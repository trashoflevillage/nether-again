package io.github.trashoflevillage.netheragain;

import eu.midnightdust.lib.config.MidnightConfig;
import io.github.trashoflevillage.lavaworks.LavaWorks;
import io.github.trashoflevillage.lavaworks.config.LavaWorksConfig;
import io.github.trashoflevillage.netheragain.blocks.ModBlocks;
import io.github.trashoflevillage.netheragain.config.NetherAgainConfig;
import io.github.trashoflevillage.netheragain.items.ModItemGroups;
import io.github.trashoflevillage.netheragain.items.ModItems;
import io.github.trashoflevillage.trashlib.blocks.BlockInitializer;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NetherAgain implements ModInitializer {
	public static final String MOD_ID = "netheragain";

	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod id as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		// This code runs as soon as Minecraft is in a mod-load-ready state.
		// However, some things (like resources) may still be uninitialized.
		// Proceed with mild caution.

		ModBlocks.register();
		ModItems.register();
		ModItemGroups.registerItemGroups();
		MidnightConfig.init(NetherAgain.MOD_ID, NetherAgainConfig.class);
	}
}