package com.smartAPI.view;

import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.BorderLayout;

import javax.swing.JLabel;
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
import com.smartAPI.model.Common;
import com.smartAPI.model.SmartAPIModel;

import java.awt.Color;

public class Panel_ShowCodePattern extends JPanel implements TreePathListener{
	private MyJLabel labelUserName;
	private JTextPane txtpaneKeyWord;
	private JTextPane txtpnCode;
	/**
	 * Create the panel.
	 */
	public Panel_ShowCodePattern() {
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(2, 26, 446, 273);
		add(scrollPane);
		
		txtpnCode = new JTextPane();
		txtpnCode.setEditable(false);
		scrollPane.setViewportView(txtpnCode);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(2, 299, 446, 84);
		add(scrollPane_1);
		
		txtpaneKeyWord = new JTextPane();
		txtpaneKeyWord.setEditable(false);
		scrollPane_1.setViewportView(txtpaneKeyWord);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(2, 2, 446, 24);
		panel_1.setBorder(new LineBorder(SystemColor.activeCaption, 1, true));
		add(panel_1);
		panel_1.setLayout(new GridLayout(0, 5, 0, 0));
		
		labelUserName = new MyJLabel("Username");
		panel_1.add(labelUserName);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(2, 426, 446, 42);
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
		panel_CodePatternScore.setBounds(0, 382, 448, 42);
		add(panel_CodePatternScore);
		panel_CodePatternScore.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(153, 180, 209), SystemColor.inactiveCaption, null, null));

	}
	
	public void setCodePattern(CodePattern cp){
		labelUserName.setText(cp.getOwner());
		txtpnCode.setText(cp.getCode());
		txtpaneKeyWord.setText(cp.getKeyWord());
	}

	@Override
	public void treePathChanged(TreePath t) {
		if (t.getPathCount() == 3){	//selected a codePattern
			String cp = t.getPathComponent(2).toString();
			SmartAPIModel s = new SmartAPIModel();
			CodePattern c = new CodePattern(s.getResourceFromBase(Common.NS + cp));
			setCodePattern(c);
		}
	}


}
