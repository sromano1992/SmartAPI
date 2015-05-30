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


public class Panel_InsertProject extends JPanel {
	private ArrayList<JCheckBox> chkBox_s;
	private JTextField textField_name;
	private RSyntaxTextArea textPane_description; 

	/**
	 * Create the panel.
	 */
	public Panel_InsertProject() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_1 = new JPanel();
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
		panel_5.add(panel);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{0, 0, 0};
		gbl_panel.rowHeights = new int[]{0, 0, 0};
		gbl_panel.columnWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JLabel lblName = new JLabel("Name:");
		GridBagConstraints gbc_lblName = new GridBagConstraints();
		gbc_lblName.insets = new Insets(0, 0, 5, 5);
		gbc_lblName.anchor = GridBagConstraints.EAST;
		gbc_lblName.gridx = 0;
		gbc_lblName.gridy = 0;
		panel.add(lblName, gbc_lblName);
		
		textField_name = new JTextField();
		GridBagConstraints gbc_textField_name = new GridBagConstraints();
		gbc_textField_name.fill = GridBagConstraints.HORIZONTAL;
		gbc_textField_name.weightx = 0.5;
		gbc_textField_name.insets = new Insets(0, 0, 5, 0);
		gbc_textField_name.gridx = 1;
		gbc_textField_name.gridy = 0;
		panel.add(textField_name, gbc_textField_name);
		textField_name.setColumns(10);
		
		JLabel lblDescription = new JLabel("Description:");
		GridBagConstraints gbc_lblDescription = new GridBagConstraints();
		gbc_lblDescription.insets = new Insets(0, 0, 0, 5);
		gbc_lblDescription.gridx = 0;
		gbc_lblDescription.gridy = 1;
		panel.add(lblDescription, gbc_lblDescription);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 1;
		gbc_scrollPane_1.gridy = 1;
		panel.add(scrollPane_1, gbc_scrollPane_1);
		
		textPane_description = new RSyntaxTextArea();
		textPane_description.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_NONE);
		scrollPane_1.setViewportView(textPane_description);
		
		JScrollPane scrollPane = new JScrollPane();
		panel_3.add(scrollPane, BorderLayout.EAST);
		final JPanel chkBoxPanel = new JPanel();
		chkBoxPanel.setBounds(0, 0, 80, 400);
		scrollPane.setViewportView(chkBoxPanel);
		
		JPanel panel_6 = new JPanel();
		panel_7.add(panel_6, BorderLayout.SOUTH);
		panel_6.setLayout(new GridLayout(0, 6, 0, 0));
		
		JLabel label = new JLabel("");
		panel_6.add(label);
		
		JLabel label_1 = new JLabel("");
		panel_6.add(label_1);
		
		JLabel label_2 = new JLabel("");
		panel_6.add(label_2);
		
		JLabel label_4 = new JLabel("");
		panel_6.add(label_4);
		
		final JLabel label_required = new JLabel("");
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
		chkBoxPanel.setLayout(new GridLayout((int) Math.round((categories.size() + 0.00)/4), 4, 0, 0));
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
