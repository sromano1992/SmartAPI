package com.smartAPI.view;

import java.util.Vector;
import javax.swing.table.AbstractTableModel;
import com.smartAPI.model.Utente;

/**
 * 
 * @author Amedeo Leo
 *
 */

public class VectorTableModel extends AbstractTableModel {
	
	private static final long serialVersionUID = 1L;
	Vector<Utente> v = new Vector<Utente>();
	String[] ColName = {"Username", "Nome", "Cognome", "Email", "Punteggio"};

	public VectorTableModel(Vector<Utente> v) {
		this.v = v;	
	}
	
	public void setColumnName(int i, String name) {
	    ColName[i] = name;
	    fireTableStructureChanged();
	}
	
	public void removeRow(int row) {
		v.remove(row);
		fireTableRowsDeleted(row, row);
	}
	
	public int getColumnCount() { 
		return ColName.length;
	}

	public int getRowCount() { 
		return v.size();
	}

	public Object getValueAt(int row, int col) {
		Utente u = (Utente)v.elementAt(row);
		switch (col){
	 		case 0: return u.getNickname();
	 		case 1: return u.getNome();
	 		case 2: return u.getCognome();
	 		case 3: return u.getEmail();
	 		//case 4: return punteggio 
	 		default: return "";
		}
	}
 
	public String getColumnName(int col) {
		return ColName[col];
	}
 
	public Class getColumnClass(int col) {
		return getValueAt(0, col).getClass();
	}
 
	public boolean isCellEditable(int row, int col) {
		return false;
	} 
	
	public void deleteRow(int row) {
		fireTableRowsDeleted(row, row);
		//fireTableChanged(new TableModelEvent(table.getModel(), selectedCells.get(i), selectedCells.get(i), 0, TableModelEvent.DELETE));
	}
	
	
}

