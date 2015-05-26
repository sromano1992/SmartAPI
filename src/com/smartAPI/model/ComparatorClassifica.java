package com.smartAPI.model;

import java.util.Comparator;

public class ComparatorClassifica implements Comparator<UserClassification>{

	@Override
	public int compare(UserClassification u1, UserClassification u2) {
		
		Float punteggio0 = Float.parseFloat(u1.getSomma_media());
		Float punteggio1 = Float.parseFloat(u2.getSomma_media());
		
		if(punteggio0 > punteggio1)
			return -1;
		else
			return 1;
	}

}
