package com.smartAPI.control;

import japa.parser.ParseException;

import java.util.ArrayList;

/**
 * 
 * @author Simone Romamo - http://www.sromano.altervista.org
 *
 */
public interface IMethodParser {
	public ArrayList<String> getMethod(String codePattern) throws ParseException;
}
