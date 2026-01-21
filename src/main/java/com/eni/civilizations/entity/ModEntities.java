package com.eni.civilizations.entity;

import com.eni.civilizations.CivilizationsMod;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricDefaultAttributeRegistry;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;

public class ModEntities {

    public static final EntityType<SoldierEntity> SOLDIER = Registry.register(
            BuiltInRegistries.ENTITY_TYPE,
            Identifier.fromNamespaceAndPath(CivilizationsMod.MOD_ID, "soldier"),
            EntityType.Builder.of(SoldierEntity::new, MobCategory.MONSTER)
                    .sized(0.6f, 1.95f) // Standard human size
                    .build(ResourceKey.create(BuiltInRegistries.ENTITY_TYPE.key(),
                            Identifier.fromNamespaceAndPath(CivilizationsMod.MOD_ID, "soldier"))));

    public static void register() {
        // Attributes are usually registered in a separate event handler or method
        // called from ModInitializer
        // but for this structure, we keep it here.
        FabricDefaultAttributeRegistry.register(SOLDIER, SoldierEntity.createAttributes());
    }
}
