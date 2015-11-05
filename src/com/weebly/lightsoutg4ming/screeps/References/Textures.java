package com.weebly.lightsoutg4ming.screeps.References;

import io.brace.lightsoutgaming.engine.graphics.Sprite;
import io.brace.lightsoutgaming.engine.graphics.SpriteSheet;

public class Textures {
	public static class Sheets{
		public static SpriteSheet Map = new SpriteSheet("/Textures/Map.png");
	}
	
	public static class Map{
		public static Sprite floor = new Sprite(0,0,1,16,Textures.Sheets.Map);
		public static Sprite wall = new Sprite(1,0,1,16,Textures.Sheets.Map);
		public static Sprite wallBL = new Sprite(2,0,1,16,Textures.Sheets.Map);
		public static Sprite wallBR = new Sprite(3,0,1,16,Textures.Sheets.Map);
		public static Sprite wallTL = new Sprite(0,1,1,16,Textures.Sheets.Map);
		public static Sprite wallTR = new Sprite(1,1,1,16,Textures.Sheets.Map);
		public static Sprite wallT = new Sprite(2,1,1,16,Textures.Sheets.Map);
		public static Sprite wallB = new Sprite(3,1,1,16,Textures.Sheets.Map);
		public static Sprite wallL = new Sprite(0,2,1,16,Textures.Sheets.Map);
		public static Sprite wallR = new Sprite(1,2,1,16,Textures.Sheets.Map);
		public static Sprite wallAllown = new Sprite(2,2,1,16,Textures.Sheets.Map);
		public static Sprite energy = new Sprite(3,2,1,16,Textures.Sheets.Map);
		public static Sprite Hover = new Sprite(0,3,1,16,Textures.Sheets.Map);
	}
}
