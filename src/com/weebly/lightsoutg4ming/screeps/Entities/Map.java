package com.weebly.lightsoutg4ming.screeps.Entities;

import io.brace.lightsoutgaming.engine.input.Mouse;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.weebly.lightsoutg4ming.screeps.Input.MouseDrag;
import com.weebly.lightsoutg4ming.screeps.References.Textures;
import com.weebly.lightsoutg4ming.screeps.main.Main;

public class Map extends Entity {
	
	BufferedImage map;
	int[][] pixels;
	int width, height;
	float x, y;
	
	public Map(String path){
		try {
			loadLevel(path);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void loadLevel(String path) throws IOException{
		map = new BufferedImage(800,800, BufferedImage.TYPE_INT_ARGB);
		Graphics g = map.getGraphics();
		BufferedImage mapFile = ImageIO.read(Map.class.getResource(path));
		width = mapFile.getWidth();
		height = mapFile.getHeight();
		int[] pixels = mapFile.getRGB(0, 0, width, height, null, 0, width);
		this.pixels = new int[width][height];
		for(int x = 0; x < width; x++){
			for(int y = 0; y < height; y++){
				this.pixels[x][y] = pixels[x+y*width];
			}
		}
		for(int x = 0; x < width; x++){
			for(int y = 0; y < height; y++){
				int color = pixels[x + y*width];
				if(color == 0xff000000)
					g.drawImage(getWallImage(x,y), x*16, y*16, null);
			}
		}
	}
	
	private BufferedImage getWallImage(int x, int y){
		BufferedImage result = Textures.Map.wall;
		boolean top = y > 0 && pixels[x][y-1] == 0xff000000;
		boolean bottom = y < height-1 && pixels[x][y+1] == 0xff000000;
		boolean left = x > 0 && pixels[x-1][y] == 0xff000000;
		boolean right = x < width-1 && pixels[x+1][y] == 0xff000000;
		int sides = 0;
		if(top)
			sides++;
		if(bottom)
			sides++;
		if(left)
			sides++;
		if(right)
			sides++;
		
		if(sides == 2){
			if((left && right) || (top && bottom)){
			}else if(left && top)
				result = Textures.Map.wallBR;
			else if(left && bottom)
				result = Textures.Map.wallTR;
			else if(right && top)
				result = Textures.Map.wallBL;
			else if(right && bottom)
				result = Textures.Map.wallTL;
		}else if(sides == 1){
			if(left)
				result = Textures.Map.wallR;
			else if(right)
				result = Textures.Map.wallL;
			else if(top)
				result = Textures.Map.wallB;
			else if(bottom)
				result = Textures.Map.wallT;
		}else if(sides == 0)
			result = Textures.Map.wallSingle;
		
		return result;
	}

	@Override
	public void draw(Graphics g) {
		// TODO Auto-generated method stub
		float padding = (float)(((800f*Main.zoom)-800f)/2);
		g.drawImage(map, 0, 0, 600, 600, (int)((padding+x)/Main.zoom), (int)((padding+y)/Main.zoom), (int)(((800*Main.zoom+x)-padding)/Main.zoom), (int)(((800*Main.zoom+y)-padding)/Main.zoom), null);
		int divisions = (int) (12*Main.zoom);
		int sX = ((Mouse.mouseX))/divisions*divisions-(int)((x*600/800)/divisions);
		int sY = ((Mouse.mouseY))/divisions*divisions-(int)((y*600/800)/divisions);
		g.drawImage(Textures.Map.selected, sX, sY, sX+(divisions), sY+(divisions), 0, 0, 16, 16, null);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		x += (MouseDrag.DragStartX - MouseDrag.DragX)*800/600;
		y += (MouseDrag.DragStartY - MouseDrag.DragY)*800/600;
		MouseDrag.DragStartX = MouseDrag.DragX;
		MouseDrag.DragStartY = MouseDrag.DragY;
		float padding = (float)(((800f*Main.zoom)-800f)/2);
		if(((padding+x)/Main.zoom) < 0)
			x = -padding;
		if((((800*Main.zoom+x)-padding)/Main.zoom) > 800)
			x = padding;
		if(((padding+y)/Main.zoom) < 0)
			y = -padding;
		if((((800*Main.zoom+y)-padding)/Main.zoom) > 800)
			y = padding;
	}

}
