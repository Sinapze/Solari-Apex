package com.sinapze.solariapex.item;

import net.minecraft.creativetab.CreativeTabs;

//Super basic item, just a dust from Sivart Ore
public class ItemSivartDust extends ItemBase{

	public ItemSivartDust()
	{
		super("sivartDust"); //creates the item with unlocalized name "sivartDust"
		setCreativeTab(CreativeTabs.tabMaterials);
	}
}
