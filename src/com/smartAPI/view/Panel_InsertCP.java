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
	private JTextField textField;
	private JTextField textField_1;

	/**
	 * Create the panel.
	 */
	public Panel_InsertCP() {
		setBackground(new Color(2, 94, 137));
		setLayout(null);
		
		nomeCP = new JTextField();
		nomeCP.setBounds(248, 110, 149, 25);
		add(nomeCP);
		nomeCP.setColumns(20);
		
		
		
		txtCodePattern = new JTextArea();
		txtCodePattern.setBounds(252, 343, 378, 220);
		Border border = BorderFactory.createLineBorder(Color.BLACK);
		txtCodePattern.setBorder(border);
		add(txtCodePattern);
		
		
		keyword = new JTextField();
		keyword.setBounds(248, 172, 149, 25);
		keyword.setColumns(20);
		add(keyword);

		
		Vector v = new Vector();
		 
		    v.add("Storage");
		    v.add("Database");
		    v.add("Other...");
		    DefaultComboBoxModel model = new DefaultComboBoxModel(v);
		  final JComboBox jcb = new JComboBox(model);
		  jcb.setBounds(558, 198, 149, 36);
		    add(jcb);
		    jcb.addActionListener(new ActionListener() {
				
				public void actionPerformed(ActionEvent e) {
				 String categoria = (String) jcb.getSelectedItem();
					if(categoria.equals("Other...")){
						newCategoria.setVisible(true);
					}
					if(!categoria.equals(""))System.out.println("Categoria: "+categoria);
				}
			});
		    
		    
		    
		    newCategoria = new JTextField();
		    newCategoria.setBounds(714, 203, 149, 25);
		    add(newCategoria);
		    newCategoria.setColumns(10);
		    newCategoria.setVisible(false);		
		
		    setSize(1005, 731);
		    
		    MyJLabel cpLabel = new MyJLabel("Code Pattern");
		    cpLabel.setBounds(156, 343, 94, 25);
		    add(cpLabel);
		    
		    MyJLabel nomeLabel = new MyJLabel("Name");
		    nomeLabel.setBounds(156, 110, 94, 25);
		    add(nomeLabel);
		    
		    MyJLabel keywordLabel = new MyJLabel("Keyword");
		    keywordLabel.setBounds(156, 172, 94, 25);
		    add(keywordLabel);
		    
		    MyJLabel categoriaLabel = new MyJLabel("Category");
		    categoriaLabel.setBounds(466, 203, 94, 25);
		    add(categoriaLabel);
		    
		    JButton addCP = new JButton("Insert");
		    addCP.setBounds(385, 577, 120, 35);
		    addCP.addActionListener(new ActionListener() {
		    	public void actionPerformed(ActionEvent e) {
		    		String val_nome = nomeCP.getText();
		    		String val_CP = txtCodePattern.getText();
		    		String val_keyword = keyword.getText();
		    		if(!newCategoria.getText().equals("")) System.out.println("categoria: "+newCategoria.getText());
		    		System.out.println("Nome: "+val_nome+" Key: "+val_keyword+" Cp: "+val_CP);
		    	}
		    });
		    add(addCP);
		    
		    MyJLabel language = new MyJLabel("Language");
		    language.setBounds(156, 234, 94, 25);
		    add(language);
		    
		    textField = new JTextField();
		    textField.setBounds(248, 234, 149, 25);
		    add(textField);
		    textField.setColumns(10);
		    
		    MyJLabel library = new MyJLabel("Library");
		    library.setBounds(466, 141, 94, 25);
		    add(library);
		    
		    textField_1 = new JTextField();
		    textField_1.setBounds(558, 141, 149, 25);
		    add(textField_1);
		    textField_1.setColumns(10);
		    setVisible(true);
	}
}
