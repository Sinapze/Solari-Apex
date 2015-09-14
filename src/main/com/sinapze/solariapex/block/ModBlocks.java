package com.sinapze.solariapex.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class ModBlocks {

	public static Block sivartOre;
	public static Block sivartBlock;
	public static Block sivartLamp;
	
	public static Block evoliteOre;
	public static Block evoliteBlock;
	
	public static void init()
	{
		GameRegistry.registerBlock(sivartOre = new BlockSivartOre(), "sivartOre");
		GameRegistry.registerBlock(sivartBlock = new BlockSivart(), "sivartBlock");
		GameRegistry.registerBlock(sivartLamp = new BlockSivartLamp(), "sivartLamp");
		GameRegistry.registerBlock(evoliteOre = new BlockEvoliteOre(), "evoliteOre");
		GameRegistry.registerBlock(evoliteBlock = new BlockEvolite(), "evoliteBlock");
	}
}
