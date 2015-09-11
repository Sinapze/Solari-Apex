package com.sinapze.solariapex.block;

//Holds the block related recipes

public class BlockRecipes {
	
	//Can contain multiple types of recipes, eg registerFurncaeRecipes for a furnace, registerPulverizerRecipes for a pulverizer
	
	//Self explanatory, shaped recipes go in this function. 
	private static void registerShapedRecipes()
	{
		
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
