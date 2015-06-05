package com.smartAPI.view;

import java.awt.Color;
import java.awt.Cursor;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Logger;

import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;

import com.smartAPI.control.IUserOptionListener;
import com.smartAPI.control.IUserPanelListener;
import com.smartAPI.model.Common;
import com.smartAPI.model.SmartAPIModel;
import com.smartAPI.model.UserException;
import com.smartAPI.model.Utente;
import com.smartAPI.test.Main;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.BorderLayout;

public class UserInfoJPanel extends JPanel {
	private static Logger log;
	JLabel lblImage;
	JLabel lblUser;
	JLabel lblPassword;
	JLabel lblName;
	JLabel lblSurname;
	JLabel lblEmail;
	JLabel lblPersonalData;
	private static int SCORE = 10;
	private JTextField userField;
	private JPasswordField passwordField;
	private JTextField nameField;
	private JTextField surnameField;
	private JTextField emailField;
	private JComboBox comboBox;
	private JButton btnSave;
	private ArrayList<IUserOptionListener> listener_s;
	private ArrayList<IUserPanelListener> logOutListener_s;
	private JLabel lblYourInfo;
	private JPanel panel_2;
	private JPanel panel_star;
	Vector comboBoxItems;
	DefaultComboBoxModel model;
	private String avatar=Common.UTENTE.getAvatar();//iniz. con avatar user
	
	public UserInfoJPanel() {
		log = Logger.getLogger("global");
		comboBoxItems = new Vector();
		comboBoxItems.add("");
		model = new DefaultComboBoxModel(
				comboBoxItems);
		comboBox = new JComboBox(model);
		
		
		setBackground(new Color(2, 94, 137));
		// path dipende dall'avatar dell'utente
		String pathIcon = Common.UTENTE.getAvatar();
		MyImageIcon imgicon = new MyImageIcon(pathIcon, 80, 70);
		setLayout(new BorderLayout(0, 0));

		panel_2 = new JPanel();
		panel_2.setBackground(new Color(2, 94, 137));
		add(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 30, 4, 200 };
		gbl_panel_2.rowHeights = new int[] { 0, 30, 30, 30, 0, 0, 30, 0, 0, 0,
				30, 30, 0, 0, 0, 30 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 0.0, 0.0 };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0 };
		panel_2.setLayout(gbl_panel_2);

		lblYourInfo = new JLabel("YOUR INFO");
		GridBagConstraints gbc_lblYourInfo = new GridBagConstraints();
		gbc_lblYourInfo.gridwidth = 4;
		gbc_lblYourInfo.fill = GridBagConstraints.BOTH;
		gbc_lblYourInfo.insets = new Insets(0, 0, 5, 0);
		gbc_lblYourInfo.gridx = 0;
		gbc_lblYourInfo.gridy = 0;
		panel_2.add(lblYourInfo, gbc_lblYourInfo);
		lblYourInfo.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblYourInfo.setOpaque(true);
		lblYourInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourInfo.setForeground(Color.YELLOW);
		lblYourInfo.setBackground(new Color(27, 147, 225));
		lblYourInfo.setHorizontalAlignment(SwingConstants.CENTER);

