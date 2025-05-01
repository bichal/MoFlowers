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

import java.util.Collection;
import java.util.Objects;
import java.util.Optional;

/**
 * Default implementation of the MoFlowers API.
 * Handles registration and querying of flowers and related resources.
 */
public class MoFlowersAPIImpl implements IMoFlowersAPI {
    @Override
    public void registerFlower(Item flowerItem) {
        Objects.requireNonNull(flowerItem, "Flower item cannot be null");
        if (!FlowerRegistry.isRegisteredFlower(flowerItem)) {
            FlowerRegistry.registerFlower(flowerItem);
        }
    }

    @Override
    public void registerFlowerBlock(Block flowerBlock) {
        Objects.requireNonNull(flowerBlock, "Flower block cannot be null");
        if (!FlowerRegistry.isRegisteredFlowerBlock(flowerBlock)) {
            FlowerRegistry.registerFlowerBlock(flowerBlock);
        }
    }

    @Override
    public void registerFlowers(Collection<Item> flowerItems) {
        if (flowerItems != null) {
            for (Item item : flowerItems) {
                registerFlower(item);
            }
        }
    }

    @Override
    public void registerFlowerBlocks(Collection<Block> flowerBlocks) {
        if (flowerBlocks != null) {
            for (Block block : flowerBlocks) {
                registerFlowerBlock(block);
            }
        }
    }

    @Override
    public void registerCustomFlower(FlowerData flowerData) {
        Objects.requireNonNull(flowerData, "FlowerData cannot be null");
        registerFlower(flowerData.item());
        registerFlowerBlock(flowerData.block());
        MoFlowersEvents.invokeFlowerRegistration(flowerData);
    }

    @Override
    public boolean isMoFlower(Item item) {
        return item != null && FlowerRegistry.isRegisteredFlower(item);
    }

    @Override
    public boolean isMoFlowerBlock(Block block) {
        return block != null && FlowerRegistry.isRegisteredFlowerBlock(block);
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
    public Optional<Item> getFlowersChestItem() {
        return Optional.ofNullable(ModItems.FLOWERS_CHEST);
    }

    @Override
    public Optional<Block> getFlowersChestBlock() {
        return Optional.ofNullable(ModBlocks.FLOWERS_CHEST);
    }

    @Override
    public void registerFlowerRegistrationCallback(IFlowerRegistrationCallback callback) {
        MoFlowersEvents.registerFlowerRegistrationCallback(callback);
    }
}
