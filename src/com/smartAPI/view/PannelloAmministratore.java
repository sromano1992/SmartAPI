package com.smartAPI.view;

import javax.swing.JFrame;

import com.smartAPI.model.SmartAPIModel;
import com.smartAPI.model.Utente;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.LayoutStyle.ComponentPlacement;
import java.util.ArrayList;
import java.util.Vector;
import java.awt.BorderLayout;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;

import java.awt.Color;

/** 
 * 
 * @author Amedeo Leo
 *
 */

public class PannelloAmministratore extends JFrame {

	private static final long serialVersionUID = 1L;
	private SmartAPIModel model;
	private JTable table;
	private KeyListener tableKeyListener;
	private MouseListener tableMouseListener;
	private boolean pressingCTRL=false;
	ArrayList<Integer> selectedCells = new ArrayList<Integer>();
	
	public PannelloAmministratore(SmartAPIModel model) {
		setSize(740,670);
		setVisible(true);
		setTitle("Pannello amministratore");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.model = model;
		aggiungi();
		initialize();
	}
	
	private void initialize() {	
		JPanel panel = new JPanel();
		
		JPanel panel_1 = new JPanel();
		
		JLabel label = new JLabel("Label per errori o conferme");
		label.setForeground(Color.RED);
		
		JButton button = new JButton("Elimina");
		GroupLayout gl_panel_1 = new GroupLayout(panel_1);
		gl_panel_1.setHorizontalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 674, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addComponent(label)
					.addPreferredGap(ComponentPlacement.RELATED, 437, Short.MAX_VALUE)
					.addComponent(button, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_1.setVerticalGroup(
			gl_panel_1.createParallelGroup(Alignment.LEADING)
				.addGap(0, 44, Short.MAX_VALUE)
				.addGroup(gl_panel_1.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
						.addComponent(label, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addComponent(button, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_1.setLayout(gl_panel_1);
		
		JButton button_1 = new JButton("Elimina");
		
		
		JPanel panel_3 = new JPanel();
		
		JLabel label_1 = new JLabel("Label per errori o conferme");
		label_1.setForeground(Color.RED);
		
		GroupLayout gl_panel_3 = new GroupLayout(panel_3);
		gl_panel_3.setHorizontalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 674, Short.MAX_VALUE)
				.addGap(0, 674, Short.MAX_VALUE)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addComponent(label_1)
					.addPreferredGap(ComponentPlacement.RELATED, 437, Short.MAX_VALUE)
					.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		gl_panel_3.setVerticalGroup(
			gl_panel_3.createParallelGroup(Alignment.LEADING)
				.addGap(0, 44, Short.MAX_VALUE)
				.addGap(0, 44, Short.MAX_VALUE)
				.addGroup(gl_panel_3.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
						.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 22, Short.MAX_VALUE)
						.addComponent(button_1, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE))
					.addContainerGap())
		);
		panel_3.setLayout(gl_panel_3);
		
		JPanel panel_2 = new JPanel();
		
		JTreeEvents treeEvents_1 = new JTreeEvents(model, false, null);
		JTreeEvents treeEvents = new JTreeEvents(model, true, treeEvents_1);
		
		
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
						.addComponent(panel, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
						.addComponent(panel_1, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE)
						.addGroup(Alignment.LEADING, groupLayout.createSequentialGroup()
							.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(treeEvents_1, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE))
						.addComponent(panel_3, GroupLayout.DEFAULT_SIZE, 722, Short.MAX_VALUE))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGap(28)
					.addComponent(panel, GroupLayout.PREFERRED_SIZE, 217, GroupLayout.PREFERRED_SIZE)
					.addGap(11)
					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(18)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(panel_2, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(18))
						.addGroup(groupLayout.createSequentialGroup()
							.addComponent(treeEvents_1, GroupLayout.PREFERRED_SIZE, 212, GroupLayout.PREFERRED_SIZE)
							.addPreferredGap(ComponentPlacement.RELATED)))
					.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 44, GroupLayout.PREFERRED_SIZE)
					.addGap(28))
		);
		
		JPanel panel_4 = new JPanel();
		GroupLayout gl_panel_2 = new GroupLayout(panel_2);
		gl_panel_2.setHorizontalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel_2.createSequentialGroup()
					.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 335, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(379, Short.MAX_VALUE))
		);
		gl_panel_2.setVerticalGroup(
			gl_panel_2.createParallelGroup(Alignment.LEADING)
				.addComponent(panel_4, GroupLayout.DEFAULT_SIZE, 223, Short.MAX_VALUE)
		);
		panel_4.setLayout(new BorderLayout(0, 0));
		panel_4.add(treeEvents);
		panel_2.setLayout(gl_panel_2);
		
		table = new JTable();
		final VectorTableModel tableModel = new VectorTableModel(new Vector<Utente>(model.getUsers()));
		table.setModel(tableModel);

		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("qui");
				System.out.println(selectedCells.size());
				for(int i = 0; i < selectedCells.size(); i++) {					
					tableModel.removeRow(selectedCells.get(i));
					//usare !isadmin per non eliminare utenti amministratori
				}
				tableModel.fireTableDataChanged();
				selectedCells.removeAll(selectedCells);
			}
		});
		table.getTableHeader().setReorderingAllowed(false);		
		table.addKeyListener(tableKeyListener);
	    table.addMouseListener(tableMouseListener);
		panel.setLayout(new BorderLayout(0, 0));
		panel.add(table, BorderLayout.CENTER);
		panel.add(new JScrollPane(table));
				
		getContentPane().setLayout(groupLayout);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnFile = new JMenu("File");	
		menuBar.add(mnFile);
		
		JMenuItem mntmEsci = new JMenuItem("Esci");
		mnFile.add(mntmEsci);		
	}
	public void aggiungi() {
	    tableKeyListener = new KeyAdapter() {
	    	public void keyPressed(KeyEvent e) {
	    		if(e.getKeyCode()==KeyEvent.VK_CONTROL){
	    			pressingCTRL = true;
		        }
		    }

	    	public void keyReleased(KeyEvent e) {
	    		if(e.getKeyCode()==KeyEvent.VK_CONTROL){
	    			pressingCTRL=false;
		        }
		    }
		};

	    tableMouseListener = new MouseAdapter() {
	    	public void mouseClicked(MouseEvent e) {
	    		int row = table.rowAtPoint(e.getPoint());
	            boolean trovato = false;
	            boolean trovato1 = false;
	    		if(pressingCTRL){
	    			for(int i = 0; i < selectedCells.size(); i++) {
	    				if(selectedCells.get(i)== row) {
	 		               selectedCells.remove(selectedCells.get(i));
	 		               trovato = true;
	 		               break;
	    				}
	    			}
		            if(!trovato) {
		            	selectedCells.add(row);
		            	trovato = false;
		            }
		        }
	    		else {
	    			for(int i = 0; i < selectedCells.size(); i++) {
	    				if(selectedCells.get(i)== row) {
	    					trovato1 = true;
		 		            break;
	    				}
	    			}
    				if(!trovato1) {
    					selectedCells.removeAll(selectedCells);
    					selectedCells.add(row);
    				}
	    		}
	    	}
	    };
	}
}
