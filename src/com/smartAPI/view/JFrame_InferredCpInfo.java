package com.smartAPI.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.text.DecimalFormat;
import java.util.ArrayList;

import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;

import com.hp.hpl.jena.rdf.model.Resource;
import com.smartAPI.model.CodePattern;

import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;

import javax.swing.UIManager;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;

import java.awt.Color;

import javax.swing.border.MatteBorder;
/**
 * 
 * @author Simone Romamo - http://www.sromano.altervista.org
 *
 */
public class JFrame_InferredCpInfo extends JFrame {
	private JPanel contentPane;
	private JTextPane textPane_InferredCategory, textPane_Probability, textPane_RelativeBasic;
	private JTextArea textArea_CommonMethod = new JTextArea();
	private JLabel lblReliability;
	private JLabel lblRelativeBasic;
	private JPanel panel_2;
	private JPanel panel_3;
	private JLabel labelCommonMethods;
	private JLabel labelBasicMethods;
	private JTextArea textArea_Basic;
	private JTextArea textArea_Inferred;
	private JLabel lblInferredCategory;

	/**
	 * Create the frame.
	 */
	public JFrame_InferredCpInfo() {
		setTitle("Inference informations");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 568, 217);
		contentPane = new JPanel();
		contentPane.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblInferredCategory = new JLabel("Inferred Category:");
		lblInferredCategory.setOpaque(true);
		lblInferredCategory.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		lblInferredCategory.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblInferredCategory.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblInferredCategory);
		
		textPane_InferredCategory = new JTextPane();
		textPane_InferredCategory.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		textPane_InferredCategory.setEditable(false);
		panel.add(textPane_InferredCategory);
		
		lblReliability = new JLabel("Reliability (common/basic):");
		lblReliability.setOpaque(true);
		lblReliability.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		lblReliability.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblReliability.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblReliability);
		
		textPane_Probability = new JTextPane();
		textPane_Probability.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		textPane_Probability.setEditable(false);
		panel.add(textPane_Probability);
		
		lblRelativeBasic = new JLabel("Relative Basic Code Pattern:");
		lblRelativeBasic.setOpaque(true);
		lblRelativeBasic.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		lblRelativeBasic.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRelativeBasic.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblRelativeBasic);
		
		textPane_RelativeBasic = new JTextPane();
		textPane_RelativeBasic.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		textPane_RelativeBasic.setEditable(false);
		panel.add(textPane_RelativeBasic);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		panel_2 = new JPanel();
		panel_2.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_1.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(0, 3, 0, 0));
		
		textArea_Inferred = new JTextArea();
		textArea_Inferred.setLineWrap(true);
		textArea_Inferred.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		panel_2.add(new JScrollPane(textArea_Inferred));
		
		textArea_CommonMethod = new JTextArea();
		textArea_CommonMethod.setLineWrap(true);
		textArea_CommonMethod.setBackground(UIManager.getColor("InternalFrame.inactiveTitleBackground"));
		panel_2.add(new JScrollPane(textArea_CommonMethod));
		
		textArea_Basic = new JTextArea();
		textArea_Basic.setLineWrap(true);
		textArea_Basic.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		panel_2.add(new JScrollPane(textArea_Basic));
		
		panel_3 = new JPanel();
		panel_3.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		panel_3.setBackground(UIManager.getColor("InternalFrame.activeTitleBackground"));
		panel_1.add(panel_3, BorderLayout.NORTH);
		panel_3.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lblInferredMethods = new JLabel("Inferred's methods");
		lblInferredMethods.setHorizontalAlignment(SwingConstants.CENTER);
		panel_3.add(lblInferredMethods);
		lblInferredMethods.setFont(new Font("Tahoma", Font.BOLD, 11));
		
		labelCommonMethods = new JLabel("Common methods");
		labelCommonMethods.setHorizontalAlignment(SwingConstants.CENTER);
		labelCommonMethods.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_3.add(labelCommonMethods);
		
		labelBasicMethods = new JLabel("Basic's methods");
		labelBasicMethods.setHorizontalAlignment(SwingConstants.CENTER);
		labelBasicMethods.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_3.add(labelBasicMethods);
	}
	
	public void setInferredCP(CodePattern cp, String cpCategory){
		setTitle("Inference informations for " + cp.getResource().getLocalName());
		textPane_InferredCategory.setText(cpCategory);
		DecimalFormat df = new DecimalFormat("#.00");
		textPane_Probability.setText(df.format(cp.getScore()) + "%");
		if(cp.getScore()<30)
			textPane_Probability.setBackground(Color.red);
		if(cp.getScore()<60 && cp.getScore()>=30)
			textPane_Probability.setBackground(Color.yellow);
		if(cp.getScore()>=60)
			textPane_Probability.setBackground(Color.green);
		textPane_RelativeBasic.setText(cp.getRelativeBasicCodePattern().getResource().getLocalName());
		textArea_CommonMethod.setText("");
		int cycle = 0;
		for (Resource method:cp.getCommonWithBasic()){
			if(cycle > 0)
				textArea_CommonMethod.setText(textArea_CommonMethod.getText() + " - ");
			textArea_CommonMethod.setText(textArea_CommonMethod.getText() + method.getLocalName());
			cycle = 1;
		}
		cycle = 0;
		for (Resource method:cp.getUsedMethod_s()){
			if(cycle > 0)
				textArea_Inferred.setText(textArea_Inferred.getText() + " - ");
			textArea_Inferred.setText(textArea_Inferred.getText() + method.getLocalName());
			cycle = 1;
		}
		cycle = 0;
		
		for (Resource method:cp.getRelativeBasicCodePattern().getUsedMethod_s()){
			if(cycle > 0)
				textArea_Basic.setText(textArea_Basic.getText() + " - ");
			textArea_Basic.setText(textArea_Basic.getText() + method.getLocalName());
			cycle = 1;
		}
	}

}
