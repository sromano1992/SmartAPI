package com.smartAPI.view;

import javax.swing.JPanel;

import java.awt.Choice;
import java.awt.Color;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JList;
import javax.swing.AbstractListModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JMenuBar;

import java.awt.Font;
import java.util.Vector;

/**
 * Pannello che permette all'utente di inserire un code pattern
 * @author iolrin
 *
 */
public class Panel_InsertCP extends JPanel {
	private JTextField nomeCP;
	private JTextField txtCodePattern;
	private JTextField keyword;
	private JTextField newCategoria;

	/**
	 * Create the panel.
	 */
	public Panel_InsertCP() {
		setBackground(new Color(2, 94, 137));
		setLayout(null);
		
		nomeCP = new JTextField();
		nomeCP.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				nomeCP.setText(" ");
			}
		});
	
		nomeCP.setText("Nome code pattern");
		nomeCP.setBounds(6, 6, 149, 36);
		add(nomeCP);
		nomeCP.setColumns(20);
		
		txtCodePattern = new JTextField();
		txtCodePattern.setText("Code Pattern...");
		txtCodePattern.setBounds(6, 85, 293, 190);
		add(txtCodePattern);
		txtCodePattern.setColumns(10);
		txtCodePattern.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				txtCodePattern.setText(" ");
			}
		});
		
		keyword = new JTextField();
		keyword.setText("Keyword");
		keyword.setColumns(20);
		keyword.setBounds(194, 6, 149, 36);
		add(keyword);
		keyword.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				keyword.setText(" ");
			}
		});

		 
		Vector v = new Vector();
		 
		    v.add("Storage");
		    v.add("Database");
		    v.add("Altro...");
		    DefaultComboBoxModel model = new DefaultComboBoxModel(v);
		  final JComboBox jcb = new JComboBox(model);
		    jcb.setBounds(400, 6, 149, 36);
		    add(jcb);
		    jcb.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
					String categoria = (String) jcb.getSelectedItem();
					System.out.println(categoria);
					if(categoria.equals("Altro...")){
						newCategoria.setVisible(true);
					}
				}
			});
		    
		    newCategoria = new JTextField();
		    newCategoria.setText("Inserisci la categoria");
		    newCategoria.setBounds(400, 54, 166, 36);
		    add(newCategoria);
		    newCategoria.setColumns(10);
		    newCategoria.setVisible(false);		
		    newCategoria.addMouseListener(new MouseAdapter() {
				@Override
				public void mouseClicked(MouseEvent e) {
					newCategoria.setText(" ");
				}
			});
		
		    setSize(633, 249);
		    setVisible(true);
	}
}
