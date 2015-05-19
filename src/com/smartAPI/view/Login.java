package com.smartAPI.view;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Arrays;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.SwingConstants;

import com.smartAPI.model.*;

/**
 * @author Amedeo Leo
 */

public class Login extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JPasswordField passwordField;
	private JTextField textField;
	private SmartAPIModel model;

	public Login(SmartAPIModel model) {
		setSize(300, 305);
		setVisible(true);
		setTitle("Login");
        setBackground(new java.awt.Color(255, 255, 255));
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.model = model;
        initComponents();
	}
     
	private void initComponents() {
        JPanel panel = new JPanel();
        
        JLabel lblLoginUtente = new JLabel("Login utente");
        lblLoginUtente.setFont(new java.awt.Font("Tahoma", 1, 14)); 

        GroupLayout gl_panel = new GroupLayout(panel);
        gl_panel.setHorizontalGroup(
        	gl_panel.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblLoginUtente, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
        			.addContainerGap(139, Short.MAX_VALUE))
        );
        gl_panel.setVerticalGroup(
        	gl_panel.createParallelGroup(Alignment.LEADING)
        		.addComponent(lblLoginUtente, Alignment.TRAILING, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        );
        panel.setLayout(gl_panel);
        
        JPanel panel_2 = new JPanel();
        
        JLabel label_1 = new JLabel("Password");
        
        passwordField = new JPasswordField();
        GroupLayout gl_panel_2 = new GroupLayout(panel_2);
        gl_panel_2.setHorizontalGroup(
        	gl_panel_2.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_2.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(label_1, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(passwordField, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
        );
        gl_panel_2.setVerticalGroup(
        	gl_panel_2.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_panel_2.createParallelGroup(Alignment.BASELINE)
        			.addComponent(label_1, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        			.addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        panel_2.setLayout(gl_panel_2);
        
        JPanel panel_3 = new JPanel();
        
        JLabel label_2 = new JLabel("Registrati");
        label_2.setVerticalTextPosition(SwingConstants.TOP);
        label_2.addMouseListener(new MouseListener() {
			
			public void mouseReleased(MouseEvent arg0) {
			}
			
			public void mousePressed(MouseEvent arg0) {
				
			}
			
			public void mouseExited(MouseEvent arg0) {
				
			}
			
			public void mouseEntered(MouseEvent e) {
				e.getComponent().setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
			}
			
			public void mouseClicked(MouseEvent arg0) {
				Registrazione frameRegistrazione = new Registrazione(model);
			}
		});
        
        label_2.setForeground(new java.awt.Color(51, 102, 255));
        
        final JLabel lblNewLabel = new JLabel("Label per errori");
        lblNewLabel.setForeground(Color.RED);
        GroupLayout gl_panel_3 = new GroupLayout(panel_3);
        gl_panel_3.setHorizontalGroup(
        	gl_panel_3.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_panel_3.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
        			.addGap(27)
        			.addComponent(label_2, GroupLayout.PREFERRED_SIZE, 55, GroupLayout.PREFERRED_SIZE))
        );
        gl_panel_3.setVerticalGroup(
        	gl_panel_3.createParallelGroup(Alignment.TRAILING)
        		.addGroup(gl_panel_3.createParallelGroup(Alignment.BASELINE)
        			.addComponent(label_2, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        			.addComponent(lblNewLabel, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE))
        );
        panel_3.setLayout(gl_panel_3);
        
        JButton btnLogin = new JButton("Login");
        btnLogin.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		try {
        			String username = textField.getText();
        			char[] confermaPassword = passwordField.getPassword();
        			if(username.trim().equals("") || Arrays.toString(confermaPassword).trim().equals((""))) {
            			throw new UserException("Username o password errati");
        			}
        			StringBuilder realPassword = new StringBuilder();
        			for(char s : confermaPassword) {
        			    realPassword.append(s);
        			}
        			if(model.exists(username, realPassword.toString())) {
        				JOptionPane.showMessageDialog(null, "Login effettuato con successo");
        	        	setVisible(false);
        	        	if(model.isAdministrator(username)) {
        	        		new PannelloAmministratore(model);
        	        	}
        	        	//pannello
        			}
        		}
        		catch(UserException u) {
        			lblNewLabel.setText(u.getMessage());
        		}
        	}
        });
        
        JPanel panel_1 = new JPanel();
        
        JLabel lblUsername = new JLabel("Username");
        
        textField = new JTextField();
        textField.setColumns(10);
        GroupLayout gl_panel_1 = new GroupLayout(panel_1);
        gl_panel_1.setHorizontalGroup(
        	gl_panel_1.createParallelGroup(Alignment.LEADING)
        		.addGroup(gl_panel_1.createSequentialGroup()
        			.addContainerGap()
        			.addComponent(lblUsername, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE)
        			.addPreferredGap(ComponentPlacement.UNRELATED)
        			.addComponent(textField, GroupLayout.DEFAULT_SIZE, 144, Short.MAX_VALUE))
        );
        gl_panel_1.setVerticalGroup(
        	gl_panel_1.createParallelGroup(Alignment.TRAILING)
        		.addGap(0, 39, Short.MAX_VALUE)
        		.addGroup(gl_panel_1.createParallelGroup(Alignment.BASELINE)
        			.addComponent(lblUsername, GroupLayout.DEFAULT_SIZE, 39, Short.MAX_VALUE)
        			.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
        );
        panel_1.setLayout(gl_panel_1);
        GroupLayout groupLayout = new GroupLayout(getContentPane());
        groupLayout.setHorizontalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
        				.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        				.addGroup(groupLayout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addContainerGap()
        					.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
        						.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 87, GroupLayout.PREFERRED_SIZE)
        						.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)))
        				.addGroup(groupLayout.createSequentialGroup()
        					.addContainerGap()
        					.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 261, GroupLayout.PREFERRED_SIZE)))
        			.addContainerGap(10, Short.MAX_VALUE))
        );
        groupLayout.setVerticalGroup(
        	groupLayout.createParallelGroup(Alignment.LEADING)
        		.addGroup(groupLayout.createSequentialGroup()
        			.addComponent(panel, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
        			.addGap(20)
        			.addComponent(panel_1, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(panel_2, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(panel_3, GroupLayout.PREFERRED_SIZE, 39, GroupLayout.PREFERRED_SIZE)
        			.addGap(18)
        			.addComponent(btnLogin, GroupLayout.PREFERRED_SIZE, 32, GroupLayout.PREFERRED_SIZE)
        			.addGap(59))
        );
        getContentPane().setLayout(groupLayout);
		
	}
}

