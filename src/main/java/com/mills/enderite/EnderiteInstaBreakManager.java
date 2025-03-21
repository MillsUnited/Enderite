package com.mills.enderite;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockDamageEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class EnderiteInstaBreakManager implements Listener {

    private EnderiteItems enderiteItems;

    public EnderiteInstaBreakManager(EnderiteItems enderiteItems) {
        this.enderiteItems = enderiteItems;
    }

    @EventHandler
    public void onBlockDamage(BlockDamageEvent e) {
        Player player = e.getPlayer();
        ItemStack tool = player.getInventory().getItemInMainHand();

        Block block = e.getBlock();
        Material blockType = block.getType();

        if (isEnderitePickaxe(tool) && isBlock(blockType)) {
            e.setInstaBreak(true);
        }

        if (isEnderiteAxe(tool) && isWood(blockType)) {
            e.setInstaBreak(true);
        }

        if (isEnderiteShovel(tool) && isShovelBlock(blockType)) {
            e.setInstaBreak(true);
        }

    }

    private boolean isEnderitePickaxe(ItemStack item) {
        return isSameItem(item, enderiteItems.enderitePickaxe());
    }

    private boolean isEnderiteAxe(ItemStack item) {
        return isSameItem(item, enderiteItems.enderiteAxe());
    }

    private boolean isEnderiteShovel(ItemStack item) {
        return isSameItem(item, enderiteItems.enderiteShovel());
    }

    private boolean isSameItem(ItemStack item, ItemStack reference) {
        if (item == null || reference == null) return false;
        if (item.getType() != reference.getType()) return false;

        ItemMeta meta = item.getItemMeta();
        ItemMeta refMeta = reference.getItemMeta();
        if (meta == null || refMeta == null) return false;

        return meta.hasDisplayName() && refMeta.hasDisplayName() && meta.getDisplayName().equals(refMeta.getDisplayName());
    }

    private boolean isWood(Material material) {
        return switch (material) {
            // Logs
            case OAK_LOG, BIRCH_LOG, SPRUCE_LOG, DARK_OAK_LOG, JUNGLE_LOG,
                 ACACIA_LOG, MANGROVE_LOG, CHERRY_LOG, CRIMSON_STEM, WARPED_STEM,
                 // Stripped Logs
                 STRIPPED_OAK_LOG, STRIPPED_BIRCH_LOG, STRIPPED_SPRUCE_LOG, STRIPPED_DARK_OAK_LOG,
                 STRIPPED_JUNGLE_LOG, STRIPPED_ACACIA_LOG, STRIPPED_MANGROVE_LOG,
                 STRIPPED_CHERRY_LOG, STRIPPED_CRIMSON_STEM, STRIPPED_WARPED_STEM,
                 // Wood Blocks
                 OAK_WOOD, BIRCH_WOOD, SPRUCE_WOOD, DARK_OAK_WOOD, JUNGLE_WOOD,
                 ACACIA_WOOD, MANGROVE_WOOD, CHERRY_WOOD, CRIMSON_HYPHAE, WARPED_HYPHAE,
                 // Stripped Wood Blocks
                 STRIPPED_OAK_WOOD, STRIPPED_BIRCH_WOOD, STRIPPED_SPRUCE_WOOD, STRIPPED_DARK_OAK_WOOD,
                 STRIPPED_JUNGLE_WOOD, STRIPPED_ACACIA_WOOD, STRIPPED_MANGROVE_WOOD,
                 STRIPPED_CHERRY_WOOD, STRIPPED_CRIMSON_HYPHAE, STRIPPED_WARPED_HYPHAE,
                 // Planks
                 OAK_PLANKS, BIRCH_PLANKS, SPRUCE_PLANKS, DARK_OAK_PLANKS, JUNGLE_PLANKS,
                 ACACIA_PLANKS, MANGROVE_PLANKS, CHERRY_PLANKS, CRIMSON_PLANKS, WARPED_PLANKS,
                 // Stairs
                 OAK_STAIRS, BIRCH_STAIRS, SPRUCE_STAIRS, DARK_OAK_STAIRS, JUNGLE_STAIRS,
                 ACACIA_STAIRS, MANGROVE_STAIRS, CHERRY_STAIRS, CRIMSON_STAIRS, WARPED_STAIRS,
                 // Slabs
                 OAK_SLAB, BIRCH_SLAB, SPRUCE_SLAB, DARK_OAK_SLAB, JUNGLE_SLAB,
                 ACACIA_SLAB, MANGROVE_SLAB, CHERRY_SLAB, CRIMSON_SLAB, WARPED_SLAB,
                 // Fences
                 OAK_FENCE, BIRCH_FENCE, SPRUCE_FENCE, DARK_OAK_FENCE, JUNGLE_FENCE,
                 ACACIA_FENCE, MANGROVE_FENCE, CHERRY_FENCE, CRIMSON_FENCE, WARPED_FENCE,
                 // Fence Gates
                 OAK_FENCE_GATE, BIRCH_FENCE_GATE, SPRUCE_FENCE_GATE, DARK_OAK_FENCE_GATE, JUNGLE_FENCE_GATE,
                 ACACIA_FENCE_GATE, MANGROVE_FENCE_GATE, CHERRY_FENCE_GATE, CRIMSON_FENCE_GATE, WARPED_FENCE_GATE,
                 // Doors
                 OAK_DOOR, BIRCH_DOOR, SPRUCE_DOOR, DARK_OAK_DOOR, JUNGLE_DOOR,
                 ACACIA_DOOR, MANGROVE_DOOR, CHERRY_DOOR, CRIMSON_DOOR, WARPED_DOOR,
                 // Buttons
                 OAK_BUTTON, BIRCH_BUTTON, SPRUCE_BUTTON, DARK_OAK_BUTTON, JUNGLE_BUTTON,
                 ACACIA_BUTTON, MANGROVE_BUTTON, CHERRY_BUTTON, CRIMSON_BUTTON, WARPED_BUTTON,
                 // Pressure Plates
                 OAK_PRESSURE_PLATE, BIRCH_PRESSURE_PLATE, SPRUCE_PRESSURE_PLATE, DARK_OAK_PRESSURE_PLATE, JUNGLE_PRESSURE_PLATE,
                 ACACIA_PRESSURE_PLATE, MANGROVE_PRESSURE_PLATE, CHERRY_PRESSURE_PLATE, CRIMSON_PRESSURE_PLATE, WARPED_PRESSURE_PLATE
                    -> true;
            default -> false;
        };
    }

    private boolean isShovelBlock(Material material) {
        return switch (material) {
            case SAND, GRAVEL, CLAY
                -> true;
            default -> false;
        };
    }

    private boolean isBlock(Material material) {
        return switch (material) {
            case
                    // Base Deepslate Blocks
                    DEEPSLATE, COBBLED_DEEPSLATE, DEEPSLATE_BRICKS, CRACKED_DEEPSLATE_BRICKS, CHISELED_DEEPSLATE,
                    DEEPSLATE_TILES, CRACKED_DEEPSLATE_TILES, POLISHED_DEEPSLATE, POLISHED_DEEPSLATE_STAIRS,
                    POLISHED_DEEPSLATE_SLAB, POLISHED_DEEPSLATE_WALL, COBBLED_DEEPSLATE_STAIRS, COBBLED_DEEPSLATE_SLAB, COBBLED_DEEPSLATE_WALL,
                    DEEPSLATE_BRICK_STAIRS, DEEPSLATE_BRICK_SLAB, DEEPSLATE_BRICK_WALL, DEEPSLATE_TILE_STAIRS, DEEPSLATE_TILE_SLAB, DEEPSLATE_TILE_WALL,

                    // Overworld Ores
                    COAL_ORE, COPPER_ORE, DIAMOND_ORE, EMERALD_ORE, GOLD_ORE, IRON_ORE, LAPIS_ORE, REDSTONE_ORE,

                    // Deepslate Ores
                    DEEPSLATE_COAL_ORE, DEEPSLATE_COPPER_ORE, DEEPSLATE_DIAMOND_ORE, DEEPSLATE_EMERALD_ORE, DEEPSLATE_GOLD_ORE,
                    DEEPSLATE_IRON_ORE, DEEPSLATE_LAPIS_ORE, DEEPSLATE_REDSTONE_ORE,

                    // Nether Ores
                    NETHER_QUARTZ_ORE, NETHER_GOLD_ORE,

                    // Copper Block Variants
                    COPPER_BLOCK, EXPOSED_COPPER, WEATHERED_COPPER, OXIDIZED_COPPER,
                    CUT_COPPER, EXPOSED_CUT_COPPER, WEATHERED_CUT_COPPER, OXIDIZED_CUT_COPPER,
                    WAXED_COPPER_BLOCK, WAXED_EXPOSED_COPPER, WAXED_WEATHERED_COPPER, WAXED_OXIDIZED_COPPER,
                    WAXED_CUT_COPPER, WAXED_EXPOSED_CUT_COPPER, WAXED_WEATHERED_CUT_COPPER, WAXED_OXIDIZED_CUT_COPPER,

                    // Copper Stairs & Slabs
                    CUT_COPPER_STAIRS, EXPOSED_CUT_COPPER_STAIRS, WEATHERED_CUT_COPPER_STAIRS, OXIDIZED_CUT_COPPER_STAIRS,
                    WAXED_CUT_COPPER_STAIRS, WAXED_EXPOSED_CUT_COPPER_STAIRS, WAXED_WEATHERED_CUT_COPPER_STAIRS, WAXED_OXIDIZED_CUT_COPPER_STAIRS,
                    CUT_COPPER_SLAB, EXPOSED_CUT_COPPER_SLAB, WEATHERED_CUT_COPPER_SLAB, OXIDIZED_CUT_COPPER_SLAB,
                    WAXED_CUT_COPPER_SLAB, WAXED_EXPOSED_CUT_COPPER_SLAB, WAXED_WEATHERED_CUT_COPPER_SLAB, WAXED_OXIDIZED_CUT_COPPER_SLAB,

                    // Ore Blocks
                    COAL_BLOCK, RAW_COPPER_BLOCK, RAW_IRON_BLOCK, RAW_GOLD_BLOCK,
                    IRON_BLOCK, GOLD_BLOCK, DIAMOND_BLOCK, EMERALD_BLOCK, LAPIS_BLOCK,
                    REDSTONE_BLOCK, NETHERITE_BLOCK, QUARTZ_BLOCK, AMETHYST_BLOCK,

                    // Stone Variants
                    STONE, GRANITE, POLISHED_GRANITE, DIORITE, POLISHED_DIORITE, ANDESITE, POLISHED_ANDESITE, TUFF, CALCITE,
                    DRIPSTONE_BLOCK,

                    // Cobblestone Variants
                    COBBLESTONE, MOSSY_COBBLESTONE, COBBLESTONE_STAIRS, MOSSY_COBBLESTONE_STAIRS,
                    COBBLESTONE_SLAB, MOSSY_COBBLESTONE_SLAB, COBBLESTONE_WALL, MOSSY_COBBLESTONE_WALL,

                    // Stone Bricks
                    STONE_BRICKS, CRACKED_STONE_BRICKS, CHISELED_STONE_BRICKS, MOSSY_STONE_BRICKS,
                    STONE_BRICK_STAIRS, MOSSY_STONE_BRICK_STAIRS, STONE_BRICK_SLAB, MOSSY_STONE_BRICK_SLAB,
                    STONE_BRICK_WALL, MOSSY_STONE_BRICK_WALL

                    -> true;

            default -> false;
        };
    }

}
