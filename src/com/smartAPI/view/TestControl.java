package com.smartAPI.view;

import javax.swing.JFrame;

import com.smartAPI.model.SmartAPIModel;

public class TestControl {

	public static void main(String[] args) {
		SmartAPIModel model = new SmartAPIModel();
		JFrame frame = new JFrame();
		LoginGrafica login = new LoginGrafica();
		frame.add(login);
		frame.setVisible(true);
	}

}
