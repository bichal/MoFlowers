/*
 * Copyright (c) 2025 Bichal.
 * All rights reserved.
 */

package net.bichal.moflowers.screen;

import net.bichal.moflowers.api.flowers.FlowerRegistry;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.slot.Slot;

public class RestrictedSlot extends Slot {
    public RestrictedSlot(Inventory inventory, int index, int x, int y) {
        super(inventory, index, x, y);
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return stack.isIn(FlowerRegistry.FLOWERS_TAG);
    }

    @Override
    public void setStack(ItemStack stack) {
        if (canInsert(stack)) {
            super.setStack(stack);
        }
    }
}
