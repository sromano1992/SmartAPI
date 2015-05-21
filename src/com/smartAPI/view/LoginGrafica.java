package com.smartAPI.view;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Logger;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.smartAPI.control.CreateNewUserListener;
import com.smartAPI.model.SmartAPIModel;
import com.smartAPI.model.UserException;


public class LoginGrafica extends JPanel{
	private Logger log = Logger.getLogger("global");
	private JTextField userField;
	private JPasswordField passwordField;
	private JLabel lblUser;
	private JLabel lblPassword;
	private JLabel lblNewAccount;
	private static final Logger Log = Logger.getLogger( "InfoLogging" );
	private JLabel lblError;
	private SmartAPIModel model;
	private ArrayList<CreateNewUserListener> newUserListener_s;


	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					model = new SmartAPIModel();
					LoginGrafica window = new LoginGrafica();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 */

	/**
	 * Initialize the contents of the frame.
	 */
	public LoginGrafica() {
		newUserListener_s = new ArrayList<CreateNewUserListener>();
		model = new SmartAPIModel();
		this.setBackground(new Color(2, 94, 137));
		this.setBounds(100, 100, 468, 369);
		this.setLayout(null);
		
		//USER FIELD
		userField = new JTextField();
		userField.setBounds(166, 86, 204, 52);
		this.add(userField);
		userField.setColumns(10);
		
		//PASSWORD FIELD
		passwordField = new JPasswordField();
		passwordField.setBounds(166, 131, 204, 52);
		this.add(passwordField);
		
		//LABEL USER
		lblUser = new JLabel("User");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setForeground(Color.WHITE);
		lblUser.setBackground(new Color(2, 66, 96));
		lblUser.setOpaque(true);
		lblUser.setBounds(91, 89, 79, 45);
		this.add(lblUser);
		
		//LABEL PASSWORD
		lblPassword = new JLabel("Password");
		lblPassword.setOpaque(true);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBackground(new Color(2, 66, 96));
		lblPassword.setBounds(91, 134, 79, 45);
		this.add(lblPassword);
		
		//BUTTON LOGIN
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		try {
        			String username = userField.getText();
        			char[] confermaPassword = passwordField.getPassword();
        			if(username.trim().equals("") || Arrays.toString(confermaPassword).trim().equals((""))) {
        				lblError.setVisible(true);
            			throw new UserException("User not found");
        			}
        			StringBuilder realPassword = new StringBuilder();
        			for(char s : confermaPassword) {
        			    realPassword.append(s);
        			}
        			if(model.exists(username, realPassword.toString())) {
        				JOptionPane.showMessageDialog(null, "Login effettuato con successo");
        	        	if(model.isAdministrator(username)) {
        	        		new PannelloAmministratore(model);
        	        	}
        	        	//else pannello utente
        			}
        		}
        		catch(UserException u) {
        			lblError.setText(u.getMessage());
        		}
        	}
        });
		btnLogin.setBounds(91, 251, 274, 37);
		this.add(btnLogin);
		
		//LABEL LOGIN
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setBounds(6, 26, 456, 37);
		this.add(lblLogin);
		
		//LABEL NEWACCOUNT
		lblNewAccount = new JLabel("Create an account");
		lblNewAccount.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				for (CreateNewUserListener c:newUserListener_s){
					c.newAccountClicked();
				}
				log.info("raised evento to " + newUserListener_s.size() + " listeners...");
			}
			public void mouseEntered(MouseEvent e) {
				e.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblNewAccount.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewAccount.setForeground(new Color(7, 201, 155));
		lblNewAccount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewAccount.setBounds(190, 184, 177, 16);
		this.add(lblNewAccount);
		
		//LABEL ERROR
		lblError = new JLabel("");
		lblError.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblError.setHorizontalAlignment(SwingConstants.LEFT);
		lblError.setForeground(Color.RED);
		lblError.setBounds(91, 185, 120, 16);
		this.add(lblError);
		this.setVisible(true);
	}

	public void addNewAccountListener(CreateNewUserListener c){
		newUserListener_s.add(c);
		log.info("Added listener...");
	}
}
