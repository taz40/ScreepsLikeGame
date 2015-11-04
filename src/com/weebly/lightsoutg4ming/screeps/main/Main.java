package com.weebly.lightsoutg4ming.screeps.main;

import java.awt.event.KeyEvent;

import com.weebly.lightsoutg4ming.screeps.References.Reference;

import io.brace.lightsoutgaming.engine.LightsOut;
import io.brace.lightsoutgaming.engine.input.Keyboard;

public class Main extends LightsOut {
	
	public static void main(String[] args){
		new Main().init();
	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub
		createDisplay(Reference.name + " v. " + Reference.version, Reference.width, Reference.height);
		start();
	}

	@Override
	protected void render() {
		// TODO Auto-generated method stub
		screen.clear();
		
		show();
	}

	@Override
	protected void update() {
		// TODO Auto-generated method stub
		if(Keyboard.getKey(KeyEvent.VK_SPACE)){
			for(int rx = 0; rx < 7; rx++){
				for(int ry = 0; ry < 7; ry++){
					
				}
			}
			Keyboard.keys[KeyEvent.VK_SPACE] = false;
		}
	}

}
