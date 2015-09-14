package com.sinapze.solariapex.block;

import java.util.Random;

import com.sinapze.solariapex.item.ModItems;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;


//A block that is an ore that drops dusts, not the block itself (like redstone, lapis)
public class BlockSivartOre extends BaseBlock{

	//define some variables we want to use in regards to what/how many items this block drops
	private Item dropItem;
	private int meta;
	private int least_quantity;
	private int most_quantity;
	
	//Call the BaseBlock constructor with necessary arguments
	public BlockSivartOre()
	{
		super("sivartOre", Material.rock, soundTypeStone, 3F, 10F, "pickaxe", 3);
		this.dropItem = ModItems.sivartDust; //when broken this is the item that is dropped
		this.meta = 1; //the metadata of the dropped item
		this.least_quantity = 2; //the smallest amount of item dropped
		this.most_quantity = 5; //the highest amount of the item dropped
	}
	
	//override this function so that the block drops our item instead of the block itself
	@Override
	public Item getItemDropped(int meta, Random random, int fortune)
	{
		return this.dropItem;
	}
	
	//override this function to set the metadata of the item that is dropped
	@Override
	public int damageDropped(int metadata)
	{
		return this.meta;
	}
	
	//this function determines the amount of items that are dropped
	@Override
	public int quantityDropped(int meta, int fortune, Random random)
	{
		//we return the lowest plus a random number between highest and lowest plus the level of fortune plus 1
		//in practice this returns 2 to 5 (plus 1 per level of fortune (max 8))
		return (this.least_quantity + random.nextInt(this.most_quantity - this.least_quantity + fortune + 1));
	}
	
	//this function tells the game how much xp to drop when the block breaks
	@Override
	public int getExpDrop(IBlockAccess world, int metadata, int fortune)
	{
		//we return a base of 3 plus the level of fortune
		return (3 + fortune);
	}
}

