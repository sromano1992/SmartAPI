package com.smartAPI.view;

import javax.swing.JPanel;
import javax.swing.JSplitPane;
import javax.swing.tree.TreePath;

import com.smartAPI.control.TreePathListener;
import com.smartAPI.model.Common;
import com.smartAPI.model.SmartAPIModel;
import com.smartAPI.model.Utente;

import java.awt.Color;
import java.awt.GridLayout;

public class Panel_ShowAllUser extends JPanel implements TreePathListener{
	private ShowUsersInfo showUserPanel;
	private UserClassificationJPanel userClassificationJPanel;
	/**
	 * Create the panel.
	 */
	public Panel_ShowAllUser() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setBackground(new Color(228, 230, 235));
		//splitPane.setEnabled(false);
		splitPane.setDividerSize(3);
		splitPane.setDividerLocation(220);
		add(splitPane);
		
		showUserPanel = new ShowUsersInfo();
		splitPane.setRightComponent(showUserPanel);
		
		TreeViewUsers treeViewUsers = new TreeViewUsers();
		treeViewUsers.setUser_s(new SmartAPIModel().getUsers(), "user");
		treeViewUsers.addTreePathListener(this);
		splitPane.setLeftComponent(treeViewUsers);
		
		userClassificationJPanel = new UserClassificationJPanel(Common.UTENTE.getNickname());
		add(userClassificationJPanel);
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
