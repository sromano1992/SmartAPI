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
		//model.addUser("simone", "romano", "simone@romano.com", "simone", "simone", false, "1");
		model.modificaUtente("simone", "simone1", "simone", "romano1", "simoneromano@gmail.com", "2");
	}

}