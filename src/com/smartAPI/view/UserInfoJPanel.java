package com.smartAPI.view;

import java.awt.Color;

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
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;
import java.awt.Font;

public class UserInfoJPanel extends JPanel {

	JLabel lblImage;
	private static int SCORE = 10;
	private JTextField userField;
	private JPasswordField passwordField;
	private JTextField nameField;
	private JTextField surnameField;
	private JTextField emailField;
	private final JComboBox comboBox;
	private JButton btnSave;
	private String avatar="";//iniz. con avatar user
	
	public UserInfoJPanel(String user,String password,String name,String surname,String email) {
		setLayout(null);
		setBackground(new Color(228, 230, 235));

		lblImage = new JLabel("");
		//path dipende dall'avatar dell'utente
		String path="res/1.png";
		String pathIcon = getClass().getResource(path).getFile();
		MyImageIcon imgicon = new MyImageIcon(pathIcon,80,70);
		lblImage.setIcon(imgicon.getImageResponsive());
		
		lblImage.setBounds(73, 122, 80, 71);
		add(lblImage);
		
		JButton btnModify = new JButton("");
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
		btnModify.setBounds(306, 63, 26, 29);
		path="res/pencil.png";
		pathIcon = getClass().getResource(path).getFile();
		imgicon = new MyImageIcon(pathIcon,20,20);
		btnModify.setIcon(imgicon.getImageResponsive());
		add(btnModify);
		
		Vector comboBoxItems=new Vector();
	    comboBoxItems.add("avatar - 1");
	    comboBoxItems.add("avatar - 2");
	    comboBoxItems.add("avatar - 3");
	    comboBoxItems.add("avatar - 4");
	    comboBoxItems.add("avatar - 5");
	    comboBoxItems.add("avatar - 6");
	    final DefaultComboBoxModel model = new DefaultComboBoxModel(comboBoxItems);
		
		JLabel lblYourInfo = new JLabel("YOUR INFO");
		lblYourInfo.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblYourInfo.setOpaque(true);
		lblYourInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourInfo.setForeground(Color.YELLOW);
		lblYourInfo.setBackground(new Color(27, 147, 225));
		lblYourInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblYourInfo.setBounds(32, 35, 333, 86);
		add(lblYourInfo);
		
		JPanel panel = new JPanel();
		panel.setBounds(32, 201, 333, 619);
		panel.setBackground(new Color(2, 94, 137));

		add(panel);
		panel.setLayout(null);
		comboBox = new JComboBox(model);
		comboBox.setBounds(27, 6, 117, 31);
		panel.add(comboBox);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setBounds(27, 64, 95, 31);
		panel.add(lblUser);
		lblUser.setOpaque(true);
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setForeground(Color.WHITE);
		lblUser.setBackground(new Color(2, 66, 96));
		
		userField = new JTextField(user);
		userField.setBounds(119, 61, 204, 37);
		panel.add(userField);
		userField.setEditable(false);
		userField.setColumns(10);
		userField.setBackground(new Color(230, 230, 230));
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(27, 95, 95, 31);
		panel.add(lblPassword);
		lblPassword.setOpaque(true);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBackground(new Color(2, 66, 96));
		
		passwordField = new JPasswordField(password);
		passwordField.setBounds(119, 91, 204, 37);
		panel.add(passwordField);
		passwordField.setEditable(false);
		passwordField.setBackground(new Color(230, 230, 230));
		
		JLabel lblPersonalData = new JLabel("Personal Data");
		lblPersonalData.setBounds(0, 175, 333, 50);
		panel.add(lblPersonalData);
		lblPersonalData.setOpaque(true);
		lblPersonalData.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonalData.setForeground(Color.YELLOW);
		lblPersonalData.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblPersonalData.setBackground(new Color(27, 147, 225));
		
		JLabel lblName = new JLabel("Name");
		lblName.setBounds(24, 287, 95, 31);
		panel.add(lblName);
		lblName.setOpaque(true);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setForeground(Color.WHITE);
		lblName.setBackground(new Color(2, 66, 96));
		
		nameField = new JTextField(name);
		nameField.setBounds(116, 283, 204, 37);
		panel.add(nameField);
		nameField.setEditable(false);
		nameField.setBackground(new Color(230, 230, 230));
		nameField.setColumns(10);
		
		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(24, 317, 95, 31);
		panel.add(lblSurname);
		lblSurname.setOpaque(true);
		lblSurname.setHorizontalAlignment(SwingConstants.CENTER);
		lblSurname.setForeground(Color.WHITE);
		lblSurname.setBackground(new Color(2, 66, 96));
		
		surnameField = new JTextField(surname);
		surnameField.setBounds(116, 313, 204, 37);
		panel.add(surnameField);
		surnameField.addFocusListener(new FocusListener() {
			
			public void focusLost(FocusEvent e) {
				surnameField.setBackground(Color.WHITE);
			}
			
			public void focusGained(FocusEvent e) {
				
			}
		});
		
		surnameField.setEditable(false);
		surnameField.setBackground(new Color(230, 230, 230));
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(24, 347, 95, 31);
		panel.add(lblEmail);
		lblEmail.setOpaque(true);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBackground(new Color(2, 66, 96));
		
		emailField = new JTextField(email);
		emailField.setBounds(116, 343, 204, 37);
		panel.add(emailField);
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
		
		btnSave = new JButton("Save");
		btnSave.setBounds(85, 406, 181, 29);
		panel.add(btnSave);
		btnSave.setVisible(false);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Passw: "+passwordField.getText());
				System.out.println("Name: "+nameField.getText());
				System.out.println("Surname: "+surnameField.getText());
				System.out.println("Email: "+emailField.getText());
				System.out.println("Avatar: "+avatar);

				comboBox.setVisible(false);
				passwordField.setBackground(new Color(230, 230, 230));
				passwordField.setEditable(true);
				nameField.setBackground(new Color(230, 230, 230));
				nameField.setEditable(true);
				surnameField.setBackground(new Color(230, 230, 230));
				surnameField.setEditable(true);
				emailField.setBackground(new Color(230, 230, 230));
				emailField.setEditable(true);
				btnSave.setVisible(false);
				
			}
		});
		nameField.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				nameField.setBackground(Color.WHITE);
				
			}
			
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
		comboBox.setVisible(false);
		comboBox.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String s=(String)comboBox.getSelectedItem();
				String[]parts = s.split(" - ");
				String path="res/"+parts[1]+".png";
				avatar=parts[1];
				String pathIcon = getClass().getResource(path).getFile();				
				MyImageIcon imgicon = new MyImageIcon(pathIcon,80,70);
				lblImage.setIcon(imgicon.getImageResponsive());
			}
		});
		
		JPanel panelStar = new JPanel();
		panelStar.setBounds(205, 133, 127, 50);
		add(panelStar);
		panelStar.setBackground(new Color(228, 230, 235));
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
