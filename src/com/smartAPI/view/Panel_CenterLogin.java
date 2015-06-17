package com.smartAPI.view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


import java.awt.Font;
import java.awt.BorderLayout;
import java.awt.GridLayout;

public class Panel_CenterLogin extends JPanel {


	public Panel_CenterLogin() {
		this.setBackground(new Color(2, 94, 137));
		ImageIcon ii = new ImageIcon(this.getClass().getResource("res/logo.gif"));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setBackground(new Color(2,94,137));
		panel_1.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel = new JPanel();
		panel_1.add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		JLabel lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblLogo, BorderLayout.CENTER);
		lblLogo.setIcon(ii);
		panel.setBackground(new Color(2,94,137));

		JLabel lblLogoTxt = new JLabel("");
		lblLogoTxt.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(lblLogoTxt, BorderLayout.SOUTH);
		
		JLabel lblNewLabel = new JLabel("");
		panel_1.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		ii = new ImageIcon(this.getClass().getResource("res/logoTxt.png"));
		lblLogoTxt.setIcon(ii);

	}

}
