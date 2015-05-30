package com.smartAPI.model;

/**
 * This class contains model elements.
 * @author Simone Romamo - http://www.sromano.altervista.org
 *
 */
public class Common {
	public static final String NS = "http://www.semanticweb.org/simone/ontologies/2015/4/SmartAPI#";
	public static final String METHOD = "Method";
	public static final String USER = "User";
	public static final String CODE_PATTERN = "CodePattern";
	public static final String USE_METHOD = "useMethod";
	public static final String USE_STORAGE = "useStorage";
	public static final String HAS_LIBRARY = "hasLibrary";
	public static final String HAS_LANGUAGE = "hasLanguage";
	public static final String HAS_USERNAME = "hasUsername";
	public static final String HAS_PASSWORD = "hasPassword";
	public static final String HAS_NAME = "hasName";
	public static final String HAS_SURNAME = "hasSurname";
	public static final String HAS_EMAIL = "hasEmail";
	public static final String IS_ADMINISTRATOR = "isAdministrator";
	public static final String HAS_OWNER = "hasOwner";
	public static final String NO_OWNER_MESS = "No owner found!";
	public static final String HAS_CODE = "hasCode";	
	public static final String NO_CODE_MESS = "No code found!";
	public static final String HAS_KEYWORD = "hasKeyword";
	public static final String HAS_AVATAR = "hasAvatar";
	public static final String HAS_VOTED = "hasVoted";
	public static final String HAS_VOTERS = "hasVoters";
	public static final String HAS_SCORE = "hasScore";
	public static final String HAS_STARS = "hasStars";
	public static final String JAVA = "Java";
	public static final String PYTHON = "Python";
	public static final String PYTHON_CP_TMP_FILE = "pythonCodePattern.sat";
	public static final String PY_PARSER_SCRIPT = "/pyParser.py";
	public static final String PROJECT = "Project";
	public static final String HAS_CATEGORY = "hasCategory";
	public static final String FOLLOW_PROJECT = "followProject";
	public static final String HAS_DESCRIPTION = "hasDescription";
	public static Utente UTENTE = null;
	
	public static void setUser(Utente u){
		UTENTE = u;
	}
}
