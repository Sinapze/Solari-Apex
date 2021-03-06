package com.sinapze.solariapex.block;

import com.sinapze.solariapex.item.ModItems;
import com.sinapze.solariapex.block.ModBlocks;
import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

//Holds the block related recipes

public class BlockRecipes {
	
	//Can contain multiple types of recipes, eg registerFurncaeRecipes for a furnace, registerPulverizerRecipes for a pulverizer
	
	//Self explanatory, shaped recipes go in this function. 
	private static void registerShapedRecipes()
	{
		GameRegistry.addRecipe(new ItemStack(ModBlocks.sivartBlock), new Object[] {"XXX", "XXX", "XXX", 'X', ModItems.sivartDust});
		GameRegistry.addRecipe(new ItemStack(ModBlocks.sivartLamp), new Object[] {" R ", "GXG", " G ", 'R', Items.redstone, 'G', Items.glowstone_dust, 'X', ModBlocks.sivartBlock});
	}
	
	//Shapeless recipes go here
	private static void registerShapelessRecipes()
	{
		
	}
	
	//Called by the CommonProxy init, just calls the other functions in this class above
	public static void registerBlockRecipes()
	{
		registerShapedRecipes();
		registerShapelessRecipes();
	}
}
