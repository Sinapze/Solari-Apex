package com.sinapze.solariapex.item.equipment.armor.evolite;

import com.sinapze.solariapex.SolariApex;
import com.sinapze.solariapex.item.ItemEvoliteIngot;
import com.sinapze.solariapex.item.ModItems;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.ISpecialArmor;

public class ItemEvoliteArmor extends ItemArmor implements ISpecialArmor {
	
	//create a string to hold our texture name
	private static String TEXTURE_NAME;

	//create a constructor that will be called by the other evolite armor classes with just type and name
	public ItemEvoliteArmor(int type, String unlocalizedName)
	{
		this(unlocalizedName, ItemEvoliteIngot.EVOLITE_ARMOR, type); //calls constructor below with the evolite armor material
	}
	
	//overload the constructor with addition of material.
	public ItemEvoliteArmor(String unlocalizedName, ArmorMaterial material,  int armorType)
	{
		super(material, 0, armorType); //calls the itemarmor constructor with our material, render version 0, and the integer of armor type
		this.setUnlocalizedName(unlocalizedName);
		this.setTextureName(SolariApex.MODID + ":/armor/" + unlocalizedName);
		setCreativeTab(SolariApex.tabSolariApex); //sets the items in the mod creative tab
	}

	//override this function to get our armor texture for the actual model (not item icon). 
	@Override
	public String getArmorTexture(ItemStack stack, Entity entity, int slot, String type)
	{
		//complicated, but basically the files need to be under /assets/modid/textures/armor and then have filename 
		//TEXTURE_NAME_1 or 2.png. 1 has helmet, chest and boots, 2 has legs.
		return SolariApex.MODID + ":textures/armor/" + TEXTURE_NAME + "_" + (this.armorType == 2 ? "2" : "1") + ".png";
	}
	
	//allows the armor to be reparable. tests if the item trying to be used is equal to ModItems.evoliteIngot
	public boolean getIsRepairable(ItemStack toRepair, ItemStack material)
	{
		return material.getItem() == ModItems.evoliteIngot;
	}
		
	@Override
	public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage,
			int slot) 
	{
		//Stolen from botania's itemmanastellarmor class. will modify later
		return new ArmorProperties(0, damageReduceAmount / 25D, armor.getMaxDamage() + 1 - armor.getItemDamage());
	}

	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) {
		// TODO Auto-generated method stub
		
	}

}
