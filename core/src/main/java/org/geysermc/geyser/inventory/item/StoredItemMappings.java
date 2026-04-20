/*
 * Copyright (c) 2019-2022 GeyserMC. http://geysermc.org
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

package org.geysermc.geyser.inventory.item;

import lombok.Getter;
import lombok.experimental.Accessors;
import net.kyori.adventure.key.Key;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.geysermc.geyser.item.ItemIds;
import org.geysermc.geyser.registry.type.ItemMapping;

import java.util.Map;

/**
 * A class to have easy access to specific item mappings per-version.
 */
@Getter
@Accessors(fluent = true)
public class StoredItemMappings {
    private final ItemMapping barrier;
    private final ItemMapping compass;
    private final ItemMapping glassBottle;
    private final ItemMapping milkBucket;
    private final ItemMapping powderSnowBucket;
    private final ItemMapping totem;
    private final ItemMapping upgradeTemplate;
    private final ItemMapping wheat;
    private final ItemMapping writableBook;
    private final ItemMapping writtenBook;

    public StoredItemMappings(Map<Key, ItemMapping> itemMappings) {
        this.barrier = load(itemMappings, ItemIds.BARRIER);
        this.compass = load(itemMappings, ItemIds.COMPASS);
        this.glassBottle = load(itemMappings, ItemIds.GLASS_BOTTLE);
        this.milkBucket = load(itemMappings, ItemIds.MILK_BUCKET);
        this.powderSnowBucket = load(itemMappings, ItemIds.POWDER_SNOW_BUCKET);
        this.totem = load(itemMappings, ItemIds.TOTEM_OF_UNDYING);
        this.upgradeTemplate = load(itemMappings, ItemIds.NETHERITE_UPGRADE_SMITHING_TEMPLATE);
        this.wheat = load(itemMappings, ItemIds.WHEAT);
        this.writableBook = load(itemMappings, ItemIds.WRITABLE_BOOK);
        this.writtenBook = load(itemMappings, ItemIds.WRITTEN_BOOK);
    }

    @NonNull
    private ItemMapping load(Map<Key, ItemMapping> itemMappings, Key item) {
        ItemMapping mapping = itemMappings.get(item);
        if (mapping == null) {
            throw new RuntimeException("Could not find item " + item);
        }

        return mapping;
    }
}
