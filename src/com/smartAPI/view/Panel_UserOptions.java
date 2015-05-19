package com.smartAPI.view;

import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import java.awt.Color;

/**
 * Pannello che mostra all'utente le operazioni che può effettuare
 * @author iolrin
 *
 */
public class Panel_UserOptions extends JPanel {

	/**
	 * Create the panel.
	 */
	public Panel_UserOptions() {
		setBackground(new Color(72, 209, 204));
		
		JButton VisualizzaUtenti = new JButton("Visualizza Utenti");
		VisualizzaUtenti.setBounds(387, 6, 123, 36);
		VisualizzaUtenti.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		setLayout(null);
		
		JButton Ricerca = new JButton("Ricerca");
		Ricerca.setBounds(17, 6, 123, 36);
		add(Ricerca);
		
		JButton Inserisci = new JButton("Inserisci");
		Inserisci.setBounds(210, 6, 107, 36);
		add(Inserisci);
		add(VisualizzaUtenti);

	}

}
