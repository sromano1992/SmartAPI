package com.smartAPI.model;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Modella un insieme di utenti.
 * 
*/
public class GestioneUtente {

	public GestioneUtente( ) {
    	this.utenti = new ArrayList<Utente>();
    }

	public GestioneUtente(ArrayList<Utente> utenti) {
    	this.utenti = utenti;
    }
    
	/**
		Ispeziona l'insieme degli utenti.
		@return l'ArrayList degli utenti.		
	*/

	public ArrayList<Utente> getUtenti() {
    	return this.utenti;
    }
    
	/**
		Aggiunge un nuovo utente all'insieme.
		@param user il nuovo utente da aggiungere.
	*/
    public void add(Utente user) throws IOException {
    	this.utenti.add(user);
    	scriviUtenti();
    }

	/**
		Rimuove un utente all'insieme.
		@param user l' utente da eliminare.
	*/
    
    public void remove(Utente user) throws IOException {
    	int count = 0;
    	for(Utente k : utenti) {
        		if(k.getIdUtente() == user.getIdUtente()) {
            		utenti.remove(count);
            		scriviUtenti();
            		break;
        		}
        		count++;
    	}
  	}

	/**
		Scrive gli utenti sul file.
	*/    

    public void scriviUtenti() throws IOException {
    	String pathUtenti = "utenti.dat";
    	@SuppressWarnings("resource")
		ObjectOutputStream x = new ObjectOutputStream(new FileOutputStream(pathUtenti));
    	x.writeObject(utenti);
  	}
    
	/**
		Carica da file l'ArrayList di utenti e crea una GestioneUtente.
		@return new GestioneUtente.
	*/

    public static GestioneUtente caricaUtenti() throws ClassNotFoundException {
    	try {
    			ObjectInputStream file = new ObjectInputStream(new FileInputStream("utenti.dat"));
    			@SuppressWarnings("unchecked")
				ArrayList<Utente> utentiDaCaricare = (ArrayList<Utente>) file.readObject(); 
    			file.close();
    			if(utentiDaCaricare.size() >= 1)
    				Utente.lastIdUtente = utentiDaCaricare.get(utentiDaCaricare.size()-1).getIdUtente();
    			else
    				Utente.lastIdUtente = 0;
            
    			return new GestioneUtente(utentiDaCaricare);
    		}
    	
    	catch(IOException e) {
    			return new GestioneUtente();
    	}
    }
    
	/**
		Controlla se l'utente esiste.
		@param s la stringa per verificare se l'utente con nickname o e-mail corrispondente esiste.
		@return valore booleano che indica se l'utente e' presente nell'insieme.
	*/
	
    public boolean exists(String s) {
  		for(Utente x : utenti) {
        		if(x.getNickname().equalsIgnoreCase(s) || x.getEmail().equalsIgnoreCase(s)) {
            		return true;
        		}
    	}
    	return false;
  	}
    
	/**
		Ispeziona l'utente desiderato.
		@param username il nome dell'utente desiderato.
		@return l'utente richiesto.
	*/

    public Utente getUser(String username) {
    	for(Utente x: utenti) {
    	    if(x.getNickname().equals(username)) {
    	        return x;
    	    }
    	}
    	throw new UserException("Username inesistente");
	}

	/**
		Ispeziona l'utente desiderato.
		@param idUser l'id dell'utente desiderato.
		@return l'utente richiesto.
	*/
 	
	public Utente getUser(int idUser) {
    	for(Utente x: utenti) {
    	    if(x.getIdUtente() == idUser) {
    	        return x;
   	            }
    	}
    	
    	throw new UserException("ID inesistente");
	}

	private ArrayList<Utente> utenti;
}
