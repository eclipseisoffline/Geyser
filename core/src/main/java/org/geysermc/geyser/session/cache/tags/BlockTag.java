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
 * Lists vanilla block tags.
 */
@SuppressWarnings("unused")
public class BlockTag extends Tag {
    public static final Map<Key, BlockTag> TAGS = new Object2ObjectOpenHashMap<>();
    public static final TagRegistry<BlockTag> REGISTRY = new TagRegistry<>(TAGS, BlockTag::new);

    public static final BlockTag WOOL = register("wool");
    public static final BlockTag PLANKS = register("planks");
    public static final BlockTag STONE_BRICKS = register("stone_bricks");
    public static final BlockTag WOODEN_BUTTONS = register("wooden_buttons");
    public static final BlockTag STONE_BUTTONS = register("stone_buttons");
    public static final BlockTag BUTTONS = register("buttons");
    public static final BlockTag WOOL_CARPETS = register("wool_carpets");
    public static final BlockTag WOODEN_DOORS = register("wooden_doors");
    public static final BlockTag MOB_INTERACTABLE_DOORS = register("mob_interactable_doors");
    public static final BlockTag WOODEN_STAIRS = register("wooden_stairs");
    public static final BlockTag WOODEN_SLABS = register("wooden_slabs");
    public static final BlockTag WOODEN_FENCES = register("wooden_fences");
    public static final BlockTag PRESSURE_PLATES = register("pressure_plates");
    public static final BlockTag WOODEN_PRESSURE_PLATES = register("wooden_pressure_plates");
    public static final BlockTag STONE_PRESSURE_PLATES = register("stone_pressure_plates");
    public static final BlockTag WOODEN_TRAPDOORS = register("wooden_trapdoors");
    public static final BlockTag DOORS = register("doors");
    public static final BlockTag SAPLINGS = register("saplings");
    public static final BlockTag LOGS_THAT_BURN = register("logs_that_burn");
    public static final BlockTag OVERWORLD_NATURAL_LOGS = register("overworld_natural_logs");
    public static final BlockTag LOGS = register("logs");
    public static final BlockTag DARK_OAK_LOGS = register("dark_oak_logs");
    public static final BlockTag OAK_LOGS = register("oak_logs");
    public static final BlockTag BIRCH_LOGS = register("birch_logs");
    public static final BlockTag ACACIA_LOGS = register("acacia_logs");
    public static final BlockTag CHERRY_LOGS = register("cherry_logs");
    public static final BlockTag JUNGLE_LOGS = register("jungle_logs");
    public static final BlockTag SPRUCE_LOGS = register("spruce_logs");
    public static final BlockTag MANGROVE_LOGS = register("mangrove_logs");
    public static final BlockTag CRIMSON_STEMS = register("crimson_stems");
    public static final BlockTag WARPED_STEMS = register("warped_stems");
    public static final BlockTag BAMBOO_BLOCKS = register("bamboo_blocks");
    public static final BlockTag WART_BLOCKS = register("wart_blocks");
    public static final BlockTag BANNERS = register("banners");
    public static final BlockTag SAND = register("sand");
    public static final BlockTag SMELTS_TO_GLASS = register("smelts_to_glass");
    public static final BlockTag STAIRS = register("stairs");
    public static final BlockTag SLABS = register("slabs");
    public static final BlockTag WALLS = register("walls");
    public static final BlockTag ANVIL = register("anvil");
    public static final BlockTag RAILS = register("rails");
    public static final BlockTag LEAVES = register("leaves");
    public static final BlockTag TRAPDOORS = register("trapdoors");
    public static final BlockTag SMALL_FLOWERS = register("small_flowers");
    public static final BlockTag BEDS = register("beds");
    public static final BlockTag FENCES = register("fences");
    public static final BlockTag TALL_FLOWERS = register("tall_flowers");
    public static final BlockTag FLOWERS = register("flowers");
    public static final BlockTag PIGLIN_REPELLENTS = register("piglin_repellents");
    public static final BlockTag GOLD_ORES = register("gold_ores");
    public static final BlockTag IRON_ORES = register("iron_ores");
    public static final BlockTag DIAMOND_ORES = register("diamond_ores");
    public static final BlockTag REDSTONE_ORES = register("redstone_ores");
    public static final BlockTag LAPIS_ORES = register("lapis_ores");
    public static final BlockTag COAL_ORES = register("coal_ores");
    public static final BlockTag EMERALD_ORES = register("emerald_ores");
    public static final BlockTag COPPER_ORES = register("copper_ores");
    public static final BlockTag CANDLES = register("candles");
    public static final BlockTag DIRT = register("dirt");
    public static final BlockTag TERRACOTTA = register("terracotta");
    public static final BlockTag BADLANDS_TERRACOTTA = register("badlands_terracotta");
    public static final BlockTag CONCRETE_POWDER = register("concrete_powder");
    public static final BlockTag COMPLETES_FIND_TREE_TUTORIAL = register("completes_find_tree_tutorial");
    public static final BlockTag FLOWER_POTS = register("flower_pots");
    public static final BlockTag ENDERMAN_HOLDABLE = register("enderman_holdable");
    public static final BlockTag ICE = register("ice");
    public static final BlockTag VALID_SPAWN = register("valid_spawn");
    public static final BlockTag IMPERMEABLE = register("impermeable");
    public static final BlockTag UNDERWATER_BONEMEALS = register("underwater_bonemeals");
    public static final BlockTag CORAL_BLOCKS = register("coral_blocks");
    public static final BlockTag WALL_CORALS = register("wall_corals");
    public static final BlockTag CORAL_PLANTS = register("coral_plants");
    public static final BlockTag CORALS = register("corals");
    public static final BlockTag BAMBOO_PLANTABLE_ON = register("bamboo_plantable_on");
    public static final BlockTag STANDING_SIGNS = register("standing_signs");
    public static final BlockTag WALL_SIGNS = register("wall_signs");
    public static final BlockTag SIGNS = register("signs");
    public static final BlockTag CEILING_HANGING_SIGNS = register("ceiling_hanging_signs");
    public static final BlockTag WALL_HANGING_SIGNS = register("wall_hanging_signs");
    public static final BlockTag ALL_HANGING_SIGNS = register("all_hanging_signs");
    public static final BlockTag ALL_SIGNS = register("all_signs");
    public static final BlockTag DRAGON_IMMUNE = register("dragon_immune");
    public static final BlockTag DRAGON_TRANSPARENT = register("dragon_transparent");
    public static final BlockTag WITHER_IMMUNE = register("wither_immune");
    public static final BlockTag WITHER_SUMMON_BASE_BLOCKS = register("wither_summon_base_blocks");
    public static final BlockTag BEEHIVES = register("beehives");
    public static final BlockTag CROPS = register("crops");
    public static final BlockTag BEE_GROWABLES = register("bee_growables");
    public static final BlockTag PORTALS = register("portals");
    public static final BlockTag FIRE = register("fire");
    public static final BlockTag NYLIUM = register("nylium");
    public static final BlockTag BEACON_BASE_BLOCKS = register("beacon_base_blocks");
    public static final BlockTag SOUL_SPEED_BLOCKS = register("soul_speed_blocks");
    public static final BlockTag WALL_POST_OVERRIDE = register("wall_post_override");
    public static final BlockTag CLIMBABLE = register("climbable");
    public static final BlockTag FALL_DAMAGE_RESETTING = register("fall_damage_resetting");
    public static final BlockTag SHULKER_BOXES = register("shulker_boxes");
    public static final BlockTag HOGLIN_REPELLENTS = register("hoglin_repellents");
    public static final BlockTag SOUL_FIRE_BASE_BLOCKS = register("soul_fire_base_blocks");
    public static final BlockTag STRIDER_WARM_BLOCKS = register("strider_warm_blocks");
    public static final BlockTag CAMPFIRES = register("campfires");
    public static final BlockTag GUARDED_BY_PIGLINS = register("guarded_by_piglins");
    public static final BlockTag PREVENT_MOB_SPAWNING_INSIDE = register("prevent_mob_spawning_inside");
    public static final BlockTag FENCE_GATES = register("fence_gates");
    public static final BlockTag UNSTABLE_BOTTOM_CENTER = register("unstable_bottom_center");
    public static final BlockTag MUSHROOM_GROW_BLOCK = register("mushroom_grow_block");
    public static final BlockTag INFINIBURN_OVERWORLD = register("infiniburn_overworld");
    public static final BlockTag INFINIBURN_NETHER = register("infiniburn_nether");
    public static final BlockTag INFINIBURN_END = register("infiniburn_end");
    public static final BlockTag BASE_STONE_OVERWORLD = register("base_stone_overworld");
    public static final BlockTag STONE_ORE_REPLACEABLES = register("stone_ore_replaceables");
    public static final BlockTag DEEPSLATE_ORE_REPLACEABLES = register("deepslate_ore_replaceables");
    public static final BlockTag BASE_STONE_NETHER = register("base_stone_nether");
    public static final BlockTag OVERWORLD_CARVER_REPLACEABLES = register("overworld_carver_replaceables");
    public static final BlockTag NETHER_CARVER_REPLACEABLES = register("nether_carver_replaceables");
    public static final BlockTag CANDLE_CAKES = register("candle_cakes");
    public static final BlockTag CAULDRONS = register("cauldrons");
    public static final BlockTag CRYSTAL_SOUND_BLOCKS = register("crystal_sound_blocks");
    public static final BlockTag INSIDE_STEP_SOUND_BLOCKS = register("inside_step_sound_blocks");
    public static final BlockTag COMBINATION_STEP_SOUND_BLOCKS = register("combination_step_sound_blocks");
    public static final BlockTag CAMEL_SAND_STEP_SOUND_BLOCKS = register("camel_sand_step_sound_blocks");
    public static final BlockTag OCCLUDES_VIBRATION_SIGNALS = register("occludes_vibration_signals");
    public static final BlockTag DAMPENS_VIBRATIONS = register("dampens_vibrations");
    public static final BlockTag DRIPSTONE_REPLACEABLE_BLOCKS = register("dripstone_replaceable_blocks");
    public static final BlockTag CAVE_VINES = register("cave_vines");
    public static final BlockTag MOSS_REPLACEABLE = register("moss_replaceable");
    public static final BlockTag LUSH_GROUND_REPLACEABLE = register("lush_ground_replaceable");
    public static final BlockTag AZALEA_ROOT_REPLACEABLE = register("azalea_root_replaceable");
    public static final BlockTag SMALL_DRIPLEAF_PLACEABLE = register("small_dripleaf_placeable");
    public static final BlockTag BIG_DRIPLEAF_PLACEABLE = register("big_dripleaf_placeable");
    public static final BlockTag SNOW = register("snow");
    public static final BlockTag MINEABLE_AXE = register("mineable/axe");
    public static final BlockTag MINEABLE_HOE = register("mineable/hoe");
    public static final BlockTag MINEABLE_PICKAXE = register("mineable/pickaxe");
    public static final BlockTag MINEABLE_SHOVEL = register("mineable/shovel");
    public static final BlockTag SWORD_EFFICIENT = register("sword_efficient");
    public static final BlockTag NEEDS_DIAMOND_TOOL = register("needs_diamond_tool");
    public static final BlockTag NEEDS_IRON_TOOL = register("needs_iron_tool");
    public static final BlockTag NEEDS_STONE_TOOL = register("needs_stone_tool");
    public static final BlockTag INCORRECT_FOR_NETHERITE_TOOL = register("incorrect_for_netherite_tool");
    public static final BlockTag INCORRECT_FOR_DIAMOND_TOOL = register("incorrect_for_diamond_tool");
    public static final BlockTag INCORRECT_FOR_IRON_TOOL = register("incorrect_for_iron_tool");
    public static final BlockTag INCORRECT_FOR_STONE_TOOL = register("incorrect_for_stone_tool");
    public static final BlockTag INCORRECT_FOR_GOLD_TOOL = register("incorrect_for_gold_tool");
    public static final BlockTag INCORRECT_FOR_WOODEN_TOOL = register("incorrect_for_wooden_tool");
    public static final BlockTag FEATURES_CANNOT_REPLACE = register("features_cannot_replace");
    public static final BlockTag LAVA_POOL_STONE_CANNOT_REPLACE = register("lava_pool_stone_cannot_replace");
    public static final BlockTag GEODE_INVALID_BLOCKS = register("geode_invalid_blocks");
    public static final BlockTag FROG_PREFER_JUMP_TO = register("frog_prefer_jump_to");
    public static final BlockTag SCULK_REPLACEABLE = register("sculk_replaceable");
    public static final BlockTag SCULK_REPLACEABLE_WORLD_GEN = register("sculk_replaceable_world_gen");
    public static final BlockTag ANCIENT_CITY_REPLACEABLE = register("ancient_city_replaceable");
    public static final BlockTag VIBRATION_RESONATORS = register("vibration_resonators");
    public static final BlockTag ANIMALS_SPAWNABLE_ON = register("animals_spawnable_on");
    public static final BlockTag ARMADILLO_SPAWNABLE_ON = register("armadillo_spawnable_on");
    public static final BlockTag AXOLOTLS_SPAWNABLE_ON = register("axolotls_spawnable_on");
    public static final BlockTag GOATS_SPAWNABLE_ON = register("goats_spawnable_on");
    public static final BlockTag MOOSHROOMS_SPAWNABLE_ON = register("mooshrooms_spawnable_on");
    public static final BlockTag PARROTS_SPAWNABLE_ON = register("parrots_spawnable_on");
    public static final BlockTag POLAR_BEARS_SPAWNABLE_ON_ALTERNATE = register("polar_bears_spawnable_on_alternate");
    public static final BlockTag RABBITS_SPAWNABLE_ON = register("rabbits_spawnable_on");
    public static final BlockTag FOXES_SPAWNABLE_ON = register("foxes_spawnable_on");
    public static final BlockTag WOLVES_SPAWNABLE_ON = register("wolves_spawnable_on");
    public static final BlockTag FROGS_SPAWNABLE_ON = register("frogs_spawnable_on");
    public static final BlockTag AZALEA_GROWS_ON = register("azalea_grows_on");
    public static final BlockTag CONVERTABLE_TO_MUD = register("convertable_to_mud");
    public static final BlockTag MANGROVE_LOGS_CAN_GROW_THROUGH = register("mangrove_logs_can_grow_through");
    public static final BlockTag MANGROVE_ROOTS_CAN_GROW_THROUGH = register("mangrove_roots_can_grow_through");
    public static final BlockTag DEAD_BUSH_MAY_PLACE_ON = register("dead_bush_may_place_on");
    public static final BlockTag SNAPS_GOAT_HORN = register("snaps_goat_horn");
    public static final BlockTag REPLACEABLE_BY_TREES = register("replaceable_by_trees");
    public static final BlockTag SNOW_LAYER_CANNOT_SURVIVE_ON = register("snow_layer_cannot_survive_on");
    public static final BlockTag SNOW_LAYER_CAN_SURVIVE_ON = register("snow_layer_can_survive_on");
    public static final BlockTag INVALID_SPAWN_INSIDE = register("invalid_spawn_inside");
    public static final BlockTag SNIFFER_DIGGABLE_BLOCK = register("sniffer_diggable_block");
    public static final BlockTag SNIFFER_EGG_HATCH_BOOST = register("sniffer_egg_hatch_boost");
    public static final BlockTag TRAIL_RUINS_REPLACEABLE = register("trail_ruins_replaceable");
    public static final BlockTag REPLACEABLE = register("replaceable");
    public static final BlockTag ENCHANTMENT_POWER_PROVIDER = register("enchantment_power_provider");
    public static final BlockTag ENCHANTMENT_POWER_TRANSMITTER = register("enchantment_power_transmitter");
    public static final BlockTag MAINTAINS_FARMLAND = register("maintains_farmland");
    public static final BlockTag BLOCKS_WIND_CHARGE_EXPLOSIONS = register("blocks_wind_charge_explosions");
    public static final BlockTag DOES_NOT_BLOCK_HOPPERS = register("does_not_block_hoppers");
    public static final BlockTag AIR = register("air");

    private BlockTag(Key key) {
        super(key);
    }

    @Override
    public TagType registry() {
        return TagType.BLOCK;
    }

    private static BlockTag register(String name) {
        Key key = MinecraftKey.key(name);
        BlockTag tag = new BlockTag.Vanilla(key);
        TAGS.put(key, tag);
        return tag;
    }

    private static class Vanilla extends BlockTag implements Ordered {
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
