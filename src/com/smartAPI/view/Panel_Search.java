package com.smartAPI.view;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;

/**
 * 
 * @author Simone Romamo - http://www.sromano.altervista.org
 * This panel contains 2 tabs: 
 * 		the first one to show codePatterns
 * 		second one to show projects
 */
public class Panel_Search extends JPanel {
	private static final String SHOW_CP = "Show code patterns";
	private static final String SHOW_PROJECTS = "Show projects";
	private JPanel panel, thisPanel;
	private Panel_ShowProjects panel_1;
	private Panel_CodePatternCompleteView cp_panel;

	/**
	 * Create the panel.
	 */
	public Panel_Search() {
		thisPanel = this;
		setLayout(new BorderLayout(0, 0));
		
		final JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);

		panel = new JPanel();
		panel.setName(SHOW_CP);
		panel.setLayout(new BorderLayout(0, 0));
		cp_panel = new Panel_CodePatternCompleteView();
		panel.add(cp_panel);
		
		panel_1 = new Panel_ShowProjects();
		panel_1.setName(SHOW_PROJECTS);
		panel_1.setLayout(new BorderLayout(0, 0));
		panel_1.add(new Panel_ShowProjects());		

		tabbedPane.addTab(SHOW_CP, null, panel, null);
		tabbedPane.addTab(SHOW_PROJECTS, null, panel_1, null);
		tabbedPane.setBackground(new Color(228, 230, 235));
		tabbedPane.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent arg0) {
				if (tabbedPane.getSelectedIndex() == 1){
					panel_1.refreshTreeView();
				}
			}
		});
		
		add(tabbedPane);		
	}
	
	public void refresh(){
		cp_panel.refresh();
	}

}
