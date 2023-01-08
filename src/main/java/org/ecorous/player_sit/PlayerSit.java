package org.ecorous.player_sit;

import org.ecorous.player_sit.commands.SitCommand;
import org.quiltmc.loader.api.ModContainer;
import org.quiltmc.qsl.base.api.entrypoint.ModInitializer;
import org.quiltmc.qsl.command.api.CommandRegistrationCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
public class PlayerSit implements ModInitializer {
	// This logger is used to write text to the console and the log file.
	// It is considered best practice to use your mod name as the logger's name.
	// That way, it's clear which mod wrote info, warnings, and errors.
	public static final Logger LOGGER = LoggerFactory.getLogger("PlayerSit");

	@Override
	public void onInitialize(ModContainer mod) {
		CommandRegistrationCallback.EVENT.register(((dispatcher, buildContext, environment) -> {
			SitCommand.register(dispatcher, environment);
		}));
	}
}
