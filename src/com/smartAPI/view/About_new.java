package com.smartAPI.view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;

import com.smartAPI.model.Common;

public class About_new extends JPanel {

	String path="";
	String pathIcon="";
	MyImageIcon imgicon;
	public About_new() {
		setBackground(new Color(228, 230, 235));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		 path="res/simo.png";
		 pathIcon = getClass().getResource(path).getFile();
		 imgicon = new MyImageIcon(pathIcon,180,150);
		 lblNewLabel.setIcon(imgicon.getImageResponsive());
		lblNewLabel.setBounds(21, 32, 180, 152);
		add(lblNewLabel);
	}

}
