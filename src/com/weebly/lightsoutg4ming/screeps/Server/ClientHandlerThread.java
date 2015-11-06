package com.weebly.lightsoutg4ming.screeps.Server;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandlerThread implements Runnable {
	
	Socket client;
	
	public ClientHandlerThread(Socket client){
		this.client = client;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			PrintWriter out = new PrintWriter(client.getOutputStream());
			BufferedReader in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String username = in.readLine();
			String password = in.readLine();
			boolean accepted = true;
			if(ServerMain.users.usernames.contains(username)){
				int index = ServerMain.users.usernames.indexOf(username);
				if(password.equals(ServerMain.users.passwords.get(index))){
					accepted = true;
				}else{
					accepted = false;
				}
			}else{
				ServerMain.users.usernames.add(username);
				ServerMain.users.passwords.add(password);
				new File("C:/RoboScreepsServer/").mkdirs();
				new File("C:/RoboScreepsServer/users.usr").createNewFile();
				ObjectOutputStream out2 = new ObjectOutputStream(new FileOutputStream("C:/RoboScreepsServer/users.usr"));
				out2.writeObject(ServerMain.users);
			}
			out.println(accepted);
			out.flush();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
