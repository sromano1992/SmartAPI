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
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;

import javax.swing.JTextPane;

public class Test_Simone extends JPanel {

	/**
	 * Create the panel.
	 */
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(900, 900);
		f.add(new Panel_CodePatternCompleteView());
		f.setVisible(true);
	}

}
