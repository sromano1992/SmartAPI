package com.smartAPI.view;

import javax.swing.JPanel;

import java.awt.Choice;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.ScrollPaneConstants;

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

import java.awt.ScrollPane;

import javax.swing.ImageIcon;

import com.smartAPI.control.AddCodePatternControl;

/**
 * Pannello che permette all'utente di inserire un code pattern
 * @author iolrin
 *
 */
public class Panel_InsertCP extends JPanel {
	private JTextField nomeCP;
	private JTextArea ta;
	private JTextField keyword;
	private JTextField newCategoria;
	private JTextField langTextField;
	private JTextField libTextField;
	private String categoria;
	private  JLabel lblError, lblOk;

	/**
	 * Create the panel.
	 */
	public Panel_InsertCP() {

		//setBackground(new Color(2, 94, 137));
		setBackground(new Color(228, 230, 235));
		setLayout(null);

		nomeCP = new JTextField();
		nomeCP.setBounds(365, 18, 190, 37);
		add(nomeCP);
		nomeCP.setColumns(20);


		/*txtCodePattern = new JTextArea();
		txtCodePattern.setBounds(94, 343, 787, 220);
		//Border border = BorderFactory.createLineBorder(Color.BLACK);
		//txtCodePattern.setBorder(border);
		JScrollPane scrollableTextArea = new JScrollPane(txtCodePattern);
		scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollableTextArea);*/




		keyword = new JTextField();
		keyword.setBounds(105, 67, 190, 37);
		keyword.setColumns(20);
		add(keyword);


		Vector v = new Vector();

		v.add("Storage");
		v.add("Database");
		v.add("Other...");
		DefaultComboBoxModel model = new DefaultComboBoxModel(v);
		final JComboBox jcb = new JComboBox(model);
		jcb.setBounds(624, 144, 190, 37);
		add(jcb);
		categoria = (String) v.get(0);
		jcb.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				 categoria = (String) jcb.getSelectedItem();
				if(categoria.equals("Other...")){
					newCategoria.setVisible(true);
				}
				if(!categoria.equals("Other..."))System.out.println("Categoria: "+categoria);
			}
		});



		newCategoria = new JTextField();
		newCategoria.setBounds(624, 182, 190, 37);
		add(newCategoria);
		newCategoria.setColumns(10);
		newCategoria.setVisible(false);		

		setSize(826, 594);

		JLabel cpLabel = new JLabel("*Code ");
		cpLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		cpLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cpLabel.setBackground(new Color(231, 76, 60));
		cpLabel.setForeground(Color.WHITE);
		cpLabel.setBounds(15, 237, 54, 32);
		cpLabel.setOpaque(true);
		//cpLabel.setUI(new VerticalLabelUI(true));
		add(cpLabel);

		MyJLabel nomeLabel = new MyJLabel("*Name");
		nomeLabel.setBackground(new Color(231, 76, 60));
		nomeLabel.setBounds(287, 20, 80, 32);
		add(nomeLabel);

		MyJLabel keywordLabel = new MyJLabel("Keyword");
		keywordLabel.setBackground(new Color(231, 76, 60));
		keywordLabel.setBounds(27, 69, 80, 32);
		add(keywordLabel);

		MyJLabel categoriaLabel = new MyJLabel("*Category");
		categoriaLabel.setBackground(new Color(231, 76, 60));
		categoriaLabel.setBounds(546, 145, 80, 32);
		add(categoriaLabel);

		JButton addCP = new JButton("Insert");
		addCP.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		addCP.setForeground(Color.BLACK);
		addCP.setIcon(null);
		addCP.setBounds(340, 463, 184, 35);
		addCP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String val_nome = nomeCP.getText();
				String val_CP = ta.getText();
				String val_keyword = keyword.getText();
				String val_language = langTextField.getText();
				String val_lib = libTextField.getText();
				if(!newCategoria.getText().equals("")) categoria = newCategoria.getText();
				
				if(val_nome.equals("") | val_language.equals("") | val_lib.equals("") | val_CP.equals("")){
					lblOk.setVisible(false);
					lblError.setText("Fields with * are required!");
					lblError.setVisible(true);
				}
				
				else{
					if(new AddCodePatternControl(val_nome, val_CP, val_keyword, val_language, val_lib, categoria).addCodePattern() == 1){
						lblError.setVisible(false);
						lblOk.setText("Code pattern inserted!");
						lblOk.setVisible(true);
					}
					else{
						lblOk.setVisible(false);
						lblError.setText("Code pattern not inserted!");
						lblError.setVisible(true);
					}
				}
				//System.out.println("Name: "+val_nome+" Key: "+val_keyword+" Cp: "+val_CP+" Language: "+val_language+" Library: "+val_lib);
			}
		});
		add(addCP);

		MyJLabel language = new MyJLabel("*Language");
		language.setBackground(new Color(231, 76, 60));
		language.setBounds(27, 145, 80, 32);
		add(language);

		langTextField = new JTextField();
		langTextField.setBounds(105, 142, 190, 37);
		add(langTextField);
		langTextField.setColumns(10);

		MyJLabel library = new MyJLabel("*Library");
		library.setBackground(new Color(231, 76, 60));
		library.setBounds(546, 69, 80, 32);
		add(library);

		libTextField = new JTextField();
		libTextField.setBounds(624, 67, 190, 37);
		add(libTextField);
		libTextField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(228, 230, 235));
		add(panel);
		panel.setBounds(69, 231, 738, 220);
		ta = new JTextArea(" ", 13, 60);
		//panel.add(ta);
		ta.setVisible(true);
	    ta.setLineWrap(true);
	    
	    JScrollPane scrollPane = new JScrollPane(ta);
	    scrollPane.setVisible(true);
	    scrollPane.setBounds(69,231,80,80);
	    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    panel.add(scrollPane);
	    
	    
	    JLabel lblPattern = new JLabel("Pattern");
	    lblPattern.setOpaque(true);
	    lblPattern.setHorizontalAlignment(SwingConstants.CENTER);
	    lblPattern.setForeground(Color.WHITE);
	    lblPattern.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
	    lblPattern.setBackground(new Color(231, 76, 60));
	    lblPattern.setBounds(15, 269, 55, 32);
	    add(lblPattern);
	    
	    lblError = new JLabel();
	    lblError.setBounds(533, 470, 300, 16);
	    lblError.setForeground(Color.RED);
		lblError.setFont(new Font("Lucida Grande", Font.BOLD, 13));
		add(lblError);
	    lblError.setVisible(false);
	    
	    
	    lblOk = new JLabel();
	    lblOk.setBounds(533, 470, 300, 16);
	    lblOk.setForeground(new Color(0, 168, 107));
		lblOk.setFont(new Font("Lucida Grande", Font.BOLD, 13));
	    add(lblOk);
	    
	    lblOk.setVisible(false);
	    //panel.add(new JScrollPane());
		
		
		
		//panel.setLayout(null);
		
	   


	}
}
