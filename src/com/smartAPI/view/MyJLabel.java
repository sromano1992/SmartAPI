package com.smartAPI.view;
import java.awt.Color;

import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class MyJLabel  extends JTextField{
	public MyJLabel(String input){
		this.setText(input);
		this.setOpaque(true);
		this.setHorizontalAlignment(SwingConstants.CENTER);
		this.setForeground(Color.WHITE);
		this.setBackground(new Color(2, 66, 96));
	}
	
}
