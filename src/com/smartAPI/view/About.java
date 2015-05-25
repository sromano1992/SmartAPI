package com.smartAPI.view;

	import javax.swing.JPanel;

	import java.awt.Component;
	import java.awt.GridLayout;
import java.awt.Image;
import java.awt.GridBagLayout;
	import java.awt.GridBagConstraints;

	import javax.swing.JDesktopPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
	import javax.swing.JTabbedPane;
	import javax.swing.JToolBar;
	import javax.swing.SwingUtilities;

	import java.awt.BorderLayout;

	import javax.swing.JSplitPane;
	import javax.swing.GroupLayout;
	import javax.swing.GroupLayout.Alignment;
import javax.swing.Icon;
import javax.swing.ImageIcon;

import com.smartAPI.control.IUserOptionListener;
import com.smartAPI.model.Common;

import java.awt.Color;
	import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Insets;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.JTable;
import java.awt.Panel;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

	public class About extends JPanel implements IUserOptionListener{
		private Panel_CodePatternCompleteView panel_showCP;
		private Panel_ShowAllUser panel_ShowUser;
		private static int INSERT_CP = 0, SHOW_USER = 1, SHOW_CODE_PATTERN = 2, SHOW_ABOUT = 3;
		private int actualPanel = INSERT_CP;
		private JPanel panel;
		private JTextField textField;
		private JTextField textField_1;
		private JTextField textField_2;
		
		//private aboutPanel
		
		public About() {
			try {
				panel = addControl_s();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
				
		}

		private JPanel addControl_s() throws IOException {
			
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
			panel.setBackground(new Color(228, 230, 235));
			
			UserOptionsJPanel panel_UserOptionsColors = new UserOptionsJPanel();
			panel_UserOptionsColors.setBounds(15, 0, 945, 95);
			panel_UserOptionsColors.addListener(this);
			panel.setLayout(null);
			panel.add(panel_UserOptionsColors);
			panel_UserOptionsColors.setLayout(null);
			
			textField = new JTextField();
			textField.setBounds(212, 128, 555, 115);
			panel.add(textField);
			textField.setColumns(10);
			
			textField_1 = new JTextField();
			textField_1.setColumns(10);
			textField_1.setBounds(212, 268, 555, 115);
			panel.add(textField_1);
			
			textField_2 = new JTextField();
			textField_2.setColumns(10);
			textField_2.setBounds(212, 411, 555, 115);
			panel.add(textField_2);
			
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(38, 128, 140, 115);
			String path="res/simo.png";
			String pathIcon = getClass().getResource(path).getFile();
			MyImageIcon imgicon = new MyImageIcon(pathIcon,140,115);
			lblNewLabel.setIcon(imgicon.getImageResponsive());
			panel.add(lblNewLabel);
			
			
			JLabel label = new JLabel("");
			label.setBounds(38, 268, 140, 115);
			String path1="res/amedeo.png";
			String pathIcon1 = getClass().getResource(path1).getFile();
			MyImageIcon imgicon1 = new MyImageIcon(pathIcon1,140,115);
			label.setIcon(imgicon1.getImageResponsive());
			panel.add(label);
			
			JLabel label_1 = new JLabel("");
			label_1.setBounds(38, 411, 140, 115);
			String path2="res/ciro.png";
			String pathIcon2 = getClass().getResource(path2).getFile();
			MyImageIcon imgicon2 = new MyImageIcon(pathIcon2,140,115);
			label_1.setIcon(imgicon2.getImageResponsive());
			panel.add(label_1);
			
			JLabel label_2 = new JLabel("");
			label_2.setBounds(212, 555, 140, 134);
			String path3="res/iole.png";
			String pathIcon3 = getClass().getResource(path3).getFile();
			MyImageIcon imgicon3 = new MyImageIcon(pathIcon3,140,134);
			label_2.setIcon(imgicon3.getImageResponsive());
			panel.add(label_2);
			
			JLabel label_3 = new JLabel("");
			label_3.setBounds(627, 555, 140, 134);
			String path4="res/ste.png";
			String pathIcon4 = getClass().getResource(path4).getFile();
			MyImageIcon imgicon4 = new MyImageIcon(pathIcon4,140,134);
			label_3.setIcon(imgicon4.getImageResponsive());
			panel.add(label_3);
			
			
			
		
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
				//panel.remove(panel_InsertCP);
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
				//panel.remove(panel_InsertCP);
			actualPanel = INSERT_CP;

			//panel.add(panel_InsertCP);
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
				//panel.remove(panel_InsertCP);
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
				//panel.remove(panel_InsertCP);
			actualPanel = SHOW_ABOUT;

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
		
		public void setPanel_1Background(Color background) {
			//panel_1.setBackground(background);
		}
	}


