package com.smartAPI.test;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.WindowConstants;
import javax.swing.JEditorPane;
import javax.swing.text.EditorKit;

import jsyntaxpane.*;

import javax.swing.JFormattedTextField;

import org.fife.ui.rsyntaxtextarea.RSyntaxTextArea;
import org.fife.ui.rsyntaxtextarea.SyntaxConstants;
import org.fife.ui.rtextarea.RTextScrollPane;
/**
 * 
 * @author Simone Romamo - http://www.sromano.altervista.org
 *
 */
public class Test_JavaEditor extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test_JavaEditor frame = new Test_JavaEditor();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Test_JavaEditor() {
		 /*final Container c = this.getContentPane();
		 c.setLayout(new BorderLayout());
		  
		  
		 final JEditorPane codeEditor = new JEditorPane();
		 JScrollPane scrPane = new JScrollPane(codeEditor);
		 c.add(scrPane, BorderLayout.CENTER);
		 c.doLayout();
		 try{
			 DefaultSyntaxKit.initKit();
			 codeEditor.setContentType("text/java");
		 }catch(Exception e){
			 
		 }
		 //codeEditor.setText("public static void main(String[] args) {\n}");
		 this.setSize(800, 600);
		 this.setVisible(true);
		 this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); */
		
		
		/*
		Parser parser = new PrettifyParser();

        // initialize the highlighter and use Default theme
        SyntaxHighlighter highlighter = new SyntaxHighlighter(parser, new ThemeDefault());
        // set the line number count from 10 instead of 1
        highlighter.setFirstLine(0);
        // set to highlight line 13, 27, 28, 38, 42, 43 and 53
        highlighter.setHighlightedLineList(Arrays.asList(13, 27, 28, 38, 42, 43, 53));
        highlighter.setContent("highlighter.setFirstLine(10);");

        JFrame frame = new JFrame();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(highlighter);
        frame.setLocationByPlatform(true);
        frame.pack();
        frame.setVisible(true);*/
		


		
			
		
		JPanel cp = new JPanel(new BorderLayout());

	      RSyntaxTextArea textArea = new RSyntaxTextArea(20, 60);
	      textArea.setSyntaxEditingStyle(SyntaxConstants.SYNTAX_STYLE_JAVA);
	      textArea.setCodeFoldingEnabled(true);
	      textArea.canRedo();
	      textArea.canUndo();
	      RTextScrollPane sp = new RTextScrollPane(textArea);
	      cp.add(sp);
	      textArea.setText("JFrame f = new JFrame();");
	      System.out.println(textArea.getText());
	
	      setContentPane(cp);
	      setTitle("Text Editor Demo");
	      setDefaultCloseOperation(EXIT_ON_CLOSE);
	      setLocationRelativeTo(null);
		
		JFrame f = new JFrame();
		f.add(cp);
		f.setSize(500,500);
		f.setVisible(true);
		f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
	}

}
