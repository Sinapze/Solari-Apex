package com.sinapze.solariapex.item;

import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class ItemBlyzeChunk extends ItemBase{
	
	public ItemBlyzeChunk()
	{
		super("blyzeChunk");
	}

	//adds the tool material BLYZE, which has diamond (3) mining level, durability of 2000, speed of 10 (diamond 8, iron 6), 4 damage (3 is diamond), and 22 enchantability (iron is 14)
	public static ToolMaterial BLYZE = EnumHelper.addToolMaterial("BLYZE", 3, 2000, 10.0F, 4F, 22);
		
	//adds the armor material BLYZE_ARMOR which has durability of 45 (diamond 33, iron 15), has damage reduction of 22 (diamond 20) and enchantability of 25 (gold enchantability)
	public static ArmorMaterial BLYZE_ARMOR = EnumHelper.addArmorMaterial("BLYZE_ARMOR", 45, new int[] {4, 8, 6, 4}, 25);
}
