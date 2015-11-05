package com.weebly.lightsoutg4ming.screeps.server;

import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Arrays;

import io.brace.lightsoutgaming.engine.Network.Networked;
import io.brace.lightsoutgaming.engine.graphics.Screen;

public class ServerData extends Networked {
	
	public static Room[][] rooms = new Room[7][7];
	int x, y;
	
	public ServerData(){
		for(int x = 0; x < 7; x++){
			for(int y = 0; y < 7; y++){
				rooms[x][y] = new Room();
			}
		}
	}

	@Override
	public void recv(String[] data) {
		ArrayList<String> roomsList = new ArrayList<String>(Arrays.asList(data));
		x = Integer.parseInt(data[0]);
		y = Integer.parseInt(data[1]);
		roomsList.remove(0);
		roomsList.remove(0);
		String[] data2 = {};
		data2 = roomsList.toArray(data2);
		rooms[x][y].recv(data2);
	}

	@Override
	public String[] send() {
		ArrayList<String> roomsList = new ArrayList<String>();
		roomsList.add(Integer.toString(x));
		roomsList.add(Integer.toString(y));
		roomsList.addAll(Arrays.asList(rooms[x][y].send()));
		x++;
		if(x >= 7){
			x = 0;
			y++;
		}
		if(y >= 7){
			y = 0;
		}
		String[] data = {};
		data = roomsList.toArray(data);
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
