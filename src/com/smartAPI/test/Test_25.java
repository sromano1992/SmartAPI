package com.smartAPI.test;
import com.smartAPI.model.SmartAPIModel;


public class Test_25 {
	
	/**
	 * @author Amedeo Leo
	 * Task: Definizione del metodo addKeyword.
	 *
	 */
	
	public static void main(String[] args) {
		SmartAPIModel s = new SmartAPIModel();
		
		String risorsa = "c2";
		String keyword = "calendar";		
		
		if(s.addKeyword(risorsa, keyword)) 
			s.storeOntModel();
	}	
}
