package com.smartAPI.view;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.Border;
import javax.swing.tree.TreePath;

import org.apache.log4j.Logger;

import com.smartAPI.control.TreePathListener;
import com.smartAPI.model.SmartAPIModel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.GridLayout;

import javax.swing.JScrollPane;
import javax.swing.JSplitPane;

import java.awt.Dimension;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JFrame;
import javax.swing.ScrollPaneConstants;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

/**
 * 
 * @author Simone Romamo - http://www.sromano.altervista.org
 *
 */
public class Panel_CodePatternCompleteView extends JPanel implements TreePathListener{
	private static Logger log = Logger.getLogger("global");

	/**
	 * Create the panel.
	 */
	public Panel_CodePatternCompleteView() {
		setLayout(new BorderLayout(0, 0));
		
		JSplitPane splitPane = new JSplitPane();
		splitPane.setContinuousLayout(true);
	    splitPane.setOneTouchExpandable(true);
		add(splitPane, BorderLayout.CENTER);
		splitPane.setSize(new Dimension(0, 250));
		splitPane.setPreferredSize(new Dimension(193, 250));
		splitPane.setMinimumSize(new Dimension(193, 250));
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);		
		
		Panel_InferredCodePattern panel_InferredCodePattern = new Panel_InferredCodePattern();
		splitPane.setRightComponent(panel_InferredCodePattern);

		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		
		splitPane.setDividerLocation(75);
		
		TreeViewCP treeView = new TreeViewCP();
		TreeViewCP treeView_1 = new TreeViewCP();
		treeView.setCodePattern_s(new SmartAPIModel().getAllCodePatternForCategory(), "Basic", false);
		
		treeView.addTreePathListener(this);
		treeView.addTreePathListener(treeView_1);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		panel.add(treeView);
		panel.add(treeView_1);
		treeView.addTreePathListener(panel_InferredCodePattern.getPanel_ShowCodePattern());
		
		treeView_1.addTreePathListener(panel_InferredCodePattern.getPanel_ShowCodePattern_1());
	}

	@Override
	public void treePathChanged(TreePath t) {
		log.info("updating gui...");
		SwingUtilities.updateComponentTreeUI(this);
		Component c = getParent();
		while (c!=null){
			SwingUtilities.updateComponentTreeUI(this);
			c = c.getParent();
		}
	}
}
