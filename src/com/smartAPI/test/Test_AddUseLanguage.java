package com.smartAPI.test;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.rdf.model.Resource;
import com.smartAPI.model.Common;
import com.smartAPI.model.SmartAPIModel;

public class Test_AddUseLanguage {
	public static void main(String[] args) {
		SmartAPIModel s = new SmartAPIModel();
		ObjectProperty useLibrary = s.getOntModel().getObjectProperty(
				Common.NS + Common.HAS_LANGUAGE);
		Resource languageRis = s.getResourceFromBase(Common.NS + "Java");
		Individual lib = s.getOntModel().getIndividual(Common.NS + "pyLib12");
		if (lib == null){
			lib = s.getOntClass("Library").createIndividual(Common.NS + "pyLib12");
		}
		lib.addProperty(useLibrary, languageRis);
		s.storeOntModel();

	}
}
