package com.sinapze.solariapex.item;

import com.sinapze.solariapex.SolariApex;

import net.minecraft.item.Item;

//Base item class to extend when you create an item
public class ItemBase extends Item{

	public ItemBase(String unlocalizedName)
	{
		super(); //calls the item constructor
		setUnlocalizedName(unlocalizedName); //sets the unlocalized name
		setTextureName(SolariApex.MODID + ":" + unlocalizedName);
		//setCreativeTab(SolariApex.tabSolariApex); //sets the items in the mod creative tab
	}
}
