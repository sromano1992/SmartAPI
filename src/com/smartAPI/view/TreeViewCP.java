package com.smartAPI.view;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import com.hp.hpl.jena.rdf.model.Resource;
import com.smartAPI.control.TreePathListener;
import com.smartAPI.model.CodePattern_Category;
import com.smartAPI.model.SmartAPIModel;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class TreeViewCP extends JPanel implements TreePathListener{
	private JTree tree;
	private ArrayList<TreePathListener> treePathListener;
	private JScrollPane scrollPane;
	private JScrollPane scroll;
	private ArrayList<CodePattern_Category> cp_s;
	
	/**
	 * Create the panel.
	 */
	public TreeViewCP() {
		setLayout(new BorderLayout(0, 0));
		this.treePathListener = new ArrayList<TreePathListener>();		
	}

	public void setCodePattern_s(ArrayList<CodePattern_Category> cp_s, String rootName, boolean inferred){
		this.cp_s = cp_s;
		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(rootName);
		for (CodePattern_Category tmp:cp_s){
			if(inferred){
				DefaultMutableTreeNode categoryNode = new DefaultMutableTreeNode(tmp.getCategoryName());
				for (int i=0; i<tmp.getInferredCodePattern().size(); i++){
					DefaultMutableTreeNode cp_instance = new DefaultMutableTreeNode(tmp.getInferredCodePattern().get(i).getResource().getLocalName());
					categoryNode.add(cp_instance);
				}
				rootNode.add(categoryNode);
			}
			else{	//all basic cp
				DefaultMutableTreeNode categoryNode = new DefaultMutableTreeNode(tmp.getCategoryName());
				for (int i=0; i<tmp.getBasicCodePattern().size(); i++){
					DefaultMutableTreeNode cp_instance = new DefaultMutableTreeNode(tmp.getBasicCodePattern().get(i).getResource().getLocalName());
					categoryNode.add(cp_instance);
				}
				rootNode.add(categoryNode);
			}
		}
		if (tree != null){
			this.remove(tree);
		}
		tree = new JTree(rootNode);
		if( scroll == null){
			scroll = new JScrollPane(tree);
			add(scroll);
		}
		else{
			this.remove(scroll);
			scroll = new JScrollPane(tree);
			add(scroll);
		}
		tree.addMouseListener(new MouseAdapter() {
		      public void mouseClicked(MouseEvent me) {
		    	  TreePath tp = tree.getPathForLocation(me.getX(), me.getY());
		    	    if (tp != null){
		    	    	for(TreePathListener t:treePathListener){
		    	    		t.treePathChanged(tp);
		    	    	}		    	      
		    	    }
		      }
	    });
	}
	
	public void addTreePathListener(TreePathListener o){
		treePathListener.add(o);
	}

	@Override
	/**
	 * When this event occur I've to get
	 * cp category from treePath and get the list
	 * of inferredCodePattern for same category.
	 */
	public void treePathChanged(TreePath t) {
		SmartAPIModel s = new SmartAPIModel();
		if(t.getPathCount() >= 2){
			CodePattern_Category cp_s = s.getPatternOfCategory(t.getPathComponent(1).toString());
			ArrayList<CodePattern_Category> tmp = new ArrayList<CodePattern_Category>();
			tmp.add(cp_s);
			setCodePattern_s(tmp, "Inferred", true);
		}		
	}

	public ArrayList<CodePattern_Category> getCp_s() {
		return cp_s;
	}	
}
