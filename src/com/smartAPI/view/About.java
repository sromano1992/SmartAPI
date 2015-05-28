package com.smartAPI.view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;

import com.smartAPI.model.Common;

public class About extends JPanel {

	String path="";
	String pathIcon="";
	MyImageIcon imgicon;
	public About() {
		setBackground(new Color(228, 230, 235));
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		 path="res/simo.png";
		 pathIcon = getClass().getResource(path).getFile();
		 imgicon = new MyImageIcon(pathIcon,180,150);
		 lblNewLabel.setIcon(imgicon.getImageResponsive());
		lblNewLabel.setBounds(23, 116, 180, 152);
		add(lblNewLabel);
		
		JLabel label = new JLabel("");
		path="res/amedeo.png";
		 pathIcon = getClass().getResource(path).getFile();
		 imgicon = new MyImageIcon(pathIcon,180,150);
		 label.setIcon(imgicon.getImageResponsive());
		label.setBounds(251, 116, 180, 152);
		add(label);
		
		JLabel label_1 = new JLabel("");
		path="res/ciro.png";
		 pathIcon = getClass().getResource(path).getFile();
		 imgicon = new MyImageIcon(pathIcon,180,150);
		 label_1.setIcon(imgicon.getImageResponsive());
		label_1.setBounds(480, 116, 180, 152);
		add(label_1);
		
		JLabel label_2 = new JLabel("");
		path="res/iole.jpg";
		 pathIcon = getClass().getResource(path).getFile();
		 imgicon = new MyImageIcon(pathIcon,180,150);
		 label_2.setIcon(imgicon.getImageResponsive());
		label_2.setBounds(144, 361, 180, 152);
		add(label_2);
		
		JLabel label_3 = new JLabel("");
		path="res/ste.jpg";
		 pathIcon = getClass().getResource(path).getFile();
		 imgicon = new MyImageIcon(pathIcon,180,150);
		 label_3.setIcon(imgicon.getImageResponsive());
		label_3.setBounds(373, 361, 180, 152);
		add(label_3);
		
		JLabel lblNewLabel_1 = new JLabel("Simone Romano");
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setBounds(23, 280, 129, 16);
		add(lblNewLabel_1);
	}
}
