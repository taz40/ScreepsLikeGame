package com.weebly.lightsoutg4ming.screeps.server;

import java.util.ArrayList;
import java.util.Arrays;

import io.brace.lightsoutgaming.engine.Network.Networked;
import io.brace.lightsoutgaming.engine.graphics.Screen;

public class ServerData extends Networked {
	
	Room[][] rooms = new Room[7][7];

	@Override
	public void recv(String[] data) {
		ArrayList<String> roomsList = (ArrayList<String>) Arrays.asList(data);
		for(int x = 0; x < 7; x++){
			for(int y = 0; y < 7; y++){
				String[] data2 = {};
				roomsList.toArray(data2);
				rooms[x][y].recv(data2);
				for(int i = 0; i < 50*50; i++){
					roomsList.remove(0);
				}
			}
		}
	}

	@Override
	public String[] send() {
		ArrayList<String> roomsList = new ArrayList<String>();
		for(int x = 0; x < 7; x++){
			for(int y = 0; y < 7; y++){
				roomsList.addAll(Arrays.asList(rooms[x][y].send()));
			}
		}
		String[] data = {};
		roomsList.toArray(data);
		return data;
	}

	@Override
	public void render(Screen arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}

}
