package com.smartAPI.view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class TestCiro {
	public static void main(String[] args) {
		/*CreateNewAccount c = new CreateNewAccount();
		c.setVisible(true);*/
		UserInfo ui= new UserInfo("c.amati","123","Ciro","Amati","ciro.amati@gmail.com");
		JFrame frame= new JFrame();
		frame.setVisible(true);
		frame.setBounds(100, 100, 350, 537);
		frame.add(ui);
	}

}
