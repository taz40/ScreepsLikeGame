package com.weebly.lightsoutg4ming.screeps.main;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import com.weebly.lightsoutg4ming.screeps.References.Textures;
public class Main extends Component implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	boolean running = true;
	int fps = 0;

	public Main(){
		System.out.println("success");
		GameWindow frame = new GameWindow();
		frame.setVisible(true);
		frame.add(this);
		new Thread(this).start();
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.black);
		g.fillRect(0, 0, 800, 800);
		//Render Things
		g.setColor(Color.white);
		g.drawString(fps+" fps", 10, 10);
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int timePassed = 0;
		long last = System.currentTimeMillis();
		int frames = 0;
		while(running){
			repaint();
			timePassed += (int) (System.currentTimeMillis() - last);
			last = System.currentTimeMillis();
			frames++;
			if(timePassed >= 1000){
				timePassed = 0;
				fps = frames;
				frames = 0;
			}
			try {
				Thread.sleep(2);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
}
