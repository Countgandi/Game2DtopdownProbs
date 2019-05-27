package com.countgandi.com;

import java.awt.Component;
import java.awt.Dimension;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Window {
	
	public Window(int width, int height, String title, Component c) {
		JFrame frame = new JFrame(title);
		Dimension size = new Dimension(width, height);
		
		frame.setPreferredSize(size);
		frame.setMaximumSize(size);
		frame.setMinimumSize(size);
		
		frame.add(c);
		
		try {
			frame.setIconImage(ImageIO.read(Window.class.getResource("/tex/icon.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
		frame.setResizable(false);
		frame.setVisible(true);
	}

}
