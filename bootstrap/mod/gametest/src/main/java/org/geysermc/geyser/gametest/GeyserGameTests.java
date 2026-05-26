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

package org.geysermc.geyser.gametest;

import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.gametest.framework.GameTestInstance;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import org.geysermc.geyser.gametest.tests.EntityDataSerializerTest;
import org.geysermc.geyser.gametest.tests.EntityMetadataTest;
import org.geysermc.geyser.gametest.util.SynchedEntityDataDebugger;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public final  class GeyserGameTests {
    private static final List<EntityType<?>> UNSUPPORTED_ENTITY_TYPES = List.of(EntityType.BLOCK_DISPLAY, EntityType.ITEM_DISPLAY, EntityType.MARKER);

    private GeyserGameTests() {}

    private static ResourceKey<GameTestInstance> createKey(String name) {
        return ResourceKey.create(Registries.TEST_INSTANCE, Identifier.fromNamespaceAndPath("geyser", name));
    }

    private static ResourceKey<GameTestInstance> createKey(Identifier testType, String name) {
        return createKey(testType.getPath() + "/" + name);
    }

    private static ResourceKey<GameTestInstance> createSingletonKey(Identifier testType) {
        return createKey(testType.getPath());
    }

    private static void registerSingletonTest(HolderLookup.Provider registries, FabricDynamicRegistryProvider.Entries entries, GeyserGameTestTypes.SingletonTestType type, boolean required) {
        entries.add(createSingletonKey(type.type()), type.constructor().create(registries, required));
    }

    private static void registerSingletonTest(HolderLookup.Provider registries, FabricDynamicRegistryProvider.Entries entries, GeyserGameTestTypes.SingletonTestType type) {
        registerSingletonTest(registries, entries, type, true);
    }

    private static void registerEntityTypeTests(HolderLookup.Provider registries, FabricDynamicRegistryProvider.Entries entries) {
        for (EntityType<?> entityType : BuiltInRegistries.ENTITY_TYPE) {
            entries.add(createKey(GeyserGameTestTypes.ENTITY_METADATA, BuiltInRegistries.ENTITY_TYPE.getKey(entityType).getPath()),
                new EntityMetadataTest(registries, !UNSUPPORTED_ENTITY_TYPES.contains(entityType), entityType));
        }
    }

    @SafeVarargs
    private static <T> void registerEntityDataSerializerTest(HolderLookup.Provider registries, FabricDynamicRegistryProvider.Entries entries, EntityDataSerializer<T> serializer, T... cases) {
        entries.add(createKey(GeyserGameTestTypes.ENTITY_DATA_SERIALIZER, SynchedEntityDataDebugger.findNameOfSerializer(serializer).toLowerCase(Locale.ROOT)),
            new EntityDataSerializerTest<>(registries, true, serializer, Arrays.asList(cases)));
    }

    private static void registerEntityDataSerializerTests(HolderLookup.Provider registries, FabricDynamicRegistryProvider.Entries entries) {
        registerEntityDataSerializerTest(registries, entries, EntityDataSerializers.BYTE, (byte) 0, (byte) 1, (byte) 2, (byte) -10, (byte) 100, (byte) 15, Byte.MIN_VALUE, Byte.MAX_VALUE);
        registerEntityDataSerializerTest(registries, entries, EntityDataSerializers.INT, 15, -12, 5, 43, 10000, -1000000, Integer.MAX_VALUE, Integer.MIN_VALUE);
        registerEntityDataSerializerTest(registries, entries, EntityDataSerializers.LONG, 46L, -67L, 200L, 35983959954L, -1238398482348L, Long.MAX_VALUE, Long.MIN_VALUE);
    }

    public static void bootstrap(HolderLookup.Provider registries, FabricDynamicRegistryProvider.Entries entries) {
        registerEntityTypeTests(registries, entries);
        registerSingletonTest(registries, entries, GeyserGameTestTypes.REQUIRED_COMPONENTS_FOR_HASHING);
        registerSingletonTest(registries, entries, GeyserGameTestTypes.MINECRAFT_VERSION);
        registerEntityDataSerializerTests(registries, entries);
    }
}
