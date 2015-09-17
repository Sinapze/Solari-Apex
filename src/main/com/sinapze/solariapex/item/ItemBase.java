package com.sinapze.solariapex.item;

import com.sinapze.solariapex.SolariApex;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.item.Item;

//Base item class to extend when you create an item
public class ItemBase extends Item{

	public ItemBase(String unlocalizedName)
	{
		super(); //calls the item constructor
		setUnlocalizedName(unlocalizedName); //sets the unlocalized name
		setTextureName(SolariApex.MODID + ":" + unlocalizedName);
		setCreativeTab(SolariApex.tabSolariApex); //sets the items in the mod creative tab
	}
	
	//TODO Make this work so we can have armor icons in the jar?
	//@Override
	//@SideOnly(Side.CLIENT)
	//public void registerIcons(IIconRegister iconRegister)
	//{
		//itemIcon = iconRegister.registerIcon("solariapex/textures/items/sivartDust.png");
		//itemIcon = iconRegister.registerIcon(SolariApex.MODID + ":" + this.getUnlocalizedName());
				//return forName(ir, item.getUnlocalizedName().replaceAll("item\\.", ""));
	//}
}
