package com.smartAPI.test;

import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.smartAPI.model.CodePattern_Category;
import com.smartAPI.model.SmartAPIModel;
import com.smartAPI.view.Panel_CodePatternCompleteView;
import com.smartAPI.view.TreeViewCP;

/**
 * 
 * @author Simone Romamo - http://www.sromano.altervista.org
 *
 */
public class Test_CodePatternCompleteView {
	public static void main(String[] args) {
		JFrame f = new JFrame();
		f.setSize(new Dimension(400,400));
		TreeViewCP myTree = new TreeViewCP();
		Panel_CodePatternCompleteView p = new Panel_CodePatternCompleteView();
		//myTree.setCodePattern_s(new SmartAPIModel().getAllCodePatternForCategory(), "Basic", false);
		
		
		f.add(p);
		f.setVisible(true);
	}
}
