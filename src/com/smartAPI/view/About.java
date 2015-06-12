package com.smartAPI.view;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;

import com.smartAPI.model.Common;
import com.sun.jndi.toolkit.url.Uri;

import java.awt.Font;

import javax.swing.SwingConstants;

import java.awt.Desktop;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;
import java.awt.BorderLayout;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.net.URI;

public class About extends JPanel {

	String path = "";
	String pathIcon = "";
	MyImageIcon imgicon;

	public About() {
		setBackground(new Color(228, 230, 235));
		JLabel lblIconSimo = new JLabel();
		lblIconSimo.setHorizontalAlignment(SwingConstants.CENTER);
		pathIcon = "res/simo.png";
		imgicon = new MyImageIcon(pathIcon, 180, 150);
		setLayout(new GridLayout(4, 5, 0, 0));
		
		JLabel label = new JLabel("");
		add(label);
		lblIconSimo.setIcon(imgicon.getImageResponsive());
		add(lblIconSimo);
		pathIcon = "res/simoQr.jpg";
		imgicon = new MyImageIcon(pathIcon, 50, 50);
		JLabel  lblIconAme = new JLabel("");
		lblIconAme.setHorizontalAlignment(SwingConstants.CENTER);
		pathIcon = "res/amedeo.png";
		imgicon = new MyImageIcon(pathIcon, 180, 150);
		lblIconAme.setIcon(imgicon.getImageResponsive());
		add(lblIconAme);
		pathIcon = "res/amedeoQr.jpg";
		imgicon = new MyImageIcon(pathIcon, 50, 50);
		
		JLabel  lblIconCiro = new JLabel("");
		lblIconCiro.setHorizontalAlignment(SwingConstants.CENTER);
		pathIcon = "res/ciro.png";
		imgicon = new MyImageIcon(pathIcon, 180, 150);
		lblIconCiro.setIcon(imgicon.getImageResponsive());
		add(lblIconCiro);
		
		JLabel label_1 = new JLabel("");
		add(label_1);
		
		JLabel label_2 = new JLabel("");
		add(label_2);
		
		JPanel panel = new JPanel();
		add(panel);
		panel.setLayout(new BorderLayout(0, 0));
		JLabel lblTxtSimo = new JLabel("Simone Romano");
		panel.add(lblTxtSimo, BorderLayout.NORTH);
		lblTxtSimo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTxtSimo.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblTxtSimo.setForeground(Color.DARK_GRAY);
		lblTxtSimo.setBackground(new Color(228, 230, 235));
		lblTxtSimo.setOpaque(true);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(228, 230, 235));
		panel_4.setForeground(Color.DARK_GRAY);
		panel.add(panel_4, BorderLayout.CENTER);
		GridBagLayout gbl_panel_4 = new GridBagLayout();
		gbl_panel_4.columnWidths = new int[]{180, 0};
		gbl_panel_4.rowHeights = new int[]{150, 0};
		gbl_panel_4.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_4.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_4.setLayout(gbl_panel_4);
		JLabel labelsimoqr = new JLabel("");
		GridBagConstraints gbc_labelsimoqr = new GridBagConstraints();
		gbc_labelsimoqr.gridx = 0;
		gbc_labelsimoqr.gridy = 0;
		pathIcon = "res/simoQr.jpg";
		imgicon = new MyImageIcon(pathIcon, 50, 50);
		panel_4.add(labelsimoqr, gbc_labelsimoqr);
		labelsimoqr.setIcon(imgicon.getImageResponsive());
		
