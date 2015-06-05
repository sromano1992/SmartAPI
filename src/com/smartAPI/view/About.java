package com.smartAPI.view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;

import com.smartAPI.model.Common;
import java.awt.Font;
import javax.swing.SwingConstants;

public class About extends JPanel {

	String path = "";
	String pathIcon = "";
	MyImageIcon imgicon;

	public About() {
		setBackground(new Color(228, 230, 235));
		setLayout(null);

		JLabel lblIconSimo = new JLabel("");
		pathIcon = "res/simo.png";
		imgicon = new MyImageIcon(pathIcon, 180, 150);
		lblIconSimo.setIcon(imgicon.getImageResponsive());
		lblIconSimo.setBounds(324, 73, 180, 152);
		add(lblIconSimo);

		JLabel lblIconAme = new JLabel("");
		pathIcon = "res/amedeo.png";
		imgicon = new MyImageIcon(pathIcon, 180, 150);
		lblIconAme.setIcon(imgicon.getImageResponsive());
		lblIconAme.setBounds(552, 73, 180, 152);
		add(lblIconAme);

		JLabel lblIconCiro = new JLabel("");
		pathIcon = "res/ciro.png";
		imgicon = new MyImageIcon(pathIcon, 180, 150);
		lblIconCiro.setIcon(imgicon.getImageResponsive());
		lblIconCiro.setBounds(781, 73, 180, 152);
		add(lblIconCiro);

		JLabel lblIconIole = new JLabel("");
		pathIcon = "res/iole.jpg";
		imgicon = new MyImageIcon(pathIcon, 180, 150);
		lblIconIole.setIcon(imgicon.getImageResponsive());
		lblIconIole.setBounds(445, 318, 180, 152);
		add(lblIconIole);

		JLabel lblIconSte = new JLabel("");
		pathIcon = "res/ste.jpg";
		imgicon = new MyImageIcon(pathIcon, 180, 150);
		lblIconSte.setIcon(imgicon.getImageResponsive());
		lblIconSte.setBounds(674, 318, 180, 152);
		add(lblIconSte);

		JLabel lblTxtSimo = new JLabel("Simone Romano");
		lblTxtSimo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTxtSimo.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblTxtSimo.setForeground(Color.DARK_GRAY);
		lblTxtSimo.setBackground(new Color(228, 230, 235));
		lblTxtSimo.setOpaque(true);
		lblTxtSimo.setBounds(324, 226, 180, 16);
		add(lblTxtSimo);

		JLabel lblNewLabel = new JLabel("New label");
		pathIcon = "res/simoQr.jpg";
		imgicon = new MyImageIcon(pathIcon, 50, 50);
		lblNewLabel.setIcon(imgicon.getImageResponsive());
		lblNewLabel.setBounds(384, 245, 50, 50);
		add(lblNewLabel);

		JLabel lblTxtAme = new JLabel("Amedeo Leo");
		lblTxtAme.setOpaque(true);
		lblTxtAme.setHorizontalAlignment(SwingConstants.CENTER);
		lblTxtAme.setForeground(Color.DARK_GRAY);
		lblTxtAme.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblTxtAme.setBackground(new Color(228, 230, 235));
		lblTxtAme.setBounds(552, 227, 180, 16);
		add(lblTxtAme);

		JLabel label = new JLabel("New label");
		pathIcon = "res/amedeoQr.jpg";
		imgicon = new MyImageIcon(pathIcon, 50, 50);
		label.setIcon(imgicon.getImageResponsive());
		label.setBounds(612, 245, 50, 50);
		add(label);

		JLabel lblTxtCiro = new JLabel("Ciro Amati");
		lblTxtCiro.setOpaque(true);
		lblTxtCiro.setHorizontalAlignment(SwingConstants.CENTER);
		lblTxtCiro.setForeground(Color.DARK_GRAY);
		lblTxtCiro.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblTxtCiro.setBackground(new Color(228, 230, 235));
		lblTxtCiro.setBounds(781, 227, 180, 16);
		add(lblTxtCiro);

		JLabel label_1 = new JLabel("New label");
		pathIcon = "res/ciroQr.jpg";
		imgicon = new MyImageIcon(pathIcon, 50, 50);
		label_1.setIcon(imgicon.getImageResponsive());
		label_1.setBounds(841, 245, 50, 50);
		add(label_1);

		JLabel lblTxtIole = new JLabel("Iolanda Rinaldi");
		lblTxtIole.setOpaque(true);
		lblTxtIole.setHorizontalAlignment(SwingConstants.CENTER);
		lblTxtIole.setForeground(Color.DARK_GRAY);
		lblTxtIole.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblTxtIole.setBackground(new Color(228, 230, 235));
		lblTxtIole.setBounds(445, 471, 180, 16);
		add(lblTxtIole);

		JLabel label_2 = new JLabel("New label");
		pathIcon = "res/ioleQr.jpg";
		imgicon = new MyImageIcon(pathIcon, 50, 50);
		label_2.setIcon(imgicon.getImageResponsive());
		label_2.setBounds(505, 493, 50, 50);
		add(label_2);

		JLabel lblTxtSte = new JLabel("Stefania Cardamone");
		lblTxtSte.setOpaque(true);
		lblTxtSte.setHorizontalAlignment(SwingConstants.CENTER);
		lblTxtSte.setForeground(Color.DARK_GRAY);
		lblTxtSte.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblTxtSte.setBackground(new Color(228, 230, 235));
		lblTxtSte.setBounds(674, 472, 180, 16);
		add(lblTxtSte);

		JLabel label_3 = new JLabel("New label");
		pathIcon = "res/steQr.jpg";
		imgicon = new MyImageIcon(pathIcon, 50, 50);
		label_3.setIcon(imgicon.getImageResponsive());
		label_3.setBounds(734, 493, 50, 50);
		add(label_3);

	}
}
