package com.smartAPI.view;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.tree.TreePath;

import com.smartAPI.control.TreePathListener;
import com.smartAPI.model.Common;
import com.smartAPI.model.SmartAPIModel;
import com.smartAPI.model.Utente;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Panel_ShowAllUser extends JPanel implements TreePathListener{
	private ShowUsersInfoNew showUserPanel;
	private UserClassificationNew userClassificationJPanel;

	/**
	 * Create the panel.
	 */
	public Panel_ShowAllUser() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, 0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.insets = new Insets(0, 0, 5, 5);
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 2;
		gbc_panel_4.gridy = 1;
		add(panel_4, gbc_panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBackground(new Color(228, 230, 235));
		splitPane.setEnabled(false);
		splitPane.setDividerSize(3);
		splitPane.setDividerLocation(200);
		panel_4.add(splitPane,BorderLayout.CENTER);
		
		showUserPanel = new ShowUsersInfoNew();
		splitPane.setRightComponent(showUserPanel);		
		TreeViewUsers treeViewUsers = new TreeViewUsers();
		treeViewUsers.setUser_s(new SmartAPIModel().getUsers(), "user");
		treeViewUsers.addTreePathListener(this);
		splitPane.setLeftComponent(treeViewUsers);
		
		
		userClassificationJPanel = new UserClassificationNew(Common.UTENTE.getNickname());
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 0, 5);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 2;
		gbc_panel_5.gridy = 3;
		add(userClassificationJPanel, gbc_panel_5);

		
		
		
//		setLayout(new GridLayout(0, 1, 0, 0));
//		
//		JSplitPane splitPane = new JSplitPane();
//		splitPane.setBackground(new Color(228, 230, 235));
//		//splitPane.setEnabled(false);
//		splitPane.setDividerSize(3);
//		splitPane.setDividerLocation(220);
//		add(splitPane);
//		
//		showUserPanel = new ShowUsersInfoNew();
//		splitPane.setRightComponent(showUserPanel);
//		
//		TreeViewUsers treeViewUsers = new TreeViewUsers();
//		treeViewUsers.setUser_s(new SmartAPIModel().getUsers(), "user");
//		treeViewUsers.addTreePathListener(this);
//		splitPane.setLeftComponent(treeViewUsers);
//		
//		userClassificationJPanel = new UserClassificationNew(Common.UTENTE.getNickname());
//		add(userClassificationJPanel);
		
		
		
	}

	@Override
	public void treePathChanged(TreePath t) {
		SmartAPIModel s = new SmartAPIModel();
		if(t.getPathCount() > 1){
			Utente us = s.getUtente(t.getPathComponent(1).toString());
			showUserPanel.setUser(us);
			userClassificationJPanel.setUser(us.getNickname());
		}		
	}
}
