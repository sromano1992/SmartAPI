package com.smartAPI.test;

import com.hp.hpl.jena.ontology.OntClass;
import com.smartAPI.model.Common;
import com.smartAPI.model.SmartAPIModel;

/**
 * Aggiunta di un utente ad un codePattern
 * @author iolrin
 */
public class Test_35 {

	public static void main(String[] args) {
		SmartAPIModel model = new SmartAPIModel();
		String utente = "u1";
		String codePattern = "c1";
		
		
		model.addObjectPropertyInstance(Common.HAS_OWNER, codePattern, utente);
		model.storeOntModel();
		
	}

}
