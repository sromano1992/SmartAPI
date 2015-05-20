package com.smartAPI.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class CreateNewAccountJPanel extends JPanel {
	
	private JTextField userField;
	private JPasswordField passwordField;
	private JTextField nameField;
	private JPasswordField surnameField;
	private JPasswordField passwordField_2;
	private JPasswordField passwordField_3;
	private JLabel lblIcon;
	private JLabel lblCreateNewAccount;
	private JLabel lblUser;

		public CreateNewAccountJPanel() {
			setLayout(null);
			setBackground(new Color(2, 94, 137));
			
			lblCreateNewAccount = new JLabel("Create Account");
			lblCreateNewAccount.setHorizontalAlignment(SwingConstants.CENTER);
			lblCreateNewAccount.setForeground(Color.WHITE);
			lblCreateNewAccount.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
			lblCreateNewAccount.setBounds(6, 21, 417, 37);
			add(lblCreateNewAccount);
			
			lblUser = new JLabel("User");
			lblUser.setOpaque(true);
			lblUser.setHorizontalAlignment(SwingConstants.CENTER);
			lblUser.setForeground(Color.WHITE);
			lblUser.setBackground(new Color(2, 66, 96));
			lblUser.setBounds(47, 195, 95, 31);
			add(lblUser);
			
			userField = new JTextField();
			userField.setColumns(10);
			userField.setBounds(139, 192, 204, 37);
			add(userField);
			
			JLabel lblPassword = new JLabel("Password");
			lblPassword.setOpaque(true);
			lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
			lblPassword.setForeground(Color.WHITE);
			lblPassword.setBackground(new Color(2, 66, 96));
			lblPassword.setBounds(47, 226, 95, 31);
			add(lblPassword);
			
			passwordField = new JPasswordField();
			passwordField.setBounds(139, 222, 204, 37);
			add(passwordField);
			
			nameField = new JTextField();
			nameField.setColumns(10);
			nameField.setBounds(139, 282, 204, 37);
			add(nameField);
			
			JLabel lblName = new JLabel("Name");
			lblName.setOpaque(true);
			lblName.setHorizontalAlignment(SwingConstants.CENTER);
			lblName.setForeground(Color.WHITE);
			lblName.setBackground(new Color(2, 66, 96));
			lblName.setBounds(47, 286, 95, 31);
			add(lblName);
			
			JLabel lblSurname = new JLabel("Surname");
			lblSurname.setOpaque(true);
			lblSurname.setHorizontalAlignment(SwingConstants.CENTER);
			lblSurname.setForeground(Color.WHITE);
			lblSurname.setBackground(new Color(2, 66, 96));
			lblSurname.setBounds(47, 316, 95, 31);
			add(lblSurname);
			
			surnameField = new JPasswordField();
			surnameField.setBounds(139, 312, 204, 37);
			add(surnameField);
			
			JButton btnCreate = new JButton("Create Account");
			btnCreate.setBounds(58, 437, 274, 37);
			add(btnCreate);
			
			JLabel lblRepatPassw = new JLabel("Confirm Passw");
			lblRepatPassw.setOpaque(true);
			lblRepatPassw.setHorizontalAlignment(SwingConstants.CENTER);
			lblRepatPassw.setForeground(Color.WHITE);
			lblRepatPassw.setBackground(new Color(2, 66, 96));
			lblRepatPassw.setBounds(47, 257, 95, 31);
			add(lblRepatPassw);
			
			passwordField_2 = new JPasswordField();
			passwordField_2.setBounds(139, 252, 204, 37);
			add(passwordField_2);
			
			passwordField_3 = new JPasswordField();
			passwordField_3.setBounds(139, 342, 204, 37);
			add(passwordField_3);
			
			JLabel lblEmail = new JLabel("Email");
			lblEmail.setOpaque(true);
			lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
			lblEmail.setForeground(Color.WHITE);
			lblEmail.setBackground(new Color(2, 66, 96));
			lblEmail.setBounds(47, 346, 95, 31);
			add(lblEmail);
			
			lblIcon = new JLabel("");
			String path="res/1.png";
			String pathIcon = getClass().getResource(path).getFile();
			MyImageIcon imgicon = new MyImageIcon(pathIcon,80,70);
			lblIcon.setIcon(imgicon.getImageResponsive());
			lblIcon.setBounds(81, 80, 80, 71);
			add(lblIcon);
			
			Vector comboBoxItems=new Vector();
		    comboBoxItems.add("avatar - 1");
		    comboBoxItems.add("avatar - 2");
		    comboBoxItems.add("avatar - 3");
		    comboBoxItems.add("avatar - 4");
		    comboBoxItems.add("avatar - 5");
		    comboBoxItems.add("avatar - 6");
		    final DefaultComboBoxModel model = new DefaultComboBoxModel(comboBoxItems);
		    final JComboBox comboBox = new JComboBox(model);
		    comboBox.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					String s=(String)comboBox.getSelectedItem();
					String[] parts = s.split(" - ");
					String path="res/"+parts[1]+".png";
					String pathIcon = getClass().getResource(path).getFile();				
					MyImageIcon imgicon = new MyImageIcon(pathIcon,80,70);
					lblIcon.setIcon(imgicon.getImageResponsive());
				}
			});
			
			comboBox.setBounds(214, 101, 118, 31);
			add(comboBox);

	}

}