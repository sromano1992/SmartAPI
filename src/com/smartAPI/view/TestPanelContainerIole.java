package com.smartAPI.view;

import javax.swing.JFrame;

public class TestPanelContainerIole {

	public static void main (String[] args){
		Test_JPanelContainer t = new Test_JPanelContainer();
		JFrame f = new JFrame();
		f.add(t);
		f.setVisible(true);
		f.setSize(500, 500);
	}
}
