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
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JLabel;
import java.awt.BorderLayout;

public class Desktop_1 extends JPanel implements IUserOptionListener, IUserPanelListener{
	private Panel_Search panel_search;
	private Panel_ShowAllUser panel_ShowUser;
	private UserInfoJPanel userInfoJPanel;
	private AdminInfoJPanel adminInfoJPanel;
	private About panel_About;
	private IUserPanelListener mainFrame;
	private static int INSERT_CP = 0, SHOW_USER = 1, SHOW_CODE_PATTERN = 2, SHOW_ABOUT = 3, LOGOUT = 4;
	private int actualPanel = INSERT_CP;
	private JPanel panel;
	private Panel_Insert panel_Insert;
	
	public Desktop_1(IUserPanelListener desktop_0) {
		this.mainFrame = desktop_0;
		panel = addControl_s();

		panel_search = new Panel_Search();
		panel_search.setBounds(20, 107, 811, 582);		
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
		panel.setBackground(new Color(228, 230, 235));
		panel.setLayout(new GridLayout(0, 1, 0, 0));
				
				JLabel label = new JLabel("");
				
				JLabel label_1 = new JLabel("");
				
				JLabel label_2 = new JLabel("");
				
				JLabel label_3 = new JLabel("");
				
				JPanel panel_2 = new JPanel();
				panel.add(panel_2);
				GridBagLayout gbl_panel_2 = new GridBagLayout();
				gbl_panel_2.columnWidths = new int[]{0, 0};
				gbl_panel_2.rowHeights = new int[] {20, 500, 0};
				gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
				gbl_panel_2.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
				panel_2.setLayout(gbl_panel_2);
				
				JPanel panel_3 = new JPanel();
				GridBagConstraints gbc_panel_3 = new GridBagConstraints();
				gbc_panel_3.insets = new Insets(0, 0, 5, 0);
				gbc_panel_3.fill = GridBagConstraints.BOTH;
				gbc_panel_3.gridx = 0;
				gbc_panel_3.gridy = 0;
				panel_2.add(panel_3, gbc_panel_3);
				panel_3.setLayout(new BorderLayout(0, 0));
				
				UserOptionsJPanel userOptionsJPanel = new UserOptionsJPanel();
				userOptionsJPanel.addListener(this);
				userOptionsJPanel.setLayout(null);
				panel_3.add(userOptionsJPanel);
				
				JPanel panel_4 = new JPanel();
				GridBagConstraints gbc_panel_4 = new GridBagConstraints();
				gbc_panel_4.fill = GridBagConstraints.BOTH;
				gbc_panel_4.gridx = 0;
				gbc_panel_4.gridy = 1;
				panel_2.add(panel_4, gbc_panel_4);
				panel_4.setLayout(new BorderLayout(0, 0));
				
				panel_Insert = new Panel_Insert();
				panel_4.add(panel_Insert);
				
				JLabel label_4 = new JLabel("");
				
				JLabel label_5 = new JLabel("");
				
				JLabel label_6 = new JLabel("");
				
				JLabel label_7 = new JLabel("");
				
		
		return panel_4;
	}

	@Override
	public void searchClicked() {
		// TODO Auto-generated method stub
		if(actualPanel == SHOW_CODE_PATTERN)
			panel.remove(panel_search);
		else if(actualPanel == SHOW_USER)
			panel.remove(panel_ShowUser);
		else if(actualPanel == INSERT_CP)
			panel.remove(panel_Insert);
		else if(actualPanel == SHOW_ABOUT)
			panel.remove(panel_About);

		actualPanel = SHOW_CODE_PATTERN;

		panel_search.refresh();
		panel.add(panel_search);
		updateGUI();
	}

	@Override
	public void insertClicked() {
		// TODO Auto-generated method stub
		if(actualPanel == SHOW_CODE_PATTERN)
			panel.remove(panel_search);
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
			panel.remove(panel_search);
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
			panel.remove(panel_search);
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
