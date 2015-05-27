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

import com.smartAPI.model.Utente;

public class ShowUsersInfo extends JPanel{

	public static JLabel lblImage;
	private static int SCORE = 10;
	public static JTextField userField;
	public static JTextField nameField;
	public static JTextField surnameField;
	public static JTextField emailField;
	private JLabel lblEmail;
	private JPanel panelStar;
	private JLabel lblUser ;
	private JLabel lblName;
	private JLabel lblSurname;
	private String avatar="";//iniz. con avatar user
	
	public ShowUsersInfo() {
		setLayout(null);
		setBackground(new Color(2, 94, 137));
		lblImage = new JLabel();
		//path dipende dall'avatar dell'utente
		String path= "res/nouser.png";
		String pathIcon = getClass().getResource(path).getFile();
		MyImageIcon imgicon = new MyImageIcon(pathIcon,80,70);
		lblImage.setIcon(imgicon.getImageResponsive());
		
		lblImage.setBounds(77, 29, 80, 70);
		add(lblImage);
		
		panelStar = new JPanel();
		panelStar.setBackground(new Color(2, 94, 137));
		panelStar.setBounds(57, 127, 127, 50);
		add(panelStar);
		
		lblUser = new JLabel("User");
		lblUser.setOpaque(true);
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setForeground(Color.WHITE);
		lblUser.setBackground(new Color(2, 66, 96));
		lblUser.setBounds(282, 21, 95, 31);
		add(lblUser);
		
		userField = new JTextField();
		userField.setEditable(false);
		userField.setColumns(10);
		userField.setBackground(new Color(230, 230, 230));
		userField.setBounds(374, 18, 204, 37);
		add(userField);
		
		lblName = new JLabel("Name");
		lblName.setOpaque(true);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setForeground(Color.WHITE);
		lblName.setBackground(new Color(2, 66, 96));
		lblName.setBounds(282, 64, 95, 31);
		add(lblName);
		
		nameField = new JTextField();
		nameField.setEditable(false);
		nameField.setBackground(new Color(230, 230, 230));
		nameField.setColumns(10);
		nameField.setBounds(374, 60, 204, 38);
		nameField.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				nameField.setBackground(Color.WHITE);
				
			}
			
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		add(nameField);
		
		lblSurname = new JLabel("Surname");
		lblSurname.setOpaque(true);
		lblSurname.setHorizontalAlignment(SwingConstants.CENTER);
		lblSurname.setForeground(Color.WHITE);
		lblSurname.setBackground(new Color(2, 66, 96));
		lblSurname.setBounds(282, 110, 95, 31);
		add(lblSurname);
		
		surnameField = new JTextField();
		surnameField.addFocusListener(new FocusListener() {
			
			public void focusLost(FocusEvent e) {
				surnameField.setBackground(Color.WHITE);
			}
			
			public void focusGained(FocusEvent e) {
				
			}
		});
		
		surnameField.setEditable(false);
		surnameField.setBackground(new Color(230, 230, 230));
		surnameField.setBounds(374, 106, 204, 37);
		add(surnameField);
		
		lblEmail = new JLabel("Email");
		lblEmail.setOpaque(true);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBackground(new Color(2, 66, 96));
		lblEmail.setBounds(282, 153, 95, 31);
		add(lblEmail);
		
		emailField = new JTextField();
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
		emailField.setBounds(374, 149, 204, 37);
		add(emailField);
	}
			
	public void setUser(Utente u) {
				String path=u.getAvatar();
				String pathIcon = getClass().getResource(path).getFile();
				MyImageIcon imgicon = new MyImageIcon(pathIcon,80,70);
				lblImage.setIcon(imgicon.getImageResponsive());
				userField.setText(u.getNickname());
				
				nameField.setText(u.getNome());
				surnameField.setText(u.getCognome());
				emailField.setText(u.getEmail());
			}

	}

