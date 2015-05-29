package com.smartAPI.view;

import javax.swing.JPanel;

import java.awt.Component;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import javax.swing.JSplitPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

import com.smartAPI.control.IUserOptionListener;
import com.smartAPI.control.IUserPanelListener;
import com.smartAPI.model.Common;

import java.awt.Color;

public class Desktop_1 extends JPanel implements IUserOptionListener, IUserPanelListener{
	private Panel_Insert panel_Insert;
	private Panel_CodePatternCompleteView panel_showCP;
	private Panel_ShowAllUser panel_ShowUser;
	private UserInfoJPanel userInfoJPanel;
	private AdminInfoJPanel adminInfoJPanel;
	private About panel_About;
	private IUserPanelListener mainFrame;
	private static int INSERT_CP = 0, SHOW_USER = 1, SHOW_CODE_PATTERN = 2, SHOW_ABOUT = 3, LOGOUT = 4;
	private int actualPanel = INSERT_CP;
	private JPanel panel;
	
	public Desktop_1(IUserPanelListener desktop_0) {
		this.mainFrame = desktop_0;
		panel = addControl_s();

		panel_Insert = new Panel_Insert();
		panel_Insert.setBounds(0, 181, 920, 564);
		panel.add(panel_Insert);

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

		if (!Common.UTENTE.isAdmin()){
			userInfoJPanel = new UserInfoJPanel();
			userInfoJPanel.addLogOutListener(this);
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
		}
		else{
			adminInfoJPanel  = new AdminInfoJPanel();
			adminInfoJPanel.addUserInfoJPanelListener(this);
			splitPane.setLeftComponent(adminInfoJPanel);
			GroupLayout gl_AdminInfoJPanel = new GroupLayout(adminInfoJPanel);
			gl_AdminInfoJPanel.setHorizontalGroup(
					gl_AdminInfoJPanel.createParallelGroup(Alignment.LEADING)
					.addGap(0, 400, Short.MAX_VALUE)
					);
			gl_AdminInfoJPanel.setVerticalGroup(
					gl_AdminInfoJPanel.createParallelGroup(Alignment.LEADING)
					.addGap(0, 542, Short.MAX_VALUE)
					);
			adminInfoJPanel.setLayout(gl_AdminInfoJPanel);
		}



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
			panel.remove(panel_Insert);
		else if(actualPanel == SHOW_ABOUT)
			panel.remove(panel_About);

		actualPanel = SHOW_CODE_PATTERN;

		panel_showCP.refresh();
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
			panel.remove(panel_Insert);
		else if(actualPanel == SHOW_ABOUT)
			panel.remove(panel_About);

		actualPanel = INSERT_CP;

		panel.add(panel_Insert);
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
			panel.remove(panel_Insert);
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
			panel.remove(panel_Insert);
		else if(actualPanel == SHOW_ABOUT)
			panel.remove(panel_About);

		actualPanel = SHOW_ABOUT;
		panel.add(panel_About);
		updateGUI();
	}

	@Override
	public void logOutClicked() {
		mainFrame.logOutClicked();
		insertClicked();
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
