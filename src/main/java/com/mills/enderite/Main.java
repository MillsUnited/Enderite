package com.mills.enderite;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private EnderiteItems enderiteItems;
    private EnderiteRecipe enderiteRecipe;

    @Override
    public void onEnable() {
        this.enderiteItems = new EnderiteItems(this);

        Bukkit.getPluginManager().registerEvents(new EnderiteItems(this), this);
        Bukkit.getPluginManager().registerEvents(new EnderiteInstaBreakManager(enderiteItems), this);
        Bukkit.getPluginManager().registerEvents(new EnderiteReplanterManager(this, enderiteItems), this);
        Bukkit.getPluginManager().registerEvents(new EnderiteArmorBufferManager(this, enderiteItems), this);

        enderiteRecipe = new EnderiteRecipe(this, enderiteItems);

        EnderiteBlockManager blockManager = new EnderiteBlockManager(this, enderiteItems);
        Bukkit.getPluginManager().registerEvents(blockManager, this);

        World endWorld = Bukkit.getWorld("world_the_end");
        if (endWorld != null) {
            endWorld.getPopulators().add(blockManager);
        }
    }
}
