package com.sinapze.solariapex.util;

import cpw.mods.fml.common.eventhandler.EventPriority;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayerMP;

//Used to register custom events. May need to have another class for some events.
@SuppressWarnings("unused")
public class EventHandler {


	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void onEvent(LivingHurtEvent event)
	{
		//TODO Make this work
		//System.out.println(event.entity + "is about to take damage " + event.ammount + " of type " + event.source.getDamageType() + " from source " + event.source.getSourceOfDamage());
		//Entity damageSource = event.source.getSourceOfDamage();
		//int damageTarget = event.entity.getEntityId();
		//System.out.println("Entity Id: " + damageTarget + " Position X: " + event.entity.posX + " Y: " + event.entity.posY + "Z: " + event.entity.posZ );
		//System.out.println("Damage Source X: " + damageSource.posX + " Y: " + damageSource.posY + "Z: " + damageSource.posZ);
		
		//double differenceX = event.entity.posX - damageSource.posX;
		//double differenceY = event.entity.posY - damageSource.posY;
		//double differenceZ = event.entity.posZ - damageSource.posZ;
		
		//System.out.println("Difference X: " + differenceX + " Y: " + differenceY + " Z: " + differenceZ);
		//event.entity.addVelocity((differenceX * (-0.5)), 0, (differenceY * (-0.5))); //works but is kinda janky
		//((EntityLivingBase) event.entity).knockBack(event.entity, 100F, 0, 1); //too complicated? unknown parameters
		}
	
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void onEvent(LivingAttackEvent event)
	{
		//System.out.println("Attack on " + event.entity + " for " + event.ammount + " from damage source " + event.source);
	}
}
