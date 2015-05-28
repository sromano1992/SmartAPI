package com.smartAPI.view;

import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;

import java.awt.FlowLayout;
import java.awt.CardLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ScrollPaneConstants;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Panel_InferredCodePattern extends JPanel {
	private Panel_ShowCodePattern panel_ShowCodePattern, panel_ShowCodePattern_1;
	/**
	 * Create the panel.
	 */
	public Panel_InferredCodePattern() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		//add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		panel_ShowCodePattern = new Panel_ShowCodePattern();
		panel.add(panel_ShowCodePattern);
		
		panel_ShowCodePattern_1 = new Panel_ShowCodePattern();
		panel.add(panel_ShowCodePattern_1);
		
		JPanel panel_3 = new JPanel();
		add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		MyJLabel lblNewLabel = new MyJLabel("Inferred");
		lblNewLabel.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewLabel.setBackground(new Color(230, 126, 34));
		lblNewLabel.setText("Basic");
		
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel);
		
		MyJLabel lblBasic = new MyJLabel("Basic");
		lblBasic.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblBasic.setText("Inferred");
		lblBasic.setBackground(new Color(230, 126, 34));
		lblBasic.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblBasic);

	}
	public Panel_ShowCodePattern getPanel_ShowCodePattern() {
		return panel_ShowCodePattern;
	}
	public void setPanel_ShowCodePattern(Panel_ShowCodePattern panel_ShowCodePattern) {
		this.panel_ShowCodePattern = panel_ShowCodePattern;
	}
	public Panel_ShowCodePattern getPanel_ShowCodePattern_1() {
		return panel_ShowCodePattern_1;
	}
	public void setPanel_ShowCodePattern_1(
			Panel_ShowCodePattern panel_ShowCodePattern_1) {
		this.panel_ShowCodePattern_1 = panel_ShowCodePattern_1;
	}	
}
