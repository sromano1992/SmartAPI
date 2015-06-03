package com.smartAPI.view;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.Vector;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import com.smartAPI.model.Common;
import com.smartAPI.model.SmartAPIModel;
import com.smartAPI.model.Utente;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ShowUsersInfo extends JPanel{

	private static Logger log = Logger.getLogger("global");
	public static JLabel lblImage, lblStar;
	private static int MAX_STARS = 10;
	public static JTextField userField;
	public static JTextField nameField;
	public static JTextField surnameField;
	public static JTextField emailField;
	private JLabel lblEmail;
	private JPanel panelStar;
	private JLabel lblUser;
	private JLabel lblName;
	private JLabel lblSurname;
	private ImageIcon blackstar;
	private String avatar="";//iniz. con avatar user
	private JTextField textFieldYes;
	private JTextField textFieldNo;
	private String username="";
	private boolean isAdmin =false;

	public ShowUsersInfo() {
		setLayout(null);
		setBackground(new Color(2, 94, 137));
		lblImage = new JLabel();
		//path dipende dall'avatar dell'utente
		String path= "res/nouser.png";
		String pathIcon = getClass().getResource(path).getFile();
		MyImageIcon imgicon = new MyImageIcon(pathIcon,80,70);
		lblImage.setIcon(imgicon.getImageResponsive());

		lblImage.setBounds(60, 29, 80, 70);
		add(lblImage);

		panelStar = new JPanel();
		panelStar.setBackground(new Color(2, 94, 137));
		panelStar.setLayout(new FlowLayout());
		panelStar.setBounds(57, 127, 130,70);
		add(panelStar);

		lblUser = new JLabel("User");
		lblUser.setOpaque(true);
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setForeground(Color.WHITE);
		lblUser.setBackground(new Color(2, 66, 96));
		lblUser.setBounds(282, 21, 95, 31);
		add(lblUser);

		userField = new JTextField();
		userField.setEditable(false);
		userField.setColumns(10);
		userField.setBackground(new Color(230, 230, 230));
		userField.setBounds(374, 18, 204, 37);
		add(userField);

		lblName = new JLabel("Name");
		lblName.setOpaque(true);
		lblName.setHorizontalAlignment(SwingConstants.CENTER);
		lblName.setForeground(Color.WHITE);
		lblName.setBackground(new Color(2, 66, 96));
		lblName.setBounds(282, 64, 95, 31);
		add(lblName);

		nameField = new JTextField();
		nameField.setEditable(false);
		nameField.setBackground(new Color(230, 230, 230));
		nameField.setColumns(10);
		nameField.setBounds(374, 60, 204, 38);
		nameField.addFocusListener(new FocusListener() {
			public void focusLost(FocusEvent e) {
				nameField.setBackground(Color.WHITE);

			}

			public void focusGained(FocusEvent e) {
				// TODO Auto-generated method stub

			}
		});
		add(nameField);

		lblSurname = new JLabel("Surname");
		lblSurname.setOpaque(true);
		lblSurname.setHorizontalAlignment(SwingConstants.CENTER);
		lblSurname.setForeground(Color.WHITE);
		lblSurname.setBackground(new Color(2, 66, 96));
		lblSurname.setBounds(282, 110, 95, 31);
		add(lblSurname);

		surnameField = new JTextField();
		surnameField.addFocusListener(new FocusListener() {

			public void focusLost(FocusEvent e) {
				surnameField.setBackground(Color.WHITE);
			}

			public void focusGained(FocusEvent e) {

			}
		});

		surnameField.setEditable(false);
		surnameField.setBackground(new Color(230, 230, 230));
		surnameField.setBounds(374, 106, 204, 37);
		add(surnameField);

		lblEmail = new JLabel("Email");
		lblEmail.setOpaque(true);
		lblEmail.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmail.setForeground(Color.WHITE);
		lblEmail.setBackground(new Color(2, 66, 96));
		lblEmail.setBounds(282, 153, 95, 31);
		add(lblEmail);

		emailField = new JTextField();
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
		emailField.setBounds(374, 149, 204, 37);
		add(emailField);

		//if(Common.UTENTE.isAdmin()){
			JLabel lblMakeAdmin = new JLabel("Make admin");
			lblMakeAdmin.setOpaque(true);
			lblMakeAdmin.setHorizontalAlignment(SwingConstants.CENTER);
			lblMakeAdmin.setForeground(Color.WHITE);
			lblMakeAdmin.setBackground(new Color(250, 172, 88));
			lblMakeAdmin.setBounds(282, 200, 95, 31);
			add(lblMakeAdmin);

			textFieldYes = new JTextField();
			Border border = BorderFactory.createLineBorder(new Color(250, 172, 88), 0);
			textFieldYes.setBorder(border);
			textFieldYes.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldYes.setEditable(false);
			textFieldYes.setBackground(new Color(230, 230, 230));
			textFieldYes.setBounds(378, 198, 97, 34);
			add(textFieldYes);

			textFieldNo = new JTextField();
			
			textFieldNo.setForeground(Color.BLACK);
			textFieldNo.setBorder(border);
			textFieldNo.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldNo.setEditable(false);
			textFieldNo.setBackground(new Color(230, 230, 230));
			textFieldNo.setBounds(475, 198, 97, 34);
			add(textFieldNo);
		//}

		blackstar=new ImageIcon();
		String blackpath = "res/grey_star.png";
		String blackpathIcon = getClass().getResource(blackpath).getFile();
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
		
		//JOptionPane.showMessageDialog(null, "User: "+u.getNickname(), "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);

		if(isAdmin){
			//JOptionPane.showMessageDialog(null, "User: "+u.getNickname()+" is admin", "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);

			
				textFieldYes.setBackground(Color.ORANGE);
				textFieldNo.setBackground(Color.ORANGE);
			textFieldYes.setText(u.getNickname());
			textFieldNo.setText("is Admin");
		}
		else{
			//JOptionPane.showMessageDialog(null, "User: "+u.getNickname()+" not is admin", "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);

			textFieldYes.setText("YES");
			textFieldYes.setEditable(false);
			textFieldYes.setBackground(new Color(230, 230, 230));
			textFieldNo.setText("NO");
			textFieldNo.setHorizontalAlignment(SwingConstants.CENTER);
			textFieldNo.setEditable(false);
			textFieldNo.setBackground(Color.red);
			
		    textFieldYes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				textFieldNo.setForeground(Color.BLACK);
				textFieldYes.setBackground(Color.GREEN);
				textFieldNo.setBackground(new Color(230, 230, 230));
				SmartAPIModel m = new SmartAPIModel();
				m.modificaPermessiUtente( username, true);
				
				
				//JOptionPane.showMessageDialog(null, "User: "+username+"now is admin", "InfoBox: " , JOptionPane.INFORMATION_MESSAGE);
				textFieldYes.setBackground(Color.GREEN);
				textFieldNo.setBackground(Color.GREEN);
				textFieldYes.setText(username);
				textFieldNo.setText("is Admin");
			}
		});
		
		textFieldNo.addMouseListener(new MouseAdapter() {
			@Override
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
		
		panelStar.removeAll();
		String path=u.getAvatar();
		String pathIcon = getClass().getResource(path).getFile();
		MyImageIcon imgicon = new MyImageIcon(pathIcon,80,70);
		lblImage.setIcon(imgicon.getImageResponsive());
		userField.setText(u.getNickname());

		nameField.setText(u.getNome());
		surnameField.setText(u.getCognome());
		emailField.setText(u.getEmail());

		ImageIcon star=new ImageIcon();
		path="res/star.png";
		pathIcon = getClass().getResource(path).getFile();
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
	}
}

