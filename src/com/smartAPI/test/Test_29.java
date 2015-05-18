package com.smartAPI.test;

import java.util.ArrayList;

import com.hp.hpl.jena.rdf.model.Resource;
import com.smartAPI.model.Common;
import com.smartAPI.model.SmartAPIModel;

/**
 * 
 * @author Stefania Cardamone
 * Aggiunta di istanze alla proprietà useMethod (ex. useCalendar)
 *
 */
public class Test_29 {
	public static void main(String[] args) {
		SmartAPIModel s = new SmartAPIModel();
		
		String category = "Calendar";
		String pattern = "c1";		
		ArrayList<String> method_s = new ArrayList<String>();
		for (int i=100; i<110; i++){
			method_s.add("m" + i);
		}
		s.addToMethodClass(method_s);
		
		Resource c1 = s.getOntModel().getResource(Common.NS + pattern);

		for (String m : method_s) {
			c1.addProperty(s.getOntModel().getProperty(Common.NS + "use" + category), s.getResourceFromBase(Common.NS + m));
		}
		
		s.storeOntModel();
	}
}
