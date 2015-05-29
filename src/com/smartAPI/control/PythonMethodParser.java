package com.smartAPI.control;

import japa.parser.ParseException;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.logging.Logger;


/**
 * 
 * @author Simone Romamo - http://www.sromano.altervista.org This class will
 *         parse python code to extract method invocation.
 */
public class PythonMethodParser implements IMethodParser{
	private static Logger log = Logger.getLogger("global");

	public ArrayList<String> getMethod(String pyCode) throws ParseException{
		ArrayList<String> method_s = new ArrayList<String>();
		String pyPath = this.getClass().getResource("/pyParser.py").getFile();
		File file;
		try {
			file = new File(new java.net.URI(pyPath).getPath());
			String[] szCmd = { "python", file.getAbsolutePath(), pyCode };
			String command = "python " + file.getAbsolutePath() + " " + pyCode;
			log.info("Running command: " + command);
			Process p = Runtime.getRuntime().exec(szCmd);
			p.waitFor();
			BufferedReader in = new BufferedReader(new InputStreamReader(
					p.getInputStream()));
			String line;
			while ((line = in.readLine()) != null) {
				method_s.add(line);
			}
			in.close();
			log.info("Found py method: " + method_s);
			return method_s;
		} catch (URISyntaxException e) {
			e.printStackTrace();
		} catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return null;
	}

}
