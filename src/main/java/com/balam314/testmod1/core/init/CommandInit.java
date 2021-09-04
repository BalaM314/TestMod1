package com.balam314.testmod1.core.init;

import java.util.ArrayList;

import com.balam314.testmod1.TestMod1;
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
		
		TestMod1.LOGGER.info(">>>>>>>>>>>CommandInit.registerCommands called hooray ");
		
		commandlist.forEach(command -> {
			if(command.isEnabled() && command.setExecution() != null) {
				COMMAND.register(command.getBuilder());
				TestMod1.LOGGER.info(">>>>>>>>>>>Registered command " + command.name + "<<<<<<<<<<<");
			}
		});
	}
}
