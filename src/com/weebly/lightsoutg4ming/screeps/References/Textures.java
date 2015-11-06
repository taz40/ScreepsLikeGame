package com.weebly.lightsoutg4ming.screeps.References;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Textures {
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
