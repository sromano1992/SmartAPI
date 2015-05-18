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
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{450, 0};
		gridBagLayout.rowHeights = new int[] {250, 50, 0};
		gridBagLayout.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel_2 = new JPanel();
		GridBagConstraints gbc_panel_2 = new GridBagConstraints();
		gbc_panel_2.fill = GridBagConstraints.BOTH;
		gbc_panel_2.insets = new Insets(0, 0, 5, 0);
		gbc_panel_2.gridx = 0;
		gbc_panel_2.gridy = 0;
		add(panel_2, gbc_panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel_2.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		Panel_ShowCodePattern panel_ShowCodePattern = new Panel_ShowCodePattern();
		panel.add(panel_ShowCodePattern);
		
		Panel_ShowCodePattern panel_ShowCodePattern_1 = new Panel_ShowCodePattern();
		panel.add(panel_ShowCodePattern_1);
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("Inferred");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblNewLabel);
		
		JLabel lblBasic = new JLabel("Basic");
		lblBasic.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblBasic);
		
		JPanel panel_1 = new JPanel();
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridx = 0;
		gbc_panel_1.gridy = 1;
		add(panel_1, gbc_panel_1);
		
		Panel_CommonMethods panel_CommonMethods = new Panel_CommonMethods();
		panel_1.add(panel_CommonMethods);

	}
}
