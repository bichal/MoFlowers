/*
 * Copyright (c) 2025 Bichal.
 * All rights reserved.
 */

package net.bichal.moflowers.screen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.screen.slot.Slot;

public class FlowersChestScreenHandler extends GenericContainerScreenHandler {
    private final Inventory inventory;
    private final int rows;

    public FlowersChestScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory, int rows) {
        super(rows == 3 ? ScreenHandlerType.GENERIC_9X3 : ScreenHandlerType.GENERIC_9X6, syncId, playerInventory, inventory, rows);
        this.inventory = inventory;
        this.rows = rows;
        this.slots.clear();

        for (int i = 0; i < rows; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new RestrictedSlot(inventory, j + i * 9, 8 + j * 18, 18 + i * 18));
            }
        }
        int yOffset = (rows - 4) * 18;
        for (int i = 0; i < 3; ++i) {
            for (int j = 0; j < 9; ++j) {
                this.addSlot(new Slot(playerInventory, j + i * 9 + 9, 8 + j * 18, 103 + i * 18 + yOffset));
            }
        }

        for (int i = 0; i < 9; ++i) {
            this.addSlot(new Slot(playerInventory, i, 8 + i * 18, 161 + yOffset));
        }
    }

    @Override
    public boolean canInsertIntoSlot(ItemStack stack, Slot slot) {
        if (slot.inventory == this.inventory) {
            return slot.canInsert(stack);
        }
        return true;
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slotIndex) {
        Slot slot = this.slots.get(slotIndex);
        if (!slot.hasStack()) {
            return ItemStack.EMPTY;
        }
        ItemStack stackInSlot = slot.getStack();

        if (slotIndex >= this.rows * 9) {
            if (!this.slots.getFirst().canInsert(stackInSlot)) {
                return ItemStack.EMPTY;
            }

            if (!this.insertItem(stackInSlot, 0, this.rows * 9, false)) {
                return ItemStack.EMPTY;
            }
        }
        else {
            if (!this.insertItem(stackInSlot, this.rows * 9, this.slots.size(), true)) {
                return ItemStack.EMPTY;
            }
        }

        if (stackInSlot.isEmpty()) {
            slot.setStack(ItemStack.EMPTY);
        }
        else {
            slot.markDirty();
        }

        return stackInSlot.copy();
    }
}