package com.smartAPI.view;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.tree.TreePath;

import org.apache.log4j.Logger;

import com.smartAPI.control.TreePathListener;
import com.smartAPI.model.SmartAPIModel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.GridLayout;

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
		
		JPanel panel = new JPanel();
		add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 2, 0, 0));
		
		TreeView treeView = new TreeView();
		panel.add(treeView);
		
		TreeView treeView_1 = new TreeView();
		panel.add(treeView_1);
		
		JPanel panel_CodePattern_s = new JPanel();
		add(panel_CodePattern_s, BorderLayout.CENTER);
		panel_CodePattern_s.setLayout(new GridLayout(0, 1, 0, 0));
		
		Panel_InferredCodePattern panel_InferredCodePattern = new Panel_InferredCodePattern();
		panel_CodePattern_s.add(panel_InferredCodePattern);

		treeView.addTreePathListener(panel_InferredCodePattern.getPanel_ShowCodePattern());
		treeView.addTreePathListener(treeView_1);
		
		treeView_1.addTreePathListener(panel_InferredCodePattern.getPanel_ShowCodePattern_1());
		treeView.setCodePattern_s(new SmartAPIModel().getAllCodePatternForCategory(), "Basic", false);
		
		treeView.addTreePathListener(this);
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
		SwingUtilities.updateComponentTreeUI(this.getParent());
	}
}
