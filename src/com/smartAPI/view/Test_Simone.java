package com.smartAPI.view;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JTextField;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JButton;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeSelectionModel;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;

public class Test_Simone extends JPanel {

	/**
	 * Create the panel.
	 */
	public Test_Simone() {
		Panel_CodePatternSetScore panel_CodePatternSetScore = new Panel_CodePatternSetScore();
		panel_CodePatternSetScore.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseExited(MouseEvent arg0) {
			}
		});
		add(panel_CodePatternSetScore);

	}

}
