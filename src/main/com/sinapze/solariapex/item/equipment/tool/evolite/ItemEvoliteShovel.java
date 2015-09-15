package com.sinapze.solariapex.item.equipment.tool.evolite;

import com.sinapze.solariapex.SolariApex;
import com.sinapze.solariapex.item.ItemEvoliteIngot;
import com.sinapze.solariapex.item.ModItems;

import net.minecraft.item.ItemSpade;
import net.minecraft.item.ItemStack;

//A basic shovel class that extends itemSpade from default minecraft
public class ItemEvoliteShovel extends ItemSpade{
	
	public ItemEvoliteShovel(String unlocalizedName)
	{
		super(ItemEvoliteIngot.EVOLITE); //we call the spade constructor with our evolite material
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(SolariApex.MODID + ":/tools/" + unlocalizedName);
		setCreativeTab(SolariApex.tabSolariApex); //sets the items in the mod creative tab
	}
	//allows the tool to be reparable. tests if the item trying to be used is equal to ModItems.evoliteIngot
	public boolean getIsRepairable(ItemStack toRepair, ItemStack material)
	{
		return material.getItem() == ModItems.evoliteIngot;
	}
}
