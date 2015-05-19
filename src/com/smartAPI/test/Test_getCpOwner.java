package com.smartAPI.test;

import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.rdf.model.Resource;
import com.smartAPI.model.SmartAPIModel;

/**
 * 
 * @author Simone Romamo - http://www.sromano.altervista.org
 *
 */
public class Test_getCpOwner {
	public static void main(String[] args) {
		SmartAPIModel s = new SmartAPIModel();
		System.out.println(s.getCpOwner("c1"));
		System.out.println(s.getCpSourceCode("c1"));
	}
}
