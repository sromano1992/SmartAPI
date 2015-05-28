package com.smartAPI.view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;

import com.smartAPI.model.Common;
import java.awt.Font;
import javax.swing.SwingConstants;

public class About extends JPanel {

	String path="";
	String pathIcon="";
	MyImageIcon imgicon;
	public About() {
		setBackground(new Color(228, 230, 235));
		setLayout(null);
		
		JLabel lblIconSimo = new JLabel("");
		 path="res/simo.png";
		 pathIcon = getClass().getResource(path).getFile();
		 imgicon = new MyImageIcon(pathIcon,180,150);
		 lblIconSimo.setIcon(imgicon.getImageResponsive());
		lblIconSimo.setBounds(24, 73, 180, 152);
		add(lblIconSimo);
		
		JLabel lblIconAme = new JLabel("");
		path="res/amedeo.png";
		 pathIcon = getClass().getResource(path).getFile();
		 imgicon = new MyImageIcon(pathIcon,180,150);
		 lblIconAme.setIcon(imgicon.getImageResponsive());
		lblIconAme.setBounds(252, 73, 180, 152);
		add(lblIconAme);
		
		JLabel lblIconCiro = new JLabel("");
		path="res/ciro.png";
		 pathIcon = getClass().getResource(path).getFile();
		 imgicon = new MyImageIcon(pathIcon,180,150);
		 lblIconCiro.setIcon(imgicon.getImageResponsive());
		lblIconCiro.setBounds(481, 73, 180, 152);
		add(lblIconCiro);
		
		JLabel lblIconIole = new JLabel("");
		path="res/iole.jpg";
		 pathIcon = getClass().getResource(path).getFile();
		 imgicon = new MyImageIcon(pathIcon,180,150);
		 lblIconIole.setIcon(imgicon.getImageResponsive());
		lblIconIole.setBounds(145, 318, 180, 152);
		add(lblIconIole);
		
		JLabel lblIconSte = new JLabel("");
		path="res/ste.jpg";
		 pathIcon = getClass().getResource(path).getFile();
		 imgicon = new MyImageIcon(pathIcon,180,150);
		 lblIconSte.setIcon(imgicon.getImageResponsive());
		lblIconSte.setBounds(374, 318, 180, 152);
		add(lblIconSte);
		
		JLabel lblTxtSimo = new JLabel("Simone Romano");
		lblTxtSimo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTxtSimo.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblTxtSimo.setForeground(Color.DARK_GRAY);
		lblTxtSimo.setBackground(new Color(228, 230, 235));
		lblTxtSimo.setOpaque(true);
		lblTxtSimo.setBounds(24, 226, 180, 16);
		add(lblTxtSimo);
		
		JLabel lblNewLabel = new JLabel("New label");
		path="res/simoQr.jpg";
		 pathIcon = getClass().getResource(path).getFile();
		 imgicon = new MyImageIcon(pathIcon,50,50);
		 lblNewLabel.setIcon(imgicon.getImageResponsive());
		lblNewLabel.setBounds(92, 245, 50, 50);
		add(lblNewLabel);
		
		JLabel lblTxtAme = new JLabel("Amedeo Leo");
		lblTxtAme.setOpaque(true);
		lblTxtAme.setHorizontalAlignment(SwingConstants.CENTER);
		lblTxtAme.setForeground(Color.DARK_GRAY);
		lblTxtAme.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblTxtAme.setBackground(new Color(228, 230, 235));
		lblTxtAme.setBounds(252, 227, 180, 16);
		add(lblTxtAme);
		
		JLabel lblTxtCiro = new JLabel("Ciro Amati");
		lblTxtCiro.setOpaque(true);
		lblTxtCiro.setHorizontalAlignment(SwingConstants.CENTER);
		lblTxtCiro.setForeground(Color.DARK_GRAY);
		lblTxtCiro.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblTxtCiro.setBackground(new Color(228, 230, 235));
		lblTxtCiro.setBounds(481, 227, 180, 16);
		add(lblTxtCiro);
		
		JLabel lblTxtIole = new JLabel("Iolanda Rinaldi");
		lblTxtIole.setOpaque(true);
		lblTxtIole.setHorizontalAlignment(SwingConstants.CENTER);
		lblTxtIole.setForeground(Color.DARK_GRAY);
		lblTxtIole.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblTxtIole.setBackground(new Color(228, 230, 235));
		lblTxtIole.setBounds(145, 471, 180, 16);
		add(lblTxtIole);
		
		JLabel lblTxtSte = new JLabel("Stefania Cardamone");
		lblTxtSte.setOpaque(true);
		lblTxtSte.setHorizontalAlignment(SwingConstants.CENTER);
		lblTxtSte.setForeground(Color.DARK_GRAY);
		lblTxtSte.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblTxtSte.setBackground(new Color(228, 230, 235));
		lblTxtSte.setBounds(374, 472, 180, 16);
		add(lblTxtSte);
	}
}
