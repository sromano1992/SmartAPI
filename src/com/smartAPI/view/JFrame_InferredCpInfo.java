package com.smartAPI.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JTextArea;

import com.hp.hpl.jena.rdf.model.Resource;
import com.smartAPI.model.CodePattern;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
/**
 * 
 * @author Simone Romamo - http://www.sromano.altervista.org
 *
 */
public class JFrame_InferredCpInfo extends JFrame {
	private JPanel contentPane;
	private JTextPane textPane_InferredCategory, textPane_Probability, textPane_RelativeBasic;
	private JTextArea textArea_CommonMethod = new JTextArea();
	private JLabel lblInferredCategory;
	private JLabel lblReliability;
	private JLabel lblRelativeBasic;
	private JLabel lblCommonMethods;

	/**
	 * Create the frame.
	 */
	public JFrame_InferredCpInfo() {
		setTitle("Inference informations");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 189);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		lblInferredCategory = new JLabel("Inferred Category:");
		lblInferredCategory.setFont(new Font("Sylfaen", Font.BOLD, 11));
		lblInferredCategory.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblInferredCategory);
		
		textPane_InferredCategory = new JTextPane();
		textPane_InferredCategory.setEditable(false);
		panel.add(textPane_InferredCategory);
		
		lblReliability = new JLabel("Reliability:");
		lblReliability.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblReliability.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblReliability);
		
		textPane_Probability = new JTextPane();
		textPane_Probability.setEditable(false);
		panel.add(textPane_Probability);
		
		lblRelativeBasic = new JLabel("Relative Basic Code Pattern:");
		lblRelativeBasic.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblRelativeBasic.setHorizontalAlignment(SwingConstants.RIGHT);
		panel.add(lblRelativeBasic);
		
		textPane_RelativeBasic = new JTextPane();
		textPane_RelativeBasic.setEditable(false);
		panel.add(textPane_RelativeBasic);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		textArea_CommonMethod = new JTextArea();
		textArea_CommonMethod.setEditable(false);
		panel_1.add(textArea_CommonMethod);
		
		lblCommonMethods = new JLabel("Common methods:");
		lblCommonMethods.setFont(new Font("Tahoma", Font.BOLD, 11));
		panel_1.add(lblCommonMethods, BorderLayout.NORTH);
	}
	
	public void setInferredCP(CodePattern cp, String cpCategory){
		textPane_InferredCategory.setText(cpCategory);
		textPane_Probability.setText(cp.getScore() + "");
		textPane_RelativeBasic.setText(cp.getRelativeBasicCodePattern().getResource().getLocalName());
		textArea_CommonMethod.setText("");
		int cycle = 0;
		for (Resource method:cp.getCommonWithBasic()){
			if(cycle > 0)
				textArea_CommonMethod.setText(textArea_CommonMethod.getText() + " - ");
			textArea_CommonMethod.setText(method.getLocalName());
			cycle = 1;
		}
	}

}
