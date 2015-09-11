package com.sinapze.solariapex.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class ModBlocks {

	public static Block sivartOre;
	
	public static void init()
	{
		GameRegistry.registerBlock(sivartOre = new BlockSivartOre(), "sivartOre");
	}
}
