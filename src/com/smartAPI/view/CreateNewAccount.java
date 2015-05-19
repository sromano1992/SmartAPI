package com.smartAPI.view;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Font;
import java.io.File;
import java.io.FileFilter;
import java.nio.file.DirectoryStream.Filter;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JFileChooser;
import javax.swing.JButton;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class CreateNewAccount {

	private JFrame frame;
	private JTextField userField;
	private JPasswordField passwordField;
	private JTextField textField;
	private JPasswordField passwordField_1;
	private JPasswordField passwordField_2;
	private JPasswordField passwordField_3;
	private JLabel lblImage;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CreateNewAccount window = new CreateNewAccount();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public CreateNewAccount() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(2, 94, 137));
		frame.setBounds(100, 100, 425, 537);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblCreateNewAccount = new JLabel("Create Account");
		lblCreateNewAccount.setHorizontalAlignment(SwingConstants.CENTER);
		lblCreateNewAccount.setForeground(Color.WHITE);
		lblCreateNewAccount.setFont(new Font("Lucida Grande", Font.PLAIN, 26));
		lblCreateNewAccount.setBounds(6, 21, 417, 37);
		frame.getContentPane().add(lblCreateNewAccount);
		
		JLabel lblUser = new JLabel("User");
		lblUser.setOpaque(true);
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setForeground(Color.WHITE);
		lblUser.setBackground(new Color(2, 66, 96));
		lblUser.setBounds(47, 195, 95, 31);
		frame.getContentPane().add(lblUser);
		
		userField = new JTextField();
		userField.setColumns(10);
		userField.setBounds(139, 192, 204, 37);
		frame.getContentPane().add(userField);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setOpaque(true);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBackground(new Color(2, 66, 96));
		lblPassword.setBounds(47, 226, 95, 31);
		frame.getContentPane().add(lblPassword);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(139, 222, 204, 37);
		frame.getContentPane().add(passwordField);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(139, 282, 204, 37);
		frame.getContentPane().add(textField);
		
		JLabel lblNome = new JLabel("Name");
		lblNome.setOpaque(true);
		lblNome.setHorizontalAlignment(SwingConstants.CENTER);
		lblNome.setForeground(Color.WHITE);
		lblNome.setBackground(new Color(2, 66, 96));
		lblNome.setBounds(47, 286, 95, 31);
		frame.getContentPane().add(lblNome);
		
		JLabel lblCognome = new JLabel("Surname");
		lblCognome.setOpaque(true);
		lblCognome.setHorizontalAlignment(SwingConstants.CENTER);
		lblCognome.setForeground(Color.WHITE);
		lblCognome.setBackground(new Color(2, 66, 96));
		lblCognome.setBounds(47, 316, 95, 31);
		frame.getContentPane().add(lblCognome);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(139, 312, 204, 37);
		frame.getContentPane().add(passwordField_1);
		
		JButton btnCreate = new JButton("Create Account");
		btnCreate.setBounds(69, 437, 274, 37);
		frame.getContentPane().add(btnCreate);
		
		lblImage = new JLabel("Image");
		lblImage.setHorizontalAlignment(SwingConstants.CENTER);
		lblImage.setIcon(new ImageIcon("/Users/iCiro/Desktop/screenshot_26.png"));
		lblImage.setBounds(86, 70, 88, 92);
		frame.getContentPane().add(lblImage);
		
		JButton btnNewButton = new JButton("Upload");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser fileChooser = new JFileChooser();
				fileChooser.setAcceptAllFileFilterUsed(false);
				fileChooser.addChoosableFileFilter(new FileNameExtensionFilter("Images", "jpg", "png","gif","bmp"));

		        int returnValue = fileChooser.showOpenDialog(null);
		        if (returnValue == JFileChooser.APPROVE_OPTION) {
		          File selectedFile = fileChooser.getSelectedFile();
		          
		          System.out.println("getCurrentDirectory(): " + fileChooser.getCurrentDirectory());
		          System.out.println("getSelectedFile() : " + fileChooser.getSelectedFile());
		          System.out.println(selectedFile.getPath());
		          
		        ImageIcon image = new ImageIcon(selectedFile.getPath());
		        
		  		lblImage.setIcon(image);
		        }
			}
		});
		btnNewButton.setBounds(207, 103, 117, 29);
		frame.getContentPane().add(btnNewButton);
		
		JLabel lblRepatPassw = new JLabel("Confirm Passw");
		lblRepatPassw.setOpaque(true);
		lblRepatPassw.setHorizontalAlignment(SwingConstants.CENTER);
		lblRepatPassw.setForeground(Color.WHITE);
		lblRepatPassw.setBackground(new Color(2, 66, 96));
		lblRepatPassw.setBounds(47, 257, 95, 31);
		frame.getContentPane().add(lblRepatPassw);
		
		passwordField_2 = new JPasswordField();
		passwordField_2.setBounds(139, 252, 204, 37);
		frame.getContentPane().add(passwordField_2);
		
		passwordField_3 = new JPasswordField();
		passwordField_3.setBounds(139, 342, 204, 37);
		frame.getContentPane().add(passwordField_3);
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setOpaque(true);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBackground(new Color(2, 66, 96));
		lblEmail.setBounds(47, 346, 95, 31);
		frame.getContentPane().add(lblEmail);
		
		
	}
}
