/*
 * Copyright (c) 2025 Bichal.
 * All rights reserved.
 */

package net.bichal.moflowers.client;

import net.bichal.moflowers.blocks.ModBlocks;
import net.bichal.moflowers.blocks.entity.ModBlockEntities;
import net.bichal.moflowers.client.render.FlowersChestBlockEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.rendering.v1.ColorProviderRegistry;
import net.minecraft.block.BlockState;
import net.minecraft.block.IceBlock;
import net.minecraft.client.color.world.BiomeColors;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactories;
import net.minecraft.fluid.FluidState;
import net.minecraft.fluid.Fluids;
import net.minecraft.world.biome.BiomeKeys;
import net.minecraft.world.biome.GrassColors;

public class MoFlowersClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        registerRenderLayersCutout();
        registerColorProviders();
        registerBlockEntityRenderers();
    }

    public void registerRenderLayersCutout() {
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.OPEN_PALE_WILDFLOWERS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CLOSED_PALE_WILDFLOWERS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MAGENTA_PETALS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.MOON_CACTUS_FLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LILY_PAD_FLOWER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SUNFLOWERS, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.TALL_LAVENDER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.LAVENDER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.WILD_FIREFLY_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_LAVENDER, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.CALENDULA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.POTTED_CALENDULA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.FOXGLOVE, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.HEBEA, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SWEET_BLUE_BERRY_BUSH, RenderLayer.getCutout());
        BlockRenderLayerMap.INSTANCE.putBlock(ModBlocks.SWEET_GLOW_BERRY_BUSH, RenderLayer.getCutout());
    }

    public void registerColorProviders() {
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            if (tintIndex != 0) {
                return world != null && pos != null ? BiomeColors.getGrassColor(world, pos) : GrassColors.getDefaultColor();
            }
            else {
                return -1;
            }
        }, ModBlocks.OPEN_PALE_WILDFLOWERS, ModBlocks.CLOSED_PALE_WILDFLOWERS, ModBlocks.MAGENTA_PETALS, ModBlocks.LAVENDER, ModBlocks.TALL_LAVENDER, ModBlocks.CALENDULA, ModBlocks.FOXGLOVE, ModBlocks.HEBEA);
        ColorProviderRegistry.BLOCK.register((state, world, pos, tintIndex) -> {
            if (tintIndex != 0) {
                if (world != null && pos != null) {
                    if (world.getBiomeFabric(pos).matchesKey(BiomeKeys.SWAMP)) {
                        FluidState downState = world.getFluidState(pos.down());
                        FluidState upState = world.getFluidState(pos.up());
                        BlockState downBlock = world.getBlockState(pos.down());

                        if ((downState.getFluid() == Fluids.WATER || downBlock.getBlock() instanceof IceBlock) && upState.getFluid() == Fluids.EMPTY) {
                            return 0x208030;
                        }
                    }
                    return BiomeColors.getGrassColor(world, pos);
                }
                else {
                    return GrassColors.getDefaultColor();
                }
            }
            else {
                return -1;
            }
        }, ModBlocks.LILY_PAD_FLOWER);
    }

    private void registerBlockEntityRenderers() {
        BlockEntityRendererFactories.register(ModBlockEntities.FLOWERS_CHEST_BLOCK_ENTITY, FlowersChestBlockEntityRenderer::new);
    }
}
