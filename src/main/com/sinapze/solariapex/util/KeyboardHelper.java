package com.sinapze.solariapex.util;

//Place to store keyboard press events

import org.lwjgl.input.Keyboard;

public class KeyboardHelper {

	//example of watching for a keypress, in this case either control key
	public static boolean isControlDown()
	{
		return Keyboard.isKeyDown(Keyboard.KEY_LCONTROL) || Keyboard.isKeyDown(Keyboard.KEY_LCONTROL);
	}
}
