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
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Rectangle;


public class LoginGrafica extends JPanel{
	private Logger log = Logger.getLogger("global");
	private JTextField userField;
	private JPasswordField passwordField;
	private JLabel lblUser;
	private JLabel lblPassword;
	private JLabel lblNewAccount;
	private static final Logger Log = Logger.getLogger( "InfoLogging" );
	private static SmartAPIModel model;
	private ArrayList<ILogInPanelListner> logInListener_s;
	private JLabel lblLogo;
	JLabel lblLogin;
	private JProgressBar progressBar;
	private JPanel panel_1;
	private JLabel label;
	private JLabel label_1;
	private JLabel lblerror;

	/**
	 * Initialize the contents of the frame.
	 */
	public LoginGrafica() {
		logInListener_s = new ArrayList<ILogInPanelListner>();
		model = new SmartAPIModel();
		this.setBackground(new Color(2, 94, 137));
		this.setBounds(100, 100, 606, 660);
		setLayout(new BorderLayout(0, 0));
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(2,94,137));
		add(panel_1);
		GridBagLayout gbl_panel_1 = new GridBagLayout();
		gbl_panel_1.columnWidths = new int[] {0, 0, 0, 0};
		gbl_panel_1.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
		gbl_panel_1.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0};
		gbl_panel_1.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_1.setLayout(gbl_panel_1);
						
								//LABEL LOGIN
								lblLogin = new JLabel("LOGIN");
								GridBagConstraints gbc_lblLogin = new GridBagConstraints();
								gbc_lblLogin.insets = new Insets(0, 0, 5, 5);
								gbc_lblLogin.gridx = 2;
								gbc_lblLogin.gridy = 0;
								panel_1.add(lblLogin, gbc_lblLogin);
								lblLogin.setHorizontalAlignment(SwingConstants.CENTER);
								lblLogin.setFont(new Font("Lucida Grande", Font.PLAIN, 30));
								lblLogin.setForeground(Color.WHITE);
						
						label = new JLabel("");
						GridBagConstraints gbc_label = new GridBagConstraints();
						gbc_label.weightx = 0.2;
						gbc_label.insets = new Insets(0, 0, 5, 5);
						gbc_label.gridx = 0;
						gbc_label.gridy = 4;
						panel_1.add(label, gbc_label);
				
						//LABEL USER
						lblUser = new JLabel("User");
						lblUser.setBounds(new Rectangle(0, 0, 100, 100));
						GridBagConstraints gbc_lblUser = new GridBagConstraints();
						gbc_lblUser.weightx = 0.1;
						gbc_lblUser.fill = GridBagConstraints.BOTH;
						gbc_lblUser.insets = new Insets(0, 0, 5, 0);
						gbc_lblUser.gridx = 1;
						gbc_lblUser.gridy = 4;
						panel_1.add(lblUser, gbc_lblUser);
						lblUser.setHorizontalAlignment(SwingConstants.CENTER);
						lblUser.setForeground(Color.WHITE);
						lblUser.setBackground(new Color(2, 66, 96));
						lblUser.setOpaque(true);
						
								//USER FIELD
								userField = new JTextField();
								GridBagConstraints gbc_userField = new GridBagConstraints();
								gbc_userField.weightx = 0.2;
								gbc_userField.fill = GridBagConstraints.BOTH;
								gbc_userField.insets = new Insets(0, 0, 5, 5);
								gbc_userField.gridx = 2;
								gbc_userField.gridy = 4;
								panel_1.add(userField, gbc_userField);
								userField.setText("amedeo");
								userField.setColumns(10);
										
										label_1 = new JLabel("");
										GridBagConstraints gbc_label_1 = new GridBagConstraints();
										gbc_label_1.weightx = 0.2;
										gbc_label_1.insets = new Insets(0, 0, 5, 0);
										gbc_label_1.gridx = 3;
										gbc_label_1.gridy = 4;
										panel_1.add(label_1, gbc_label_1);
								
										//LABEL PASSWORD
										lblPassword = new JLabel("Password");
										GridBagConstraints gbc_lblPassword = new GridBagConstraints();
										gbc_lblPassword.fill = GridBagConstraints.BOTH;
										gbc_lblPassword.insets = new Insets(0, 0, 5, 0);
										gbc_lblPassword.gridx = 1;
										gbc_lblPassword.gridy = 5;
										panel_1.add(lblPassword, gbc_lblPassword);
										lblPassword.setOpaque(true);
										lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
										lblPassword.setForeground(Color.WHITE);
										lblPassword.setBackground(new Color(2, 66, 96));
										
												//PASSWORD FIELD
												passwordField = new JPasswordField("amedeo");
												GridBagConstraints gbc_passwordField = new GridBagConstraints();
												gbc_passwordField.weightx = 0.1;
												gbc_passwordField.fill = GridBagConstraints.BOTH;
												gbc_passwordField.insets = new Insets(0, 0, 5, 5);
												gbc_passwordField.gridx = 2;
												gbc_passwordField.gridy = 5;
												panel_1.add(passwordField, gbc_passwordField);
														
														lblerror = new JLabel("");
														lblerror.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
														lblerror.setForeground(Color.RED);
														lblerror.setOpaque(true);
														GridBagConstraints gbc_lblerror = new GridBagConstraints();
														gbc_lblerror.fill = GridBagConstraints.BOTH;
														gbc_lblerror.insets = new Insets(0, 0, 5, 5);
														gbc_lblerror.gridx = 1;
														gbc_lblerror.gridy = 6;
														panel_1.add(lblerror, gbc_lblerror);
														lblerror.setBackground(new Color(2, 94, 137));
												
														//BUTTON LOGIN
														JButton btnLogin = new JButton("Login");
														GridBagConstraints gbc_btnLogin = new GridBagConstraints();
														gbc_btnLogin.fill = GridBagConstraints.BOTH;
														gbc_btnLogin.insets = new Insets(0, 0, 0, 5);
														gbc_btnLogin.gridx = 2;
														gbc_btnLogin.gridy = 7;
														panel_1.add(btnLogin, gbc_btnLogin);
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

																	lblerror.setVisible(true);
																	lblerror.setText(u.getMessage());
																} 		
															}
														});

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
