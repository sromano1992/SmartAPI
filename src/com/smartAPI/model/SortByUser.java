package com.smartAPI.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;



public class SortByUser {

	ArrayList <UserClassification> listUsers;

	public SortByUser(ArrayList <UserClassification> listUsers){
		this.listUsers= listUsers;

	}

	public ArrayList<UserClassification> getListUser(){
		return listUsers;
	}
	
	public ArrayList<UserClassification> getListUserOrdered(){
		Collections.sort(listUsers, new comparatorByScore());
		return listUsers;
	}

	private class comparatorByScore implements Comparator<UserClassification> {

		public int compare(UserClassification u1, UserClassification u2) {
			double id1 = u1.getScore();
			double id2 = u2.getScore();

			return (id1 > id2 ) ? -1: (id1 < id2) ? 1:0 ;
		}		
	}

	
}
