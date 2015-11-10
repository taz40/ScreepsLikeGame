package com.weebly.lightsoutg4ming.screeps.Input;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

public class MouseDrag implements MouseMotionListener, MouseListener {
	
	public static float DragX = 0;
	public static float DragY = 0;
	
	public static float DragStartX = 0;
	public static float DragStartY = 0;
	
	//public static boolean Dragging = false;

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		DragX = e.getXOnScreen();
		DragY = e.getYOnScreen();
	}
	
	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		DragStartX = e.getXOnScreen();
		DragStartY = e.getYOnScreen();
		DragX = DragStartX;
		DragY = DragStartY;
		//Dragging = true;
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		//Dragging = false;
	}

}
