package com.smartAPI.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.smartAPI.model.Common;

public class JFrame_Search extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public JFrame_Search() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		Panel_Search panel_Search = new Panel_Search();
		contentPane.add(panel_Search, BorderLayout.CENTER);
		this.setTitle(Common.SHOW_FRAME_TITLE);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(dim.width/4*3, dim.height/4*3);
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}

}
