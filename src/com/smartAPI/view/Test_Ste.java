package com.smartAPI.view;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Test_Ste {

	public static void main(String[] args) {
				//ShowUsers_Ste panel = new ShowUsers_Ste("s.carda","123","Stefania","Cardamone","s.cardamone@gmail.com");
				RemoveUser panel = new RemoveUser("s.carda","123","Stefania","Cardamone","s.cardamone@gmail.com");
				
				//CREATE NEW ACCOUNT
				//CreateNewAccountJPanel panel = new CreateNewAccountJPanel();
				JFrame frame= new JFrame();
				frame.setVisible(true);
				frame.setBounds(100, 100, 370, 537);
				frame.add(panel);

	}

}


	