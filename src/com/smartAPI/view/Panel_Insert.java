package com.smartAPI.view;

import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

/**
 * 
 * @author Simone Romamo - http://www.sromano.altervista.org
 *
 */
public class Panel_Insert extends JPanel {
	private static final String INSERT_PROJECT = "Insert Project";
	private static final String INSERT_CP = "Insert cp";
	private JPanel panel_1, panel, thisPanel;
	private Border border;
	/**
	 * Create the panel.
	 */
	public Panel_Insert() {
		thisPanel = this;
		setLayout(new BorderLayout(0, 0));
		setBackground(new Color(228, 230, 235));
		
		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBackground(new Color(228, 230, 235));

		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

		panel = new JPanel();
		border = BorderFactory.createLineBorder(new Color(228, 230, 235), 1);
		panel.setBorder(border);
		panel.setName(INSERT_PROJECT);
		panel.setLayout(new BorderLayout(0, 0));
		//panel.setBackground(new Color(228, 230, 235));
		panel.add(new Panel_InsertCP());
		
		panel_1 = new JPanel();
		panel_1.setName(INSERT_CP);
		panel_1.setLayout(new BorderLayout(0, 0));
		panel_1.add(new Panel_InsertProject());		

		tabbedPane.addTab(INSERT_CP, null, panel, null);
		tabbedPane.addTab(INSERT_PROJECT, null, panel_1, null);
		tabbedPane.setBackground(new Color(228, 230, 235));
		add(tabbedPane);
		
		
	}

}
