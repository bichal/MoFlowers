/*
 * Copyright (c) 2025 Bichal.
 * All rights reserved.
 */

package net.bichal.moflowers.api.flowers;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraft.util.Identifier;

/**
 * Immutable data class representing a custom flower in MoFlowers.
 * Use the {@link Builder} to create instances.
 *
 * @param item             The flower item.
 * @param block            The flower block.
 * @param hasTallVariant   Whether the flower has a tall variant.
 * @param isWaterPlaceable Whether the flower can be placed on water.
 * @param defaultColor     The default color of the flower.
 * @param biomeRestriction Optional biome restriction for the flower.
 */
public record FlowerData(Item item, Block block, boolean hasTallVariant, boolean isWaterPlaceable, int defaultColor,
                         Identifier biomeRestriction) {
    /**
     * Builder for {@link FlowerData}.
     */
    public static class Builder {
        private final Item item;
        private final Block block;
        private boolean hasTallVariant = false;
        private boolean isWaterPlaceable = false;
        private int defaultColor = 0xFFFFFF;
        private Identifier biomeRestriction = null;

        /**
         * Creates a new builder for a flower.
         *
         * @param item  The flower item.
         * @param block The flower block.
         */
        public Builder(Item item, Block block) {
            this.item = item;
            this.block = block;
        }

        /**
         * Sets whether the flower has a tall variant.
         *
         * @param tall True if tall variant exists.
         * @return This builder.
         */
        public Builder tallVariant(boolean tall) {
            this.hasTallVariant = tall;
            return this;
        }

        /**
         * Sets whether the flower can be placed on water.
         *
         * @param waterPlaceable True if water placeable.
         * @return This builder.
         */
        public Builder waterPlaceable(boolean waterPlaceable) {
            this.isWaterPlaceable = waterPlaceable;
            return this;
        }

        /**
         * Sets the default color for the flower.
         *
         * @param color The color (ARGB).
         * @return This builder.
         */
        public Builder defaultColor(int color) {
            this.defaultColor = color;
            return this;
        }

        /**
         * Sets a biome restriction for the flower.
         *
         * @param biomeId The biome identifier.
         * @return This builder.
         */
        public Builder biomeRestriction(Identifier biomeId) {
            this.biomeRestriction = biomeId;
            return this;
        }

        /**
         * Builds the {@link FlowerData} instance.
         *
         * @return The built FlowerData.
         */
        public FlowerData build() {
            return new FlowerData(item, block, hasTallVariant, isWaterPlaceable, defaultColor, biomeRestriction);
        }
    }
}
