package com.smartAPI.control;

import japa.parser.ParseException;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.logging.Logger;

import com.smartAPI.model.Common;


/**
 * 
 * @author Simone Romamo - http://www.sromano.altervista.org This class will
 *         parse python code to extract method invocation.
 */
public class PythonMethodParser implements IMethodParser{
	private static Logger log = Logger.getLogger("global");

	public ArrayList<String> getMethod(String pyCode) throws ParseException{
		ArrayList<String> method_s = new ArrayList<String>();
		try {
			URL location = this.getClass().getProtectionDomain().getCodeSource().getLocation();
			String codePath = location.getFile() + Common.PYTHON_CP_TMP_FILE;
			String pyPath = this.getClass().getResource(Common.PY_PARSER_SCRIPT).getFile();
			
			File f_codePath = new File(new java.net.URI(codePath).getPath());
			File f_pyPath = new File(new java.net.URI(pyPath).getPath());
			
			FileOutputStream fos = new FileOutputStream(new File(codePath));
			fos.write(pyCode.getBytes());
			fos.close();
			String[] szCmd = { "python", f_pyPath.getAbsolutePath(), f_codePath.getAbsolutePath() };
			String command = "python " + f_pyPath.getAbsolutePath() + " " + f_codePath.getAbsolutePath();
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
		}  catch (NumberFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (URISyntaxException e) {
			e.printStackTrace();
		}
		return null;
	}

}
