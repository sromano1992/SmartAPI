package com.smartAPI.test;

import java.util.ArrayList;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.rdf.model.Resource;
import com.smartAPI.model.Common;
import com.smartAPI.model.SmartAPIModel;

/**
 * Associare il code pattern inserito ad una categoria.
 * @author Stefania Cardamone
 *
 */
public class Test_28 {

	public static void main(String[] args) {
		SmartAPIModel s = new SmartAPIModel();
		String category = "Storage";		
		String codePattern = "Ste_CodePattern";
		
		s.associateCatAndCodePattern(category, codePattern);
		
	}

}
