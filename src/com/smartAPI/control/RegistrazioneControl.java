package com.smartAPI.control;

import java.util.ArrayList;
import java.util.Arrays;

import com.hp.hpl.jena.ontology.DatatypeProperty;
import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.SimpleSelector;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.smartAPI.model.Common;
import com.smartAPI.model.SmartAPIModel;
import com.smartAPI.model.UserException;
import com.smartAPI.model.Utente;

/**
 * 
 * @author Amedeo Leo
 *
 */

public class RegistrazioneControl {
	
	private SmartAPIModel model;
	
	public RegistrazioneControl(SmartAPIModel model) {
		this.model = model;
	}

	public boolean registra(String nome, String cognome, String username, char[] password, char[] confermaPassword, String email, String pathAvatar) {
		if (nome.trim().equals("") || cognome.trim().equals("") || username.trim().equals("") || 
				Arrays.toString(password).trim().equals("") || 
				Arrays.toString(confermaPassword).trim().equals("") ||
				email.trim().equals("")) {
			throw new UserException("Campi mancanti");
		}
		
		if(Arrays.toString(confermaPassword).equals(Arrays.toString(password))) {
			StringBuilder realPassword = new StringBuilder();
			for(char s : password) {
			    realPassword.append(s);
			}
			if(model.addUser(nome, cognome, email, username, realPassword.toString(), false, pathAvatar)) {
				return true;
			}
			else
				throw new UserException("Username gia' in uso");	
		}	
		else {
			throw new UserException("Le password non coincidono!");
		}	
	}
	
	public boolean addUser (String nome, String cognome, String email, String username, String password, boolean isAdmin, String avatar) {
		OntClass userClass = model.getOntModel().getOntClass(Common.NS + Common.USER);
		
		if(!userAlreadyExists(userClass.getLocalName(), username)) {
			Utente user = new Utente(nome, cognome, email, username, password, false, avatar);
			
			Individual individualUser1 = model.getOntModel().createIndividual(Common.NS + username, userClass);
			DatatypeProperty hasUsername = model.getOntModel().getDatatypeProperty(Common.NS + Common.HAS_USERNAME);
			DatatypeProperty hasPassword = model.getOntModel().getDatatypeProperty(Common.NS + Common.HAS_PASSWORD);
			DatatypeProperty hasName = model.getOntModel().getDatatypeProperty(Common.NS + Common.HAS_NAME);
			DatatypeProperty hasSurname = model.getOntModel().getDatatypeProperty(Common.NS + Common.HAS_SURNAME);
			DatatypeProperty hasEmail = model.getOntModel().getDatatypeProperty(Common.NS + Common.HAS_EMAIL);
			DatatypeProperty isAdministrator = model.getOntModel().getDatatypeProperty(Common.NS + Common.IS_ADMINISTRATOR);
			DatatypeProperty hasAvatar = model.getOntModel().getDatatypeProperty(Common.NS + Common.HAS_AVATAR);
		
			individualUser1.addProperty(hasUsername, username);
			individualUser1.addProperty(hasPassword, password);
			individualUser1.addProperty(hasEmail, email);
			individualUser1.addProperty(hasName, nome);
			individualUser1.addProperty(hasSurname, cognome);
			individualUser1.addProperty(hasAvatar, avatar);
			if(isAdmin) {
				individualUser1.addProperty(isAdministrator, "si");
			}
			else {
				individualUser1.addProperty(isAdministrator, "no");
			}
			
			model.storeOntModel();							
			return true;
		}
		return false;
	}
	
	private boolean userAlreadyExists(String userClass, String username) {
		ArrayList<Resource> list = model.getIndividualOfClass(userClass);
		for(int i = 0; i < list.size(); i++) {
			Resource resource = list.get(i);
			StmtIterator iter = model.getOntModel().listStatements(new SimpleSelector(resource,null,(RDFNode)null));
			while (iter.hasNext()) {
				Statement stmt = iter.nextStatement();
				Property predicate = stmt.getPredicate();
				RDFNode object = stmt.getObject();
				if(predicate.getLocalName().equals("hasUsername")) {
					if(object.toString().equals(username)) {
						return true;
					}
				}
			}
		}
		return false;
	}
}
