package com.smartAPI.view;

import java.util.ArrayList;
import java.util.Collections;

import com.smartAPI.model.ComparatorClassifica;
import com.smartAPI.model.SmartAPIModel;
import com.smartAPI.model.UserClassification;

/**
 * 
 * @author Amedeo Leo
 *
 */

public class Test_Votazione {

	public static void main(String[] args) {
		SmartAPIModel s = new SmartAPIModel();
		
		//s.addUser("prova", "prova", "prova@prova.com", "prova", "provap", false, "res/4.png");
		
		//code pattern proprio
		//s.aggiungiVotoCodePattern("u1", "c2", "8");
		
		//code pattern gi� votato
		//s.aggiungiVotoCodePattern("simone", "c1", "8");
		
		//code pattern non ancora votato
		//c1 avr� voters 2, score 16; cir� avr� hasVoted c2,c1
		//s.aggiungiVotoCodePattern("ciro", "c1", "9");
		
		//System.out.println(s.getMediaVotazioni("c2"));
		//System.out.println(s.hasAlreadyVoted("prova", "c2"));
		//System.out.println(s.hasAlreadyVoted("prova", "s1"));
		//System.out.println(s.modificaPermessiUtente("prova", true));
		
		/*
		System.out.println("***");
		System.out.println("Username, Somma della media dei voti dei suoi code pattern, #votanti dei suoi code pattern, #utenti che lo hanno votato");
	*/	
	ArrayList<String> c = s.classificaUtenti();
	ArrayList<UserClassification> classifica = s.getInfoUserClassification(c);
	
//		
//		for(String x : classifica) {
//			System.out.println(x);
//		}
		
		Collections.sort(classifica, new ComparatorClassifica());
		
		System.out.println("Ordino");
		for(UserClassification x : classifica) {
			System.out.println(x);
		}
		
		
		//System.out.println(s.isOwner("u1", "c1"));
		//System.out.println(s.isOwner("u2", "c2"));
		
		System.out.println(s.getNumeroStelle("ciro"));
	}

}
