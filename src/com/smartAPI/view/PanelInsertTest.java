package com.smartAPI.view;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class PanelInsertTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Panel_InsertCP window = new Panel_InsertCP();
					JFrame fr = new JFrame();
					fr.add(window);
					fr.setBounds(6, 6, 800, 600);
					fr.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
