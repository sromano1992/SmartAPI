package com.smartAPI.view;
import java.awt.BorderLayout;
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

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JProgressBar;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.smartAPI.control.LoginControl;
import com.smartAPI.control.ILogInPanelListner;
import com.smartAPI.model.Common;
import com.smartAPI.model.SmartAPIModel;
import com.smartAPI.model.UserException;
import com.smartAPI.model.Utente;

import javax.swing.ImageIcon;
import javax.swing.border.Border;


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
	private ArrayList<ILogInPanelListner> logInListener_s;
	private JLabel lblLogo;
	JLabel lblLogin;
	private JProgressBar progressBar;

	/**
	 * Initialize the contents of the frame.
	 */
	public LoginGrafica() {
		logInListener_s = new ArrayList<ILogInPanelListner>();
		model = new SmartAPIModel();
		this.setBackground(new Color(2, 94, 137));
		this.setBounds(100, 100, 468, 660);
		this.setLayout(null);
		
		//USER FIELD
		userField = new JTextField();
		userField.setBounds(175, 396, 204, 52);
		this.add(userField);
		userField.setColumns(10);
		
		//PASSWORD FIELD
		passwordField = new JPasswordField();
		passwordField.setBounds(175, 441, 204, 52);
		this.add(passwordField);
		
		//LABEL USER
		lblUser = new JLabel("User");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setForeground(Color.WHITE);
		lblUser.setBackground(new Color(2, 66, 96));
		lblUser.setOpaque(true);
		lblUser.setBounds(100, 399, 79, 45);
		this.add(lblUser);
		
		//LABEL PASSWORD
		lblPassword = new JLabel("Password");
		lblPassword.setOpaque(true);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBackground(new Color(2, 66, 96));
		lblPassword.setBounds(100, 444, 79, 45);
		this.add(lblPassword);
		
		//BUTTON LOGIN
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {
			
        	public void actionPerformed(ActionEvent arg0) {
        		
        		//progressBar.setVisible(true);
        			
        			//new Thread(new Runnable() {
						
						//@Override
						//public void run() {
							try {
							LoginControl loginControl = new LoginControl(model);
							
		        			if(loginControl.controllaUtente(userField.getText(), passwordField.getPassword())) {
		        				Utente utente = loginControl.getUtente(userField.getText());
		        				progressBar.setValue(20);
		        				//Thread.sleep(200); //test
		        				progressBar.setValue(50);
		        				Common.setUser(utente);
		        				progressBar.setValue(60);
		        				//Thread.sleep(200);//test
		        				progressBar.setValue(70);
		        				//pannello Desktop 1
		        				for (ILogInPanelListner c:logInListener_s){
		        					c.loginClicked();
		        				}
		        				progressBar.setValue(100);
		        				log.info("raised evento to " + logInListener_s.size() + " listeners...");
		        			}
						}
						
		        		catch(UserException u) {
		            		progressBar.setVisible(false);

		        			lblError.setVisible(true);
		        			lblError.setText(u.getMessage());
		        		} 						
						//}
					//}).start();
        			
        		
        	}
        });
		btnLogin.setBounds(105, 535, 274, 37);
		this.add(btnLogin);
		
		//LABEL LOGIN
		lblLogin = new JLabel("SmartApi");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setBounds(6, 312, 456, 37);
		this.add(lblLogin);
		
		//LABEL NEWACCOUNT
		lblNewAccount = new JLabel("Create an account");
		lblNewAccount.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				for (ILogInPanelListner c:logInListener_s){
					c.newAccountClicked();
				}
				log.info("raised evento to " + logInListener_s.size() + " listeners...");
			}
			public void mouseEntered(MouseEvent e) {
				e.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
		});
		lblNewAccount.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblNewAccount.setForeground(new Color(7, 201, 155));
		lblNewAccount.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewAccount.setBounds(199, 494, 177, 16);
		this.add(lblNewAccount);
		
		//LABEL ERROR
		lblError = new JLabel("");
		lblError.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblError.setHorizontalAlignment(SwingConstants.LEFT);
		lblError.setForeground(Color.RED);
		lblError.setBounds(100, 494, 120, 16);
		this.add(lblError);
		
		lblLogo = new JLabel("");
		lblLogo.setHorizontalAlignment(SwingConstants.TRAILING);
		lblLogo.setIcon(null);
		lblLogo.setBounds(138, 180, 177, 152);
		String path="res/logo.png";
		String pathIcon = getClass().getResource(path).getFile();
		MyImageIcon imgicon = new MyImageIcon(pathIcon,150,100);
		lblLogo.setIcon(imgicon.getImageResponsive());
		add(lblLogo);
		
//		progressBar = new JProgressBar();
//		progressBar.setVisible(false);
//		progressBar.setBounds(169, 584, 146, 20);
//		add(progressBar);
		
	   this.setVisible(true);
		

	}

	public void addLoginPanelListner(ILogInPanelListner c){
		logInListener_s.add(c);
		log.info("Added listener...");
	}
}
