package com.smartAPI.view;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JDesktopPane;
import javax.swing.JTabbedPane;
import javax.swing.JToolBar;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.FlowLayout;

public class Desktop_Show extends JPanel {

	
	public Desktop_Show() {
		setLayout(new GridLayout(1, 0, 0, 0));
		setSize(1416,858);
		setBackground(new Color(228, 230, 235));
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBackground(new Color(228, 230, 235));
		splitPane.setEnabled(false);
		splitPane.setDividerSize(0);
		add(splitPane);
		
		UserInfoJPanel userInfoJPanel = new UserInfoJPanel((String) null, (String) null, (String) null, (String) null, (String) null);
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
		panel_UserOptionsColors.setBounds(0, 6, 875, 100);
		panel.add(panel_UserOptionsColors);
		panel_UserOptionsColors.setLayout(null);
		
		Panel_CodePatternCompleteView panel_CodePatternCompleteView = new Panel_CodePatternCompleteView();
		panel_CodePatternCompleteView.setBounds(20, 107, 811, 582);
		panel.add(panel_CodePatternCompleteView);
	}
}
