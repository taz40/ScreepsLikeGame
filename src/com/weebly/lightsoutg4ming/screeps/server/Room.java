package com.weebly.lightsoutg4ming.screeps.server;

import io.brace.lightsoutgaming.engine.graphics.Screen;
import io.brace.lightsoutgaming.engine.graphics.Sprite;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.weebly.lightsoutg4ming.screeps.References.Textures;

public class Room {
	
	String path;
	
	public void render(Screen s, int x, int y){
		for(int px = 0; px < 50; px++){
			for(int py = 0; py < 50; py++){
				int color = map[px][py];
				if(color == 0xff000000){
					s.renderSprite(px*1*16+x*50*16, py*1*16+y*50*16, getWallSprite(px,py), true);
				}else if(color == 0xfffff200){
					s.renderSprite(px*1*16+x*50*16, py*1*16+y*50*16, getWallSprite(px,py), true);
					s.renderSprite(px*1*16+x*50*16, py*1*16+y*50*16, Textures.Map.energy, true);
				}else if(color == 0xffffffff){
					s.renderSprite(px*1*16+x*50*16, py*1*16+y*50*16, Textures.Map.floor, true);
				}
			}
		}
	}
	
	private Sprite getWallSprite(int x, int y){
		Sprite sprite = null;
		boolean top = y+1 < 50 && (map[x][y+1] == 0xff000000 || map[x][y+1] == 0xfffff200);
		boolean bottom = y-1 >= 0 && (map[x][y-1] == 0xff000000 || map[x][y-1] == 0xfffff200);
		boolean left = x-1 >= 0 && (map[x-1][y] == 0xff000000 || map[x-1][y] == 0xfffff200);
		boolean right = x+1 < 50 && (map[x+1][y] == 0xff000000 || map[x+1][y] == 0xfffff200);
		int numOfSides = 0;
		if(top)
			numOfSides++;
		if(bottom)
			numOfSides++;
		if(left)
			numOfSides++;
		if(right)
			numOfSides++;
		
		if(numOfSides >= 3){
			sprite = Textures.Map.wall;
		}
		if(numOfSides == 2){
			if(left && right){
				sprite = Textures.Map.wall;
			}else if(left && top){
				sprite = Textures.Map.wallTR;
			}else if(left && bottom){
				sprite = Textures.Map.wallBR;
			}else if(right && bottom){
				sprite = Textures.Map.wallBL;
			}else if(right && top){
				sprite = Textures.Map.wallTL;
			}else if(top && bottom){
				sprite = Textures.Map.wall;
			}
		}
		if(numOfSides == 1){
			if(top){
				sprite = Textures.Map.wallB;
			}else if(bottom){
				sprite = Textures.Map.wallT;
			}else if(left){
				sprite = Textures.Map.wallR;
			}else if(right){
				sprite = Textures.Map.wallL;
			}
		}
		if(numOfSides == 0){
			sprite = Textures.Map.wallAllown;
		}
		return sprite;
	}
	
	public Room(String path){
		this.path = path;
		BufferedImage bi = null;
		try {
			bi = ImageIO.read(Room.class.getResource(path));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int[] pixels = bi.getRGB(0, 0, bi.getWidth(), bi.getHeight(), null, 0, bi.getWidth());
		for(int x = 0; x < 50; x++){
			for(int y = 0; y < 50; y++){
				map[x][y] = pixels[x + y*50];
			}
		}
	}
	
	public int[][] map = new int[50][50];
	
}
