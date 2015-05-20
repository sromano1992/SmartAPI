package com.smartAPI.test;

import java.util.ArrayList;

import com.hp.hpl.jena.rdf.model.Resource;
import com.smartAPI.model.SmartAPIModel;

public class Test_User {

	/**
	 * @author Amedeo Leo, Ciro Amati
	 * 
	 */
	public static void main(String[] args) {
		SmartAPIModel s = new SmartAPIModel();
		if(s.addUser("iole", "rinaldi", "iole.rinaldi@gmail.com", "iinaldi", "pASSWORD", false))
			System.out.println("tutto ok");
	}
}
