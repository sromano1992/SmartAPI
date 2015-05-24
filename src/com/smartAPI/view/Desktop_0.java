package com.smartAPI.view;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;
import java.util.logging.Logger;

import javax.swing.JFrame;
import javax.swing.JLabel;




import javax.swing.SwingUtilities;

import com.smartAPI.control.ILogInPanelListner;

/**
 * Login page.
 *
 */
public class Desktop_0 extends JPanel implements ILogInPanelListner{
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
		
		JLabel label = new JLabel("");
		label.setOpaque(true);
		label.setBackground(new Color(2, 94, 137));
		add(label);
		
		loginGrafica = new LoginGrafica();
		add(loginGrafica);
		
		JLabel lblNewLabel = new JLabel("");
		add(lblNewLabel);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setBackground(new Color(2, 94, 137));
		loginGrafica.addLoginPanelListner(this);
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
			d1 = new Desktop_Insert();
		mainContainer.remove(this);
		mainContainer.add(d1);
		SwingUtilities.updateComponentTreeUI(mainContainer);
		SwingUtilities.updateComponentTreeUI(this);
	}
}
