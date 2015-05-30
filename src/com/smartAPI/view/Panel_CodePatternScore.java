package com.smartAPI.view;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;

import java.awt.GridLayout;

import javax.swing.JTextArea;

import java.awt.Canvas;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Panel_CodePatternScore extends JPanel {
	private static Logger log = Logger.getLogger("global");
	private static int _MAX_SCORE = 11;
	private static int _MIN_SCORE = 0;
	
	/**
	 * Create the panel.
	 */
	public void setScore(double score) {
		removeAll();
		if(score > _MAX_SCORE){
			log.severe("Max score is " + _MAX_SCORE + "; will be show " + _MAX_SCORE);
			score = _MAX_SCORE;
		}
		setLayout(new GridLayout(1, _MAX_SCORE, 0, 0));
		String starIco = this.getClass().getResource("res/star.png").getFile();
		ImageIcon pic = new ImageIcon(starIco);
	    for (int i=0; i<score; i++){
	    	add(new JLabel(pic));
	    }
	    for (int i=0; i<_MAX_SCORE-score; i++)
	    	add(new JLabel());
	    if(score == 0)
	    	add(new JLabel(""+ score));
	    else{
		    DecimalFormat df = new DecimalFormat("#.00");
		    add(new JLabel(""+df.format(score)));
	    }
	    SwingUtilities.updateComponentTreeUI(this);
	}

	public Panel_CodePatternScore() {
		log.info("Score not defined...will be showed 4 stars");
		setLayout(new GridLayout(1, _MAX_SCORE, 0, 0));
		
		String starIco = this.getClass().getResource("res/star.png").getFile();
		ImageIcon pic = new ImageIcon(starIco);
	    for (int i=0; i<4; i++){
	    	add(new JLabel(pic));
	    }
	    for (int i=0; i<_MAX_SCORE-4; i++)
	    	add(new JLabel());
	    add(new JLabel("4.2"));
	}
}
