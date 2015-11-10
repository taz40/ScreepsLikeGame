package com.weebly.lightsoutg4ming.screeps.Input;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class ScrollWheel implements MouseWheelListener {
	
	public static double changeInPosition = 0;
	public static boolean changed = false;

	@Override
	public void mouseWheelMoved(MouseWheelEvent e) {
		// TODO Auto-generated method stub
		changeInPosition = e.getPreciseWheelRotation();
		changed = true;
	}

}
