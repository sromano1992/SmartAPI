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
	private static SmartAPIModel model;
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
		this.setBounds(100, 100, 606, 660);
		this.setLayout(null);

		//USER FIELD
		userField = new JTextField();
		userField.setText("amedeo");
		userField.setBounds(138, 427, 282, 52);
		this.add(userField);
		userField.setColumns(10);

		//PASSWORD FIELD
		passwordField = new JPasswordField("amedeo");
		passwordField.setBounds(138, 472, 282, 52);
		this.add(passwordField);

		//LABEL USER
		lblUser = new JLabel("User");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setForeground(Color.WHITE);
		lblUser.setBackground(new Color(2, 66, 96));
		lblUser.setOpaque(true);
		lblUser.setBounds(63, 430, 79, 45);
		this.add(lblUser);

		//LABEL PASSWORD
		lblPassword = new JLabel("Password");
		lblPassword.setOpaque(true);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBackground(new Color(2, 66, 96));
		lblPassword.setBounds(63, 475, 79, 45);
		this.add(lblPassword);

		//BUTTON LOGIN
		JButton btnLogin = new JButton("Login");
		btnLogin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				try {
					LoginControl loginControl = new LoginControl(model);

					if(loginControl.controllaUtente(userField.getText(), passwordField.getPassword())) {
						Utente utente = loginControl.getUtente(userField.getText());
						Common.setUser(utente);
						for (ILogInPanelListner c:logInListener_s){
							c.loginClicked();
						}
						log.info("raised evento to " + logInListener_s.size() + " listeners...");
					}
				}

				catch(UserException u) {

					lblError.setVisible(true);
					lblError.setText(u.getMessage());
				} 		
			}
		});
		btnLogin.setBounds(106, 578, 274, 37);
		this.add(btnLogin);

		//LABEL LOGIN
		lblLogin = new JLabel("LOGIN");
		lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
		lblLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
		lblLogin.setForeground(Color.WHITE);
		lblLogin.setBounds(94, 340, 274, 37);
		this.add(lblLogin);

		//LABEL NEWACCOUNT
//		lblNewAccount = new JLabel("Create an account");
//		lblNewAccount.addMouseListener(new MouseAdapter() {
//			public void mouseClicked(MouseEvent e) {
//				for (ILogInPanelListner c:logInListener_s){
//					c.newAccountClicked();
//				}
//				log.info("raised evento to " + logInListener_s.size() + " listeners...");
//			}
//			public void mouseEntered(MouseEvent e) {
//				e.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
//			}
//		});
//		lblNewAccount.setFont(new Font("Lucida Grande", Font.BOLD, 13));
//		lblNewAccount.setForeground(new Color(7, 201, 155));
//		lblNewAccount.setHorizontalAlignment(SwingConstants.RIGHT);
//		lblNewAccount.setBounds(215, 526, 177, 16);
//		this.add(lblNewAccount);

		//LABEL ERROR
		lblError = new JLabel("");
		lblError.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblError.setHorizontalAlignment(SwingConstants.LEFT);
		lblError.setForeground(Color.RED);
		lblError.setBounds(63, 526, 197, 16);
		this.add(lblError);

		//lblLogo = new JLabel("");
		//lblLogo.setHorizontalAlignment(SwingConstants.TRAILING);
		//lblLogo.setIcon(null);
		//lblLogo.setBounds (113, 35, 231, 173);
		//String path="res/logo.gif";
		//String pathIcon = getClass().getResource(path).getFile();
		//MyImageIcon imgicon = new MyImageIcon(pathIcon,200,150);
		//lblLogo.setIcon(imgicon.getImageResponsive());
		//ImageIcon ii = new ImageIcon(this.getClass().getResource(
        //        "res/logo.gif"));
		//lblLogo.setIcon(ii);
		//add(lblLogo);


		this.setVisible(true);


	}

	public void addLoginPanelListner(ILogInPanelListner c){
		logInListener_s.add(c);
		log.info("Added listener...");
	}
	
	public static SmartAPIModel getModel() {
		return model;
	}
}
