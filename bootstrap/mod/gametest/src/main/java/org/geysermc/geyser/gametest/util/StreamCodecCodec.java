/*
 * Copyright (c) 2026 GeyserMC. http://geysermc.org
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 *
 * @author GeyserMC
 * @link https://github.com/GeyserMC/Geyser
 */

package org.geysermc.geyser.gametest.util;

import com.mojang.datafixers.util.Pair;
import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.DynamicOps;
import com.mojang.serialization.codecs.PrimitiveCodec;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.netty.handler.codec.CodecException;
import net.fabricmc.fabric.mixin.resource.conditions.RegistryOpsAccessor;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.resources.RegistryOps;
import net.minecraft.resources.ResourceKey;

import java.util.Base64;
import java.util.Optional;
import java.util.stream.Stream;

public final class StreamCodecCodec<B extends ByteBuf, A> implements PrimitiveCodec<A> {
    private final StreamCodec<? super B, A> streamCodec;
    private final DynamicOpsByteBufFunction<B> byteBufCreator;

    public StreamCodecCodec(StreamCodec<? super B, A> streamCodec, DynamicOpsByteBufFunction<B> byteBufCreator) {
        this.streamCodec = streamCodec;
        this.byteBufCreator = byteBufCreator;
    }

    public static <A> Codec<A> of(StreamCodec<? super FriendlyByteBuf, A> streamCodec) {
        return new StreamCodecCodec<>(streamCodec, _ -> DataResult.success(new FriendlyByteBuf(Unpooled.buffer())));
    }

    public static <A> Codec<A> ofRegistry(StreamCodec<? super RegistryFriendlyByteBuf, A> streamCodec) {
        return new StreamCodecCodec<>(streamCodec, ops -> {
            if (ops instanceof RegistryOps<?> registryOps) {
                return DataResult.success(new RegistryFriendlyByteBuf(Unpooled.buffer(), createRegistryAccess(((RegistryOpsAccessor) registryOps).getRegistryInfoGetter())));
            }
            return DataResult.error(() -> "ops must be a RegistryOps");
        });
    }

    @Override
    public <T> DataResult<A> read(DynamicOps<T> ops, T input) {
        return ops.getStringValue(input).apply2(Pair::of, byteBufCreator.create(ops))
            .flatMap(pair -> {
                pair.getSecond().writeBytes(Base64.getDecoder().decode(pair.getFirst()));
                try {
                    return DataResult.success(streamCodec.decode(pair.getSecond()));
                } catch (CodecException exception) {
                    return DataResult.error(() -> "failed to parse bytes: " + exception.getMessage());
                } finally {
                    pair.getSecond().release();
                }
            });
    }

    @Override
    public <T> T write(DynamicOps<T> ops, A value) {
        // Can't return a DataResult here
        throw new UnsupportedOperationException();

    }

    @Override
    public <T> DataResult<T> encode(A input, DynamicOps<T> ops, T prefix) {
            return byteBufCreator.create(ops)
                .flatMap(buf -> {
                    try {
                        streamCodec.encode(buf, input);
                        byte[] bytes = new byte[buf.readableBytes()];
                        buf.readBytes(bytes);
                        return ops.mergeToPrimitive(prefix, ops.createString(Base64.getEncoder().encodeToString(bytes)));
                    } catch (CodecException exception) {
                        return DataResult.error(() -> "failed to encode input to bytes: " + exception.getMessage());
                    } finally {
                        buf.release();
                    }
                });
    }

    @FunctionalInterface
    public interface DynamicOpsByteBufFunction<B extends ByteBuf> {

        DataResult<B> create(DynamicOps<?> ops);
    }

    private static RegistryAccess createRegistryAccess(RegistryOps.RegistryInfoLookup registryInfoLookup) {
        return new RegistryAccess() {
            @Override
            public <E> Optional<Registry<E>> lookup(ResourceKey<? extends Registry<? extends E>> registryKey) {
                return registryInfoLookup.lookup(registryKey)
                    .map(RegistryOps.RegistryInfo::getter)
                    .map(getter -> (Registry<E>) getter);
            }

            @Override
            public Stream<RegistryEntry<?>> registries() {
                return Stream.empty();
            }
        };
    }
}
