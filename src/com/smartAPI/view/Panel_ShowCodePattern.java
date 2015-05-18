package com.smartAPI.view;

import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;
import java.awt.FlowLayout;
import java.awt.CardLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ScrollPaneConstants;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JTextField;
import javax.swing.JTextPane;

public class Panel_ShowCodePattern extends JPanel {

	/**
	 * Create the panel.
	 */
	public Panel_ShowCodePattern() {
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{450, 0};
		gbl_panel.rowHeights = new int[] {200, 86, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel.add(scrollPane, gbc_scrollPane);
		
		JTextPane txtpnTry = new JTextPane();
		txtpnTry.setEditable(false);
		txtpnTry.setText("try {\r\n \r\n    ResultSet rs;\r\n    PreparedStatement ps = conn.prepareStatement( \r\n             \"SELECT i.*, j.* FROM Omega i, Zappa j WHERE i = ? AND j = ?\" );\r\n    // Nel prepared statement ps, i punti di domanda denotano le variabili in input,\r\n    // che possono essere passate attraverso una lista di parametri, per esempio.\r\n \r\n    // Il codice seguente sostituisce i punti di domanda con stringhe o interi.\r\n    // Il primo parametro indica la posizione in cui il valore va inserito, \r\n    // il secondo parametro \u00E8 il valore da inserire.\r\n    ps.setString(1, \"Poor Yorick\");\r\n    ps.setInt(2, 8008);\r\n \r\n    // Il ResultSet rs riceve la risposta del database.\r\n    rs = ps.executeQuery();\r\n    while ( rs.next() ) {\r\n       int numeroColonne = rs.getMetaData().getColumnCount();\r\n        for ( int i = 1 ; i <= numeroColonne ; i++ ) {\r\n           System.out.println( \"COLONNA \" + i + \" = \" + rs.getObject(i) );\r\n     }\r\n \r\n    rs.close();\r\n    ps.close();\r\n \r\n } catch (SQLException e) {\r\n    // gestione delle eccezioni\r\n }");
		scrollPane.setViewportView(txtpnTry);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 1;
		panel.add(scrollPane_1, gbc_scrollPane_1);
		
		JTextPane txtpaneCode = new JTextPane();
		txtpaneCode.setEditable(false);
		txtpaneCode.setText("Lorem Ipsum \u00E8 un testo segnaposto utilizzato nel settore della tipografia e della stampa. Lorem Ipsum \u00E8 considerato il testo segnaposto standard sin dal sedicesimo secolo, quando un anonimo tipografo prese una cassetta di caratteri e li assembl\u00F2 per preparare un testo campione. \u00C8 sopravvissuto non solo a pi\u00F9 di cinque secoli, ma anche al passaggio alla videoimpaginazione, pervenendoci sostanzialmente inalterato. Fu reso popolare, negli anni \u201960, con la diffusione dei fogli di caratteri trasferibili \u201CLetraset\u201D, che contenevano passaggi del Lorem Ipsum, e pi\u00F9 recentemente da software di impaginazione come Aldus PageMaker, che includeva versioni del Lorem Ipsum.");
		scrollPane_1.setViewportView(txtpaneCode);
		
		JPanel panel_1 = new JPanel();
		add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new GridLayout(0, 5, 0, 0));
		
		JLabel labelUserName = new JLabel("Username");
		panel_1.add(labelUserName);

	}
}
