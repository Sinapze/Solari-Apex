package com.sinapze.solariapex.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ModItems {

	//put all the actual items here
	public static Item sivartDust;
	public static Item evoliteIngot;
	
	public static void init()
	{
		GameRegistry.registerItem(sivartDust = new ItemSivartDust(), "sivartDust");
		GameRegistry.registerItem(evoliteIngot = new ItemEvoliteIngot(), "evoliteIngot");
	}
}
