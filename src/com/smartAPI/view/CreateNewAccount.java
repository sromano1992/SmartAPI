package com.smartAPI.view;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.io.File;
import java.io.FileFilter;
import java.io.IOException;
import java.nio.file.DirectoryStream.Filter;
import java.util.Vector;

import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import javax.swing.text.html.ImageView;
import javax.swing.text.Element;

import java.awt.Toolkit;

import javax.swing.JComboBox;


public class CreateNewAccount extends JFrame{

	private JFrame frame;
	private JTextField userField;
	private JPasswordField passwordField;
	private JTextField textField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JPasswordField passwordField_3;
	private JLabel lblIcon;

	
	public CreateNewAccount() {
		initialize();
	}

	private void initialize() {
		setResizable(false);
		getContentPane().setBackground(new Color(2, 94, 137));
		setBounds(100, 100, 425, 537);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		JLabel lblCreateNewAccount = new JLabel("Create Account");
		lblCreateNewAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateNewAccount.setForeground(Color.WHITE);
		lblCreateNewAccount.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		lblCreateNewAccount.setBounds(6, 21, 417, 37);
		getContentPane().add(lblCreateNewAccount);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setOpaque(true);
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setForeground(Color.WHITE);
		lblUser.setBackground(new Color(2, 66, 96));
		lblUser.setBounds(47, 195, 95, 31);
		getContentPane().add(lblUser);
		
		userField = new JTextField();
		userField.setColumns(10);
		userField.setBounds(139, 192, 204, 37);
		getContentPane().add(userField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setOpaque(true);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBackground(new Color(2, 66, 96));
		lblPassword.setBounds(47, 226, 95, 31);
		getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(139, 222, 204, 37);
		getContentPane().add(passwordField);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(139, 282, 204, 37);
		getContentPane().add(textField);
		
		JLabel lblNome = new JLabel("Name");
		lblNome.setOpaque(true);
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setForeground(Color.WHITE);
		lblNome.setBackground(new Color(2, 66, 96));
		lblNome.setBounds(47, 286, 95, 31);
		getContentPane().add(lblNome);
		
		JLabel lblCognome = new JLabel("Surname");
		lblCognome.setOpaque(true);
		lblCognome.setHorizontalAlignment(SwingConstants.CENTER);
		lblCognome.setForeground(Color.WHITE);
		lblCognome.setBackground(new Color(2, 66, 96));
		lblCognome.setBounds(47, 316, 95, 31);
		getContentPane().add(lblCognome);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(139, 312, 204, 37);
		getContentPane().add(passwordField_1);
		
		JButton btnCreate = new JButton("Create Account");
		btnCreate.setBounds(69, 437, 274, 37);
		getContentPane().add(btnCreate);
		
		JLabel lblRepatPassw = new JLabel("Confirm Passw");
		lblRepatPassw.setOpaque(true);
		lblRepatPassw.setHorizontalAlignment(SwingConstants.CENTER);
		lblRepatPassw.setForeground(Color.WHITE);
		lblRepatPassw.setBackground(new Color(2, 66, 96));
		lblRepatPassw.setBounds(47, 257, 95, 31);
		getContentPane().add(lblRepatPassw);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(139, 252, 204, 37);
		getContentPane().add(passwordField_2);
		
		passwordField_3 = new JPasswordField();
		passwordField_3.setBounds(139, 342, 204, 37);
		getContentPane().add(passwordField_3);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setOpaque(true);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBackground(new Color(2, 66, 96));
		lblEmail.setBounds(47, 346, 95, 31);
		getContentPane().add(lblEmail);
		
		lblIcon = new JLabel("");
		String path="res/1.png";
		String pathIcon = getClass().getResource(path).getFile();
		MyImageIcon imgicon = new MyImageIcon(pathIcon);
		lblIcon.setIcon(imgicon.getImageResponsive());
		lblIcon.setBounds(81, 80, 80, 71);
		getContentPane().add(lblIcon);
		
		
		Vector comboBoxItems=new Vector();
	    comboBoxItems.add("img - 1");
	    comboBoxItems.add("img - 2");
	    comboBoxItems.add("img - 3");
	    comboBoxItems.add("img - 4");
	    comboBoxItems.add("img - 5");
	    comboBoxItems.add("img - 6");
	    final DefaultComboBoxModel model = new DefaultComboBoxModel(comboBoxItems);
	    final JComboBox comboBox = new JComboBox(model);
	    comboBox.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				String s=(String)comboBox.getSelectedItem();
				String[] parts = s.split(" - ");
				String path="res/"+parts[1]+".png";
				String pathIcon = getClass().getResource(path).getFile();				
				MyImageIcon imgicon = new MyImageIcon(pathIcon);
				lblIcon.setIcon(imgicon.getImageResponsive());
			}
		});
		
		comboBox.setBounds(214, 101, 109, 31);
		getContentPane().add(comboBox);
		
		
	}
}
