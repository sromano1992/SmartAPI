package com.smartAPI.test;

import java.awt.Dimension;

import javax.swing.JFrame;

import com.smartAPI.view.Panel_CodePatternScore;

/**
 * 
 * @author Simone Romamo - http://www.sromano.altervista.org
 *
 */
public class Test_viewScore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		JFrame j = new JFrame();
		j.add(new Panel_CodePatternScore(11));
		j.setVisible(true);
		j.setSize(new Dimension(400,100));
	}

}
