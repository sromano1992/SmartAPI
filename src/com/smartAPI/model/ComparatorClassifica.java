package com.smartAPI.model;

import java.util.Comparator;

public class ComparatorClassifica implements Comparator<String>{

	@Override
	public int compare(String arg0, String arg1) {
		
		Float punteggio0 = Float.parseFloat(arg0.split(",")[1]);
		Float punteggio1 = Float.parseFloat(arg1.split(",")[1]);
		
		if(punteggio0 > punteggio1)
			return -1;
		else
			return 1;
	}

}
