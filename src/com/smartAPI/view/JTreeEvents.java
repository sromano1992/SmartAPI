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
	
	  public JTreeEvents(SmartAPIModel model, boolean basic, JTreeEvents panel) {
	    setLayout(new BorderLayout());
	    if(basic) {
		    top = new DefaultMutableTreeNode("Basic");
		    this.panel = panel;
		    this.basic = basic;
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
   		
   		
	    /*
	    DefaultMutableTreeNode a = new DefaultMutableTreeNode("A");
	    top.add(a);
	    
	    a.add(new DefaultMutableTreeNode("A1"));
	    a.add(new DefaultMutableTreeNode("A2"));

	    DefaultMutableTreeNode b = new DefaultMutableTreeNode("B");
	    top.add(b);
	    
	    b.add(new DefaultMutableTreeNode("B1"));
	    b.add(new DefaultMutableTreeNode("B2"));
	    b.add(new DefaultMutableTreeNode("B3"));
	    */

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
	    
	    System.out.println(tp.getLastPathComponent().toString());	 
	    if(basic)
	    	aggiungiNodi(tp.getLastPathComponent().toString(), panel);
	}
	  
	  public void aggiungiNodi(String r, JTreeEvents tree) {
		  DefaultMutableTreeNode n = new DefaultMutableTreeNode(r);
 		  tree.getRoot().add(n);
 		  System.out.println("qui");
 		  tree.repaint();
	  }
	  
	  public DefaultMutableTreeNode getRoot() {
		  return top;
	  }
	  
	  
}