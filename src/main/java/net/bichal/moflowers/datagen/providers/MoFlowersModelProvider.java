/*
 * Copyright (c) 2025 Bichal.
 * All rights reserved.
 */

package net.bichal.moflowers.datagen.providers;

import net.bichal.moflowers.blocks.ModBlocks;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.BlockStateModelGenerator;
import net.minecraft.client.data.ItemModelGenerator;

public class MoFlowersModelProvider extends FabricModelProvider {
    public MoFlowersModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator b) {
        b.registerTintableCrossBlockState(ModBlocks.WILD_FIREFLY_BUSH, BlockStateModelGenerator.CrossType.EMISSIVE_NOT_TINTED);
    }

    @Override
    public void generateItemModels(ItemModelGenerator i) {
        i.register(ModBlocks.WILD_FIREFLY_BUSH.asItem());
    }
}