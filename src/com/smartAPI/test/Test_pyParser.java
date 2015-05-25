package com.smartAPI.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URISyntaxException;

import org.python.core.PyObject;
import org.python.core.PyString;
import org.python.util.PythonInterpreter;

import com.hp.hpl.jena.util.FileManager;

/**
 * 
 * @author Simone Romamo - http://www.sromano.altervista.org
 *
 */
public class Test_pyParser {

	public static void main(String[] args) {
		new Test_pyParser().parsePy();
	}
	
	public void parsePy(){
		String pyCode = "for actor in root.findall('real_person:actor', ns):\n"
				+"	name = actor.find('real_person:name', ns)\n"
				+"	name.text\n"
				+"	for char in actor.findall('role:character', ns):\n"
				+"		print ' |-->', char.text\n";
		
		String pyPath = this.getClass().getResource("/pyParser.py").getFile();
		File file;
			try {
				file = new File(new java.net.URI(pyPath).getPath());
				String[] szCmd = {"python", file.getAbsolutePath(), pyCode};
				String command = "python " + file.getAbsolutePath() + " " + pyCode;
				System.out.println(command);
				Process p = Runtime.getRuntime().exec(szCmd);
				p.waitFor();
				BufferedReader in = new BufferedReader(new InputStreamReader(p.getInputStream()));
				String line;
				while ((line = in.readLine()) != null) {
					System.out.println(line);
		       }
		       in.close();
			} catch (URISyntaxException e) {
				e.printStackTrace();
			} catch (NumberFormatException e){
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

	}
	
	public void runWith_jython(){
		PythonInterpreter interpreter = new PythonInterpreter();
		interpreter.exec("import sys\nsys.path.append('pathToModiles if they're not there by default')\nimport yourModule");
		// execute a function that takes a string and returns a string
		PyObject someFunc = interpreter.get("funcName");
		PyObject result = someFunc.__call__(new PyString("Test!"));
		String realResult = (String) result.__tojava__(String.class);
	}

}
