package com.sinapze.solariapex.item;

import com.sinapze.solariapex.item.equipment.armor.evolite.ItemEvoliteHelm;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ModItems {

	//put all the actual items here
	public static Item sivartDust;
	public static Item evoliteIngot;
	
	//armor items
	public static Item evoliteHelm;
	
	public static void init()
	{
		//actual items
		GameRegistry.registerItem(sivartDust = new ItemSivartDust(), "sivartDust");
		GameRegistry.registerItem(evoliteIngot = new ItemEvoliteIngot(), "evoliteIngot");
		
		//armor items
		GameRegistry.registerItem(evoliteHelm = new ItemEvoliteHelm(), "evoliteHelm");
	}
}
