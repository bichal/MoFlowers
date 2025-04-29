/*
 * Copyright (c) 2025 Bichal.
 * All rights reserved.
 */

package net.bichal.moflowers.blocks;

import net.bichal.moflowers.MoFlowers;
import net.bichal.moflowers.api.flowers.FlowerRegistry;
import net.bichal.moflowers.blocks.entity.ModBlockEntities;
import net.minecraft.block.*;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.util.Identifier;

import java.util.function.Function;

public class ModBlocks {
    public static final Block OPEN_PALE_WILDFLOWERS = registerBlock("open_pale_wildflowers", settings -> new PaleWildFlowersBlock(PaleWildFlowersBlock.PaleWildFlowersState.OPEN, settings), AbstractBlock.Settings
            .copy(Blocks.WILDFLOWERS).mapColor(Blocks.CREAKING_HEART.getDefaultMapColor())
            .luminance(state -> (state.get(FlowerbedBlock.FLOWER_AMOUNT))).ticksRandomly());
    public static final Block CLOSED_PALE_WILDFLOWERS = registerBlock("closed_pale_wildflowers", settings -> new PaleWildFlowersBlock(PaleWildFlowersBlock.PaleWildFlowersState.CLOSED, settings), AbstractBlock.Settings
            .copy(Blocks.WILDFLOWERS).mapColor(Blocks.PALE_OAK_LEAVES.getDefaultMapColor()).ticksRandomly());
    public static final Block MAGENTA_PETALS = registerBlock("magenta_petals", FlowerbedBlock::new, AbstractBlock.Settings.copy(Blocks.PINK_PETALS));
    public static final Block MOON_CACTUS_FLOWER = registerBlock("moon_cactus_flower", CactusFlowerBlock::new, AbstractBlock.Settings.copy(Blocks.CACTUS_FLOWER));
    public static final Block LILY_PAD_FLOWER = registerBlock("lily_pad_flower", LilyPadBlock::new, AbstractBlock.Settings
            .copy(Blocks.LILY_PAD).mapColor(MapColor.PINK));
    public static final Block SUNFLOWERS = registerBlock("sunflowers", TallFlowerBlock::new, AbstractBlock.Settings.copy(Blocks.SUNFLOWER));
    public static final Block WILD_FIREFLY_BUSH = registerBlock("wild_firefly_bush", FireflyBushBlock::new, AbstractBlock.Settings.copy(Blocks.FIREFLY_BUSH));
    public static final Block LAVENDER = registerBlock("lavender", settings -> new FlowerBlock(StatusEffects.INSTANT_HEALTH, 1F, settings), AbstractBlock.Settings.copy(Blocks.DANDELION));
    public static final Block CALENDULA = registerBlock("calendula", settings -> new FlowerBlock(StatusEffects.BLINDNESS, 0.35F, settings), AbstractBlock.Settings.copy(Blocks.DANDELION));
    public static final Block POTTED_LAVENDER = registerBlock("potted_lavender", settings -> new FlowerPotBlock(LAVENDER, settings), createFlowerPotSettings());
    public static final Block POTTED_CALENDULA = registerBlock("potted_calendula", settings -> new FlowerPotBlock(CALENDULA, settings), createFlowerPotSettings());
    public static final Block TALL_LAVENDER = registerBlock("tall_lavender", TallFlowerBlock::new, AbstractBlock.Settings.copy(Blocks.DANDELION));
    public static final Block FOXGLOVE = registerBlock("foxglove", TallFlowerBlock::new, AbstractBlock.Settings.copy(Blocks.DANDELION));
    public static final Block HEBEA = registerBlock("hebea", settings -> new FlowerBlock(StatusEffects.NAUSEA, 1.2F, settings), AbstractBlock.Settings.copy(Blocks.DANDELION));
    public static final Block POTTED_HEBEA = registerBlock("potted_hebea", settings -> new FlowerPotBlock(HEBEA, settings), createFlowerPotSettings());
    public static final Block SWEET_BLUE_BERRY_BUSH = registerBlock("sweet_blue_berry_bush", SweetBlueBerryBushBlock::new, AbstractBlock.Settings.copy(Blocks.SWEET_BERRY_BUSH));
    public static final Block SWEET_GLOW_BERRY_BUSH = registerBlock("sweet_glow_berry_bush", SweetGlowBerryBushBlock::new, AbstractBlock.Settings
            .copy(Blocks.SWEET_BERRY_BUSH)
            .luminance(state -> state.get(SweetGlowBerryBushBlock.AGE) == 2 ? 7 : state.get(SweetGlowBerryBushBlock.AGE) == 3 ? 14 : 0));
    public static final Block FLOWERS_CHEST = registerBlock("flowers_chest", settings -> new FlowersChestBlock(() -> ModBlockEntities.FLOWERS_CHEST_BLOCK_ENTITY, settings), AbstractBlock.Settings.copy(Blocks.CHEST));

    public static Block registerBlock(RegistryKey<Block> key, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Block block = factory.apply(settings.registryKey(key));
        return Registry.register(Registries.BLOCK, key, block);
    }

    private static RegistryKey<Block> keyOf(String id) {
        return RegistryKey.of(RegistryKeys.BLOCK, Identifier.of(MoFlowers.MOD_ID, id));
    }

    private static Block registerBlock(String id, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Block block = registerBlock(keyOf(id), factory, settings);

        if (block instanceof FlowerBlock || block instanceof TallFlowerBlock || block instanceof FlowerbedBlock) {
            FlowerRegistry.registerFlowerBlock(block);
        }

        return block;
    }

    public static AbstractBlock.Settings createFlowerPotSettings() {
        return AbstractBlock.Settings.create().breakInstantly().nonOpaque().pistonBehavior(PistonBehavior.DESTROY);
    }

    public static void register() {
        MoFlowers.LOGGER.info("[{}] ModBlocks initialized", MoFlowers.MOD_NAME);
    }
}
