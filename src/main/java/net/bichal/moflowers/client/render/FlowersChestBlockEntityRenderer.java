/*
 * Copyright (c) 2025 Bichal.
 * All rights reserved.
 */

package net.bichal.moflowers.client.render;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.*;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.block.enums.ChestType;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.block.entity.BlockEntityRendererFactory;
import net.minecraft.client.render.block.entity.ChestBlockEntityRenderer;
import net.minecraft.client.render.block.entity.LightmapCoordinatesRetriever;
import net.minecraft.client.render.block.entity.model.ChestBlockModel;
import net.minecraft.client.render.entity.model.EntityModelLayers;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.RotationAxis;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;

@Environment(EnvType.CLIENT)
public class FlowersChestBlockEntityRenderer<T extends ChestBlockEntity> extends ChestBlockEntityRenderer<T> {
    private final ChestBlockModel singleChest;
    private final ChestBlockModel doubleChestLeft;
    private final ChestBlockModel doubleChestRight;

    public FlowersChestBlockEntityRenderer(BlockEntityRendererFactory.Context context) {
        super(context);
        this.singleChest = new ChestBlockModel(context.getLayerModelPart(EntityModelLayers.CHEST));
        this.doubleChestLeft = new ChestBlockModel(context.getLayerModelPart(EntityModelLayers.DOUBLE_CHEST_LEFT));
        this.doubleChestRight = new ChestBlockModel(context.getLayerModelPart(EntityModelLayers.DOUBLE_CHEST_RIGHT));
    }

    @Override
    public void render(T entity, float tickProgress, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, int overlay, Vec3d cameraPos) {
        World world = entity.getWorld();
        boolean bl = world != null;
        BlockState blockState = bl ? entity.getCachedState() : Blocks.CHEST.getDefaultState()
                .with(ChestBlock.FACING, Direction.SOUTH);
        ChestType chestType = blockState.contains(ChestBlock.CHEST_TYPE) ? blockState.get(ChestBlock.CHEST_TYPE) : ChestType.SINGLE;
        if (blockState.getBlock() instanceof AbstractChestBlock<?> abstractChestBlock) {
            boolean bl2 = chestType != ChestType.SINGLE;
            matrices.push();
            float f = blockState.get(ChestBlock.FACING).getPositiveHorizontalDegrees();
            matrices.translate(0.5F, 0.5F, 0.5F);
            matrices.multiply(RotationAxis.POSITIVE_Y.rotationDegrees(-f));
            matrices.translate(-0.5F, -0.5F, -0.5F);
            DoubleBlockProperties.PropertySource<? extends ChestBlockEntity> propertySource;
            if (bl) {
                propertySource = abstractChestBlock.getBlockEntitySource(blockState, world, entity.getPos(), true);
            }
            else {
                propertySource = DoubleBlockProperties.PropertyRetriever::getFallback;
            }

            float g = propertySource.apply(ChestBlock.getAnimationProgressRetriever(entity)).get(tickProgress);
            g = 1.0F - g;
            g = 1.0F - g * g * g;
            int i = propertySource.apply(new LightmapCoordinatesRetriever<>()).applyAsInt(light);
            SpriteIdentifier spriteIdentifier = ModTexturedRenderLayers.getFlowersChestTextureId(chestType);
            VertexConsumer vertexConsumer = spriteIdentifier.getVertexConsumer(vertexConsumers, RenderLayer::getEntityCutout);
            if (bl2) {
                if (chestType == ChestType.LEFT) {
                    this.render(matrices, vertexConsumer, this.doubleChestLeft, g, i, overlay);
                }
                else {
                    this.render(matrices, vertexConsumer, this.doubleChestRight, g, i, overlay);
                }
            }
            else {
                this.render(matrices, vertexConsumer, this.singleChest, g, i, overlay);
            }

            matrices.pop();
        }
    }

    private void render(MatrixStack matrices, VertexConsumer vertices, ChestBlockModel model, float animationProgress, int light, int overlay) {
        model.setLockAndLidPitch(animationProgress);
        model.render(matrices, vertices, light, overlay);
    }
}
