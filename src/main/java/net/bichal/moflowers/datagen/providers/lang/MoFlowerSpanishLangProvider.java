/*
 * Copyright (c) 2025 Bichal.
 * All rights reserved.
 */

package net.bichal.moflowers.datagen.providers.lang;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class MoFlowerSpanishLangProvider extends FabricLanguageProvider {
    public MoFlowerSpanishLangProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, "es_es", registryLookup);
    }

    @Override
    public void generateTranslations(RegistryWrapper.WrapperLookup wrapperLookup, TranslationBuilder t) {
        // Blocks
        t.add("block.moflowers.open_pale_wildflowers", "Flores pálidas abiertas");
        t.add("block.moflowers.closed_pale_wildflowers", "Flores pálidas cerradas");
        t.add("block.moflowers.magenta_petals", "Pétalos magenta");
        t.add("block.moflowers.moon_cactus_flower", "Flor de cactus lunar");
        t.add("block.moflowers.lily_pad_flower", "Flor de nenúfar");
        t.add("block.moflowers.sunflowers", "Girasoles");
        t.add("block.moflowers.wild_firefly_bush", "Arbusto de luciérnagas silvestre");
        t.add("block.moflowers.lavender", "Lavanda");
        t.add("block.moflowers.calendula", "Caléndula");
        t.add("block.moflowers.potted_lavender", "Lavanda en maceta");
        t.add("block.moflowers.potted_calendula", "Caléndula en maceta");
        t.add("block.moflowers.tall_lavender", "Lavanda Alta");
        t.add("block.moflowers.foxglove", "Dedalera");
        t.add("block.moflowers.hebea", "Hebea");
        t.add("block.moflowers.potted_hebea", "Hebea en maceta");
        t.add("block.moflowers.sweet_blue_berry_bush", "Arbusto de bayas azules dulces");
        t.add("block.moflowers.sweet_glow_berry_bush", "Arbusto de bayas brillantes dulces");
        t.add("block.moflowers.flowers_chest", "Cofre de flores");

        // Items
        t.add("item.moflowers.sweet_blue_berries", "Bayas azules dulces");
        t.add("item.moflowers.sweet_glow_berries", "Bayas brillantes dulces");

        // ItemGroups
        t.add("itemGroup.moflowers", "MoFlowers");

        // Containers
        t.add("container.moflowers.flowers_chest", "Cofre de flores");
        t.add("container.moflowers.double_flowers_chest", "Gran cofre de flores");

        // Advancements
        t.add("advancement.moflowers.get_first_moflowers_flower.title", "Primera flor de MoFlowers");
        t.add("advancement.moflowers.get_first_moflowers_flower.description", "Consigue cualquier flor de MoFlowers por primera vez");
        t.add("advancement.moflowers.get_flowers_chest.title", "Cofre floral");
        t.add("advancement.moflowers.get_flowers_chest.description", "Obtén tu cofre de flores");
        t.add("advancement.moflowers.get_all_moflowers_flower.title", "Campo de flores");
        t.add("advancement.moflowers.get_all_moflowers_flower.description", "Recolecta todas las flores de MoFlowers");
    }
}