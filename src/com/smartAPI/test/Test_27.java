package com.smartAPI.test;


import java.util.ArrayList;

import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.smartAPI.model.CodePattern;
import com.smartAPI.model.Common;
import com.smartAPI.model.SmartAPIModel;

/**
 * Ricerca di una categoria di code pattern.
 * @author Simone Romamo - http://www.sromano.altervista.org
 *
 */

public class Test_27 {
	public static void main(String[] args) {
		System.out.println(new SmartAPIModel().getPatternOfCategory("Storage"));
	}
	
}
