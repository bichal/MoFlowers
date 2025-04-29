/*
 * Copyright (c) 2025 Bichal.
 * All rights reserved.
 */

package net.bichal.moflowers.api.impl;

import net.bichal.moflowers.api.IMoFlowersAPI;
import net.bichal.moflowers.api.event.IFlowerRegistrationCallback;
import net.bichal.moflowers.api.event.MoFlowersEvents;
import net.bichal.moflowers.api.flowers.FlowerData;
import net.bichal.moflowers.api.flowers.FlowerRegistry;
import net.bichal.moflowers.blocks.ModBlocks;
import net.bichal.moflowers.item.ModItems;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;

/**
 * Default implementation of the API
 * Handles registration and querying of flowers and related resources.
 */
public class MoFlowersAPIImpl implements IMoFlowersAPI {
    @Override
    public void registerFlower(Item flowerItem) {
        FlowerRegistry.registerFlower(flowerItem);
    }

    @Override
    public void registerFlowerBlock(Block flowerBlock) {
        FlowerRegistry.registerFlowerBlock(flowerBlock);
    }

    @Override
    public void registerCustomFlower(FlowerData flowerData) {
        FlowerRegistry.registerFlower(flowerData.item());
        FlowerRegistry.registerFlowerBlock(flowerData.block());
        MoFlowersEvents.invokeFlowerRegistration(flowerData);
    }

    @Override
    public boolean isMoFlower(Item item) {
        return FlowerRegistry.isRegisteredFlower(item);
    }

    @Override
    public boolean isMoFlowerBlock(Block block) {
        return FlowerRegistry.isRegisteredFlowerBlock(block);
    }

    @Override
    public TagKey<Item> getFlowersTag() {
        return FlowerRegistry.FLOWERS_TAG;
    }

    @Override
    public TagKey<Block> getFlowerBlocksTag() {
        return FlowerRegistry.FLOWER_BLOCKS_TAG;
    }

    @Override
    public Item getFlowersChestItem() {
        return ModItems.FLOWERS_CHEST;
    }

    @Override
    public Block getFlowersChestBlock() {
        return ModBlocks.FLOWERS_CHEST;
    }

    @Override
    public void registerFlowerRegistrationCallback(IFlowerRegistrationCallback callback) {
        MoFlowersEvents.registerFlowerRegistrationCallback(callback);
    }
}
