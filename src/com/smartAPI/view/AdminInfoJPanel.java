package com.smartAPI.view;

import java.awt.Color;
import java.awt.Cursor;

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
import java.util.ArrayList;
import java.util.Vector;
import java.util.logging.Logger;

import javax.swing.JComboBox;
import javax.swing.ComboBoxModel;

import com.smartAPI.control.IUserOptionListener;
import com.smartAPI.control.IUserPanelListener;
import com.smartAPI.model.Common;
import com.smartAPI.model.SmartAPIModel;
import com.smartAPI.model.UserException;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AdminInfoJPanel extends JPanel {
	private ArrayList<IUserPanelListener> listener_s;
	private static Logger log = Logger.getLogger("global");
	JLabel lblImage;
	JLabel lblError;
	//private static int SCORE = 10;
	private JTextField userField;
	private JPasswordField passwordField;
	private JTextField nameField;
	private JTextField surnameField;
	private JTextField emailField;
	private final JComboBox comboBox;
	private JButton btnSave;
	private String avatar=Common.UTENTE.getAvatar();//iniz. con avatar user

	public AdminInfoJPanel() {
		setLayout(null);
		setBackground(new Color(228, 230, 235));

		lblImage = new JLabel("");
		//path dipende dall'avatar dell'utente
		String path=Common.UTENTE.getAvatar();
		System.out.println(path);
		String pathIcon = getClass().getResource(path).getFile();
		MyImageIcon imgicon = new MyImageIcon(pathIcon,80,70);
		lblImage.setIcon(imgicon.getImageResponsive());

		lblImage.setBounds(155, 97, 80, 71);
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
		btnModify.setBounds(313, 45, 26, 29);
		path="res/pencil.png";
		pathIcon = getClass().getResource(path).getFile();
		imgicon = new MyImageIcon(pathIcon,20,20);
		btnModify.setIcon(imgicon.getImageResponsive());
		add(btnModify);

		Vector comboBoxItems=new Vector();
		comboBoxItems.add("admin - 1");
		comboBoxItems.add("admin - 2");

		final DefaultComboBoxModel model = new DefaultComboBoxModel(comboBoxItems);

		JLabel lblAdminInfo = new JLabel("ADMIN INFO");
		lblAdminInfo.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblAdminInfo.setOpaque(true);
		lblAdminInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminInfo.setForeground(Color.YELLOW);
		lblAdminInfo.setBackground(new Color(151, 121, 102));
		lblAdminInfo.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdminInfo.setBounds(32, 35, 335, 50);
		add(lblAdminInfo);

		JPanel panel = new JPanel();
		panel.setBounds(32, 180, 335, 509);
		panel.setBackground(new Color(250, 172, 88));

		add(panel);
		panel.setLayout(null);
		comboBox = new JComboBox(model);
		comboBox.setBounds(107, 6, 118, 31);
		panel.add(comboBox);

		JLabel lblUser = new JLabel("User");
		lblUser.setBounds(25, 64, 75, 31);
		panel.add(lblUser);
		lblUser.setOpaque(true);
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setForeground(Color.WHITE);
		lblUser.setBackground(new Color(180, 95, 4));

		userField = new JTextField(Common.UTENTE.getNickname());
		userField.setBounds(97, 61, 208, 37);
		panel.add(userField);
		userField.setEditable(false);
		userField.setColumns(10);
		userField.setBackground(new Color(230, 230, 230));

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(25, 95, 75, 31);
		panel.add(lblPassword);
		lblPassword.setOpaque(true);
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setBackground(new Color(180, 95, 4));

		passwordField = new JPasswordField(Common.UTENTE.getPassword());
		passwordField.setBounds(97, 92, 208, 37);
		panel.add(passwordField);
		passwordField.setEditable(false);
		passwordField.setBackground(new Color(230, 230, 230));

		JLabel lblPersonalData = new JLabel("Personal Data");
		lblPersonalData.setBounds(0, 188, 335, 37);
		panel.add(lblPersonalData);
		lblPersonalData.setOpaque(true);
		lblPersonalData.setHorizontalAlignment(SwingConstants.CENTER);
		lblPersonalData.setForeground(Color.YELLOW);
		lblPersonalData.setFont(new Font("Lucida Grande", Font.PLAIN, 20));
		lblPersonalData.setBackground(new Color(151, 121, 102));

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(25, 286, 75, 31);
		panel.add(lblName);
		lblName.setOpaque(true);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setForeground(Color.WHITE);
		lblName.setBackground(new Color(180, 95, 4));

		nameField = new JTextField(Common.UTENTE.getNome());
		nameField.setBounds(97, 283, 208, 37);
		panel.add(nameField);
		nameField.setEditable(false);
		nameField.setBackground(new Color(230, 230, 230));
		nameField.setColumns(10);

		JLabel lblSurname = new JLabel("Surname");
		lblSurname.setBounds(25, 316, 75, 31);
		panel.add(lblSurname);
		lblSurname.setOpaque(true);
		lblSurname.setHorizontalAlignment(SwingConstants.CENTER);
		lblSurname.setForeground(Color.WHITE);
		lblSurname.setBackground(new Color(180, 95, 4));

		surnameField = new JTextField(Common.UTENTE.getCognome());
		surnameField.setBounds(97, 313, 208, 37);
		panel.add(surnameField);
		surnameField.setEditable(false);
		surnameField.setBackground(new Color(230, 230, 230));

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(25, 346, 75, 31);
		panel.add(lblEmail);
		lblEmail.setOpaque(true);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBackground(new Color(180, 95, 4));

		emailField = new JTextField(Common.UTENTE.getEmail());
		emailField.setBounds(97, 343, 208, 37);
		panel.add(emailField);
		emailField.setEditable(false);
		emailField.setBackground(new Color(230, 230, 230));

		btnSave = new JButton("Save");
		btnSave.setVisible(false);
		btnSave.setBounds(75, 428, 181, 29);
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String nick = Common.UTENTE.getNickname();
				SmartAPIModel m = new SmartAPIModel();

				System.out.println("Passw: "+passwordField.getText());
				System.out.println("Name: "+nameField.getText());
				System.out.println("Surname: "+surnameField.getText());
				System.out.println("Email: "+emailField.getText());
				System.out.println("Avatar: "+avatar);

				try{
					m.modificaUtente(nick, passwordField.getText(), nameField.getText(), surnameField.getText(), emailField.getText(), avatar);		
					comboBox.setVisible(false);
					passwordField.setBackground(new Color(230, 230, 230));
					passwordField.setEditable(false);
					nameField.setBackground(new Color(230, 230, 230));
					nameField.setEditable(false);
					surnameField.setBackground(new Color(230, 230, 230));
					surnameField.setEditable(false);
					emailField.setBackground(new Color(230, 230, 230));
					emailField.setEditable(false);
					btnSave.setVisible(false);
					lblError.setVisible(false);

				}catch (UserException e1){
					lblError.setText(e1.getMessage());
					lblError.setVisible(true);
					btnSave.setVisible(true);
				}
			}
		});
		panel.add(btnSave);

		JButton btnLogout = new JButton("Logout");
		btnLogout.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				e.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			}
			public void mouseClicked(MouseEvent e) {				
				for (IUserPanelListener i:listener_s){
					i.logOutClicked();
				}
				log.info("LOGOUT");
			}

		});
		btnLogout.setBounds(75, 453, 181, 29);
		panel.add(btnLogout);

		lblError = new JLabel("");
		lblError.setVisible(false);
		lblError.setHorizontalAlignment(SwingConstants.LEFT);
		lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		lblError.setBounds(25, 389, 197, 16);
		panel.add(lblError);


		comboBox.setVisible(false);
		comboBox.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String s=(String)comboBox.getSelectedItem();
				String[]parts = s.split(" - ");
				String path="res/admin-"+parts[1]+".png";
				avatar=path;
				String pathIcon = getClass().getResource(path).getFile();				
				MyImageIcon imgicon = new MyImageIcon(pathIcon,80,70);
				lblImage.setIcon(imgicon.getImageResponsive());
			}
		});

		//		JPanel panelStar = new JPanel();
		//		panelStar.setBounds(212, 107, 127, 50);
		//		add(panelStar);
		//		panelStar.setBackground(new Color(228, 230, 235));
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
		//		for (int i=0; i<SCORE; i++){
		//			panelStar.add(new JLabel(star));
		//	    }

	}
	
	public void addUserInfoJPanelListener(IUserPanelListener toAdd){
		if (listener_s == null){
			listener_s = new ArrayList<IUserPanelListener>();
		}
		listener_s.add(toAdd);
		log.info("New IuserPanelListener added");
	}
}
