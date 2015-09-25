package com.sinapze.solariapex.item.equipment.tool;

import java.util.List;

import com.sinapze.solariapex.SolariApex;
import com.sinapze.solariapex.block.ModBlocks;
import com.sinapze.solariapex.item.ItemBase;
import com.sinapze.solariapex.item.ModItems;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.BlockTorch;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

@SuppressWarnings("unused")

public class ItemDaybreak extends ItemBase{

	IIcon onIcon; //create icons names to hold our on and off icons
	IIcon offIcon;
	
	public ItemDaybreak() 
	{
		super("daybreak");
		this.setMaxStackSize(1); //makes it so you cant have more than 1 in a slot
		setHasSubtypes(true); //tells the game we have subtypes (for the different textures)
	}

	
	@Override
	public void onCreated(ItemStack itemStack, World world, EntityPlayer player) 
	{
		//when the item is created, we attach a nbt tag compound to it and then set a long with key "torchNum"
		//initially we want this to be 0, and it will increase as torches are added to it
		itemStack.stackTagCompound = new NBTTagCompound();
		itemStack.stackTagCompound.setLong("torchNum", 0);
	}
	

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	@SideOnly(Side.CLIENT)
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean adv) 
	{
		//add a check to see if there is any nbttag yet, because when in a creative menu there isnt and it crashes when it tries to render it
		if (itemStack.stackTagCompound != null)
		{
			long torchNum = itemStack.stackTagCompound.getLong("torchNum");
			list.add(EnumChatFormatting.YELLOW + "Torches Stored: " + torchNum);
		}
		else //if there isnt a nbt tag just put a placeholder until it is actually spawned in and onUpdate gives it one
			list.add(EnumChatFormatting.YELLOW + "Torches Stored: ");
	}
	
	@Override
	public boolean onItemUse(ItemStack itemStack, EntityPlayer player, World world, int x, int y, int z, int side, float par8, float par9, float par10)
	{
		boolean isSolid = false; //create a flag to use later and initialize it to false
		long torchNum = itemStack.stackTagCompound.getLong("torchNum"); //the NBT tag that holds the amount of torches stored
		//we first check to see if we have any stored torches in the daybreak. otherwise we cant place one
		if (torchNum > 0)
		{
			//then first check if the block we are clicking on is some sort of "replacable" like grass, snow, lava, water etc
			if(world.getBlock(x, y, z).isReplaceable(world, x, y, z))
			{
				world.setBlock(x, y, z, Blocks.torch); //if it is replacable we replace it with the torch
				itemStack.stackTagCompound.setLong("torchNum", torchNum - 1); //if we placed the torch, we want to update the torchNum by subtracting 1
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
		long torchNum = itemStack.stackTagCompound.getLong("torchNum"); //the NBT tag that holds the amount of torches stored
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
					itemStack.stackTagCompound.setLong("torchNum", torchNum - 1);
					return true;
				}
			}
			//if tryAdvanced isnt true, the block face clicked should be solid and we simply put the torch here
			//we dont need to worry about any other blocks being there, because at the very least it will attach
			//to the block that is clicked on
			else
			{
				world.setBlock(x, y, z, Blocks.torch);
				itemStack.stackTagCompound.setLong("torchNum", torchNum - 1);
				return true;
			}
		}
		return false;
	}
	
	
	@Override
	public void onUpdate(ItemStack itemStack, World world, Entity entity, int p_77663_4_, boolean p_77663_5_)
	{
		EntityPlayer player = (EntityPlayer) entity; //cast our entity as a player so we can use player functions
		//a check to make sure the nbt tag for storing the number of torches exists. if it doesnt (pulled from creative, glitch) we make it and set torchNum to 0
		if (itemStack.stackTagCompound == null)
		{
			itemStack.stackTagCompound = new NBTTagCompound();
			itemStack.stackTagCompound.setLong("torchNum", 0);
		}
		//make an integer array that is the length of the players inventory
		int[] slots = new int[player.inventory.getSizeInventory() - player.inventory.armorInventory.length];
		
		for (int i = 0; i < slots.length; i++) //start a for loop to go through each slot of inventory
		{
			long torchNum = itemStack.stackTagCompound.getLong("torchNum"); //get our current amount stored before each iteration
			ItemStack stack = player.inventory.getStackInSlot(i); //get the stack we are currently looking at
			if(stack == null) //if the slot is empty we just want to go to the next iteration
				continue;
			else if (stack.getItem() == Item.getItemFromBlock(Blocks.torch)) //if the slot contains torches
			{
				itemStack.stackTagCompound.setLong("torchNum", torchNum + stack.stackSize); //we add the stacksize to our tag
				player.inventory.setInventorySlotContents(i, null); //and delete the torches out of the inventory
			}
		}
		//every tick, we check to see if the number of torches is greater than 0. if it is, we set damage to 1 (on) or if it isnt set it to 0 (off)
		if (itemStack.stackTagCompound.getLong("torchNum") > 0)
			itemStack.setItemDamage(1);
		else
			itemStack.setItemDamage(0);
	}
	
	//this is where we define where the textures come from for the on and off states
	@Override
	@SideOnly(Side.CLIENT)
	public void registerIcons(IIconRegister reg) 
	{
		offIcon = reg.registerIcon(SolariApex.MODID + ":/tools/daybreak_0");
		onIcon = reg.registerIcon(SolariApex.MODID + ":/tools/daybreak_1");
	}
	
	//this function is used to change the texture based on the item damage. 0 == off, 1 == on
	@Override
	@SideOnly(Side.CLIENT)
	public IIcon getIconFromDamage(int damage) 
	{
		return (damage == 1) ? onIcon : offIcon;
	}

}
