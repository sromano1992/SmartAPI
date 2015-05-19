package com.smartAPI.test;

import java.util.ArrayList;
import com.smartAPI.model.SmartAPIModel;

/**
 * Aggiunta alla classe Method di ogni metodo che compone il code pattern inserito.
 * @author Simone Romamo - http://www.sromano.altervista.org
 *
 */
public class Test_21 {
	public static void main(String[] args) {
		SmartAPIModel s = new SmartAPIModel();

		//creating method list
		ArrayList<String> method_sToAdd = new ArrayList<String>();
		for (int i=1; i<16; i++){
			method_sToAdd.add("m" + i);
		}
		
		s.addToMethodClass(method_sToAdd);
		//s.storeOntModel();
	}
}
