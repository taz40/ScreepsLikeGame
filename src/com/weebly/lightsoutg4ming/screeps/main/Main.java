package com.weebly.lightsoutg4ming.screeps.main;

import com.weebly.lightsoutg4ming.screeps.References.Reference;

import io.brace.lightsoutgaming.engine.LightsOut;

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
		
	}

}
