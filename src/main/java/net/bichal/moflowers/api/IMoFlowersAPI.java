package net.bichal.moflowers.api;

import net.bichal.moflowers.api.event.IFlowerRegistrationCallback;
import net.bichal.moflowers.api.flowers.FlowerData;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.tag.TagKey;

import java.util.Collection;
import java.util.Optional;

public interface IMoFlowersAPI {
    /**
     * Registers a new item as a flower of the mod.
     */
    void registerFlower(Item flowerItem);

    /**
     * Registers a new block as a flower of the mod.
     */
    void registerFlowerBlock(Block flowerBlock);

    /**
     * Registers multiple items as flowers of the mod.
     */
    void registerFlowers(Collection<Item> flowerItems);

    /**
     * Registers multiple blocks as flowers of the mod.
     */
    void registerFlowerBlocks(Collection<Block> flowerBlocks);

    /**
     * Registers a custom flower with detailed data.
     */
    void registerCustomFlower(FlowerData flowerData);

    /**
     * Checks if the item is registered as a mod flower.
     */
    boolean isMoFlower(Item item);

    /**
     * Checks if the block is registered as a mod flower.
     */
    boolean isMoFlowerBlock(Block block);

    /**
     * Returns the tag for mod flower items.
     */
    TagKey<Item> getFlowersTag();

    /**
     * Returns the tag for mod flower blocks.
     */
    TagKey<Block> getFlowerBlocksTag();

    /**
     * Returns the flower chest item, if present.
     */
    Optional<Item> getFlowersChestItem();

    /**
     * Returns the flower chest block, if present.
     */
    Optional<Block> getFlowersChestBlock();

    /**
     * Registers a callback invoked when a flower is registered.
     */
    void registerFlowerRegistrationCallback(IFlowerRegistrationCallback callback);
}
