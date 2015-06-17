package com.smartAPI.view;

import javax.swing.GroupLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.GroupLayout.Alignment;

import com.smartAPI.control.IUserOptionListener;
import com.smartAPI.control.IUserPanelListener;
import com.smartAPI.model.Common;

import java.awt.Component;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Color;
import java.awt.BorderLayout;

public class Desktop_1 extends JPanel implements IUserOptionListener, IUserPanelListener{
	private Panel_Search panel_search;
	private Panel_ShowAllUser panel_ShowUser;
	private About panel_About;
	private IUserPanelListener mainFrame;
	private static int INSERT_CP = 0, SHOW_USER = 1, SHOW_CODE_PATTERN = 2, SHOW_ABOUT = 3, LOGOUT = 4, USERINFO=5;
	private int actualPanel = INSERT_CP;
	private JPanel panel, panel_4;
	private	JFrame f;
	private Panel_Insert panel_Insert;
	private UserInfoJPanel panel_UserInfo;

	/**
	 * Create the panel.
	 */
	public Desktop_1(IUserPanelListener desktop_0) {
		this.mainFrame = desktop_0;

		panel_search = new Panel_Search();	
		panel_ShowUser = new Panel_ShowAllUser();		
		panel_About = new About();
		panel_UserInfo = new UserInfoJPanel();
		
		panel_UserInfo.addLogOutListener(this);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] {0, 600};
		gridBagLayout.rowWeights = new double[]{1.0};
		gridBagLayout.columnWeights = new double[]{0, 1.0};
		setLayout(gridBagLayout);
		
		panel = new JPanel();
		panel.setBackground(Color.BLACK);
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.insets = new Insets(0, 0, 0, 5);
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);
		panel.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.ORANGE);
		GridBagConstraints gbc_panel_1 = new GridBagConstraints();
		gbc_panel_1.gridx = 1;
		gbc_panel_1.fill = GridBagConstraints.BOTH;
		gbc_panel_1.gridy = 0;
		add(panel_1, gbc_panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.CENTER);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] {0};
		gbl_panel_2.rowHeights = new int[] {20, 660};
		gbl_panel_2.columnWeights = new double[]{1.0};
		gbl_panel_2.rowWeights = new double[]{1.0, 1.0};
		panel_2.setLayout(gbl_panel_2);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 0;
		panel_2.add(panel_3, gbc_panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		UserOptionsJPanel userOptionsJPanel = new UserOptionsJPanel();
		userOptionsJPanel.addListener(this);
		/*GridBagLayout gridBagLayout_1 = (GridBagLayout) userOptionsJPanel.getLayout();
		gridBagLayout_1.rowWeights = new double[]{0.0};
		gridBagLayout_1.rowHeights = new int[]{94};
		gridBagLayout_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		gridBagLayout_1.columnWidths = new int[]{208, 208, 208, 208};
		panel_3.add(userOptionsJPanel, BorderLayout.NORTH);*/
		panel_3.add(userOptionsJPanel);
		
		panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 1;
		panel_2.add(panel_4, gbc_panel_4);
		panel_4.setLayout(new GridLayout(0, 1, 0, 0));
		
		panel_Insert = new Panel_Insert();
		panel_4.add(panel_Insert);

	}
	
	public void searchClicked() {
		// TODO Auto-generated method stub
		if(actualPanel == SHOW_CODE_PATTERN)
			panel_4.remove(panel_search);
		else if(actualPanel == SHOW_USER)
			panel_4.remove(panel_ShowUser);
		else if(actualPanel == INSERT_CP)
			panel_4.remove(panel_Insert);
		else if(actualPanel == SHOW_ABOUT)
			panel_4.remove(panel_About);
		else if(actualPanel == USERINFO)
			panel_4.remove(panel_UserInfo);
		actualPanel = SHOW_CODE_PATTERN;

		panel_search = new Panel_Search();	//updating search panel
		panel_4.add(panel_search);
		updateGUI();

	}

	public void insertClicked() {
		// TODO Auto-generated method stub
		if(actualPanel == SHOW_CODE_PATTERN)
			panel_4.remove(panel_search);
		else if(actualPanel == SHOW_USER)
			panel_4.remove(panel_ShowUser);
		else if(actualPanel == INSERT_CP)
			panel_4.remove(panel_Insert);
		else if(actualPanel == SHOW_ABOUT)
			panel_4.remove(panel_About);
		else if(actualPanel == USERINFO)
			panel_4.remove(panel_UserInfo);
		actualPanel = INSERT_CP;

		panel_4.add(panel_Insert);
		updateGUI();
	}

	public void showUserClicked() {
		// TODO Auto-generated method stub
		if(actualPanel == SHOW_CODE_PATTERN)
			panel_4.remove(panel_search);
		else if(actualPanel == SHOW_USER)
			panel_4.remove(panel_ShowUser);
		else if(actualPanel == INSERT_CP)
			panel_4.remove(panel_Insert);
		else if(actualPanel == SHOW_ABOUT)
			panel_4.remove(panel_About);
		else if(actualPanel == USERINFO)
			panel_4.remove(panel_UserInfo);
		actualPanel = SHOW_USER;

		panel_4.add(panel_ShowUser);
		updateGUI();
	}

	public void aboutClicked() {
		// TODO Auto-generated method stub
		if(actualPanel == SHOW_CODE_PATTERN)
			panel_4.remove(panel_search);
		else if(actualPanel == SHOW_USER)
			panel_4.remove(panel_ShowUser);
		else if(actualPanel == INSERT_CP)
			panel_4.remove(panel_Insert);
		else if(actualPanel == SHOW_ABOUT)
			panel_4.remove(panel_About);
		else if(actualPanel == USERINFO)
			panel_4.remove(panel_UserInfo);
		actualPanel = SHOW_ABOUT;
		panel_4.add(panel_About);
		updateGUI();
	}

	public void logOutClicked() {
		mainFrame.logOutClicked();
		insertClicked();
	}

	public void userInfoClicked() {
		if(actualPanel == SHOW_CODE_PATTERN)
			panel_4.remove(panel_search);
		else if(actualPanel == SHOW_USER)
			panel_4.remove(panel_ShowUser);
		else if(actualPanel == INSERT_CP)
			panel_4.remove(panel_Insert);
		else if(actualPanel == SHOW_ABOUT)
			panel_4.remove(panel_About);
		else if(actualPanel == USERINFO)
			panel_4.remove(panel_UserInfo);
		actualPanel = USERINFO;
		panel_4.add(panel_UserInfo);
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
