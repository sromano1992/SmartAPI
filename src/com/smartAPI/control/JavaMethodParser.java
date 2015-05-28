package com.smartAPI.control;

import japa.parser.JavaParser;
import japa.parser.ParseException;
import japa.parser.ast.CompilationUnit;
import japa.parser.ast.body.VariableDeclarator;
import japa.parser.ast.expr.MethodCallExpr;
import japa.parser.ast.expr.VariableDeclarationExpr;
import japa.parser.ast.visitor.VoidVisitorAdapter;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Logger;


/**
 * This class will contains method to parser 
 * code inserted by user to find method declaration.
 * @author Simone Romamo - http://www.sromano.altervista.org
 *
 */
public class JavaMethodParser{

	public static Logger logger = Logger.getLogger("global");
	public static String CLASS_DEF = "public class Prova{ ";
	
	
    public ArrayList<String> parse(String code) throws ParseException {
    	InputStream is = new ByteArrayInputStream(code.getBytes());
        CompilationUnit cu=null;
        try {
           cu = JavaParser.parse(is);
        }catch(ParseException e){
        	code = CLASS_DEF + code + "}";
        	InputStream is1 = new ByteArrayInputStream(code.getBytes());
        	cu = JavaParser.parse(is1);
        	
        }
        
        
        VariableVisitor varVisitor = new VariableVisitor();
        varVisitor.visit(cu, null);
        ArrayList<VariableDeclarationExpr> variables = varVisitor.getVarList();
       
        MethodVisitor methVisitor = new MethodVisitor();
        methVisitor.visit(cu, null);
        ArrayList<MethodCallExpr> methods = methVisitor.getMethodList();

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
	    
       ArrayList<String> toRet = new ArrayList<String>();
       toRet.addAll(toReturn.keySet());
       return toRet;
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
