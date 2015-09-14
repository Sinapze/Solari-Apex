package com.sinapze.solariapex.proxies;


import com.sinapze.solariapex.block.BlockRecipes;
import com.sinapze.solariapex.block.ModBlocks;
import com.sinapze.solariapex.item.ItemRecipes;
import com.sinapze.solariapex.item.ModItems;
import com.sinapze.solariapex.util.EventHandler;

import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.common.MinecraftForge;

public class CommonProxy {

	//Pre-initialization. Put config setup, create blocks, items and register them
    public void preInit(FMLPreInitializationEvent event) 
    {
    	System.out.println("Proxy pre-Initialization Start");
    	ModItems.init();
    	ModBlocks.init();
    }
    
    //Initialization. Put data structures, add crafting recipes and register new handlers
    public void init(FMLInitializationEvent event) 
    {
    	System.out.println("Proxy Initialization Start");
    	BlockRecipes.registerBlockRecipes();
    	ItemRecipes.registerItemRecipes();
    	MinecraftForge.EVENT_BUS.register(new EventHandler());
    }
    
    //Post-initialization. Put things that communicate based on other mods (ie detect botania and add recipes based on that)
    public void postInit(FMLPostInitializationEvent event) 
    {
    	System.out.println("Proxy post-Initialization Start");
    }
}
