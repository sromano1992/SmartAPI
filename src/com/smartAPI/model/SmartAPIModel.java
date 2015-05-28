package com.smartAPI.model;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.logging.Logger;

import org.apache.xerces.impl.xs.XSDDescription;

import com.hp.hpl.jena.datatypes.xsd.impl.XSDBaseStringType;
import com.hp.hpl.jena.ontology.DatatypeProperty;
import com.hp.hpl.jena.ontology.Individual;
import com.hp.hpl.jena.ontology.ObjectProperty;
import com.hp.hpl.jena.ontology.OntClass;
import com.hp.hpl.jena.ontology.OntModel;
import com.hp.hpl.jena.ontology.OntModelSpec;
import com.hp.hpl.jena.ontology.OntResource;
import com.hp.hpl.jena.rdf.model.Literal;
import com.hp.hpl.jena.rdf.model.Model;
import com.hp.hpl.jena.rdf.model.ModelFactory;
import com.hp.hpl.jena.rdf.model.Property;
import com.hp.hpl.jena.rdf.model.RDFNode;
import com.hp.hpl.jena.rdf.model.Resource;
import com.hp.hpl.jena.rdf.model.ResourceFactory;
import com.hp.hpl.jena.rdf.model.Selector;
import com.hp.hpl.jena.rdf.model.SimpleSelector;
import com.hp.hpl.jena.rdf.model.Statement;
import com.hp.hpl.jena.rdf.model.StmtIterator;
import com.hp.hpl.jena.util.FileManager;
import com.hp.hpl.jena.util.iterator.ExtendedIterator;

/**
 * 
 * @author Simone Romamo - http://www.sromano.altervista.org
 * This class manages '*.owl' knowledge base.
 */
public class SmartAPIModel {
	private static final String OWL_FILE_PATH = "/SmartAPI_1.2.owl";
	private static Logger log = Logger.getLogger("global");
	private static OntModel base;
	private static OntModel inf;

