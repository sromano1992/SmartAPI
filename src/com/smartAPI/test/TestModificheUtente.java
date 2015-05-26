package com.smartAPI.test;

import com.smartAPI.model.SmartAPIModel;

/**
 * 
 * @author Amedeo Leo
 *
 */

public class TestModificheUtente {

	public static void main(String[] args) {
		SmartAPIModel model = new SmartAPIModel();
		
		//String username, String password, String nome, String cognome, String email, String avatar
		model.addUser("prova", "prova", "prova@romano.com", "prova", "prova", false, "1");
		model.modificaUtente("prova", "prova1", "simone", "prova", "simoneromano@gmail.com", "2");
	}

}