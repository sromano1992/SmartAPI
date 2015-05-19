package com.smartAPI.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;

public class Panel_UserOptions extends JPanel {

	/**
	 * Create the panel.
	 */
	public Panel_UserOptions() {
		
		JButton VisualizzaUtenti = new JButton("Visualizza Utenti");
		VisualizzaUtenti.setBounds(300, 0, 144, 41);
		VisualizzaUtenti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		setLayout(null);
		
		JButton Ricerca = new JButton("Ricerca");
		Ricerca.setBounds(0, 0, 144, 41);
		add(Ricerca);
		
		JButton Inserisci = new JButton("Inserisci");
		Inserisci.setBounds(150, 0, 144, 41);
		add(Inserisci);
		add(VisualizzaUtenti);

	}

}
