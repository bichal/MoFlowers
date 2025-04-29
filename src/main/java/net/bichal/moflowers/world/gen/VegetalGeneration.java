/*
 * Copyright (c) 2025 Bichal.
 * All rights reserved.
 */

package net.bichal.moflowers.world.gen;

import net.fabricmc.fabric.api.biome.v1.BiomeModifications;
import net.fabricmc.fabric.api.biome.v1.BiomeSelectors;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.gen.GenerationStep;
import net.minecraft.world.gen.feature.PlacedFeature;

public class VegetalGeneration {
    public static final RegistryKey<PlacedFeature> MAGENTA_PETALS_MEADOW = ModWorldGeneration.registerPlaceFeature("magenta_petals_meadow");
    public static final RegistryKey<PlacedFeature> MAGENTA_PETALS_PLAINS = ModWorldGeneration.registerPlaceFeature("magenta_petals_plains");
    public static final RegistryKey<PlacedFeature> MAGENTA_PETALS_FLOWER_FOREST = ModWorldGeneration.registerPlaceFeature("magenta_petals_flower_forest");
    public static final RegistryKey<PlacedFeature> LAVENDER_MEADOW = ModWorldGeneration.registerPlaceFeature("lavender_meadow");
    public static final RegistryKey<PlacedFeature> LAVENDER_PLAINS = ModWorldGeneration.registerPlaceFeature("lavender_plains");
    public static final RegistryKey<PlacedFeature> LAVENDER_FLOWER_FOREST = ModWorldGeneration.registerPlaceFeature("lavender_flower_forest");
    public static final RegistryKey<PlacedFeature> CLOSED_PALE_WILDFLOWERS = ModWorldGeneration.registerPlaceFeature("closed_pale_wildflowers");
    public static final RegistryKey<PlacedFeature> BLUE_BERRY_BUSH = ModWorldGeneration.registerPlaceFeature("patch_blue_berry_bush");

    public static void generate() {
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.MEADOW), GenerationStep.Feature.VEGETAL_DECORATION, MAGENTA_PETALS_MEADOW);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, MAGENTA_PETALS_PLAINS);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FLOWER_FOREST), GenerationStep.Feature.VEGETAL_DECORATION, MAGENTA_PETALS_FLOWER_FOREST);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.MEADOW), GenerationStep.Feature.VEGETAL_DECORATION, LAVENDER_MEADOW);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PLAINS), GenerationStep.Feature.VEGETAL_DECORATION, LAVENDER_PLAINS);
        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.FLOWER_FOREST), GenerationStep.Feature.VEGETAL_DECORATION, LAVENDER_FLOWER_FOREST);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.PALE_GARDEN), GenerationStep.Feature.VEGETAL_DECORATION, CLOSED_PALE_WILDFLOWERS);

        BiomeModifications.addFeature(BiomeSelectors.includeByKey(BiomeKeys.TAIGA), GenerationStep.Feature.VEGETAL_DECORATION, BLUE_BERRY_BUSH);
    }
}