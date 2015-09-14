package com.sinapze.solariapex.block;

import net.minecraft.block.material.Material;

//super basic block that is just for decoration. Simply calls the baseblock constructor
public class BlockSivart extends BaseBlock{

	public BlockSivart() 
	{
		super("sivartBlock", Material.rock, soundTypeStone, 4.0F, 10F, "pickaxe", 1);
	}

}
