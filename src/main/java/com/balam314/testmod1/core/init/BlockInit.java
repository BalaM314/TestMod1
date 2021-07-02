package com.balam314.testmod1.core.init;

import com.balam314.testmod1.TestMod1;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialColor;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;


public class BlockInit {
	
	public static final DeferredRegister<Block> BLOCK = DeferredRegister.create(ForgeRegistries.BLOCKS, TestMod1.MOD_ID);
	
	public static final RegistryObject<Block> THOMAS = BLOCK.register("thomas", () -> new Block(
			AbstractBlock.Properties.of(Material.HEAVY_METAL, MaterialColor.COLOR_BLACK)
				.friction(-0.1f)
				.harvestLevel(4)
				.harvestTool(ToolType.PICKAXE)
				.strength(75.0f, 69420.0f)
				.jumpFactor(420.0f)
				.speedFactor(69.0f)
				.sound(SoundType.GILDED_BLACKSTONE)
				.requiresCorrectToolForDrops()
			));
	
}
