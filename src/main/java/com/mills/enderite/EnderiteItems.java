package com.mills.enderite;

import org.bukkit.*;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.event.Listener;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ArmorMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.components.EquippableComponent;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.*;

public class EnderiteItems implements Listener {
    private final JavaPlugin plugin;
    private final NamespacedKey durabilityKey;

    public EnderiteItems(JavaPlugin plugin) {
        this.plugin = plugin;
        this.durabilityKey = new NamespacedKey(plugin, "custom_durability");
    }


    public ItemStack enderiteBlock() {

        ItemStack enderiteBlock = new ItemStack(Material.CRYING_OBSIDIAN);
        ItemMeta blockMeta = enderiteBlock.getItemMeta();
        blockMeta.setDisplayName(ChatColor.YELLOW + "Enderite Ore");
        blockMeta.setCustomModelData(1);
        enderiteBlock.setItemMeta(blockMeta);
        return enderiteBlock;
    }

    public ItemStack enderiteShard() {

        ItemStack enderiteShard = new ItemStack(Material.AMETHYST_SHARD);
        ItemMeta shardMeta = enderiteShard.getItemMeta();
        shardMeta.setDisplayName(ChatColor.YELLOW + "Enderite Shard");
        NamespacedKey model = new NamespacedKey("minecraft", "enderite_shard");
        shardMeta.setItemModel(model);
        enderiteShard.setItemMeta(shardMeta);
        return enderiteShard;
    }

    public ItemStack enderiteIngot() {

        ItemStack enderiteIngot = new ItemStack(Material.NETHERITE_INGOT);
        ItemMeta ingotMeta =  enderiteIngot.getItemMeta();
        ingotMeta.setDisplayName(ChatColor.YELLOW + "Enderite Ingot");
        NamespacedKey model = new NamespacedKey("minecraft", "enderite_ingot");
        ingotMeta.setItemModel(model);
        enderiteIngot.setItemMeta(ingotMeta);
        return enderiteIngot;
    }

    public ItemStack enderiteHelmet() {
        ItemStack enderiteHelmet = new ItemStack(Material.NETHERITE_HELMET);
        ArmorMeta helmetMeta = (ArmorMeta) enderiteHelmet.getItemMeta();

        if (helmetMeta == null) return enderiteHelmet;

        helmetMeta.setDisplayName(ChatColor.YELLOW + "Enderite Helmet");

        AttributeModifier kbres = new AttributeModifier(
                UUID.randomUUID(), "generic.knockback_resistance", 0.2, AttributeModifier.Operation.ADD_NUMBER);
        AttributeModifier armor = new AttributeModifier(
                UUID.randomUUID(), "generic.armor", 4, AttributeModifier.Operation.ADD_NUMBER);
        AttributeModifier armortough = new AttributeModifier(
                UUID.randomUUID(), "generic.armor_toughness", 4, AttributeModifier.Operation.ADD_NUMBER);

        helmetMeta.addAttributeModifier(Attribute.ARMOR, armor);
        helmetMeta.addAttributeModifier(Attribute.ARMOR_TOUGHNESS, armortough);
        helmetMeta.addAttributeModifier(Attribute.KNOCKBACK_RESISTANCE, kbres);

        helmetMeta.setCustomModelData(1000);

        EquippableComponent equippable = helmetMeta.getEquippable();
        if (equippable != null) {
            equippable.setSlot(EquipmentSlot.HEAD);
            equippable.setModel(new NamespacedKey("nexo", "enderite"));
            helmetMeta.setEquippable(equippable);
        }

        PersistentDataContainer data = helmetMeta.getPersistentDataContainer();
        NamespacedKey key = new NamespacedKey("nexo", "id");
        data.set(key, PersistentDataType.STRING, "enderite_helmet");

        enderiteHelmet.setItemMeta(helmetMeta);
        return enderiteHelmet;
    }

