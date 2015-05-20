package com.smartAPI.test;

import com.smartAPI.model.Common;
import com.smartAPI.model.SmartAPIModel;

/**
 * 
 * @author Simone Romamo - http://www.sromano.altervista.org
 * Aggiunta del metodo addLibrary per aggiungere una libreria ad un'istanza di code pattern.
 */
public class Test_30 {
	public static void main(String[] args) {
		SmartAPIModel s = new SmartAPIModel();
		String codePatternName = "c1";
		String libToAdd = "JDBC";
		s.addObjectPropertyInstance(Common.HAS_LIBRARY, codePatternName, libToAdd);
		s.storeOntModel();
	}
}
