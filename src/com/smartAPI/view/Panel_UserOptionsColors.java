package com.smartAPI.view;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * Pannello che mostra all'utente le operazioni che può effettuare
 * @author iolrin
 *
 */
public class Panel_UserOptionsColors extends JPanel {

	JLabel lblSearch;
	JLabel lblInsert;
	JLabel lblShowUsers;
	private JLabel lblNewLabel;
	public Panel_UserOptionsColors() {
		setBackground(new Color(228, 230, 235));
		setLayout(null);
		
		 lblSearch = new JLabel(" Search");
		 lblSearch.setHorizontalAlignment(SwingConstants.CENTER);
		lblSearch.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseEntered(MouseEvent e) {
				e.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
 				lblSearch.setOpaque(true);
 				lblSearch.setForeground(Color.YELLOW);
 				lblSearch.setBackground(new Color(27, 147, 225));
			}
			@Override
			public void mouseExited(MouseEvent e) {
				lblSearch.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
				lblSearch.setOpaque(true);
				lblSearch.setForeground(Color.WHITE);
				lblSearch.setBackground(new Color(230, 126, 34));
			}
		});
		lblSearch.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblSearch.setOpaque(true);
		lblSearch.setForeground(Color.WHITE);
		lblSearch.setBackground(new Color(230, 126, 34));
		lblSearch.setBounds(19, 28, 170, 50);
		
		String path="res/search.png";
		String pathIcon = getClass().getResource(path).getFile();
		MyImageIcon imgicon = new MyImageIcon(pathIcon,45,30);
		lblSearch.setIcon(imgicon.getImageResponsive());
		
		add(lblSearch);
		
		lblInsert = new JLabel(" Insert");
		lblInsert.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				e.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
 				lblInsert.setOpaque(true);
 				lblInsert.setForeground(Color.YELLOW);
 				lblInsert.setBackground(new Color(27, 147, 225));
			}
			public void mouseExited(MouseEvent e) {
				lblInsert.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
				lblInsert.setOpaque(true);
				lblInsert.setForeground(Color.WHITE);
				lblInsert.setBackground(new Color(231, 76, 60));
			}
		});
		
		
		lblInsert.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblInsert.setOpaque(true);
		lblInsert.setForeground(Color.WHITE);
		lblInsert.setBackground(new Color(231, 76, 60));
		lblInsert.setHorizontalAlignment(SwingConstants.CENTER);
		lblInsert.setBounds(190, 28, 170, 50);
		path="res/insert.png";
		pathIcon = getClass().getResource(path).getFile();
		imgicon = new MyImageIcon(pathIcon,35,35);
		lblInsert.setIcon(imgicon.getImageResponsive());
		add(lblInsert);
		
		lblShowUsers = new JLabel(" Show users");
		lblShowUsers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				e.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
				lblShowUsers.setOpaque(true);
				lblShowUsers.setForeground(Color.YELLOW);
				lblShowUsers.setBackground(new Color(27, 147, 225));
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				lblShowUsers.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
				lblShowUsers.setOpaque(true);
				lblShowUsers.setForeground(Color.WHITE);
				lblShowUsers.setBackground(new Color(106, 183, 127));
			}
		});
		lblShowUsers.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblShowUsers.setOpaque(true);
		lblShowUsers.setForeground(Color.WHITE);
		lblShowUsers.setBackground(new Color(106, 183, 127));
		lblShowUsers.setHorizontalAlignment(SwingConstants.CENTER);		
		lblShowUsers.setBounds(361, 28, 170, 50);
		path="res/show.png";
		pathIcon = getClass().getResource(path).getFile();
		imgicon = new MyImageIcon(pathIcon,43,43);
		lblShowUsers.setIcon(imgicon.getImageResponsive());
		add(lblShowUsers);
		
		JLabel lblAbout = new JLabel(" About");
		lblAbout.setOpaque(true);
		lblAbout.setHorizontalAlignment(SwingConstants.CENTER);
		lblAbout.setForeground(Color.WHITE);
		lblAbout.setFont(new Font("Lucida Grande", Font.PLAIN, 22));
		lblAbout.setBackground(new Color(138, 246, 113));
		lblAbout.setBounds(532, 28, 170, 50);
		path="res/friends.png";
		pathIcon = getClass().getResource(path).getFile();
		imgicon = new MyImageIcon(pathIcon,40,40);
		lblAbout.setIcon(imgicon.getImageResponsive());
		add(lblAbout);
		
		

	}
}
