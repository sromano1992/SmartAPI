package com.smartAPI.view;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.tree.TreePath;

import com.smartAPI.control.TreePathListener;
import com.smartAPI.model.CodePattern_Category;
import com.smartAPI.model.Common;
import com.smartAPI.model.Project;
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

import javax.swing.ButtonGroup;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import javax.swing.JToggleButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JRadioButton;
import javax.swing.JComboBox;

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
	private String language;
	/**
	 * Create the panel.
	 */
	public Panel_CodePatternCompleteView() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.NORTH);
		panel_1.setBackground(new Color(228, 230, 235));

		panel_1.setLayout(new GridLayout(0, 8, 0, 0));

		final JComboBox comboBox_myProject = new JComboBox();
		comboBox_myProject.setEnabled(true);
		comboBox_myProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String projectName = comboBox_myProject.getSelectedItem().toString();
				SmartAPIModel s = new SmartAPIModel();
				Project selectedProject = s.getProject(projectName);
				ArrayList<CodePattern_Category> toShow = new ArrayList<CodePattern_Category>();
				for (String category:selectedProject.getCategories()){
					toShow.add(s.getPatternOfCategory(category));
				}
				treeView.setCodePattern_s(toShow, "Basic", false);
			}
		});
		
		final JRadioButton rdbtnJava = new JRadioButton("Java");
		rdbtnJava.setBackground(new Color(228,230,235));
		language=rdbtnJava.getText();
		rdbtnJava.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				language = rdbtnJava.getText();
				textField_keyword.setText("");
				treeView.setCodePattern_s(new SmartAPIModel().getAllCodePatternForCategory_byLanguage(Common.JAVA), "Basic", false);
				comboBox_myProject.setEnabled(false);
			}
		});
		
		final JRadioButton rdbtnPython = new JRadioButton("Python");
		rdbtnPython.setBackground(new Color(228,230,235));
		rdbtnPython.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				language = rdbtnPython.getText();
				textField_keyword.setText("");
				treeView.setCodePattern_s(new SmartAPIModel().getAllCodePatternForCategory_byLanguage(Common.PYTHON), "Basic", false);
				comboBox_myProject.setEnabled(false);
			}
		});
		

		JRadioButton rdbtnShowAll = new JRadioButton("Show all");
		rdbtnShowAll.setBackground(new Color(228, 230, 235));
		rdbtnShowAll.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e){
				treeView.setCodePattern_s(new SmartAPIModel().getAllCodePatternForCategory(), "Basic", false);
				buttonDeleteKeyword.setEnabled(false);
				textField_keyword.setText("");
				textField_keyword.setBackground(Color.white);
				language = "all";
				comboBox_myProject.setEnabled(false);
			}
		});
		JRadioButton rdbtnByProject = new JRadioButton("By Project");
		rdbtnByProject.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				comboBox_myProject.setEnabled(true);
			}
		});
		rdbtnByProject.setBackground(new Color(228, 230, 235));
		
		ButtonGroup buttonGroup = new ButtonGroup();
		buttonGroup.add(rdbtnJava);
		buttonGroup.add(rdbtnPython);
		buttonGroup.add(rdbtnShowAll);
		buttonGroup.add(rdbtnByProject);
		panel_1.add(rdbtnJava);
		panel_1.add(rdbtnPython);
		
		panel_1.add(rdbtnShowAll);
		
		panel_1.add(rdbtnByProject);
		
		comboBox_myProject.setEnabled(true);
		panel_1.add(comboBox_myProject);
		
		JLabel lblKeyword = new JLabel("Keyword:");
		lblKeyword.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_1.add(lblKeyword);
		
		textField_keyword = new JTextField();
		panel_1.add(textField_keyword);
		textField_keyword.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_1.setBackground(new Color(228, 230, 235));
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
				ArrayList<CodePattern_Category> patternWithKeywordAndLang;
				if (language == "all"){
					patternWithKeywordAndLang = new SmartAPIModel().getAllCodePatternForCategory_byKeyword(textField_keyword.getText());
				}
				else{
					patternWithKeywordAndLang = new SmartAPIModel().getAllCodePatternForCategory_byKeywordAndLang(textField_keyword.getText(), language);
				}
				if (patternWithKeywordAndLang != null){
					textField_keyword.setBackground(Color.white);
					buttonDeleteKeyword.setEnabled(true);
					treeView.setCodePattern_s(patternWithKeywordAndLang, "Basic", false);
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

		rdbtnByProject.setSelected(true);
		//projectCombo
		SmartAPIModel s = new SmartAPIModel();
		ArrayList<Project> userFollowedProject = s.followedProject(Common.UTENTE);
		if (userFollowedProject.size() > 0){
			for (Project p:userFollowedProject){
				comboBox_myProject.addItem(p.getName());
			}
		}
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
