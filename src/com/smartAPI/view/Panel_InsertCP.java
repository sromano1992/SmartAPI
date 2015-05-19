package com.smartAPI.view;

import javax.swing.JPanel;

import java.awt.Choice;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
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

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import javax.swing.border.Border;

/**
 * Pannello che permette all'utente di inserire un code pattern
 * @author iolrin
 *
 */
public class Panel_InsertCP extends JPanel {
	private JTextField nomeCP;
	private JTextArea txtCodePattern;
	private JTextField keyword;
	private JTextField newCategoria;

	/**
	 * Create the panel.
	 */
	public Panel_InsertCP() {
		setBackground(new Color(211, 211, 211));
		setLayout(null);
		
		nomeCP = new JTextField();
		nomeCP.setBounds(98, 39, 149, 25);
		add(nomeCP);
		nomeCP.setColumns(20);
		
		txtCodePattern = new JTextArea();
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		txtCodePattern.setBorder(border);
		txtCodePattern.setBounds(102, 211, 378, 220);
		add(txtCodePattern);
		
		keyword = new JTextField();
		keyword.setColumns(20);
		keyword.setBounds(98, 102, 149, 25);
		add(keyword);

		 
		Vector v = new Vector();
		 
		    v.add("Storage");
		    v.add("Database");
		    v.add("Altro...");
		    DefaultComboBoxModel model = new DefaultComboBoxModel(v);
		  final JComboBox jcb = new JComboBox(model);
		    jcb.setBounds(408, 66, 149, 36);
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
		    newCategoria.setBounds(564, 71, 149, 25);
		    add(newCategoria);
		    newCategoria.setColumns(10);
		    newCategoria.setVisible(false);		
		
		    setSize(753, 480);
		    
		    MyJLabel cpLabel = new MyJLabel("Code Pattern");
		    cpLabel.setBounds(6, 211, 94, 25);
		    add(cpLabel);
		    
		    MyJLabel nomeLabel = new MyJLabel("Nome");
		    nomeLabel.setBounds(6, 39, 94, 25);
		    add(nomeLabel);
		    
		    MyJLabel keywordLabel = new MyJLabel("Keyword");
		    keywordLabel.setBounds(6, 102, 94, 25);
		    add(keywordLabel);
		    
		    MyJLabel categoriaLabel = new MyJLabel("Categoria");
		    categoriaLabel.setBounds(316, 71, 94, 25);
		    add(categoriaLabel);
		    setVisible(true);
	}
}
