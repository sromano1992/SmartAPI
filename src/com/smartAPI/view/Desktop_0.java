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

/**
 * Login page.
 *
 */
public class Desktop_0 extends JPanel implements ILogInPanelListner, IUserPanelListener{
	private LoginGrafica loginGrafica;
	private Desktop_Insert d1;
	private CreateNewAccountJPanel newAccountPanel;
	private Logger log = Logger.getLogger("global");
	private JFrame mainContainer;
	/**
	 * Create the panel.
	 */
	public Desktop_0(JFrame f) {
		mainContainer = f;
		setLayout(new GridLayout(1, 3, 0, 0));
		
		loginGrafica = new LoginGrafica();
		add(loginGrafica);
		loginGrafica.addLoginPanelListner(this);
		
		Panel_CenterLogin panel_CenterLogin = new Panel_CenterLogin();
		add(panel_CenterLogin);
		
		CreateNewAccountJPanel createNewAccountJPanel = new CreateNewAccountJPanel();
		add(createNewAccountJPanel);
	}

	@Override
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

	@Override
	public void loginClicked() {
		log.info("Log in event intercepted");
		if (d1 == null)
			d1 = new Desktop_Insert(this);
		mainContainer.remove(this);
		mainContainer.getContentPane().add(d1);
		SwingUtilities.updateComponentTreeUI(mainContainer);
		SwingUtilities.updateComponentTreeUI(this);
	}

	@Override
	public void logOutClicked() {
		log.info("Log out event intercepted");
		mainContainer.remove(d1);
		mainContainer.getContentPane().add(this);
		Common.UTENTE = null;
		SwingUtilities.updateComponentTreeUI(mainContainer);
		SwingUtilities.updateComponentTreeUI(this);
	}
	
}
