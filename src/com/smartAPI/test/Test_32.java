package com.smartAPI.test;

import com.smartAPI.model.Common;
import com.smartAPI.model.SmartAPIModel;

/**
 * 
 * @author Simone Romamo - http://www.sromano.altervista.org
 *	Aggiunta del metodo addLibrary per legare una libreria ad un linguaggio di programmazione
 */
public class Test_32 {
	public static void main(String[] args) {
		SmartAPIModel s = new SmartAPIModel();
		String langName = "Java";
		String libToAdd = "JDBC";		
		s.addObjectPropertyInstance(Common.HAS_LANGUAGE, langName, libToAdd);
		s.storeOntModel();
	}
}
