package com.smartAPI.view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;

import com.smartAPI.model.Common;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class About extends JPanel {

	String path = "";
	String pathIcon = "";
	MyImageIcon imgicon;

	public About() {
		setBackground(new Color(228, 230, 235));
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		JLabel lblIconSimo = new JLabel();
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel.gridx = 3;
		gbc_lblNewLabel.gridy = 3;
		pathIcon = "res/simo.png";
		imgicon = new MyImageIcon(pathIcon, 180, 150);
		lblIconSimo.setIcon(imgicon.getImageResponsive());
		add(lblIconSimo, gbc_lblNewLabel);
		JLabel lblTxtSimo = new JLabel("Simone Romano");
		lblTxtSimo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTxtSimo.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblTxtSimo.setForeground(Color.DARK_GRAY);
		lblTxtSimo.setBackground(new Color(228, 230, 235));
		lblTxtSimo.setOpaque(true);
		GridBagConstraints gbc_lblNewLabel_1 = new GridBagConstraints();
		gbc_lblNewLabel_1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_1.gridx = 3;
		gbc_lblNewLabel_1.gridy = 4;
		add(lblTxtSimo, gbc_lblNewLabel_1);
		JLabel labelsimoqr = new JLabel("");
		GridBagConstraints gbc_lblNewLabel_2 = new GridBagConstraints();
		gbc_lblNewLabel_2.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_2.gridx = 3;
		gbc_lblNewLabel_2.gridy = 5;
		pathIcon = "res/simoQr.jpg";
		imgicon = new MyImageIcon(pathIcon, 50, 50);
		labelsimoqr.setIcon(imgicon.getImageResponsive());
		add(labelsimoqr, gbc_lblNewLabel_2);
		JLabel  lblIconAme = new JLabel("");
		pathIcon = "res/amedeo.png";
		imgicon = new MyImageIcon(pathIcon, 180, 150);
		lblIconAme.setIcon(imgicon.getImageResponsive());
		GridBagConstraints gbc_lblNewLabel1 = new GridBagConstraints();
		gbc_lblNewLabel1.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel1.gridx = 7;
		gbc_lblNewLabel1.gridy = 3;
		add(lblIconAme, gbc_lblNewLabel1);
		JLabel lblTxtAme = new JLabel("Amedeo Leo");
		lblTxtAme.setOpaque(true);
		lblTxtAme.setHorizontalAlignment(SwingConstants.CENTER);
		lblTxtAme.setForeground(Color.DARK_GRAY);
		lblTxtAme.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblTxtAme.setBackground(new Color(228, 230, 235));
		GridBagConstraints gbc_lblNewLabel_7 = new GridBagConstraints();
		gbc_lblNewLabel_7.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_7.gridx = 7;
		gbc_lblNewLabel_7.gridy = 4;
		add(lblTxtAme, gbc_lblNewLabel_7);
		JLabel labelameqr = new JLabel();
		GridBagConstraints gbc_lblNewLabel_4 = new GridBagConstraints();
		gbc_lblNewLabel_4.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_4.gridx = 7;
		gbc_lblNewLabel_4.gridy = 5;
		pathIcon = "res/amedeoQr.jpg";
		imgicon = new MyImageIcon(pathIcon, 50, 50);
		labelameqr.setIcon(imgicon.getImageResponsive());
		add(labelameqr, gbc_lblNewLabel_4);
		
		JLabel  lblIconCiro = new JLabel("");
		pathIcon = "res/ciro.png";
		imgicon = new MyImageIcon(pathIcon, 180, 150);
		lblIconCiro.setIcon(imgicon.getImageResponsive());
		GridBagConstraints gbc_lblNewLabel9 = new GridBagConstraints();
		gbc_lblNewLabel9.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel9.gridx = 11;
		gbc_lblNewLabel9.gridy = 3;
		add(lblIconCiro, gbc_lblNewLabel9);
		
		JLabel lblTxtCiro = new JLabel("Ciro Amati");
		lblTxtCiro.setOpaque(true);
		lblTxtCiro.setHorizontalAlignment(SwingConstants.CENTER);
		lblTxtCiro.setForeground(Color.DARK_GRAY);
		lblTxtCiro.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblTxtCiro.setBackground(new Color(228, 230, 235));
		GridBagConstraints gbc_lblNewLabel_8 = new GridBagConstraints();
		gbc_lblNewLabel_8.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_8.gridx = 11;
		gbc_lblNewLabel_8.gridy = 4;
		add(lblTxtCiro, gbc_lblNewLabel_8);
	
		JLabel lblciroqr = new JLabel();
		GridBagConstraints gbc_lblNewLabel_10 = new GridBagConstraints();
		gbc_lblNewLabel_10.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_10.gridx = 11;
		gbc_lblNewLabel_10.gridy = 5;
		pathIcon = "res/ciroQr.jpg";
		imgicon = new MyImageIcon(pathIcon, 50, 50);
		lblciroqr.setIcon(imgicon.getImageResponsive());
		add(lblciroqr, gbc_lblNewLabel_10);
		
		JLabel  lblIconIole = new JLabel("");
		pathIcon = "res/iole.jpg";
		imgicon = new MyImageIcon(pathIcon, 180, 150);
		lblIconIole.setIcon(imgicon.getImageResponsive());
		GridBagConstraints gbc_lblNewLabel12 = new GridBagConstraints();
		gbc_lblNewLabel12.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel12.gridx = 5;
		gbc_lblNewLabel12.gridy = 7;
		add(lblIconIole, gbc_lblNewLabel12);
		
		JLabel lblTxtIole = new JLabel("Iolanda Rinaldi");
		lblTxtIole.setOpaque(true);
		lblTxtIole.setHorizontalAlignment(SwingConstants.CENTER);
		lblTxtIole.setForeground(Color.DARK_GRAY);
		lblTxtIole.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblTxtIole.setBackground(new Color(228, 230, 235));
		GridBagConstraints gbc_lblNewLabel_13 = new GridBagConstraints();
		gbc_lblNewLabel_13.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_13.gridx = 5;
		gbc_lblNewLabel_13.gridy = 8;
		add(lblTxtIole, gbc_lblNewLabel_13);
		
		JLabel lblioleqr = new JLabel();
		pathIcon = "res/ioleQr.jpg";
		imgicon = new MyImageIcon(pathIcon, 50, 50);
		lblioleqr.setIcon(imgicon.getImageResponsive());
		GridBagConstraints gbc_lblNewLabel_21 = new GridBagConstraints();
		gbc_lblNewLabel_21.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_21.gridx = 5;
		gbc_lblNewLabel_21.gridy = 9;
		add(lblioleqr, gbc_lblNewLabel_21);
		
	
		JLabel  lblIconSte = new JLabel("");
		pathIcon = "res/ste.jpg";
		imgicon = new MyImageIcon(pathIcon, 180, 150);
		lblIconSte.setIcon(imgicon.getImageResponsive());
		GridBagConstraints gbc_lblNewLabel112 = new GridBagConstraints();
		gbc_lblNewLabel112.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel112.gridx = 9;
		gbc_lblNewLabel112.gridy = 7;
		add(lblIconSte, gbc_lblNewLabel112);
		
		JLabel lblTxtSte = new JLabel("Stefania Cardamone");
		lblTxtSte.setOpaque(true);
		lblTxtSte.setHorizontalAlignment(SwingConstants.CENTER);
		lblTxtSte.setForeground(Color.DARK_GRAY);
		lblTxtSte.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblTxtSte.setBackground(new Color(228, 230, 235));
		GridBagConstraints gbc_lblNewLabel_113 = new GridBagConstraints();
		gbc_lblNewLabel_113.insets = new Insets(0, 0, 5, 5);
		gbc_lblNewLabel_113.gridx = 9;
		gbc_lblNewLabel_113.gridy = 8;
		add(lblTxtSte, gbc_lblNewLabel_113);
		
		JLabel lblsteqr = new JLabel();
		pathIcon = "res/steQr.jpg";
		imgicon = new MyImageIcon(pathIcon, 50, 50);
		lblsteqr.setIcon(imgicon.getImageResponsive());
		GridBagConstraints gbc_lblNewLabel_221 = new GridBagConstraints();
		gbc_lblNewLabel_221.insets = new Insets(0, 0, 0, 5);
		gbc_lblNewLabel_221.gridx = 9;
		gbc_lblNewLabel_221.gridy = 9;
		add(lblsteqr, gbc_lblNewLabel_221);
	}
}
