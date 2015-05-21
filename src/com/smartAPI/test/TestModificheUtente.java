package com.smartAPI.test;

import com.smartAPI.model.SmartAPIModel;

public class TestModificheUtente {

	public static void main(String[] args) {
		SmartAPIModel model = new SmartAPIModel();
		
		model.modificaUtente("stefy", "stefania", "stefania", "cardamone1", "stefania@gmail.com");
	}

}