    public ItemStack enderiteChestplate() {
        AttributeModifier kbres = new AttributeModifier(
                UUID.randomUUID(), "generic.knockback_resistance", 0.2, AttributeModifier.Operation.ADD_NUMBER);
        AttributeModifier armor = new AttributeModifier(
                UUID.randomUUID(), "generic.armor", 9, AttributeModifier.Operation.ADD_NUMBER);
        AttributeModifier armortough = new AttributeModifier(
                UUID.randomUUID(), "generic.armor_toughness", 4, AttributeModifier.Operation.ADD_NUMBER);
        ItemStack enderiteChestplate = new ItemStack(Material.NETHERITE_CHESTPLATE);
        ItemMeta chestplateMeta = enderiteChestplate.getItemMeta();
        chestplateMeta.setDisplayName(ChatColor.YELLOW + "Enderite Chestplate");
        NamespacedKey model = new NamespacedKey("minecraft", "enderite_chestplate");
        chestplateMeta.setItemModel(model);
        chestplateMeta.addAttributeModifier(Attribute.ARMOR, armor);
        chestplateMeta.addAttributeModifier(Attribute.ARMOR_TOUGHNESS, armortough);
        chestplateMeta.addAttributeModifier(Attribute.KNOCKBACK_RESISTANCE, kbres);

        EquippableComponent equippable = chestplateMeta.getEquippable();
        if (equippable != null) {
            equippable.setSlot(EquipmentSlot.CHEST);
            equippable.setModel(new NamespacedKey("nexo", "enderite"));
            chestplateMeta.setEquippable(equippable);
        }

        PersistentDataContainer data = chestplateMeta.getPersistentDataContainer();
        NamespacedKey key = new NamespacedKey("nexo", "id");
        data.set(key, PersistentDataType.STRING, "enderite_helmet");

        enderiteChestplate.setItemMeta(chestplateMeta);
        return enderiteChestplate;
    }

    public ItemStack enderiteLeggings() {
        AttributeModifier kbres = new AttributeModifier(
                UUID.randomUUID(), "generic.knockback_resistance", 0.2, AttributeModifier.Operation.ADD_NUMBER);
        AttributeModifier armor = new AttributeModifier(
                UUID.randomUUID(), "generic.armor", 7, AttributeModifier.Operation.ADD_NUMBER);
        AttributeModifier armortough = new AttributeModifier(
                UUID.randomUUID(), "generic.armor_toughness", 4, AttributeModifier.Operation.ADD_NUMBER);
        ItemStack enderiteLeggings = new ItemStack(Material.NETHERITE_LEGGINGS);
        ItemMeta leggingsMeta = enderiteLeggings.getItemMeta();
        leggingsMeta.setDisplayName(ChatColor.YELLOW + "Enderite Leggings");
        NamespacedKey model = new NamespacedKey("minecraft", "enderite_leggings");
        leggingsMeta.setItemModel(model);
        leggingsMeta.addAttributeModifier(Attribute.ARMOR, armor);
        leggingsMeta.addAttributeModifier(Attribute.ARMOR_TOUGHNESS, armortough);
        leggingsMeta.addAttributeModifier(Attribute.KNOCKBACK_RESISTANCE, kbres);

        EquippableComponent equippable = leggingsMeta.getEquippable();
        if (equippable != null) {
            equippable.setSlot(EquipmentSlot.LEGS);
            equippable.setModel(new NamespacedKey("nexo", "enderite"));
            leggingsMeta.setEquippable(equippable);
        }

        PersistentDataContainer data = leggingsMeta.getPersistentDataContainer();
        NamespacedKey key = new NamespacedKey("nexo", "id");
        data.set(key, PersistentDataType.STRING, "enderite_helmet");

        enderiteLeggings.setItemMeta(leggingsMeta);
        return enderiteLeggings;
    }

