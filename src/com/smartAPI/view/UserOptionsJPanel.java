package com.smartAPI.view;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.SwingConstants;









import com.smartAPI.control.IUserOptionListener;
import com.smartAPI.model.Common;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

/**
 * Pannello che mostra all'utente le operazioni che può effettuare
 * @author iolrin
 *
 */
public class UserOptionsJPanel extends JPanel {
	private ArrayList<IUserOptionListener> listener_s;
	private static Logger log = Logger.getLogger("global");
	JLabel lblSearch;
	JLabel lblInsert;
	JLabel lblShowUsers;
	private JLabel lblNewLabel;
	private JButton btnSearch;
	String path="";
	String pathIcon = "";
	MyImageIcon imgicon = null;
	private JButton btnInsert;
	private JButton btnShow;
	private JButton btnAbout;
	private JButton btnUserInfo;
	
	public UserOptionsJPanel() {
		setBackground(new Color(228, 230, 235));
		setLayout(new GridLayout(1, 4));
				
				
		
		
		btnSearch = new JButton("");
		btnSearch.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				e.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			}
			
			
			public void mouseClicked(MouseEvent e) {
				
				for (IUserOptionListener i:listener_s){
					i.searchClicked();
				}
				log.info("search event raised");
					
			}

		});
		path="res/search.png";
		btnSearch.setIcon(new ImageIcon(this.getClass().getResource(path)));
		btnSearch.setBounds(214, 28, 200, 52);
		btnSearch.setBorderPainted(false);
		btnSearch.setFocusPainted(false);
		btnSearch.setContentAreaFilled(false);
		
		add(btnSearch);
		
		btnInsert = new JButton("");

		btnInsert.setBorderPainted(false);
		btnInsert.setFocusPainted(false);
		btnInsert.setContentAreaFilled(false);
		btnInsert.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnInsert.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				e.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			}
			public void mouseClicked(MouseEvent e) {
				
				for (IUserOptionListener i:listener_s){
					i.insertClicked();
				}
				log.info("insert event raised");
			}

		});
		path="res/insert.png";
		btnInsert.setIcon(new ImageIcon(this.getClass().getResource(path)));
		btnInsert.setBounds(11, 28, 200, 51);
		add(btnInsert);
		
		btnShow = new JButton("");

		btnShow.setBorderPainted(false);
		btnShow.setFocusPainted(false);
		btnShow.setContentAreaFilled(false);
		btnShow.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				e.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			}
			public void mouseClicked(MouseEvent e) {
				
				for (IUserOptionListener i:listener_s){
					i.showUserClicked();
				}
				log.info("show user raised");
			}

		});
		path="res/show.png";
		btnShow.setIcon(new ImageIcon(this.getClass().getResource(path)));
		btnShow.setBounds(417, 28, 200, 51);
		
		add(btnShow);
		
		btnAbout = new JButton("");
		btnAbout.setBorderPainted(false);
		btnAbout.setFocusPainted(false);
		btnAbout.setContentAreaFilled(false);
		btnAbout.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				e.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			}
			public void mouseClicked(MouseEvent e) {
				
				for (IUserOptionListener i:listener_s){
					i.aboutClicked();
				}
				log.info("about event raised");
			}

		});
		path="res/about.png";
		btnAbout.setIcon(new ImageIcon(this.getClass().getResource(path)));
		btnAbout.setBounds(621, 28, 200, 51);
		add(btnAbout);
		
		btnUserInfo = new JButton("");
		btnUserInfo.setBackground(Color.WHITE);
		btnUserInfo.setHorizontalAlignment(SwingConstants.RIGHT);
		btnUserInfo.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		
		pathIcon = Common.UTENTE.getAvatar();
		MyImageIcon imgicon = new MyImageIcon(pathIcon, 30, 30);
		btnUserInfo.setIcon(imgicon.getImageResponsive());
		btnUserInfo.setFocusPainted(false);
		btnUserInfo.setText("Benvenuto, "+Common.UTENTE.getNome());
		btnUserInfo.setContentAreaFilled(false);
		btnUserInfo.setBorderPainted(false);
		btnUserInfo.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				e.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

			}
			public void mouseClicked(MouseEvent e) {
				
				for (IUserOptionListener i:listener_s){
					i.userInfoClicked();
				}
				log.info("user info");
			}

		});
		add(btnUserInfo);
		
		
	}
	
	public void addListener(IUserOptionListener i){
		if (listener_s == null){
			listener_s = new ArrayList<IUserOptionListener>();
		}
		listener_s.add(i);

	}
}
