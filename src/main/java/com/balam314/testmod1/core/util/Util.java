package com.balam314.testmod1.core.util;

import javax.annotation.Nullable;

import com.balam314.testmod1.TestMod1;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemUseContext;

public class Util{
	
	public Util() {
		TestMod1.LOGGER.info("Loaded TestMod1/ClientUtils");
	}
	
	public static int constrain(int num, @Nullable int min, @Nullable int max) {
		try {
			if(num > max) {return max;}
			if(num < min) {return min;}
			return num;
		} catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	public static Block block(ItemUseContext useIn) {
		return useIn.getLevel().getBlockState(useIn.getClickedPos()).getBlock();
	}
	
	public static BlockState blockState(ItemUseContext useIn) {
		return useIn.getLevel().getBlockState(useIn.getClickedPos());
	}
	
	public static String name(Block block) {
		return block.getRegistryName().toString();
	}
}
