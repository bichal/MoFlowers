/*
 * Copyright (c) 2025 Bichal.
 * All rights reserved.
 */

package net.bichal.moflowers.world.gen;

import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.PlacedFeature;

public class ModWorldGeneration {
    public static void register() {
        VegetalGeneration.generate();
    }

    public static RegistryKey<PlacedFeature> registerPlaceFeature(String path) {
        return RegistryKey.of(RegistryKeys.PLACED_FEATURE, Identifier.of("moflowers", path));
    }
}
