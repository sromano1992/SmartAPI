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
import javax.swing.border.BevelBorder;

import java.awt.SystemColor;

import javax.swing.border.LineBorder;
import javax.swing.tree.TreePath;

import com.smartAPI.control.TreePathListener;
import com.smartAPI.model.CodePattern;
import com.smartAPI.model.Common;
import com.smartAPI.model.SmartAPIModel;

import java.awt.Color;

public class Panel_ShowCodePattern extends JPanel implements TreePathListener{
	private MyJLabel labelUserName;
	private JTextPane txtpaneKeyWord;
	private JTextPane txtpnCode;
	/**
	 * Create the panel.
	 */
	public Panel_ShowCodePattern() {
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.CENTER);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[]{450, 0};
		gbl_panel.rowHeights = new int[] {200, 86, 0, 0, 0};
		gbl_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel.rowWeights = new double[]{0.0, 0.0, 1.0, 1.0, Double.MIN_VALUE};
		panel.setLayout(gbl_panel);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		panel.add(scrollPane, gbc_scrollPane);
		
		txtpnCode = new JTextPane();
		txtpnCode.setEditable(false);
		txtpnCode.setText("try {\r\n \r\n    ResultSet rs;\r\n    PreparedStatement ps = conn.prepareStatement( \r\n             \"SELECT i.*, j.* FROM Omega i, Zappa j WHERE i = ? AND j = ?\" );\r\n    // Nel prepared statement ps, i punti di domanda denotano le variabili in input,\r\n    // che possono essere passate attraverso una lista di parametri, per esempio.\r\n \r\n    // Il codice seguente sostituisce i punti di domanda con stringhe o interi.\r\n    // Il primo parametro indica la posizione in cui il valore va inserito, \r\n    // il secondo parametro \u00E8 il valore da inserire.\r\n    ps.setString(1, \"Poor Yorick\");\r\n    ps.setInt(2, 8008);\r\n \r\n    // Il ResultSet rs riceve la risposta del database.\r\n    rs = ps.executeQuery();\r\n    while ( rs.next() ) {\r\n       int numeroColonne = rs.getMetaData().getColumnCount();\r\n        for ( int i = 1 ; i <= numeroColonne ; i++ ) {\r\n           System.out.println( \"COLONNA \" + i + \" = \" + rs.getObject(i) );\r\n     }\r\n \r\n    rs.close();\r\n    ps.close();\r\n \r\n } catch (SQLException e) {\r\n    // gestione delle eccezioni\r\n }");
		scrollPane.setViewportView(txtpnCode);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 1;
		panel.add(scrollPane_1, gbc_scrollPane_1);
		
		txtpaneKeyWord = new JTextPane();
		txtpaneKeyWord.setEditable(false);
		txtpaneKeyWord.setText("Lorem Ipsum \u00E8 un testo segnaposto utilizzato nel settore della tipografia e della stampa. Lorem Ipsum \u00E8 considerato il testo segnaposto standard sin dal sedicesimo secolo, quando un anonimo tipografo prese una cassetta di caratteri e li assembl\u00F2 per preparare un testo campione. \u00C8 sopravvissuto non solo a pi\u00F9 di cinque secoli, ma anche al passaggio alla videoimpaginazione, pervenendoci sostanzialmente inalterato. Fu reso popolare, negli anni \u201960, con la diffusione dei fogli di caratteri trasferibili \u201CLetraset\u201D, che contenevano passaggi del Lorem Ipsum, e pi\u00F9 recentemente da software di impaginazione come Aldus PageMaker, che includeva versioni del Lorem Ipsum.");
		scrollPane_1.setViewportView(txtpaneKeyWord);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(SystemColor.activeCaption, 1, true));
		add(panel_1, BorderLayout.NORTH);
		panel_1.setLayout(new GridLayout(0, 5, 0, 0));
		
		labelUserName = new MyJLabel("Username");
		panel_1.add(labelUserName);
		
		JPanel panel_2 = new JPanel();
		add(panel_2, BorderLayout.SOUTH);
		panel_2.setLayout(new GridLayout(2, 1, 0, 0));
		
		Panel_CodePatternScore panel_CodePatternScore = new Panel_CodePatternScore();
		panel_2.add(panel_CodePatternScore);
		panel_CodePatternScore.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(153, 180, 209), SystemColor.inactiveCaption, null, null));
		
		JPanel panel_3 = new JPanel();
		panel_2.add(panel_3);
		
		MyJLabel mjlblVota = new MyJLabel("Username");
		mjlblVota.setOpaque(true);
		mjlblVota.setBackground(new Color(4, 113, 36));
		mjlblVota.setText("Vota");
		panel_3.add(mjlblVota);
		
		Panel_CodePatternSetScore panel_CodePatternSetScore = new Panel_CodePatternSetScore();
		panel_3.add(panel_CodePatternSetScore);

	}
	
	public void setCodePattern(CodePattern cp){
		labelUserName.setText(cp.getOwner());
		txtpnCode.setText(cp.getCode());
		txtpaneKeyWord.setText(cp.getKeyWord());
	}

	@Override
	public void treePathChanged(TreePath t) {
		if (t.getPathCount() == 3){	//selected a codePattern
			String cp = t.getPathComponent(2).toString();
			SmartAPIModel s = new SmartAPIModel();
			CodePattern c = new CodePattern(s.getResourceFromBase(Common.NS + cp));
			setCodePattern(c);
		}
	}


}
