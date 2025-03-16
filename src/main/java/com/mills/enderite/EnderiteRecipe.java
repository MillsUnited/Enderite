package com.mills.enderite;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.*;

public class EnderiteRecipe {

    private Main main;
    private EnderiteItems enderiteItems;

    public EnderiteRecipe(Main main, EnderiteItems enderiteItems) {
        this.main = main;
        this.enderiteItems = enderiteItems;
        enderiteSmelting();
        enderiteIngotCraft();
        enderitePickaxeCraft();
        enderiteAxeCraft();
        enderiteShovelCraft();
        enderiteSwordCraft();
        enderiteHoeCraft();
        enderiteHelmetCraft();
        enderiteChestplateCraft();
        enderiteLeggingsCraft();
        enderiteBootsCraft();
    }

    public void enderiteSmelting() {
        ItemStack input = enderiteItems.enderiteBlock();
        ItemStack output = enderiteItems.enderiteShard();

        FurnaceRecipe enderiteSmelt = new FurnaceRecipe(
                new NamespacedKey(main, "enderite_smelting"),
                output,
                input.getType(),
                5.0f,
                200);

        Bukkit.addRecipe(enderiteSmelt);
    }

    public void enderiteIngotCraft() {
        ItemStack result = enderiteItems.enderiteIngot();
        NamespacedKey key = new NamespacedKey(main, "enderite_ingot");
        ShapedRecipe recipe = new ShapedRecipe(key, result);
        recipe.shape(
                "EEE",
                "EEE",
                "EEE"
        );
        recipe.setIngredient('E', new RecipeChoice.ExactChoice(enderiteItems.enderiteShard()));
        Bukkit.addRecipe(recipe);
    }

    public void enderitePickaxeCraft() {
        ItemStack result = enderiteItems.enderitePickaxe();
        NamespacedKey key = new NamespacedKey(main, "enderite_pickaxe");
        ShapedRecipe recipe = new ShapedRecipe(key, result);
        recipe.shape(
                "ABA",
                "ACA",
                "AAA"
        );
        recipe.setIngredient('A', Material.DIAMOND);
        recipe.setIngredient('B', new RecipeChoice.ExactChoice(enderiteItems.enderiteIngot()));
        recipe.setIngredient('C', Material.NETHERITE_PICKAXE);
        Bukkit.addRecipe(recipe);
    }

    public void enderiteAxeCraft() {
        ItemStack result = enderiteItems.enderiteAxe();
        NamespacedKey key = new NamespacedKey(main, "enderite_axe");
        ShapedRecipe recipe = new ShapedRecipe(key, result);
        recipe.shape(
                "ABA",
                "ACA",
                "AAA"
        );
        recipe.setIngredient('A', Material.DIAMOND);
        recipe.setIngredient('B', new RecipeChoice.ExactChoice(enderiteItems.enderiteIngot()));
        recipe.setIngredient('C', Material.NETHERITE_AXE);
        Bukkit.addRecipe(recipe);
    }

    public void enderiteShovelCraft() {
        ItemStack result = enderiteItems.enderiteShovel();
        NamespacedKey key = new NamespacedKey(main, "enderite_shovel");
        ShapedRecipe recipe = new ShapedRecipe(key, result);
        recipe.shape(
                "ABA",
                "ACA",
                "AAA"
        );
        recipe.setIngredient('A', Material.DIAMOND);
        recipe.setIngredient('B', new RecipeChoice.ExactChoice(enderiteItems.enderiteIngot()));
        recipe.setIngredient('C', Material.NETHERITE_SHOVEL);
        Bukkit.addRecipe(recipe);
    }

    public void enderiteSwordCraft() {
        ItemStack result = enderiteItems.enderiteSword();
        NamespacedKey key = new NamespacedKey(main, "enderite_sword");
        ShapedRecipe recipe = new ShapedRecipe(key, result);
        recipe.shape(
                "ABA",
                "ACA",
                "AAA"
        );
        recipe.setIngredient('A', Material.DIAMOND);
        recipe.setIngredient('B', new RecipeChoice.ExactChoice(enderiteItems.enderiteIngot()));
        recipe.setIngredient('C', Material.NETHERITE_SWORD);
        Bukkit.addRecipe(recipe);
    }

    public void enderiteHoeCraft() {
        ItemStack result = enderiteItems.enderiteHoe();
        NamespacedKey key = new NamespacedKey(main, "enderite_hoe");
        ShapedRecipe recipe = new ShapedRecipe(key, result);
        recipe.shape(
                "ABA",
                "ACA",
                "AAA"
        );
        recipe.setIngredient('A', Material.DIAMOND);
        recipe.setIngredient('B', new RecipeChoice.ExactChoice(enderiteItems.enderiteIngot()));
        recipe.setIngredient('C', Material.NETHERITE_HOE);
        Bukkit.addRecipe(recipe);
    }

    public void enderiteHelmetCraft() {
        ItemStack result = enderiteItems.enderiteHelmet();
        NamespacedKey key = new NamespacedKey(main, "enderite_helmet");
        ShapedRecipe recipe = new ShapedRecipe(key, result);
        recipe.shape(
                "ABA",
                "ACA",
                "AAA"
        );
        recipe.setIngredient('A', Material.DIAMOND);
        recipe.setIngredient('B', new RecipeChoice.ExactChoice(enderiteItems.enderiteIngot()));
        recipe.setIngredient('C', Material.NETHERITE_HELMET);
        Bukkit.addRecipe(recipe);
    }

    public void enderiteChestplateCraft() {
        ItemStack result = enderiteItems.enderiteChestplate();
        NamespacedKey key = new NamespacedKey(main, "enderite_chestplate");
        ShapedRecipe recipe = new ShapedRecipe(key, result);
        recipe.shape(
                "ABA",
                "ACA",
                "AAA"
        );
        recipe.setIngredient('A', Material.DIAMOND);
        recipe.setIngredient('B', new RecipeChoice.ExactChoice(enderiteItems.enderiteIngot()));
        recipe.setIngredient('C', Material.NETHERITE_CHESTPLATE);
        Bukkit.addRecipe(recipe);
    }

    public void enderiteLeggingsCraft() {
        ItemStack result = enderiteItems.enderiteLeggings();
        NamespacedKey key = new NamespacedKey(main, "enderite_leggings");
        ShapedRecipe recipe = new ShapedRecipe(key, result);
        recipe.shape(
                "ABA",
                "ACA",
                "AAA"
        );
        recipe.setIngredient('A', Material.DIAMOND);
        recipe.setIngredient('B', new RecipeChoice.ExactChoice(enderiteItems.enderiteIngot()));
        recipe.setIngredient('C', Material.NETHERITE_LEGGINGS);
        Bukkit.addRecipe(recipe);
    }

    public void enderiteBootsCraft() {
        ItemStack result = enderiteItems.enderiteBoots();
        NamespacedKey key = new NamespacedKey(main, "enderite_boots");
        ShapedRecipe recipe = new ShapedRecipe(key, result);
        recipe.shape(
                "ABA",
                "ACA",
                "AAA"
        );
        recipe.setIngredient('A', Material.DIAMOND);
        recipe.setIngredient('B', new RecipeChoice.ExactChoice(enderiteItems.enderiteIngot()));
        recipe.setIngredient('C', Material.NETHERITE_BOOTS);
        Bukkit.addRecipe(recipe);
    }
}
