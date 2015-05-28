package com.smartAPI.test;

import javax.swing.JFrame;

import com.smartAPI.view.Desktop_0;

public class Main {
	public static JFrame f;
	public static void main(String[] args) {
		//JFrame f = new JFrame();
		 f = new JFrame();

		f.setSize(1300, 900);
		f.add(new Desktop_0(f));
		//f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		f.setVisible(true);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
	}
}
