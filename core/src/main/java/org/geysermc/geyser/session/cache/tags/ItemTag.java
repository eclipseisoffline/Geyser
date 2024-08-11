/*
 * Copyright (c) 2019-2024 GeyserMC. http://geysermc.org
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

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import net.kyori.adventure.key.Key;
import org.geysermc.geyser.util.MinecraftKey;
import org.geysermc.geyser.util.Ordered;

import java.util.Map;

/**
 * Lists vanilla item tags.
 */
@SuppressWarnings("unused")
public class ItemTag extends Tag {
    public static final Map<Key, ItemTag> TAGS = new Object2ObjectOpenHashMap<>();
    public static final TagRegistry<ItemTag> REGISTRY = new TagRegistry<>(TAGS, ItemTag::new);

    public static final ItemTag WOOL = register("wool");
    public static final ItemTag PLANKS = register("planks");
    public static final ItemTag STONE_BRICKS = register("stone_bricks");
    public static final ItemTag WOODEN_BUTTONS = register("wooden_buttons");
    public static final ItemTag STONE_BUTTONS = register("stone_buttons");
    public static final ItemTag BUTTONS = register("buttons");
    public static final ItemTag WOOL_CARPETS = register("wool_carpets");
    public static final ItemTag WOODEN_DOORS = register("wooden_doors");
    public static final ItemTag WOODEN_STAIRS = register("wooden_stairs");
    public static final ItemTag WOODEN_SLABS = register("wooden_slabs");
    public static final ItemTag WOODEN_FENCES = register("wooden_fences");
    public static final ItemTag FENCE_GATES = register("fence_gates");
    public static final ItemTag WOODEN_PRESSURE_PLATES = register("wooden_pressure_plates");
    public static final ItemTag WOODEN_TRAPDOORS = register("wooden_trapdoors");
    public static final ItemTag DOORS = register("doors");
    public static final ItemTag SAPLINGS = register("saplings");
    public static final ItemTag LOGS_THAT_BURN = register("logs_that_burn");
    public static final ItemTag LOGS = register("logs");
    public static final ItemTag DARK_OAK_LOGS = register("dark_oak_logs");
    public static final ItemTag OAK_LOGS = register("oak_logs");
    public static final ItemTag BIRCH_LOGS = register("birch_logs");
    public static final ItemTag ACACIA_LOGS = register("acacia_logs");
    public static final ItemTag CHERRY_LOGS = register("cherry_logs");
    public static final ItemTag JUNGLE_LOGS = register("jungle_logs");
    public static final ItemTag SPRUCE_LOGS = register("spruce_logs");
    public static final ItemTag MANGROVE_LOGS = register("mangrove_logs");
    public static final ItemTag CRIMSON_STEMS = register("crimson_stems");
    public static final ItemTag WARPED_STEMS = register("warped_stems");
    public static final ItemTag BAMBOO_BLOCKS = register("bamboo_blocks");
    public static final ItemTag WART_BLOCKS = register("wart_blocks");
    public static final ItemTag BANNERS = register("banners");
    public static final ItemTag SAND = register("sand");
    public static final ItemTag SMELTS_TO_GLASS = register("smelts_to_glass");
    public static final ItemTag STAIRS = register("stairs");
    public static final ItemTag SLABS = register("slabs");
    public static final ItemTag WALLS = register("walls");
    public static final ItemTag ANVIL = register("anvil");
    public static final ItemTag RAILS = register("rails");
    public static final ItemTag LEAVES = register("leaves");
    public static final ItemTag TRAPDOORS = register("trapdoors");
    public static final ItemTag SMALL_FLOWERS = register("small_flowers");
    public static final ItemTag BEDS = register("beds");
    public static final ItemTag FENCES = register("fences");
    public static final ItemTag TALL_FLOWERS = register("tall_flowers");
    public static final ItemTag FLOWERS = register("flowers");
    public static final ItemTag PIGLIN_REPELLENTS = register("piglin_repellents");
    public static final ItemTag PIGLIN_LOVED = register("piglin_loved");
    public static final ItemTag IGNORED_BY_PIGLIN_BABIES = register("ignored_by_piglin_babies");
    public static final ItemTag MEAT = register("meat");
    public static final ItemTag SNIFFER_FOOD = register("sniffer_food");
    public static final ItemTag PIGLIN_FOOD = register("piglin_food");
    public static final ItemTag FOX_FOOD = register("fox_food");
    public static final ItemTag COW_FOOD = register("cow_food");
    public static final ItemTag GOAT_FOOD = register("goat_food");
    public static final ItemTag SHEEP_FOOD = register("sheep_food");
    public static final ItemTag WOLF_FOOD = register("wolf_food");
    public static final ItemTag CAT_FOOD = register("cat_food");
    public static final ItemTag HORSE_FOOD = register("horse_food");
    public static final ItemTag HORSE_TEMPT_ITEMS = register("horse_tempt_items");
    public static final ItemTag CAMEL_FOOD = register("camel_food");
    public static final ItemTag ARMADILLO_FOOD = register("armadillo_food");
    public static final ItemTag BEE_FOOD = register("bee_food");
    public static final ItemTag CHICKEN_FOOD = register("chicken_food");
    public static final ItemTag FROG_FOOD = register("frog_food");
    public static final ItemTag HOGLIN_FOOD = register("hoglin_food");
    public static final ItemTag LLAMA_FOOD = register("llama_food");
    public static final ItemTag LLAMA_TEMPT_ITEMS = register("llama_tempt_items");
    public static final ItemTag OCELOT_FOOD = register("ocelot_food");
    public static final ItemTag PANDA_FOOD = register("panda_food");
    public static final ItemTag PIG_FOOD = register("pig_food");
    public static final ItemTag RABBIT_FOOD = register("rabbit_food");
    public static final ItemTag STRIDER_FOOD = register("strider_food");
    public static final ItemTag STRIDER_TEMPT_ITEMS = register("strider_tempt_items");
    public static final ItemTag TURTLE_FOOD = register("turtle_food");
    public static final ItemTag PARROT_FOOD = register("parrot_food");
    public static final ItemTag PARROT_POISONOUS_FOOD = register("parrot_poisonous_food");
    public static final ItemTag AXOLOTL_FOOD = register("axolotl_food");
    public static final ItemTag GOLD_ORES = register("gold_ores");
    public static final ItemTag IRON_ORES = register("iron_ores");
    public static final ItemTag DIAMOND_ORES = register("diamond_ores");
    public static final ItemTag REDSTONE_ORES = register("redstone_ores");
    public static final ItemTag LAPIS_ORES = register("lapis_ores");
    public static final ItemTag COAL_ORES = register("coal_ores");
    public static final ItemTag EMERALD_ORES = register("emerald_ores");
    public static final ItemTag COPPER_ORES = register("copper_ores");
    public static final ItemTag NON_FLAMMABLE_WOOD = register("non_flammable_wood");
    public static final ItemTag SOUL_FIRE_BASE_BLOCKS = register("soul_fire_base_blocks");
    public static final ItemTag CANDLES = register("candles");
    public static final ItemTag DIRT = register("dirt");
    public static final ItemTag TERRACOTTA = register("terracotta");
    public static final ItemTag COMPLETES_FIND_TREE_TUTORIAL = register("completes_find_tree_tutorial");
    public static final ItemTag BOATS = register("boats");
    public static final ItemTag CHEST_BOATS = register("chest_boats");
    public static final ItemTag FISHES = register("fishes");
    public static final ItemTag SIGNS = register("signs");
    public static final ItemTag CREEPER_DROP_MUSIC_DISCS = register("creeper_drop_music_discs");
    public static final ItemTag COALS = register("coals");
    public static final ItemTag ARROWS = register("arrows");
    public static final ItemTag LECTERN_BOOKS = register("lectern_books");
    public static final ItemTag BOOKSHELF_BOOKS = register("bookshelf_books");
    public static final ItemTag BEACON_PAYMENT_ITEMS = register("beacon_payment_items");
    public static final ItemTag STONE_TOOL_MATERIALS = register("stone_tool_materials");
    public static final ItemTag STONE_CRAFTING_MATERIALS = register("stone_crafting_materials");
    public static final ItemTag FREEZE_IMMUNE_WEARABLES = register("freeze_immune_wearables");
    public static final ItemTag DAMPENS_VIBRATIONS = register("dampens_vibrations");
    public static final ItemTag CLUSTER_MAX_HARVESTABLES = register("cluster_max_harvestables");
    public static final ItemTag COMPASSES = register("compasses");
    public static final ItemTag HANGING_SIGNS = register("hanging_signs");
    public static final ItemTag CREEPER_IGNITERS = register("creeper_igniters");
    public static final ItemTag NOTEBLOCK_TOP_INSTRUMENTS = register("noteblock_top_instruments");
    public static final ItemTag FOOT_ARMOR = register("foot_armor");
    public static final ItemTag LEG_ARMOR = register("leg_armor");
    public static final ItemTag CHEST_ARMOR = register("chest_armor");
    public static final ItemTag HEAD_ARMOR = register("head_armor");
    public static final ItemTag SKULLS = register("skulls");
    public static final ItemTag TRIMMABLE_ARMOR = register("trimmable_armor");
    public static final ItemTag TRIM_MATERIALS = register("trim_materials");
    public static final ItemTag TRIM_TEMPLATES = register("trim_templates");
    public static final ItemTag DECORATED_POT_SHERDS = register("decorated_pot_sherds");
    public static final ItemTag DECORATED_POT_INGREDIENTS = register("decorated_pot_ingredients");
    public static final ItemTag SWORDS = register("swords");
    public static final ItemTag AXES = register("axes");
    public static final ItemTag HOES = register("hoes");
    public static final ItemTag PICKAXES = register("pickaxes");
    public static final ItemTag SHOVELS = register("shovels");
    public static final ItemTag BREAKS_DECORATED_POTS = register("breaks_decorated_pots");
    public static final ItemTag VILLAGER_PLANTABLE_SEEDS = register("villager_plantable_seeds");
    public static final ItemTag DYEABLE = register("dyeable");
    public static final ItemTag ENCHANTABLE_FOOT_ARMOR = register("enchantable/foot_armor");
    public static final ItemTag ENCHANTABLE_LEG_ARMOR = register("enchantable/leg_armor");
    public static final ItemTag ENCHANTABLE_CHEST_ARMOR = register("enchantable/chest_armor");
    public static final ItemTag ENCHANTABLE_HEAD_ARMOR = register("enchantable/head_armor");
    public static final ItemTag ENCHANTABLE_ARMOR = register("enchantable/armor");
    public static final ItemTag ENCHANTABLE_SWORD = register("enchantable/sword");
    public static final ItemTag ENCHANTABLE_FIRE_ASPECT = register("enchantable/fire_aspect");
    public static final ItemTag ENCHANTABLE_SHARP_WEAPON = register("enchantable/sharp_weapon");
    public static final ItemTag ENCHANTABLE_WEAPON = register("enchantable/weapon");
    public static final ItemTag ENCHANTABLE_MINING = register("enchantable/mining");
    public static final ItemTag ENCHANTABLE_MINING_LOOT = register("enchantable/mining_loot");
    public static final ItemTag ENCHANTABLE_FISHING = register("enchantable/fishing");
    public static final ItemTag ENCHANTABLE_TRIDENT = register("enchantable/trident");
    public static final ItemTag ENCHANTABLE_DURABILITY = register("enchantable/durability");
    public static final ItemTag ENCHANTABLE_BOW = register("enchantable/bow");
    public static final ItemTag ENCHANTABLE_EQUIPPABLE = register("enchantable/equippable");
    public static final ItemTag ENCHANTABLE_CROSSBOW = register("enchantable/crossbow");
    public static final ItemTag ENCHANTABLE_VANISHING = register("enchantable/vanishing");
    public static final ItemTag ENCHANTABLE_MACE = register("enchantable/mace");

    private ItemTag(Key key) {
        super(key);
    }

    @Override
    public TagType registry() {
        return TagType.BLOCK;
    }

    private static ItemTag register(String name) {
        Key key = MinecraftKey.key(name);
        ItemTag tag = new ItemTag.Vanilla(key);
        TAGS.put(key, tag);
        return tag;
    }

    private static class Vanilla extends ItemTag implements Ordered {
        final int id;

        Vanilla(Key key) {
            super(key);
            this.id = TAGS.size();
        }

        @Override
        public int ordinal() {
            return id;
        }
    }
}
