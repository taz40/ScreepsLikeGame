package com.weebly.lightsoutg4ming.screeps.main;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import io.brace.lightsoutgaming.engine.input.Keyboard;
import io.brace.lightsoutgaming.engine.input.Mouse;

public class GameWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public GameWindow() {
		setTitle("Screeps Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//contentPane = new JPanel();
		//contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		//contentPane.setLayout(new BorderLayout(0, 0));
		//setContentPane(contentPane);
	}

}
