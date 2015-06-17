package com.smartAPI.view;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JLabel;




import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import com.smartAPI.control.ILogInPanelListner;
import com.smartAPI.control.IUserPanelListener;
import com.smartAPI.model.Common;

import java.awt.FlowLayout;
import java.awt.BorderLayout;

/**
 * Login page.
 *
 */
public class Desktop_0 extends JPanel implements ILogInPanelListner, IUserPanelListener{
	private LoginGrafica loginGrafica;
	public  Desktop_1 d1;
	public  Desktop_0 d0;
	private CreateNewAccountJPanel newAccountPanel;
	private Logger log = Logger.getLogger("global");
	private JFrame mainContainer;
	/**
	 * Create the panel.
	 */
	public Desktop_0(JFrame f) {
		mainContainer = f;
		setLayout(new GridLayout(1, 3, 0, 0));
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(2,94,137));
		add(panel);
		panel.setLayout(new GridLayout(3, 1, 0, 0));
		
		JLabel label = new JLabel("");
		panel.add(label);
		
		loginGrafica = new LoginGrafica();
		panel.add(loginGrafica);
		loginGrafica.addLoginPanelListner(this);
		
		Panel_CenterLogin panel_CenterLogin = new Panel_CenterLogin();
		add(panel_CenterLogin);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		
		CreateNewAccountJPanel createNewAccountJPanel = new CreateNewAccountJPanel();
		panel_1.add(createNewAccountJPanel);
	}

	public void newAccountClicked() {
		log.info("new user clicked...");
		for (Component c:getComponents()){
			remove(c);
		}
		JLabel label = new JLabel("");
		label.setOpaque(true);
		label.setBackground(new Color(2, 94, 137));
		add(label);
		if (newAccountPanel == null)
			newAccountPanel = new CreateNewAccountJPanel();
		add(newAccountPanel);
		JLabel label1 = new JLabel("");
		label1.setOpaque(true);
		label1.setBackground(new Color(2, 94, 137));
		add(label1);
		SwingUtilities.updateComponentTreeUI(this);
		Component c = getParent();
		while (c!=null){
			SwingUtilities.updateComponentTreeUI(this);
			c = c.getParent();
		}
	}

	public void loginClicked() {
		log.info("Log in event intercepted");
		//if (d1 == null)
			d1 = new Desktop_1(this);
		mainContainer.remove(this);
		mainContainer.getContentPane().add(d1);
		SwingUtilities.updateComponentTreeUI(mainContainer);
		SwingUtilities.updateComponentTreeUI(this);
	}

	public void logOutClicked() {
		log.info("Log out event intercepted");
		mainContainer.remove(d1);
		mainContainer.getContentPane().add(this);
		Common.UTENTE = null;
		SwingUtilities.updateComponentTreeUI(mainContainer);
		SwingUtilities.updateComponentTreeUI(this);
	}
	
}
