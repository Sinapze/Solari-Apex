package com.sinapze.solariapex.item;

import com.sinapze.solariapex.item.equipment.armor.evolite.ItemEvoliteBoots;
import com.sinapze.solariapex.item.equipment.armor.evolite.ItemEvoliteChest;
import com.sinapze.solariapex.item.equipment.armor.evolite.ItemEvoliteHelm;
import com.sinapze.solariapex.item.equipment.armor.evolite.ItemEvoliteLegs;
import com.sinapze.solariapex.item.equipment.tool.evolite.ItemEvoliteAxe;
import com.sinapze.solariapex.item.equipment.tool.evolite.ItemEvoliteHoe;
import com.sinapze.solariapex.item.equipment.tool.evolite.ItemEvolitePick;
import com.sinapze.solariapex.item.equipment.tool.evolite.ItemEvoliteShovel;
import com.sinapze.solariapex.item.equipment.tool.evolite.ItemEvoliteSword;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ModItems {

	//put all the actual items here
	public static Item sivartDust;
	public static Item evoliteIngot;
	
	//armor items
	public static Item evoliteHelm;
	public static Item evoliteChest;
	public static Item evoliteLegs;
	public static Item evoliteBoots;
	
	//tool items
	public static Item evoliteSword;
	public static Item evolitePick;
	public static Item evoliteAxe;
	public static Item evoliteShovel;
	public static Item evoliteHoe;
	
	public static void init()
	{
		//actual items
		GameRegistry.registerItem(sivartDust = new ItemSivartDust(), "sivartDust");
		GameRegistry.registerItem(evoliteIngot = new ItemEvoliteIngot(), "evoliteIngot");
		
		//armor items
		GameRegistry.registerItem(evoliteHelm = new ItemEvoliteHelm(), "evoliteHelm");
		GameRegistry.registerItem(evoliteChest = new ItemEvoliteChest(), "evoliteChest");
		GameRegistry.registerItem(evoliteLegs = new ItemEvoliteLegs(), "evoliteLegs");
		GameRegistry.registerItem(evoliteBoots = new ItemEvoliteBoots(), "evoliteBoots");
		
		//tool items
		GameRegistry.registerItem(evoliteSword = new ItemEvoliteSword("evoliteSword"), "evoliteSword");
		GameRegistry.registerItem(evolitePick = new ItemEvolitePick("evolitePick"), "evolitePick");
		GameRegistry.registerItem(evoliteAxe = new ItemEvoliteAxe("evoliteAxe"), "evoliteAxe");
		GameRegistry.registerItem(evoliteShovel = new ItemEvoliteShovel("evoliteShovel"), "evoliteShovel");
		GameRegistry.registerItem(evoliteHoe = new ItemEvoliteHoe("evoliteHoe"), "evoliteHoe");
	}
}
