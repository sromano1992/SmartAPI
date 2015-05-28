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




import com.smartAPI.control.IUserOptionListener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.swing.ImageIcon;

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
		pathIcon = getClass().getResource(path).getFile();
		btnSearch.setIcon(new ImageIcon(pathIcon));
		btnSearch.setBounds(214, 28, 200, 52);
		
		add(btnSearch);
		
		btnInsert = new JButton("");
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
		pathIcon = getClass().getResource(path).getFile();
		btnInsert.setIcon(new ImageIcon(pathIcon));
		btnInsert.setBounds(11, 28, 200, 51);
		add(btnInsert);
		
		btnShow = new JButton("");
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
		pathIcon = getClass().getResource(path).getFile();
		btnShow.setIcon(new ImageIcon(pathIcon));
		btnShow.setBounds(417, 28, 200, 51);
		add(btnShow);
		
		btnAbout = new JButton("");
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
		pathIcon = getClass().getResource(path).getFile();
		btnAbout.setIcon(new ImageIcon(pathIcon));
		btnAbout.setBounds(621, 28, 200, 51);
		add(btnAbout);
		
		
	}
	
	public void addListener(IUserOptionListener i){
		if (listener_s == null){
			listener_s = new ArrayList<IUserOptionListener>();
		}
		listener_s.add(i);

	}
}
