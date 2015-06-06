package com.smartAPI.test;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.smartAPI.control.OSValidator;
import com.smartAPI.model.SmartAPIModel;
import com.smartAPI.view.CreateAdminJPanel;
import com.smartAPI.view.Desktop_0;
import java.awt.Toolkit;
import java.awt.Window.Type;

public class Main {
	public static  JFrame f;
	public static  JFrame fAdmin;

	public static void main(String[] args) {
		SmartAPIModel m = new SmartAPIModel();
		f = new JFrame();
		f.setTitle("SmartAPI 1.0");
		f.setIconImage(Toolkit.getDefaultToolkit().getImage(Main.class.getResource("/com/smartAPI/view/res/basic-code-icon.png")));
		fAdmin = new JFrame();
		f.setSize(1300, 900);
		fAdmin.setSize(1300, 900);

		if (m.createAdmin()){
			fAdmin.getContentPane().add(new CreateAdminJPanel());
			fAdmin.setVisible(true);
			fAdmin.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		}
		else{
			f.getContentPane().add(new Desktop_0(f));
			f.setVisible(true);
			f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		}
		if (OSValidator.isWindows())
			f.setExtendedState(JFrame.MAXIMIZED_BOTH); 
		/*else{
			Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
			f.setSize(dim.width, dim.height);
		}*/
		
		
	}
	
	public static JFrame getMainContainer(){
		return f;
	}
	
	public static void setVisible() {
		f.setVisible(true);
		f.getContentPane().add(new Desktop_0(f));
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
	}
}
