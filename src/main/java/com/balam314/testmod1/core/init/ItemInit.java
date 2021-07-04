package com.balam314.testmod1.core.init;

import com.balam314.testmod1.TestMod1;
import com.balam314.testmod1.common.item.SillyItem;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Rarity;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;



public class ItemInit {
	
	public static final DeferredRegister<Item> ITEM = DeferredRegister.create(ForgeRegistries.ITEMS, TestMod1.MOD_ID);
	
	
	public static final RegistryObject<Item> Thingy = ITEM.register("thingy", () -> new Item(new Item.Properties().fireResistant().rarity(Rarity.EPIC).stacksTo(63).tab(ItemGroup.TAB_MISC)));
	public static final RegistryObject<SillyItem> SpecialItem = ITEM.register("meme", () -> new SillyItem(new Item.Properties().rarity(Rarity.EPIC).stacksTo(1).tab(ItemGroup.TAB_TOOLS)));
	
	//BlockItems
	public static final RegistryObject<BlockItem> Thomas = ITEM.register("thomas", () -> new BlockItem(BlockInit.THOMAS.get(), new Item.Properties().fireResistant().rarity(Rarity.EPIC).tab(ItemGroup.TAB_BUILDING_BLOCKS)));
	public static final RegistryObject<BlockItem> Rickroll = ITEM.register("rickroll", () -> new BlockItem(BlockInit.RICKROLL.get(), new Item.Properties().fireResistant().rarity(Rarity.EPIC).tab(ItemGroup.TAB_MISC)));
}
