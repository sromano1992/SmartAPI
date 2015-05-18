package com.smartAPI.test;

import java.util.ArrayList;

import com.hp.hpl.jena.rdf.model.Resource;
import com.smartAPI.model.SmartAPIModel;

/**
 * Aggiunta o selezione di una categoria di code pattern.
 * @author Simone Romamo - http://www.sromano.altervista.org
 *
 */
public class Test_26 {
	public static void main(String[] args) {
		SmartAPIModel s = new SmartAPIModel();
		//selezione categoria
		ArrayList<Resource> category_s = s.getMethodCategory();
		for (Resource r:category_s){
			System.out.println(r.getLocalName());
		}
		//aggiunta categoria
		s.addPatternCategory("Storage");
		s.addPatternCategory("Gui");
		s.storeOntModel();
	}
}
