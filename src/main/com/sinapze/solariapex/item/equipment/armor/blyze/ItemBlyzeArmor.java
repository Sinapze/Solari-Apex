package com.sinapze.solariapex.item.equipment.armor.blyze;

import com.sinapze.solariapex.SolariApex;
import com.sinapze.solariapex.item.ItemBlyzeChunk;
import com.sinapze.solariapex.item.ItemEvoliteIngot;
import com.sinapze.solariapex.item.ModItems;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.util.DamageSource;
import net.minecraftforge.common.ISpecialArmor;

public class ItemBlyzeArmor extends ItemArmor implements ISpecialArmor{
	
	//create a string to hold our texture name
	private static String TEXTURE_NAME = "blyze";
	
	//create a constructor that will be called by the other blyze armor classes with just type and name
	public ItemBlyzeArmor(int type, String unlocalizedName)
	{
		this(unlocalizedName, ItemBlyzeChunk.BLYZE_ARMOR, type); //calls constructor below with the blyze armor material
	}

	//overload the constructor with addition of material.
	public ItemBlyzeArmor(String unlocalizedName, ArmorMaterial material,  int armorType)
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
		
	//allows the armor to be reparable. tests if the item trying to be used is equal to ModItems.blyzeChunk
	public boolean getIsRepairable(ItemStack toRepair, ItemStack material)
	{
		return material.getItem() == ModItems.blyzeChunk;
	}
		
	@Override
	public ArmorProperties getProperties(EntityLivingBase player, ItemStack armor, DamageSource source, double damage,
			int slot) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getArmorDisplay(EntityPlayer player, ItemStack armor, int slot) {
		return damageReduceAmount;
	}

	@Override
	public void damageArmor(EntityLivingBase entity, ItemStack stack, DamageSource source, int damage, int slot) {
		// TODO Auto-generated method stub
		
	}
}
