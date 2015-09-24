package com.sinapze.solariapex.item.equipment.tool;

import java.util.List;

import com.sinapze.solariapex.block.ModBlocks;
import com.sinapze.solariapex.item.ItemBase;
import com.sinapze.solariapex.item.ModItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTorch;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;

@SuppressWarnings("unused")

public class ItemDaybreak extends ItemBase{

	public ItemDaybreak() 
	{
		super("daybreak");
		this.setMaxDamage(100);
		this.setMaxStackSize(1);
	}

	
	@Override
	public void onCreated(ItemStack itemStack, World world, EntityPlayer player) 
	{
		itemStack.setItemDamage(1);
	}
	
	//@SuppressWarnings("rawtypes")
	@SuppressWarnings("unchecked")
	@Override
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean adv) 
	{
		list.add(EnumChatFormatting.GOLD + "Torches Stored: " + (itemStack.getMaxDamage() - itemStack.getItemDamage()));
	}
	
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float par8, float par9, float par10)
	{
		boolean isSolid = false; //create a flag to use later and initialize it to false
		
		//we first check to see if we have any stored torches in the daybreak. otherwise we cant place one
		if (itemStack.getMaxDamage() - itemStack.getItemDamage() > 0)
		{
			//then first check if the block we are clicking on is some sort of "replacable" like grass, snow, lava, water etc
			if(world.getBlock(x, y, z).isReplaceable(world, x, y, z))
			{
				world.setBlock(x, y, z, Blocks.torch); //if it is replacable we replace it with the torch
				itemStack.damageItem(1, player);
				return true;
			}
			
			//if it is not replaceable, it can either be solid (regular block) or non solid (ladder, others)
			//we set the isSolid flag to true or false based on whether its the opaque cube or not
			isSolid = world.getBlock(z, y, z).isOpaqueCube();
			
				//then we enter a switch for the side
				switch (side)
				{
					case 0: //the bottom side. treat it as a non-solid because it cant attach to its bottom
						//call the function tryPlaceTorch below, with the attempted location of 1 block below the block that was clicked
						return tryPlaceTorch(itemStack, player, world, x, y-1, z, true);
					case 1: //top face
						return tryPlaceTorch(itemStack, player, world, x, y+1, z, isSolid);
					case 2: //north face
						return tryPlaceTorch(itemStack, player, world, x, y, z-1, isSolid);
					case 3: //south face
						return tryPlaceTorch(itemStack, player, world, x, y, z+1, isSolid);
					case 4: //west face
						return tryPlaceTorch(itemStack, player, world, x-1, y, z, isSolid);
					case 5: //east face
						return tryPlaceTorch(itemStack, player, world, x+1, y, z, isSolid);
					default:
						return false;
				}
			}
		return false; //this is returned if there arent any torches stored
	}
	
	//function which handles trying and placing the actual torches
	public boolean tryPlaceTorch(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, boolean tryAdvanced)
	{
		//first we check to see if the block we are trying to place a torch in is air or replacable
		//if it isnt we dont want to be able to place a torch there
		if(world.isAirBlock(x, y, z) || world.getBlock(x, y, z).isReplaceable(world, x, y, z))
		{
			//if we cant place the block on the actual block clicked (because its not solid), we check the 4 blocks around the spot
			//we are trying to place the torch and the block below it as well to see if they can support it
			if(tryAdvanced)
			{
				//if any of the 4 spots or block below are solid, we will set the block to the torch
				if(world.getBlock(x,y-1,z).isOpaqueCube() || world.getBlock(x-1,y,z).isOpaqueCube() || world.getBlock(x+1,y,z).isOpaqueCube() || world.getBlock(x,y,z-1).isOpaqueCube() || world.getBlock(x,y,z+1).isOpaqueCube())
				{
					world.setBlock(x, y, z, Blocks.torch);
					itemStack.damageItem(1, player);
					return true;
				}
			}
			//if tryAdvanced isnt true, the block face clicked should be solid and we simply put the torch here
			//we dont need to worry about any other blocks being there, because at the very least it will attach
			//to the block that is clicked on
			else
			{
				world.setBlock(x, y, z, Blocks.torch);
				itemStack.damageItem(1, player);
				return true;
			}
		}
		return false;
	}
	
	
	//TODO Add torch sucking? Light under feet?
	@Override
	public void onUpdate(ItemStack itemStack, World world, Entity entity, int p_77663_4_, boolean p_77663_5_)
	{
		
	}
	//TODO testing purposes only. Remove before actual release
	@Override
	public boolean showDurabilityBar(ItemStack itemStack)
	{
		return true;
	}
	
	//allows the tool to be reparable. tests if the item trying to be used is equal to a torch
	public boolean getIsRepairable(ItemStack toRepair, ItemStack stack)
	{
		return stack.getItem() == Item.getItemFromBlock(Blocks.torch);
	}
}
