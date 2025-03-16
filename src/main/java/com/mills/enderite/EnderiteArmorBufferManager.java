package com.mills.enderite;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class EnderiteArmorBufferManager implements Listener {

    private EnderiteItems enderiteItems;
    private JavaPlugin plugin;

    public EnderiteArmorBufferManager(JavaPlugin plugin, EnderiteItems enderiteItems) {
        this.plugin = plugin;
        this.enderiteItems = enderiteItems;
        giveEffectsWhenYouHaveArmor();
    }

    public void giveEffectsWhenYouHaveArmor() {
        Bukkit.getScheduler().runTaskTimer(plugin, () -> {
            for (Player player : Bukkit.getOnlinePlayers()) {
                ItemStack helmet = player.getInventory().getHelmet();
                ItemStack chestplate = player.getInventory().getChestplate();
                ItemStack leggings = player.getInventory().getLeggings();
                ItemStack boots = player.getInventory().getBoots();

                if (isFullEnderiteArmor(helmet, chestplate, leggings, boots)) {
                    player.addPotionEffect(new PotionEffect(PotionEffectType.STRENGTH, 60, 0, true, false));
                    player.addPotionEffect(new PotionEffect(PotionEffectType.RESISTANCE, 60, 1, true, false));
                }

            }
        }, 0L, 1L);
    }

    private boolean isFullEnderiteArmor(ItemStack helmet, ItemStack chestplate, ItemStack leggings, ItemStack boots) {
        return isEnderiteHelmet(helmet) && isEnderiteChestplate(chestplate) && isEnderiteLeggings(leggings) && isEnderiteBoots(boots);
    }

    private boolean isEnderiteHelmet(ItemStack item) {
        return isSameItem(item, enderiteItems.enderiteHelmet());
    }

    private boolean isEnderiteChestplate(ItemStack item) {
        return isSameItem(item, enderiteItems.enderiteChestplate());
    }

    private boolean isEnderiteLeggings(ItemStack item) {
        return isSameItem(item, enderiteItems.enderiteLeggings());
    }

    private boolean isEnderiteBoots(ItemStack item) {
        return isSameItem(item, enderiteItems.enderiteBoots());
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
