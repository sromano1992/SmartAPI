package com.smartAPI.model;

import java.util.ArrayList;

import org.apache.log4j.Logger;

/**
 * 
 * @author Simone Romamo - http://www.sromano.altervista.org
 *
 */
public class Project {
	private static Logger log = Logger.getLogger("global");
	private String name, description;
	private ArrayList<String> categories;

	public Project(String name, String description, ArrayList<String> categories) {
		super();
		this.name = name;
		this.description = description;
		this.categories = categories;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public ArrayList<String> getCategories() {
		return categories;
	}

	public void setCategories(ArrayList<String> categories) {
		this.categories = categories;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

}
