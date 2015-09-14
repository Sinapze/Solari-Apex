package com.sinapze.solariapex.item;

import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

//Ingot class for evolite. Also defines the tool and armor materials
public class ItemEvoliteIngot extends ItemBase {

	public ItemEvoliteIngot()
	{
		super("evoliteIngot");
	}
	
	//adds the tool material EVOLITE, which has iron (2) mining level, durability of 500, speed of 7 (diamond 8, iron 6), 2.5 damage (3 is diamond), and 15 enchantability (iron is 14)
	public static ToolMaterial EVOLITE = EnumHelper.addToolMaterial("EVOLITE", 2, 500, 7.0F, 2.5F, 15);
	
	//adds the armor material EVOLITE_ARMOR which has durability of 20 (diamond 33, iron 15), has damage reduction of 17 (diamond 20) and enchantability of 13
	public static ArmorMaterial EVOLITE_ARMOR = EnumHelper.addArmorMaterial("EVOLITE_ARMOR", 20, new int[] {3, 6, 5, 3}, 13);
}
