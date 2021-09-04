package com.balam314.testmod1.core.init;

import java.util.ArrayList;

import com.balam314.testmod1.common.command.BaseCommand;
import com.balam314.testmod1.common.command.SpeedCommand;
import com.mojang.brigadier.CommandDispatcher;

import net.minecraft.command.CommandSource;
import net.minecraftforge.event.RegisterCommandsEvent;

public class CommandInit {

	private static final ArrayList<BaseCommand> commandlist = new ArrayList<>();
	
	public static void registerCommands(final RegisterCommandsEvent event) {
		CommandDispatcher<CommandSource> COMMAND = event.getDispatcher();
		
		commandlist.add(new SpeedCommand("speed", 2, true));
		
		commandlist.forEach(command -> {
			if(command.isEnabled() && command.setExecution() != null) {
				COMMAND.register(command.getBuilder());
			}
		});
	}
}
