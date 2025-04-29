/*
 * Copyright (c) 2025 Bichal.
 * All rights reserved.
 */

package net.bichal.moflowers.client.render;

import net.bichal.moflowers.MoFlowers;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.block.enums.ChestType;
import net.minecraft.client.render.TexturedRenderLayers;
import net.minecraft.client.util.SpriteIdentifier;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ModTexturedRenderLayers {
    public static final Identifier FLOWERS_CHEST = Identifier.of(MoFlowers.MOD_ID, "entity/chest/flowers");
    public static final Identifier FLOWERS_CHEST_LEFT = Identifier.of(MoFlowers.MOD_ID, "entity/chest/flowers_left");
    public static final Identifier FLOWERS_CHEST_RIGHT = Identifier.of(MoFlowers.MOD_ID, "entity/chest/flowers_right");

    public static final SpriteIdentifier FLOWERS_CHEST_SPRITE = new SpriteIdentifier(TexturedRenderLayers.CHEST_ATLAS_TEXTURE, FLOWERS_CHEST);
    public static final SpriteIdentifier FLOWERS_CHEST_LEFT_SPRITE = new SpriteIdentifier(TexturedRenderLayers.CHEST_ATLAS_TEXTURE, FLOWERS_CHEST_LEFT);
    public static final SpriteIdentifier FLOWERS_CHEST_RIGHT_SPRITE = new SpriteIdentifier(TexturedRenderLayers.CHEST_ATLAS_TEXTURE, FLOWERS_CHEST_RIGHT);

    public static SpriteIdentifier getFlowersChestTextureId(ChestType type) {
        return switch (type) {
            case LEFT -> FLOWERS_CHEST_LEFT_SPRITE;
            case RIGHT -> FLOWERS_CHEST_RIGHT_SPRITE;
            default -> FLOWERS_CHEST_SPRITE;
        };
    }
}