package com.smartAPI.test;

import com.smartAPI.model.SmartAPIModel;

public class testDeleteProj {

	public static void main(String[] args) {
		SmartAPIModel m = new SmartAPIModel();
		System.out.println(m.deleteProject("test_0100"));
	}

}
