package com.smartAPI.control;

import japa.parser.ParseException;

import java.util.ArrayList;
import java.util.logging.Logger;

//import org.python.jline.internal.Log;

import com.smartAPI.model.Common;
import com.smartAPI.model.SmartAPIModel;

public class AddCodePatternControl {
	
	//private static Logger Log = Logger.getLogger("global");

	private String val_name; 
	private String val_CP;
	private String val_keyword;
	private String val_language;
	private String val_lib;
	private String category;
	private SmartAPIModel model = new SmartAPIModel();
	private IMethodParser parser;
	
	public AddCodePatternControl(String val_nome, String val_CP,String val_keyword, String val_language, String val_lib, String categoria) {
		this.val_name=val_nome;
		this.val_CP = val_CP;
		this.val_keyword = val_keyword;
		this.val_language = val_language;
		this.val_lib = val_lib;
		this.category = categoria;
		if (val_language.equals(Common.JAVA))
			parser = new JavaMethodParser();
		else if(val_language.equals(Common.PYTHON))
			parser = new PythonMethodParser();
	}

	public String getVal_name() {
		return val_name;
	}

	public void setVal_name(String val_nome) {
		this.val_name = val_nome;
	}

	public String getVal_CP() {
		return val_CP;
	}

	public void setVal_CP(String val_CP) {
		this.val_CP = val_CP;
	}

	public String getVal_keyword() {
		return val_keyword;
	}

	public String getVal_language() {
		return val_language;
	}

	public void setVal_language(String val_language) {
		this.val_language = val_language;
	}

	public String getVal_lib() {
		return val_lib;
	}

	public void setVal_lib(String val_lib) {
		this.val_lib = val_lib;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String categoria) {
		this.category = categoria;
	}

	public void setVal_keyword(String val_keyword) {
		this.val_keyword = val_keyword;
	}
	
	
	public int addCodePattern(){
		try {
			ArrayList<String> method_s = parser.getMethod(val_CP);
			if(method_s.size() == 0)
				return -2;
			System.out.println("metodi*******:"+method_s);
			model.addToMethodClass(method_s);
			//model.addPatternCategory(category);
			model.addUseMethod(category);
			model.associateCatAndCodePattern(category, val_name);
			model.setCPSourceCode(val_CP, val_name);
			model.addInstanceUseMethod(category, val_name, method_s);
			if(!val_keyword.equals("")) model.addKeyword(val_name, val_keyword);
			model.setOwner(val_name);
			model.setLibrary(val_name, val_lib);
			model.addUseLanguage(val_lib, val_language);
			model.initScoreVoters(val_name);
			model.storeOntModel();
			//Log.info("Code pattern added...");
			return 1;
		} catch (ParseException e) {
			e.printStackTrace();
			return -1;
		}
	}
	

}
