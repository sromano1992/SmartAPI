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
		String name = "CodePattern";
		
		OntClass o = s.getOntModel().getOntClass(Common.NS+category);
		Individual p1 = s.getOntModel().createIndividual(Common.NS+name,o);
		
		s.storeOntModel();
		
	}

}
