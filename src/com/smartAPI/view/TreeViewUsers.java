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
import com.smartAPI.model.Utente;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class TreeViewUsers extends JPanel implements TreePathListener{
	private JTree tree;
	private ArrayList<TreePathListener> treePathListener;
	private JScrollPane scrollPane;
	
	/**
	 * Create the panel.
	 */
	public TreeViewUsers() {
		setLayout(new BorderLayout(0, 0));
		this.treePathListener = new ArrayList<TreePathListener>();		
	}

	public void setUser_s(ArrayList<Utente> user_s, String rootName){
		DefaultMutableTreeNode rootNode = new DefaultMutableTreeNode(rootName);
		for (Utente tmp:user_s){
			DefaultMutableTreeNode us_node = new DefaultMutableTreeNode(tmp.getNome());
			rootNode.add(us_node);	
		}
		if (tree != null){
			this.remove(tree);
		}
		tree = new JTree(rootNode);
		add(new JScrollPane(tree));
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
		
	}
}
