/*
 * Copyright (c) 2025 Bichal.
 * All rights reserved.
 */

package net.bichal.moflowers.datagen.providers.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class MoFlowersEnglishLangProvider extends FabricLanguageProvider {
    public MoFlowersEnglishLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "en_us", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder t) {
        // Blocks
        t.add("block.moflowers.open_pale_wildflowers", "Open pale wildflowers");
        t.add("block.moflowers.closed_pale_wildflowers", "Closed pale wildflowers");
        t.add("block.moflowers.magenta_petals", "Magenta petals");
        t.add("block.moflowers.moon_cactus_flower", "Moon cactus flower");
        t.add("block.moflowers.lily_pad_flower", "Lily pad flower");
        t.add("block.moflowers.sunflowers", "Sunflowers");
        t.add("block.moflowers.wild_firefly_bush", "Wild firefly bush");
        t.add("block.moflowers.lavender", "Lavender");
        t.add("block.moflowers.calendula", "Calendula");
        t.add("block.moflowers.potted_lavender", "Potted Lavender");
        t.add("block.moflowers.potted_calendula", "Potted Calendula");
        t.add("block.moflowers.tall_lavender", "Tall Lavender");
        t.add("block.moflowers.foxglove", "Foxglove");
        t.add("block.moflowers.hebea", "Hebea");
        t.add("block.moflowers.potted_hebea", "Potted Hebea");
        t.add("block.moflowers.sweet_blue_berry_bush", "Sweet blueberry bush");
        t.add("block.moflowers.sweet_glow_berry_bush", "Sweet glowberry bush");
        t.add("block.moflowers.flowers_chest", "Flowers chest");

        // Items
        t.add("item.moflowers.sweet_blue_berries", "Sweet blueberries");
        t.add("item.moflowers.sweet_glow_berries", "Sweet glowberries");

        // ItemGroups
        t.add("itemGroup.moflowers", "MoFlowers");

        // Containers
        t.add("container.moflowers.flowers_chest", "Flowers chest");
        t.add("container.moflowers.double_flowers_chest", "Large flowers chest");

        // Advancements
        t.add("advancement.moflowers.get_first_moflowers_flower.title", "First MoFlowers flower");
        t.add("advancement.moflowers.get_first_moflowers_flower.description", "Get any MoFlowers flower for the first time");
        t.add("advancement.moflowers.get_flowers_chest.title", "Flowering chest");
        t.add("advancement.moflowers.get_flowers_chest.description", "Get your flowers chest");
        t.add("advancement.moflowers.get_all_moflowers_flower.title", "Crossing fields");
        t.add("advancement.moflowers.get_all_moflowers_flower.description", "Get all MoFlowers flowers");
    }
}