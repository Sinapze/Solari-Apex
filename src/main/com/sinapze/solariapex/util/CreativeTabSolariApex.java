package com.sinapze.solariapex.util;

import com.sinapze.solariapex.SolariApex;
import com.sinapze.solariapex.item.ModItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTabSolariApex extends CreativeTabs{

	public CreativeTabSolariApex(String tabLabel)
	{
		super(tabLabel);
		setBackgroundImageName(SolariApex.MODID + ".png"); //The image automatically has tab_ applied to it so name accordingly
	}
	
	//just tells the game that the tab gui has a space for a search bar
	public boolean hasSearchBar()
	{
		return true;
	}
	
	//Set the tab icon as the return value
	@Override
	public ItemStack getIconItemStack()
	{
		return new ItemStack(ModItems.sivartDust);
	}
	
	@Override
	public Item getTabIconItem()
	{
		return new Item();
	}
}
