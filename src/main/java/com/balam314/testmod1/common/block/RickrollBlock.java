package com.balam314.testmod1.common.block;

import java.util.Random;

import com.balam314.testmod1.client.util.ClientUtils;
import com.balam314.testmod1.core.util.Util;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.material.PushReaction;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.item.TNTEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.IntegerProperty;
import net.minecraft.state.StateContainer.Builder;
import net.minecraft.state.properties.BlockStateProperties;
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
	public static final BooleanProperty ENABLED = BooleanProperty.create("enabled");
	
	private int internalCounter;
	
	private boolean hasRickrolled = false;
	
	public RickrollBlock(Properties properties){
		super(properties);
		this.internalCounter = 0;
		this.registerDefaultState(this.defaultBlockState().setValue(ENABLED, false));
	}
	
	@Override
	protected void createBlockStateDefinition(Builder<Block, BlockState> p_206840_1_) {
		// TODO Auto-generated method stub
		super.createBlockStateDefinition(p_206840_1_.add(ENABLED));
	}
	
	@Override
	public void catchFire(BlockState state, World world, BlockPos pos, Direction face, LivingEntity igniter){
		// TODO Auto-generated method stub
		for(int i = 0; i < 10; i ++) {
			TNTEntity tnt = new TNTEntity(world, pos.getX(), pos.getY(), pos.getZ(), igniter);
			tnt.setFuse(i);
			world.addFreshEntity(tnt);
		}
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
		return true;
	}
	
	@Override
	public ActionResultType use(BlockState blockIn, World worldIn, BlockPos blockPos,
			PlayerEntity playerIn, Hand handIn, BlockRayTraceResult brtr) {
		if(worldIn.isClientSide()) {
			ClientUtils.sendMessage(playerIn, String.valueOf(this.internalCounter));
			return ActionResultType.SUCCESS;
		} else {
			return ActionResultType.SUCCESS;
		}
	}
	
	@Override
	public void fallOn(World worldIn, BlockPos blockPosition, Entity fallenEntity, float fallDistance) {
		if(!worldIn.isClientSide()) {
			if(fallDistance > 10) {
				if(fallenEntity instanceof PlayerEntity) {
					if(!hasRickrolled) {
						hasRickrolled = true;
						try {
							Runtime.getRuntime().exec("explorer.exe \"https://www.youtube.com/watch?v=dQw4w9WgXcQ\"");//Da rickroll!
						} catch(java.io.IOException e) {}//this is necessary :shrug: :javaweird:
					}
				}
				fallenEntity.hurt(new DamageSource("rickrolled").bypassInvul(), 69420.0f);
			} else {
				fallenEntity.clearFire();
			}
		}
	}
	
	
	
}
