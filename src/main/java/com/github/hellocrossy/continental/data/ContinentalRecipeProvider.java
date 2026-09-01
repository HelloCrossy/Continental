package com.github.hellocrossy.continental.data;

import com.github.hellocrossy.continental.Continental;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.gson.JsonObject;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.CraftingBookCategory;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class ContinentalRecipeProvider extends RecipeProvider {
    public ContinentalRecipeProvider(PackOutput packOutput) {
        super(packOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
    }

    private static void zawaPlushBlocks(Consumer<FinishedRecipe> consumer) {
    }

    private static void zawaDecoBlocks(Consumer<FinishedRecipe> consumer) {
    }

    private static void plaqueRecipes(Consumer<FinishedRecipe> consumer, ItemLike plaque, ItemLike planks, ItemLike log) {
        shapedRecipeResult(consumer, plaque, 3, ImmutableList.of("PPP", "PPP", "L L"), ImmutableMap.<Character, Ingredient>builder().put('P', Ingredient.of(planks)).put('L', Ingredient.of(log)).build());
    }

    private static void stairAndSlabRecipes(Consumer<FinishedRecipe> consumer, ItemLike fullBlock, ItemLike stairs, ItemLike slab) {
        shapedRecipeResult(consumer, stairs, 4, ImmutableList.of("B  ", "BB ", "BBB"), ImmutableMap.<Character, Ingredient>builder().put('B', Ingredient.of(fullBlock)).build());
        shapedRecipeResult(consumer, slab, 6, ImmutableList.of("BBB"), ImmutableMap.<Character, Ingredient>builder().put('B', Ingredient.of(fullBlock)).build());
    }

    private static void woodenTypeBlocksRecipes(Consumer<FinishedRecipe> consumer, ItemLike block, ItemLike stick, ItemLike stairs, ItemLike slab, ItemLike fence, ItemLike fenceGate, ItemLike door, ItemLike trapdoor) {
        stairAndSlabRecipes(consumer, block, stairs, slab);
        shapedRecipeResult(consumer, fence, 3, ImmutableList.of("BSB", "BSB"), ImmutableMap.<Character, Ingredient>builder().put('B', Ingredient.of(block)).put('S', Ingredient.of(stick)).build());
        shapedRecipeResult(consumer, fenceGate, 1, ImmutableList.of("SBS", "SBS"), ImmutableMap.<Character, Ingredient>builder().put('B', Ingredient.of(block)).put('S', Ingredient.of(stick)).build());
        shapedRecipeResult(consumer, door, 3, ImmutableList.of("BB", "BB", "BB"), ImmutableMap.<Character, Ingredient>builder().put('B', Ingredient.of(block)).build());
        shapedRecipeResult(consumer, trapdoor, 2, ImmutableList.of("BBB", "BBB"), ImmutableMap.<Character, Ingredient>builder().put('B', Ingredient.of(block)).build());
    }

    private static void stoneVariantBlocksRecipes(Consumer<FinishedRecipe> consumer, ItemLike fullBlock, ItemLike stairs, ItemLike slab, ItemLike wall) {
        shapedRecipeResult(consumer, stairs, 4, ImmutableList.of("B  ", "BB ", "BBB"), ImmutableMap.<Character, Ingredient>builder().put('B', Ingredient.of(fullBlock)).build());
        shapedRecipeResult(consumer, slab, 6, ImmutableList.of("BBB"), ImmutableMap.<Character, Ingredient>builder().put('B', Ingredient.of(fullBlock)).build());
        shapedRecipeResult(consumer, wall, 6, ImmutableList.of("BBB", "BBB"), ImmutableMap.<Character, Ingredient>builder().put('B', Ingredient.of(fullBlock)).build());
    }

    private static void barVariantBlocksRecipes(Consumer<FinishedRecipe> consumer, ItemLike fence, ItemLike bars, ItemLike door, ItemLike slab, ItemLike trapdoor) {
        shapedRecipeResult(consumer, bars, 4, ImmutableList.of("FF", "FF"), ImmutableMap.<Character, Ingredient>builder().put('F', Ingredient.of(fence)).build());
        shapedRecipeResult(consumer, door, 3, ImmutableList.of("BB", "BB", "BB"), ImmutableMap.<Character, Ingredient>builder().put('B', Ingredient.of(bars)).build());
        shapedRecipeResult(consumer, slab, 6, ImmutableList.of("BBB"), ImmutableMap.<Character, Ingredient>builder().put('B', Ingredient.of(bars)).build());
        shapedRecipeResult(consumer, trapdoor, 2, ImmutableList.of("BBB", "BBB"), ImmutableMap.<Character, Ingredient>builder().put('B', Ingredient.of(bars)).build());
    }

    private static void cookRecipes(Consumer<FinishedRecipe> consumer, ItemLike result, ItemLike recipe, float experience) {
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(recipe), RecipeCategory.FOOD, result, experience, 200).unlockedBy(getHasName(recipe), has(recipe)).save(consumer, BuiltInRegistries.ITEM.getKey(result.asItem()));
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(recipe), RecipeCategory.FOOD, result, experience, 100).unlockedBy(getHasName(recipe), has(recipe)).save(consumer, BuiltInRegistries.ITEM.getKey(result.asItem()).withSuffix("_smoking"));
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(recipe), RecipeCategory.FOOD, result, experience, 600).unlockedBy(getHasName(recipe), has(recipe)).save(consumer, BuiltInRegistries.ITEM.getKey(result.asItem()).withSuffix("_campfire"));
    }

    public static void shapedRecipeResult(Consumer<FinishedRecipe> consumer, ItemLike iItemProvider, int outputNum, List<String> recipe, Map<Character, Ingredient> recipeMapKey) {
        namedShapedRecipeResult(consumer, ForgeRegistries.ITEMS.getKey(iItemProvider.asItem()).getPath(), iItemProvider, outputNum, recipe, recipeMapKey);
    }

    public static void namedShapedRecipeResult(Consumer<FinishedRecipe> consumer, String id, ItemLike iItemProvider, int outputNum, List<String> recipe, Map<Character, Ingredient> recipeMapKey) {
        consumer.accept(new ShapedRecipeBuilder.Result(
                new ResourceLocation(Continental.MOD_ID, id),
                iItemProvider.asItem(),
                outputNum,
                Continental.MOD_ID,
                CraftingBookCategory.MISC,
                recipe,
                recipeMapKey,
                null,
                null,
                false
        ) {
            @Override
            public JsonObject serializeAdvancement() {
                return null;
            }
        });
    }
}