		JButton btnModify = new JButton("");
		GridBagConstraints gbc_btnModify = new GridBagConstraints();
		gbc_btnModify.fill = GridBagConstraints.VERTICAL;
		gbc_btnModify.insets = new Insets(0, 0, 5, 0);
		gbc_btnModify.gridx = 3;
		gbc_btnModify.gridy = 1;
		pathIcon = "res/pencil.png";
		imgicon = new MyImageIcon(pathIcon, 20, 20);
		btnModify.setIcon(imgicon.getImageResponsive());
		panel_2.add(btnModify, gbc_btnModify);
		btnModify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comboBox.setVisible(true);
				passwordField.setBackground(Color.WHITE);
				passwordField.setEditable(true);
				nameField.setBackground(Color.WHITE);
				nameField.setEditable(true);
				surnameField.setBackground(Color.WHITE);
				surnameField.setEditable(true);
				emailField.setBackground(Color.WHITE);
				emailField.setEditable(true);
				btnSave.setVisible(true);

			}
		});

		lblImage = new JLabel("");
		GridBagConstraints gbc_lblImage = new GridBagConstraints();
		gbc_lblImage.insets = new Insets(0, 0, 5, 5);
		gbc_lblImage.gridx = 1;
		gbc_lblImage.gridy = 4;
		pathIcon = Common.UTENTE.getAvatar();
		imgicon = new MyImageIcon(pathIcon, 80, 70);
		panel_2.add(lblImage, gbc_lblImage);
		lblImage.setIcon(imgicon.getImageResponsive());

		panel_star = new JPanel();
		GridBagConstraints gbc_panelStar = new GridBagConstraints();
		gbc_panelStar.fill = GridBagConstraints.BOTH;
		gbc_panelStar.insets = new Insets(0, 0, 5, 5);
		gbc_panelStar.gridx = 2;
		gbc_panelStar.gridy = 4;
		panel_2.add(panel_star, gbc_panelStar);
		panel_star.setBackground(new Color(2, 94, 137));

		 
		

		lblUser = new JLabel("User");
		GridBagConstraints gbc_lblUser = new GridBagConstraints();
		gbc_lblUser.fill = GridBagConstraints.BOTH;
		gbc_lblUser.insets = new Insets(0, 0, 5, 0);
		gbc_lblUser.gridx = 1;
		gbc_lblUser.gridy = 7;
		panel_2.add(lblUser, gbc_lblUser);
		lblUser.setOpaque(true);
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setForeground(Color.WHITE);
		lblUser.setBackground(new Color(2, 66, 96));

		userField = new JTextField(Common.UTENTE.getNickname());
		GridBagConstraints gbc_userField = new GridBagConstraints();
		gbc_userField.fill = GridBagConstraints.BOTH;
		gbc_userField.insets = new Insets(0, 0, 5, 5);
		gbc_userField.gridx = 2;
		gbc_userField.gridy = 7;
		panel_2.add(userField, gbc_userField);
		userField.setEditable(false);
		userField.setColumns(10);
		userField.setBackground(new Color(230, 230, 230));

		lblPassword = new JLabel("Password");
		GridBagConstraints gbc_lblPassword = new GridBagConstraints();
		gbc_lblPassword.fill = GridBagConstraints.BOTH;
		gbc_lblPassword.insets = new Insets(0, 0, 5, 0);
		gbc_lblPassword.gridx = 1;
		gbc_lblPassword.gridy = 8;
		panel_2.add(lblPassword, gbc_lblPassword);
		lblPassword.setOpaque(true);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBackground(new Color(2, 66, 96));

		passwordField = new JPasswordField(Common.UTENTE.getPassword());
		GridBagConstraints gbc_passwordField = new GridBagConstraints();
		gbc_passwordField.fill = GridBagConstraints.BOTH;
		gbc_passwordField.insets = new Insets(0, 0, 5, 5);
		gbc_passwordField.gridx = 2;
		gbc_passwordField.gridy = 8;
		panel_2.add(passwordField, gbc_passwordField);
		passwordField.setEditable(false);
		passwordField.setBackground(new Color(230, 230, 230));

		lblPersonalData = new JLabel("Personal Data");
		GridBagConstraints gbc_lblPersonalData = new GridBagConstraints();
		gbc_lblPersonalData.fill = GridBagConstraints.BOTH;
		gbc_lblPersonalData.gridwidth = 4;
		gbc_lblPersonalData.insets = new Insets(0, 0, 5, 0);
		gbc_lblPersonalData.gridx = 0;
		gbc_lblPersonalData.gridy = 9;
		panel_2.add(lblPersonalData, gbc_lblPersonalData);
		lblPersonalData.setOpaque(true);
		lblPersonalData.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonalData.setForeground(Color.YELLOW);
		lblPersonalData.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblPersonalData.setBackground(new Color(27, 147, 225));

		lblName = new JLabel("Name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.fill = GridBagConstraints.BOTH;
		gbc_lblName.insets = new Insets(0, 0, 5, 0);
		gbc_lblName.gridx = 1;
		gbc_lblName.gridy = 12;
		panel_2.add(lblName, gbc_lblName);
		lblName.setOpaque(true);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setForeground(Color.WHITE);
		lblName.setBackground(new Color(2, 66, 96));

		nameField = new JTextField(Common.UTENTE.getNome());
		GridBagConstraints gbc_nameField = new GridBagConstraints();
		gbc_nameField.fill = GridBagConstraints.BOTH;
		gbc_nameField.insets = new Insets(0, 0, 5, 5);
		gbc_nameField.gridx = 2;
		gbc_nameField.gridy = 12;
		panel_2.add(nameField, gbc_nameField);
		nameField.setEditable(false);
		nameField.setBackground(new Color(230, 230, 230));
		nameField.setColumns(10);

		 lblSurname = new JLabel("Surname");
		GridBagConstraints gbc_lblSurname = new GridBagConstraints();
		gbc_lblSurname.fill = GridBagConstraints.BOTH;
		gbc_lblSurname.insets = new Insets(0, 0, 5, 0);
		gbc_lblSurname.gridx = 1;
		gbc_lblSurname.gridy = 13;
		panel_2.add(lblSurname, gbc_lblSurname);
		lblSurname.setOpaque(true);
		lblSurname.setHorizontalAlignment(SwingConstants.CENTER);
		lblSurname.setForeground(Color.WHITE);
		lblSurname.setBackground(new Color(2, 66, 96));

		surnameField = new JTextField(Common.UTENTE.getCognome());
		GridBagConstraints gbc_surnameField = new GridBagConstraints();
		gbc_surnameField.fill = GridBagConstraints.BOTH;
		gbc_surnameField.insets = new Insets(0, 0, 5, 5);
		gbc_surnameField.gridx = 2;
		gbc_surnameField.gridy = 13;
		panel_2.add(surnameField, gbc_surnameField);
		surnameField.setEditable(false);
		surnameField.setBackground(new Color(230, 230, 230));

		lblEmail = new JLabel("Email");
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.fill = GridBagConstraints.BOTH;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 0);
		gbc_lblEmail.gridx = 1;
		gbc_lblEmail.gridy = 14;
		panel_2.add(lblEmail, gbc_lblEmail);
		lblEmail.setOpaque(true);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBackground(new Color(2, 66, 96));

		emailField = new JTextField(Common.UTENTE.getEmail());
		GridBagConstraints gbc_emailField = new GridBagConstraints();
		gbc_emailField.fill = GridBagConstraints.BOTH;
		gbc_emailField.insets = new Insets(0, 0, 5, 5);
		gbc_emailField.gridx = 2;
		gbc_emailField.gridy = 14;
		panel_2.add(emailField, gbc_emailField);
		emailField.setEditable(false);
		emailField.setBackground(new Color(230, 230, 230));

		btnSave = new JButton("Save");
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.ipadx = 92;
		gbc_btnSave.insets = new Insets(0, 0, 5, 5);
		gbc_btnSave.gridx = 2;
		gbc_btnSave.gridy = 16;
		panel_2.add(btnSave, gbc_btnSave);
		btnSave.setVisible(false);
		final JLabel lblError = new JLabel("");
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nick = Common.UTENTE.getNickname();
				SmartAPIModel m = new SmartAPIModel();
				try{
					m.modificaUtente(nick, passwordField.getText(),
							nameField.getText(), surnameField.getText(),
							emailField.getText(), avatar);
					comboBox.setVisible(false);
					passwordField.setBackground(new Color(230, 230, 230));
					passwordField.setEditable(false);
					nameField.setBackground(new Color(230, 230, 230));
					nameField.setEditable(false);
					surnameField.setBackground(new Color(230, 230, 230));
					surnameField.setEditable(false);
					emailField.setBackground(new Color(230, 230, 230));
					emailField.setEditable(false);
					btnSave.setVisible(false);
				} catch(UserException u){
					lblError.setText(u.getMessage());
				}

			}
		});

		JButton btnOut = new JButton("Log out");
		GridBagConstraints gbc_btnOut = new GridBagConstraints();
		gbc_btnOut.ipadx = 80;
		gbc_btnOut.insets = new Insets(0, 0, 5, 5);
		gbc_btnOut.gridx = 2;
		gbc_btnOut.gridy = 17;
		panel_2.add(btnOut, gbc_btnOut);

		
		GridBagConstraints gbc_lblError = new GridBagConstraints();
		gbc_lblError.insets = new Insets(0, 0, 0, 5);
		gbc_lblError.gridx = 2;
		gbc_lblError.gridy = 18;
		panel_2.add(lblError, gbc_lblError);
		lblError.setHorizontalAlignment(SwingConstants.LEFT);
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		btnOut.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				for (IUserPanelListener i : logOutListener_s) {
					i.logOutClicked();
				}
				log.info("LOGOUT");
			}
		});

		int numStelle = LoginGrafica.getModel().cambiaStelle(
				userField.getText());

	

		ImageIcon star = new ImageIcon();
		if(Common.UTENTE.isAdmin())
			pathIcon = "res/starwhite.png";
		else
			pathIcon = "res/star.png";
		imgicon = new MyImageIcon(pathIcon, 20, 20);
		star = imgicon.getImageResponsive();
		for (int i = 0; i < numStelle; i++) {
			panel_star.add(new JLabel(star));
		}
	}

	public void addListener(IUserOptionListener i) {
		if (listener_s == null) {
			listener_s = new ArrayList<IUserOptionListener>();
		}
		listener_s.add(i);
	}

	public void addLogOutListener(IUserPanelListener i) {
		if (logOutListener_s == null) {
			logOutListener_s = new ArrayList<IUserPanelListener>();
		}
		logOutListener_s.add(i);
	}
	
	public void isAdmin(boolean isAdmin){
		if (isAdmin){
			panel_star.setBackground(new Color(250, 172, 88));
			setBackground(new Color(250, 172, 88));
			panel_2.setBackground(new Color(250, 172, 88));
			lblYourInfo.setText("ADMIN INFO");
			lblYourInfo.setBackground(new Color(151, 121, 102));
			comboBoxItems = new Vector();
			comboBoxItems.add("admin - 1");
			comboBoxItems.add("admin - 2");

			model = new DefaultComboBoxModel(
					comboBoxItems);
			comboBox = new JComboBox(model);
			comboBox.setVisible(false);
			GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.fill = GridBagConstraints.BOTH;
			gbc_comboBox.insets = new Insets(0, 0, 5, 5);
			gbc_comboBox.gridx = 1;
			gbc_comboBox.gridy = 5;
			panel_2.add(comboBox, gbc_comboBox);
			comboBox.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					String s = (String) comboBox.getSelectedItem();
					String[] parts = s.split(" - ");
					String pathIcon="";
					pathIcon = "res/admin-" + parts[1] + ".png";
					avatar = pathIcon;
					MyImageIcon imgicon = new MyImageIcon(pathIcon, 80, 70);
					lblImage.setIcon(imgicon.getImageResponsive());
				}
			});
			
			
			lblUser.setBackground(new Color(180, 95, 4));
			lblPassword.setBackground(new Color(180, 95, 4));
			lblName.setBackground(new Color(180, 95, 4));
			lblSurname.setBackground(new Color(180, 95, 4));
			lblEmail.setBackground(new Color(180, 95, 4));
			lblPersonalData.setBackground(new Color(151, 121, 102));
			
		}
		else{
			panel_star.setBackground(new Color(2, 94, 137));
			setBackground(new Color(2, 94, 137));
			panel_2.setBackground(new Color(2, 94, 137));
			lblYourInfo.setText("YOUR INFO");
			comboBoxItems = new Vector();
			
			comboBoxItems.add("avatar - 1");
			comboBoxItems.add("avatar - 2");
			comboBoxItems.add("avatar - 3");
			comboBoxItems.add("avatar - 4");
			comboBoxItems.add("avatar - 5");
			comboBoxItems.add("avatar - 6");
			comboBoxItems.add("avatar - 7");
			comboBoxItems.add("avatar - 8");

			model = new DefaultComboBoxModel(
					comboBoxItems);
			comboBox = new JComboBox(model);
			comboBox.setVisible(false);
			GridBagConstraints gbc_comboBox = new GridBagConstraints();
			gbc_comboBox.fill = GridBagConstraints.BOTH;
			gbc_comboBox.insets = new Insets(0, 0, 5, 5);
			gbc_comboBox.gridx = 1;
			gbc_comboBox.gridy = 5;
			panel_2.add(comboBox, gbc_comboBox);
			comboBox.addActionListener(new ActionListener() {

				public void actionPerformed(ActionEvent e) {
					String s = (String) comboBox.getSelectedItem();
					String[] parts = s.split(" - ");
					String pathIcon="";
					pathIcon = "res/" + parts[1] + ".png";
					avatar = pathIcon;
					MyImageIcon imgicon = new MyImageIcon(pathIcon, 80, 70);
					lblImage.setIcon(imgicon.getImageResponsive());
					
					
				}
			});
		}
	}
}
