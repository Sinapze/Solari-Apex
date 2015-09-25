package com.sinapze.solariapex.item.equipment.armor.blyze;

import com.sinapze.solariapex.SolariApex;
import com.sinapze.solariapex.item.ItemBlyzeChunk;
import com.sinapze.solariapex.item.ItemEvoliteIngot;
import com.sinapze.solariapex.item.ModItems;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.world.World;
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
	
	//private Block[] blocksToChange = new Block[10]; //place to store last 10 blocks
	//private int toLight = 9;
	//private int toDelight = 0;
	
	@Override
	public void onArmorTick(World world, EntityPlayer player, ItemStack itemStack)
	{
		/* This function was supposed to light up the last 10 blocks.
		 * However world.getBlock returns a block type, and therefore it applies light to all blocks
		 * of that type. aka giving every single grass block a light level of 15
		if (player.getCurrentArmor(0) != null && player.getCurrentArmor(0).getItem().equals(ModItems.blyzeBoots) && player.getCurrentArmor(1) != null && player.getCurrentArmor(1).getItem().equals(ModItems.blyzeLegs) && player.getCurrentArmor(2) != null && player.getCurrentArmor(2).getItem().equals(ModItems.blyzeChest) && player.getCurrentArmor(3) != null && player.getCurrentArmor(3).getItem().equals(ModItems.blyzeHelm))
		{
			int x = (int) player.lastTickPosX;
			int y = (int) player.lastTickPosY -1;
			int z = (int) player.lastTickPosZ;
			if (world.getBlock(x, y, z) != blocksToChange[toLight] && !world.getBlock(x, y, z).isAir(world, x, y, z) && world.getBlock(x, y, z).isOpaqueCube())
			{
				toLight = (toLight + 1) % blocksToChange.length; //loops back to 0 when it would reach 10, otherwise increments
				toDelight = (toDelight + 1) % blocksToChange.length; //loops back to 0 when it would reach 10, otherwise increments
				blocksToChange[toLight] = world.getBlock(x, y, z);
				
				System.out.println("We want to light" + blocksToChange[toLight]); //testing
				System.out.println("We want to delight" + blocksToChange[toDelight]);
				//blocksToChange[toLight].setLightLevel(1.0F);
				//blocksToChange[toDelight].setLightLevel(0.0F);
			}
			
		}
		*/
	}
}
