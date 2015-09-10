package com.sinapze.solariapex;

import cpw.mods.fml.common.SidedProxy;

import com.sinapze.solariapex.proxies.CommonProxy;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

//tells forge mod loader that this is a mod, with modid, name, and version. We get these values from statics below
@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION)
public class Main {

	//we declare a modid, modname and version as statics so we can reference them from anywhere else and know we just need to change them here
	public static final String MODID = "solariapex";
	public static final String MODNAME = "Solari Apex";
	public static final String VERSION = "0.0.1";
	
	//creates a new instance of the mod, which actually makes it run when we load it
	@Instance(MODID)
	public static Main instance;
	
	//create a proxy which determines whether the mod is running on client or server side
	@SidedProxy(clientSide= "com.sinapze.solariapex.proxies.ClientProxy", serverSide="com.sinapze.solariapex.proxies.ServerProxy")
	public static CommonProxy proxy; //actually makes the proxy
		
	//Pre-initialization. Put config setup, create blocks, items and register them
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		proxy.preInit(event); //we call the commonproxy preinit event as it will handle everything that needs to pre-init on both client and server 
		System.out.println("Pre-Initialization Start"); //debug info, shows in console when events happen
	}
		
	//Initialization. Put data structures, add crafting recipes and register new handlers
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		proxy.init(event); //we call commonproxy init, as above it handles both server and client init
		System.out.println("Initialization Start");
	}
		
	//Post-initialization. Put things that communicate based on other mods (ie detect botania and add recipes based on that)
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		proxy.postInit(event); //call commonproxy postinit for same reasons above
		System.out.println("Post-Initialization Start");
	}	
}
