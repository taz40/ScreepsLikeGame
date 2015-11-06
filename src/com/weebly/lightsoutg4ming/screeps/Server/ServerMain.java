package com.weebly.lightsoutg4ming.screeps.Server;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerMain{
	
	public static UserSheet users;
	
	public static void main(String[] args){
		new ServerMain();
	}
	
	public ServerMain(){
		if(new File("C:/RoboScreepsServer/users.usr").exists()){
			try {
				ObjectInputStream in = new ObjectInputStream(new FileInputStream("C:/RoboScreepsServer/users.usr"));
				users = (UserSheet)in.readObject();
			} catch (IOException | ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			users = new UserSheet();
		}
		try {
			ServerSocket s = new ServerSocket(12345);
			while(true){
				Socket client = s.accept();
				new Thread(new ClientHandlerThread(client)).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