    public ItemStack enderiteBoots() {
        AttributeModifier kbres = new AttributeModifier(
                UUID.randomUUID(), "generic.knockback_resistance", 0.2, AttributeModifier.Operation.ADD_NUMBER);
        AttributeModifier armor = new AttributeModifier(
                UUID.randomUUID(), "generic.armor", 4, AttributeModifier.Operation.ADD_NUMBER);
        AttributeModifier armortough = new AttributeModifier(
                UUID.randomUUID(), "generic.armor_toughness", 4, AttributeModifier.Operation.ADD_NUMBER);
        ItemStack enderiteBoots = new ItemStack(Material.NETHERITE_BOOTS);
        ItemMeta bootsMeta = enderiteBoots.getItemMeta();
        bootsMeta.setDisplayName(ChatColor.YELLOW + "Enderite Boots");
        NamespacedKey model = new NamespacedKey("minecraft", "enderite_boots");
        bootsMeta.setItemModel(model);
        bootsMeta.addAttributeModifier(Attribute.ARMOR, armor);
        bootsMeta.addAttributeModifier(Attribute.ARMOR_TOUGHNESS, armortough);
        bootsMeta.addAttributeModifier(Attribute.KNOCKBACK_RESISTANCE, kbres);

        EquippableComponent equippable = bootsMeta.getEquippable();
        if (equippable != null) {
            equippable.setSlot(EquipmentSlot.FEET);
            equippable.setModel(new NamespacedKey("nexo", "enderite"));
            bootsMeta.setEquippable(equippable);
        }

        PersistentDataContainer data = bootsMeta.getPersistentDataContainer();
        NamespacedKey key = new NamespacedKey("nexo", "id");
        data.set(key, PersistentDataType.STRING, "enderite_helmet");

        enderiteBoots.setItemMeta(bootsMeta);
        return enderiteBoots;
    }

    public ItemStack enderiteSword() {
        AttributeModifier attack = new AttributeModifier(
                UUID.randomUUID(), "generic.attack", 9, AttributeModifier.Operation.ADD_NUMBER);
        ItemStack enderiteSword = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta swordMeta = enderiteSword.getItemMeta();
        swordMeta.setDisplayName(ChatColor.YELLOW + "Enderite Sword");
        NamespacedKey model = new NamespacedKey("minecraft", "enderite_sword");
        swordMeta.setItemModel(model);
        swordMeta.addAttributeModifier(Attribute.ATTACK_DAMAGE, attack);
        enderiteSword.setItemMeta(swordMeta);
        return enderiteSword;
    }

    public ItemStack enderitePickaxe() {
        ItemStack enderitePickaxe = new ItemStack(Material.NETHERITE_PICKAXE);
        ItemMeta pickaxeMeta = enderitePickaxe.getItemMeta();
        pickaxeMeta.setDisplayName(ChatColor.YELLOW + "Enderite Pickaxe");
        NamespacedKey model = new NamespacedKey("minecraft", "enderite_pickaxe");
        pickaxeMeta.setItemModel(model);
        enderitePickaxe.setItemMeta(pickaxeMeta);
        return enderitePickaxe;
    }

    public ItemStack enderiteAxe() {
        ItemStack enderiteAxe = new ItemStack(Material.NETHERITE_AXE);
        ItemMeta axeMeta = enderiteAxe.getItemMeta();
        axeMeta.setDisplayName(ChatColor.YELLOW + "Enderite Axe");
        NamespacedKey model = new NamespacedKey("minecraft", "enderite_axe");
        axeMeta.setItemModel(model);
        enderiteAxe.setItemMeta(axeMeta);
        return enderiteAxe;
    }

    public ItemStack enderiteShovel() {
        ItemStack enderiteShovel = new ItemStack(Material.NETHERITE_SHOVEL);
        ItemMeta shovelMeta = enderiteShovel.getItemMeta();
        shovelMeta.setDisplayName(ChatColor.YELLOW + "Enderite Shovel");
        NamespacedKey model = new NamespacedKey("minecraft", "enderite_shovel");
        shovelMeta.setItemModel(model);
        enderiteShovel.setItemMeta(shovelMeta);
        return enderiteShovel;
    }

    public ItemStack enderiteHoe() {
        ItemStack enderiteHoe = new ItemStack(Material.NETHERITE_HOE);
        ItemMeta hoeMeta = enderiteHoe.getItemMeta();
        hoeMeta.setDisplayName(ChatColor.YELLOW + "Enderite Hoe");
        NamespacedKey model = new NamespacedKey("minecraft", "enderite_hoe");
        hoeMeta.setItemModel(model);
        enderiteHoe.setItemMeta(hoeMeta);
        return enderiteHoe;
    }
}
