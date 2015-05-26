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
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import java.awt.Dimension;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;

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
		splitPane.setSize(new Dimension(0, 250));
		splitPane.setPreferredSize(new Dimension(193, 250));
		splitPane.setMinimumSize(new Dimension(193, 250));
		splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		add(splitPane, BorderLayout.CENTER);

		JPanel panel_CodePattern_s = new JPanel();
		splitPane.setRightComponent(panel_CodePattern_s);
		panel_CodePattern_s.setLayout(new GridLayout(0, 1, 0, 0));
		
		Panel_InferredCodePattern panel_InferredCodePattern = new Panel_InferredCodePattern();
		panel_CodePattern_s.add(panel_InferredCodePattern);
		
		JPanel panel = new JPanel();
		splitPane.setLeftComponent(panel);
		
		TreeView treeView = new TreeView();
		treeView.setBounds(0, 0, 398, 115);
		TreeView treeView_1 = new TreeView();
		treeView_1.setBounds(398, 0, 398, 115);
		treeView.setCodePattern_s(new SmartAPIModel().getAllCodePatternForCategory(), "Basic", false);
		
		treeView.addTreePathListener(this);
		treeView.addTreePathListener(treeView_1);
		panel.setLayout(null);
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
