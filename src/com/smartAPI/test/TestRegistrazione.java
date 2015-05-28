package com.smartAPI.test;

import com.smartAPI.control.RegistrazioneControl;
import com.smartAPI.model.SmartAPIModel;

/**
 * 
 * @author Amedeo Leo
 *
 */

public class TestRegistrazione {

	public static void main(String[] args) {
		SmartAPIModel model = new SmartAPIModel();
		RegistrazioneControl rc = new RegistrazioneControl(model);
		char password[] = new char[]{'a','b','c','d','e','f'};
		char confermaPassword[] = new char[]{'a','b','c','d','e','f'};
		
		rc.registra("abcd", "abcd", "abcd", password, confermaPassword, "abcd@aabcd.com", false, "res/4.png");
	}

}
