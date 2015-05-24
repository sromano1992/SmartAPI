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

import com.smartAPI.model.UserClassification;

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

		//VIEWCLASSIFICATION
		UserClassification u1 = new UserClassification("c.amati", 80, "avatar-1");
		UserClassification u2 = new UserClassification("a.leo", 72, "avatar-3");
		UserClassification u3 = new UserClassification("s.romano", 87, "avatar-2");
		
		ArrayList<UserClassification> listUsers = new ArrayList<UserClassification>();
		listUsers.add(u1);
		listUsers.add(u2);
		listUsers.add(u3);
		
		ViewClassificationUsers panel = new ViewClassificationUsers(listUsers);
		
		JFrame frame= new JFrame();
		
		frame.setVisible(true);
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.add(panel);

		
	}

}
