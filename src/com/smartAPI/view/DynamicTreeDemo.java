package com.smartAPI.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeModelEvent;
import javax.swing.event.TreeModelListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import com.hp.hpl.jena.rdf.model.Resource;
import com.smartAPI.model.CodePattern;
import com.smartAPI.model.CodePattern_Category;
import com.smartAPI.model.SmartAPIModel;

public class DynamicTreeDemo extends JPanel implements ActionListener {
	 
	private static final long serialVersionUID = 1L;
	private int newNodeSuffix = 1;
   	private String ADD_COMMAND = "add";
   	private String REMOVE_COMMAND = "remove";
   	private String CLEAR_COMMAND = "clear";
   	private DynamicTree treePanel;
   	private JFrame frame;
   	private SmartAPIModel model;

   	public DynamicTreeDemo(JFrame frame, JButton removeButton, SmartAPIModel model) {
   		super(new BorderLayout());
   		this.frame = frame;
   		this.model = model;

   	    // Create the components.
   	    treePanel = new DynamicTree();
   	    populateTree(treePanel);

   	    removeButton.setActionCommand(REMOVE_COMMAND);
   	    removeButton.addActionListener(this);

   	    JButton clearButton = new JButton("Clear");
   	    clearButton.setActionCommand(CLEAR_COMMAND);
   	    clearButton.addActionListener(this);

   	    // Lay everything out.
   	    treePanel.setPreferredSize(new Dimension(300, 150));
   	    add(treePanel, BorderLayout.CENTER);

   	}

   	public void populateTree(DynamicTree treePanel) {
   		ArrayList<Resource> categorie = model.getPatternCategory();
   		
   		ArrayList<DefaultMutableTreeNode> nodi = new ArrayList<DefaultMutableTreeNode>();
   		for (Resource r : categorie) {
   			DefaultMutableTreeNode n;
   			n = treePanel.addObject(null, r.getLocalName());
   			nodi.add(n);
   			System.out.println(r.getLocalName());
   			CodePattern_Category cc = model.getPatternOfCategory(r.getLocalName());
   			System.out.println(cc.getInferredCodePattern());
			for(CodePattern c : cc.getInferredCodePattern()) {
				treePanel.addObject(n, c.getResource().getLocalName());
			}
			for(CodePattern c1 : cc.getBasicCodePattern()) 
				treePanel.addObject(n, c1.getResource().getLocalName());
			
   		}
   		
   		/*
   		String p1Name = new String("Parent 1");
   	    String p2Name = new String("Parent 2");
   	    String c1Name = new String("Child 1");
   	    String c2Name = new String("Child 2");

   	    DefaultMutableTreeNode p1, p2;

   	    p1 = treePanel.addObject(null, p1Name);
   	    p2 = treePanel.addObject(null, p2Name);

   	    treePanel.addObject(p1, c1Name);
   	    treePanel.addObject(p1, c2Name);

   	    treePanel.addObject(p2, c1Name);
   	    treePanel.addObject(p2, c2Name);
   	    */
   	  }

   	  public void actionPerformed(ActionEvent e) {
   	    String command = e.getActionCommand();

   	    if (ADD_COMMAND.equals(command)) {
   	      treePanel.addObject("New Node " + newNodeSuffix++);
   	    } else if (REMOVE_COMMAND.equals(command)) {
   	      treePanel.removeCurrentNode();
   	    } else if (CLEAR_COMMAND.equals(command)) {
   	      treePanel.clear();
   	    }
   	  }

   	  private void createAndShowGUI(JFrame frame, JButton button, SmartAPIModel model) {   	   
   	    DynamicTreeDemo newContentPane = new DynamicTreeDemo(frame, button, model);
   	    newContentPane.setOpaque(true);
   	    frame.setContentPane(newContentPane);
   	  }
   	  
   	  class DynamicTree extends JPanel {
   		  protected DefaultMutableTreeNode rootNode;
   		  protected DefaultTreeModel treeModel;
   		  protected JTree tree;
   		  private Toolkit toolkit = Toolkit.getDefaultToolkit();

   		  public DynamicTree() {
   		    super(new GridLayout(1, 0));

   		    rootNode = new DefaultMutableTreeNode("Root Node");
   		    treeModel = new DefaultTreeModel(rootNode);

   		    tree = new JTree(treeModel);
   		    tree.setEditable(true);
   		    tree.getSelectionModel().setSelectionMode(
   		        TreeSelectionModel.SINGLE_TREE_SELECTION);
   		    tree.setShowsRootHandles(true);

   		    JScrollPane scrollPane = new JScrollPane(tree);
   		    add(scrollPane);
   		  }

   		  /** Remove all nodes except the root node. */
   		  public void clear() {
   		    rootNode.removeAllChildren();
   		    treeModel.reload();
   		  }

   		  /** Remove the currently selected node. */
   		  public void removeCurrentNode() {
   		    TreePath currentSelection = tree.getSelectionPath();
   		    if (currentSelection != null) {
   		      DefaultMutableTreeNode currentNode = (DefaultMutableTreeNode) (currentSelection
   		          .getLastPathComponent());
   		      MutableTreeNode parent = (MutableTreeNode) (currentNode.getParent());
   		      if (parent != null) {
   		        treeModel.removeNodeFromParent(currentNode);
   		        return;
   		      }
   		    }

   		    // Either there was no selection, or the root was selected.
   		    toolkit.beep();
   		  }

   		  /** Add child to the currently selected node. */
   		  public DefaultMutableTreeNode addObject(Object child) {
   		    DefaultMutableTreeNode parentNode = null;
   		    TreePath parentPath = tree.getSelectionPath();

   		    if (parentPath == null) {
   		      parentNode = rootNode;
   		    } else {
   		      parentNode = (DefaultMutableTreeNode) (parentPath.getLastPathComponent());
   		    }

   		    return addObject(parentNode, child, true);
   		  }

   		  public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent,
   		      Object child) {
   		    return addObject(parent, child, false);
   		  }

   		  public DefaultMutableTreeNode addObject(DefaultMutableTreeNode parent,
   		      Object child, boolean shouldBeVisible) {
   		    DefaultMutableTreeNode childNode = new DefaultMutableTreeNode(child);

   		    if (parent == null) {
   		      parent = rootNode;
   		    }

   		    // It is key to invoke this on the TreeModel, and NOT DefaultMutableTreeNode
   		    treeModel.insertNodeInto(childNode, parent, parent.getChildCount());

   		    // Make sure the user can see the lovely new node.
   		    if (shouldBeVisible) {
   		      tree.scrollPathToVisible(new TreePath(childNode.getPath()));
   		    }
   		    return childNode;
   		  }

   		  class MyTreeModelListener implements TreeModelListener {
   		    public void treeNodesChanged(TreeModelEvent e) {
   		      DefaultMutableTreeNode node;
   		      node = (DefaultMutableTreeNode) (e.getTreePath().getLastPathComponent());

   		      /*
   		       * If the event lists children, then the changed node is the child of the
   		       * node we've already gotten. Otherwise, the changed node and the
   		       * specified node are the same.
   		       */

   		      int index = e.getChildIndices()[0];
   		      node = (DefaultMutableTreeNode) (node.getChildAt(index));
   		    }

   		    public void treeNodesInserted(TreeModelEvent e) {
   		    }

   		    public void treeNodesRemoved(TreeModelEvent e) {
   		    }

   		    public void treeStructureChanged(TreeModelEvent e) {
   		    }
   		  }
   		}
   	}