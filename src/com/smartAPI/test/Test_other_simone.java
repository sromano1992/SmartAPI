package com.smartAPI.test;

import com.smartAPI.model.SmartAPIModel;

public class Test_other_simone {

	public static void main(String[] args) {
		SmartAPIModel s = new SmartAPIModel();
		//System.out.println(s.getPatternOfCategory("Storage").getBasicCodePattern());
		//System.out.println(s.getPatternOfCategory("Storage").getInferredCodePattern());

		s.associateCatAndCodePattern("Storage", "s6");
		s.addKeyword("s6", "keyword");
		s.setCPSourceCode("println", "s6");
		s.initScoreVoters("s6");
		s.storeOntModel();
	}

}
