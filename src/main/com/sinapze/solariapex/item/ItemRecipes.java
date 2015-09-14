package com.sinapze.solariapex.item;

import com.sinapze.solariapex.item.ModItems;
import com.sinapze.solariapex.block.ModBlocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.ItemStack;

//Holds the item related recipes

public class ItemRecipes {
	
	//Can contain multiple types of recipes, eg registerFurncaeRecipes for a furnace, registerPulverizerRecipes for a pulverizer
	
	//Self explanatory, shaped recipes go in this function. 
	private static void registerShapedRecipes()
	{
		
	}
	
	//Shapeless recipes go here
	private static void registerShapelessRecipes()
	{
		GameRegistry.addShapelessRecipe(new ItemStack(ModItems.sivartDust, 9), new Object[] {ModBlocks.sivartBlock});
	}
	
	//Called by the CommonProxy init, just calls the other functions in this class above
	public static void registerItemRecipes()
	{
		registerShapedRecipes();
		registerShapelessRecipes();
	}
}
