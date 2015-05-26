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
		if(s.addUser("simone", "romano", "sromano@gmail.com", "simrom", "password", true, "res/3.png"))
			System.out.println("tutto ok");
	}
}
