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

	private OntClass getOntClass(String className) {
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
	 * Aggiunge la proprietà hasKeyword ad una risorsa
	 * @author Amedeo Leo
	 */
	public boolean addKeyword(String risorsa, String keyword) {
		Individual ind = getOntModel().getIndividual(Common.NS + risorsa);
		DatatypeProperty hasKeyword = getOntModel().getDatatypeProperty(Common.NS + "hasKeyword");
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
	 * Controlla se una risorsa ha una proprieta'.
	 * @author Amedeo Leo
	 */
	private boolean hasProperty(Selector selector, String property) {
		StmtIterator iter = listStatements(selector);
        while (iter.hasNext()) {
            Statement stmt      = iter.nextStatement();
            Property  predicate = stmt.getPredicate();   // get the predicate
            log.info(predicate.toString().substring(predicate.toString().indexOf("#")));
            log.info("Property: " + property);
            if(predicate.toString().substring(predicate.toString().indexOf("#")).equals("#" + property))
            	return true;
        }
		return false;
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
	
	public boolean addUser(String nome, String cognome, String email, String username, String password) {
		OntClass userClass = getOntModel().getOntClass(Common.NS + Common.USER);
		if(!userAlreadyExists(userClass.getLocalName(), username)) {
			try {
				Utente user = new Utente(nome, cognome, email, username, password);
				getOntModel();
				String userId = calculateID(userClass.getLocalName());
				String newUserId = String.valueOf(Integer.parseInt(userId) + 1);
				System.out.println(newUserId);
				
				Individual individualUser1 = getOntModel().createIndividual(Common.NS + "u" + newUserId , userClass);
				DatatypeProperty hasUsername = getOntModel().getDatatypeProperty(Common.NS + Common.HAS_USERNAME);
				DatatypeProperty hasPassword = getOntModel().getDatatypeProperty(Common.NS + Common.HAS_PASSWORD);
				DatatypeProperty hasName = getOntModel().getDatatypeProperty(Common.NS + Common.HAS_NAME);
				DatatypeProperty hasSurname = getOntModel().getDatatypeProperty(Common.NS + Common.HAS_SURNAME);
				DatatypeProperty hasEmail = getOntModel().getDatatypeProperty(Common.NS + Common.HAS_EMAIL);
		
				individualUser1.addProperty(hasUsername, username);
				individualUser1.addProperty(hasPassword, password);
				individualUser1.addProperty(hasEmail, email);
				individualUser1.addProperty(hasName, nome);
				individualUser1.addProperty(hasSurname, cognome);
				storeOntModel();							
			}
			catch(UserException e) {
				log.severe(e.getMessage());
				return false;
			}
			
			return true;
		}
		else
			return false;
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
	private String calculateID(String userClass) {
		String id = "0";
		ArrayList<Resource> list = getIndividualOfClass(userClass);
		for(int i = 0; i < list.size(); i++) {
			Resource resource = list.get(i);
			StmtIterator iter = getOntModel().listStatements(new SimpleSelector(resource,null,(RDFNode)null));
			while (iter.hasNext()) {
				Statement stmt = iter.nextStatement();
				Resource subject = stmt.getSubject(); // get the subject
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
}
