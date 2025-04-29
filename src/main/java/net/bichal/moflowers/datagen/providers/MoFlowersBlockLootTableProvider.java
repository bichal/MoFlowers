/*
 * Copyright (c) 2025 Bichal.
 * All rights reserved.
 */

package net.bichal.moflowers.datagen.providers;

import net.bichal.moflowers.blocks.ModBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.minecraft.block.Blocks;
import net.minecraft.block.SweetBerryBushBlock;
import net.minecraft.block.TallPlantBlock;
import net.minecraft.block.enums.DoubleBlockHalf;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.Enchantments;
import net.minecraft.item.Items;
import net.minecraft.loot.LootPool;
import net.minecraft.loot.LootTable;
import net.minecraft.loot.condition.BlockStatePropertyLootCondition;
import net.minecraft.loot.entry.ItemEntry;
import net.minecraft.loot.function.ApplyBonusLootFunction;
import net.minecraft.loot.function.SetCountLootFunction;
import net.minecraft.loot.provider.number.UniformLootNumberProvider;
import net.minecraft.predicate.StatePredicate;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.RegistryWrapper;

import java.util.concurrent.CompletableFuture;

public class MoFlowersBlockLootTableProvider extends FabricBlockLootTableProvider {
    public MoFlowersBlockLootTableProvider(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        RegistryWrapper.Impl<Enchantment> impl = this.registries.getOrThrow(RegistryKeys.ENCHANTMENT);

        addDrop(ModBlocks.CLOSED_PALE_WILDFLOWERS, segmentedDrops(ModBlocks.CLOSED_PALE_WILDFLOWERS));
        addDrop(ModBlocks.OPEN_PALE_WILDFLOWERS, segmentedDrops(ModBlocks.OPEN_PALE_WILDFLOWERS));

        addDrop(ModBlocks.MAGENTA_PETALS);
        addDrop(ModBlocks.MOON_CACTUS_FLOWER);
        addDrop(ModBlocks.LILY_PAD_FLOWER);
        addDrop(ModBlocks.LAVENDER);
        addDrop(ModBlocks.CALENDULA);
        addDrop(ModBlocks.HEBEA);

        addDrop(ModBlocks.FLOWERS_CHEST, this::nameableContainerDrops);

        addDrop(ModBlocks.SUNFLOWERS, block -> dropsWithProperty(block, TallPlantBlock.HALF, DoubleBlockHalf.LOWER));
        addDrop(ModBlocks.TALL_LAVENDER, block -> dropsWithProperty(block, TallPlantBlock.HALF, DoubleBlockHalf.LOWER));
        addDrop(ModBlocks.FOXGLOVE, block -> dropsWithProperty(block, TallPlantBlock.HALF, DoubleBlockHalf.LOWER));

        addPottedPlantDrops(ModBlocks.POTTED_LAVENDER);
        addPottedPlantDrops(ModBlocks.POTTED_CALENDULA);
        addPottedPlantDrops(ModBlocks.POTTED_HEBEA);

        addDrop(ModBlocks.SWEET_BLUE_BERRY_BUSH, block -> applyExplosionDecay(block, LootTable.builder()
                .pool(LootPool.builder().conditionally(BlockStatePropertyLootCondition.builder(Blocks.SWEET_BERRY_BUSH)
                                                               .properties(StatePredicate.Builder.create()
                                                                                   .exactMatch(SweetBerryBushBlock.AGE, 3)))
                              .with(ItemEntry.builder(Items.SWEET_BERRIES))
                              .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 3.0F)))
                              .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE))))
                .pool(LootPool.builder().conditionally(BlockStatePropertyLootCondition.builder(Blocks.SWEET_BERRY_BUSH)
                                                               .properties(StatePredicate.Builder.create()
                                                                                   .exactMatch(SweetBerryBushBlock.AGE, 2)))
                              .with(ItemEntry.builder(Items.SWEET_BERRIES))
                              .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)))
                              .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE))))));

        addDrop(ModBlocks.SWEET_GLOW_BERRY_BUSH, block -> applyExplosionDecay(block, LootTable.builder()
                .pool(LootPool.builder().conditionally(BlockStatePropertyLootCondition.builder(Blocks.SWEET_BERRY_BUSH)
                                                               .properties(StatePredicate.Builder.create()
                                                                                   .exactMatch(SweetBerryBushBlock.AGE, 3)))
                              .with(ItemEntry.builder(Items.GLOW_BERRIES))
                              .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(2.0F, 3.0F)))
                              .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE))))
                .pool(LootPool.builder().conditionally(BlockStatePropertyLootCondition.builder(Blocks.SWEET_BERRY_BUSH)
                                                               .properties(StatePredicate.Builder.create()
                                                                                   .exactMatch(SweetBerryBushBlock.AGE, 2)))
                              .with(ItemEntry.builder(Items.GLOW_BERRIES))
                              .apply(SetCountLootFunction.builder(UniformLootNumberProvider.create(1.0F, 2.0F)))
                              .apply(ApplyBonusLootFunction.uniformBonusCount(impl.getOrThrow(Enchantments.FORTUNE))))));
    }
}
