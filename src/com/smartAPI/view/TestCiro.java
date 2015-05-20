package com.smartAPI.view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestCiro {
	public static void main(String[] args) {
		
		//USERINFO
		//UserInfoJPanel panel = new UserInfoJPanel("c.amati","123","Ciro","Amati","ciro.amati@gmail.com");
		
		//CREATE NEW ACCOUNT
		CreateNewAccountJPanel panel = new CreateNewAccountJPanel();
		JFrame frame= new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 370, 537);
		frame.add(panel);
	}

}
