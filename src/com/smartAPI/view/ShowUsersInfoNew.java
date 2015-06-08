package com.smartAPI.view;

import javax.swing.JPanel;

import java.awt.GridBagLayout;

import javax.swing.JLabel;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;

import com.smartAPI.model.Common;
import com.smartAPI.model.SmartAPIModel;
import com.smartAPI.model.Utente;

import java.awt.Rectangle;
import java.awt.GridLayout;

public class ShowUsersInfoNew extends JPanel {
	public static JLabel lblImage, lblStar;
	private static int MAX_STARS = 10;
	public static JTextField userField;
	public static JTextField nameField;
	public static JTextField surnameField;
	public static JTextField emailField;
	private JPanel panelStar, panelAdm;
	private JLabel lblEmail;
	private JLabel lblUser;
	private JLabel lblName;
	private JLabel lblSurname;
	private ImageIcon blackstar;
	private String avatar="";//iniz. con avatar user
	private String username="";
	private boolean isAdmin = false;
	private JLabel lblMakeAdmin;
	private JTextField textFieldYes;
	private JTextField textFieldNo;

	/**
	 * Create the panel.
	 */
	public ShowUsersInfoNew() {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0, 100, 0, 0, 0, 0, 0, 0, 0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0, 0, 0, 100, 0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 1.0, 0.0, 0.0, 0.0, 1.0, 0.0, 1.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 1.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		setBackground(new Color(2, 94, 137));
		
		
		
		panelStar = new JPanel();
		panelStar.setBackground(new Color(2, 94, 137));
		GridBagConstraints gbc_panelStar = new GridBagConstraints();
		//gbc_panelStar.insets = new Insets(0, 0, 0, 0);
		gbc_panelStar.fill = GridBagConstraints.CENTER;
		gbc_panelStar.gridx = 2;
		gbc_panelStar.gridy = 4;
		add(panelStar, gbc_panelStar);
		panelStar.setLayout(new GridLayout(2, 5, 0, 0));
		
		
		
		lblImage = new JLabel();
		//path dipende dall'avatar dell'utente
		String pathIcon= "res/nouser.png";
		MyImageIcon imgicon = new MyImageIcon(pathIcon,80,70);
		lblImage.setIcon(imgicon.getImageResponsive());
		
		GridBagConstraints gbc_lblImage = new GridBagConstraints();
		gbc_lblImage.insets = new Insets(0, 0, 5, 5);
		gbc_lblImage.gridx = 2;
		gbc_lblImage.gridy = 1;
		add(lblImage, gbc_lblImage);
		
		
		lblUser = new JLabel("User");
		GridBagConstraints gbc_lblUser = new GridBagConstraints();
		gbc_lblUser.anchor = GridBagConstraints.EAST;
		gbc_lblUser.insets = new Insets(0, 0, 5, 5);
		gbc_lblUser.gridx = 5;
		gbc_lblUser.gridy = 2;
		lblUser.setOpaque(true);
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setForeground(Color.WHITE);
		lblUser.setBackground(new Color(2, 66, 96));
		add(lblUser, gbc_lblUser);
		
		userField = new JTextField();
		GridBagConstraints gbc_userField = new GridBagConstraints();
		gbc_userField.insets = new Insets(0, 0, 5, 5);
		gbc_userField.fill = GridBagConstraints.HORIZONTAL;
		gbc_userField.gridx = 6;
		gbc_userField.gridy = 2;
		add(userField, gbc_userField);
		userField.setColumns(10);
		userField.setEditable(false);
		userField.setBackground(new Color(230, 230, 230));
		
		lblName = new JLabel("Name");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.gridx = 5;
		gbc_lblName.gridy = 3;
		lblName.setOpaque(true);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setForeground(Color.WHITE);
		lblName.setBackground(new Color(2, 66, 96));
		add(lblName, gbc_lblName);
		
		nameField = new JTextField();
		GridBagConstraints gbc_nameField = new GridBagConstraints();
		gbc_nameField.insets = new Insets(0, 0, 5, 5);
		gbc_nameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_nameField.gridx = 6;
		gbc_nameField.gridy = 3;
		add(nameField, gbc_nameField);
		nameField.setEditable(false);
		nameField.setBackground(new Color(230, 230, 230));
		nameField.setColumns(10);
		nameField.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				nameField.setBackground(Color.WHITE);

			}
			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});
		
		lblSurname = new JLabel("Surname");
		GridBagConstraints gbc_lblSurname = new GridBagConstraints();
		gbc_lblSurname.anchor = GridBagConstraints.EAST;
		gbc_lblSurname.insets = new Insets(0, 0, 5, 5);
		gbc_lblSurname.gridx = 5;
		gbc_lblSurname.gridy = 4;
		lblSurname.setOpaque(true);
		lblSurname.setHorizontalAlignment(SwingConstants.CENTER);
		lblSurname.setForeground(Color.WHITE);
		lblSurname.setBackground(new Color(2, 66, 96));
		add(lblSurname, gbc_lblSurname);
		
		surnameField = new JTextField();
		GridBagConstraints gbc_surnameField = new GridBagConstraints();
		gbc_surnameField.insets = new Insets(0, 0, 5, 5);
		gbc_surnameField.fill = GridBagConstraints.HORIZONTAL;
		gbc_surnameField.gridx = 6;
		gbc_surnameField.gridy = 4;
		add(surnameField, gbc_surnameField);
		surnameField.setColumns(10);
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
		GridBagConstraints gbc_lblEmail = new GridBagConstraints();
		gbc_lblEmail.anchor = GridBagConstraints.EAST;
		gbc_lblEmail.insets = new Insets(0, 0, 5, 5);
		gbc_lblEmail.gridx = 5;
		gbc_lblEmail.gridy = 5;
		lblEmail.setOpaque(true);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBackground(new Color(2, 66, 96));
		add(lblEmail, gbc_lblEmail);
		
		emailField = new JTextField();
		GridBagConstraints gbc_emailField = new GridBagConstraints();
		gbc_emailField.insets = new Insets(0, 0, 5, 5);
		gbc_emailField.fill = GridBagConstraints.HORIZONTAL;
		gbc_emailField.gridx = 6;
		gbc_emailField.gridy = 5;
		add(emailField, gbc_emailField);
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
		emailField.setColumns(10);
		
	if(Common.UTENTE.isAdmin()){	
		
		
		panelAdm = new JPanel();
		panelAdm.setBackground(new Color(2, 94, 137));
		GridBagConstraints gbc_panelAdm = new GridBagConstraints();
		//gbc_panelStar.insets = new Insets(0, 0, 0, 0);
		gbc_panelAdm.fill = GridBagConstraints.BOTH;
		gbc_panelAdm.gridx = 6;
		gbc_panelAdm.gridy = 6;
		add(panelAdm, gbc_panelAdm);
		
		
		lblMakeAdmin = new JLabel(" Make Admin ");
		GridBagConstraints gbc_lblMakeAdmin = new GridBagConstraints();
		gbc_lblMakeAdmin.anchor = GridBagConstraints.EAST;
		gbc_lblMakeAdmin.insets = new Insets(0, 0, 5, 5);
		gbc_lblMakeAdmin.gridx = 0;
		gbc_lblMakeAdmin.gridy = 1;
		lblMakeAdmin.setOpaque(true);
		lblMakeAdmin.setHorizontalAlignment(SwingConstants.CENTER);
		lblMakeAdmin.setForeground(Color.WHITE);
		lblMakeAdmin.setBackground(new Color(250, 172, 88));
		panelAdm.add(lblMakeAdmin, gbc_lblMakeAdmin);
		
		textFieldYes = new JTextField();
		GridBagConstraints gbc_textFieldYes = new GridBagConstraints();
		gbc_textFieldYes.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldYes.fill = GridBagConstraints.VERTICAL;
		gbc_textFieldYes.gridx = 1;
		gbc_textFieldYes.gridy = 1;
		panelAdm.add(textFieldYes, gbc_textFieldYes);
		Border border = BorderFactory.createLineBorder(new Color(250, 172, 88), 0);
		textFieldYes.setBorder(border);
		textFieldYes.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldYes.setEditable(false);
		textFieldYes.setBackground(new Color(230, 230, 230));

		
		textFieldNo = new JTextField();
		GridBagConstraints gbc_textFieldNo = new GridBagConstraints();
		gbc_textFieldNo.insets = new Insets(0, 0, 5, 5);
		gbc_textFieldNo.fill = GridBagConstraints.VERTICAL;
		gbc_textFieldNo.gridx = 2;
		gbc_textFieldNo.gridy = 1;
		
		textFieldNo.setForeground(Color.BLACK);
		textFieldNo.setBorder(border);
		textFieldNo.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldNo.setEditable(false);
		textFieldNo.setBackground(new Color(230, 230, 230));
		panelAdm.add(textFieldNo, gbc_textFieldNo);
		
	}
	
	blackstar=new ImageIcon();
	String blackpathIcon = "res/grey_star.png";
	MyImageIcon blackimgicon = new MyImageIcon(blackpathIcon,20,20);
	blackstar=blackimgicon.getImageResponsive();

	
	for (int i=0; i<MAX_STARS; i++){
		panelStar.add(new JLabel(blackstar));
	}
	panelStar.setVisible(true);
	
	}
	
	
	
	
	public void setUser(Utente u) {
		  username = u.getNickname();
		  isAdmin = u.isAdmin();
		if(isAdmin){
			if(Common.UTENTE.isAdmin()){
				textFieldYes.setBackground(Color.ORANGE);
				textFieldNo.setBackground(Color.ORANGE);
			textFieldYes.setText(" "+u.getNickname()+" ");
			textFieldNo.setText(" is Admin ");
			}
		}
		else{
			if(Common.UTENTE.isAdmin()){
			textFieldYes.setText(" YES ");
			textFieldYes.setEditable(false);
			textFieldYes.setBackground(new Color(230, 230, 230));
			textFieldNo.setText(" NO ");
			textFieldNo.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldNo.setEditable(false);
			textFieldNo.setBackground(Color.red);

			
		    textFieldYes.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				textFieldNo.setForeground(Color.BLACK);
				textFieldYes.setBackground(Color.GREEN);
				textFieldNo.setBackground(new Color(230, 230, 230));
				SmartAPIModel m = new SmartAPIModel();
				m.modificaPermessiUtente( username, true);
				textFieldYes.setBackground(Color.GREEN);
				textFieldNo.setBackground(Color.GREEN);
				textFieldYes.setText(" "+username+" ");
				textFieldNo.setText(" is Admin ");
			}
		});
		
		textFieldNo.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				textFieldNo.setForeground(Color.BLACK);
				textFieldNo.setBackground(Color.red);
				textFieldYes.setBackground(new Color(230, 230, 230));
				if (isAdmin){
					textFieldYes.setBackground(Color.ORANGE);
					textFieldNo.setBackground(Color.ORANGE);
				}
			}
		});
			}
		}
		
		panelStar.removeAll();
		String pathIcon=u.getAvatar();
		MyImageIcon imgicon = new MyImageIcon(pathIcon,80,70);
		lblImage.setIcon(imgicon.getImageResponsive());
		userField.setText(u.getNickname());

		nameField.setText(u.getNome());
		surnameField.setText(u.getCognome());
		emailField.setText(u.getEmail());

		ImageIcon star=new ImageIcon();
		pathIcon="res/star.png";
		imgicon = new MyImageIcon(pathIcon,20,20);
		star=imgicon.getImageResponsive();


		int numStelle = LoginGrafica.getModel().cambiaStelle(userField.getText());
		int blackStars = 10 - numStelle;
		for (int i=0; i<numStelle; i++){
			panelStar.add(new JLabel(star));
		}

		for (int i=0; i<blackStars; i++){
			panelStar.add(new JLabel(blackstar));
		}
		panelStar.setVisible(true);
		SwingUtilities.updateComponentTreeUI(this);
	}

}
