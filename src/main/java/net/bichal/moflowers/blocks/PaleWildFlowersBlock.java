/*
 * Copyright (c) 2025 Bichal.
 * All rights reserved.
 */

package net.bichal.moflowers.blocks;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.*;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityCollisionHandler;
import net.minecraft.entity.effect.StatusEffect;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.entity.passive.BeeEntity;
import net.minecraft.particle.TrailParticleEffect;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.Difficulty;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class PaleWildFlowersBlock extends FlowerbedBlock {
    public static final MapCodec<FlowerbedBlock> CODEC = RecordCodecBuilder.mapCodec(instance -> instance
            .group(Codec.BOOL.fieldOf("open")
                           .forGetter(block -> ((PaleWildFlowersBlock) block).state.open), createSettingsCodec())
            .apply(instance, PaleWildFlowersBlock::new));

    private final PaleWildFlowersBlock.PaleWildFlowersState state;

    public PaleWildFlowersBlock(PaleWildFlowersState state, AbstractBlock.Settings settings) {
        super(settings);
        this.state = state;
    }

    public PaleWildFlowersBlock(boolean open, AbstractBlock.Settings settings) {
        super(settings);
        this.state = PaleWildFlowersBlock.PaleWildFlowersState.of(open);
    }

    @Override
    public MapCodec<FlowerbedBlock> getCodec() {
        return CODEC;
    }

    @Override
    public void randomTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (this.updateStateAndNotifyOthers(state, world, pos, random)) {
            world.playSound(null, pos, this.state.getOpposite().longSound, SoundCategory.BLOCKS, 1.0F, 1.0F);
        }

        super.randomTick(state, world, pos, random);
    }

    private boolean updateStateAndNotifyOthers(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!world.getDimension().natural()) {
            return false;
        }
        else
            if (CreakingHeartBlock.isNightAndNatural(world) == this.state.open) {
                return false;
            }
            else {
                int currentFlowerAmount = state.get(FLOWER_AMOUNT);
                PaleWildFlowersBlock.PaleWildFlowersState newState = this.state.getOpposite();

                BlockState newBlockState = newState.getBlock().getDefaultState()
                        .with(FLOWER_AMOUNT, currentFlowerAmount);
                world.setBlockState(pos, newBlockState, Block.NOTIFY_ALL);
                world.emitGameEvent(GameEvent.BLOCK_CHANGE, pos, GameEvent.Emitter.of(state));
                newState.spawnTrailParticle(world, pos, random);

                BlockPos.iterate(pos.add(-3, -2, -3), pos.add(3, 2, 3)).forEach(otherPos -> {
                    BlockState blockState2 = world.getBlockState(otherPos);
                    if (blockState2.getBlock() instanceof PaleWildFlowersBlock && ((PaleWildFlowersBlock) blockState2.getBlock()).state == this.state) {
                        double d = Math.sqrt(pos.getSquaredDistance(otherPos));
                        int i = random.nextBetween((int) (d * 5.0), (int) (d * 10.0));
                        world.scheduleBlockTick(otherPos, blockState2.getBlock(), i);
                    }
                });

                return true;
            }
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        if (this.state.isOpen() && random.nextInt(700) == 0) {
            BlockState blockState = world.getBlockState(pos.down());
            if (blockState.isOf(Blocks.PALE_MOSS_BLOCK)) {
                world.playSoundClient(pos.getX(), pos.getY(), pos.getZ(), SoundEvents.BLOCK_EYEBLOSSOM_IDLE, SoundCategory.AMBIENT, 1.0F, 1.0F, false);
            }
        }
    }

    @Override
    protected void onEntityCollision(BlockState state, World world, BlockPos pos, Entity entity, EntityCollisionHandler handler) {
        if (!world.isClient() && world.getDifficulty() != Difficulty.PEACEFUL && entity instanceof BeeEntity beeEntity && BeeEntity.isAttractive(state) && !beeEntity.hasStatusEffect(StatusEffects.POISON)) {
            beeEntity.addStatusEffect(this.getContactEffect());
        }
    }

    public StatusEffectInstance getContactEffect() {
        return new StatusEffectInstance(StatusEffects.POISON, 25);
    }

    public enum PaleWildFlowersState {
        OPEN(true, StatusEffects.BLINDNESS, 11.0F, SoundEvents.BLOCK_EYEBLOSSOM_OPEN_LONG, SoundEvents.BLOCK_EYEBLOSSOM_OPEN, 16545810), CLOSED(false, StatusEffects.NAUSEA, 7.0F, SoundEvents.BLOCK_EYEBLOSSOM_CLOSE_LONG, SoundEvents.BLOCK_EYEBLOSSOM_CLOSE, 6250335);

        final boolean open;
        final RegistryEntry<StatusEffect> stewEffect;
        final float effectLengthInSeconds;
        final SoundEvent longSound;
        final SoundEvent sound;
        private final int particleColor;
        private int flowerAmount;

        PaleWildFlowersState(final boolean open, final RegistryEntry<StatusEffect> stewEffect, final float effectLengthInSeconds, final SoundEvent longSound, final SoundEvent sound, final int particleColor) {
            this.open = open;
            this.stewEffect = stewEffect;
            this.effectLengthInSeconds = effectLengthInSeconds;
            this.longSound = longSound;
            this.sound = sound;
            this.particleColor = particleColor;
            this.flowerAmount = 1;
        }

        public static PaleWildFlowersBlock.PaleWildFlowersState of(boolean open) {
            return open ? OPEN : CLOSED;
        }

        public Block getBlock() {
            return this.open ? ModBlocks.OPEN_PALE_WILDFLOWERS : ModBlocks.CLOSED_PALE_WILDFLOWERS;
        }

        public PaleWildFlowersBlock.PaleWildFlowersState getOpposite() {
            PaleWildFlowersBlock.PaleWildFlowersState oppositeState = this == OPEN ? CLOSED : OPEN;
            oppositeState.flowerAmount = this.flowerAmount;
            return oppositeState;
        }

        public boolean isOpen() {
            return this.open;
        }

        public void spawnTrailParticle(ServerWorld world, BlockPos pos, Random random) {
            Vec3d vec3d = pos.toCenterPos();
            double d = 0.5 + random.nextDouble();
            Vec3d vec3d2 = new Vec3d(random.nextDouble() - 0.5, random.nextDouble() + 1.0, random.nextDouble() - 0.5);
            Vec3d vec3d3 = vec3d.add(vec3d2.multiply(d));
            TrailParticleEffect trailParticleEffect = new TrailParticleEffect(vec3d3, this.particleColor, (int) (20.0 * d));
            world.spawnParticles(trailParticleEffect, vec3d.x, vec3d.y, vec3d.z, getFlowerAmount() * 2, 0.0, 0.0, 0.0, 0.0);
        }

        public int getFlowerAmount() {
            return this.flowerAmount;
        }
    }
}
