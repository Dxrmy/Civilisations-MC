package com.eni.civilizations.entity;

import com.eni.civilizations.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.HolderLookup;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
// import net.minecraft.world.level.block.entity.TickableBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class VillageCenterBlockEntity extends BlockEntity {
    private int wood = 0;
    private int stone = 0;
    private int food = 0;
    private int workers = 0;
    private int soldiers = 0;
    private boolean isUnderAttack = false;

    public VillageCenterBlockEntity(BlockPos pPos, BlockState pBlockState) {
        super(ModBlockEntities.VILLAGE_CENTER, pPos, pBlockState);
    }

    @Override
    public void saveAdditional(@org.jetbrains.annotations.NotNull CompoundTag pTag,
            HolderLookup.@org.jetbrains.annotations.NotNull Provider pRegistries) {
        super.saveAdditional(pTag, pRegistries);
        pTag.putInt("wood", wood);
        pTag.putInt("stone", stone);
        pTag.putInt("food", food);
        pTag.putInt("workers", workers);
        pTag.putInt("soldiers", soldiers);
        pTag.putBoolean("under_attack", isUnderAttack);
    }

    @Override
    public void loadAdditional(@org.jetbrains.annotations.NotNull CompoundTag pTag,
            HolderLookup.@org.jetbrains.annotations.NotNull Provider pRegistries) {
        super.loadAdditional(pTag, pRegistries);
        wood = pTag.getInt("wood").orElse(0);
        stone = pTag.getInt("stone").orElse(0);
        food = pTag.getInt("food").orElse(0);
        workers = pTag.getInt("workers").orElse(0);
        soldiers = pTag.getInt("soldiers").orElse(0);
        isUnderAttack = pTag.getBoolean("under_attack").orElse(false);
    }

    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @Override
    public @org.jetbrains.annotations.NotNull CompoundTag getUpdateTag(
            HolderLookup.@org.jetbrains.annotations.NotNull Provider pRegistries) {
        return this.saveWithoutMetadata(pRegistries);
    }

    public static void tick(Level level, BlockPos pos, BlockState state, VillageCenterBlockEntity blockEntity) {
        if (level.isClientSide())
            return;

        // Simple logic for the demo
        if (level.getGameTime() % 100 == 0) {
            blockEntity.food++;
            if (blockEntity.food > 10) {
                blockEntity.workers++;
                blockEntity.food = 0;
            }
        }

        // War state logic (placeholder)
        if (blockEntity.isUnderAttack && level.getGameTime() % 200 == 0) {
            // Spawn soldier logic would go here, referencing ModEntities.SOLDIER
            // checking soldier count, etc.
            // For now, keeping it simple to compile.
            if (blockEntity.soldiers < 5) {
                // Spawning logic requires ServerLevel usually
                blockEntity.soldiers++;
            }
        }
    }
}
