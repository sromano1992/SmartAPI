package com.smartAPI.view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.ScrollPane;
import java.util.ArrayList;

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
		
		//Desktop_Insert panel = new Desktop_Insert();
		//Desktop_Show panel = new Desktop_Show();
		
		//CREATE ADMIN
		//CreateAdminJPanel panel = new CreateAdminJPanel();
		
		//ADMININFO
		//AdminInfoJPanel panel = new AdminInfoJPanel("a.leo","000","Amedeo","Leo","amedeo.leo@gmail.com");

		//USERCLASSIFICATION
		UserClassificationJPanel panel = new UserClassificationJPanel();
		
		
		JFrame frame= new JFrame();
		
		frame.setVisible(true);
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.add(panel);

		
	}

}
