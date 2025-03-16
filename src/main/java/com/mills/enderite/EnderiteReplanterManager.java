package com.mills.enderite;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.block.data.Ageable;
import org.bukkit.block.data.BlockData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

public class EnderiteReplanterManager implements Listener {

    private EnderiteItems enderiteItems;
    private JavaPlugin plugin;

    public EnderiteReplanterManager(JavaPlugin plugin, EnderiteItems enderiteItems) {
        this.plugin = plugin;
        this.enderiteItems = enderiteItems;
    }

    @EventHandler
    public void onBreak(BlockBreakEvent e) {
        Player player = e.getPlayer();
        Block block = e.getBlock();
        ItemStack tool = player.getInventory().getItemInMainHand();

        if (isEnderiteHoe(tool)) {
            BlockData blockData = block.getBlockData();

            if (blockData instanceof Ageable) {
                Ageable ageable = (Ageable) blockData;
                int growthStage = ageable.getAge();
                int maxGrowthStage = ageable.getMaximumAge();
                int setGrowthStage = maxGrowthStage - 1;

                if (growthStage < maxGrowthStage) {
                    e.setCancelled(true);
                    player.spigot().sendMessage(ChatMessageType.ACTION_BAR, TextComponent.fromLegacy(ChatColor.RED + "Crop's not fully grown!"));
                }

                if (growthStage == maxGrowthStage) {
                    Material blockType = block.getType();
                    Location playerLoc = player.getLocation();

                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            if (block.getType() == Material.AIR) {

                                switch (blockType) {
                                    case WHEAT:
                                        block.setType(Material.WHEAT);
                                        break;
                                    case CARROTS:
                                        block.setType(Material.CARROTS);
                                        break;
                                    case POTATOES:
                                        block.setType(Material.POTATOES);
                                        break;
                                    case NETHER_WART:
                                        block.setType(Material.NETHER_WART);
                                }

                                BlockData newBlockData = block.getBlockData();
                                if (newBlockData instanceof Ageable) {
                                    Ageable ageable = (Ageable) newBlockData;
                                    ageable.setAge(setGrowthStage);
                                    block.setBlockData(ageable);
                                }
                                block.getWorld().playSound(playerLoc, Sound.ITEM_BOTTLE_EMPTY, 1.0f, 1.0f);
                            }
                        }
                    }.runTaskLater(plugin, 60L);
                }
            }
        }
    }

    private boolean isEnderiteHoe(ItemStack item) {
        if (item == null || !item.hasItemMeta()) return false;
        ItemMeta meta = item.getItemMeta();

        if (meta != null && meta.hasDisplayName()) {
        }

        return isSameItem(item, enderiteItems.enderiteHoe());
    }

    private boolean isSameItem(ItemStack item, ItemStack reference) {
        if (item == null || reference == null) return false;
        if (item.getType() != reference.getType()) return false;

        ItemMeta meta = item.getItemMeta();
        ItemMeta refMeta = reference.getItemMeta();
        if (meta == null || refMeta == null) return false;

        return meta.hasDisplayName() && refMeta.hasDisplayName() && meta.getDisplayName().equals(refMeta.getDisplayName());
    }

}
