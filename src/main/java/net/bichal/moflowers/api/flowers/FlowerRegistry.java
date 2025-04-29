/*
 * Copyright (c) 2025 Bichal.
 * All rights reserved.
 */

package net.bichal.moflowers.api.flowers;

import net.bichal.moflowers.MoFlowers;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.HashSet;
import java.util.Set;

/**
 * Registry for flowers and flower blocks in the mod
 * Provides methods to register and check for registered flowers and blocks.
 */
public class FlowerRegistry {
    public static final TagKey<Item> FLOWERS_TAG = TagKey.of(RegistryKeys.ITEM, Identifier.of(MoFlowers.MOD_ID, "mo_flowers"));
    public static final TagKey<Block> FLOWER_BLOCKS_TAG = TagKey.of(RegistryKeys.BLOCK, Identifier.of(MoFlowers.MOD_ID, "flower_blocks"));

    private static final Set<Item> registeredFlowers = new HashSet<>();
    private static final Set<Block> registeredFlowerBlocks = new HashSet<>();

    /**
     * Registers a flower item.
     *
     * @param flower The item to register as a flower.
     */
    public static void registerFlower(Item flower) {
        registeredFlowers.add(flower);
    }

    /**
     * Registers a flower block.
     *
     * @param block The block to register as a flower block.
     */
    public static void registerFlowerBlock(Block block) {
        registeredFlowerBlocks.add(block);
    }

    /**
     * Checks if an item is a registered flower.
     *
     * @param item The item to check.
     * @return True if the item is registered as a flower, false otherwise.
     */
    public static boolean isRegisteredFlower(Item item) {
        return registeredFlowers.contains(item);
    }

    /**
     * Checks if a block is a registered flower block.
     *
     * @param block The block to check.
     * @return True if the block is registered as a flower block, false otherwise.
     */
    public static boolean isRegisteredFlowerBlock(Block block) {
        return registeredFlowerBlocks.contains(block);
    }
}
