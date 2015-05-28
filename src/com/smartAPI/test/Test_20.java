package com.smartAPI.test;
import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.FieldDeclaration;
import japa.parser.ast.body.MethodDeclaration;
import japa.parser.ast.body.VariableDeclarator;
import japa.parser.ast.body.VariableDeclaratorId;
import japa.parser.ast.expr.Expression;
import japa.parser.ast.expr.FieldAccessExpr;
import japa.parser.ast.expr.MethodCallExpr;
import japa.parser.ast.expr.VariableDeclarationExpr;
import japa.parser.ast.type.Type;
import japa.parser.ast.visitor.VoidVisitorAdapter;

import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;

import javax.swing.JFrame;

import com.smartAPI.view.Desktop_0;

/**
 * Ricerca dei metodi all'interno del code pattern inserito.
 * @author iolrin
 *
 */
public class Test_20 {
	
	public static Logger logger = Logger.getLogger("global");
	public static String CLASS_DEF = "public class Prova{ ";
    public static void main(String[] args) throws Exception {
    	//String code = "	public JFrame f; public String stringa; public  void metodo() {String f=null; f.toString(); f.setSize(1300, 900);f.add(new Desktop_0(f));f.setVisible(true);f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);} public static void main(String[]args){f.reload(); stringa.stampa();} ";
    	String code="public void metodo() { VariableVisitor1 vis1 = new VariableVisitor1(); vis1.visit(cu, null);}";
    /*	String code = "public class Prova{private static File createFile(String testo) throws "+ "IOException{String content = testo; File file = new File(\"test1.java\");if (!file.exists())"
    			+ "{file.createNewFile();}FileWriter fw = new FileWriter(file.getAbsoluteFile()); "
    			+ "BufferedWriter bw = new BufferedWriter(fw);bw.write(content);bw.close(); return file;}}";*/
    	InputStream is = new ByteArrayInputStream(code.getBytes());
        CompilationUnit cu=null;
        try {
           cu = JavaParser.parse(is);
        }catch(ParseException e){
        	code = CLASS_DEF + code + "}";
        	InputStream is1 = new ByteArrayInputStream(code.getBytes());
        	try{
        		cu = JavaParser.parse(is1);
        	}catch(ParseException e1){
        		logger.severe("Non riesco a risolvere l'errore");
        	}
        }
        
        
        VariableVisitor1 vis1 = new VariableVisitor1();
        vis1.visit(cu, null);
        ArrayList<FieldDeclaration> variab= vis1.getVarList();
        System.out.println("field: "+variab);
        
        VariableVisitor varVisitor = new VariableVisitor();
        varVisitor.visit(cu, null);
        ArrayList<VariableDeclarationExpr> variables = varVisitor.getVarList();
       System.out.println("variables: "+variables);
        MethodVisitor methVisitor = new MethodVisitor();
        methVisitor.visit(cu, null);
        ArrayList<MethodCallExpr> methods = methVisitor.getMethodList();

	       System.out.println("methods: "+methods);
	       HashMap<String,String> toReturn = new HashMap<String, String>();
	       
	      
	       for(int i=0; i<variables.size();i++){
	    	   List<VariableDeclarator> list = variables.get(i).getVars();
	    	   for(int j=0; j<list.size(); j++){
	    		   for(int k=0; k<methods.size(); k++){
	    			   String name = list.get(j).getId()+"";
	    			   String scope = methods.get(k).getScope()+"";
	    		   if(name.equals(scope)) {
	    			   toReturn.put(variables.get(i).getType()+"_"+methods.get(k).getName(), null);
	    		   }
	    	    }
	    	   }
	       }
	       
	       
	       ArrayList<String> method_s = new ArrayList<String>();
	       method_s.addAll(toReturn.keySet());
	       System.out.println(method_s);
    }


    private static class VariableVisitor1 extends VoidVisitorAdapter {
     	ArrayList<FieldDeclaration> variables1 = new ArrayList<FieldDeclaration>();
        public void visit(FieldDeclaration n, Object arg) {
        	variables1.add(n);
        }
        
        public ArrayList<FieldDeclaration> getVarList(){
        	return variables1; 
        }
    }
    
    private static class VariableVisitor extends VoidVisitorAdapter {
     	ArrayList<VariableDeclarationExpr> variables = new ArrayList<VariableDeclarationExpr>();
        public void visit(VariableDeclarationExpr n, Object arg) {
        	variables.add(n);
        }
        
        public ArrayList<VariableDeclarationExpr> getVarList(){
        	return variables; 
        }
    }
    
    
    private static class MethodVisitor extends VoidVisitorAdapter {
        
     	ArrayList<MethodCallExpr> methods = new ArrayList<MethodCallExpr>();
        public void visit(MethodCallExpr n, Object arg) {
        	methods.add(n);
        }
        
        public ArrayList<MethodCallExpr> getMethodList(){
        	return methods; 
        }
   
    }
	
	
}
