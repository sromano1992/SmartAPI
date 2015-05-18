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

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Panel_InferredCodePattern extends JPanel {

	/**
	 * Create the panel.
	 */
	public Panel_InferredCodePattern() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Inferred");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel);
		
		JLabel lblBasic = new JLabel("Basic");
		lblBasic.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblBasic);
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		Panel_ShowCodePattern panel_ShowCodePattern = new Panel_ShowCodePattern();
		panel.add(panel_ShowCodePattern);
		
		Panel_ShowCodePattern panel_ShowCodePattern_1 = new Panel_ShowCodePattern();
		panel.add(panel_ShowCodePattern_1);

	}
}
