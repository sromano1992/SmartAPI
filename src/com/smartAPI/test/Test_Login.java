package com.smartAPI.test;

import java.util.ArrayList;

import com.hp.hpl.jena.query.Dataset;
import com.hp.hpl.jena.query.Query;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.QueryFactory;
import com.hp.hpl.jena.query.QuerySolution;
import com.hp.hpl.jena.query.ReadWrite;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.tdb.TDBFactory;
import com.smartAPI.model.Common;
import com.smartAPI.model.SmartAPIModel;
import com.smartAPI.model.Utente;
import com.smartAPI.view.Login;
import com.smartAPI.view.NuovoAmministratore;

/**
 * 
 * @author Amedeo Leo
 * 	
 */

public class Test_Login {
	
	public static void main(String[] args) {
		SmartAPIModel s = new SmartAPIModel();
		
		if(!s.calculateID("User").equals("0")) {
			Login l = new Login(s);
		}			
		else {
			NuovoAmministratore n = new NuovoAmministratore(s);
		}
		
		/*
		ArrayList<Utente> utenti = s.getUsers();
		for(Utente u : utenti)
			System.out.println(u.toString());
		
		System.out.println("\n");
		*/
		/*
		if(s.isAdministrator("amedeo")) {
			if(s.deleteUser("amedeo1")) {
				System.out.println("Utente eliminato");
			}
			else {
				System.out.println("Utente non trovato");
			}
		}
		
		System.out.println("\n");
		*/
		/*
		if(s.isAdministrator("amedeo")) {
			if(s.deleteCodePattern("c1")) {
				System.out.println("CodePattern eliminato");
			}
			else {
				System.out.println("CodePattern non trovato");
			}
		}
		*/
	}
}
