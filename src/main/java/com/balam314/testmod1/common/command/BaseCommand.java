package com.balam314.testmod1.common.command;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;

import net.minecraft.command.CommandSource;
import net.minecraft.command.Commands;

public class BaseCommand {
	protected LiteralArgumentBuilder<CommandSource> builder;
	boolean enabled;
	public String name;
	
	public BaseCommand(String name, int permissionLevel, boolean enabled) {
		this.builder = Commands.literal(name).requires(source -> source.hasPermission(permissionLevel));
		this.enabled = enabled;
		this.name = name;
	}
	
	public LiteralArgumentBuilder<CommandSource> getBuilder() {
		return builder;
	}
	
	public boolean isEnabled() {
		return enabled;
	}
	
	public LiteralArgumentBuilder<CommandSource> setExecution() {
		return null;
	}
}
