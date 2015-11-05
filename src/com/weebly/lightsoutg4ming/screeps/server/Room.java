package com.weebly.lightsoutg4ming.screeps.server;

import java.util.Random;

public class Room {
	
	Random rnd = new Random();
	
	public Room(){
		for(int x = 0; x < 50; x++){
			for(int y = 0; y < 50; y++){
				map[x][y] = rnd.nextInt(3);
			}
		}
	}
	
	public int[][] map = new int[50][50];

	public String[] send(){
		String[] data = new String[50*50];
		for(int x = 0; x < 50; x++){
			for(int y = 0; y < 50; y++){
				data[y + x * 50] = Integer.toString(map[x][y]);
			}
		}
		return data;
	}
	
	public void recv(String[] data){
		for(int x = 0; x < 50; x++){
			for(int y = 0; y < 50; y++){
				map[x][y] = Integer.parseInt(data[y+2 + x * 50]);
			}
		}
	}
	
}
