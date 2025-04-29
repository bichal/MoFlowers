/*
 * Copyright (c) 2025 Bichal.
 * All rights reserved.
 */

package net.bichal.moflowers.blocks.entity;

import net.bichal.moflowers.MoFlowers;
import net.bichal.moflowers.blocks.ModBlocks;
import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;

public class ModBlockEntities {
    public static final BlockEntityType<FlowersChestBlockEntity> FLOWERS_CHEST_BLOCK_ENTITY = Registry.register(Registries.BLOCK_ENTITY_TYPE, Identifier.of(MoFlowers.MOD_ID, "flowers_chest"), FabricBlockEntityTypeBuilder
            .create(FlowersChestBlockEntity::new, ModBlocks.FLOWERS_CHEST).build());

    public static void register() {
        MoFlowers.LOGGER.info("[{}] ModBlockEntities initialized", MoFlowers.MOD_NAME);
    }
}