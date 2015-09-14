package com.sinapze.solariapex.block;

import net.minecraft.block.material.Material;

//Pretty basic block, an ore that drops iteself like iron and gold ore
public class BlockEvoliteOre extends BaseBlock{

	public BlockEvoliteOre()
	{
		//simply calls the baseblock constructor with required fields
		super("evoliteOre", Material.rock, soundTypeStone, 3F, 10F, "pickaxe", 2);
	}
}
