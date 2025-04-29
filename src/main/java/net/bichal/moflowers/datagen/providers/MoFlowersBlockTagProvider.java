/*
 * Copyright (c) 2025 Bichal.
 * All rights reserved.
 */

package net.bichal.moflowers.datagen.providers;

import net.bichal.moflowers.blocks.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class MoFlowersBlockTagProvider extends FabricTagProvider<Block> {
    public static final TagKey<Block> FLOWERS = TagKey.of(RegistryKeys.BLOCK, Identifier.of("c", "flowers"));
    public static final TagKey<Block> MO_FLOWERS = TagKey.of(RegistryKeys.BLOCK, Identifier.of("c", "mo_flowers"));
    public static final TagKey<Block> TALL_FLOWERS = TagKey.of(RegistryKeys.BLOCK, Identifier.of("c", "flowers/tall"));
    public static final TagKey<Block> SMALL_FLOWERS = TagKey.of(RegistryKeys.BLOCK, Identifier.of("c", "flowers/small"));

    public MoFlowersBlockTagProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, RegistryKeys.BLOCK, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        Block[] Small = new Block[]{ModBlocks.CLOSED_PALE_WILDFLOWERS, ModBlocks.OPEN_PALE_WILDFLOWERS, ModBlocks.MAGENTA_PETALS, ModBlocks.MOON_CACTUS_FLOWER, ModBlocks.LAVENDER, ModBlocks.CALENDULA, ModBlocks.LILY_PAD_FLOWER, ModBlocks.HEBEA};
        Block[] Tall = new Block[]{ModBlocks.SUNFLOWERS, ModBlocks.TALL_LAVENDER, ModBlocks.FOXGLOVE};

        getOrCreateTagBuilder(BlockTags.FLOWERS).add(Tall).add(Small);
        getOrCreateTagBuilder(MO_FLOWERS).add(Tall).add(Small);
        getOrCreateTagBuilder(FLOWERS).addTag(MO_FLOWERS);
        getOrCreateTagBuilder(BlockTags.SMALL_FLOWERS).add(Small);
        getOrCreateTagBuilder(SMALL_FLOWERS).add(Small);
        getOrCreateTagBuilder(TALL_FLOWERS).add(Tall);
        getOrCreateTagBuilder(BlockTags.BEE_ATTRACTIVE).addTag(MO_FLOWERS);
        getOrCreateTagBuilder(BlockTags.INSIDE_STEP_SOUND_BLOCKS).add(ModBlocks.CLOSED_PALE_WILDFLOWERS, ModBlocks.OPEN_PALE_WILDFLOWERS, ModBlocks.MAGENTA_PETALS, ModBlocks.LILY_PAD_FLOWER);
        getOrCreateTagBuilder(BlockTags.WALL_POST_OVERRIDE).add(ModBlocks.MOON_CACTUS_FLOWER);
        getOrCreateTagBuilder(BlockTags.ENDERMAN_HOLDABLE).add(ModBlocks.MOON_CACTUS_FLOWER);
        getOrCreateTagBuilder(BlockTags.FROG_PREFER_JUMP_TO).add(ModBlocks.LILY_PAD_FLOWER);
        getOrCreateTagBuilder(BlockTags.FEATURES_CANNOT_REPLACE).add(ModBlocks.FLOWERS_CHEST);
        getOrCreateTagBuilder(BlockTags.REPLACEABLE_BY_TREES).addTag(MO_FLOWERS).add(ModBlocks.WILD_FIREFLY_BUSH);
        getOrCreateTagBuilder(BlockTags.REPLACEABLE_BY_MUSHROOMS).addTag(MO_FLOWERS).add(ModBlocks.WILD_FIREFLY_BUSH);
        getOrCreateTagBuilder(BlockTags.BEE_GROWABLES).add(ModBlocks.SWEET_BLUE_BERRY_BUSH)
                .add(ModBlocks.SWEET_GLOW_BERRY_BUSH);
        getOrCreateTagBuilder(BlockTags.FALL_DAMAGE_RESETTING).add(ModBlocks.SWEET_BLUE_BERRY_BUSH)
                .add(ModBlocks.SWEET_GLOW_BERRY_BUSH);
    }
}