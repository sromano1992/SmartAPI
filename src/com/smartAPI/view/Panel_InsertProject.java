package com.smartAPI.view;

import javax.swing.JPanel;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;

import java.awt.BorderLayout;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;

import com.hp.hpl.jena.rdf.model.Resource;
import com.smartAPI.model.SmartAPIModel;

import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.util.ArrayList;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.UIManager;
import javax.swing.border.LineBorder;

import java.awt.Dimension;
import java.awt.Component;
import java.awt.Font;


public class Panel_InsertProject extends JPanel {
	private ArrayList<JCheckBox> chkBox_s;
	private JTextField textField_name;
	private RSyntaxTextArea textPane_description; 
	private Border border;

	/**
	 * Create the panel.
	 */
	public Panel_InsertProject() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
		border = BorderFactory.createLineBorder(new Color(228, 230, 235), 0);
		panel_1.setBorder(border);
		panel_1.setBackground(new Color(228, 230, 235));
		add(panel_1, BorderLayout.NORTH);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(1, 0, 0, 0));
		
		JPanel panel_7 = new JPanel();
		panel_2.add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_7.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		JPanel panel_5 = new JPanel();
		panel_3.add(panel_5, BorderLayout.CENTER);
		panel_5.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		//panel.setBorder(new EmptyBorder(10, 10, 10, 10) );
		
		panel.setBackground(new Color(228, 230, 235));
		panel_5.add(panel);
		panel.setLayout(null);
		
		
		MyJLabel lblName = new MyJLabel("*Name");
		lblName.setBounds(26, 3, 56, 22);
		lblName.setAlignmentY(Component.TOP_ALIGNMENT);
		lblName.setBackground(new Color(231, 76, 60));
		panel.add(lblName);
		
		textField_name = new JTextField();
		textField_name.setBounds(82, 0, 364, 28);
		panel.add(textField_name);
		textField_name.setColumns(10);
		
		MyJLabel lblDescription = new MyJLabel("Description:");
		lblDescription.setText("*Description");
		lblDescription.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		lblDescription.setBackground(new Color(231, 76, 60));
		lblDescription.setBounds(0, 136, 80, 22);
		panel.add(lblDescription);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(82, 28, 364, 233);
		panel.add(scrollPane_1);
		
		textPane_description = new RSyntaxTextArea();
		textPane_description.setTabSize(4);
		border = BorderFactory.createLineBorder(new Color(228, 230, 235), 0);
		textPane_description.setBorder(border);
		textPane_description.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_NONE);
		scrollPane_1.setViewportView(textPane_description);
		
		JScrollPane scrollPane = new JScrollPane();
		border = BorderFactory.createLineBorder(new Color(228, 230, 235), 1);
		scrollPane.setBorder(border);
		panel_3.add(scrollPane, BorderLayout.EAST);
		final JPanel chkBoxPanel = new JPanel();
		chkBoxPanel.setBounds(0, 0, 80, 400);
		scrollPane.setViewportView(chkBoxPanel);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(228, 230, 235));
		panel_7.add(panel_6, BorderLayout.SOUTH);
		panel_6.setLayout(new GridLayout(0, 6, 0, 0));
		
		JLabel label = new JLabel("");
		label.setBackground(new Color(228, 230, 235));
		label.setOpaque(true);
		panel_6.add(label);
		
		JLabel label_1 = new JLabel("");
		label_1.setBackground(new Color(228, 230, 235));
		label_1.setOpaque(true);
		panel_6.add(label_1);
		
		JLabel label_2 = new JLabel("");
		label_2.setBackground(new Color(228, 230, 235));
		label_2.setOpaque(true);
		panel_6.add(label_2);
		
		JLabel label_4 = new JLabel("");
		label_4.setBackground(new Color(228, 230, 235));
		label_4.setOpaque(true);
		panel_6.add(label_4);
		
		final JLabel label_required = new JLabel("");
		label_required.setBackground(new Color(228, 230, 235));
		label_required.setOpaque(true);
		label_required.setForeground(UIManager.getColor("ToolBar.dockingForeground"));
		panel_6.add(label_required);
		
		JButton button = new JButton("Add");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int status = 0;
				if (textField_name.getText().length() == 0){
					status = 1;
					Border border = BorderFactory.createLineBorder(Color.red);
					textField_name.setBorder(border);
				}
				if (textPane_description.getText().length() == 0){
					status = 2;
					Border border = BorderFactory.createLineBorder(Color.red);
					textPane_description.setBorder(border);
				}
				if (noCategoryChecked()){
					status = 3;
					Border border = BorderFactory.createLineBorder(Color.red);
					chkBoxPanel.setBorder(border);
				}
				if (status > 0){
					label_required.setVisible(true);
					label_required.setForeground(Color.red);
					label_required.setText("Add required information");
				}
				else{
					label_required.setVisible(false);
					ArrayList<String> categories = new ArrayList<String>();
					for (JCheckBox c:chkBox_s)
						if (c.isSelected())
							categories.add(c.getText());
					SmartAPIModel s = new SmartAPIModel();
					if (!s.addProject(textField_name.getText(), textPane_description.getText(), categories)){
						label_required.setVisible(true);
						label_required.setForeground(Color.red);
						label_required.setText("Project already in kb");
					}
					else{
						label_required.setVisible(true);
						label_required.setForeground(Color.green);
						Border border = BorderFactory.createLineBorder(Color.white);
						textPane_description.setBorder(border);
						textField_name.setBorder(border);
						label_required.setText("Project added");
					}
				}
			}
			
			/**
			 * Return true if no category has been selected
			 * @return
			 */
			private boolean noCategoryChecked() {
				for (JCheckBox c:chkBox_s)
					if (c.isSelected())
						return false;
				return true;
			}
		});
		panel_6.add(button);
		
		
		SmartAPIModel s = new SmartAPIModel();
		ArrayList<Resource> categories = s.getPatternCategory();
		//chkBoxPanel.setLayout(new GridLayout((int) Math.round((categories.size() + 0.00)/4), 4, 0, 0));
		chkBoxPanel.setBackground(new Color(228, 230, 235));
		border = BorderFactory.createLineBorder(new Color(228, 230, 235), 1);
		chkBoxPanel.setBorder(border);
		this.chkBox_s = new ArrayList<JCheckBox>();
		for (int i=0; i<categories.size(); i++){
			JCheckBox toAdd = new JCheckBox(categories.get(i).getLocalName());
			chkBoxPanel.add(toAdd);
			chkBox_s.add(toAdd);
		}


	}
	
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(300, 400);
		f.setVisible(true);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
		f.getContentPane().add(new Panel_InsertProject());
	}
}
