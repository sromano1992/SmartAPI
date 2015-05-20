package com.smartAPI.view;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class ShowUsers_Ste extends JPanel{

	JLabel lblImage;
	private static int SCORE = 10;
	private JTextField userField;
	private JPasswordField passwordField;
	private JTextField nameField;
	private JTextField surnameField;
	private JTextField emailField;
	private String avatar="";//iniz. con avatar user
	
			
			
	public ShowUsers_Ste(String user,String password,String name,String surname,String email) {
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
				panelStar.setBounds(154, 64, 127, 50);
				add(panelStar);
				
				JLabel lblUser = new JLabel("User");
				lblUser.setOpaque(true);
				lblUser.setHorizontalAlignment(SwingConstants.CENTER);
				lblUser.setForeground(Color.WHITE);
				lblUser.setBackground(new Color(2, 66, 96));
				lblUser.setBounds(18, 166, 95, 31);
				add(lblUser);
				
				userField = new JTextField(user);
				userField.setEditable(false);
				userField.setColumns(10);
				userField.setBackground(new Color(230, 230, 230));
				userField.setBounds(110, 163, 204, 37);
				add(userField);
				
				JLabel lblPassword = new JLabel("Password");
				lblPassword.setOpaque(true);
				lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
				lblPassword.setForeground(Color.WHITE);
				lblPassword.setBackground(new Color(2, 66, 96));
				lblPassword.setBounds(18, 197, 95, 31);
				add(lblPassword);
				
				passwordField = new JPasswordField(password);
				passwordField.setEditable(false);
				passwordField.setBackground(new Color(230, 230, 230));
				passwordField.setBounds(110, 193, 204, 37);
				add(passwordField);
				
				JLabel lblName = new JLabel("Name");
				lblName.setOpaque(true);
				lblName.setHorizontalAlignment(SwingConstants.CENTER);
				lblName.setForeground(Color.WHITE);
				lblName.setBackground(new Color(2, 66, 96));
				lblName.setBounds(18, 258, 95, 31);
				add(lblName);
				
				nameField = new JTextField(name);
				nameField.setEditable(false);
				nameField.setBackground(new Color(230, 230, 230));
				nameField.setColumns(10);
				nameField.setBounds(110, 258, 204, 37);
				nameField.addFocusListener(new FocusListener() {
					public void focusLost(FocusEvent e) {
						nameField.setBackground(Color.WHITE);
						
					}
					
					public void focusGained(FocusEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
				add(nameField);
				
				JLabel lblSurname = new JLabel("Surname");
				lblSurname.setOpaque(true);
				lblSurname.setHorizontalAlignment(SwingConstants.CENTER);
				lblSurname.setForeground(Color.WHITE);
				lblSurname.setBackground(new Color(2, 66, 96));
				lblSurname.setBounds(18, 288, 95, 31);
				add(lblSurname);
				
				surnameField = new JTextField(surname);
				surnameField.addFocusListener(new FocusListener() {
					
					public void focusLost(FocusEvent e) {
						surnameField.setBackground(Color.WHITE);
					}
					
					public void focusGained(FocusEvent e) {
						
					}
				});
				
				surnameField.setEditable(false);
				surnameField.setBackground(new Color(230, 230, 230));
				surnameField.setBounds(110, 284, 204, 37);
				add(surnameField);
				
				JLabel lblEmail = new JLabel("Email");
				lblEmail.setOpaque(true);
				lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
				lblEmail.setForeground(Color.WHITE);
				lblEmail.setBackground(new Color(2, 66, 96));
				lblEmail.setBounds(18, 318, 95, 31);
				add(lblEmail);
				
				emailField = new JTextField(email);
				emailField.addFocusListener(new FocusListener() {
					
					public void focusLost(FocusEvent e) {
						emailField.setBackground(Color.WHITE);
						
					}
					public void focusGained(FocusEvent e) {
						// TODO Auto-generated method stub
						
					}
				});
				emailField.setEditable(false);
				emailField.setBackground(new Color(230, 230, 230));
				emailField.setBounds(110, 314, 204, 37);
				add(emailField);
				path="res/pencil.png";
				pathIcon = getClass().getResource(path).getFile();
				imgicon = new MyImageIcon(pathIcon,20,20);
				
				Vector comboBoxItems=new Vector();
			    comboBoxItems.add("avatar - 1");
			    comboBoxItems.add("avatar - 2");
			    comboBoxItems.add("avatar - 3");
			    comboBoxItems.add("avatar - 4");
			    comboBoxItems.add("avatar - 5");
			    comboBoxItems.add("avatar - 6");
			    final DefaultComboBoxModel model = new DefaultComboBoxModel(comboBoxItems);
				path="res/pencil.png";
				pathIcon = getClass().getResource(path).getFile();
				imgicon = new MyImageIcon(pathIcon,20,20);
				path="res/pencil.png";
				pathIcon = getClass().getResource(path).getFile();
				imgicon = new MyImageIcon(pathIcon,20,20);
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

