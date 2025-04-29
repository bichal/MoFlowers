/*
 * Copyright (c) 2025 Bichal.
 * All rights reserved.
 */
package net.bichal.moflowers.blocks.entity;

import net.bichal.moflowers.screen.FlowersChestScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.block.enums.ChestType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;

public class FlowersChestBlockEntity extends ChestBlockEntity {
    public FlowersChestBlockEntity(BlockPos pos, BlockState state) {
        super(ModBlockEntities.FLOWERS_CHEST_BLOCK_ENTITY, pos, state);
    }

    @Override
    public Text getDisplayName() {
        return Text.translatable("container.moflowers.flowers_chest");
    }

    @Override
    public ScreenHandler createMenu(int syncId, PlayerInventory playerInventory, PlayerEntity player) {
        this.generateLoot(player);

        ChestType chestType = this.getCachedState().get(ChestBlock.CHEST_TYPE);
        if (chestType == ChestType.SINGLE) {
            return new FlowersChestScreenHandler(syncId, playerInventory, this, 3);
        }
        return null;
    }
}