package com.si.igame.desktop;

import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.si.igame.iGame;

public class DesktopLauncher 
{
	public static void main (String[] arg) 
        {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		
                config.width = 1366;
                config.height = 768;
		config.title = "mygame";
		
		new LwjglApplication(new iGame(), config);
	}
}
