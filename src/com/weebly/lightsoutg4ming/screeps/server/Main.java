package com.weebly.lightsoutg4ming.screeps.server;

import io.brace.lightsoutgaming.engine.LightsOut;
import io.brace.lightsoutgaming.engine.Network.NetworkUtils;
import io.brace.lightsoutgaming.engine.Network.Server;

import java.net.DatagramSocket;
import java.net.Socket;

import com.weebly.lightsoutg4ming.screeps.References.Reference;

public class Main extends LightsOut {
	
	DatagramSocket s;
	
	public static void main(String[] args){
		new Main().init();
	}

	@Override
	protected void init() {
		// TODO Auto-generated method stub
		createDisplay(Reference.name + " v. " + Reference.version, Reference.width, Reference.height);
		start();
		Server server = new Server(false, 12345, "RoboScreeps");
		s = NetworkUtils.NetInit();
		NetworkUtils.connect("localhost", 12345, "Server_Client", "RoboScreeps", s, this);
		NetworkUtils.createObject(ServerData.class, NetworkUtils.serverIP, 12345, s);
	}

	@Override
	protected void render() {
		// TODO Auto-generated method stub
		screen.clear();
		
		show();
	}

	@Override
	protected void update() {
		// TODO Auto-generated method stub
		
	}

}
