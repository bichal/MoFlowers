/*
 * Copyright (c) 2025 Bichal.
 * All rights reserved.
 */

package net.bichal.moflowers.blocks;

import net.bichal.moflowers.blocks.entity.FlowersChestBlockEntity;
import net.bichal.moflowers.screen.FlowersChestScreenHandler;
import net.minecraft.block.BlockState;
import net.minecraft.block.ChestBlock;
import net.minecraft.block.DoubleBlockProperties;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.DoubleInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.screen.NamedScreenHandlerFactory;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;
import java.util.function.Supplier;

public class FlowersChestBlock extends ChestBlock {
    public static final DoubleBlockProperties.PropertyRetriever<ChestBlockEntity, Optional<NamedScreenHandlerFactory>> NAME_RETRIEVER = new DoubleBlockProperties.PropertyRetriever<>() {
        public Optional<NamedScreenHandlerFactory> getFromBoth(final ChestBlockEntity chestBlockEntity, final ChestBlockEntity chestBlockEntity2) {
            final Inventory inventory = new DoubleInventory(chestBlockEntity, chestBlockEntity2);
            return Optional.of(new NamedScreenHandlerFactory() {
                @Nullable
                @Override
                public ScreenHandler createMenu(int i, PlayerInventory playerInventory, PlayerEntity playerEntity) {
                    if (chestBlockEntity.checkUnlocked(playerEntity) && chestBlockEntity2.checkUnlocked(playerEntity)) {
                        chestBlockEntity.generateLoot(playerInventory.player);
                        chestBlockEntity2.generateLoot(playerInventory.player);

                        return new FlowersChestScreenHandler(i, playerInventory, inventory, 6);
                    }
                    else {
                        return null;
                    }
                }

                @Override
                public Text getDisplayName() {
                    if (chestBlockEntity.hasCustomName()) {
                        return chestBlockEntity.getDisplayName();
                    }
                    else {
                        return chestBlockEntity2.hasCustomName() ? chestBlockEntity2.getDisplayName() : Text.translatable("container.moflowers.double_flowers_chest");
                    }
                }
            });
        }

        public Optional<NamedScreenHandlerFactory> getFrom(ChestBlockEntity chestBlockEntity) {
            return Optional.of(chestBlockEntity);
        }

        public Optional<NamedScreenHandlerFactory> getFallback() {
            return Optional.empty();
        }
    };

    public FlowersChestBlock(Supplier<BlockEntityType<? extends ChestBlockEntity>> blockEntityTypeSupplier, Settings settings) {
        super(blockEntityTypeSupplier, settings);
    }

    @Override
    public BlockEntity createBlockEntity(BlockPos pos, BlockState state) {
        return new FlowersChestBlockEntity(pos, state);
    }

    @Nullable
    @Override
    protected NamedScreenHandlerFactory createScreenHandlerFactory(BlockState state, World world, BlockPos pos) {
        return this.getBlockEntitySource(state, world, pos, false).apply(NAME_RETRIEVER).orElse(null);
    }
}
