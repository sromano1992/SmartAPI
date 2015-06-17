package com.smartAPI.view;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.GridBagConstraints;

import javax.swing.JTextPane;

import java.awt.Insets;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.JSplitPane;
import javax.swing.tree.TreePath;

import com.smartAPI.control.TreePathListener;
import com.smartAPI.model.Common;
import com.smartAPI.model.Project;
import com.smartAPI.model.SmartAPIModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Panel_ShowProjects extends JPanel implements TreePathListener{
	private JTextField textField_name;
	private ArrayList<Project> addedProject_s;
	private JTextPane textPane_Description, textPane_category;
	private SmartAPIModel s = new SmartAPIModel();
	private TreeViewProject treeViewProject;
	private String selectedProject;
	private JCheckBox chckbxFollow;
	
	/**
	 * Create the panel.
	 */
	public Panel_ShowProjects() {
		setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		add(splitPane, BorderLayout.CENTER);
		
		JPanel panel_1 = new JPanel();
		splitPane.setRightComponent(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(0, 6, 0, 0));
		
		chckbxFollow = new JCheckBox("Follow");
		chckbxFollow.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (chckbxFollow.isSelected()){
					s.addFollowerToProject(selectedProject, Common.UTENTE.getNickname());
				}
				else{
					s.removeFollowerFromProject(selectedProject, Common.UTENTE.getNickname());
				}
			}
		});
		panel_2.add(chckbxFollow);
		
		JLabel label_1 = new JLabel("");
		panel_2.add(label_1);
		
		JLabel label_2 = new JLabel("");
		panel_2.add(label_2);
		
		JLabel label_3 = new JLabel("");
		panel_2.add(label_3);
		
		JLabel label = new JLabel("");
		panel_2.add(label);
		
		JLabel label_4 = new JLabel("");
		panel_2.add(label_4);
		
		JSplitPane splitPane_1 = new JSplitPane();
		splitPane_1.setDividerLocation(400);
		splitPane_1.setOrientation(JSplitPane.VERTICAL_SPLIT);
		panel_1.add(splitPane_1, BorderLayout.CENTER);
		
		JPanel panel = new JPanel();
		splitPane_1.setLeftComponent(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] {90, 300, 0};
		gbl_panel.rowHeights = new int[] {0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0};
		panel.setLayout(gbl_panel);
		
		JLabel lblName = new JLabel(" Name ");
		lblName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblName.setForeground(Color.WHITE);
		lblName.setOpaque(true);
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblName.insets = new Insets(5, 0, 0, 5);
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 0;
		panel.add(lblName, gbc_lblName);
		lblName.setBackground(new Color(231, 76, 60));

		textField_name = new JTextField();
		textField_name.setEditable(false);
		GridBagConstraints gbc_textField_name = new GridBagConstraints();
		gbc_textField_name.insets = new Insets(0, 0, 5, 0);
		gbc_textField_name.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_name.gridx = 1;
		gbc_textField_name.gridy = 0;
		gbc_textField_name.anchor = GridBagConstraints.NORTHWEST;
		panel.add(textField_name, gbc_textField_name);
		textField_name.setColumns(10);
		
		JLabel lblDescription = new JLabel(" Description ");
		lblDescription.setForeground(Color.WHITE);
		lblDescription.setOpaque(true);
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.anchor = GridBagConstraints.NORTHEAST;
		//gbc_lblName.anchor = GridBagConstraints.BOTH;
		gbc_lblDescription.insets = new Insets(0, 0, 5, 5);
		gbc_lblDescription.gridx = 0;
		gbc_lblDescription.gridy = 1;
		lblDescription.setBackground(new Color(231, 76, 60));
		panel.add(lblDescription, gbc_lblDescription);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.gridx = 1;
		gbc_scrollPane.gridy = 1;
		panel.add(scrollPane, gbc_scrollPane);
		
		textPane_Description = new JTextPane();
		textPane_Description.setEditable(false);
		GridBagConstraints gbl_txt = new GridBagConstraints();
		//gbl_txt.fill = GridBagConstraints.WEST;
		gbl_txt.anchor = GridBagConstraints.WEST;
		scrollPane.setViewportView(textPane_Description);
		
		JPanel panel_4 = new JPanel();
		splitPane_1.setRightComponent(panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] {90, 0, 0};
		gbl_panel_4.rowHeights = new int[]{0, 0};
		gbl_panel_4.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		
		JLabel lblCategory = new JLabel(" Categories ");
		lblCategory.setForeground(Color.WHITE);
		lblCategory.setOpaque(true);
		GridBagConstraints gbc_lblCategory = new GridBagConstraints();
		gbc_lblCategory.insets = new Insets(0, 0, 0, 5);
		gbc_lblCategory.anchor = GridBagConstraints.NORTHEAST;
		gbc_lblCategory.gridx = 0;
		gbc_lblCategory.gridy = 0;
		panel_4.add(lblCategory, gbc_lblCategory);
		lblCategory.setBackground(new Color(231, 76, 60));

		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 1;
		gbc_scrollPane_1.gridy = 0;
		panel_4.add(scrollPane_1, gbc_scrollPane_1);
		
		textPane_category = new JTextPane();
		scrollPane_1.setViewportView(textPane_category);
		textPane_category.setEditable(false);
		
		treeViewProject = new TreeViewProject();
		refreshTreeView();
		treeViewProject.addTreePathListener(this);
		splitPane.setLeftComponent(treeViewProject);
		splitPane.setDividerLocation(200);

	}

	public void refreshTreeView() {
		this.addedProject_s = s.getProject_s();
		treeViewProject.setProject_s(addedProject_s, "Projects");
	}

	public void setProject(Project p){
		textField_name.setText(p.getName());
		textPane_Description.setText(p.getDescription());
		textPane_category.setText("");
		for (int i=0; i<p.getCategories().size(); i++){
			if (!textPane_category.getText().equals(""))
				textPane_category.setText(textPane_category.getText() + " - " + p.getCategories().get(i));
			else
				textPane_category.setText(p.getCategories().get(i));
		}
		chckbxFollow.setSelected(s.followProject(Common.UTENTE.getNickname(), selectedProject));
	}
	
	public void treePathChanged(TreePath t) {
		selectedProject = t.getLastPathComponent().toString();
		for (Project p:addedProject_s){
			if (p.getName().equals(t.getLastPathComponent().toString()))
				setProject(p);
		}
	}

}
