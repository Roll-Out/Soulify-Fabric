package com.github.rollout.soulify;

import com.github.rollout.soulify.registry.SoulifyBlocks;
import com.github.rollout.soulify.registry.SoulifyFluids;
import net.fabricmc.api.ModInitializer;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Soulify implements ModInitializer {

    public static Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "soulify";
    public static final String MOD_NAME = "Soulify";

    @Override
    public void onInitialize() {
        new SoulifyBlocks();
        SoulifyBlocks.RegisterSoulifyBlocks();
        SoulifyFluids.RegisterSoulifyFluids();
        log(Level.INFO, "Initializing");
        //TODO: Initializer
    }

    public static void log(Level level, String message){
        LOGGER.log(level, "["+MOD_NAME+"] " + message);
    }

}