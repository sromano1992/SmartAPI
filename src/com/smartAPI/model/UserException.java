package com.smartAPI.model;

/**
 	Eccezione per la gestione degli utenti.
 */

public class UserException extends RuntimeException{

	private static final long serialVersionUID = 1L;
	
	public UserException() {
		super();
	}
	
	public UserException(String s) {
		super(s);
	}

}
