package com.smartAPI.test;

import com.smartAPI.model.SmartAPIModel;

public class TestKeyword {

	public static void main(String[] args) {
		SmartAPIModel model = new SmartAPIModel();
		System.out.println(model.hasKeyword("s4", "k12"));
	}
}
