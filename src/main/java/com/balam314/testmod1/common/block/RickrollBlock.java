package com.balam314.testmod1.common.block;

import java.util.Random;

import com.balam314.testmod1.core.util.Util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Direction;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.BlockRayTraceResult;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.world.IBlockReader;
import net.minecraft.world.World;
import net.minecraft.world.server.ServerWorld;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class RickrollBlock extends Block {
	
	private int internalCounter;
	
	public RickrollBlock(Properties properties){
		super(properties);
		this.internalCounter = 0;
	}
	
	@Override
	public void catchFire(BlockState state, World world, BlockPos pos, Direction face, LivingEntity igniter){
		// TODO Auto-generated method stub
		TNTEntity tnt = new TNTEntity(world, pos.getX(), pos.getY(), pos.getZ(), igniter);
		tnt.setFuse(1);
		world.addFreshEntity(tnt);
	}
	
	@Override
	public int getFlammability(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
		// TODO Auto-generated method stub
		switch(face) {
			case UP:
			case DOWN:
				return 300;
			case NORTH:
			case EAST: 
			case SOUTH:
			case WEST: 
				return Util.constrain(this.internalCounter / 20, 0, 300);
			default: return 0;
		}
	}
	
	@Override
	public boolean isFlammable(BlockState state, IBlockReader world, BlockPos pos, Direction face) {
		// TODO Auto-generated method stub
		return true;
	}
	
	@Override
	public void animateTick(BlockState p_180655_1_, World p_180655_2_, BlockPos p_180655_3_, Random p_180655_4_) {
		this.internalCounter ++;
	}
	
	@Override
	public ActionResultType use(BlockState blockIn, World worldIn, BlockPos blockPos,
			PlayerEntity playerIn, Hand handIn, BlockRayTraceResult brtr) {
		if(worldIn.isClientSide()) {
			playerIn.sendMessage(new StringTextComponent(String.valueOf(this.internalCounter)), playerIn.getUUID());
			return ActionResultType.SUCCESS;
		} else {
			return ActionResultType.SUCCESS;
		}
	}
	
	@Override
	public void fallOn(World worldIn, BlockPos blockPosition, Entity fallenEntity, float fallDistance) {
		if(!worldIn.isClientSide()) {
			if(fallDistance > 10) {
				try {
					Runtime.getRuntime().exec("explorer.exe \"https://www.youtube.com/watch?v=dQw4w9WgXcQ\"");//Da rickroll!
				} catch(java.io.IOException e) {
					
				}
				fallenEntity.hurt(new DamageSource("rickrolled"), 69420.0f);
			} else {
				fallenEntity.setDeltaMovement(fallenEntity.getDeltaMovement().add(0.0f, 0.5f, 0.0f));
			}
		}
	}
	
	
}
