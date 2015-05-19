package com.smartAPI.view;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

import org.apache.log4j.Logger;

/**
 * @author Simone Romamo - http://www.sromano.altervista.org
 *
 */
public class JLabelWithPosition extends JLabel {
	private static final long serialVersionUID = 1L;
	private int pos;
	private static Logger log = Logger.getLogger("global");
	
	public JLabelWithPosition(ImageIcon picGrey, int pos) {
		// TODO Auto-generated constructor stub
		super(picGrey);
		this.pos = pos;
	}

	public int getPos() {
		return pos;
	}

	public void setPos(int pos) {
		this.pos = pos;
	}
	
	
}
