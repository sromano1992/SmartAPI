package com.smartAPI.view;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class UserInfo extends JPanel {

	JLabel lblImage;
	private static int SCORE = 10;
	private JTextField userField;
	private JPasswordField passwordField;
	private JTextField nameField;
	private JTextField surnameField;
	private JTextField emailField;
	
	public UserInfo(String user,String password,String name,String surname,String email) {
		setLayout(null);
		setBackground(new Color(2, 94, 137));
		lblImage = new JLabel("");
		//path dipende dall'avatar dell'utente
		String path="res/1.png";
		String pathIcon = getClass().getResource(path).getFile();
		MyImageIcon imgicon = new MyImageIcon(pathIcon,80,70);
		lblImage.setIcon(imgicon.getImageResponsive());
		
		lblImage.setBounds(49, 54, 80, 71);
		add(lblImage);
		
		JPanel panelStar = new JPanel();
		panelStar.setBackground(new Color(2, 94, 137));
		panelStar.setBounds(144, 64, 127, 50);
		add(panelStar);
		
		JLabel label = new JLabel("User");
		label.setOpaque(true);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setBackground(new Color(2, 66, 96));
		label.setBounds(18, 173, 95, 31);
		add(label);
		
		userField = new JTextField(user);
		userField.setEditable(false);
		userField.setColumns(10);
		userField.setBounds(110, 170, 204, 37);
		add(userField);
		
		JLabel label_1 = new JLabel("Password");
		label_1.setOpaque(true);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setBackground(new Color(2, 66, 96));
		label_1.setBounds(18, 204, 95, 31);
		add(label_1);
		
		passwordField = new JPasswordField(password);
		passwordField.setEditable(false);
		passwordField.setBounds(110, 200, 204, 37);
		add(passwordField);
		
		JLabel label_2 = new JLabel("Name");
		label_2.setOpaque(true);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.WHITE);
		label_2.setBackground(new Color(2, 66, 96));
		label_2.setBounds(18, 264, 95, 31);
		add(label_2);
		
		nameField = new JTextField(name);
		nameField.setEditable(false);
		nameField.setColumns(10);
		nameField.setBounds(110, 260, 204, 37);
		add(nameField);
		
		JLabel label_3 = new JLabel("Surname");
		label_3.setOpaque(true);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.WHITE);
		label_3.setBackground(new Color(2, 66, 96));
		label_3.setBounds(18, 294, 95, 31);
		add(label_3);
		
		surnameField = new JTextField(surname);
		surnameField.setEditable(false);
		surnameField.setBounds(110, 290, 204, 37);
		add(surnameField);
		
		JLabel label_4 = new JLabel("Email");
		label_4.setOpaque(true);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.WHITE);
		label_4.setBackground(new Color(2, 66, 96));
		label_4.setBounds(18, 324, 95, 31);
		add(label_4);
		
		emailField = new JTextField(email);
		emailField.setEditable(false);
		emailField.setBounds(110, 320, 204, 37);
		add(emailField);
		
		JButton btnModName = new JButton("");
		btnModName.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				nameField.setEditable(true);
			}
		});
		btnModName.setBounds(309, 264, 26, 29);
		path="res/pencil.png";
		pathIcon = getClass().getResource(path).getFile();
		imgicon = new MyImageIcon(pathIcon,20,20);
		btnModName.setIcon(imgicon.getImageResponsive());
		add(btnModName);
		
		JButton buttonSurname = new JButton("");
		buttonSurname.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				surnameField.setEditable(true);
			}
		});
		path="res/pencil.png";
		pathIcon = getClass().getResource(path).getFile();
		imgicon = new MyImageIcon(pathIcon,20,20);
		buttonSurname.setIcon(imgicon.getImageResponsive());
		buttonSurname.setBounds(309, 294, 26, 29);
		add(buttonSurname);
		
		JButton buttonEmail = new JButton("");
		buttonEmail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				emailField.setEditable(true);
			}
		});
		path="res/pencil.png";
		pathIcon = getClass().getResource(path).getFile();
		imgicon = new MyImageIcon(pathIcon,20,20);
		buttonEmail.setIcon(imgicon.getImageResponsive());
		buttonEmail.setBounds(309, 325, 26, 29);
		add(buttonEmail);
		ImageIcon star=new ImageIcon();
		path="res/star.png";
		pathIcon = getClass().getResource(path).getFile();
		imgicon = new MyImageIcon(pathIcon,20,20);
		star=imgicon.getImageResponsive();
		for (int i=0; i<SCORE; i++){
			panelStar.add(new JLabel(star));
	    }
		
	}
}
