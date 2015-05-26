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
import javax.swing.SwingConstants;
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
import java.awt.Font;
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
		private static int INSERT_CP = 0, SHOW_USER = 1, SHOW_CODE_PATTERN = 2, SHOW_ABOUT = 3;
		private int actualPanel = INSERT_CP;
		private JPanel panel;
		
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
			
			
			JLabel lblNewLabel = new JLabel("");
			lblNewLabel.setBounds(175, 188, 140, 115);
			String path="res/simo.png";
			String pathIcon = getClass().getResource(path).getFile();
			MyImageIcon imgicon = new MyImageIcon(pathIcon,140,115);
			lblNewLabel.setIcon(imgicon.getImageResponsive());
			panel.add(lblNewLabel);
			
			
			JLabel label = new JLabel("");
			label.setBounds(384, 188, 140, 115);
			String path1="res/amedeo.png";
			String pathIcon1 = getClass().getResource(path1).getFile();
			MyImageIcon imgicon1 = new MyImageIcon(pathIcon1,140,115);
			label.setIcon(imgicon1.getImageResponsive());
			panel.add(label);
			
			JLabel label_1 = new JLabel("");
			label_1.setBounds(602, 188, 140, 115);
			String path2="res/ciro.png";
			String pathIcon2 = getClass().getResource(path2).getFile();
			MyImageIcon imgicon2 = new MyImageIcon(pathIcon2,140,115);
			label_1.setIcon(imgicon2.getImageResponsive());
			panel.add(label_1);
			
			JLabel label_2 = new JLabel("");
			label_2.setBounds(291, 475, 140, 134);
			String path3="res/iole.png";
			String pathIcon3 = getClass().getResource(path3).getFile();
			MyImageIcon imgicon3 = new MyImageIcon(pathIcon3,140,134);
			label_2.setIcon(imgicon3.getImageResponsive());
			panel.add(label_2);
			
			JLabel label_3 = new JLabel("");
			label_3.setBounds(533, 475, 140, 134);
			String path4="res/ste.png";
			String pathIcon4 = getClass().getResource(path4).getFile();
			MyImageIcon imgicon4 = new MyImageIcon(pathIcon4,140,134);
			label_3.setIcon(imgicon4.getImageResponsive());
			panel.add(label_3);
			
			JLabel lblNewLabel_1 = new JLabel("Simone Romano");
			lblNewLabel_1.setBounds(191, 314, 105, 82);
			String path5="res/simoQr.jpg";
			String pathIcon5 = getClass().getResource(path5).getFile();
			MyImageIcon imgicon5 = new MyImageIcon(pathIcon5,105, 68);
			lblNewLabel_1.setIcon(imgicon5.getImageResponsive());
			panel.add(lblNewLabel_1);
			
			JLabel label_4 = new JLabel("Amedeo Leo");
			label_4.setBounds(407, 321, 105, 68);
			String path6="res/amedeoQr.jpg";
			String pathIcon6 = getClass().getResource(path6).getFile();
			MyImageIcon imgicon6 = new MyImageIcon(pathIcon6,105, 68);
			label_4.setIcon(imgicon6.getImageResponsive());
			panel.add(label_4);
			
			JLabel label_5 = new JLabel("Ciro Amati");
			label_5.setBounds(620, 321, 105, 68);
			String path7="res/ciroQr.jpg";
			String pathIcon7 = getClass().getResource(path7).getFile();
			MyImageIcon imgicon7 = new MyImageIcon(pathIcon7,105, 68);
			label_5.setIcon(imgicon7.getImageResponsive());
			panel.add(label_5);
			
			JLabel label_6 = new JLabel("Iolanda Rinaldi");
			label_6.setBounds(311, 620, 105, 68);
			String path8="res/ioleQr.jpg";
			String pathIcon8 = getClass().getResource(path8).getFile();
			MyImageIcon imgicon8 = new MyImageIcon(pathIcon8,105, 68);
			label_6.setIcon(imgicon8.getImageResponsive());
			panel.add(label_6);
			
			JLabel label_7 = new JLabel("Stefania Cardamone");
			label_7.setBounds(552, 620, 105, 68);
			String path9="res/steQr.jpg";
			String pathIcon9 = getClass().getResource(path9).getFile();
			MyImageIcon imgicon9 = new MyImageIcon(pathIcon9,105, 68);
			label_7.setIcon(imgicon9.getImageResponsive());
			panel.add(label_7);
			
			JLabel lblNewLabel_2 = new JLabel("Simone Romano");
			lblNewLabel_2.setBounds(175, 149, 140, 28);
			lblNewLabel_2.setFont(new Font("Lucida Grande", Font.BOLD+Font.ITALIC, 15));
			lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
			panel.add(lblNewLabel_2);
			
			JLabel label_8 = new JLabel("Amedeo Leo");
			label_8.setBounds(384, 149, 140, 28);
			label_8.setFont(new Font("Lucida Grande", Font.BOLD+Font.ITALIC, 15));
			label_8.setHorizontalAlignment(SwingConstants.CENTER);
			panel.add(label_8);
			
			JLabel label_9 = new JLabel("Ciro Amati");
			label_9.setBounds(602, 149, 140, 28);
			label_9.setFont(new Font("Lucida Grande", Font.BOLD+Font.ITALIC, 15));
			label_9.setHorizontalAlignment(SwingConstants.CENTER);
			panel.add(label_9);
			
			JLabel label_10 = new JLabel("Iolanda Rinaldi");
			label_10.setBounds(291, 436, 140, 28);
			label_10.setFont(new Font("Lucida Grande", Font.BOLD+Font.ITALIC, 15));
			label_10.setHorizontalAlignment(SwingConstants.CENTER);
			panel.add(label_10);
			
			JLabel label_11 = new JLabel("Stefania Cardamone");
			label_11.setBounds(516, 436, 170, 28);
			label_11.setFont(new Font("Lucida Grande", Font.BOLD+Font.ITALIC, 15));
			label_11.setHorizontalAlignment(SwingConstants.CENTER);
			panel.add(label_11);
			
			
			
		
			return panel;
			
			
		}

		@Override
		public void searchClicked() {
			
		}

		@Override
		public void insertClicked() {
			
		}

		@Override
		public void showUserClicked() {
			
		}

		@Override
		public void aboutClicked() {
			
		}

		private void updateGUI(){
			
		}
		
		public void setPanel_1Background(Color background) {
			//panel_1.setBackground(background);
		}
	}