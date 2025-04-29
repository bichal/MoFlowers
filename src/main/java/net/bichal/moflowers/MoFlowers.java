/*
 * Copyright (c) 2025 Bichal.
 * All rights reserved.
 */

package net.bichal.moflowers;

import net.bichal.moflowers.api.IMoFlowersAPI;
import net.bichal.moflowers.api.MoFlowersAPI;
import net.bichal.moflowers.api.flowers.FlowerData;
import net.bichal.moflowers.api.impl.MoFlowersAPIImpl;
import net.bichal.moflowers.blocks.ModBlocks;
import net.bichal.moflowers.blocks.entity.ModBlockEntities;
import net.bichal.moflowers.item.ModItemGroups;
import net.bichal.moflowers.item.ModItems;
import net.bichal.moflowers.world.gen.ModWorldGeneration;
import net.fabricmc.api.ModInitializer;
import net.minecraft.block.Block;
import net.minecraft.block.LilyPadBlock;
import net.minecraft.block.TallFlowerBlock;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MoFlowers implements ModInitializer {
    public static final String MOD_ID = MoFlowersAPI.MOD_ID;
    public static final String MOD_NAME = MoFlowersAPI.MOD_NAME;
    public static final Logger LOGGER = LoggerFactory.getLogger(MoFlowers.MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Inicializando MoFlowers");

        MoFlowersAPI.setInstance(new MoFlowersAPIImpl());

        ModBlocks.register();
        ModItems.register();
        ModItemGroups.register();
        ModBlockEntities.register();

        ModWorldGeneration.register();

        registerDefaultFlowers();
    }

    /**
     * Registers all default flowers for the mod using the API.
     * This ensures that all main flowers are available in the flower registry for use in recipes, tags, and other mod features.
     */
    private void registerDefaultFlowers() {
        IMoFlowersAPI api = MoFlowersAPI.getInstance();

        // Main flowers
        registerFlowerFromBlock(api, ModBlocks.OPEN_PALE_WILDFLOWERS, 0xE0D8C5, Identifier.of("minecraft:pale_garden"));
        registerFlowerFromBlock(api, ModBlocks.CLOSED_PALE_WILDFLOWERS, 0x8C7A6D, Identifier.of("minecraft:pale_garden"));
        registerFlowerFromBlock(api, ModBlocks.MAGENTA_PETALS, 0xFF00FF);
        registerFlowerFromBlock(api, ModBlocks.MOON_CACTUS_FLOWER, 0xA020F0, Identifier.of("minecraft:desert"));
        registerFlowerFromBlock(api, ModBlocks.LILY_PAD_FLOWER, 0x208030, Identifier.of("minecraft:swamp"));
        registerFlowerFromBlock(api, ModBlocks.SUNFLOWERS, 0xFFD700, Identifier.of("minecraft:sunflower_plains"));
        registerFlowerFromBlock(api, ModBlocks.WILD_FIREFLY_BUSH, 0x8A2BE2);
        registerFlowerFromBlock(api, ModBlocks.LAVENDER, 0x9370DB);
        registerFlowerFromBlock(api, ModBlocks.TALL_LAVENDER, 0x9370DB);
        registerFlowerFromBlock(api, ModBlocks.CALENDULA, 0xFFB347);
        registerFlowerFromBlock(api, ModBlocks.FOXGLOVE, 0xFF77FF);
        registerFlowerFromBlock(api, ModBlocks.HEBEA, 0xF8BBD0);

        // Berry bushes
        registerFlowerFromBlock(api, ModBlocks.SWEET_BLUE_BERRY_BUSH, 0x4F86F7);
        registerFlowerFromBlock(api, ModBlocks.SWEET_GLOW_BERRY_BUSH, 0xFFD700);

        // Potted variants
        registerFlowerFromBlock(api, ModBlocks.POTTED_LAVENDER, 0x9370DB);
        registerFlowerFromBlock(api, ModBlocks.POTTED_CALENDULA, 0xFFB347);
        registerFlowerFromBlock(api, ModBlocks.POTTED_HEBEA, 0xF8BBD0);
    }

    /**
     * Registers a flower from a block with a given color.
     *
     * @param api   The API instance.
     * @param block The block to register as a flower.
     * @param color The default color of the flower.
     */
    private void registerFlowerFromBlock(IMoFlowersAPI api, Block block, int color) {
        registerFlowerFromBlock(api, block, color, null);
    }

    /**
     * Registers a flower from a block with a given color and optional biome restriction.
     *
     * @param api              The API instance.
     * @param block            The block to register as a flower.
     * @param color            The default color of the flower.
     * @param biomeRestriction The biome restriction for the flower, or null if none.
     */
    private void registerFlowerFromBlock(IMoFlowersAPI api, Block block, int color, Identifier biomeRestriction) {
        Item item = Registries.ITEM.get(Registries.BLOCK.getId(block));
        api.registerCustomFlower(new FlowerData.Builder(item, block).defaultColor(color)
                                         .tallVariant(block instanceof TallFlowerBlock)
                                         .waterPlaceable(block instanceof LilyPadBlock)
                                         .biomeRestriction(biomeRestriction).build());
    }
}
