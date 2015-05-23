package com.smartAPI.view;

import javax.swing.JPanel;

import java.awt.Choice;
import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JScrollPane;
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

import java.awt.ScrollPane;

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
	private JTextField langTextField;
	private JTextField libTextField;

	/**
	 * Create the panel.
	 */
	public Panel_InsertCP() {
		//setBackground(new Color(2, 94, 137));
		setBackground(new Color(228, 230, 235));
		setLayout(null);

		nomeCP = new JTextField();
		nomeCP.setBounds(360, 18, 124, 37);
		add(nomeCP);
		nomeCP.setColumns(20);


		txtCodePattern = new JTextArea();
		txtCodePattern.setBounds(94, 343, 787, 220);
		//Border border = BorderFactory.createLineBorder(Color.BLACK);
		//txtCodePattern.setBorder(border);
		JScrollPane scrollableTextArea = new JScrollPane(txtCodePattern);
		scrollableTextArea.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
		scrollableTextArea.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		add(scrollableTextArea);




		keyword = new JTextField();
		keyword.setBounds(100, 67, 124, 37);
		keyword.setColumns(20);
		add(keyword);


		Vector v = new Vector();

		v.add("Storage");
		v.add("Database");
		v.add("Other...");
		DefaultComboBoxModel model = new DefaultComboBoxModel(v);
		final JComboBox jcb = new JComboBox(model);
		jcb.setBounds(617, 144, 124, 37);
		add(jcb);
		jcb.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String categoria = (String) jcb.getSelectedItem();
				if(categoria.equals("Other...")){
					newCategoria.setVisible(true);
				}
				if(!categoria.equals("Other..."))System.out.println("Categoria: "+categoria);
			}
		});



		newCategoria = new JTextField();
		newCategoria.setBounds(617, 182, 124, 37);
		add(newCategoria);
		newCategoria.setColumns(10);
		newCategoria.setVisible(false);		

		setSize(826, 594);

		JLabel cpLabel = new JLabel("Code Pattern");
		cpLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
		cpLabel.setHorizontalAlignment(SwingConstants.CENTER);
		cpLabel.setBackground(new Color(231, 76, 60));
		cpLabel.setForeground(Color.WHITE);
		cpLabel.setBounds(38, 236, 30, 210);
		cpLabel.setOpaque(true);
		cpLabel.setUI(new VerticalLabelUI(true));
		add(cpLabel);

		MyJLabel nomeLabel = new MyJLabel("Name");
		nomeLabel.setBackground(new Color(231, 76, 60));
		nomeLabel.setBounds(287, 20, 75, 32);
		add(nomeLabel);

		MyJLabel keywordLabel = new MyJLabel("Keyword");
		keywordLabel.setBackground(new Color(231, 76, 60));
		keywordLabel.setBounds(27, 69, 75, 32);
		add(keywordLabel);

		MyJLabel categoriaLabel = new MyJLabel("Category");
		categoriaLabel.setBackground(new Color(231, 76, 60));
		categoriaLabel.setBounds(543, 145, 75, 32);
		add(categoriaLabel);

		JButton addCP = new JButton("Insert");
		addCP.setBounds(300, 463, 184, 35);
		addCP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String val_nome = nomeCP.getText();
				String val_CP = txtCodePattern.getText();
				String val_keyword = keyword.getText();
				String val_language = langTextField.getText();
				String val_lib = libTextField.getText();
				if(!newCategoria.getText().equals("")) System.out.println("Category: "+newCategoria.getText());
				System.out.println("Name: "+val_nome+" Key: "+val_keyword+" Cp: "+val_CP+" Language: "+val_language+" Library: "+val_lib);
			}
		});
		add(addCP);

		MyJLabel language = new MyJLabel("Language");
		language.setBackground(new Color(231, 76, 60));
		language.setBounds(27, 145, 75, 32);
		add(language);

		langTextField = new JTextField();
		langTextField.setBounds(100, 142, 124, 37);
		add(langTextField);
		langTextField.setColumns(10);

		MyJLabel library = new MyJLabel("Library");
		library.setBackground(new Color(231, 76, 60));
		library.setBounds(543, 69, 75, 32);
		add(library);

		libTextField = new JTextField();
		libTextField.setBounds(617, 67, 124, 37);
		add(libTextField);
		libTextField.setColumns(10);
		
		
		String txt="Lorem Ipsum è un testo segnaposto utilizzato nel"+ ""
				+ "settore della tipografia e della stampa. Lorem Ipsum è "
				+ "considerato il testo segnaposto standard sin dal sedicesimo "
				+ "secolo, quando un anonimo tipografo prese una cassetta di "
				+ "caratteri e li assemblò per preparare un testo campione. "
				+ "È sopravvissuto non solo a più di cinque secoli, ma anche"
				+ " al passaggio alla videoimpaginazione, pervenendoci "
				+ "sostanzialmente inalterato. Fu reso popolare, negli anni ’60,"
				+ " con la diffusione dei fogli di caratteri trasferibili “Letraset”, "
				+ "che contenevano passaggi del Lorem Ipsum, "
				+ "e più recentemente da software di impaginazione come Aldus PageMaker,"
				+ " che includeva versioni del Lorem Ipsum.";
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(228, 230, 235));
		add(panel);
		panel.setBounds(69, 231, 671, 220);
		JTextArea ta = new JTextArea(txt+txt+txt, 13, 55);
		panel.add(ta);
	    ta.setLineWrap(true);
	    panel.add(new JScrollPane());
		
		
		
		//panel.setLayout(null);
		
	   


	}
}
