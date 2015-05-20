package com.smartAPI.view;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import java.awt.SystemColor;

public class Test_JPanelContainer extends JPanel {

	public Test_JPanelContainer() {
		setLayout(new GridLayout(1, 0, 0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setDividerSize(3);
		splitPane.setBackground(SystemColor.menu);
		splitPane.setEnabled( false );
		add(splitPane);
		
		UserInfoJPanel userInfoJPanel = new UserInfoJPanel((String) null, (String) null, (String) null, (String) null, (String) null);
		splitPane.setLeftComponent(userInfoJPanel);
		GroupLayout gl_userInfoJPanel = new GroupLayout(userInfoJPanel);
		gl_userInfoJPanel.setHorizontalGroup(
			gl_userInfoJPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 355, Short.MAX_VALUE)
		);
		gl_userInfoJPanel.setVerticalGroup(
			gl_userInfoJPanel.createParallelGroup(Alignment.LEADING)
				.addGap(0, 644, Short.MAX_VALUE)
		);
		userInfoJPanel.setLayout(gl_userInfoJPanel);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setEnabled( false );
		splitPane_1.setDividerSize(3);

		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		splitPane.setRightComponent(splitPane_1);
		
		Panel_UserOptions panel_UserOptions = new Panel_UserOptions();
		splitPane_1.setLeftComponent(panel_UserOptions);
		GroupLayout gl_panel_UserOptions = new GroupLayout(panel_UserOptions);
		gl_panel_UserOptions.setHorizontalGroup(
			gl_panel_UserOptions.createParallelGroup(Alignment.LEADING)
				.addGap(0, 337, Short.MAX_VALUE)
		);
		gl_panel_UserOptions.setVerticalGroup(
			gl_panel_UserOptions.createParallelGroup(Alignment.LEADING)
				.addGap(0, 50, Short.MAX_VALUE)
		);
		panel_UserOptions.setLayout(gl_panel_UserOptions);
		
		Panel_CodePatternCompleteView panel_CodePatternCompleteView = new Panel_CodePatternCompleteView();
		splitPane_1.setRightComponent(panel_CodePatternCompleteView);
		
		
	}
}
