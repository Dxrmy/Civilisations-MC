package com.eni.civilizations.block;

import com.eni.civilizations.entity.ModBlockEntities;
import com.eni.civilizations.entity.VillageCenterBlockEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.Nullable;

import com.mojang.serialization.MapCodec;

public class VillageCenterBlock extends BaseEntityBlock {
    public static final MapCodec<VillageCenterBlock> CODEC = simpleCodec(VillageCenterBlock::new);

    @Override
    public com.mojang.serialization.MapCodec<VillageCenterBlock> codec() {
        return simpleCodec(VillageCenterBlock::new);
    }

    public VillageCenterBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public RenderShape getRenderShape(BlockState pState) {
        return RenderShape.MODEL;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pPos, BlockState pState) {
        return new VillageCenterBlockEntity(pPos, pState);
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level pLevel, BlockState pState,
            BlockEntityType<T> pBlockEntityType) {
        return createTickerHelper(pBlockEntityType, ModBlockEntities.VILLAGE_CENTER, VillageCenterBlockEntity::tick);
    }
}
