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

package org.geysermc.geyser.gametest.tests;

import com.mojang.serialization.Codec;
import com.mojang.serialization.DataResult;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import net.minecraft.core.HolderLookup;
import net.minecraft.gametest.framework.GameTestHelper;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.resources.RegistryOps;
import net.minecraft.util.ExtraCodecs;
import org.geysermc.geyser.gametest.util.StreamCodecCodec;
import org.geysermc.mcprotocollib.protocol.data.game.entity.metadata.MetadataType;
import org.geysermc.mcprotocollib.protocol.data.game.entity.metadata.MetadataTypes;

import java.util.Arrays;
import java.util.List;

public class EntityDataSerializerTest<T> extends GeyserTestInstance {
    private static final Codec<EntityDataSerializer<?>> ENTITY_DATA_SERIALIZER_CODEC = ExtraCodecs.NON_NEGATIVE_INT.flatXmap(
        id -> {
            EntityDataSerializer<?> serializer = EntityDataSerializers.getSerializer(id);
            if (serializer == null) {
                return DataResult.error(() -> "no serializer exists with ID " + id);
            }
            return DataResult.success(serializer);
        }, serializer -> {
            int id = EntityDataSerializers.getSerializedId(serializer);
            if (id == -1) {
                return DataResult.error(() -> "no ID exists for serializer " + serializer);
            }
            return DataResult.success(id);
        });
    public static final MapCodec<EntityDataSerializerTest<?>> MAP_CODEC = RecordCodecBuilder.mapCodec(instance ->
        commonFields(instance)
            .and(SerializerWithData.MAP_CODEC.forGetter(test -> test.serializerWithData))
            .apply(instance, EntityDataSerializerTest::new)
    );

    private final SerializerWithData<T> serializerWithData;

    private EntityDataSerializerTest(RegistryOps<?> ops, boolean required, SerializerWithData<T> serializerWithData) {
        super(ops, required);
        this.serializerWithData = serializerWithData;
    }

    public EntityDataSerializerTest(HolderLookup.Provider registries, boolean required, EntityDataSerializer<T> serializer, List<T> cases) {
        super(registries, required);
        this.serializerWithData = new SerializerWithData<>(serializer, cases);
    }

    @Override
    public void run(GameTestHelper helper) {
        EntityDataSerializer<T> serializer = serializerWithData.serializer;
        for (T testCase : serializerWithData.cases) {
            RegistryFriendlyByteBuf registryBuf = new RegistryFriendlyByteBuf(Unpooled.buffer(), helper.getLevel().registryAccess());
            serializer.codec().encode(registryBuf, testCase);
            byte[] mojangEncoded = new byte[registryBuf.readableBytes()];
            registryBuf.readBytes(mojangEncoded);
            registryBuf.release();

            MetadataType<?> mcplType = MetadataTypes.from(EntityDataSerializers.getSerializedId(serializer));
            byte[] mcplEncoded = loopbackMetadataMCPLEncoded(mcplType, mojangEncoded);
            helper.assertTrue(Arrays.equals(mcplEncoded, mojangEncoded), "Mojang and MCPL must encode the test case the same");
        }

        helper.succeed();
    }

    @Override
    public MapCodec<EntityDataSerializerTest<?>> codec() {
        return MAP_CODEC;
    }

    @Override
    protected MutableComponent typeDescription() {
        return Component.literal("Geyser Entity Data Serializer Test for " + serializerWithData.serializer);
    }

    private static <T> byte[] loopbackMetadataMCPLEncoded(MetadataType<T> mcplType, byte[] encoded) {
        T mcplValue = mcplType.getReader().read(Unpooled.wrappedBuffer(encoded));
        ByteBuf writeBuf = Unpooled.buffer();
        mcplType.getWriter().write(writeBuf, mcplValue);
        byte[] mcplEncoded = new byte[writeBuf.readableBytes()];
        writeBuf.readBytes(mcplEncoded);
        writeBuf.release();
        return mcplEncoded;
    }

    private record SerializerWithData<T>(EntityDataSerializer<T> serializer, List<T> cases) {
        private static final MapCodec<SerializerWithData<?>> MAP_CODEC = ENTITY_DATA_SERIALIZER_CODEC.dispatchMap("serializer",
            SerializerWithData::serializer, SerializerWithData::createCodec);

        private static <T> MapCodec<SerializerWithData<T>> createCodec(EntityDataSerializer<T> serializer) {
            return ExtraCodecs.compactListCodec(StreamCodecCodec.ofRegistry(serializer.codec())).fieldOf("cases")
                .xmap(cases -> new SerializerWithData<>(serializer, cases), SerializerWithData::cases);
        }
    }
}
