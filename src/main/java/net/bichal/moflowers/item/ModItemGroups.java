/*
 * Copyright (c) 2025 Bichal.
 * All rights reserved.
 */
package net.bichal.moflowers.item;

import net.bichal.moflowers.MoFlowers;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

@SuppressWarnings("unused")
public class ModItemGroups {
    public static final ItemGroup MOFLOWERS_ITEM_GROUP = Registry.register(Registries.ITEM_GROUP, Identifier.of(MoFlowers.MOD_ID, "moflowers_items"), FabricItemGroup
            .builder().icon(() -> new ItemStack(ModItems.OPEN_PALE_WILDFLOWERS))
            .displayName(Text.translatable("itemGroup.moflowers")).entries((displayContext, entries) -> {
                entries.add(ModItems.FLOWERS_CHEST);
                entries.add(ModItems.CLOSED_PALE_WILDFLOWERS);
                entries.add(ModItems.OPEN_PALE_WILDFLOWERS);
                entries.add(ModItems.MAGENTA_PETALS);
                entries.add(ModItems.MOON_CACTUS_FLOWER);
                entries.add(ModItems.LILY_PAD_FLOWER);
                entries.add(ModItems.SUNFLOWERS);
                entries.add(ModItems.WILD_FIREFLY_BUSH);
                entries.add(ModItems.LAVENDER);
                entries.add(ModItems.TALL_LAVENDER);
                entries.add(ModItems.CALENDULA);
                entries.add(ModItems.FOXGLOVE);
                entries.add(ModItems.HEBEA);
                entries.add(ModItems.SWEET_BLUE_BERRIES);
                entries.add(ModItems.SWEET_GLOW_BERRIES);
            }).build());

    public static void register() {
    }
}
