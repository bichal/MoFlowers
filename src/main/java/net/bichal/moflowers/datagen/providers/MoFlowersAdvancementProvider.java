/*
 * Copyright (c) 2025 Bichal.
 * All rights reserved.
 */

package net.bichal.moflowers.datagen.providers;

import net.bichal.moflowers.MoFlowers;
import net.bichal.moflowers.item.ModItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricAdvancementProvider;
import net.minecraft.advancement.*;
import net.minecraft.advancement.criterion.InventoryChangedCriterion;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;

public class MoFlowersAdvancementProvider extends FabricAdvancementProvider {
    public MoFlowersAdvancementProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(output, registryLookup);
    }

    @Override
    public void generateAdvancement(RegistryWrapper.WrapperLookup wrapperLookup, Consumer<AdvancementEntry> consumer) {
        Item[] items = {ModItems.CLOSED_PALE_WILDFLOWERS, ModItems.OPEN_PALE_WILDFLOWERS, ModItems.MAGENTA_PETALS, ModItems.MOON_CACTUS_FLOWER, ModItems.SUNFLOWERS, ModItems.TALL_LAVENDER, ModItems.LAVENDER, ModItems.LILY_PAD_FLOWER, ModItems.FOXGLOVE, ModItems.CALENDULA, ModItems.HEBEA, ModItems.SWEET_BLUE_BERRIES, ModItems.SWEET_GLOW_BERRIES};

        Advancement.Builder builder = Advancement.Builder.create()
                .display(ModItems.CLOSED_PALE_WILDFLOWERS, Text.translatable("advancement.moflowers.get_first_moflowers_flower.title"), Text.translatable("advancement.moflowers.get_first_moflowers_flower.description"), Identifier.ofVanilla("textures/gui/advancements/backgrounds/husbandry"), AdvancementFrame.TASK, false, true, false)
                .criteriaMerger(AdvancementRequirements.CriterionMerger.OR);

        for (Item item : items) {
            String fieldName = null;
            for (var field : ModItems.class.getFields()) {
                try {
                    if (field.get(null) == item) {
                        fieldName = field.getName().toLowerCase();
                        break;
                    }
                } catch (IllegalAccessException ignored) {}
            }
            if (fieldName == null) {
                fieldName = item.getTranslationKey().replace("item.moflowers.", "");
            }
            builder.criterion("got_" + fieldName, InventoryChangedCriterion.Conditions.items(item));
        }
        AdvancementEntry getFirstMoFlowersFlower = builder.rewards(AdvancementRewards.Builder.experience(15))
                .build(consumer, MoFlowers.MOD_ID + ":get_first_moflowers_flower");
        AdvancementEntry getFlowersChest = Advancement.Builder.create().parent(getFirstMoFlowersFlower)
                .display(ModItems.CLOSED_PALE_WILDFLOWERS, Text.translatable("advancement.moflowers.get_flowers_chest.title"), Text.translatable("advancement.moflowers.get_flowers_chest.description"), null, AdvancementFrame.TASK, false, true, false)
                .criterion("got_flowers_chest", InventoryChangedCriterion.Conditions.items(ModItems.FLOWERS_CHEST))
                .rewards(AdvancementRewards.Builder.experience(10))
                .build(consumer, MoFlowers.MOD_ID + ":get_flowers_chest");
        AdvancementEntry getAllMoFlowersFlower = Advancement.Builder.create().parent(getFirstMoFlowersFlower)
                .display(ModItems.OPEN_PALE_WILDFLOWERS, Text.translatable("advancement.moflowers.get_all_moflowers_flower.title"), Text.translatable("advancement.moflowers.get_all_moflowers_flower.description"), null, AdvancementFrame.GOAL, true, true, false)
                .criterion("got_all_moflowers_flower", InventoryChangedCriterion.Conditions.items(items))
                .rewards(AdvancementRewards.Builder.experience(30))
                .build(consumer, MoFlowers.MOD_ID + ":get_all_moflowers_flower");
    }
}
