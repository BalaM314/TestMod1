package com.balam314.testmod1.common.item;

import java.util.List;


import com.balam314.testmod1.TestMod1;
import com.balam314.testmod1.client.util.ClientUtils;
import com.balam314.testmod1.common.block.RickrollBlock;
import com.balam314.testmod1.core.util.Util;

import net.minecraft.block.Block;
import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;
import net.minecraft.state.IntegerProperty;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.World;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;


public class SillyItem extends Item {

	public SillyItem(Properties properties) {
		super(properties);
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public void appendHoverText(ItemStack stack, World worldIn, List<ITextComponent> tooltip, ITooltipFlag flagIn) {
		super.appendHoverText(stack, worldIn, tooltip, flagIn);
		tooltip.add(new TranslationTextComponent("item.testmod1.meme.tooltip"));
		if(ClientUtils.checkKeyPressed("lshift")){
			tooltip.add(new StringTextComponent("Right click on a netherite block or Thomas block to get helpful effects!"));
		} else {
			tooltip.add(new StringTextComponent("Press \u00A76<LSHIFT>\u00A7r for more information"));
		}
		if(ClientUtils.checkKeyPressed("rshift")){
			worldIn.disconnect();
		} else {
			tooltip.add(new StringTextComponent("Press <RIGHT_SHIFT> for a secret"));
		}
	}

	@Override
	@OnlyIn(Dist.CLIENT)
	public boolean isFireResistant(){
		return ClientUtils.checkKeyPressed("lshift");
	}
	/*@Override
	public ActionResult<ItemStack> use(World worldIn, PlayerEntity playerIn, Hand handIn){
		playerIn.addEffect(new EffectInstance(Effects.POISON, 80, 10));
		return ActionResult.success(playerIn.getItemInHand(handIn));
	}*/

	@Override
	public ActionResultType useOn(ItemUseContext itemUseIn){
		// TODO Auto-generated method stub
		Block clickedBlock = Util.block(itemUseIn);
		TestMod1.LOGGER.debug("Clicked on " + Util.name(clickedBlock));
		if(Util.name(clickedBlock).equals("testmod1:thomas")){
			itemUseIn.getPlayer().addEffect(new EffectInstance(Effects.REGENERATION, 8400, 255));
		} else if(Util.name(clickedBlock).equals("minecraft:netherite_block")){
			itemUseIn.getPlayer().addEffect(new EffectInstance(Effects.DAMAGE_RESISTANCE, 69420, 5));
		} else if(Util.name(clickedBlock).equals("minecraft:diamond_block")){
			itemUseIn.getPlayer().setInvulnerable(!itemUseIn.getPlayer().isInvulnerable());
		} else if(Util.name(clickedBlock).equals("testmod1:rickroll")){
			itemUseIn.getLevel().setBlock(itemUseIn.getClickedPos(), Util.blockState(itemUseIn).setValue(RickrollBlock.ENABLED, true), 0);
		} else {
			itemUseIn.getLevel().destroyBlock(itemUseIn.getClickedPos(), true);
		}
		return ActionResultType.SUCCESS;
	}



}