	public OntModel getOntModel(){
		if(base != null)
			return base;
		base = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);		
		String modelPath = this.getClass().getResource(OWL_FILE_PATH).getFile();
		File file;
		try {
			file = new File(new java.net.URI(modelPath).getPath());
			InputStream in = FileManager.get().open(file.getAbsolutePath());
			if (in == null) {
				throw new IllegalArgumentException("File: " + file.getAbsolutePath() + " not found");
			}
			base.read(in, null);		
			log.info("Model created...");
		} catch (URISyntaxException e) {
			log.severe("Exception creating file: '" + modelPath + "'");
			e.printStackTrace();
		}
		return base;	
	}

	public OntModel getInfModel(){
		if (inf != null){
			log.info("returning inf model...");
			return inf;
		}
		inf = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM_RDFS_INF, getOntModel());
		log.info("Inf Model created...");
		return inf;
	}

	public ArrayList<Resource> getInferredIndividualOfClass(String className){			
		ArrayList<Resource> toReturn = new ArrayList<Resource>();
		StmtIterator iter = getInfModel().listStatements();
		while (iter.hasNext()) {
			Statement stmt = iter.nextStatement(); // get next statement
			Resource subject = stmt.getSubject(); // get the subject
			Property predicate = stmt.getPredicate(); // get the predicate
			RDFNode object = stmt.getObject(); // get the object

			if (predicate.getLocalName().contains("type") && object instanceof Resource) {
				if(object.toString().contains(className))		
					toReturn.add(subject);
			} 
		}
		return toReturn;
	}

	public ArrayList<Resource> getIndividualOfClass(String className){			
		ArrayList<Resource> toReturn = new ArrayList<Resource>();
		StmtIterator iter = getOntModel().listStatements();
		while (iter.hasNext()) {
			Statement stmt = iter.nextStatement(); // get next statement
			Resource subject = stmt.getSubject(); // get the subject
			Property predicate = stmt.getPredicate(); // get the predicate
			RDFNode object = stmt.getObject(); // get the object

			if (predicate.getLocalName().contains("type") && object instanceof Resource) {
				if(object.toString().contains(className))		
					toReturn.add(subject);
			} 
		}
		return toReturn;
	}

	public Property getProperty(String propName){
		return getOntModel().getProperty(propName);
	}

	public Resource getResourceFromBase(String resName){
		return getOntModel().getResource(resName);
	}

	public Resource getResourceFromInf(String resName){
		return getInfModel().getResource(resName);
	}

	/**
	 * This method will return a list of category for
	 * the method with methodName
	 * @param methodName
	 * @return
	 */
	public ArrayList<Resource> getCategoryOfMethod(String methodName){
		Resource m = getResourceFromBase(methodName);
		ArrayList<Resource> toReturn = new ArrayList<Resource>();
		ArrayList<Resource> category = getMethodCategory();
		for (Resource c : category){
			ArrayList<Resource> cm1 = getInferredIndividualOfClass(c.getLocalName());
			for(Resource r : cm1){
				if(r.getLocalName().equals(m.toString())){
					toReturn.add(c);
				}
			}
		}		
		return toReturn;
	}

	public ArrayList<Resource> getPatternCategory(){
		ArrayList<Resource> toReturn = new ArrayList<Resource>();
		for (Iterator<OntClass> i=getOntModel().listClasses(); i.hasNext();){
			OntClass temp = i.next();			
			if(temp.hasSuperClass() && temp.getSuperClass().getLocalName().contains(Common.CODE_PATTERN)){
				toReturn.add(temp);
			}
		}
		return toReturn;
	}

	public ArrayList<Resource> getMethodCategory(){
		ArrayList<Resource> toReturn = new ArrayList<Resource>();
		for (Iterator<OntClass> i=getOntModel().listClasses(); i.hasNext();){
			OntClass temp = i.next();			
			if(temp.hasSuperClass() && temp.getSuperClass().getLocalName().contains(Common.METHOD)){
				toReturn.add(temp);
			}
		}
		return toReturn;
	}

	/**
	 * This method will add element of method_s list
	 * to Method ontology's class if it hasn't them.
	 * @param method_sToAdd
	 */
	public void addToMethodClass(ArrayList<String> method_sToAdd){
		OntClass methodClass = null;
		ArrayList<Resource> methodIndividual_s = getIndividualOfClass(Common.METHOD);
		for (String m:method_sToAdd){
			if (!(containsMethod(methodIndividual_s, m))){
				if(methodClass == null){
					methodClass = getOntClass(Common.METHOD);
				}
				getOntModel().createIndividual(Common.NS + m, methodClass);
				log.info("Method " + m + " added to Method class");
			}
			else
				log.info("Method " + m + " already in Method class");
		}
	}

	public OntClass getOntClass(String className) {
		OntClass toReturn = null;
		for (Iterator<OntClass> i=getOntModel().listClasses(); i.hasNext();){
			OntClass tempClass = i.next();
			if (tempClass.getLocalName().equals(className))
				toReturn = tempClass;
		}
		return toReturn;
	}

	private boolean containsMethod(ArrayList<Resource> method_s, String m){
		for (Resource r:method_s){
			if (r.getLocalName().equals(m.toString())){
				return true;
			}
		}
		return false;
	}

	public void storeOntModel(){
		String modelPath = this.getClass().getResource(OWL_FILE_PATH).getFile();
		File file;
		try {
			file = new File(new java.net.URI(modelPath).getPath());
			OutputStream out = new FileOutputStream(new File(file.getAbsolutePath()));
			if (out == null) {
				throw new IllegalArgumentException("File: " + "SmartAPI_1.2.owl"+ " not found");
			}
			getOntModel().write(out);
			log.info("Model written to file...");
		} catch (FileNotFoundException e) {
			log.severe("Exception writing owl file!");
			e.printStackTrace();
		} catch (URISyntaxException e) {
			log.severe("Exception writing owl file!");
			e.printStackTrace();
		} catch (IOException e) {
			log.severe("Exception closing owl file!");
			e.printStackTrace();
		}		
	}

	public void printOntModel(){
		getOntModel().write(System.out, "RDF/XML-ABBREV");
	}

	/**
	 * This method will add new Pattern category.
	 */
	public void addPatternCategory(String categoryName){
		ArrayList<Resource> category_s = getPatternCategory();
		for (Resource r:category_s){
			if(r.getLocalName().equalsIgnoreCase(categoryName)){
				log.info("Category '" + categoryName + "' already in knowledge base...");
				return;
			}
		}
		getOntModel().createClass(Common.NS + categoryName).addSuperClass(getOntClass(Common.CODE_PATTERN));
		log.info("Added category '" + categoryName + "'");
	}

	/**
	 * Aggiunge la propriet� hasKeyword ad una risorsa
	 * @author Amedeo Leo
	 */
	public boolean addKeyword(String risorsa, String keyword) {
		Individual ind = getOntModel().getIndividual(Common.NS + risorsa);
		DatatypeProperty hasKeyword = getOntModel().getDatatypeProperty(Common.NS + Common.HAS_KEYWORD);
		ind.addProperty(hasKeyword, keyword);
		log.info("Added property " + keyword);
		return true;
	}

	/**
	 * Crea una ObjectProperty
	 * @author Amedeo Leo
	 */

	public ObjectProperty createObjectProperty(String property) {
		return getOntModel().createObjectProperty(property);
	}

	/**
	 * Crea una ObjectProperty, passando in input dominio,range e label.
	 * @author Amedeo Leo
	 */
	public ObjectProperty createObjectProperty(String property, String domain, String range, String label) {
		OntModel o = getOntModel();
		ObjectProperty p = o.createObjectProperty(property);
		OntClass ontDomain = o.getOntClass(Common.NS.concat(domain));
		OntClass ontRange = o.getOntClass(Common.NS.concat(range));
		if (ontDomain == null || ontRange == null)
			return null;

		p.addDomain(ontDomain);
		p.addRange(ontRange);
		p.addLabel(label, "it");
		return p;
	}


	/**
	 * Restituisce la lista di Statement, passando in input l'oggetto Selector
	 * @author Amedeo Leo
	 */
	public StmtIterator listStatements(Selector selector) {
		return getOntModel().listStatements(selector);
	}

	public CodePattern_Category getPatternOfCategory(String category){
		boolean addToInfferred = false, addToBasic = false;
		String property = "use" + category;
		String methodClass = category + "Method";

		//Search for inferred storageMethod
		ArrayList<Resource> methodOfCategory = getInferredIndividualOfClass(methodClass);

		//search for codePattern with useMethod->founded method
		ArrayList<CodePattern> inferredCodePattern = new ArrayList<CodePattern>();
		ArrayList<CodePattern> basicCodePattern = new ArrayList<CodePattern>();

		ArrayList<Resource> individualOfCategory = getInferredIndividualOfClass(Common.CODE_PATTERN);
		CodePattern tmpBaseCp = null, tmpInferredCP = null;
		for (Resource codePattern:individualOfCategory){
			addToInfferred = addToBasic = false;
			for (StmtIterator s1 = codePattern.listProperties(); s1.hasNext();){
				Statement temp = s1.next();
				Resource subject = temp.getSubject(); // get the subject
				Property predicate = temp.getPredicate(); // get the predicate
				RDFNode object = temp.getObject(); // get the object

				if(predicate.getLocalName().equals(Common.USE_METHOD)){
					if (object.isResource()){
						Resource usedMethod = object.asResource();
						for(Resource r:methodOfCategory){
							if (r.getLocalName().equals(usedMethod.getLocalName())){
								if(!addToInfferred){
									tmpInferredCP = new CodePattern(codePattern);
									inferredCodePattern.add(tmpInferredCP);
									addToInfferred = true;
								}
								tmpInferredCP.addMethod(r);
							}
						}
					}
				}
				if(predicate.getLocalName().equals(property)){
					if (object.isResource()){
						Resource usedMethod = object.asResource();
						for(Resource r:methodOfCategory){
							if (r.getLocalName().equals(usedMethod.getLocalName())){
								if(!addToBasic){
									tmpBaseCp = new CodePattern(codePattern);
									basicCodePattern.add(tmpBaseCp);
									addToBasic = true;
								}
								tmpBaseCp.addMethod(r);
							}
						}
					}
				}
			}
		}
		//deleting basic method from inferred
		ArrayList<CodePattern> toRemove = new ArrayList<CodePattern>();
		for (CodePattern c:basicCodePattern){
			for (CodePattern i:inferredCodePattern){
				if(c.getResource().equals(i.getResource())){
					toRemove.add(i);
				}
			}
		}
		for (CodePattern c:toRemove){
			inferredCodePattern.remove(c);
		}

		//probability calculation
		for (CodePattern inferred:inferredCodePattern){
			for (CodePattern basic:basicCodePattern){
				if(CodePattern.haveSameMethod_s(inferred, basic)){
					inferred.setScore(100.00);
					inferred.setRelativeBasicCodePattern(basic);
					break;	//go to next inferred code pattern
				}
				else{
					double intersectionSize = CodePattern.intersection(inferred.getUsedMethod_s(), basic.getUsedMethod_s()).size();
					if(intersectionSize > 0){
						double tmpScore = (intersectionSize / basic.getUsedMethod_s().size())*100;
						if (tmpScore > inferred.getScore()){
							inferred.setScore(tmpScore);
							inferred.setRelativeBasicCodePattern(basic);
						}
					}
				}
			}
		}
		return new CodePattern_Category(category, inferredCodePattern, basicCodePattern, methodClass, methodOfCategory);
	}

	public void addUseLibrary(String codePatternName, String libToAdd) {
		ObjectProperty useLibrary = getOntModel().getObjectProperty(Common.NS + Common.HAS_LIBRARY);
		Resource lib = getResourceFromBase(Common.NS + libToAdd);
		Resource cp = getResourceFromBase(Common.NS + codePatternName);

		cp.addProperty(useLibrary, lib);
	}

	public void addUseLanguage(String library, String language) {
		ObjectProperty useLibrary = getOntModel().getObjectProperty(Common.NS + Common.HAS_LANGUAGE);
		Resource languageRis = getResourceFromBase(Common.NS + language);
		Resource lib = getResourceFromBase(Common.NS + library);

		lib.addProperty(useLibrary, languageRis);
	}

	public void addObjectPropertyInstance(String propName, String subject, String object){
		ObjectProperty p = getOntModel().getObjectProperty(Common.NS + propName);
		Resource s = getResourceFromBase(Common.NS + subject);
		Resource o = getResourceFromBase(Common.NS + object);

		s.addProperty(p, o);
		log.info("Add property '" + propName + "' to subject '" + subject + "' with value '" + object + "'");
	}
	/**
	 * Aggiunge un utente alla base ontologica
	 * @author Amedeo Leo, Ciro Amati
	 * 
	 */

	public boolean addUser(String nome, String cognome, String email, String username, String password, boolean isAdmin, String avatar) {
		OntClass userClass = getOntModel().getOntClass(Common.NS + Common.USER);
		if(!userAlreadyExists(userClass.getLocalName(), username)) {
			Utente user = new Utente(nome, cognome, email, username, password, false, avatar, "0", 0);
			getOntModel();

			Individual individualUser1 = getOntModel().createIndividual(Common.NS + username, userClass);
			DatatypeProperty hasUsername = getOntModel().getDatatypeProperty(Common.NS + Common.HAS_USERNAME);
			DatatypeProperty hasPassword = getOntModel().getDatatypeProperty(Common.NS + Common.HAS_PASSWORD);
			DatatypeProperty hasName = getOntModel().getDatatypeProperty(Common.NS + Common.HAS_NAME);
			DatatypeProperty hasSurname = getOntModel().getDatatypeProperty(Common.NS + Common.HAS_SURNAME);
			DatatypeProperty hasEmail = getOntModel().getDatatypeProperty(Common.NS + Common.HAS_EMAIL);
			DatatypeProperty isAdministrator = getOntModel().getDatatypeProperty(Common.NS + Common.IS_ADMINISTRATOR);
			DatatypeProperty hasAvatar = getOntModel().getDatatypeProperty(Common.NS + Common.HAS_AVATAR);
			DatatypeProperty hasVoted = getOntModel().getDatatypeProperty(Common.NS + Common.HAS_VOTED);
			DatatypeProperty hasStars = getOntModel().getDatatypeProperty(Common.NS + Common.HAS_STARS);
			
			individualUser1.addProperty(hasUsername, username);
			individualUser1.addProperty(hasPassword, password);
			individualUser1.addProperty(hasEmail, email);
			individualUser1.addProperty(hasName, nome);
			individualUser1.addProperty(hasSurname, cognome);
			individualUser1.addProperty(hasAvatar, avatar);
			individualUser1.addProperty(hasVoted, "0");
			individualUser1.addProperty(hasStars, getOntModel().createTypedLiteral(new Integer(0)));

			if(isAdmin) {
				individualUser1.addProperty(isAdministrator, "si");
			}
			else {
				individualUser1.addProperty(isAdministrator, "no");
			}
			storeOntModel();							
			return true;
		}
		else
			return false;
	}

	/**
	 * Controlla se il login effettuato � corretto.
	 * @author Amedeo Leo
	 */
	public boolean exists(String username, String password) {
		ArrayList<Resource> list = getIndividualOfClass("User");
		Resource subject = null;

		for(int i = 0; i < list.size(); i++) {
			Resource resource = list.get(i);
			StmtIterator iter = getOntModel().listStatements(new SimpleSelector(resource,null,(RDFNode)null));
			while (iter.hasNext()) {
				Statement stmt = iter.nextStatement();
				Property predicate = stmt.getPredicate();
				RDFNode object = stmt.getObject();

				if(predicate.getLocalName().equals("hasUsername")) {
					if(object.toString().equals(username)) {
						subject = stmt.getSubject();
						break;
					}
				}
			}
		}

		if(subject != null) {
			StmtIterator iter = getOntModel().listStatements(new SimpleSelector(subject,null,(RDFNode)null));
			while (iter.hasNext()) {
				Statement stmt = iter.nextStatement();
				Property predicate = stmt.getPredicate();
				RDFNode object = stmt.getObject();
				if(predicate.getLocalName().equals("hasPassword")) {
					if(object.toString().equals(password)) {
						return true;
					}
				}
			}
		}
		else 
			throw new UserException("Username non esistente");
		throw new UserException("Password errata");
	}

	/**
	 * Controlla se un utente esiste gia'.
	 * @author Amedeo Leo, Ciro Amati
	 */
	private boolean userAlreadyExists(String userClass, String username) {
		ArrayList<Resource> list = getIndividualOfClass(userClass);
		for(int i = 0; i < list.size(); i++) {
			Resource resource = list.get(i);
			StmtIterator iter = getOntModel().listStatements(new SimpleSelector(resource,null,(RDFNode)null));
			while (iter.hasNext()) {
				Statement stmt = iter.nextStatement();
				Property predicate = stmt.getPredicate();
				RDFNode object = stmt.getObject();
				if(predicate.getLocalName().equals("hasUsername")) {
					if(object.toString().equals(username)) {
						return true;
					}
				}
			}
		}
		return false;
	}

	/**
	 * Calcola l'id dell'ultimo utente inserito
	 * @author Amedeo Leo, Ciro Amati
	 */
	public String calculateID(String userClass) {
		String id = "0";
		ArrayList<Resource> list = getIndividualOfClass(userClass);
		for(int i = 0; i < list.size(); i++) {
			Resource resource = list.get(i);
			StmtIterator iter = getOntModel().listStatements(new SimpleSelector(resource,null,(RDFNode)null));
			while (iter.hasNext()) {
				Statement stmt = iter.nextStatement();
				Resource subject = stmt.getSubject();
				Property predicate = stmt.getPredicate();

				if(predicate.getLocalName().equals("type")) {
					String newId = subject.getLocalName().substring(1);
					if(Integer.parseInt(newId) > Integer.parseInt(id)) 
						id = newId;
				}
			}
		}
		return id;
	}

	/**
	 * Restituisce tutti gli utenti.
	 * @author Amedeo Leo
	 */
	public ArrayList<Utente> getUsers() {
		ArrayList<Utente> utenti = new ArrayList<Utente>();
		ArrayList<Resource> list = getIndividualOfClass("User");
		for(int i = 0; i < list.size(); i++) {
			Resource resource = list.get(i);
			StmtIterator iterResource = getOntModel().listStatements(new SimpleSelector(resource,null,(RDFNode)null));
			String nome = "", cognome = "", username = "", password = "", email = "", avatar = "", voti = "";
			boolean amministratore = false;
			while (iterResource.hasNext()) {
				Statement stmtResource = iterResource.nextStatement();
				Resource subjectResource = stmtResource.getSubject();
				Property predicateResource = stmtResource.getPredicate();
				if(predicateResource.getLocalName().equals("type")) {
					StmtIterator iterSubject = getOntModel().listStatements(new SimpleSelector(subjectResource,null,(RDFNode)null));
					while (iterSubject.hasNext()) {
						Statement stmt = iterSubject.nextStatement();
						Property predicate = stmt.getPredicate();
						RDFNode object = stmt.getObject();

						if(predicate.getLocalName().equals(Common.HAS_NAME)) {
							nome = object.toString();
						}
						if(predicate.getLocalName().equals(Common.HAS_SURNAME)) {
							cognome = object.toString();
							//System.out.println(cognome);
						}
						if(predicate.getLocalName().equals(Common.HAS_USERNAME)) {
							username = object.toString();
						}
						if(predicate.getLocalName().equals(Common.HAS_PASSWORD)) {
							password = object.toString();
						}
						if(predicate.getLocalName().equals(Common.HAS_EMAIL)) {
							email = object.toString();
						}
						if(predicate.getLocalName().equals(Common.IS_ADMINISTRATOR)) {
							if(object.toString().equals("si")) {
								amministratore = true;
							}
							else
								amministratore = false;
						}
						if(predicate.getLocalName().equals(Common.HAS_AVATAR)) {
							avatar = object.toString();
						}
						if(predicate.getLocalName().equals(Common.HAS_VOTED)) {
							voti = object.toString();
						}
					}
				}
			}
			//String nome, String cognome, String email, String nickname, String password, boolean admin, String avatar
			utenti.add(new Utente(nome,cognome,email,username,password,amministratore, avatar, voti, getNumeroStelle(username)));

		}
		return utenti;
	}

	/**
	 * Controlla se un utente � un amministratore.
	 * @author Amedeo Leo
	 */
	public boolean isAdministrator(String username) {
		ArrayList<Resource> list = getIndividualOfClass("User");
		for(int i = 0; i < list.size(); i++) {
			Resource resource = list.get(i);
			StmtIterator iter = getOntModel().listStatements(new SimpleSelector(resource,null,(RDFNode)null));
			while (iter.hasNext()) {
				Statement stmt = iter.nextStatement();
				Resource subject = stmt.getSubject();
				Property predicate = stmt.getPredicate();
				RDFNode object = stmt.getObject();

				if(predicate.getLocalName().equals("hasUsername")) {
					if(object.toString().equals(username)) {
						StmtIterator utente = getOntModel().listStatements(new SimpleSelector(subject,null,(RDFNode)null));
						while (utente.hasNext()) {
							Statement stmt1 = utente.nextStatement();
							Property predicate1 = stmt1.getPredicate();
							RDFNode object1 = stmt1.getObject();

							if(predicate1.getLocalName().equals("isAdministrator")) {
								if(object1.toString().equals("si")) {
									return true;
								}
								else
									return false;
							}
						}
					}
				}

			}
		}
		return false;
	}

	/** 
	 * Elimina un utente.
	 * @author Amedeo Leo
	 */
	public boolean deleteUser(String username) {
		ArrayList<Resource> list = getIndividualOfClass("User");
		OntModel o = getOntModel();
		ArrayList<Statement> statements = new ArrayList<Statement>();
		for(int i = 0; i < list.size(); i++) {
			Resource resource = list.get(i);
			StmtIterator iter = getOntModel().listStatements(new SimpleSelector(resource,null,(RDFNode)null));
			while (iter.hasNext()) {
				Statement stmt = iter.nextStatement();
				Resource user = stmt.getSubject();
				Property predicate = stmt.getPredicate();
				RDFNode object = stmt.getObject();

				if(predicate.getLocalName().equals("hasUsername")) {
					if(object.toString().equals(username)) {
						StmtIterator iterUser = getOntModel().listStatements(new SimpleSelector(user,null,(RDFNode)null));
						while (iterUser.hasNext()) {
							Statement stmtUser = iterUser.nextStatement();
							statements.add(stmtUser);
						}
					}
				}
			}
		}
		if(statements.size() != 0) {
			o.remove(statements);
			storeOntModel();
			return true;
		}
		return false;
	}

	/** 
	 * Elimina un codePattern.
	 * @author Amedeo Leo
	 * Nota: non elimina i metodi che appartengono solo al quel code pattern. Modificare?
	 */
	public boolean deleteCodePattern(String codePattern) {
		ArrayList<Resource> list = getInferredIndividualOfClass(Common.CODE_PATTERN);
		OntModel o = getOntModel();
		ArrayList<Statement> statements = new ArrayList<Statement>();
		for(int i = 0; i < list.size(); i++) {
			Resource resource = list.get(i);
			StmtIterator iter = getOntModel().listStatements(new SimpleSelector(resource,null,(RDFNode)null));
			while (iter.hasNext()) {
				Statement stmt = iter.nextStatement();
				Resource code = stmt.getSubject();
				if(code.getLocalName().equals(codePattern)) {
					StmtIterator iterCode = getOntModel().listStatements(new SimpleSelector(code,null,(RDFNode)null));
					while (iterCode.hasNext()) {
						Statement stmtCode = iterCode.nextStatement();
						statements.add(stmtCode);
					}
				}
			}
		}
		if(statements.size() != 0) {
			o.remove(statements);
			storeOntModel();
			return true;
		}
		return false;
	}

	/**
	 * This method will return owner for input codePattern.
	 * @param cp
	 * @return
	 */
	public String getCpOwner(String cp){
		Individual ind = getOntModel().getIndividual(Common.NS + cp);
		StmtIterator iter = ind.listProperties();
		while (iter.hasNext()) {
			Statement stmt      = iter.nextStatement();
			Property  predicate = stmt.getPredicate();   // get the predicate
			Object obj = stmt.getObject();
			Resource subject = stmt.getSubject();

			if(predicate.getLocalName().contains(Common.HAS_OWNER)){
				log.info("Found owner: " + ((Resource)obj).getLocalName());
				return ((Resource)obj).getLocalName();
			}
		}
		log.warning(Common.NO_OWNER_MESS);
		return Common.NO_OWNER_MESS;
	}

	/**
	 * This method will return source code for 
	 * the input codePattern.
	 * @param cp
	 * @return
	 */
	public String getCpSourceCode(String cp){
		Individual ind = getOntModel().getIndividual(Common.NS + cp);
		StmtIterator iter = ind.listProperties();
		while (iter.hasNext()) {
			Statement stmt      = iter.nextStatement();
			Property  predicate = stmt.getPredicate();   // get the predicate
			Object obj = stmt.getObject();
			Resource subject = stmt.getSubject();

			if(predicate.getLocalName().contains(Common.HAS_CODE)){
				log.info("Found code");
				return (obj.toString());
			}
		}
		log.warning(Common.NO_CODE_MESS);
		return Common.NO_CODE_MESS;
	}

	public String getCpKeyword(String cp){
		Individual ind = getOntModel().getIndividual(Common.NS + cp);
		StmtIterator iter = ind.listProperties();
		while (iter.hasNext()) {
			Statement stmt      = iter.nextStatement();
			Property  predicate = stmt.getPredicate();   // get the predicate
			Object obj = stmt.getObject();
			Resource subject = stmt.getSubject();

			if(predicate.getLocalName().contains(Common.HAS_KEYWORD)){
				log.info("Found keyword " + obj.toString());
				return (obj.toString());
			}
		}
		log.warning(Common.NO_CODE_MESS);
		return Common.NO_CODE_MESS;
	}

	/**
	 * This method will return one 'CodePattern_Category' for
	 * each category of codePattern.
	 * @return
	 */
	public ArrayList<CodePattern_Category> getAllCodePatternForCategory(){
		ArrayList<CodePattern_Category> toReturn = new ArrayList<CodePattern_Category>();
		ArrayList<Resource> patternCategory_s = getPatternCategory();
		for (Resource r:patternCategory_s){
			toReturn.add(getPatternOfCategory(r.getLocalName()));
		}
		return toReturn;
	}


	/**
	 * Associare il code pattern inserito ad una categoria.
	 * @author Stefania Cardamone
	 */
	public void associateCatAndCodePattern(String category, String codePattern){
		OntClass o = getOntModel().getOntClass(Common.NS+category);
		Individual p1 = getOntModel().createIndividual(Common.NS+codePattern,o);

		//storeOntModel();
	}

	/**
	 * 
	 * @author Stefania Cardamone
	 * Aggiunta di istanze alla propriet� useMethod (ex. useCalendar)
	 *
	 */
	public void addInstanceUseMethod(String category, String pattern, ArrayList<String> method_s){
		Resource c1 = getOntModel().getResource(Common.NS + pattern);

		for (String m : method_s) {
			c1.addProperty(getOntModel().getProperty(Common.NS + "use" + category), getResourceFromBase(Common.NS + m));
		}

		//storeOntModel();
	}
	
	public boolean addUseMethod(String category_name){
		if (getOntModel().getObjectProperty(Common.NS + "use"+category_name)!=null)
			return false;

		OntClass methodClass= null;
		OntClass category = getOntModel().getOntClass(Common.NS + category_name);

		if (category == null){
			category = getOntModel().createClass(Common.NS + category_name);
			OntClass codePattern =  getOntModel().getOntClass(Common.NS + "CodePattern");
			codePattern.addSubClass(category);
			OntClass method = getOntClass("Method");
			methodClass = getOntModel().createClass(Common.NS + category_name + "Method");
			method.addSubClass(methodClass);
		}
		else
			methodClass = getOntModel().getOntClass(Common.NS + category_name + "Method");

		ObjectProperty useMethod = getOntModel().getObjectProperty(Common.NS + "useMethod");
		ObjectProperty useCategory = getOntModel().createObjectProperty(Common.NS + "use"+category_name);	
		useMethod.addSubProperty(useCategory);
		useCategory.setDomain(category);
		useCategory.setRange(methodClass);
		//storeOntModel();
		return true;
	}

	/**
	 * Modifica le informazioni dell'utente.
	 * @author Amedeo Leo
	 */
	public boolean modificaUtente(String username, String password, String nome, String cognome, String email, String avatar) {
		ArrayList<Resource> list = getIndividualOfClass("User");
		
		//non gli setto voti, mi serve solo per controllare se i campi inseriti sono corretti
		Utente u = new Utente(nome,cognome,email,username,password,false, avatar, "inutile", 0);

		boolean modificaPassword = false;
		boolean modificaNome = false;
		boolean modificaCognome = false;
		boolean modificaEmail = false;
		boolean modificaAvatar = false;
		Resource subjectResource = null;

		for(int i = 0; i < list.size(); i++) {
			Resource resource = list.get(i);
			if(resource.getLocalName().equals(username)) {
				StmtIterator iterResource = getOntModel().listStatements(new SimpleSelector(resource,null,(RDFNode)null));

				while (iterResource.hasNext()) {
					Statement stmtResource = iterResource.nextStatement();
					subjectResource = stmtResource.getSubject();
					Property predicateResource = stmtResource.getPredicate();
					RDFNode object = stmtResource.getObject();

					if(predicateResource.getLocalName().equals(Common.HAS_NAME)) {	
						if(!object.toString().equals(nome))
							modificaNome = true;
					}
					if(predicateResource.getLocalName().equals(Common.HAS_SURNAME)) {
						if(!object.toString().equals(cognome))
							modificaCognome = true;
					}
					if(predicateResource.getLocalName().equals(Common.HAS_PASSWORD)) {
						if(!object.toString().equals(password))
							modificaPassword = true;
					}
					if(predicateResource.getLocalName().equals(Common.HAS_EMAIL)) {
						if(!object.toString().equals(email))
							modificaEmail = true;
					}
					if(predicateResource.getLocalName().equals(Common.HAS_AVATAR)) {
						if(!object.toString().equals(avatar))
							modificaAvatar = true;
					}
				}
			}
		}

		if(subjectResource != null) {
			if(modificaNome) {
				subjectResource.getProperty(getProperty(Common.NS + Common.HAS_NAME)).changeObject(nome);
			}
			if(modificaCognome) {
				subjectResource.getProperty(getProperty(Common.NS + Common.HAS_SURNAME)).changeObject(cognome);
			}
			if(modificaPassword) {
				subjectResource.getProperty(getProperty(Common.NS + Common.HAS_PASSWORD)).changeObject(password);
			}
			if(modificaEmail) {
				subjectResource.getProperty(getProperty(Common.NS + Common.HAS_EMAIL)).changeObject(email);
			}
			if(modificaAvatar) {
				subjectResource.getProperty(getProperty(Common.NS + Common.HAS_AVATAR)).changeObject(avatar);
			}
			storeOntModel();
			return true;
		}
		else
			throw new UserException("Utente non esistente");
	}

	/**
	 * Aggiunge una votazione all'utente
	 * @author Amedeo Leo
	 */
	public boolean aggiungiVotoUtente(String username, String codePattern) {
		ArrayList<Resource> list = getIndividualOfClass("User");
		for(int i = 0; i < list.size(); i++) {
			Resource resource = list.get(i);
			if(resource.getLocalName().equals(username)) {
				StmtIterator iterResource = getOntModel().listStatements(new SimpleSelector(resource,null,(RDFNode)null));

				while (iterResource.hasNext()) {
					Statement stmtResource = iterResource.nextStatement();
					Resource subjectResource = stmtResource.getSubject();
					Property predicateResource = stmtResource.getPredicate();
					RDFNode object = stmtResource.getObject();

					if(predicateResource.getLocalName().equals(Common.HAS_VOTED)) {
						if(object.toString().equals("0")) {
							subjectResource.getProperty(getProperty(Common.NS + Common.HAS_VOTED)).changeObject(codePattern + ",");
							storeOntModel();
							return true;
						}
						else {
							//controllo gi� fatto
							//if(hasAlreadyVoted(username, codePattern))
							//throw new UserException("Hai gi� votato questo code pattern");							
							stmtResource.changeObject(object.toString() + codePattern + ",");
							storeOntModel();
							return true;
						}
					}
				}
			}
		}
		return false;
	}

	/** 
	 * Aggiunge una votazione al code pattern
	 * @author Amedeo Leo
	 */
	public boolean aggiungiVotoCodePattern(String username, String codePattern, String votazione) {
		int voto = 0;
		try {
			voto = Integer.parseInt(votazione);
			if(voto > 0 && voto < 11) {
				Resource resource = getOntModel().getResource(Common.NS + codePattern);
				if(isOwner(username, codePattern))
					throw new UserException("Non puoi votare un tuo code pattern");
				if(hasAlreadyVoted(username, codePattern))
					throw new UserException("Hai gi� votato questo code pattern");
				int vecchiVotanti = resource.getProperty(getProperty(Common.NS + Common.HAS_VOTERS)).getObject().asLiteral().getInt();
				int nuoviVotanti = vecchiVotanti + 1;
				Literal nVotanti = getOntModel().createTypedLiteral(new Integer(nuoviVotanti));
				resource.getProperty(getProperty(Common.NS + Common.HAS_VOTERS)).changeObject(nVotanti);
				int score =  resource.getProperty(getProperty(Common.NS + Common.HAS_SCORE)).getObject().asLiteral().getInt();
				String nuovoPunteggio = (voto + score) + "";
				Literal l = getOntModel().createTypedLiteral(new Integer(nuovoPunteggio));
				resource.getProperty(getProperty(Common.NS + Common.HAS_SCORE)).changeObject(l);

				if(aggiungiVotoUtente(username, codePattern)) {				
					storeOntModel();
					return true;
				}
			}
			else 
				throw new UserException("Inserire numero tra 0 e 10");
		}
		catch(NumberFormatException e) {
			throw new UserException("Inserire numero tra 0 e 10");
		}
		return false;
	}

	/**
	 * Restituisce la media delle votazioni di un code pattern
	 * @author Amedeo Leo
	 */
	public float getMediaVotazioni(String codePattern) {
		Resource resource = getOntModel().getResource(Common.NS + codePattern);
		float n_votanti = getNumeroVotanti(codePattern);
		float score =  resource.getProperty(getProperty(Common.NS + Common.HAS_SCORE)).getObject().asLiteral().getInt();
		if(n_votanti == 0.0)
			return 0;
		System.out.println("Media votazione = " + score / n_votanti);
		return (score / n_votanti);
	}

	/**
	 * Restituisce il numero di votanti di un code pattern
	 * @author Amedeo Leo
	 */

	public float getNumeroVotanti(String codePattern) {
		Resource resource = getOntModel().getResource(Common.NS + codePattern);
		Float votanti = resource.getProperty(getProperty(Common.NS + Common.HAS_VOTERS)).getObject().asLiteral().getFloat();
		return votanti;
	}

	/** 
	 * Controlla se l'utente � il proprietario del code pattern (in modo da non poterlo votare)
	 * @author Amedeo Leo
	 */
	public boolean isOwner(String username, String codePattern) {
		Resource cp = getOntModel().getResource(Common.NS + codePattern);
		String o = cp.getProperty(getProperty(Common.NS + Common.HAS_OWNER)).getObject().toString();
		String owner = o.substring(o.indexOf("#") + 1);
		if(owner.equals(username)) 
			return true;
		return false;
	}

	/**
	 * Controlla se l'utente ha gi� votato il code pattern
	 * @author Amedeo Leo
	 */
	public boolean hasAlreadyVoted(String username, String codePattern) {
		Resource resource = getOntModel().getResource(Common.NS + username);
		String hasVoted = resource.getProperty(getProperty(Common.NS + Common.HAS_VOTED)).getObject().toString();
		String[] array = hasVoted.split(",");
		for(int j = 0; j < array.length; j++) {
			if(array[j].equals(codePattern)) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Modifica i permessi all'utente.
	 * @author Amedeo Leo
	 */
	public boolean modificaPermessiUtente(String username, boolean isAdministrator) {
		Resource resource = getOntModel().getResource(Common.NS + username);
		if(isAdministrator(username) && isAdministrator) 
			return true;
		if(!isAdministrator(username) && !isAdministrator)
			return true;
		if(isAdministrator)
			resource.getProperty(getProperty(Common.NS + Common.IS_ADMINISTRATOR)).changeObject("si");
		else
			resource.getProperty(getProperty(Common.NS + Common.IS_ADMINISTRATOR)).changeObject("no");
		storeOntModel();
		return true;
	}

	/**
	 * Restituisce la classifica degli utenti
	 * @author Amedeo Leo
	 */
	public ArrayList<String> classificaUtenti() {
		ArrayList<String> utenteCodePattern = new ArrayList<String>();
		boolean trovato = false;

		ExtendedIterator<OntClass> ext = getOntModel().getOntClass(Common.NS + Common.CODE_PATTERN).listSubClasses();
		while(ext.hasNext()) {
			OntClass o = ext.next();
			Resource r = getOntModel().getResource(Common.NS + o.getLocalName());
			ArrayList<Resource> list = getIndividualOfClass(r.getLocalName());
			for(int i = 0; i < list.size(); i++) {
				Resource resource = list.get(i);
				StmtIterator iterResource = getOntModel().listStatements(new SimpleSelector(resource,null,(RDFNode)null));
				while (iterResource.hasNext()) {
					Statement stmtResource = iterResource.nextStatement();
					Resource subjectResource = stmtResource.getSubject();
					Property predicateResource = stmtResource.getPredicate();
					RDFNode object = stmtResource.getObject();

					String subject = subjectResource.getLocalName();
					if(predicateResource.getLocalName().equals(Common.HAS_OWNER)) {
						String string_object = object.toString().substring(object.toString().indexOf("#") + 1);
						System.out.println(string_object);
						for(String s : utenteCodePattern) {
							String[] array = s.split(",");
							float votoCorrente = Float.parseFloat(array[1]);
							float numeroVotantiCodePattern = Float.parseFloat(array[2]);
							int numeroVotantiUtente  = Integer.parseInt(array[3]);

							if(array[0].equals(string_object)) {
								votoCorrente += getMediaVotazioni(subject);
								numeroVotantiCodePattern += getNumeroVotanti(subject);
								numeroVotantiUtente += 1;
								utenteCodePattern.remove(s);
								utenteCodePattern.add(string_object + "," + votoCorrente + "," + numeroVotantiCodePattern + "," + numeroVotantiUtente + "," + getAvatar(string_object));
								trovato = true;
								break;
							}
						}
						if(!trovato) {
							float mediaVotazioni = getMediaVotazioni(subject);
							if(!(mediaVotazioni == 0.0)) {
								 utenteCodePattern.add(string_object + ","  + getMediaVotazioni(subject) + "," + getNumeroVotanti(subject) + "," + 1  +  "," + getAvatar(string_object));
							}
						}
						trovato = false;
					}
				}
			}
		}
		return utenteCodePattern;
	}

	/**
	 * Restituisce l'avatar dell'utente
	 */
	
	public String getAvatar(String username) {
		Resource resource = getOntModel().getResource(Common.NS + username);
		String avatar="";
		Object r = resource.getProperty(getProperty(Common.NS + Common.HAS_AVATAR));
		if ( r == null)
			 avatar = "res/nouser.png";
		else
			 avatar = resource.getProperty(getProperty(Common.NS + Common.HAS_AVATAR)).getObject().toString();
		return avatar;
	}

	/**
	 * get info from classificaUtenti() end create UserClassification Objects
	 * @author Amati Ciro
	 */


	public ArrayList<UserClassification> getInfoUserClassification (ArrayList<String> listUsers){
		ArrayList<UserClassification> listUserClassification = new ArrayList<UserClassification>();

		for (String u: listUsers){
			String[] tmp = u.split(",");
			UserClassification uc = new UserClassification(tmp[0],tmp[1] , tmp[2], tmp[3], tmp[4]);
			listUserClassification.add(uc);

		}
		
	return listUserClassification;

	}
	
	public Utente getUtente(String username) {
		for(Utente u: getUsers()) {			
			if(u.getNickname().equals(username)) {
				return u;
			}
		}
		return null;
	}
	
	/**
	 * 
	 * Restituisce il numero di stelle dell'utente.
	 * @author Amedeo Leo
	 * 
	 */
	
	public int getNumeroStelle(String username) {
		int numeroCodePattern = 0;
		float score = 0;
		ExtendedIterator<OntClass> ext = getOntModel().getOntClass(Common.NS + Common.CODE_PATTERN).listSubClasses();
		String string_object = "";
		while(ext.hasNext()) {
			OntClass o = ext.next();
			Resource r = getOntModel().getResource(Common.NS + o.getLocalName());
			ArrayList<Resource> list = getIndividualOfClass(r.getLocalName());
			for(int i = 0; i < list.size(); i++) {
				Resource resource = list.get(i);
				StmtIterator iterResource = getOntModel().listStatements(new SimpleSelector(resource,null,(RDFNode)null));
				while (iterResource.hasNext()) {
					Statement stmtResource = iterResource.nextStatement();
					Resource subjectResource = stmtResource.getSubject();
					Property predicateResource = stmtResource.getPredicate();
					RDFNode object = stmtResource.getObject();

					String subject = subjectResource.getLocalName();
					if(predicateResource.getLocalName().equals(Common.HAS_OWNER)) {
						string_object = object.toString().substring(object.toString().indexOf("#") + 1);
						if(string_object.equals(username)) {
							score += getMediaVotazioni(subject);
							numeroCodePattern++;
						}
					}
				}
			}
		}
		
		if(numeroCodePattern == 0 || score == 0.0) {
			return 0;
		}
		getOntModel().getResource(Common.NS + username).getProperty(getProperty(Common.NS + Common.HAS_STARS)).changeLiteralObject(Math.round(score / numeroCodePattern));
		return Math.round(score / numeroCodePattern);
	}
	
	
	/**
	 * Modifica il numero di stelle dell'utente
	 * @author Amedeo Leo
	 */
	public int cambiaStelle(String username) {
		Resource resource = getOntModel().getResource(Common.NS + username);
		int vecchieStelle = resource.getProperty(getProperty(Common.NS + Common.HAS_STARS)).getInt();
		System.out.println("vecchie stelle (3): "+vecchieStelle);
		int nuoveStelle = getNumeroStelle(username);
		if (vecchieStelle!= nuoveStelle){
		resource.getProperty(getProperty(Common.NS + Common.HAS_STARS)).changeLiteralObject(nuoveStelle);
		storeOntModel();
		}
		return nuoveStelle;
	}
	
	public void setOwner(String codePattern){
		addObjectPropertyInstance(Common.HAS_OWNER, codePattern, Common.UTENTE.getNickname());
		//storeOntModel();
	}
	
	public void setLibrary(String codePattern, String library){
		addObjectPropertyInstance(Common.HAS_LIBRARY, codePattern, library);
	}
	
	public boolean setCPSourceCode(String code, String risorsa) {
		Individual ind = getOntModel().getIndividual(Common.NS + risorsa);
		DatatypeProperty hasCode = getOntModel().getDatatypeProperty(Common.NS + Common.HAS_CODE);
		ind.addProperty(hasCode, code);
		log.info("Added property " + code);
		return true;
	}
	
	public void initScoreVoters(String risorsa){
		Individual ind = getOntModel().getIndividual(Common.NS + risorsa);
		DatatypeProperty hasVoters = getOntModel().getDatatypeProperty(Common.NS + Common.HAS_VOTERS);
		ind.addProperty(hasVoters, "0");
		DatatypeProperty hasScore = getOntModel().getDatatypeProperty(Common.NS + Common.HAS_SCORE);
		ind.addProperty(hasScore, "0");
	}
	
	/**
	 * If users == 0, create admin
	 * @author Amedeo Leo & Ciro Amati
	 */
	
	public boolean createAdmin(){
		if (getUsers().size()==0)
			return true;
		return false;
	}

	
	/**
	 * Controlla se un codePattern ha la keyword passata in input.
	 * @author Amedeo Leo
	 */
	public boolean hasKeyword(String codePattern, String keyword) {
		if(getOntModel().getResource(Common.NS + codePattern).getProperty(getProperty(Common.NS + Common.HAS_KEYWORD)).getString().equals(keyword))
			return true;
		return false;
	}
}
