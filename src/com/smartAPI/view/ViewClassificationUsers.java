package com.smartAPI.view;
import java.util.ArrayList;

import javax.swing.JPanel;

import com.smartAPI.model.*;

public class ViewClassificationUsers extends JPanel {
	
	ArrayList<UserClassification> listUsersOrdered;
	
	public ViewClassificationUsers(ArrayList<UserClassification> listUsers) {
		SortByUser sbu= new SortByUser(listUsers);
		listUsersOrdered = sbu.getListUserOrdered(); //list ordered by (decrescent) score 
		
	
	}

}
