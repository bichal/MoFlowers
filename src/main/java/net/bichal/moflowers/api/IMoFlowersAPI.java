/*
 * Copyright (c) 2025 Bichal.
 * All rights reserved.
 */

package net.bichal.moflowers.api;

import net.bichal.moflowers.api.event.IFlowerRegistrationCallback;
import net.bichal.moflowers.api.flowers.FlowerData;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;

public interface IMoFlowersAPI {
    /**
     * Registers a new flower item as a mod flower.
     *
     * @param flowerItem The item to register.
     */
    void registerFlower(Item flowerItem);

    /**
     * Registers a new flower block as a mod flower.
     *
     * @param flowerBlock The block to register.
     */
    void registerFlowerBlock(Block flowerBlock);

    /**
     * Registers a custom flower with detailed data.
     *
     * @param flowerData The flower data to register.
     */
    void registerCustomFlower(FlowerData flowerData);

    /**
     * Checks if the given item is a registered mod flower.
     *
     * @param item The item to check.
     * @return True if the item is a MoFlower, false otherwise.
     */
    boolean isMoFlower(Item item);

    /**
     * Checks if the given block is a registered MoFlower block.
     *
     * @param block The block to check.
     * @return True if the block is a MoFlower block, false otherwise.
     */
    boolean isMoFlowerBlock(Block block);

    /**
     * Gets the tag containing all MoFlowers items.
     *
     * @return The item tag for MoFlowers.
     */
    TagKey<Item> getFlowersTag();

    /**
     * Gets the tag containing all MoFlowers blocks.
     *
     * @return The block tag for MoFlowers.
     */
    TagKey<Block> getFlowerBlocksTag();

    /**
     * Gets the item for the Flowers Chest.
     *
     * @return The Flowers Chest item.
     */
    Item getFlowersChestItem();

    /**
     * Gets the block for the Flowers Chest.
     *
     * @return The Flowers Chest block.
     */
    Block getFlowersChestBlock();

    /**
     * Registers a callback to be invoked when a flower is registered.
     *
     * @param callback The callback to register.
     */
    void registerFlowerRegistrationCallback(IFlowerRegistrationCallback callback);
}
