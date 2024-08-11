/*
 * Copyright (c) 2024 GeyserMC. http://geysermc.org
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

package org.geysermc.geyser.session.cache.tags;

import net.kyori.adventure.key.Key;
import org.checkerframework.checker.nullness.qual.Nullable;
import org.geysermc.geyser.util.MinecraftKey;

import java.util.Map;

/**
 * Lists registries that Geyser stores tags for.
 * <p>
 * When wanting to store tags from a new registry, add the registry here.
 */
public enum TagType {
    BLOCK("block", BlockTag.REGISTRY),
    ITEM("item", ItemTag.REGISTRY),
    ENCHANTMENT("enchantment", EnchantmentTag.REGISTRY);

    private final Key registryKey;
    private final TagRegistry<?> registry;

    TagType(String registryKey, TagRegistry<?> registry) {
        this.registryKey = MinecraftKey.key(registryKey);
        this.registry = registry;
    }

    public Map<Key, ? extends Tag> vanillaTags() {
        return registry.vanillaTags();
    }

    public Tag tag(Key identifier) {
        return registry.tag(identifier);
    }

    @Nullable
    public static TagType fromKey(Key registryKey) {
        for (TagType registry : TagType.values()) {
            if (registry.registryKey.equals(registryKey)) {
                return registry;
            }
        }
        return null;
    }

    public static void init() {
        // Causes the registries listed in the enum constants to be initialized early
    }
}
