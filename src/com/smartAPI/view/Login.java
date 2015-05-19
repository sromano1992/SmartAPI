package com.smartAPI.view;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class Login {

	private JFrame frame;
	private JTextField userField;
	private JPasswordField passwordField;
	private JLabel lblUser;
	private JLabel lblPassword;
	private JLabel lblNewAccount;
	private static final Logger Log = Logger.getLogger( "InfoLogging" );
	private JLabel lblError;



	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
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
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(new Color(2, 94, 137));
		frame.setBounds(100, 100, 468, 369);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		//USER FIELD
		userField = new JTextField();
		userField.setBounds(166, 86, 204, 52);
		frame.getContentPane().add(userField);
		userField.setColumns(10);
		
		//PASSWORD FIELD
		passwordField = new JPasswordField();
		passwordField.setBounds(166, 131, 204, 52);
		frame.getContentPane().add(passwordField);
		
		//LABEL USER
		lblUser = new JLabel("User");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setForeground(Color.WHITE);
		lblUser.setBackground(new Color(2, 66, 96));
		lblUser.setOpaque(true);
		lblUser.setBounds(91, 89, 79, 45);
		frame.getContentPane().add(lblUser);
		
		//LABEL PASSWORD
		lblPassword = new JLabel("Password");
		lblPassword.setOpaque(true);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBackground(new Color(2, 66, 96));
		lblPassword.setBounds(91, 134, 79, 45);
		frame.getContentPane().add(lblPassword);
		
		//BUTTON LOGIN
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Log.info("username: "+userField.getText());
				Log.info("password: "+passwordField.getText());
			}
		});
		btnLogin.setBounds(91, 251, 274, 37);
		frame.getContentPane().add(btnLogin);
		
		//LABEL LOGIN
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setBounds(6, 26, 456, 37);
		frame.getContentPane().add(lblLogin);
		
		//LABEL NEWACCOUNT
		lblNewAccount = new JLabel("Create an account");
		lblNewAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Log.info("create new account");
			}
		});
		lblNewAccount.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewAccount.setForeground(new Color(7, 201, 155));
		lblNewAccount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewAccount.setBounds(190, 184, 177, 16);
		frame.getContentPane().add(lblNewAccount);
		
		//LABEL ERROR
		lblError = new JLabel("User not found");
		lblError.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblError.setHorizontalAlignment(SwingConstants.LEFT);
		lblError.setForeground(Color.RED);
		lblError.setBounds(91, 185, 120, 16);
		frame.getContentPane().add(lblError);
	}

}
