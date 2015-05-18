package com.smartAPI.test;

import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.smartAPI.model.Common;
import com.smartAPI.model.SmartAPIModel;

/**
 * Aggiunta della proprietà useMethod per l'eventuale nuova categoria inserita dall'utente.
 * @author Ciro Amati 
 *
 */

public class Test_22 {

	public static void main(String[] args) {
		/*SmartAPIModel s = new SmartAPIModel();
		String categoryName = "GUI";	

		OntClass codePattern = s.getOntClass(Common.NS + "CodePattern");
		OntClass category = s.getOntModel().createClass(Common.NS + categoryName);
		codePattern.addSubClass(category);
		
		OntClass method = s.getOntClass(Common.NS + "Method");
		OntClass methodClass = s.getOntModel().createClass(Common.NS + categoryName + "Method");
		method.addSubClass(methodClass);
		
		ObjectProperty useMethod = s.getOntModel().getObjectProperty(Common.NS + "useMethod");
		ObjectProperty useCategory = s.getOntModel().createObjectProperty(Common.NS + "use"+categoryName);	
		useMethod.addSubProperty(useCategory);
		
		useCategory.setDomain(category);
		useCategory.setRange(methodClass);
		s.storeOntModel();*/
	
	}

}
