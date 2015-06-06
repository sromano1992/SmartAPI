package com.smartAPI.view;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Rectangle;

import javax.swing.JTextPane;

import java.awt.Scrollbar;
import javax.swing.ScrollPaneConstants;

public class JscrollTest extends JPanel {

	/**
	 * Create the panel.
	 */
	public JscrollTest() {

		Panel_ShowCodePattern panel_ShowCodePattern = new Panel_ShowCodePattern(true);
		
		JScrollPane scrollPane = new JScrollPane(panel_ShowCodePattern);

		add(scrollPane);
		
	}
	
	 public static void main(String... args) {
	        JFrame frame = new JFrame();
	        frame.setSize(new Dimension(400,200));
	        frame.setContentPane(getPanel());
	        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	        frame.setVisible(true);
	    }
	 
	 public static JPanel getPanel(){
		JPanel panel = new JPanel();
		panel.setLayout(new GridLayout(1, 1));
		Panel_CodePatternCompleteView toScroll = new Panel_CodePatternCompleteView();
		panel.setSize(toScroll.getWidth(), toScroll.getHeight());
        panel.add(toScroll);
        JScrollPane scrollPane = new JScrollPane(panel);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        //scrollPane.setBounds(50, 30,500, 100);
        JPanel contentPane = new JPanel(null);
        contentPane.setLayout(new GridLayout(1, 1));
        //contentPane.setPreferredSize(new Dimension(500, 400));
        contentPane.add(scrollPane);
        return contentPane;
	 }
	
}
