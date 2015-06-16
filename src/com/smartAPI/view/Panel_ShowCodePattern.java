package com.smartAPI.view;

import javax.swing.JPanel;

import java.awt.GridLayout;
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.BoxLayout;

import java.awt.FlowLayout;
import java.awt.CardLayout;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.ScrollPaneConstants;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.border.BevelBorder;

import java.awt.SystemColor;

import javax.swing.border.LineBorder;
import javax.swing.tree.TreePath;

import com.smartAPI.control.ISetScoreListener;
import com.smartAPI.control.TreePathListener;
import com.smartAPI.model.CodePattern;
import com.smartAPI.model.CodePattern_Category;
import com.smartAPI.model.Common;
import com.smartAPI.model.SmartAPIModel;

import java.awt.Color;
import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.event.InputMethodListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.ImageIcon;

import org.apache.log4j.Logger;
import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;





import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;

public class Panel_ShowCodePattern extends JPanel implements TreePathListener, ISetScoreListener{
	private MyJLabel labelUserName;
	private JTextPane txtpaneKeyWord;
	private RSyntaxTextArea txtpnCode;
	private JButton infoButton;
	private CodePattern actualCP;
	private String actualCP_category;
	private MyJLabel mjlblVota;
	private Panel_CodePatternScore panel_CodePatternScore;
	private Panel_CodePatternSetScore panel_CodePatternSetScore;
	private Logger log;
	
