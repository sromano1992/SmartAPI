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
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.smartAPI.control.RegistrazioneControl;
import com.smartAPI.model.SmartAPIModel;
import com.smartAPI.model.UserException;
import com.smartAPI.test.Main;

public class CreateAdminJPanel extends JPanel {

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

	public CreateAdminJPanel() {
		this.model = new SmartAPIModel();
		setLayout(null);
		setBackground(new Color(250, 172, 88));

		lblCreateNewAccount = new JLabel("Create Account");
		lblCreateNewAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateNewAccount.setForeground(Color.WHITE);
		lblCreateNewAccount.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		lblCreateNewAccount.setBounds(424, 127, 417, 37);
		add(lblCreateNewAccount);

		lblUser = new JLabel("User");
		lblUser.setOpaque(true);
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setForeground(Color.WHITE);
		lblUser.setBackground(new Color(180, 95, 4));
		lblUser.setBounds(468, 388, 95, 31);
		add(lblUser);

		userField = new JTextField();
		userField.setColumns(10);
		userField.setBounds(560, 385, 204, 37);
		add(userField);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setOpaque(true);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBackground(new Color(180, 95, 4));
		lblPassword.setBounds(468, 419, 95, 31);
		add(lblPassword);

		passwordField = new JPasswordField();
		passwordField.setBounds(560, 415, 204, 37);
		add(passwordField);

		nameField = new JTextField();
		nameField.setColumns(10);
		nameField.setBounds(560, 475, 204, 37);
		add(nameField);

		JLabel lblName = new JLabel("Name");
		lblName.setOpaque(true);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setForeground(Color.WHITE);
		lblName.setBackground(new Color(180, 95, 4));
		lblName.setBounds(468, 479, 95, 31);
		add(lblName);

		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setOpaque(true);
		lblSurname.setHorizontalAlignment(SwingConstants.CENTER);
		lblSurname.setForeground(Color.WHITE);
		lblSurname.setBackground(new Color(180, 95, 4));
		lblSurname.setBounds(468, 509, 95, 31);
		add(lblSurname);

		surnameField = new JTextField();
		surnameField.setBounds(560, 505, 204, 37);
		add(surnameField);

		JButton btnCreate = new JButton("Create Admin Account");
		btnCreate.setBounds(479, 630, 274, 37);
		add(btnCreate);


		JLabel lblRepatPassw = new JLabel("Confirm Passw");
		lblRepatPassw.setOpaque(true);
		lblRepatPassw.setHorizontalAlignment(SwingConstants.CENTER);
		lblRepatPassw.setForeground(Color.WHITE);
		lblRepatPassw.setBackground(new Color(180, 95, 4));
		lblRepatPassw.setBounds(468, 450, 95, 31);
		add(lblRepatPassw);

		confirmPasswField = new JPasswordField();
		confirmPasswField.setBounds(560, 445, 204, 37);
		add(confirmPasswField);

		emailField = new JTextField();
		emailField.setBounds(560, 535, 204, 37);
		add(emailField);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setOpaque(true);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBackground(new Color(180, 95, 4));
		lblEmail.setBounds(468, 539, 95, 31);
		add(lblEmail);

		lblIcon = new JLabel("");
		String path="res/admin-1.png";
		String pathIcon = getClass().getResource(path).getFile();
		MyImageIcon imgicon = new MyImageIcon(pathIcon,80,70);
		lblIcon.setIcon(imgicon.getImageResponsive());
		lblIcon.setBounds(502, 273, 80, 71);
		add(lblIcon);

		Vector comboBoxItems=new Vector();
		comboBoxItems.add("admin - 1");
		comboBoxItems.add("admin - 2");

		final DefaultComboBoxModel modelCombo = new DefaultComboBoxModel(comboBoxItems);
		final JComboBox comboBox = new JComboBox(modelCombo);
		comboBox.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String s=(String)comboBox.getSelectedItem();
				String[] parts = s.split(" - ");
				String path="res/admin-"+parts[1]+".png";
				String pathIcon = getClass().getResource(path).getFile();				
				MyImageIcon imgicon = new MyImageIcon(pathIcon,80,70);
				lblIcon.setIcon(imgicon.getImageResponsive());
			}
		});

		comboBox.setBounds(635, 294, 118, 31);
		add(comboBox);

		lblError = new JLabel("");
		lblError.setHorizontalAlignment(SwingConstants.LEFT);
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblError.setBounds(468, 584, 140, 16);
		lblError.setVisible(false);
		add(lblError);

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
					String pathAvatar="res/admin-"+parts[1]+".png";

					RegistrazioneControl registrazioneControl = new RegistrazioneControl(model);

					try{
						if(registrazioneControl.registra(nome, cognome, username, password, confermaPassword, email, true, pathAvatar)) {        				
							Main.fAdmin.setVisible(false);
							Main.setVisible();
						}
					}catch(UserException e){
						lblError.setText(e.getMessage());
						lblError.setVisible(true);
					}
				}
				catch (UserException u) {
					lblError.setText(u.getMessage());
				}
			}
		});
	}

}
