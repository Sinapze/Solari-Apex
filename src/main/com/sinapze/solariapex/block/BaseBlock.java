package com.sinapze.solariapex.block;

import com.sinapze.solariapex.SolariApex;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.creativetab.CreativeTabs;


//A base block class which contains most everything you want in a basic block.
//Just extend this class when you make a new basic block and call super() with the appropriate values you want
public class BaseBlock extends Block {
	
	public BaseBlock(String unlocalizedName, Material material, SoundType soundType, float hardness, float resistance, String tool, int harvestLevel)
	{
		super(material); //calls the block constructor which only has the material arg
		this.setBlockName(unlocalizedName);
		this.setBlockTextureName(SolariApex.MODID + ":" + unlocalizedName);
		this.setCreativeTab(CreativeTabs.tabBlock);
		this.setHardness(hardness); //how long it takes to break. stone has 1.5, obsidian has 50.0
		this.setResistance(resistance); //resistance to explosion. stone has 10.0, obsidian has 2,000.0
		this.setHarvestLevel(tool, harvestLevel); //set which tool is effective against the block (pickaxe, axe, shovel), and the level of tool 0=wood, 3=diamond
		this.setStepSound(soundType); //set which sound it makes when you walk on it
		
		/*
		* other possible but not necessary options which are better to set in the individual block classes
		* so you do not have too many arguments every time 
		* this.setLightLevel() for light emitting blocks (0 is nothing, 1 is full sunlight)
		* this.setBlockUnbreakable() self explanatory, essentially makes it like bedrock, completely unbreakable
		* this.setTickRandomly() it will receive random update ticks, useful for variable things like decaying leaves
		*/
	}
	
	/*
	 * Other useful and specific block functions. You should just override from the specific block class
	 * 
	 * Tells the game whether entities (like wither and enderdragon) can destroy it
	 * public boolean canEntityDestroy(IBlockAccess world, int x, int y, int z, Entity entity){}
	 * 
	 * Tells the game whether this block can act as a beacon base
	 * public boolean isBeaconBase(IBlockAccess worldObj, int x, int y, int z, int beaconX, int beaconY, int beaconZ){}
	 * 
	 * Tells the game that this block can provide power to an enchantment table (like a bookshelf)
	 * public float getEnchantPowerBonus(World world, int x, int y, int z){}
	 * 
	 * How much XP it drops when broken. Use only for dust ores and the like
	 * public int getExpDrop(IBlockAccess world, int metadata, int fortune){}
	 * 
	 */
}
