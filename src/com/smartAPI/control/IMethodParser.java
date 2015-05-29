package com.smartAPI.control;

import japa.parser.ParseException;

import java.util.ArrayList;

public interface IMethodParser {
	public ArrayList<String> getMethod(String codePattern) throws ParseException;
}
