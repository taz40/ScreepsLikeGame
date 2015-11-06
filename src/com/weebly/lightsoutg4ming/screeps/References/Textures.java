package com.weebly.lightsoutg4ming.screeps.References;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Textures {
	public static class Sheets{
		public static BufferedImage Map = null;
		static{
			try {
				Map = ImageIO.read(Textures.class.getResource("/Textures/Map.png"));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public static class Map{
		public static BufferedImage floor = Textures.Sheets.Map.getSubimage(0, 0, 16, 16);
		public static BufferedImage wall = Textures.Sheets.Map.getSubimage(16, 0, 16, 16);
		
		public static BufferedImage wallBL = Textures.Sheets.Map.getSubimage(32, 0, 16, 16);
		public static BufferedImage wallBR = Textures.Sheets.Map.getSubimage(48, 0, 16, 16);
		public static BufferedImage wallTL = Textures.Sheets.Map.getSubimage(0, 16, 16, 16);
		public static BufferedImage wallTR = Textures.Sheets.Map.getSubimage(16, 16, 16, 16);
		
		public static BufferedImage wallB = Textures.Sheets.Map.getSubimage(32, 16, 16, 16);
		public static BufferedImage wallT = Textures.Sheets.Map.getSubimage(48, 16, 16, 16);
		public static BufferedImage wallL = Textures.Sheets.Map.getSubimage(0, 32, 16, 16);
		public static BufferedImage wallR = Textures.Sheets.Map.getSubimage(16, 32, 16, 16);
		
		public static BufferedImage wallSingle = Textures.Sheets.Map.getSubimage(32, 32, 16, 16);
		
		public static BufferedImage energy = Textures.Sheets.Map.getSubimage(48, 32, 16, 16);
		
		public static BufferedImage selected = Textures.Sheets.Map.getSubimage(0, 48, 16, 16);
	}
}
