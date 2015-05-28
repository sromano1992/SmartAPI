package com.smartAPI.test;

import javax.swing.JFrame;

import com.smartAPI.model.SmartAPIModel;
import com.smartAPI.view.CreateAdminJPanel;
import com.smartAPI.view.Desktop_0;

public class Main {
	public static  JFrame f;
	public static  JFrame fAdmin;

	public static void main(String[] args) {
		SmartAPIModel m = new SmartAPIModel();
		f = new JFrame();
		fAdmin = new JFrame();
		f.setSize(1300, 900);
		fAdmin.setSize(1300, 900);

		if (m.createAdmin()){
			fAdmin.add(new CreateAdminJPanel());
			fAdmin.setVisible(true);
			fAdmin.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		}
		else{
			f.add(new Desktop_0(f));
			f.setVisible(true);
			f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		}
		//f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		
		
	}
	
	public static JFrame getMainContainer(){
		return f;
	}
	
	public static void setVisible() {
		f.setVisible(true);
		f.add(new Desktop_0(f));
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
	}
}
