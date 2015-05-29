package com.smartAPI.view;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.tree.TreePath;

import com.smartAPI.control.TreePathListener;
import com.smartAPI.model.CodePattern_Category;
import com.smartAPI.model.SmartAPIModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.GridLayout;

import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.ScrollPaneConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

/**
 * 
 * @author Simone Romamo - http://www.sromano.altervista.org
 *
 */
public class Panel_CodePatternCompleteView extends JPanel implements TreePathListener{
	private static Logger log = Logger.getLogger("global");
	private TreeViewCP treeView;
	private JTextField textField_keyword;
	private JButton buttonDeleteKeyword;
	
	/**
	 * Create the panel.
	 */
	public Panel_CodePatternCompleteView() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new GridLayout(0, 11, 0, 0));
		
		JRadioButton rdbtnJava = new JRadioButton("Java");
		panel_1.add(rdbtnJava);
		
		JRadioButton rdbtnPython = new JRadioButton("Python");
		panel_1.add(rdbtnPython);
		
		JLabel label_5 = new JLabel("");
		panel_1.add(label_5);
		
		JLabel label_4 = new JLabel("");
		panel_1.add(label_4);
		
		JLabel label_3 = new JLabel("");
		panel_1.add(label_3);
		
		JLabel label_2 = new JLabel("");
		panel_1.add(label_2);
		
		JLabel label_1 = new JLabel("");
		panel_1.add(label_1);
		
		JLabel label = new JLabel("");
		panel_1.add(label);
		
		JLabel lblKeyword = new JLabel("Keyword:");
		lblKeyword.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblKeyword);
		
		textField_keyword = new JTextField();
		panel_1.add(textField_keyword);
		textField_keyword.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		panel_2.setLayout(new GridLayout(0, 2, 0, 0));
		
		JButton btnSearch = new JButton("");
		btnSearch.setIcon(new ImageIcon(Panel_CodePatternCompleteView.class.getResource("/com/smartAPI/view/res/searchIcon.png")));
		panel_2.add(btnSearch);
		
		buttonDeleteKeyword = new JButton("");
		buttonDeleteKeyword.setEnabled(false);
		buttonDeleteKeyword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				treeView.setCodePattern_s(new SmartAPIModel().getAllCodePatternForCategory(), "Basic", false);
				buttonDeleteKeyword.setEnabled(false);
				textField_keyword.setText("");
				textField_keyword.setBackground(Color.white);
			}
		});
		buttonDeleteKeyword.setIcon(new ImageIcon(Panel_CodePatternCompleteView.class.getResource("/com/smartAPI/view/res/remove.png")));
		panel_2.add(buttonDeleteKeyword);
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setContinuousLayout(true);
	    splitPane.setOneTouchExpandable(true);
		add(splitPane, BorderLayout.CENTER);
		splitPane.setSize(new Dimension(0, 250));
		splitPane.setPreferredSize(new Dimension(193, 250));
		splitPane.setMinimumSize(new Dimension(193, 250));
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);		
		
		Panel_InferredCodePattern panel_InferredCodePattern = new Panel_InferredCodePattern();
		splitPane.setRightComponent(panel_InferredCodePattern);

		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		
		splitPane.setDividerLocation(75);
		
		treeView = new TreeViewCP();
		TreeViewCP treeView_1 = new TreeViewCP();
		treeView.setCodePattern_s(new SmartAPIModel().getAllCodePatternForCategory(), "Basic", false);
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ArrayList<CodePattern_Category> patternWithKeyword = new SmartAPIModel().getAllCodePatternForCategory(textField_keyword.getText());
				if (patternWithKeyword != null){
					textField_keyword.setBackground(Color.white);
					buttonDeleteKeyword.setEnabled(true);
					treeView.setCodePattern_s(patternWithKeyword, "Basic", false);
					Border border = BorderFactory.createLineBorder(Color.GRAY);
					textField_keyword.setBorder(border);
				}
				else{
					Border border = BorderFactory.createLineBorder(Color.red);
					textField_keyword.setBorder(border);
					//textField_keyword.setBackground(Color.red);
				}
			}
		});
		
		treeView.addTreePathListener(this);
		treeView.addTreePathListener(treeView_1);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		panel.add(treeView);
		panel.add(treeView_1);
		treeView.addTreePathListener(panel_InferredCodePattern.getPanel_ShowCodePattern());
		
		treeView_1.addTreePathListener(panel_InferredCodePattern.getPanel_ShowCodePattern_1());
	}

	@Override
	public void treePathChanged(TreePath t) {
		log.info("updating gui...");
		SwingUtilities.updateComponentTreeUI(this);
		Component c = getParent();
		while (c!=null){
			SwingUtilities.updateComponentTreeUI(this);
			c = c.getParent();
		}
	}
	
	public void refresh(){
		treeView.setCodePattern_s(new SmartAPIModel().getAllCodePatternForCategory(), "Basic", false);
		textField_keyword.setText("");
		textField_keyword.setBackground(Color.white);
		log.info("Updated codePattern view...");
	}
}
