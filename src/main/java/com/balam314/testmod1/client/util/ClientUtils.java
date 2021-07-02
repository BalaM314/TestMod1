package com.balam314.testmod1.client.util;

import org.lwjgl.glfw.GLFW;

import com.balam314.testmod1.TestMod1;

import net.minecraft.client.Minecraft;
import net.minecraft.client.util.InputMappings;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class ClientUtils {
	public ClientUtils() {
		TestMod1.LOGGER.info("Loaded TestMod1/ClientUtils");
	}
	
	public enum Key {
		LSHIFT, RSHIFT, LCONTROL, RCONTROL, LALT, RALT 
	}
	
	static public boolean checkKeyPressed(int key) {
		if(key == 0) {
			TestMod1.LOGGER.warn("Attempted to check whether key 0 was pressed!");
			return false;
		}
		TestMod1.LOGGER.debug("Checked whether key " + key);
		return InputMappings.isKeyDown(Minecraft.getInstance().getWindow().getWindow(), key);
	}
	
	static public boolean checkKeyPressed(String key) {
		int keynum = 0;
		switch(key.toLowerCase()) {
			case "lshift":
				keynum = GLFW.GLFW_KEY_LEFT_SHIFT;
				break;
			case "rshift":
				keynum = GLFW.GLFW_KEY_RIGHT_SHIFT;
				break;
			case "lcontrol":
				keynum = GLFW.GLFW_KEY_LEFT_CONTROL;
				break;
			case "rcontrol":
				keynum = GLFW.GLFW_KEY_RIGHT_CONTROL;
				break;
			case "lalt":
				keynum = GLFW.GLFW_KEY_LEFT_ALT;
				break;
			case "ralt":
				keynum = GLFW.GLFW_KEY_RIGHT_ALT;
				break;
		}
		return checkKeyPressed(keynum);
	}
	
	static public boolean checkKeyPressed(Key key) {
		int keynum = 0;
		switch(key) {
			case LSHIFT:
				keynum = GLFW.GLFW_KEY_LEFT_SHIFT;
				break;
			case RSHIFT:
				keynum = GLFW.GLFW_KEY_RIGHT_SHIFT;
				break;
			case LCONTROL:
				keynum = GLFW.GLFW_KEY_LEFT_CONTROL;
				break;
			case RCONTROL:
				keynum = GLFW.GLFW_KEY_RIGHT_CONTROL;
				break;
			case LALT:
				keynum = GLFW.GLFW_KEY_LEFT_ALT;
				break;
			case RALT:
				keynum = GLFW.GLFW_KEY_RIGHT_ALT;
				break;
		}
		return checkKeyPressed(keynum);
	}
}
