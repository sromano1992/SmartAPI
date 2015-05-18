package com.smartAPI.test;

import com.smartAPI.model.SmartAPIModel;

public class Test_User {

	/**
	 * @author Amedeo Leo, Ciro Amati
	 * 
	 */
	public static void main(String[] args) {
		SmartAPIModel s = new SmartAPIModel();
		if(s.addUser("iole", "rinaldi", "iole.rinaldi@gmail.com", "iinaldi", "p"))
			System.out.println("tutto ok");
	}
}
