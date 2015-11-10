package com.weebly.lightsoutg4ming.screeps.main;

import io.brace.lightsoutgaming.engine.input.Keyboard;
import io.brace.lightsoutgaming.engine.input.Mouse;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;

import com.weebly.lightsoutg4ming.screeps.Entities.Map;
import com.weebly.lightsoutg4ming.screeps.Input.MouseDrag;
import com.weebly.lightsoutg4ming.screeps.Input.ScrollWheel;
import com.weebly.lightsoutg4ming.screeps.References.Textures;
public class Main extends Component implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	boolean running = true;
	int fps = 0;
	Map map = new Map("/Rooms/Room00.png");
	public static double zoom = 1;

	public Main(){
		System.out.println("success");
		GameWindow frame = new GameWindow();
		frame.setBounds(100, 100, 616, 648);
		frame.setResizable(false);
		frame.setVisible(true);
		frame.add(this);
		new Thread(this).start();
		addMouseListener(new Mouse());
		addKeyListener(new Keyboard());
		addMouseMotionListener(new Mouse());
		addMouseListener(new MouseDrag());
		addMouseMotionListener(new MouseDrag());
		this.addMouseWheelListener(new ScrollWheel());
	}

	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
		g.setColor(Color.lightGray);
		g.fillRect(0, 0, 800, 800);
		map.draw(g);
		g.setColor(Color.white);
		g.drawString(fps+" fps", 10, 10);
	}
	
	public void update(){
		map.update();
		if(ScrollWheel.changed){
			Main.zoom -= ScrollWheel.changeInPosition*.1*(Main.zoom);
			ScrollWheel.changed = false;
			if(zoom < 1)
				zoom = 1;
			if(zoom > 5)
				zoom = 5;
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		int timePassed = 0;
		long last = System.currentTimeMillis();
		int frames = 0;
		while(running){
			repaint();
			update();
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
