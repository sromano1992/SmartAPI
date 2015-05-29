package com.smartAPI.view;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

import java.awt.GridLayout;

import javax.swing.JTextArea;

import java.awt.Canvas;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.JButton;


public class Panel_CodePatternSetScore extends JPanel {
	private static Logger log = Logger.getLogger("global");
	private static int _MAX_SCORE = 10;
	private static int _MIN_SCORE = 0;
	private int storedScoreValue;
	private boolean storedScore;
	private ArrayList<JLabel> stars;
	/**
	 * Create the panel.
	 */
	public Panel_CodePatternSetScore() {
		storedScoreValue = 0;
		storedScore = false;
		stars = new ArrayList<JLabel>();
		setLayout(new GridLayout(1, _MAX_SCORE, 0, 0));
		String starGreyIco = this.getClass().getResource("res/grey_star.png").getFile();
		final String starIco = this.getClass().getResource("res/star.png").getFile();
		final ImageIcon picGrey = new ImageIcon(starGreyIco);
		final ImageIcon pic = new ImageIcon(starIco);

	    for (int i=0; i<=_MAX_SCORE; i++){
	    	final JLabelWithPosition j;
	    	if (i==0){
	    		j = new JLabelWithPosition(new ImageIcon(), -1);
	    		j.setVisible(true);
	    	}
	    	else{
	    		j = new JLabelWithPosition(picGrey, i);
	    	}
	    	j.setToolTipText("Click to set score");
	    	if(i==0){
	    		j.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {	
						for (int i=1; i<_MAX_SCORE+1; i++){
							stars.get(i).setIcon(picGrey);
						}
					}
					public void mouseExited(MouseEvent arg0) {
						if (!storedScore){
							for (int i=1; i<storedScoreValue; i++)
								stars.get(i).setIcon(pic);
							for (int i=storedScoreValue+1; i<_MAX_SCORE; i++){
								stars.get(i).setIcon(picGrey);
							}
						}
						storedScore = false;
					}				
					@Override
					public void mouseClicked(MouseEvent arg0) {
						

						storedScore = true;
						storedScoreValue = 0;
					}
		    	});
	    	}
		    else{
		    	j.addMouseListener(new MouseAdapter() {
					@Override
					public void mouseEntered(MouseEvent arg0) {					
						for (int i=1; i<=j.getPos(); i++)
							stars.get(i).setIcon(pic);
						for (int i=j.getPos()+1; i<_MAX_SCORE+1; i++){
							stars.get(i).setIcon(picGrey);
						}
					}
					public void mouseExited(MouseEvent arg0) {
						if (!storedScore){
							for (int i=1; i<storedScoreValue; i++)
								stars.get(i).setIcon(pic);
							for (int i=storedScoreValue+1; i<_MAX_SCORE+1; i++){
								stars.get(i).setIcon(picGrey);
							}
						}
						storedScore = false;
					}				
					@Override
					public void mouseClicked(MouseEvent arg0) {
						storedScore = true;
						storedScoreValue = j.getPos() ;
						System.out.println("storedScoreValue: "+storedScoreValue);

					}
		    	});
	    	}
	    	stars.add(j);
	    	add(j);
	    }
	}
}
