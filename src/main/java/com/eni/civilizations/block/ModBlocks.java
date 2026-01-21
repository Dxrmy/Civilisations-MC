package com.eni.civilizations.block;

import com.eni.civilizations.CivilizationsMod;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;

public class ModBlocks {
    
    public static final Block VILLAGE_CENTER = new VillageCenterBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(2.0f));

    public static void register() {
         Registry.register(BuiltInRegistries.BLOCK, Identifier.fromNamespaceAndPath(CivilizationsMod.MOD_ID, "village_center"), VILLAGE_CENTER);
         // In Fabric, BlockItems are often registered separately or in item groups
    }
}
