package com.smartAPI.view;

import java.awt.BorderLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTree;
import javax.swing.ScrollPaneConstants;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import com.hp.hpl.jena.rdf.model.Resource;
import com.smartAPI.model.CodePattern;
import com.smartAPI.model.CodePattern_Category;
import com.smartAPI.model.SmartAPIModel;

/** 
 * 
 * @author Amedeo Leo
 *
 */

public class JTreeEvents extends JPanel {
	JTree tree;
	private JTextField jtf;
	private DefaultMutableTreeNode top;
	private DefaultTreeModel treeModel;  
	private JTreeEvents panel;
	private boolean basic = false;
	private SmartAPIModel model;
	
	  public JTreeEvents(SmartAPIModel model, boolean basic, JTreeEvents panel) {
	    setLayout(new BorderLayout());
	    this.model = model;
	    this.basic = basic;
	    if(basic) {
		    top = new DefaultMutableTreeNode("Basic");
		    this.panel = panel;
	   		ArrayList<Resource> categorie = model.getPatternCategory();
	   		for (Resource r : categorie) {
	   			DefaultMutableTreeNode n = new DefaultMutableTreeNode(r.getLocalName());
	   			top.add(n);
	   			CodePattern_Category cc = model.getPatternOfCategory(r.getLocalName());			
	   			//quando clicco su Storage o su s1,...,sn mi escono gli inferiti di storage
				for(CodePattern c1 : cc.getBasicCodePattern()) 
					n.add(new DefaultMutableTreeNode(c1.getResource().getLocalName()));
				
	   		}
	    }
   		else {
   			top = new DefaultMutableTreeNode("Inferred");
   		}
   		
	    tree = new JTree(top);

	    int v = ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED;
	    int h = ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED;
	    JScrollPane jsp = new JScrollPane(tree, v, h);

	    add(jsp, BorderLayout.CENTER);

	    jtf = new JTextField("", 20);
	    add(jtf, BorderLayout.SOUTH);
	    tree.addMouseListener(new MouseAdapter() {
	      public void mouseClicked(MouseEvent me) {
	        doMouseClicked(me);
	      }
	    });
	    
	    treeModel = (DefaultTreeModel) tree.getModel();
	  }

	  void doMouseClicked(MouseEvent me) {
	    TreePath tp = tree.getPathForLocation(me.getX(), me.getY());
	    if (tp != null)
	      jtf.setText(tp.toString());
	    else
	      jtf.setText("");
	    
	    if(basic) {
	    	if(tp.getLastPathComponent().toString().equals("Basic")) {
	    		return;
	    	}
	    	else
	    		aggiungiNodi(tp.getLastPathComponent().toString(), panel);
	    }
	}
	  
	  public void aggiungiNodi(String nomeNodo, JTreeEvents otherTree) {
		  DefaultMutableTreeNode n = null;
 		  
		  ArrayList<Resource> categorie = model.getPatternCategory();		  
		  for (Resource r : categorie) {
			  if(r.getLocalName().equals(nomeNodo)) {
	   			n = new DefaultMutableTreeNode(r.getLocalName());
	   			CodePattern_Category cc = model.getPatternOfCategory(r.getLocalName());			
				for(CodePattern c1 : cc.getInferredCodePattern()) 
					n.add(new DefaultMutableTreeNode(c1.getResource().getLocalName()));
	   		}
		  }
		  if(n != null) {
			  System.out.println(otherTree.getRoot().getChildCount());
			  otherTree.getRoot().removeAllChildren();
			  otherTree.remove(0);
			  otherTree.setTree(new JTree(new DefaultMutableTreeNode(nomeNodo)));
			  System.out.println("new tree");
			  otherTree.repaint();
			  otherTree.getRoot().add(n);
		  }
		  otherTree.repaint();
	  }
	  
	  public DefaultMutableTreeNode getRoot() {
		  return top;
	  }
	  
	  public void removeNodes() {
		  
	  }
	  
	  
	  public void setTree(JTree tree) {
		  this.tree = tree;
	  }
	  
	  
	  
}