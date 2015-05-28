package com.smartAPI.view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Panel_CenterLogin extends JPanel {


	public Panel_CenterLogin() {
		this.setBackground(new Color(2, 94, 137));
		setLayout(null);
		JLabel lblLogo = new JLabel("");
		lblLogo.setBounds(125, 5, 200, 200);
		ImageIcon ii = new ImageIcon(this.getClass().getResource("res/logo.gif"));
		lblLogo.setIcon(ii);
		add(lblLogo);

		JLabel lblLogoTxt = new JLabel("");
		lblLogoTxt.setBounds(96, 184, 251, 91);
		ii = new ImageIcon(this.getClass().getResource("res/logoTxt.png"));
		lblLogoTxt.setIcon(ii);
		add(lblLogoTxt);
		
		JLabel lblNewLabel = new JLabel("OR");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(125, 411, 200, 50);
		add(lblNewLabel);

	}

}
