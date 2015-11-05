package com.weebly.lightsoutg4ming.screeps.Entities;

import com.weebly.lightsoutg4ming.screeps.References.Textures;

import io.brace.lightsoutgaming.engine.Network.Networked;
import io.brace.lightsoutgaming.engine.graphics.Screen;

public class Spawn extends Networked {

	@Override
	public String[] send() {
		// TODO Auto-generated method stub
		return new String[] {x+"", y+""};
	}

	@Override
	public void recv(String[] data) {
		// TODO Auto-generated method stub
		x = Integer.parseInt(data[0]);
		y = Integer.parseInt(data[1]);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void render(Screen s) {
		// TODO Auto-generated method stub
		s.renderSprite(x, y, Textures.Entities.Spawn, true);
	}

}
