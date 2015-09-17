package com.sinapze.solariapex.item.equipment.tool.blyze;

import com.sinapze.solariapex.SolariApex;
import com.sinapze.solariapex.item.ItemBlyzeChunk;
import com.sinapze.solariapex.item.ItemEvoliteIngot;
import com.sinapze.solariapex.item.ModItems;

import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;

//A sword class that extends itemSword from default minecraft
public class ItemBlyzeSword extends ItemSword{
	
	public ItemBlyzeSword(String unlocalizedName)
	{
		super(ItemBlyzeChunk.BLYZE); //we call the itemsword constructor with our evolite material
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
