package com.smartAPI.view;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingUtilities;

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

import sun.swing.SwingUtilities2;

import com.smartAPI.control.ISetScoreListener;
import com.smartAPI.model.Common;


public class Panel_CodePatternSetScore extends JPanel{
	private static Logger log = Logger.getLogger("global");
	private static int _MAX_SCORE = 10;
	private static int _MIN_SCORE = 0;
	private int storedScoreValue;
	private boolean storedScore;
	private ArrayList<JLabel> stars;
	private ArrayList<ISetScoreListener> listener_s;
	private boolean enableVotation;
	/**
	 * Create the panel.
	 */
	public Panel_CodePatternSetScore() {
		addControl_s(Common.CAN_SET_SCORE);	
	}
	public void restore(int votedStatus){
		removeAll();
		addControl_s(votedStatus);
		SwingUtilities.updateComponentTreeUI(this);
		this.setEnableVotation(true);
		storedScore = false;
	}
	
	private void addControl_s(int votedStatus) {
		if(votedStatus == Common.CAN_SET_SCORE){
			if (listener_s == null)
				listener_s = new ArrayList<ISetScoreListener>();
			storedScoreValue = 0;
			stars = new ArrayList<JLabel>();
			setLayout(new GridLayout(1, _MAX_SCORE, 0, 0));
			
			String starGreyIco = "res/grey_star.png";
			final MyImageIcon picGrey = new MyImageIcon(starGreyIco, 20, 20);
			
			String starIco = "res/star.png";
			final MyImageIcon pic = new MyImageIcon(starIco, 20, 20);
	
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
							if(isEnableVotation() && !storedScore){
								for (int i=1; i<_MAX_SCORE+1; i++){
									stars.get(i).setIcon(picGrey.getImageResponsive());
								}
							}
						}
						public void mouseExited(MouseEvent arg0) {
							if(isEnableVotation()){
								if (!storedScore){
									for (int i=1; i<storedScoreValue; i++)
										stars.get(i).setIcon(pic.getImageResponsive());
									for (int i=storedScoreValue+1; i<_MAX_SCORE; i++){
										stars.get(i).setIcon(picGrey.getImageResponsive());
									}
								}
							}
						}				
						@Override
						public void mouseClicked(MouseEvent arg0) {
							if(isEnableVotation()&& !storedScore){
								storedScore = true;
								storedScoreValue = 0;
							}
						}
			    	});
		    	}
			    else{
			    	j.addMouseListener(new MouseAdapter() {
						@Override
						public void mouseEntered(MouseEvent arg0) {		
							if(isEnableVotation() && !storedScore){
								for (int i=1; i<=j.getPos(); i++)
									stars.get(i).setIcon(pic.getImageResponsive());
								for (int i=j.getPos()+1; i<_MAX_SCORE+1; i++){
									stars.get(i).setIcon(picGrey.getImageResponsive());
								}
							}
						}
						public void mouseExited(MouseEvent arg0) {
							if(isEnableVotation()){	
								if (storedScore == false){
									for (int i=1; i<storedScoreValue; i++)
										stars.get(i).setIcon(pic.getImageResponsive());
									for (int i=storedScoreValue+1; i<_MAX_SCORE+1; i++){
										stars.get(i).setIcon(picGrey.getImageResponsive());
									}
								}
							}
						}				
						@Override
						public void mouseClicked(MouseEvent arg0) {
							if(isEnableVotation() && !storedScore){
								storedScore = true;
								storedScoreValue = j.getPos() ;
								for (ISetScoreListener listener : listener_s){
									listener.setScoreClicked(storedScoreValue);
								}
							}
						}
			    	});
		    	}
		    	stars.add(j);
		    	add(j);
		    }
		    for (int i=1; i<_MAX_SCORE+1; i++){
				stars.get(i).setIcon(picGrey.getImageResponsive());
			}
		}
		else if (votedStatus == Common.ALREADY_VOTED_STATUS){
			add(new JLabel("Hai già votato questo codePattern"));
		}
		else if (votedStatus == Common.IS_OWNER_STATUS){
			add(new JLabel("Non puoi votare un tuo code pattern"));			
		}
	}
	
	public void addListener(ISetScoreListener listener){
		listener_s.add(listener);
	}
	
	private boolean isEnableVotation() {
		return enableVotation;
	}
	
	private void setEnableVotation(boolean enableVotation) {
		this.enableVotation = enableVotation;
	}
}
