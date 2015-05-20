package com.smartAPI.view;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.Box;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JPasswordField;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Arrays;

import com.smartAPI.model.*;

/**
 * @author Amedeo Leo
 */

public class Registrazione extends JFrame{
	
	private static final long serialVersionUID = 1L;
	
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_5;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;
	private SmartAPIModel model;

	public Registrazione(SmartAPIModel model)  {
		setSize(395, 505);
		setVisible(true);
		setTitle("Registrati");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        this.model = model;
        initComponents();
	}  
     
	private void initComponents() {
        Box horizontalBox = Box.createHorizontalBox();
        
        JPanel panel_1 = new JPanel();
        
        JLabel lblCognome = new JLabel("Cognome");
        
        textField_1 = new JTextField();
        textField_1.setColumns(10);
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
        	gl_panel_1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblCognome, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
        			.addGap(67)
        			.addComponent(textField_1, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
        );
        gl_panel_1.setVerticalGroup(
        	gl_panel_1.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
        			.addComponent(lblCognome, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        			.addComponent(textField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        panel_1.setLayout(gl_panel_1);
        
        JPanel panel_2 = new JPanel();
        
        JLabel lblUsername = new JLabel("Username\r\n");
        
        textField_2 = new JTextField();
        textField_2.setColumns(10);
        GroupLayout gl_panel_2 = new GroupLayout(panel_2);
        gl_panel_2.setHorizontalGroup(
        	gl_panel_2.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_2.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
        			.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
        );
        gl_panel_2.setVerticalGroup(
        	gl_panel_2.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
        			.addComponent(lblUsername, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        			.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        panel_2.setLayout(gl_panel_2);
        
        JPanel panel_3 = new JPanel();
        
        JLabel lblPassword = new JLabel("Password\r\n");
        
        passwordField = new JPasswordField();
        GroupLayout gl_panel_3 = new GroupLayout(panel_3);
        gl_panel_3.setHorizontalGroup(
        	gl_panel_3.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_3.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblPassword, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.RELATED, 67, Short.MAX_VALUE)
        			.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
        );
        gl_panel_3.setVerticalGroup(
        	gl_panel_3.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
        			.addComponent(lblPassword, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        			.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        panel_3.setLayout(gl_panel_3);
        
        JPanel panel_4 = new JPanel();
        
        JLabel lblConfermaPassword = new JLabel("Conferma Password\r\n");
        
        passwordField_1 = new JPasswordField();
        GroupLayout gl_panel_4 = new GroupLayout(panel_4);
        gl_panel_4.setHorizontalGroup(
        	gl_panel_4.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_panel_4.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblConfermaPassword, GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
        			.addGap(20)
        			.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, 171, GroupLayout.PREFERRED_SIZE))
        );
        gl_panel_4.setVerticalGroup(
        	gl_panel_4.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_panel_4.createParallelGroup(Alignment.BASELINE)
        			.addComponent(lblConfermaPassword, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        			.addComponent(passwordField_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        panel_4.setLayout(gl_panel_4);
        
        JPanel panel_5 = new JPanel();
        
        JLabel lblEmail = new JLabel("Email");
        
        textField_5 = new JTextField();
        textField_5.setColumns(10);
        GroupLayout gl_panel_5 = new GroupLayout(panel_5);
        gl_panel_5.setHorizontalGroup(
        	gl_panel_5.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_5.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblEmail, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
        			.addGap(67)
        			.addComponent(textField_5, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
        );
        gl_panel_5.setVerticalGroup(
        	gl_panel_5.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_panel_5.createParallelGroup(Alignment.BASELINE)
        			.addComponent(lblEmail, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        			.addComponent(textField_5, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        panel_5.setLayout(gl_panel_5);
        
        JPanel panel_6 = new JPanel();
        
        final JLabel lblLabelPerErrori = new JLabel("Label per errori\r\n");
        lblLabelPerErrori.setForeground(Color.RED);
        
        JButton btnNewButton = new JButton("Conferma");
        btnNewButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		try {
        			String nome = textField.getText();
        			String cognome = textField_1.getText();
        			String username = textField_2.getText();
        			char[] password = passwordField.getPassword();
        			char[] confermaPassword = passwordField.getPassword();
        			String email = textField_5.getText();
        			//System.out.println(nome + " " + cognome + " " + username + " " + Arrays.toString(password)  + " " + Arrays.toString(confermaPassword) + " " + email);
        			if (nome.trim().equals("") || cognome.trim().equals("") || username.trim().equals("") || 
        					Arrays.toString(password).trim().equals("") || 
        					Arrays.toString(confermaPassword).trim().equals("") ||
        					email.trim().equals("")) {
        				throw new UserException("Campi mancanti");
        			}
        			if(Arrays.toString(confermaPassword).equals(Arrays.toString(password))) {
        				StringBuilder realPassword = new StringBuilder();
        				for(char s : password) {
        				    realPassword.append(s);
        				}
        				if(model.addUser(nome, cognome, email, username, realPassword.toString(), false)) {
        					JOptionPane.showMessageDialog(rootPane, "Registrazione effettuata con successo");
        					setVisible(false);
        				}
        				else
        					throw new UserException("Username gia' in uso");
            			
        			}	
        			else {
            			throw new UserException("Le password non coincidono!");
            		}	
        		}
        		catch (UserException u) {
        			lblLabelPerErrori.setText(u.getMessage());
        		}
        	}
        });
        btnNewButton.addMouseListener(new MouseAdapter() {
        	public void mouseClicked(MouseEvent e) {
        		
        	}
        });
        GroupLayout gl_panel_6 = new GroupLayout(panel_6);
        gl_panel_6.setHorizontalGroup(
        	gl_panel_6.createParallelGroup(Alignment.LEADING)
        		.addGroup(Alignment.TRAILING, gl_panel_6.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblLabelPerErrori, GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
        			.addGap(18)
        			.addComponent(btnNewButton, GroupLayout.PREFERRED_SIZE, 99, GroupLayout.PREFERRED_SIZE))
        );
        gl_panel_6.setVerticalGroup(
        	gl_panel_6.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_panel_6.createParallelGroup(Alignment.BASELINE)
        			.addComponent(lblLabelPerErrori, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        			.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE))
        );
        panel_6.setLayout(gl_panel_6);
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(32)
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)
        				.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)
        				.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)
        				.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)
        				.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)
        				.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE)
        				.addComponent(horizontalBox, GroupLayout.PREFERRED_SIZE, 327, GroupLayout.PREFERRED_SIZE))
        			.addContainerGap(35, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGap(32)
        			.addComponent(horizontalBox, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(panel_4, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(panel_5, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
        			.addGap(31)
        			.addComponent(panel_6, GroupLayout.PREFERRED_SIZE, 41, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(31, Short.MAX_VALUE))
        );
        
        JPanel panel = new JPanel();
        horizontalBox.add(panel);
        
        JLabel lblNewLabel = new JLabel("Nome");
        
        textField = new JTextField();
        textField.setColumns(10);
        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
        	gl_panel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 79, GroupLayout.PREFERRED_SIZE)
        			.addGap(67)
        			.addComponent(textField, GroupLayout.DEFAULT_SIZE, 171, Short.MAX_VALUE))
        );
        gl_panel.setVerticalGroup(
        	gl_panel.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
        			.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 41, Short.MAX_VALUE)
        			.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        panel.setLayout(gl_panel);
        getContentPane().setLayout(groupLayout);
	}
}
