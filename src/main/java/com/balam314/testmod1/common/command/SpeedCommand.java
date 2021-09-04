package com.balam314.testmod1.common.command;

import com.mojang.brigadier.Command;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;

import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;
import net.minecraft.command.arguments.EntityArgument;
import net.minecraft.command.arguments.MessageArgument;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.util.text.ITextComponent;

public class SpeedCommand extends BaseCommand {
	
	
	public SpeedCommand(String name, int permissionLevel, boolean enabled) {
		super(name, permissionLevel, enabled);
	}

	@Override
	public LiteralArgumentBuilder<CommandSource> setExecution() {
		// TODO Auto-generated method stub
		return builder.then(
			Commands
			.argument("player", EntityArgument.player())
			.executes(source -> execute(source.getSource(), EntityArgument.getPlayer(source, "player"), 0.2f))
		).then(
			Commands
			.argument("speed", MessageArgument.message())
			.executes(source -> execute(source.getSource(), EntityArgument.getPlayer(source, "player"), MessageArgument.getMessage(source, "speed")))
		);
	}
	
	private int execute(CommandSource source, ServerPlayerEntity player, ITextComponent speedAsITC) {
		float text = 0.1f;
		try {
			text = Float.valueOf(speedAsITC.getString());
		} catch(NumberFormatException e) {}
		player.setSpeed(text);
		player.abilities.setFlyingSpeed(text);
		
		return Command.SINGLE_SUCCESS;
	}
	
	private int execute(CommandSource source, ServerPlayerEntity player, float speedAsFloat) {
		player.setSpeed(speedAsFloat);
		player.abilities.setFlyingSpeed(speedAsFloat);
		
		return Command.SINGLE_SUCCESS;
	}
}
