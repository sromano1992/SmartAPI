package com.smartAPI.view;

import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;

import java.awt.FlowLayout;
import java.awt.CardLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ScrollPaneConstants;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;

import java.awt.SystemColor;

import javax.swing.border.LineBorder;
import javax.swing.tree.TreePath;

import com.smartAPI.control.TreePathListener;
import com.smartAPI.model.CodePattern;
import com.smartAPI.model.CodePattern_Category;
import com.smartAPI.model.Common;
import com.smartAPI.model.SmartAPIModel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Panel_ShowCodePattern extends JPanel implements TreePathListener{
	private MyJLabel labelUserName;
	private JTextPane txtpaneKeyWord;
	private JTextPane txtpnCode;
	private JButton infoButton;
	private CodePattern actualCP;
	private String actualCP_category;
	
	/**
	 * Create the panel.
	 */
	public Panel_ShowCodePattern() {
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(2, 26, 436, 273);
		add(scrollPane);
		
		txtpnCode = new JTextPane();
		txtpnCode.setEditable(false);
		scrollPane.setViewportView(txtpnCode);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(2, 299, 436, 84);
		add(scrollPane_1);
		
		txtpaneKeyWord = new JTextPane();
		txtpaneKeyWord.setEditable(false);
		scrollPane_1.setViewportView(txtpaneKeyWord);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(2, 2, 436, 24);
		panel_1.setBorder(new LineBorder(SystemColor.activeCaption, 1, true));
		add(panel_1);
		panel_1.setLayout(new GridLayout(0, 5, 0, 0));
		
		labelUserName = new MyJLabel("Username");
		panel_1.add(labelUserName);
		
		JLabel label_2 = new JLabel("");
		panel_1.add(label_2);
		
		JLabel label_1 = new JLabel("");
		panel_1.add(label_1);
		
		JLabel label = new JLabel("");
		panel_1.add(label);
		
		JPanel panel = new JPanel();
		panel_1.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		infoButton = new JButton("");
		infoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame_InferredCpInfo f = new JFrame_InferredCpInfo();
				f.setInferredCP(actualCP, actualCP_category);
				f.setVisible(true);
			}
		});
		infoButton.setIcon(new ImageIcon(Panel_ShowCodePattern.class.getResource("/com/smartAPI/view/res/questionMark.gif")));
		infoButton.setEnabled(false);
		infoButton.setVisible(false);
		panel.add(infoButton);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(2, 426, 436, 42);
		add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		MyJLabel mjlblVota = new MyJLabel("Username");
		mjlblVota.setOpaque(true);
		mjlblVota.setBackground(new Color(4, 113, 36));
		mjlblVota.setText("   Vota   ");
		panel_3.add(mjlblVota, BorderLayout.WEST);
		
		Panel_CodePatternSetScore panel_CodePatternSetScore = new Panel_CodePatternSetScore();
		panel_3.add(panel_CodePatternSetScore);
		
		Panel_CodePatternScore panel_CodePatternScore = new Panel_CodePatternScore();
		panel_CodePatternScore.setBounds(0, 382, 438, 42);
		add(panel_CodePatternScore);
		panel_CodePatternScore.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(153, 180, 209), SystemColor.inactiveCaption, null, null));

	}
	
	public void setCodePattern(CodePattern cp){
		labelUserName.setText(cp.getOwner());
		txtpnCode.setText(cp.getCode());
		txtpaneKeyWord.setText(cp.getKeyWord());
		infoButton.setVisible(cp.getRelativeBasicCodePattern() != null);
		infoButton.setEnabled(cp.getRelativeBasicCodePattern() != null);
		this.actualCP = cp;
	}

	@Override
	public void treePathChanged(TreePath t) {
		if (t.getPathCount() == 3){	//selected a codePattern
			String cp = t.getPathComponent(2).toString();
			SmartAPIModel s = new SmartAPIModel();
			CodePattern cpToSearch = new CodePattern(s.getResourceFromBase(Common.NS + cp));
			/**
			 * getResFromBase will return only codePatter without information about
			 * inferred and relative basic method; with getPatternOfCategory
			 * I get infomation all information about cp of some category;
			 */
			actualCP_category = t.getPathComponent(1).toString();
			CodePattern_Category patternOfSameCat = s.getPatternOfCategory(t.getPathComponent(1).toString());
			for (CodePattern c : patternOfSameCat.getInferredCodePattern()){
				if (c.getResource().getLocalName().equals(cpToSearch.getResource().getLocalName())){
					cpToSearch = c;
				}
			}
			setCodePattern(cpToSearch);
		}
	}
}
