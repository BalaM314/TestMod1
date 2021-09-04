package com.balam314.testmod1;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.balam314.testmod1.core.init.BlockInit;
import com.balam314.testmod1.core.init.CommandInit;
import com.balam314.testmod1.core.init.ItemInit;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;


// The value here should match an entry in the META-INF/mods.toml file
@Mod(TestMod1.MOD_ID)
public class TestMod1 {
    // Directly reference a log4j logger.
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String MOD_ID = "testmod1";
	

    public TestMod1() {
        // Register the setup method for modloading
    	IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
    	
        bus.addListener(this::setup);
        BlockInit.BLOCK.register(bus);
        ItemInit.ITEM.register(bus);
        
        // Register ourselves for server and other game events we are interested in
        MinecraftForge.EVENT_BUS.register(this);
    }
    
    @SubscribeEvent
    public void onCommandRegister(final RegisterCommandsEvent event) {
    	LOGGER.warn("#####################<onCommandRegister called!>###############");
    	CommandInit.registerCommands(event);
    }
    
    private void setup(final FMLCommonSetupEvent event){
        LOGGER.info("HELLO FROM PREINIT");
    } 
}
