package com.weebly.lightsoutg4ming.screeps.Entities;

import java.awt.Graphics;

public abstract class Entity {
	
	int x, y;
	
	public abstract void draw(Graphics g);
	public abstract void update();
}
