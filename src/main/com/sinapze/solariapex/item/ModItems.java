package com.sinapze.solariapex.item;

import com.sinapze.solariapex.item.equipment.armor.blyze.ItemBlyzeBoots;
import com.sinapze.solariapex.item.equipment.armor.blyze.ItemBlyzeChest;
import com.sinapze.solariapex.item.equipment.armor.blyze.ItemBlyzeHelm;
import com.sinapze.solariapex.item.equipment.armor.blyze.ItemBlyzeLegs;
import com.sinapze.solariapex.item.equipment.armor.evolite.ItemEvoliteBoots;
import com.sinapze.solariapex.item.equipment.armor.evolite.ItemEvoliteChest;
import com.sinapze.solariapex.item.equipment.armor.evolite.ItemEvoliteHelm;
import com.sinapze.solariapex.item.equipment.armor.evolite.ItemEvoliteLegs;
import com.sinapze.solariapex.item.equipment.tool.blyze.ItemBlyzeSword;
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
	public static Item blyzeChunk;
	
	//armor items
	public static Item evoliteHelm;
	public static Item evoliteChest;
	public static Item evoliteLegs;
	public static Item evoliteBoots;
	
	public static Item blyzeHelm;
	public static Item blyzeChest;
	public static Item blyzeLegs;
	public static Item blyzeBoots;
	
	//tool items
	public static Item evoliteSword;
	public static Item evolitePick;
	public static Item evoliteAxe;
	public static Item evoliteShovel;
	public static Item evoliteHoe;
	
	public static Item blyzeSword;
	public static Item blyzePick;
	public static Item blyzeAxe;
	public static Item blyzeShovel;
	public static Item blyzeHoe;
	
	public static void init()
	{
		//actual items
		GameRegistry.registerItem(sivartDust = new ItemSivartDust(), "sivartDust");
		GameRegistry.registerItem(evoliteIngot = new ItemEvoliteIngot(), "evoliteIngot");
		GameRegistry.registerItem(blyzeChunk = new ItemBlyzeChunk(), "blyzeChunk");
		
		//armor items
		GameRegistry.registerItem(evoliteHelm = new ItemEvoliteHelm(), "evoliteHelm");
		GameRegistry.registerItem(evoliteChest = new ItemEvoliteChest(), "evoliteChest");
		GameRegistry.registerItem(evoliteLegs = new ItemEvoliteLegs(), "evoliteLegs");
		GameRegistry.registerItem(evoliteBoots = new ItemEvoliteBoots(), "evoliteBoots");
		
		GameRegistry.registerItem(blyzeHelm = new ItemBlyzeHelm(),  "blyzeHelm");
		GameRegistry.registerItem(blyzeChest = new ItemBlyzeChest(), "blyzeChest");
		GameRegistry.registerItem(blyzeLegs = new ItemBlyzeLegs(), "blyzeLegs");
		GameRegistry.registerItem(blyzeBoots = new ItemBlyzeBoots(), "blyzeBoots");
		
		//tool items
		GameRegistry.registerItem(evoliteSword = new ItemEvoliteSword("evoliteSword"), "evoliteSword");
		GameRegistry.registerItem(evolitePick = new ItemEvolitePick("evolitePick"), "evolitePick");
		GameRegistry.registerItem(evoliteAxe = new ItemEvoliteAxe("evoliteAxe"), "evoliteAxe");
		GameRegistry.registerItem(evoliteShovel = new ItemEvoliteShovel("evoliteShovel"), "evoliteShovel");
		GameRegistry.registerItem(evoliteHoe = new ItemEvoliteHoe("evoliteHoe"), "evoliteHoe");
		
		GameRegistry.registerItem(blyzeSword = new ItemBlyzeSword("blyzeSword"), "blyzeSword");
	}
}
