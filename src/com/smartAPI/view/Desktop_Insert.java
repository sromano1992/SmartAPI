package com.smartAPI.view;

import javax.swing.JPanel;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import javax.swing.SwingUtilities;

import java.awt.BorderLayout;

import javax.swing.JSplitPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import com.smartAPI.control.IUserOptionListener;

import java.awt.Color;
import java.awt.FlowLayout;

public class Desktop_Insert extends JPanel implements IUserOptionListener{
	private Panel_InsertCP panel_InsertCP;
	private JPanel panel_showCP;
	private Panel_ShowAllUser panel_ShowUser;
	private About panel_About;
	private static int INSERT_CP = 0, SHOW_USER = 1, SHOW_CODE_PATTERN = 2, SHOW_ABOUT = 3;
	private int actualPanel = INSERT_CP;
	private JPanel panel;
	
	//private aboutPanel
	
	public Desktop_Insert() {
		panel = addControl_s();
		
		panel_InsertCP = new Panel_InsertCP();
		panel_InsertCP.setBounds(0, 181, 920, 564);
		panel.add(panel_InsertCP);
		
		panel_showCP = new Panel_CodePatternCompleteView();
		panel_showCP.setBounds(20, 107, 811, 582);		
		panel_ShowUser = new Panel_ShowAllUser();
		panel_ShowUser.setBounds(0, 181, 920, 508);		
		panel_About = new About();
		panel_About.setBounds(20, 107, 811, 582);
	}

	/**
	 * Will create GUI and will return
	 * left panel where already has been added
	 * options bar (insert-search...)
	 * @return
	 */
	private JPanel addControl_s() {
		setLayout(new GridLayout(1, 0, 0, 0));
		setSize(1416,858);
		setBackground(new Color(228, 230, 235));
		JSplitPane splitPane = new JSplitPane();
		splitPane.setEnabled(false);
		splitPane.setBackground(new Color(228, 230, 235));
		splitPane.setDividerSize(0);
		add(splitPane);
		
		UserInfoJPanel userInfoJPanel = new UserInfoJPanel();
		splitPane.setLeftComponent(userInfoJPanel);
		GroupLayout gl_userInfoJPanel = new GroupLayout(userInfoJPanel);
		gl_userInfoJPanel.setHorizontalGroup(
			gl_userInfoJPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 400, Short.MAX_VALUE)
		);
		gl_userInfoJPanel.setVerticalGroup(
			gl_userInfoJPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 542, Short.MAX_VALUE)
		);
		userInfoJPanel.setLayout(gl_userInfoJPanel);
		
		JPanel panel = new JPanel();
		splitPane.setRightComponent(panel);
		panel.setLayout(null);
		panel.setBackground(new Color(228, 230, 235));
		
		UserOptionsJPanel panel_UserOptionsColors = new UserOptionsJPanel();
		panel_UserOptionsColors.addListener(this);
		panel_UserOptionsColors.setBounds(0, 6, 875, 100);
		panel.add(panel_UserOptionsColors);
		panel_UserOptionsColors.setLayout(null);
		return panel;
	}

	@Override
	public void searchClicked() {
		// TODO Auto-generated method stub
		if(actualPanel == SHOW_CODE_PATTERN)
			panel.remove(panel_showCP);
		else if(actualPanel == SHOW_USER)
			panel.remove(panel_ShowUser);
		else if(actualPanel == INSERT_CP)
			panel.remove(panel_InsertCP);
		else if(actualPanel == SHOW_ABOUT)
			panel.remove(panel_About);
		actualPanel = SHOW_CODE_PATTERN;
		
		panel.add(panel_showCP);
		updateGUI();
	}

	@Override
	public void insertClicked() {
		// TODO Auto-generated method stub
		if(actualPanel == SHOW_CODE_PATTERN)
			panel.remove(panel_showCP);
		else if(actualPanel == SHOW_USER)
			panel.remove(panel_ShowUser);
		else if(actualPanel == INSERT_CP)
			panel.remove(panel_InsertCP);
		else if(actualPanel == SHOW_ABOUT)
			panel.remove(panel_About);
		actualPanel = INSERT_CP;

		panel.add(panel_InsertCP);
		updateGUI();
	}

	@Override
	public void showUserClicked() {
		// TODO Auto-generated method stub
		if(actualPanel == SHOW_CODE_PATTERN)
			panel.remove(panel_showCP);
		else if(actualPanel == SHOW_USER)
			panel.remove(panel_ShowUser);
		else if(actualPanel == INSERT_CP)
			panel.remove(panel_InsertCP);
		else if(actualPanel == SHOW_ABOUT)
			panel.remove(panel_About);
		actualPanel = SHOW_USER;

		panel.add(panel_ShowUser);
		updateGUI();
	}

	@Override
	public void aboutClicked() {
		// TODO Auto-generated method stub
		if(actualPanel == SHOW_CODE_PATTERN)
			panel.remove(panel_showCP);
		else if(actualPanel == SHOW_USER)
			panel.remove(panel_ShowUser);
		else if(actualPanel == INSERT_CP)
			panel.remove(panel_InsertCP);
		else if(actualPanel == SHOW_ABOUT)
			panel.remove(panel_About);
		actualPanel = SHOW_ABOUT;
		panel.add(panel_About);
		updateGUI();
	}

	private void updateGUI(){
		SwingUtilities.updateComponentTreeUI(this);
		Component c = getParent();
		while (c!=null){
			SwingUtilities.updateComponentTreeUI(this);
			c = c.getParent();
		}
	}
}
