package com.smartAPI.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ScrollPane;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;

public class TestCiro {
	public static void main(String[] args) {
		
		//USERINFO
		//UserInfoJPanel panel = new UserInfoJPanel("c.amati","123","Ciro","Amati","ciro.amati@gmail.com");
		//CREATE NEW ACCOUNT
		//CreateNewAccountJPanel panel = new CreateNewAccountJPanel();
		
		ModifyDesktop_1 panel = new ModifyDesktop_1();
		JFrame frame= new JFrame();
		
		frame.setVisible(true);
		frame.setSize(500, 500);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.add(panel);

		
	}

}
