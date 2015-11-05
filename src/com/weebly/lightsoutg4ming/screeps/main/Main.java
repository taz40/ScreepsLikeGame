package com.weebly.lightsoutg4ming.screeps.main;

import io.brace.lightsoutgaming.engine.LightsOut;
import io.brace.lightsoutgaming.engine.Network.NetworkUtils;
import io.brace.lightsoutgaming.engine.input.Mouse;

import java.awt.Color;
import java.net.DatagramSocket;

import javax.swing.JOptionPane;

import com.weebly.lightsoutg4ming.screeps.References.Reference;
import com.weebly.lightsoutg4ming.screeps.References.Textures;
import com.weebly.lightsoutg4ming.screeps.server.Room;

public class Main extends LightsOut {
	
	DatagramSocket s;
	Room[][] rooms = new Room[7][7];
	int x, y;
	boolean clicked = false;
	
	public static void main(String[] args){
		new Main().init();
	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub
		for(int x = 0; x < 7; x++){
			for(int y = 0; y < 7; y++){
				rooms[x][y] = new Room("/Rooms/Room00"+".png");
			}
		}
		s = NetworkUtils.NetInit();
		if(NetworkUtils.connect("localhost", 12345, "Server_Client", "RoboScreeps", s, this) == -1){
			JOptionPane.showMessageDialog(null,
				    "Could not connect to the server!",
				    "ERROR!!!!",
				    JOptionPane.ERROR_MESSAGE);
		}else{
			createDisplay(Reference.name + " v. " + Reference.version, Reference.width, Reference.height);
			start();
		}
	}

	@Override
	protected void render() {
		// TODO Auto-generated method stub
		screen.clear(0xff7c7c7c);
		rooms[x][y].render(screen, x, y);
		screen.renderSprite(Mouse.mouseX/16*16, Mouse.mouseY/16*16, Textures.Map.Hover, false);
		screen.renderString(10, 10, x + ", " + y, Color.white, false);
		show();
	}

	@Override
	protected void update() {
		// TODO Auto-generated method stub
		if(!clicked && Mouse.button == 1){
			clicked = true;
			if(Mouse.clickX <= 16 && Mouse.clickX >= 0 && Mouse.clickY <= 31*16 && Mouse.clickY >= 19*16){
				if(x > 0){
					x--;
					screen.xOffset -= 50*16;
				}
			}
			if(Mouse.clickX <= 31*16 && Mouse.clickX >= 19*16 && Mouse.clickY <= 16*50 && Mouse.clickY >= 16*49){
				if(y < 6){
					y++;
					screen.yOffset += 50*16;
				}
			}
			if(Mouse.clickX <= 16*50 && Mouse.clickX >= 16*49 && Mouse.clickY <= 31*16 && Mouse.clickY >= 19*16){
				if(x < 6){
					x++;
					screen.xOffset += 50*16;
				}
			}
			if(Mouse.clickX <= 31*16 && Mouse.clickX >= 19*16 && Mouse.clickY <= 16 && Mouse.clickY >= 0){
				if(y > 0){
					y--;
					screen.yOffset -= 50*16;
				}
			}
		}else if(clicked && Mouse.button != 1){
			clicked = false;
		}
	}

}
