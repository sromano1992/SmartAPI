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
	
	public CreateNewAccountJPanel() {
		this.model = new SmartAPIModel();
		setLayout(null);
		setBackground(new Color(2, 94, 137));
		
		//lblCreateNewAccount = new JLabel("Create Account");
		//lblCreateNewAccount.setHorizontalAlignment(SwingConstants.CENTER);
		//lblCreateNewAccount.setForeground(Color.WHITE);
		//lblCreateNewAccount.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		//lblCreateNewAccount.setBounds(17, 180, 417, 37);
		//add(lblCreateNewAccount);
		
		lblUser = new JLabel("User");
		lblUser.setOpaque(true);
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setForeground(Color.WHITE);
		lblUser.setBackground(new Color(2, 66, 96));
		lblUser.setBounds(68, 342, 95, 31);
		add(lblUser);
		
		userField = new JTextField();
		userField.setColumns(10);
		userField.setBounds(160, 339, 204, 37);
		add(userField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setOpaque(true);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBackground(new Color(2, 66, 96));
		lblPassword.setBounds(68, 373, 95, 31);
		add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(160, 369, 204, 37);
		add(passwordField);
		
		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(160, 429, 204, 37);
		add(nameField);
		
		JLabel lblName = new JLabel("Name");
		lblName.setOpaque(true);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setForeground(Color.WHITE);
		lblName.setBackground(new Color(2, 66, 96));
		lblName.setBounds(68, 433, 95, 31);
		add(lblName);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setOpaque(true);
		lblSurname.setHorizontalAlignment(SwingConstants.CENTER);
		lblSurname.setForeground(Color.WHITE);
		lblSurname.setBackground(new Color(2, 66, 96));
		lblSurname.setBounds(68, 463, 95, 31);
		add(lblSurname);
		
		surnameField = new JTextField();
		surnameField.setBounds(160, 459, 204, 37);
		add(surnameField);
		
		JButton btnCreate = new JButton("Create Account");
		btnCreate.setBounds(79, 581, 274, 37);
		add(btnCreate);
		
		
		JLabel lblRepatPassw = new JLabel("Confirm Passw");
		lblRepatPassw.setOpaque(true);
		lblRepatPassw.setHorizontalAlignment(SwingConstants.CENTER);
		lblRepatPassw.setForeground(Color.WHITE);
		lblRepatPassw.setBackground(new Color(2, 66, 96));
		lblRepatPassw.setBounds(68, 404, 95, 31);
		add(lblRepatPassw);
		
		confirmPasswField = new JPasswordField();
		confirmPasswField.setBounds(160, 399, 204, 37);
		add(confirmPasswField);
		
		emailField = new JTextField();
		emailField.setBounds(160, 489, 204, 37);
		add(emailField);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setOpaque(true);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBackground(new Color(2, 66, 96));
		lblEmail.setBounds(68, 493, 95, 31);
		add(lblEmail);
		
		lblIcon = new JLabel("");
		String path="res/1.png";
		String pathIcon = getClass().getResource(path).getFile();
		MyImageIcon imgicon = new MyImageIcon(pathIcon,80,70);
		lblIcon.setIcon(imgicon.getImageResponsive());
		lblIcon.setBounds(101, 249, 80, 71);
		add(lblIcon);
		
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
	    final JComboBox comboBox = new JComboBox(modelCombo);
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
		
		comboBox.setBounds(234, 270, 118, 31);
		add(comboBox);
		
		lblError = new JLabel("");
		lblError.setHorizontalAlignment(SwingConstants.LEFT);
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblError.setBounds(68, 530, 140, 16);
		add(lblError);
		
	
		
		lblMessage = new JLabel("Account successfully created!");
		lblMessage.setVisible(false);
		lblMessage.setHorizontalAlignment(SwingConstants.CENTER);
		lblMessage.setForeground(new Color(7, 201, 155));
		lblMessage.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblMessage.setBounds(79, 545, 274, 16);
		add(lblMessage);
		path="res/logoTxt.png";
		pathIcon = getClass().getResource(path).getFile();
		imgicon = new MyImageIcon(pathIcon,250,100);
		lblIcon.setBounds(101, 249, 80, 71);

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
        			
        			if(registrazioneControl.registra(nome, cognome, username, password, confermaPassword, email, pathAvatar)) {
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
