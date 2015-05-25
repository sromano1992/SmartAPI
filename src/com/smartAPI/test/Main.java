package com.smartAPI.test;

import javax.swing.JFrame;

import com.smartAPI.view.Desktop_0;

/**
 * 
 * @author Simone Romamo - http://www.sromano.altervista.org
 *
 */
public class Main {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(900, 900);
		f.add(new Desktop_0(f));
		f.setVisible(true);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
	}
}
