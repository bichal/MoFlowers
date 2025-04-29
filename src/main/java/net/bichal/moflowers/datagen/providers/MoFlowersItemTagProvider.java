/*
 * Copyright (c) 2025 Bichal.
 * All rights reserved.
 */

package net.bichal.moflowers.datagen.providers;

import net.bichal.moflowers.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class MoFlowersItemTagProvider extends FabricTagProvider<Item> {
    public static final TagKey<Item> FLOWERS = TagKey.of(RegistryKeys.ITEM, Identifier.of("c", "flowers"));
    public static final TagKey<Item> MO_FLOWERS = TagKey.of(RegistryKeys.ITEM, Identifier.of("c", "mo_flowers"));
    public static final TagKey<Item> TALL_FLOWERS = TagKey.of(RegistryKeys.ITEM, Identifier.of("c", "flowers/tall"));
    public static final TagKey<Item> SMALL_FLOWERS = TagKey.of(RegistryKeys.ITEM, Identifier.of("c", "flowers/small"));

    public MoFlowersItemTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.ITEM, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        Item[] Small = new Item[]{ModItems.CLOSED_PALE_WILDFLOWERS, ModItems.OPEN_PALE_WILDFLOWERS, ModItems.MAGENTA_PETALS, ModItems.LAVENDER, ModItems.CALENDULA, ModItems.HEBEA, ModItems.LILY_PAD_FLOWER};
        Item[] Tall = new Item[]{ModItems.SUNFLOWERS, ModItems.TALL_LAVENDER, ModItems.FOXGLOVE};

        getOrCreateTagBuilder(ItemTags.FLOWERS).add(Tall).add(Small).add(ModItems.MOON_CACTUS_FLOWER);
        getOrCreateTagBuilder(MO_FLOWERS).add(Tall).add(Small).add(ModItems.MOON_CACTUS_FLOWER);
        getOrCreateTagBuilder(FLOWERS).addTag(MO_FLOWERS);
        getOrCreateTagBuilder(ItemTags.SMALL_FLOWERS).add(Small);
        getOrCreateTagBuilder(SMALL_FLOWERS).add(Small);
        getOrCreateTagBuilder(TALL_FLOWERS).add(Tall);
        getOrCreateTagBuilder(ItemTags.FOX_FOOD).add(ModItems.SWEET_BLUE_BERRIES).add(ModItems.SWEET_GLOW_BERRIES);
        getOrCreateTagBuilder(ItemTags.BEE_FOOD).addTag(MO_FLOWERS);
    }
}