package com.balam314.testmod1.common.item;

import java.util.List;

import net.minecraft.client.util.ITooltipFlag;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.world.GameType;
import net.minecraft.world.World;

public class ThomasTokenItem extends Item {

	public ThomasTokenItem(Properties properties) {
		super(properties);
	}
	
	@Override
	public void appendHoverText(ItemStack itemIn, World worldIn, List<ITextComponent> tooltip,
			ITooltipFlag p_77624_4_) {
		// TODO Auto-generated method stub
		super.appendHoverText(itemIn, worldIn, tooltip, p_77624_4_);
		tooltip.add(new StringTextComponent("Right click to toggle god mode"));
		tooltip.add(new StringTextComponent("Creative only"));
	}
	
	@Override
	public ActionResultType onItemUseFirst(ItemStack stack, ItemUseContext context) {
		PlayerEntity playerIn = context.getPlayer();
		if(!playerIn.getCooldowns().isOnCooldown(this)) {
			if(playerIn.abilities.invulnerable) {
				playerIn.getCooldowns().addCooldown(this, 10);
				playerIn.abilities.setFlyingSpeed(0.2f);
				playerIn.setInvulnerable(false);
				playerIn.setGameMode(GameType.SURVIVAL);
			} else {
				playerIn.getCooldowns().addCooldown(this, 100);
				playerIn.abilities.setFlyingSpeed(10.0f);
				playerIn.setInvulnerable(true);
				playerIn.setGameMode(GameType.CREATIVE);
			}
			return ActionResultType.SUCCESS;
		} else {
			playerIn.hurt(new DamageSource("impatience"), 1.0f);
			return ActionResultType.PASS;
		}
	}
}
