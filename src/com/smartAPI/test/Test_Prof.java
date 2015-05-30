package com.smartAPI.test;

import com.hp.hpl.jena.rdf.model.*;
import com.hp.hpl.jena.vocabulary.*;
import com.hp.hpl.jena.util.*;

import java.io.*;

import com.hp.hpl.jena.ontology.*;
import com.hp.hpl.jena.reasoner.*;

import java.util.*;

import com.hp.hpl.jena.tdb.*;
import com.hp.hpl.jena.query.*;

/*
 https://jena.apache.org/tutorials/rdf_api.html

 http://www.w3.org/TR/vcard-rdf/
 */

public class Test_Prof {
	// some definitions
	static String personURI = "http://somewhere/JohnSmith";
	static String fullName = "John Smith";

	Model model1 = null;
	
	public void myTest4(){
		String NS = "http://www.semanticweb.org/simone/ontologies/2015/4/SmartAPI#";
		OntModel m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);		
		InputStream in = FileManager.get().open("C:\\Users\\Simone\\Google Drive\\unisa_II_semestre\\GestioneProgettiSoftware\\res\\SmartAPI_1.2.owl");
		if (in == null) {
			throw new IllegalArgumentException("File: " + "SmartAPI_1.2.owl"+ " not found");
		}
		m.read(in, null);		
		OntModel inf = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM_RDFS_INF, m);
		
		StmtIterator iter = inf.listStatements();
		// print out the predicate, subject and object of each statement
		while (iter.hasNext()) {
			Statement stmt = iter.nextStatement(); // get next statement
			Resource subject = stmt.getSubject(); // get the subject
			Property predicate = stmt.getPredicate(); // get the predicate
			RDFNode object = stmt.getObject(); // get the object

			if (predicate.getLocalName().contains("type") && object instanceof Resource) {
				if(object.toString().contains("CalendarMethod"))		
					System.out.println(subject.getLocalName() + " - " + object.asNode().getLocalName());
			} 
		}		
	}
	
	public void getCodePatternInstances(){
		String NS = "http://www.semanticweb.org/simone/ontologies/2015/4/SmartAPI#";
		OntModel m = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);		
		InputStream in = FileManager.get().open("C:\\Users\\Simone\\Google Drive\\unisa_II_semestre\\GestioneProgettiSoftware\\res\\SmartAPI_1.2.owl");
		if (in == null) {
			throw new IllegalArgumentException("File: " + "SmartAPI_1.2.owl"+ " not found");
		}
		m.read(in, null);		
		OntModel inf = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM_RDFS_INF, m);
		
		for (Iterator<Individual> i = m.listIndividuals(); i.hasNext();) {
			Individual c = i.next();
			if(c.getOntClass().hasSuperClass())
				if (c.getOntClass().getSuperClass().getLocalName().contains("CodePattern"))
					System.out.println(c.getLocalName() + " - "	+ c.getOntClass().getURI());
		}
	}

	
	public void myTest5(){
		String NS = "http://www.semanticweb.org/simone/ontologies/2015/4/SmartAPI#";
		OntModel base = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
		OntModel inf = ModelFactory.createOntologyModel(OntModelSpec.OWL_DL_MEM_RDFS_INF, base);

		// Creo le classi perchè non ho caricato lo schema con la "read"
		OntClass codePattern = base.createClass(NS + "CodePattern");
		OntClass parser = base.createClass(NS + "Parser");
		OntClass storage = base.createClass(NS + "Storage");
		codePattern.addSubClass(parser);
		codePattern.addSubClass(storage);
		
		OntClass method = base.createClass(NS + "Method");
		OntClass parserMethod = base.createClass(NS + "ParserMethod");
		OntClass storageMethod = base.createClass(NS + "StorageMethod");
		method.addSubClass(parserMethod);
		method.addSubClass(storageMethod);

		ObjectProperty useMethod = base.createObjectProperty(NS + "useMethod");
		
		ObjectProperty useStorage = base.createObjectProperty(NS + "useStorage");	
		useMethod.addSubProperty(useStorage);
		useStorage.addLabel("use Storage", "en");
		useStorage.setDomain(storageMethod);
		useStorage.setRange(storage);		
		
		
		ObjectProperty useParser = base.createObjectProperty(NS + "useParser");	
		useMethod.addSubProperty(useParser);
		useParser.addLabel("use Parser", "en");
		useParser.setDomain(parserMethod);
		useParser.setRange(parser);

		
		
		Individual s1 = base.createIndividual(NS + "s1", storage);
		Individual p1 = base.createIndividual(NS + "p1", parser);
		Resource m1 = base.createResource(NS + "m1");
		Resource m2 = base.createResource(NS + "m2");
		Resource m3 = base.createResource(NS + "m3");

		m1.addProperty(useStorage, s1);
		m1.addProperty(useParser, p1);
		m2.addProperty(useParser, p1);
		m3.addProperty(useParser, p1);

		
		StmtIterator iter = inf.listStatements();
		// print out the predicate, subject and object of each statement
		while (iter.hasNext()) {
			Statement stmt = iter.nextStatement(); // get next statement
			Resource subject = stmt.getSubject(); // get the subject
			Property predicate = stmt.getPredicate(); // get the predicate
			RDFNode object = stmt.getObject(); // get the object

			//System.out.print(subject.toString());
			//System.out.print(" " + predicate.toString() + " ");
			if (predicate.getLocalName().contains("type") && object instanceof Resource) {
				if(object.toString().contains("StorageMethod"))					
					System.out.println(subject.getLocalName() + " - " + object.asNode().getLocalName());
			} 
		}
		
		//inf.write(new FileOutputStream(new File(""));
	
	}
	
	public static void main(String[] args) {
		Test_Prof m = new Test_Prof();

		m.myTest4();
		/*
		 * 1
		 */
		// m.firstExample();

		/*
		 * 2
		 */
		// m.secondExample();

		/*
		 * 3
		 */
		// m.secondExample();
		// m.thirdExample();

		/*
		 * 4
		 */
		// m.fourthExample();

		/*
		 * 5
		 */
		// m.fourthExample();
		// m.fifthExample();

		/*
		 * 6
		 */
		// m.fourthExample();
		// m.sixthExample();

		/*
		 * 1 RDFS
		 */
		// m.firstRDFSexample();

		/*
		 * 2 RDFS
		 */
		 //m.secondRDFSexample();

		/*
		 * 1 OWL
		 */
		 //m.firstOWLExample();

		/*
		 * 2 OWL
		 */
		 //m.secondOWLExample();

		/*
		 * 3 OWL
		 */
		// m.thirdOWLExample();

		/*
		 * 4 OWL
		 */
		// m.fourthOWLExample();

		/*
		 * 5 OWL
		 */
		// m.fifthOWLExample();

		/*
		 * 1 TDB
		 */
		// m.firstTDBExample();

		/*
		 * 1 ARQ
		 */
		// m.firstARQExample();
	}

	public void firstExample() {
		// create an empty model
		Model model = ModelFactory.createDefaultModel();

		// create the resource
		Resource johnSmith = model.createResource(personURI);
		Property p = model.createProperty(
				"http://edu.unisa.di.fraorc/ontologies/", "hasFather");
		Resource adamSmith = model.createResource("http://somewhere/AdamSmith");

		// add the property
		johnSmith.addProperty(VCARD.FN, fullName);
		johnSmith.addProperty(p, adamSmith);
	}

	public void secondExample() {
		// some definitions
		String personURI = "http://somewhere/JohnSmith";
		String givenName = "John";
		String familyName = "Smith";
		String fullName = givenName + " " + familyName;

		// create an empty Model
		model1 = ModelFactory.createDefaultModel();

		// create the resource
		// and add the properties cascading style
		Resource johnSmith = model1
				.createResource(personURI)
				.addProperty(VCARD.FN, fullName)
				.addProperty(
						VCARD.N,
						model1.createResource()
								.addProperty(VCARD.Given, givenName)
								.addProperty(VCARD.Family, familyName));

		model1.write(System.out);
	}

	public void thirdExample() {
		// list the statements in the Model
		StmtIterator iter = model1.listStatements();

		// print out the predicate, subject and object of each statement
		while (iter.hasNext()) {
			Statement stmt = iter.nextStatement(); // get next statement
			Resource subject = stmt.getSubject(); // get the subject
			Property predicate = stmt.getPredicate(); // get the predicate
			RDFNode object = stmt.getObject(); // get the object

			System.out.print(subject.toString());
			System.out.print(" " + predicate.toString() + " ");
			if (object instanceof Resource) {
				System.out.print(object.toString());
			} else {
				// object is a literal
				System.out.print(" \"" + object.toString() + "\"");
			}

			System.out.println(" .");
		}
	}

	public void fourthExample() {
		// create an empty model
		model1 = ModelFactory.createDefaultModel();

		// use the FileManager to find the input file
		InputStream in = FileManager.get().open("names1.rdf");
		if (in == null) {
			throw new IllegalArgumentException("File: " + "names1.rdf"
					+ " not found");
		}

		// read the RDF/XML file
		model1.read(in, null);

		// write it to standard out
		model1.write(System.out);
	}

	public void fifthExample() {
		// retrieve the John Smith vcard resource from the model
		Resource vcard = model1.getResource(personURI);
		String fName = vcard.getProperty(VCARD.FN).getString();
		System.out.println(fName);
	}

	public void sixthExample() {

		StmtIterator iter = model1.listStatements(new SimpleSelector(null,
				VCARD.FN, (RDFNode) null));
		if (iter.hasNext()) {
			System.out.println("The database contains vcards for:");
			while (iter.hasNext()) {
				System.out.println("  "
						+ iter.nextStatement().getSubject().getURI());
			}
		} else {
			System.out.println("No vcards were found in the database");
		}
	}

	private void samplePrint(Model _m, Selector s) {
		StmtIterator iter = _m.listStatements(s);
		// print out the predicate, subject and object of each statement
		while (iter.hasNext()) {
			Statement stmt = iter.nextStatement(); // get next statement
			Resource subject = stmt.getSubject(); // get the subject
			Property predicate = stmt.getPredicate(); // get the predicate
			RDFNode object = stmt.getObject(); // get the object

			System.out.print(subject.toString());
			System.out.print(" " + predicate.toString() + " ");
			if (object instanceof Resource) {
				System.out.print(object.toString());
			} else {
				// object is a literal
				System.out.print(" \"" + object.toString() + "\"");
			}

			System.out.println(" .");
		}
	}

	/*
	 * RDFS 1
	 */
	public void firstRDFSexample() {
		// create an empty model
		Model model = ModelFactory.createDefaultModel();

		// create classes
		Resource personClass = model.createResource("http://somewhere/Person");
		Resource fatherClass = model.createResource("http://somewhere/Father");
		personClass.addProperty(RDF.type, RDFS.Class);
		fatherClass.addProperty(RDF.type, RDFS.Class);
		fatherClass.addProperty(RDFS.subClassOf, personClass);

		// create instances
		Resource johnSmith = model.createResource(personURI);
		Resource adamSmith = model.createResource("http://somewhere/AdamSmith");
		johnSmith.addProperty(RDF.type, personClass);
		adamSmith.addProperty(RDF.type, fatherClass);

		samplePrint(model, new SimpleSelector(adamSmith, null, (RDFNode) null));

		System.out.println("*******");

		InfModel rdfsInfModel = ModelFactory.createRDFSModel(model);

		// list the statements in the Model
		samplePrint(rdfsInfModel, new SimpleSelector(adamSmith, null,
				(RDFNode) null));
	}

	/*
	 * RDFS 2
	 */
	public void secondRDFSexample() {
		// create an empty model
		Model model = ModelFactory.createDefaultModel();

		// create classes
		Resource personClass = model.createResource("http://somewhere/Person");
		Resource fatherClass = model.createResource("http://somewhere/Father");
		Resource sonClass = model.createResource("http://somewhere/Son");

		personClass.addProperty(RDF.type, RDFS.Class);
		fatherClass.addProperty(RDF.type, RDFS.Class);
		fatherClass.addProperty(RDFS.subClassOf, personClass);
		sonClass.addProperty(RDFS.subClassOf, personClass);

		// create instances
		Resource johnSmith = model.createResource(personURI);
		Resource adamSmith = model.createResource("http://somewhere/AdamSmith");
		johnSmith.addProperty(RDF.type, personClass);
		adamSmith.addProperty(RDF.type, fatherClass);

		// create additional properties
		Property hasFather = model.createProperty("http://somewhere/",
				"hasFather");
		hasFather.addProperty(RDFS.domain, sonClass);

		// add properties to the model
		johnSmith.addProperty(hasFather, adamSmith);

		samplePrint(model, new SimpleSelector(johnSmith, null, (RDFNode) null));

		System.out.println("*******");

		InfModel rdfsInfModel = ModelFactory.createRDFSModel(model);

		// list the statements in the Model
		samplePrint(rdfsInfModel, new SimpleSelector(johnSmith, null,
				(RDFNode) null));
	}

	/*
	 * OWL eswc
	 */

	public void firstOWLExample() {
		// http://www.eswc2006.org/www.eswc2006.org/technologies/ontology-content/2006-09-21.rdf

		// create the base model
		String SOURCE = "http://www.eswc2006.org/technologies/ontology";
		String NS = SOURCE + "#";
		OntModel base = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
		base.read("2006-09-21.rdf", "RDF/XML");

		// create the reasoning model using the base
		OntModel inf = ModelFactory.createOntologyModel(
				OntModelSpec.OWL_MEM_MICRO_RULE_INF, base);

		// create a dummy paper for this example
		OntClass paper = base.getOntClass(NS + "Paper");
		Individual p1 = base.createIndividual(NS + "paper1", paper);

		// list the asserted types
		for (Iterator<Resource> i = p1.listRDFTypes(false); i.hasNext();) {
			System.out.println(p1.getURI() + " is asserted in class "
					+ i.next());
		}

		// list the inferred types
		p1 = inf.getIndividual(NS + "paper1");
		for (Iterator<Resource> i = p1.listRDFTypes(false); i.hasNext();) {
			System.out.println(p1.getURI() + " is inferred to be in class "
					+ i.next());
		}

		/* Second Example */
		// OntClass artefact = inf.getOntClass( NS + "Artefact" );
		// for (Iterator<OntClass> i = artefact.listSubClasses(); i.hasNext(); )
		// {
		// OntClass c = i.next();
		// System.out.println( c.getURI() );
		// }
	}

	public void secondOWLExample() {
		String NS = "http://www.unisa.it/fraorc#";
		OntModel base = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
		OntModel inf = ModelFactory.createOntologyModel(
				OntModelSpec.OWL_DL_MEM_RDFS_INF, base);

		// Creo le classi perchè non ho caricato lo schema con la "read"
		OntClass programme = base.createClass(NS + "Programme");
		OntClass orgEvent = base.createClass(NS + "OrganizedEvent");

		ObjectProperty hasProgramme = base.createObjectProperty(NS
				+ "hasProgramme");

		hasProgramme.addDomain(orgEvent);
		hasProgramme.addRange(programme);
		hasProgramme.addLabel("has programme", "en");

		Individual ind1 = base.createIndividual(NS + "event01", orgEvent);

		// Non dichiaro esplicitamente che "programme01" è di tipo "Programme"
		Resource res2 = base.createResource(NS + "programme01");

		ind1.addProperty(hasProgramme, res2); // sto dicendo che la risorsa
												// (generica) res2 è programma
												// ("hasProgramme") di "event1";
												// per inferenza sarà un
												// programma

		// Uso l'inferred model per fare inferenza
		for (Iterator<Individual> i = inf.listIndividuals(); i.hasNext();) {
			Individual c = i.next();
			System.out.println(c.getLocalName() + " - "
					+ c.getOntClass().getURI());
		}

	}

	void thirdOWLExample() {
		String NS = "http://www.unisa.it/fraorc#";
		OntModel base = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);

		OntClass programme = base.createClass(NS + "Programme");
		OntClass orgEvent = base.createClass(NS + "OrganizedEvent");

		ObjectProperty hasProgramme = base.createObjectProperty(NS
				+ "hasProgramme");

		hasProgramme.addDomain(orgEvent);
		hasProgramme.addRange(programme);
		hasProgramme.addLabel("has programme", "en");

		Individual ind1 = base.createIndividual(NS + "event01", orgEvent);

		Resource res2 = base.createResource(NS + "programme01");
		ind1.addProperty(hasProgramme, res2);

		Reasoner reasoner = ReasonerRegistry.getOWLReasoner();
		reasoner = reasoner.bindSchema(base);
		InfModel infmodel = ModelFactory.createInfModel(reasoner, base);
		OntModel inf = ModelFactory.createOntologyModel(
				OntModelSpec.OWL_DL_MEM_RDFS_INF, base);

		base.write(System.out);
		System.out.println("");
		System.out.println("");
		infmodel.write(System.out);

		for (Iterator<Statement> i = infmodel.listStatements(new SimpleSelector(res2, RDF.type,	(RDFNode) null)); i.hasNext();) {
			Statement c = i.next();
			System.out.println(c.getPredicate() + " " + c.getObject());
		}
	}

	void fourthOWLExample() {
		String SOURCE = "http://xmlns.com/foaf/0.1/";
		String NS = SOURCE;
		OntModel base = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
		base.read(SOURCE, "RDF/XML");

		OntModel inf = ModelFactory.createOntologyModel(
				OntModelSpec.OWL_DL_MEM_RULE_INF, base);

		Iterator<OntProperty> i = inf.listAllOntProperties();
		while (i.hasNext()) {
			OntProperty c = i.next();
			System.out.println(c.getURI());
		}

		OntClass person = inf.createClass(SOURCE + "Person");

		ObjectProperty knowsTransitive = inf
				.createObjectProperty("http://fraorc#" + "knowsTransitive");
		knowsTransitive.convertToTransitiveProperty();
		Individual person1 = inf.createIndividual("http://fraorc#" + "a",
				person);
		Individual person2 = inf.createIndividual("http://fraorc#" + "b",
				person);
		Individual person3 = inf.createIndividual("http://fraorc#" + "c",
				person);

		person1.addProperty(knowsTransitive, person2);
		person2.addProperty(knowsTransitive, person3);

		NodeIterator listPropertyValues = person1
				.listPropertyValues(knowsTransitive);

		while (listPropertyValues.hasNext()) {
			RDFNode c = listPropertyValues.next();
			System.out.println(c.asResource().getURI());
		}
	}

	void fifthOWLExample() {
		OntModel model = ModelFactory
				.createOntologyModel(OntModelSpec.OWL_DL_MEM_RULE_INF);

		OntClass persona = model.createClass("http://fraorc/" + "Persona");
		OntClass docente = model.createClass("http://fraorc/" + "Docente");
		OntClass corso = model.createClass("http://fraorc/" + "Corso");

		Individual p1 = model
				.createIndividual("http://fraorc/" + "p1", persona);
		Individual p2 = model
				.createIndividual("http://fraorc/" + "p2", persona);
		Individual p3 = model
				.createIndividual("http://fraorc/" + "p3", persona);
		Individual p4 = model
				.createIndividual("http://fraorc/" + "p4", persona);

		Individual c1 = model.createIndividual("http://fraorc/" + "c1", corso);
		Individual c2 = model.createIndividual("http://fraorc/" + "c2", corso);

		OntProperty insegna = model.createObjectProperty("http://fraorc/"
				+ "insegna");

		p1.addProperty(insegna, c1);
		p2.addProperty(insegna, c2);
		p3.addProperty(insegna, p1);

		Restriction rest = model.createRestriction(insegna);
		rest.convertToSomeValuesFromRestriction(corso);

		Iterator<OntResource> ontResourceIterator = (Iterator<OntResource>) rest.listInstances();

		while (ontResourceIterator.hasNext()) {
			RDFNode c = ontResourceIterator.next();
			System.out.println(c.asResource().getURI());
		}
	}

	/* TDB */
	void firstTDBExample() {
		// Make a TDB-backed dataset
		String directory = "Dataset2";
		Dataset dataset = TDBFactory.createDataset(directory);

		String NS = "http://www.unisa.it/fraorc#";
		OntModel base = ModelFactory.createOntologyModel(OntModelSpec.OWL_MEM);
		OntModel inf = ModelFactory.createOntologyModel(
				OntModelSpec.OWL_DL_MEM_RDFS_INF, base);

		// Creo le classi perchè non ho caricato lo schema con la "read"
		OntClass programme = base.createClass(NS + "Programme");
		OntClass orgEvent = base.createClass(NS + "OrganizedEvent");

		ObjectProperty hasProgramme = base.createObjectProperty(NS
				+ "hasProgramme");

		hasProgramme.addDomain(orgEvent);
		hasProgramme.addRange(programme);
		hasProgramme.addLabel("has programme", "en");

		Individual ind1 = base.createIndividual(NS + "event01", orgEvent);

		// Non dichiaro esplicitamente che "programme01" è di tipo "Programme"
		Resource res2 = base.createResource(NS + "programme01");

		ind1.addProperty(hasProgramme, res2);

		/* Scrittura nello storage come Named Graph */
		dataset.begin(ReadWrite.WRITE);
		dataset.addNamedModel("http://fraorc/graph01", inf);
		dataset.commit();
		dataset.end();

		/* Lettura dallo storage */
		dataset.begin(ReadWrite.READ);
		Model model = dataset.getNamedModel("http://fraorc/graph01");
		dataset.end();

		model.write(System.out);
	}

	/* SPARQL -ARQ */
	void firstARQExample() {
		String directory = "Dataset2";
		Dataset dataset = TDBFactory.createDataset(directory);

		/* Lettura dallo storage */
		dataset.begin(ReadWrite.READ);
		Model model = dataset.getNamedModel("http://fraorc/graph01");
		dataset.end();

		// String queryString =
		// "SELECT ?p ?o WHERE {<http://www.unisa.it/fraorc#programme01> ?p ?o}"
		// ;
		String queryString = "SELECT ?p WHERE {<http://www.unisa.it/fraorc#event01> ?p <http://www.unisa.it/fraorc#programme01>}";
		Query query = QueryFactory.create(queryString);
		try {
			QueryExecution qexec = QueryExecutionFactory.create(query, model);
			ResultSet results = qexec.execSelect();
			for (; results.hasNext();) {

				QuerySolution soln = results.nextSolution();

				// RDFNode subject = soln.get("s") ; // Get a result variable by
				// name.
				RDFNode predicate = soln.get("p"); // Get a result variable -
													// must be a resource
				// RDFNode object = soln.get("o") ; // Get a result variable -
				// must be a literal
				// System.out.println(" "+predicate.toString()+" "+object.toString());
				System.out.println("PREDICATE: " + predicate.toString());
			}
		} catch (Exception e) {
			System.out.println("****** ERROR ******");
		}
	}

}
