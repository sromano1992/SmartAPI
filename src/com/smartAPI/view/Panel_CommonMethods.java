package com.smartAPI.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import java.awt.GridLayout;
import javax.swing.JTextArea;

public class Panel_CommonMethods extends JPanel {

	/**
	 * Create the panel.
	 */
	public Panel_CommonMethods() {
		setLayout(new GridLayout(0, 1, 0, 0));
		
		JTextArea txtrCommonMethods = new JTextArea();
		txtrCommonMethods.setText("Common methods");
		txtrCommonMethods.setEditable(false);
		add(txtrCommonMethods);

	}

}
