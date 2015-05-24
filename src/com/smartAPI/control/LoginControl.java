package com.smartAPI.control;

import java.util.ArrayList;
import java.util.Arrays;

import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.SimpleSelector;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.smartAPI.model.SmartAPIModel;
import com.smartAPI.model.UserException;
import com.smartAPI.model.Utente;

/**
 * 
 * @author Amedeo Leo
 *
 */

public class LoginControl {

	private SmartAPIModel model;
	
	public LoginControl(SmartAPIModel model) {
		this.model = model;
	}
	
	public boolean exists(String username, String password) {
		ArrayList<Resource> list = model.getIndividualOfClass("User");
		Resource subject = null;
		
		for(int i = 0; i < list.size(); i++) {
			Resource resource = list.get(i);
			StmtIterator iter = model.getOntModel().listStatements(new SimpleSelector(resource,null,(RDFNode)null));
			while (iter.hasNext()) {
				Statement stmt = iter.nextStatement();
				Property predicate = stmt.getPredicate();
				RDFNode object = stmt.getObject();

				if(predicate.getLocalName().equals("hasUsername")) {
					if(object.toString().equals(username)) {
						subject = stmt.getSubject();
						break;
					}
				}
			}
		}
		
		if(subject != null) {
			StmtIterator iter = model.getOntModel().listStatements(new SimpleSelector(subject,null,(RDFNode)null));
			while (iter.hasNext()) {
				Statement stmt = iter.nextStatement();
				Property predicate = stmt.getPredicate();
				RDFNode object = stmt.getObject();
				if(predicate.getLocalName().equals("hasPassword")) {
					if(object.toString().equals(password)) {
						return true;
					}
				}
			}
		}
		else 
			throw new UserException("Username non esistente");
		throw new UserException("Password errata");
	}
	
	
	
	public boolean controllaUtente(String username, char[] password) {
		if(username.trim().equals("") || Arrays.toString(password).trim().equals((""))) {
			throw new UserException("User not found");
		}
		StringBuilder realPassword = new StringBuilder();
		for(char s : password) {
		    realPassword.append(s);
		}
		if(exists(username, realPassword.toString())) {
			System.out.println("qui");
        	return true;
		}
		else return false;
	}
	
	public Utente getUtente(String username) {
		for(Utente u: model.getUsers()) {
			if(u.getNickname().equals(username)) {
				return u;
			}
		}
		return null;
	}
}
