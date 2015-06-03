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
import javax.swing.SwingUtilities;

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
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import javax.swing.border.Border;

import java.awt.ScrollPane;

import javax.swing.ImageIcon;

import com.hp.hpl.jena.rdf.model.Resource;
import com.smartAPI.control.AddCodePatternControl;
import com.smartAPI.model.Common;
import com.smartAPI.model.SmartAPIModel;

import javax.swing.JEditorPane;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;

import java.awt.SystemColor;

import javax.swing.UIManager;

import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.ComboBoxModel;

import java.awt.BorderLayout;

/**
 * Pannello che permette all'utente di inserire un code pattern
 * @author iolrin
 *
 */
public class Panel_InsertCP extends JPanel {
	private JTextField nomeCP;
	private RSyntaxTextArea ta;
	private JTextField keyword;
	private String categoria;
	private String language;	
	private MyJLabel lblLanguage;
	private JTextField libTextField;
	private JTextField newCategoria;

	/**
	 * Create the panel.
	 */
	public Panel_InsertCP() {

		//setBackground(new Color(2, 94, 137));
		setBackground(new Color(228, 230, 235));
		setLayout(new GridLayout(1, 2, 0, 0));


		Vector v = new Vector();

		SmartAPIModel s = new SmartAPIModel();
		ArrayList<Resource> categories = s.getPatternCategory();
		for (Resource r:categories){
			v.add(r.getLocalName());
		}
		v.add("Other...");
		DefaultComboBoxModel model = new DefaultComboBoxModel(v);
		categoria = (String) v.get(0);
		final JComboBox jcbCategory = new JComboBox(model);
		jcbCategory.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				 categoria = (String) jcbCategory.getSelectedItem();
				if(categoria.equals("Other...")){
					newCategoria.setVisible(true);
					SwingUtilities.updateComponentTreeUI(getParent());
				}
				if(!categoria.equals("Other..."))System.out.println("Categoria: "+categoria);
			}
		});
		
		
		setSize(826, 594);
		
		JPanel panel_2 = new JPanel();
		add(panel_2);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[]{0, 0};
		gbl_panel_2.rowHeights = new int[] {10, 350, 0};
		gbl_panel_2.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_2.rowWeights = new double[]{1.0, 1.0, Double.MIN_VALUE};
		panel_2.setLayout(gbl_panel_2);
		
		JPanel panel_3 = new JPanel();
		GridBagConstraints gbc_panel_3 = new GridBagConstraints();
		gbc_panel_3.insets = new Insets(0, 0, 5, 0);
		gbc_panel_3.fill = GridBagConstraints.BOTH;
		gbc_panel_3.gridx = 0;
		gbc_panel_3.gridy = 0;
		panel_2.add(panel_3, gbc_panel_3);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[] {0, 0, 0};
		gbl_panel_3.rowHeights = new int[] {0};
		gbl_panel_3.columnWeights = new double[]{1.0, 1.0, 1.0};
		gbl_panel_3.rowWeights = new double[]{1.0};
		panel_3.setLayout(gbl_panel_3);
		
		JPanel panel_7 = new JPanel();
		GridBagConstraints gbc_panel_7 = new GridBagConstraints();
		gbc_panel_7.insets = new Insets(0, 0, 0, 5);
		gbc_panel_7.fill = GridBagConstraints.BOTH;
		gbc_panel_7.gridx = 0;
		gbc_panel_7.gridy = 0;
		panel_3.add(panel_7, gbc_panel_7);
		GridBagLayout gbl_panel_7 = new GridBagLayout();
		gbl_panel_7.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_7.rowHeights = new int[] {0, 0, 0, 0, 0};
		gbl_panel_7.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_7.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_7.setLayout(gbl_panel_7);
										
												MyJLabel keywordLabel = new MyJLabel("Keyword");
												GridBagConstraints gbc_keywordLabel = new GridBagConstraints();
												gbc_keywordLabel.fill = GridBagConstraints.BOTH;
												gbc_keywordLabel.insets = new Insets(0, 0, 5, 0);
												gbc_keywordLabel.gridx = 1;
												gbc_keywordLabel.gridy = 2;
												panel_7.add(keywordLabel, gbc_keywordLabel);
												keywordLabel.setBackground(new Color(231, 76, 60));
										
										
										
										
												keyword = new JTextField();
												GridBagConstraints gbc_keyword = new GridBagConstraints();
												gbc_keyword.insets = new Insets(0, 0, 5, 0);
												gbc_keyword.gridx = 2;
												gbc_keyword.gridy = 2;
												panel_7.add(keyword, gbc_keyword);
												keyword.setColumns(20);
								
										
										lblLanguage = new MyJLabel("*Language");
										GridBagConstraints gbc_lblLanguage = new GridBagConstraints();
										gbc_lblLanguage.fill = GridBagConstraints.BOTH;
										gbc_lblLanguage.insets = new Insets(0, 0, 5, 0);
										gbc_lblLanguage.gridx = 1;
										gbc_lblLanguage.gridy = 3;
										panel_7.add(lblLanguage, gbc_lblLanguage);
										lblLanguage.setBackground(new Color(231, 76, 60));

									    Vector v1 = new Vector();
									    v1.add(Common.JAVA);
										v1.add(Common.PYTHON);
										
										DefaultComboBoxModel model_lang = new DefaultComboBoxModel(v1);
										language = (String) v1.get(0);
										final JComboBox jcbLanguage = new JComboBox(model_lang);
										GridBagConstraints gbc_jcbLanguage = new GridBagConstraints();
										gbc_jcbLanguage.ipadx = 90;
										gbc_jcbLanguage.gridx = 2;
										gbc_jcbLanguage.gridy = 3;
										panel_7.add(jcbLanguage, gbc_jcbLanguage);
								jcbLanguage.addActionListener(new ActionListener() {
									public void actionPerformed(ActionEvent e) {
										language = (String) jcbLanguage.getSelectedItem();
										if (language.equals(Common.JAVA))
											ta.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
										if (language.equals(Common.PYTHON)){
											ta.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_PYTHON);
											ta.setTabSize(4);
										}
									}
								});
		
		JPanel panel_6 = new JPanel();
		GridBagConstraints gbc_panel_6 = new GridBagConstraints();
		gbc_panel_6.insets = new Insets(0, 0, 0, 5);
		gbc_panel_6.fill = GridBagConstraints.BOTH;
		gbc_panel_6.gridx = 1;
		gbc_panel_6.gridy = 0;
		panel_3.add(panel_6, gbc_panel_6);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{0, 0, 0, 0};
		gbl_panel_6.rowHeights = new int[]{0, 0, 0, 0};
		gbl_panel_6.columnWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
								
										MyJLabel nomeLabel = new MyJLabel("*Name");
										GridBagConstraints gbc_nomeLabel = new GridBagConstraints();
										gbc_nomeLabel.fill = GridBagConstraints.BOTH;
										gbc_nomeLabel.insets = new Insets(0, 0, 5, 5);
										gbc_nomeLabel.gridx = 1;
										gbc_nomeLabel.gridy = 1;
										panel_6.add(nomeLabel, gbc_nomeLabel);
										nomeLabel.setBackground(new Color(231, 76, 60));
								
										nomeCP = new JTextField();
										GridBagConstraints gbc_nomeCP = new GridBagConstraints();
										gbc_nomeCP.insets = new Insets(0, 0, 5, 0);
										gbc_nomeCP.gridx = 2;
										gbc_nomeCP.gridy = 1;
										panel_6.add(nomeCP, gbc_nomeCP);
										nomeCP.setColumns(20);
		
		JPanel panel_5 = new JPanel();
		GridBagConstraints gbc_panel_5 = new GridBagConstraints();
		gbc_panel_5.insets = new Insets(0, 0, 0, 5);
		gbc_panel_5.fill = GridBagConstraints.BOTH;
		gbc_panel_5.gridx = 2;
		gbc_panel_5.gridy = 0;
		panel_3.add(panel_5, gbc_panel_5);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{0, 0, 0};
		gbl_panel_5.rowHeights = new int[]{0, 0, 0, 0, 0, 0};
		gbl_panel_5.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		MyJLabel label = new MyJLabel("*Library");
		label.setBackground(new Color(231, 76, 60));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.fill = GridBagConstraints.BOTH;
		gbc_label.insets = new Insets(0, 0, 5, 5);
		gbc_label.gridx = 0;
		gbc_label.gridy = 2;
		panel_5.add(label, gbc_label);
		
		libTextField = new JTextField();
		libTextField.setColumns(10);
		GridBagConstraints gbc_libTextField = new GridBagConstraints();
		gbc_libTextField.insets = new Insets(0, 0, 5, 0);
		gbc_libTextField.fill = GridBagConstraints.HORIZONTAL;
		gbc_libTextField.gridx = 1;
		gbc_libTextField.gridy = 2;
		panel_5.add(libTextField, gbc_libTextField);
		
		MyJLabel label_1 = new MyJLabel("*Category");
		label_1.setBackground(new Color(231, 76, 60));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.fill = GridBagConstraints.BOTH;
		gbc_label_1.insets = new Insets(0, 0, 5, 5);
		gbc_label_1.gridx = 0;
		gbc_label_1.gridy = 3;
		panel_5.add(label_1, gbc_label_1);
		
		
		GridBagConstraints gbc_jcbCategory = new GridBagConstraints();
		gbc_jcbCategory.insets = new Insets(0, 0, 5, 0);
		gbc_jcbCategory.fill = GridBagConstraints.HORIZONTAL;
		gbc_jcbCategory.gridx = 1;
		gbc_jcbCategory.gridy = 3;
		panel_5.add(jcbCategory, gbc_jcbCategory);
		
		
		
		newCategoria = new JTextField();
		newCategoria.setColumns(10);
		newCategoria.setVisible(false);
		GridBagConstraints gbc_newCategoria = new GridBagConstraints();
		gbc_newCategoria.fill = GridBagConstraints.HORIZONTAL;
		gbc_newCategoria.gridx = 1;
		gbc_newCategoria.gridy = 4;
		panel_5.add(newCategoria, gbc_newCategoria);
		newCategoria.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		GridBagConstraints gbc_panel_4 = new GridBagConstraints();
		gbc_panel_4.fill = GridBagConstraints.BOTH;
		gbc_panel_4.gridx = 0;
		gbc_panel_4.gridy = 1;
		panel_2.add(panel_4, gbc_panel_4);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[] {0, 0};
		gbl_panel_4.rowHeights = new int[] {0, 30};
		gbl_panel_4.columnWeights = new double[]{0.0, 0.0};
		gbl_panel_4.rowWeights = new double[]{0.0, 0.0};
		panel_4.setLayout(gbl_panel_4);
				
				JPanel panel_1 = new JPanel();
				GridBagConstraints gbc_panel_1 = new GridBagConstraints();
				gbc_panel_1.fill = GridBagConstraints.BOTH;
				gbc_panel_1.insets = new Insets(0, 0, 5, 5);
				gbc_panel_1.gridx = 0;
				gbc_panel_1.gridy = 0;
				panel_4.add(panel_1, gbc_panel_1);
				GridBagLayout gbl_panel_1 = new GridBagLayout();
				gbl_panel_1.columnWidths = new int[]{0, 0};
				gbl_panel_1.rowHeights = new int[]{0, 0, 0};
				gbl_panel_1.columnWeights = new double[]{0.0, Double.MIN_VALUE};
				gbl_panel_1.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
				panel_1.setLayout(gbl_panel_1);
		
				JLabel cpLabel = new JLabel("*Code ");
				GridBagConstraints gbc_cpLabel = new GridBagConstraints();
				gbc_cpLabel.fill = GridBagConstraints.BOTH;
				gbc_cpLabel.gridx = 0;
				gbc_cpLabel.gridy = 0;
				panel_1.add(cpLabel, gbc_cpLabel);
				cpLabel.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
				cpLabel.setHorizontalAlignment(SwingConstants.CENTER);
				cpLabel.setBackground(new Color(231, 76, 60));
				cpLabel.setForeground(Color.WHITE);
				cpLabel.setOpaque(true);
				
				JLabel lblPattern = new JLabel("Pattern");
				GridBagConstraints gbc_lblPattern = new GridBagConstraints();
				gbc_lblPattern.fill = GridBagConstraints.BOTH;
				gbc_lblPattern.gridx = 0;
				gbc_lblPattern.gridy = 1;
				panel_1.add(lblPattern, gbc_lblPattern);
				lblPattern.setOpaque(true);
				lblPattern.setHorizontalAlignment(SwingConstants.CENTER);
				lblPattern.setForeground(Color.WHITE);
				lblPattern.setFont(new Font("Lucida Grande", Font.PLAIN, 15));
				lblPattern.setBackground(new Color(231, 76, 60));
		
		JPanel panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.weighty = 0.1;
		gbc_panel.weightx = 0.1;
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.ipadx = 50;
		gbc_panel.insets = new Insets(0, 0, 5, 0);
		gbc_panel.gridx = 1;
		gbc_panel.gridy = 0;
		panel_4.add(panel, gbc_panel);
		panel.setBackground(new Color(228, 230, 235));
		
		
		ta = new RSyntaxTextArea(20, 60);
		ta.setRows(13);
		ta.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
		ta.setAutoIndentEnabled(true);
		ta.setCodeFoldingEnabled(true);
		ta.canRedo();
		ta.canUndo();
		panel.setLayout(new BorderLayout(0, 0));
		RTextScrollPane sp = new RTextScrollPane(ta);
		panel.add(sp);
										
										JPanel panel_8 = new JPanel();
										GridBagConstraints gbc_panel_8 = new GridBagConstraints();
										gbc_panel_8.fill = GridBagConstraints.BOTH;
										gbc_panel_8.gridx = 1;
										gbc_panel_8.gridy = 1;
										panel_4.add(panel_8, gbc_panel_8);
										panel_8.setLayout(new GridLayout(0, 5, 0, 0));
										
										JLabel label_2 = new JLabel("");
										panel_8.add(label_2);
										
										final JLabel lblOk = new JLabel("");
										lblOk.setHorizontalAlignment(SwingConstants.LEFT);
										lblOk.setOpaque(true);
										panel_8.add(lblOk);
										lblOk.setForeground(new Color(0,168,107));

										final JLabel lblError = new JLabel("");
										lblError.setHorizontalAlignment(SwingConstants.RIGHT);
										JButton addCP = new JButton("Insert");
										panel_8.add(addCP);
										addCP.setFont(new Font("Lucida Grande", Font.BOLD, 13));
										addCP.setForeground(Color.BLACK);
										addCP.setIcon(null);
										addCP.addActionListener(new ActionListener() {
											public void actionPerformed(ActionEvent e) {
												String val_nome = nomeCP.getText();
												String val_CP = ta.getText();
												String val_keyword = keyword.getText();
												//String val_language = langTextField.getText();
												String val_lib = libTextField.getText();
												if(!newCategoria.getText().equals("")) categoria = newCategoria.getText();
												
												if(val_nome.equals("") | val_lib.equals("") | val_CP.equals("")){
													lblOk.setVisible(false);
													lblError.setText("Fields with * are required!");
													lblError.setVisible(true);
												}
												else{
													int insertStatus = new AddCodePatternControl(val_nome, val_CP, val_keyword, language, val_lib, categoria).addCodePattern();
													if(insertStatus == 1){
														lblError.setVisible(false);
														lblOk.setText("Code pattern inserted!");
														lblOk.setVisible(true);
													}
													else if(insertStatus == -2){
														lblOk.setVisible(false);
														lblError.setText("No method invocation found");
														lblError.setVisible(true);
													}
													else{
														lblOk.setVisible(false);
														lblError.setText("Code pattern not inserted!");
														if (language.equals(Common.PYTHON))
															lblError.setText(lblError.getText() + " - Check code indentation");
														lblError.setVisible(true);
													}
												}
												//System.out.println("Name: "+val_nome+" Key: "+val_keyword+" Cp: "+val_CP+" Language: "+val_language+" Library: "+val_lib);
											}
										});

										
										lblError.setForeground(Color.red);
										lblError.setOpaque(true);
										panel_8.add(lblError);
		/*ta = new JTextArea(" ", 13, 60);
		//panel.add(ta);
		ta.setVisible(true);
	    ta.setLineWrap(true);
	    
	    JScrollPane scrollPane = new JScrollPane(ta);
	    scrollPane.setVisible(true);
	    scrollPane.setBounds(69,231,80,80);
	    scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
	    panel.add(scrollPane);*/
	    
	    

		
		
	    
	    //panel.add(new JScrollPane());
		
		
		
		//panel.setLayout(null);
		
	   


	}
}
