/*
 * Copyright (c) 2025 Bichal.
 * All rights reserved.
 */

package net.bichal.moflowers.datagen;

import net.bichal.moflowers.datagen.providers.*;
import net.bichal.moflowers.datagen.providers.lang.MoFlowerSpanishLangProvider;
import net.bichal.moflowers.datagen.providers.lang.MoFlowersEnglishLangProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class MoFlowersDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(MoFlowersItemTagProvider::new);
        pack.addProvider(MoFlowersBlockTagProvider::new);
        pack.addProvider(MoFlowersAdvancementProvider::new);
        pack.addProvider(MoFlowersRecipeProvider::new);
        pack.addProvider(MoFlowersBlockLootTableProvider::new);
        pack.addProvider(MoFlowersModelProvider::new);
        pack.addProvider(MoFlowersEnglishLangProvider::new);
        pack.addProvider(MoFlowerSpanishLangProvider::new);
    }
}
