/*
 * Copyright (c) 2025 Bichal.
 * All rights reserved.
 */

package net.bichal.moflowers.item;

import net.bichal.moflowers.MoFlowers;
import net.bichal.moflowers.api.flowers.FlowerRegistry;
import net.bichal.moflowers.blocks.ModBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.FlowerBlock;
import net.minecraft.block.FlowerbedBlock;
import net.minecraft.block.TallFlowerBlock;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.ContainerComponent;
import net.minecraft.component.type.FoodComponents;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.PlaceableOnWaterItem;
import net.minecraft.item.TallBlockItem;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.UnaryOperator;

public class ModItems {
    public static final Item CLOSED_PALE_WILDFLOWERS = registerItem(ModBlocks.CLOSED_PALE_WILDFLOWERS);
    public static final Item OPEN_PALE_WILDFLOWERS = registerItem(ModBlocks.OPEN_PALE_WILDFLOWERS);
    public static final Item MAGENTA_PETALS = registerItem(ModBlocks.MAGENTA_PETALS);
    public static final Item MOON_CACTUS_FLOWER = registerItem(ModBlocks.MOON_CACTUS_FLOWER);
    public static final Item LILY_PAD_FLOWER = registerItem(ModBlocks.LILY_PAD_FLOWER, PlaceableOnWaterItem::new);
    public static final Item SUNFLOWERS = registerItem(ModBlocks.SUNFLOWERS, TallBlockItem::new);
    public static final Item WILD_FIREFLY_BUSH = registerItem(ModBlocks.WILD_FIREFLY_BUSH);
    public static final Item CALENDULA = registerItem(ModBlocks.CALENDULA);
    public static final Item LAVENDER = registerItem(ModBlocks.LAVENDER);
    public static final Item HEBEA = registerItem(ModBlocks.HEBEA);
    public static final Item TALL_LAVENDER = registerItem(ModBlocks.TALL_LAVENDER, TallBlockItem::new);
    public static final Item FOXGLOVE = registerItem(ModBlocks.FOXGLOVE, TallBlockItem::new);
    public static final Item SWEET_BLUE_BERRIES = registerItem("sweet_blue_berries", createBlockItemWithUniqueName(ModBlocks.SWEET_BLUE_BERRY_BUSH), new Item.Settings().food(FoodComponents.SWEET_BERRIES));
    public static final Item SWEET_GLOW_BERRIES = registerItem("sweet_glow_berries", createBlockItemWithUniqueName(ModBlocks.SWEET_GLOW_BERRY_BUSH), new Item.Settings().food(FoodComponents.SWEET_BERRIES));
    public static final Item FLOWERS_CHEST = registerItem(ModBlocks.FLOWERS_CHEST, settings -> settings.component(DataComponentTypes.CONTAINER, ContainerComponent.DEFAULT));

    private static RegistryKey<Item> keyOf(String id) {
        return RegistryKey.of(RegistryKeys.ITEM, Identifier.of(MoFlowers.MOD_ID, id));
    }

    private static Function<Item.Settings, Item> createBlockItemWithUniqueName(Block block) {
        return settings -> new BlockItem(block, settings.useItemPrefixedTranslationKey());
    }

    public static Item registerItem(Block block) {
        return registerItem(block, BlockItem::new);
    }

    public static Item registerItem(Block block, UnaryOperator<Item.Settings> settingsOperator) {
        return registerItem(block, (blockx, settings) -> new BlockItem(blockx, settingsOperator.apply(settings)));
    }

    public static Item registerItem(String id, Function<Item.Settings, Item> factory, Item.Settings settings) {
        return registerItem(keyOf(id), factory, settings);
    }

    public static Item registerItem(Block block, BiFunction<Block, Item.Settings, Item> factory) {
        return registerItem(block, factory, new Item.Settings());
    }

    public static Item registerItem(Block block, BiFunction<Block, Item.Settings, Item> factory, Item.Settings settings) {
        Item item = registerItem(Registries.BLOCK.getKey(block)
                                         .map(blockKey -> RegistryKey.of(RegistryKeys.ITEM, blockKey.getValue()))
                                         .orElseThrow(() -> new IllegalStateException("No registry key found for block: " + block)), itemSettings -> factory.apply(block, itemSettings), settings.useBlockPrefixedTranslationKey());

        if (block instanceof FlowerBlock || block instanceof TallFlowerBlock || block instanceof FlowerbedBlock) {
            FlowerRegistry.registerFlower(item);
        }

        return item;
    }

    public static Item registerItem(RegistryKey<Item> key, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Item item = factory.apply(settings.registryKey(key));
        if (item instanceof BlockItem blockItem) {
            blockItem.appendBlocks(Item.BLOCK_ITEMS, item);
        }

        return Registry.register(Registries.ITEM, key, item);
    }

    public static void register() {
        MoFlowers.LOGGER.info("[{}] ModItems initialized", MoFlowers.MOD_NAME);
    }
}
