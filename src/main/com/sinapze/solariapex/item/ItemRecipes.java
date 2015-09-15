package com.sinapze.solariapex.item;

import com.sinapze.solariapex.item.ModItems;
import com.sinapze.solariapex.block.ModBlocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

//Holds the item related recipes

public class ItemRecipes {
	
	//Can contain multiple types of recipes, eg registerFurncaeRecipes for a furnace, registerPulverizerRecipes for a pulverizer
	
	//Self explanatory, shaped recipes go in this function. 
	private static void registerShapedRecipes()
	{
		//recipes for armor
		GameRegistry.addRecipe(new ItemStack(ModItems.evoliteHelm), new Object[] {"XXX", "X X", "   ", 'X', ModItems.evoliteIngot});
		GameRegistry.addRecipe(new ItemStack(ModItems.evoliteChest), new Object[]{"X X", "XXX", "XXX", 'X', ModItems.evoliteIngot});
		GameRegistry.addRecipe(new ItemStack(ModItems.evoliteLegs), new Object[]{"XXX", "X X", "X X", 'X', ModItems.evoliteIngot});
		GameRegistry.addRecipe(new ItemStack(ModItems.evoliteBoots), new Object[]{"   ", "X X", "X X", 'X', ModItems.evoliteIngot});
		
		//recipes for tools
		GameRegistry.addRecipe(new ItemStack(ModItems.evolitePick), new Object[]{"XXX", " Y ", " Y ", 'Y', Items.stick, 'X', ModItems.evoliteIngot});
		GameRegistry.addRecipe(new ItemStack(ModItems.evoliteSword), new Object[]{" X ", " X ", " Y ", 'Y', Items.stick, 'X', ModItems.evoliteIngot});
		GameRegistry.addRecipe(new ItemStack(ModItems.evoliteAxe), new Object[]{"XX ", "XY ", " Y ", 'Y', Items.stick, 'X', ModItems.evoliteIngot});
		GameRegistry.addRecipe(new ItemStack(ModItems.evoliteShovel), new Object[]{" X ", " Y ", " Y ", 'Y', Items.stick, 'X', ModItems.evoliteIngot});
		GameRegistry.addRecipe(new ItemStack(ModItems.evoliteHoe), new Object[]{"XX ", " Y ", " Y ", 'Y', Items.stick, 'X', ModItems.evoliteIngot});
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
