package org.ecorous.player_sit.commands;

import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.command.argument.EntityArgumentType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.server.command.CommandManager;
import net.minecraft.server.command.ServerCommandSource;
import net.minecraft.text.Text;
import org.ecorous.player_sit.PlayerSit;


import static net.minecraft.server.command.CommandManager.literal;
import static net.minecraft.server.command.CommandManager.argument;

public class SitCommand {
	public static void register(CommandDispatcher<ServerCommandSource> dispatcher, CommandManager.RegistrationEnvironment environment) {
		dispatcher.register(literal("playersit").then(argument("player", EntityArgumentType.player()).executes(context -> {
			ServerCommandSource serverCommandSource = (ServerCommandSource)context.getSource();
			PlayerEntity player = serverCommandSource.getPlayer();
			PlayerEntity toRide = EntityArgumentType.getPlayer(context, "player");
			if (player.isInRange(toRide, 5.0d) && player != toRide) {
			    player.startRiding(toRide);
			}
			else {
				serverCommandSource.sendError(Text.literal("You cannot sit on yourself and target player must be less than 5 blocks away"));
				return 0;
			}
			return 1;
		}
		)));
	}
}
