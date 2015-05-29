package com.smartAPI.view;

import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingUtilities;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.MutableTreeNode;
import javax.swing.tree.TreePath;

import org.apache.log4j.Logger;

import com.fasterxml.jackson.core.TreeNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.smartAPI.control.TreePathListener;
import com.smartAPI.model.CodePattern_Category;
import com.smartAPI.model.Common;
import com.smartAPI.model.Project;
import com.smartAPI.model.SmartAPIModel;
import com.smartAPI.model.Utente;
import com.sun.java.swing.SwingUtilities3;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class TreeViewProject extends JPanel implements TreePathListener{
	private JTree tree;
	private ArrayList<TreePathListener> treePathListener;
	private JScrollPane scrollPane;
	private JPopupMenu p_menu;
	private JMenuItem remItem;
	private JScrollPane scroll;
	private TreePath toRemoveNode;
	private DefaultTreeModel model = null; //(DefaultTreeModel)tree.getModel();
	private DefaultMutableTreeNode rootNode = null; //(DefaultMutableTreeNode)model.getRoot();
	private static Logger log = Logger.getLogger("global");
	
	/**
	 * Create the panel.
	 */
	public TreeViewProject() {
		setLayout(new BorderLayout(0, 0));
		this.treePathListener = new ArrayList<TreePathListener>();		
		p_menu = new JPopupMenu("test");
		remItem = new JMenuItem("Remove");
		p_menu.add(remItem);
	}

	public void setProject_s(ArrayList<Project> project_s, String rootName){
		log.info("Adding " + project_s.size() + " projects...");
		rootNode = new DefaultMutableTreeNode(rootName);
		for (Project tmp:project_s){
			DefaultMutableTreeNode us_node = new DefaultMutableTreeNode(tmp.getName());
			rootNode.add(us_node);	
		}
		
		if (tree != null){
			this.remove(tree);
		}
		tree = new JTree(rootNode);
		model = (DefaultTreeModel)tree.getModel();
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
		if (Common.UTENTE.isAdmin()){
			tree.addMouseListener(new MouseAdapter() {			
				@Override
				public void mouseReleased(MouseEvent arg0) {
					if (arg0.getButton() == 3){
						if(arg0.isPopupTrigger()){
							TreePath tp = tree.getPathForLocation(arg0.getX(), arg0.getY());
							toRemoveNode = tp;
							tree.setSelectionPath(tp);
							String me = toRemoveNode.getLastPathComponent().toString();
							String user = tp.getPathComponent(0).toString();
							if (tp.getPathCount() > 0 && !me.equals(Common.UTENTE.getNickname()) && !me.equals(user))
								p_menu.show(arg0.getComponent(), arg0.getX(), arg0.getY());
						}
					}
				}			
				@Override
				public void mousePressed(MouseEvent arg0) {
					if (arg0.getButton() == 3){
						TreePath tp = tree.getPathForLocation(arg0.getX(), arg0.getY());
						toRemoveNode = tp;
						tree.setSelectionPath(tp);
						String me = toRemoveNode.getLastPathComponent().toString();
						String user = tp.getPathComponent(0).toString();
						if (tp.getPathCount() > 0 && !me.equals(Common.UTENTE.getNickname()) && !me.equals(user))
							p_menu.show(arg0.getComponent(), arg0.getX(), arg0.getY());
					}
				}
			});
			
			remItem.addActionListener(new ActionListener() {				
				@Override
				public void actionPerformed(ActionEvent arg0) {
					SmartAPIModel s = new SmartAPIModel();
					Utente toRemove = s.getUtente(toRemoveNode.getPathComponent(1).toString());
					s.deleteUser(toRemove.getNickname());
					DefaultMutableTreeNode node = (DefaultMutableTreeNode)toRemoveNode.getLastPathComponent();
					//int index = model.getIndexOfChild(rootNode, node);
					rootNode.remove(node);
					//tree.removeSelectionPath(toRemoveNode);
					model.reload();
					ShowUsersInfo.userField.setText(" ");
					ShowUsersInfo.emailField.setText(" ");
					ShowUsersInfo.surnameField.setText(" ");
					ShowUsersInfo.nameField.setText(" ");
					
					String path="res/nouser.png";
					String pathIcon = getClass().getResource(path).getFile();
					MyImageIcon imgicon = new MyImageIcon(pathIcon,80,70);
					ShowUsersInfo.lblImage.setIcon(imgicon.getImageResponsive());
					
					//tree.update(getGraphics());
				}
			});
			model.reload();
			SwingUtilities.updateComponentTreeUI(this);
		}
		
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
