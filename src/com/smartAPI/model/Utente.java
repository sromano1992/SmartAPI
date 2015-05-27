package com.smartAPI.model;

import java.io.Serializable;

public class Utente implements Serializable {

	/**
	 * @author Amedeo Leo
	 */
	
	private static final long serialVersionUID = 1L;
	
	public Utente(String nome, String cognome, String email, String nickname, String password, boolean admin, String avatar, String voti, int stelle) {
		this.idUtente = ++Utente.lastIdUtente;
		this.setCognome(cognome);
		this.setNickname(nickname);
		this.setEmail(email);
		this.setNome(nome);
		this.setPassword(password);
		this.setAdmin(admin);
		this.setAvatar(avatar);
		this.setVoti(voti);
		this.setStelle(stelle);
	}
	
	public String getNome() {
		return nome;
	}

	/**
		Modifica il nome dell'utente.
		@param nome il nuovo nome.
	*/

	public void setNome(String nome) {
		if(!nome.matches("^[a-zA-Z ]{3,12}$"))
            throw new UserException("Name not valid");
        this.nome = nome;
	}

		
	/**
		Ispeziona il cognome dell'utente.
		@return il cognome dell'utente.
	*/

	public String getCognome() {
		return cognome;
	}


	/**
		Modifica il cognome dell'utente.
		@param cognome il nuovo cognome.
	*/
	public void setCognome(String cognome) {
		if(!cognome.matches("^[a-zA-Z]{3,12}$"))
            throw new UserException("Surname not valid");
		this.cognome = cognome;
	}

		
	/**
		Ispeziona l'e-mail dell'utente.
		@return l'e-mail dell'utente.
	*/

	public String getEmail() {
		return email;
	}

	/**
		Modifica l'e-mail dell'utente.
		@param email la nuova e-mail.
	*/

	public void setEmail(String email) {
		if(!email.matches("^[a-zA-Z0-9\\.\\_\\-]{3,20}@[a-zA-Z0-9\\.\\_\\-]{3,15}\\.[a-z]{2,6}$"))
            throw new UserException("Email not valid");
        	
		this.email = email;
	}
	
		
	/**
		Ispeziona il nickname dell'utente.
		@return il nickname dell'utente.
	*/

	public String getNickname() {
		return nickname;
	}


	/**
		Modifica il nickname dell'utente.
		@param nickname il nuovo nickname.
	*/

	public void setNickname(String nickname) {
		if(!nickname.matches("^[a-zA-Z0-9\\.\\_\\-]{3,15}$"))
			throw new UserException("Username not valid");
		this.nickname = nickname;
	}

		
	/**
		Ispeziona la password dell'utente.
		@return la password dell'utente.
	*/

	public String getPassword() {
		return this.password;
	}

	/**
		Modifica la password dell'utente.
		@param password la nuova password.
	*/

	public void setPassword(String password) {
		if((password.length() < 6) || (password.length() > 12))
            throw new UserException("Password not valid");
        
		this.password = password;
	}

	/**
		Ispeziona l'id dell'utente.
		@return l'id dell'utente.
	*/

	public int getIdUtente() {
		return idUtente;
	}

	/**
		Modifica l'id dell'utente.
		@param idUtente il nuovo id dell'utente.
	*/

	public void setIdUtente(int idUtente) {
		this.idUtente = idUtente;
	}

    /** 
        Ispeziona le notifiche dell'utente.
        @return le notifiche dell'utente.
     */
    /*
    public Notifiche getNotifiche() {
        return notifiche;
    }
    */
 
        
	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}
	
	public String toString() {
		return "Username:" + nickname + "\tNome:" + nome + "\tCognome:" + cognome + "\tEmail:" + email;
	}
	
	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public String getVoti() {
		return voti;
	}
	
	public void setVoti(String voti) {
		this.voti = voti;
	}
	

	public int getStelle() {
		return stelle;
	}

	public void setStelle(int stelle) {
		this.stelle = stelle;
	}


	private String nome;
	private String cognome;
	private String email;
	private String nickname;
	private String password;
	private boolean admin;
	private String avatar;
	private String voti;
	private int idUtente;
	private int stelle;
	public static int lastIdUtente;
}
