package com.smartAPI.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.smartAPI.control.RegistrazioneControl;
import com.smartAPI.model.SmartAPIModel;
import com.smartAPI.model.UserException;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.BorderLayout;

public class CreateNewAccountJPanel extends JPanel {
	
	private JTextField userField;
	private JPasswordField passwordField;
	private JTextField nameField;
	private JTextField surnameField;
	private JPasswordField confirmPasswField;
	private JTextField emailField;
	private JLabel lblIcon;
	private JLabel lblCreateNewAccount;
	private JLabel lblUser;
	private JLabel lblError;
	private SmartAPIModel model;
	private JButton btnBack;
	private JLabel lblMessage;
	private JPanel panel_1;
	private JPanel panel;
	private JLabel label;
	private JLabel label_1;
	private JLabel label_2;
	
	public CreateNewAccountJPanel() {
		this.model = new SmartAPIModel();
		setBackground(new Color(2, 94, 137));
		setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(2,94,137));
		add(panel_1, BorderLayout.CENTER);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] {0, 0, 0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[] {0, 20, 20, 20, 20, 20, 20, 20, 20, 20};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		panel_1.setLayout(gbl_panel_1);


		String path="res/1.png";
		String pathIcon = getClass().getResource(path).getFile();
		

		lblIcon = new JLabel("");
		MyImageIcon imgicon = new MyImageIcon(pathIcon,80,70);
		lblIcon.setIcon(imgicon.getImageResponsive());
		Vector comboBoxItems=new Vector();
	    comboBoxItems.add("avatar - 1");
	    comboBoxItems.add("avatar - 2");
	    comboBoxItems.add("avatar - 3");
	    comboBoxItems.add("avatar - 4");
	    comboBoxItems.add("avatar - 5");
	    comboBoxItems.add("avatar - 6");
	    comboBoxItems.add("avatar - 7");
	    comboBoxItems.add("avatar - 8");
	    final DefaultComboBoxModel modelCombo = new DefaultComboBoxModel(comboBoxItems);
		
		GridBagConstraints gbc_lblIcon = new GridBagConstraints();
		gbc_lblIcon.insets = new Insets(0, 0, 5, 5);
		gbc_lblIcon.gridx = 1;
		gbc_lblIcon.gridy = 0;
		panel_1.add(lblIcon, gbc_lblIcon);
		
		panel = new JPanel();
		panel.setBackground(new Color(2, 94, 137));
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 2;
		gbc_panel.gridy = 0;
		panel_1.add(panel, gbc_panel);
		panel.setLayout(new GridLayout(3, 3, 0, 0));
		
		label = new JLabel("");
		panel.add(label);
		final JComboBox comboBox = new JComboBox(modelCombo);
		panel.add(comboBox);
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
		
		label_1 = new JLabel("");
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.weightx = 0.1;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 1;
		panel_1.add(label_1, gbc_label_1);
		
		//lblCreateNewAccount = new JLabel("Create Account");
		//lblCreateNewAccount.setHorizontalAlignment(SwingConstants.CENTER);
		//lblCreateNewAccount.setForeground(Color.WHITE);
		//lblCreateNewAccount.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		//lblCreateNewAccount.setBounds(17, 180, 417, 37);
		//add(lblCreateNewAccount);
		
		lblUser = new JLabel("User");
		GridBagConstraints gbc_lblUser = new GridBagConstraints();
		gbc_lblUser.fill = GridBagConstraints.BOTH;
		gbc_lblUser.insets = new Insets(0, 0, 5, 0);
		gbc_lblUser.gridx = 1;
		gbc_lblUser.gridy = 1;
		panel_1.add(lblUser, gbc_lblUser);
		lblUser.setOpaque(true);
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setForeground(Color.WHITE);
		lblUser.setBackground(new Color(2, 66, 96));
		
		userField = new JTextField();
		GridBagConstraints gbc_userField = new GridBagConstraints();
		gbc_userField.weightx = 0.2;
		gbc_userField.fill = GridBagConstraints.BOTH;
		gbc_userField.insets = new Insets(0, 0, 5, 5);
		gbc_userField.gridx = 2;
		gbc_userField.gridy = 1;
		panel_1.add(userField, gbc_userField);
		userField.setColumns(10);
		
		label_2 = new JLabel("");
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.weightx = 0.1;
		gbc_label_2.insets = new Insets(0, 0, 5, 0);
		gbc_label_2.gridx = 3;
		gbc_label_2.gridy = 1;
		panel_1.add(label_2, gbc_label_2);
		
		JLabel lblPassword = new JLabel("Password");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.fill = GridBagConstraints.BOTH;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 0);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 2;
		panel_1.add(lblPassword, gbc_lblPassword);
		lblPassword.setOpaque(true);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBackground(new Color(2, 66, 96));
		
		passwordField = new JPasswordField();
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.BOTH;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 2;
		panel_1.add(passwordField, gbc_passwordField);
		
		
		JLabel lblRepatPassw = new JLabel("Confirm Passw");
		GridBagConstraints gbc_lblRepatPassw = new GridBagConstraints();
		gbc_lblRepatPassw.fill = GridBagConstraints.BOTH;
		gbc_lblRepatPassw.insets = new Insets(0, 0, 5, 0);
		gbc_lblRepatPassw.gridx = 1;
		gbc_lblRepatPassw.gridy = 3;
		panel_1.add(lblRepatPassw, gbc_lblRepatPassw);
		lblRepatPassw.setOpaque(true);
		lblRepatPassw.setHorizontalAlignment(SwingConstants.CENTER);
		lblRepatPassw.setForeground(Color.WHITE);
		lblRepatPassw.setBackground(new Color(2, 66, 96));
		
		confirmPasswField = new JPasswordField();
		GridBagConstraints gbc_confirmPasswField = new GridBagConstraints();
		gbc_confirmPasswField.fill = GridBagConstraints.BOTH;
		gbc_confirmPasswField.insets = new Insets(0, 0, 5, 5);
		gbc_confirmPasswField.gridx = 2;
		gbc_confirmPasswField.gridy = 3;
		panel_1.add(confirmPasswField, gbc_confirmPasswField);
		
		JLabel lblName = new JLabel("Name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.fill = GridBagConstraints.BOTH;
		gbc_lblName.insets = new Insets(0, 0, 5, 0);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 4;
		panel_1.add(lblName, gbc_lblName);
		lblName.setOpaque(true);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setForeground(Color.WHITE);
		lblName.setBackground(new Color(2, 66, 96));
		
		nameField = new JTextField();
		GridBagConstraints gbc_nameField = new GridBagConstraints();
		gbc_nameField.fill = GridBagConstraints.BOTH;
		gbc_nameField.insets = new Insets(0, 0, 5, 5);
		gbc_nameField.gridx = 2;
		gbc_nameField.gridy = 4;
		panel_1.add(nameField, gbc_nameField);
		nameField.setColumns(10);
		
		JLabel lblSurname = new JLabel("Surname");
		GridBagConstraints gbc_lblSurname = new GridBagConstraints();
		gbc_lblSurname.fill = GridBagConstraints.BOTH;
		gbc_lblSurname.insets = new Insets(0, 0, 5, 0);
		gbc_lblSurname.gridx = 1;
		gbc_lblSurname.gridy = 5;
		panel_1.add(lblSurname, gbc_lblSurname);
		lblSurname.setOpaque(true);
		lblSurname.setHorizontalAlignment(SwingConstants.CENTER);
		lblSurname.setForeground(Color.WHITE);
		lblSurname.setBackground(new Color(2, 66, 96));
		
		surnameField = new JTextField();
		GridBagConstraints gbc_surnameField = new GridBagConstraints();
		gbc_surnameField.fill = GridBagConstraints.BOTH;
		gbc_surnameField.insets = new Insets(0, 0, 5, 5);
		gbc_surnameField.gridx = 2;
		gbc_surnameField.gridy = 5;
		panel_1.add(surnameField, gbc_surnameField);
		
		JLabel lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.fill = GridBagConstraints.BOTH;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 0);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 6;
		panel_1.add(lblEmail, gbc_lblEmail);
		lblEmail.setOpaque(true);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBackground(new Color(2, 66, 96));
		
		emailField = new JTextField();
		GridBagConstraints gbc_emailField = new GridBagConstraints();
		gbc_emailField.fill = GridBagConstraints.BOTH;
		gbc_emailField.insets = new Insets(0, 0, 5, 5);
		gbc_emailField.gridx = 2;
		gbc_emailField.gridy = 6;
		panel_1.add(emailField, gbc_emailField);
		
		lblError = new JLabel("");
		GridBagConstraints gbc_lblError = new GridBagConstraints();
		gbc_lblError.insets = new Insets(0, 0, 5, 5);
		gbc_lblError.gridx = 1;
		gbc_lblError.gridy = 7;
		panel_1.add(lblError, gbc_lblError);
		lblError.setHorizontalAlignment(SwingConstants.LEFT);
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		
	
		
		lblMessage = new JLabel("Account successfully created!");
		GridBagConstraints gbc_lblMessage = new GridBagConstraints();
		gbc_lblMessage.insets = new Insets(0, 0, 5, 5);
		gbc_lblMessage.gridx = 2;
		gbc_lblMessage.gridy = 7;
		panel_1.add(lblMessage, gbc_lblMessage);
		lblMessage.setVisible(false);
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setForeground(new Color(7, 201, 155));
		lblMessage.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		
		JButton btnCreate = new JButton("Create Account");
		GridBagConstraints gbc_btnCreate = new GridBagConstraints();
		gbc_btnCreate.ipadx = 90;
		gbc_btnCreate.insets = new Insets(0, 0, 5, 5);
		gbc_btnCreate.gridx = 2;
		gbc_btnCreate.gridy = 8;
		panel_1.add(btnCreate, gbc_btnCreate);
		
				btnCreate.addActionListener(new ActionListener() {
		        	public void actionPerformed(ActionEvent arg0) {
		        		try {
		        			String nome = nameField.getText();
		        			String cognome = surnameField.getText();
		        			String username = userField.getText();
		        			char[] password = passwordField.getPassword();
		        			char[] confermaPassword = confirmPasswField.getPassword();
		        			String email = emailField.getText();
		        			String s=(String)comboBox.getSelectedItem();
		    				String[] parts = s.split(" - ");
		    				String pathAvatar="res/"+parts[1]+".png";
		    				
		        			RegistrazioneControl registrazioneControl = new RegistrazioneControl(model);
		        			
		        			if(registrazioneControl.registra(nome, cognome, username, password, confermaPassword, email, false,pathAvatar)) {
		        				lblError.setVisible(false);
		        				lblMessage.setVisible(true);
		        			}
		        		}
		        		catch (UserException u) {
		        			lblError.setText(u.getMessage());
		        		}
		        	}
		        });
	}
}
