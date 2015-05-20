package com.smartAPI.model;

import java.util.ArrayList;

import com.hp.hpl.jena.rdf.model.Resource;

/**
 * This class will contains all inferred and basic code pattern of a specified
 * category.
 * 
 * @author Simone Romamo - http://www.sromano.altervista.org
 * 
 */
public class CodePattern_Category {
	private String category;
	private ArrayList<CodePattern> inferredCodePattern;
	private ArrayList<CodePattern> basicCodePattern;
	private String methodClass;
	private ArrayList<Resource> methodOfCategory;


	public CodePattern_Category(String category,
			ArrayList<CodePattern> inferredCodePattern,
			ArrayList<CodePattern> basicCodePattern,
			String methodClass, ArrayList<Resource> methodOfCategory) {
		this.category = category;
		this.inferredCodePattern = inferredCodePattern;
		this.basicCodePattern = basicCodePattern;
		this.methodClass = methodClass;
		this.methodOfCategory = methodOfCategory;
	}

	public String toString() {
		String toReturn = "";
		toReturn += methodClass.toUpperCase() + ":";
		for(Resource r : methodOfCategory){
			toReturn +=r.getLocalName() + "\n";
		}
		// print result
		toReturn +="*INFERRED*" + "\n";
		for (CodePattern r : inferredCodePattern) {
			toReturn += r.getResource().getLocalName() + "\n";
		}
		toReturn +="BASIC" + "\n";
		for (CodePattern r : basicCodePattern) {
			toReturn +=r.getResource().getLocalName() + "\n";
		}
		toReturn +="Calculated SCORE:" + "\n";
		for (CodePattern inferred : inferredCodePattern)
			toReturn +=inferred.getResource().getLocalName()
					+ " inferred as "
					+ category
					+ " with probability: "
					+ inferred.getScore()
					+ "%"
					+ "; common method with "
					+ category
					+ " "
					+ inferred.getRelativeBasicCodePattern().getResource()
							.getLocalName() + "\nCommonMethod: "
					+ inferred.getCommonWithBasic() + "\n";
		return toReturn;
	}
	
	public ArrayList<CodePattern> getInferredCodePattern() {
		return inferredCodePattern;
	}
	
	public ArrayList<CodePattern> getBasicCodePattern() {
		return basicCodePattern;
	}
	
	public String getCategoryName(){
		return category;
	}
}