	/**
	 * Create the panel.
	 */
	public Panel_ShowCodePattern(boolean enableVotation) {
		log = Logger.getLogger("global");
		setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setLayout(new BorderLayout(0, 0));
		
		JPanel panel_2 = new JPanel();
		add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		
		JPanel panel_1 = new JPanel();
		panel_2.add(panel_1, BorderLayout.NORTH);
		panel_1.setBorder(new LineBorder(SystemColor.activeCaption, 1, true));
		panel_1.setLayout(new GridLayout(0, 5, 0, 0));
		
		labelUserName = new MyJLabel("Username");
		panel_1.add(labelUserName);
		
		JLabel label_2 = new JLabel("");
		panel_1.add(label_2);
		
		JLabel label_1 = new JLabel("");
		panel_1.add(label_1);
		
		JLabel label = new JLabel("");
		panel_1.add(label);
		
		JPanel panel = new JPanel();
		panel_1.add(panel);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		infoButton = new JButton("");
		infoButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFrame_InferredCpInfo f = new JFrame_InferredCpInfo();
				f.setInferredCP(actualCP, actualCP_category, new SmartAPIModel().getMediaVotazioni(actualCP.getResource().getLocalName()));
				f.setVisible(true);
				Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
				f.setLocation(dim.width/2-f.getSize().width/2, dim.height/2-f.getSize().height/2);
				f.setResizable(false);
				f.setDefaultCloseOperation(f.DISPOSE_ON_CLOSE);
			}
		});
		infoButton.setIcon(new ImageIcon(Panel_ShowCodePattern.class.getResource("/com/smartAPI/view/res/questionMark.gif")));
		infoButton.setEnabled(false);
		infoButton.setVisible(false);
		
		JLabel label_3 = new JLabel("");
		panel.add(label_3);
		panel.add(infoButton);
		
		JPanel panel_5 = new JPanel();
		panel_2.add(panel_5, BorderLayout.CENTER);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{379, 0};
		gbl_panel_5.rowHeights = new int[] {191, 51, 0};
		gbl_panel_5.columnWeights = new double[]{0.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);
		
		JScrollPane scrollPane = new JScrollPane();
		GridBagConstraints gbc_scrollPane = new GridBagConstraints();
		gbc_scrollPane.weighty = 1.0;
		gbc_scrollPane.weightx = 1.0;
		gbc_scrollPane.fill = GridBagConstraints.BOTH;
		gbc_scrollPane.insets = new Insets(0, 0, 5, 0);
		gbc_scrollPane.gridx = 0;
		gbc_scrollPane.gridy = 0;
		
		txtpnCode = new RSyntaxTextArea(20, 60);
		txtpnCode.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
		txtpnCode.setCodeFoldingEnabled(true);
      	txtpnCode.setEditable(false);
      	RTextScrollPane sp = new RTextScrollPane(txtpnCode);
      	panel_5.add(sp, gbc_scrollPane);
		
		
		JScrollPane scrollPane_1 = new JScrollPane();
		GridBagConstraints gbc_scrollPane_1 = new GridBagConstraints();
		gbc_scrollPane_1.weighty = 1.0;
		gbc_scrollPane_1.weightx = 1.0;
		gbc_scrollPane_1.fill = GridBagConstraints.BOTH;
		gbc_scrollPane_1.gridx = 0;
		gbc_scrollPane_1.gridy = 1;
		panel_5.add(scrollPane_1, gbc_scrollPane_1);
		
		txtpaneKeyWord = new JTextPane();
		txtpaneKeyWord.setEditable(false);
		scrollPane_1.setViewportView(txtpaneKeyWord);
		
		JPanel panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new GridLayout(2, 1, 0, 0));
		
		JPanel panel_3 = new JPanel();
		panel_4.add(panel_3);
		panel_3.setLayout(new BorderLayout(0, 0));
		
		mjlblVota = new MyJLabel("Username");
		mjlblVota.setFont(new Font("Lucida Grande", Font.PLAIN, 11));
		
		mjlblVota.setOpaque(true);
		mjlblVota.setBackground(new Color(4, 113, 36));
		mjlblVota.setText("CLICK ON STARS TO VOTE");
		panel_3.add(mjlblVota, BorderLayout.WEST);
		
		panel_CodePatternSetScore = new Panel_CodePatternSetScore();
		panel_CodePatternSetScore.addListener(this);
		panel_3.add(panel_CodePatternSetScore);
		
		panel_CodePatternScore = new Panel_CodePatternScore();
		panel_4.add(panel_CodePatternScore);
		panel_CodePatternScore.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(153, 180, 209), SystemColor.inactiveCaption, null, null));
		
		if (!enableVotation){
			panel_4.setEnabled(false);
			panel_4.setVisible(false);
		}
	}
	
	public void setCodePattern(CodePattern cp){
		labelUserName.setText(cp.getOwner());
		txtpnCode.setText(cp.getCode());
		txtpaneKeyWord.setText(cp.getKeyWord());
		infoButton.setVisible(cp.getRelativeBasicCodePattern() != null);
		infoButton.setEnabled(cp.getRelativeBasicCodePattern() != null);
		panel_CodePatternScore.setScore(new SmartAPIModel().getMediaVotazioni(cp.getResource().getLocalName()));
		if(new SmartAPIModel().hasAlreadyVoted(Common.UTENTE.getNickname(), cp.getResource().getLocalName())){
			panel_CodePatternSetScore.restore(Common.ALREADY_VOTED_STATUS);
		}
		else if(new SmartAPIModel().isOwner(Common.UTENTE.getNickname(), cp.getResource().getLocalName())){
			panel_CodePatternSetScore.restore(Common.IS_OWNER_STATUS);
		}
		else
			panel_CodePatternSetScore.restore(Common.CAN_SET_SCORE);
		this.actualCP = cp;
		log.info("Setted cp: " + cp.getResource().getLocalName() + " with methods " + cp.getUsedMethod_s());
	}

	@Override
	public void treePathChanged(TreePath t) {
		if (t.getPathCount() == 3){	//selected a codePattern
			String cp = t.getPathComponent(2).toString();
			SmartAPIModel s = new SmartAPIModel();
			CodePattern cpToSearch = new CodePattern(s.getResourceFromBase(Common.NS + cp));
			/**
			 * getResFromBase will return only codePatter without information about
			 * inferred and relative basic method; with getPatternOfCategory
			 * I get infomation all information about cp of some category;
			 */
			actualCP_category = t.getPathComponent(1).toString();
			CodePattern_Category patternOfSameCat = s.getPatternOfCategory(t.getPathComponent(1).toString());
			for (CodePattern c : patternOfSameCat.getInferredCodePattern()){
				if (c.getResource().getLocalName().equals(cpToSearch.getResource().getLocalName())){
					cpToSearch = c;
				}
			}
			setCodePattern(cpToSearch);
		}
	}

	@Override
	public void setScoreClicked(int storedScoreValue) {
		new SmartAPIModel().aggiungiVotoCodePattern(Common.UTENTE.getNickname(), actualCP.getResource().getLocalName(), storedScoreValue + "");
		panel_CodePatternScore.setScore(new SmartAPIModel().getMediaVotazioni(actualCP.getResource().getLocalName()));
	}
}
