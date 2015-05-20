package com.smartAPI.test;

import com.smartAPI.model.SmartAPIModel;

/**
 * Aggiunta della proprieta'  useMethod per l'eventuale nuova categoria inserita dall'utente.
 * @author Ciro Amati 
 *
 */

public class Test_22 {

	public static void main(String[] args) {
		SmartAPIModel s = new SmartAPIModel();
		if(s.addUseMethod("GUI"))
			System.out.println("Aggiunta");
		else
			System.out.println("Non aggiunta");	
	}

}
