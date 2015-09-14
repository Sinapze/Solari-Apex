package com.sinapze.solariapex.block;

import net.minecraft.block.material.Material;

//Block made of a sivart block plus redstone and glowstone
//Acts as a togleable light source
public class BlockSivartLamp extends BaseBlock{

	public BlockSivartLamp() {
		super("sivartLamp", Material.rock, soundTypeStone, 4.0F, 5.0F, "pickaxe", 1);
		this.setLightLevel(1.0F);
		
		//TODO get redstone responsiveness
	}

}
