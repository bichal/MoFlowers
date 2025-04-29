/*
 * Copyright (c) 2025 Bichal.
 * All rights reserved.
 */

package net.bichal.moflowers.datagen.providers;

import net.bichal.moflowers.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipe.RecipeExporter;
import net.minecraft.data.recipe.RecipeGenerator;
import net.minecraft.item.Items;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class MoFlowersRecipeProvider extends FabricRecipeProvider {
    public MoFlowersRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected RecipeGenerator getRecipeGenerator(RegistryWrapper.WrapperLookup registryLookup, RecipeExporter exporter) {
        return new RecipeGenerator(registryLookup, exporter) {
            @Override
            public void generate() {
                offerSingleOutputShapelessRecipe(Items.GRAY_DYE, ModItems.CLOSED_PALE_WILDFLOWERS, "gray_dye_from_close_pale_wildflowers");
                offerSingleOutputShapelessRecipe(Items.ORANGE_DYE, ModItems.OPEN_PALE_WILDFLOWERS, "orange_dye_from_open_pale_wildflowers");
                offerSingleOutputShapelessRecipe(Items.MAGENTA_DYE, ModItems.MAGENTA_PETALS, "magenta_dye_from_open_magenta_petals");
                offerSingleOutputShapelessRecipe(Items.PINK_DYE, ModItems.LILY_PAD_FLOWER, "pink_dye_from_lily_pad_flower");
                offerSingleOutputShapelessRecipe(Items.YELLOW_DYE, ModItems.SUNFLOWERS, "yellow_dye_from_sunflowers");
                offerSingleOutputShapelessRecipe(Items.PURPLE_DYE, ModItems.LAVENDER, "purple_dye_from_lavender");
                offerSingleOutputShapelessRecipe(Items.PURPLE_DYE, ModItems.TALL_LAVENDER, "purple_dye_from_tall_lavender");
                offerSingleOutputShapelessRecipe(Items.ORANGE_DYE, ModItems.CALENDULA, "orange_dye_from_calendula");
                offerSingleOutputShapelessRecipe(Items.MAGENTA_DYE, ModItems.FOXGLOVE, "magenta_dye_from_foxglove");
                offerSingleOutputShapelessRecipe(Items.PINK_DYE, ModItems.HEBEA, "pink_dye_from_hebea");
            }
        };
    }

    @Override
    public String getName() {
        return "MoFlowersRecipeProvider";
    }
}