		JButton buttonSimLink = new JButton("");
		buttonSimLink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
			    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
			        try {
			            desktop.browse(new URI("https://it.linkedin.com/in/simoneromano92"));
			        } catch (Exception e) {
			            e.printStackTrace();
			        }
			    }
			}
		});
		buttonSimLink.setBackground(new Color(228, 230, 235));
		buttonSimLink.setBorderPainted(false);
		buttonSimLink.setFocusPainted(false);
		buttonSimLink.setContentAreaFilled(false);
		buttonSimLink.setIcon(new ImageIcon(About.class.getResource("/com/smartAPI/view/res/Linkedin.png")));
		panel.add(buttonSimLink, BorderLayout.EAST);
		
		JPanel panel_1 = new JPanel();
		add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));
		JLabel lblTxtAme = new JLabel("Amedeo Leo");
		panel_1.add(lblTxtAme, BorderLayout.NORTH);
		lblTxtAme.setOpaque(true);
		lblTxtAme.setHorizontalAlignment(SwingConstants.CENTER);
		lblTxtAme.setForeground(Color.DARK_GRAY);
		lblTxtAme.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblTxtAme.setBackground(new Color(228, 230, 235));
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(new Color(228, 230, 235));
		panel_1.add(panel_5, BorderLayout.CENTER);
		GridBagLayout gbl_panel_5 = new GridBagLayout();
		gbl_panel_5.columnWidths = new int[]{180, 0};
		gbl_panel_5.rowHeights = new int[]{150, 0};
		gbl_panel_5.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_5.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_5.setLayout(gbl_panel_5);		
		JLabel labelameqr = new JLabel("");
		GridBagConstraints gbc_labelameqr = new GridBagConstraints();
		gbc_labelameqr.gridx = 0;
		gbc_labelameqr.gridy = 0;
		pathIcon = "res/amedeoQr.jpg";
		imgicon = new MyImageIcon(pathIcon, 50, 50);
		labelameqr.setIcon(imgicon.getImageResponsive());
		panel_5.add(labelameqr, gbc_labelameqr);		
		
		JButton buttonAmeLink = new JButton("");
		buttonAmeLink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
				    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
				        try {
				            desktop.browse(new URI("https://it.linkedin.com/in/amedeoleo"));
				        } catch (Exception e) {
				            e.printStackTrace();
				        }
				    }
				}
		});
		buttonAmeLink.setBackground(new Color(228, 230, 235));
		buttonAmeLink.setBorderPainted(false);
		buttonAmeLink.setFocusPainted(false);
		buttonAmeLink.setContentAreaFilled(false);
		buttonAmeLink.setIcon(new ImageIcon(About.class.getResource("/com/smartAPI/view/res/Linkedin.png")));
		panel_1.add(buttonAmeLink, BorderLayout.EAST);
		
		
		
		JPanel panel_2 = new JPanel();
		add(panel_2);
		panel_2.setLayout(new BorderLayout(0, 0));
		
		JLabel lblTxtCiro = new JLabel("Ciro Amati");
		panel_2.add(lblTxtCiro, BorderLayout.NORTH);
		lblTxtCiro.setOpaque(true);
		lblTxtCiro.setHorizontalAlignment(SwingConstants.CENTER);
		lblTxtCiro.setForeground(Color.DARK_GRAY);
		lblTxtCiro.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblTxtCiro.setBackground(new Color(228, 230, 235));
		
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(228, 230, 235));
		panel_2.add(panel_6, BorderLayout.CENTER);
		GridBagLayout gbl_panel_6 = new GridBagLayout();
		gbl_panel_6.columnWidths = new int[]{180, 0};
		gbl_panel_6.rowHeights = new int[]{150, 0};
		gbl_panel_6.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_6.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_6.setLayout(gbl_panel_6);
		JLabel lblciroqr = new JLabel();
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.gridx = 0;
		gbc_label_3.gridy = 0;
		pathIcon = "res/ciroQr.jpg";
		imgicon = new MyImageIcon(pathIcon, 50, 50);
		lblciroqr.setIcon(imgicon);
		panel_6.add(lblciroqr, gbc_label_3);		
		
		JLabel label_3 = new JLabel("");
		//add(label_3);
		lblciroqr.setIcon(imgicon.getImageResponsive());
		
		JButton buttonCiroAmati = new JButton("");
		buttonCiroAmati.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
			    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
			        try {
			            desktop.browse(new URI("https://it.linkedin.com/pub/ciro-amati/b2/b41/656"));
			        } catch (Exception e) {
			            e.printStackTrace();
			        }
			    }
			}
		});
		buttonCiroAmati.setBackground(new Color(228, 230, 235));
		buttonCiroAmati.setBorderPainted(false);
		buttonCiroAmati.setFocusPainted(false);
		buttonCiroAmati.setContentAreaFilled(false);
		buttonCiroAmati.setIcon(new ImageIcon(About.class.getResource("/com/smartAPI/view/res/Linkedin.png")));
		panel_2.add(buttonCiroAmati, BorderLayout.EAST);
		//add(lblciroqr);
		
		JLabel  lblIconIole = new JLabel("");
		lblIconIole.setHorizontalAlignment(SwingConstants.CENTER);
		pathIcon = "res/iole.jpg";
		imgicon = new MyImageIcon(pathIcon, 180, 150);
		
		JLabel label_6 = new JLabel("");
		add(label_6);
		
		JLabel label_7 = new JLabel("");
		add(label_7);
		lblIconIole.setIcon(imgicon.getImageResponsive());
		add(lblIconIole);
		pathIcon = "res/ioleQr.jpg";
		imgicon = new MyImageIcon(pathIcon, 50, 50);
		
	
		JLabel  lblIconSte = new JLabel("");
		lblIconSte.setHorizontalAlignment(SwingConstants.CENTER);
		pathIcon = "res/ste.jpg";
		imgicon = new MyImageIcon(pathIcon, 180, 150);
		lblIconSte.setIcon(imgicon.getImageResponsive());
		add(lblIconSte);
		
		JLabel label_5 = new JLabel("");
		add(label_5);
		
		JLabel label_8 = new JLabel("");
		add(label_8);
		
		JLabel label_9 = new JLabel("");
		add(label_9);
		

		JPanel panel_7 = new JPanel();
		add(panel_7);
		panel_7.setLayout(new BorderLayout(0, 0));
		
		
		JLabel lblTxtSte = new JLabel("Iolanda Rinaldi");
		panel_7.add(lblTxtSte, BorderLayout.NORTH);
		lblTxtSte.setOpaque(true);
		lblTxtSte.setHorizontalAlignment(SwingConstants.CENTER);
		lblTxtSte.setForeground(Color.DARK_GRAY);
		lblTxtSte.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblTxtSte.setBackground(new Color(228, 230, 235));
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(228, 230, 235));
		panel_7.add(panel_3, BorderLayout.CENTER);
		GridBagLayout gbl_panel_3 = new GridBagLayout();
		gbl_panel_3.columnWidths = new int[]{180, 0};
		gbl_panel_3.rowHeights = new int[]{150, 0};
		gbl_panel_3.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_panel_3.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		panel_3.setLayout(gbl_panel_3);
		JLabel labeIole = new JLabel("");
		GridBagConstraints gbc_labeste = new GridBagConstraints();
		gbc_labeste.gridx = 0;
		gbc_labeste.gridy = 0;
		pathIcon = "res/ioleQr.jpg";
		imgicon = new MyImageIcon(pathIcon, 50, 50);
		panel_3.add(labeIole, gbc_labeste);
		labeIole.setIcon(imgicon.getImageResponsive());
		
		JButton buttonIolLink = new JButton("");
		buttonIolLink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
			    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
			        try {
			            desktop.browse(new URI("https://it.linkedin.com/pub/iolanda-rinaldi/b9/992/242"));
			        } catch (Exception e) {
			            e.printStackTrace();
			        }
			    }
			}
		});
		buttonIolLink.setBackground(new Color(228, 230, 235));
		buttonIolLink.setBorderPainted(false);
		buttonIolLink.setFocusPainted(false);
		buttonIolLink.setContentAreaFilled(false);
		buttonIolLink.setIcon(new ImageIcon(About.class.getResource("/com/smartAPI/view/res/Linkedin.png")));
		panel_7.add(buttonIolLink, BorderLayout.EAST);
		
		JLabel lblTxtIole = new JLabel("Iolanda Rinaldi");
		lblTxtIole.setOpaque(true);
		lblTxtIole.setHorizontalAlignment(SwingConstants.CENTER);
		lblTxtIole.setForeground(Color.DARK_GRAY);
		lblTxtIole.setFont(new Font("Lucida Grande", Font.BOLD, 16));
		lblTxtIole.setBackground(new Color(228, 230, 235));
			
		
		JPanel panel_8 = new JPanel();
		add(panel_8);
		panel_8.setLayout(new BorderLayout(0, 0));
		
		JLabel label_10 = new JLabel("Stefania Cardamone");
		label_10.setOpaque(true);
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setForeground(Color.DARK_GRAY);
		label_10.setFont(new Font("Dialog", Font.BOLD, 16));
		label_10.setBackground(new Color(228, 230, 235));
		panel_8.add(label_10, BorderLayout.NORTH);
		
		JPanel panel_9 = new JPanel();
		panel_9.setBackground(new Color(228, 230, 235));
		panel_8.add(panel_9, BorderLayout.CENTER);
		GridBagLayout gbl_panel_9 = new GridBagLayout();
		gbl_panel_9.columnWidths = new int[]{0};
		gbl_panel_9.rowHeights = new int[]{0};
		gbl_panel_9.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panel_9.rowWeights = new double[]{Double.MIN_VALUE};
		panel_9.setLayout(gbl_panel_9);
		JLabel labeste = new JLabel("");
		GridBagConstraints gbc_labIole = new GridBagConstraints();
		gbc_labIole.gridx = 0;
		gbc_labIole.gridy = 0;
		pathIcon = "res/steQr.jpg";
		imgicon = new MyImageIcon(pathIcon, 50, 50);
		panel_9.add(labeste, gbc_labIole);
		labeste.setIcon(imgicon.getImageResponsive());
		
		JButton buttonSteLink = new JButton("");
		buttonSteLink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Desktop desktop = Desktop.isDesktopSupported() ? Desktop.getDesktop() : null;
			    if (desktop != null && desktop.isSupported(Desktop.Action.BROWSE)) {
			        try {
			            desktop.browse(new URI("https://it.linkedin.com/pub/stefania-cardamone/99/29/475"));
			        } catch (Exception e) {
			            e.printStackTrace();
			        }
			    }
			}
		});
		buttonSteLink.setBackground(new Color(228, 230, 235));
		buttonSteLink.setBorderPainted(false);
		buttonSteLink.setFocusPainted(false);
		buttonSteLink.setContentAreaFilled(false);
		buttonSteLink.setIcon(new ImageIcon(About.class.getResource("/com/smartAPI/view/res/Linkedin.png")));
		panel_8.add(buttonSteLink, BorderLayout.EAST);

		pathIcon = "res/steQr.jpg";
		imgicon = new MyImageIcon(pathIcon, 50, 50);
		
		
		JLabel label_4 = new JLabel("");
		add(label_4);
	}
}
