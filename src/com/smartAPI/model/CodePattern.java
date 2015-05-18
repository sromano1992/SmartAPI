package com.smartAPI.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


import java.util.logging.Logger;

import com.hp.hpl.jena.rdf.model.Resource;

/**
 * This class will represent a codePattern.
 * @author Simone Romamo - http://www.sromano.altervista.org
 *
 */
public class CodePattern {
	private static Logger log = Logger.getLogger("global");
	private double score = 0;
	private Resource cp;
	private ArrayList<Resource> usedMethod_s;
	private CodePattern relativeBasicPattern;	//is the pattern of another category
												//with the same methods

	public CodePattern(Resource subject) {
		this.cp = subject;
	}

	public Resource getResource() {
		return cp;
	}

	public void setResource(Resource cp) {
		this.cp = cp;
	}
	
	public void addMethod(Resource r){
		if(usedMethod_s == null){
			usedMethod_s = new ArrayList<Resource>();
		}
		usedMethod_s.add(r);
	}

	public ArrayList<Resource> getUsedMethod_s() {
		return usedMethod_s;
	}

	public static boolean haveSameMethod_s(CodePattern inferred, CodePattern basic) {
		return(intersection(inferred.getUsedMethod_s(), basic.usedMethod_s).size() == basic.usedMethod_s.size());
	}
	
	public static <T>List<T> intersection(List<T> list1, List<T> list2) {
        List<T> list = new ArrayList<T>();

        for (T t : list1) {
            if(list2.contains(t)) {
                list.add(t);
            }
        }

        return list;
    }

	public void setScore(double i) {
		this.score = i;
	}
	
	public double getScore() {
		return score;
	}

	public CodePattern getRelativeBasicCodePattern(){
		return this.relativeBasicPattern;
	}
	
	public void setRelativeBasicCodePattern(CodePattern basic) {
		this.relativeBasicPattern = basic;		
	}

	public ArrayList<Resource> getCommonWithBasic() {
		if(relativeBasicPattern == null){
			log.severe("This codePattern is not related with another one!");
			return null;
		}
		return (ArrayList<Resource>) intersection(this.getUsedMethod_s(), relativeBasicPattern.getUsedMethod_s());
	}
}
