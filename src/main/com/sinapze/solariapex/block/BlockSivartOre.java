package com.sinapze.solariapex.block;

import java.util.Random;

import com.sinapze.solariapex.item.ModItems;

import net.minecraft.block.material.Material;
import net.minecraft.item.Item;
import net.minecraft.world.IBlockAccess;

public class BlockSivartOre extends BaseBlock{

	private Item drop;
	private int meta;
	private int least_quantity;
	private int most_quantity;
	
	//Call the BaseBlock constructor with necessary arguments
	public BlockSivartOre()
	{
		super("sivartOre", Material.rock, soundTypeStone, 3F, 10F, "pickaxe", 3);
		this.drop = ModItems.sivartDust;
		this.meta = 1;
		this.least_quantity = 2;
		this.most_quantity = 5;
	}
	
	@Override
	public Item getItemDropped(int meta, Random random, int fortune)
	{
		return this.drop;
	}
	
	@Override
	public int damageDropped(int metadata)
	{
		return this.meta;
	}
	
	@Override
	public int quantityDropped(int meta, int fortune, Random random)
	{
		return (this.least_quantity + random.nextInt(this.most_quantity - this.least_quantity + fortune + 1));
	}
	
	@Override
	public int getExpDrop(IBlockAccess world, int metadata, int fortune)
	{
		return (3 + fortune);
	}
}

