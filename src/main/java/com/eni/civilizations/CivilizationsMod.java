package com.eni.civilizations;

import com.eni.civilizations.block.ModBlocks;
import com.eni.civilizations.entity.ModBlockEntities;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CivilizationsMod implements ModInitializer {
    public static final String MOD_ID = "civilizations";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    @Override
    public void onInitialize() {
        LOGGER.info("Civilizations Mod Initializing...");
        
        ModBlocks.register();
        ModBlockEntities.register();
    }
}
