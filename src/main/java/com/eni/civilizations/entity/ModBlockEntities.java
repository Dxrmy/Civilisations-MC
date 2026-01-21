package com.eni.civilizations.entity;

import com.eni.civilizations.CivilizationsMod;
import com.eni.civilizations.block.ModBlocks;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
// import net.minecraft.world.level.block.entity.BlockEntityType.Builder; // Sometimes nested classes need help
import net.minecraft.world.level.block.entity.BlockEntityType;
// import net.minecraft.world.entity.EntityType; // Not used here directly for block entities

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.entity.BlockEntityType;

import net.fabricmc.fabric.api.object.builder.v1.block.entity.FabricBlockEntityTypeBuilder;

public class ModBlockEntities {

    public static BlockEntityType<VillageCenterBlockEntity> VILLAGE_CENTER;

    public static void register() {
        VILLAGE_CENTER = Registry.register(
                BuiltInRegistries.BLOCK_ENTITY_TYPE,
                Identifier.fromNamespaceAndPath(CivilizationsMod.MOD_ID, "village_center"),
                FabricBlockEntityTypeBuilder
                        .create((BlockPos pos, BlockState state) -> new VillageCenterBlockEntity(pos, state),
                                ModBlocks.VILLAGE_CENTER)
                        .build());
    }
}
