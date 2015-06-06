package com.smartAPI.view;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;
import java.util.ArrayList;
import java.util.logging.Logger;

import javax.swing.SwingConstants;
import javax.swing.border.Border;

import com.smartAPI.model.SmartAPIModel;
import com.smartAPI.model.UserClassification;

public class UserClassificationNew extends JPanel {

	public JPanel panelFirst;
	public JPanel panelThird;
	public JPanel panelSecond;
		public JPanel panelGeneric;
	SmartAPIModel s;
		ArrayList<String> c;
		ArrayList<UserClassification> classifica;
		UserClassification uN;
		boolean flag=true; //if user is not one, not two, not three
		JLabel lblGenericIcon = null;
		JLabel lblGenericUsername = null;
		JLabel lblGenericScore = null;
		JLabel lblGenericVoteCP = null;
		JLabel lblGenericVoteUs = null;
	
	private static Logger log = Logger.getLogger("global");

	public UserClassificationNew(String username) {
		panelFirst = new JPanel();
		panelSecond = new JPanel();
		panelThird = new JPanel();
		panelGeneric = new JPanel();
		setGenericLayout();
		s = new SmartAPIModel();
		c = s.classificaUtenti();
		classifica = s.getInfoUserClassification(c);
		start(username);

	}

	public void  setRowUser(String username){
		
		initBackground();
		int positionUser = getPositionUser(classifica, username);
		log.info("Position of "+username+" is: "+positionUser);

		if (positionUser == 1)
			panelFirst.setBackground(new Color(159, 247, 129));
		if (positionUser == 2)
			panelSecond.setBackground(new Color(159, 247, 129));
		if (positionUser == 3)
			panelThird.setBackground(new Color(159, 247, 129));
		
		if (positionUser>3){
			int position = positionUser-1;
			uN = new UserClassification(classifica.get(position).getUsername(), classifica.get(position).getSomma_media(), 
					classifica.get(position).getVotanti_codepattern(), classifica.get(position).getUtenti_votanti(), classifica.get(position).getAvatar());

			log.info("*******");
			log.info(uN.toString());
			log.info("*******");
			flag=true;
		}
		else flag=false; //username is first or second or third
		
		if (flag){
			initGeneric(uN);
		}
		
	}
	
	public void start(String user) {
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{187, 187, 187, 0};
		gridBagLayout.rowHeights = new int[]{392, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		JPanel panelL = new JPanel();
		GridBagConstraints gbc_panelL = new GridBagConstraints();
		gbc_panelL.fill = GridBagConstraints.BOTH;
		gbc_panelL.insets = new Insets(0, 0, 5, 5);
		gbc_panelL.gridx = 0;
		gbc_panelL.gridy = 0;
		add(panelL, gbc_panelL);
		panelL.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panelR = new JPanel();
		GridBagConstraints gbc_panelR = new GridBagConstraints();
		gbc_panelR.insets = new Insets(0, 0, 5, 0);
		gbc_panelR.fill = GridBagConstraints.BOTH;
		gbc_panelR.gridx = 2;
		gbc_panelR.gridy = 0;
		add(panelR, gbc_panelR);

		JPanel ClassificationJPanel = new JPanel();
		GridBagConstraints gbc_ClassificationJPanel = new GridBagConstraints();
		gbc_ClassificationJPanel.fill = GridBagConstraints.BOTH;
		gbc_ClassificationJPanel.insets = new Insets(0, 0, 5, 5);
		gbc_ClassificationJPanel.gridx = 1;
		gbc_ClassificationJPanel.gridy = 0;
		add(ClassificationJPanel, gbc_ClassificationJPanel);
		ClassificationJPanel.setLayout(new GridLayout(6, 0, 0, 0));

		JPanel panelInfo = new JPanel();
		panelInfo.setBackground(Color.LIGHT_GRAY);
		ClassificationJPanel.add(panelInfo);
		GridBagLayout gbl_panelInfo = new GridBagLayout();
		gbl_panelInfo.columnWidths = new int[]{107, 0, 0, 47, 112, 86, 100, 0};
		gbl_panelInfo.rowHeights = new int[] {2};
		gbl_panelInfo.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelInfo.rowWeights = new double[]{0.0};
		panelInfo.setLayout(gbl_panelInfo);

		JLabel label = new JLabel("Username");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		GridBagConstraints gbc_label = new GridBagConstraints();
		gbc_label.insets = new Insets(0, 0, 0, 5);
		gbc_label.gridx = 2;
		gbc_label.gridy = 0;
		panelInfo.add(label, gbc_label);

		JLabel label_1 = new JLabel("Score");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		GridBagConstraints gbc_label_1 = new GridBagConstraints();
		gbc_label_1.insets = new Insets(0, 0, 0, 5);
		gbc_label_1.gridx = 3;
		gbc_label_1.gridy = 0;
		panelInfo.add(label_1, gbc_label_1);

		JLabel label_2 = new JLabel("Voters CP");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		GridBagConstraints gbc_label_2 = new GridBagConstraints();
		gbc_label_2.insets = new Insets(0, 0, 0, 5);
		gbc_label_2.gridx = 4;
		gbc_label_2.gridy = 0;
		panelInfo.add(label_2, gbc_label_2);

		JLabel label_3 = new JLabel("Voters User");
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		GridBagConstraints gbc_label_3 = new GridBagConstraints();
		gbc_label_3.insets = new Insets(0, 0, 0, 5);
		gbc_label_3.gridx = 5;
		gbc_label_3.gridy = 0;
		panelInfo.add(label_3, gbc_label_3);

		ClassificationJPanel.add(panelFirst);
		setFirstLayout();

		JLabel lblOne = new JLabel("1");
		lblOne.setHorizontalAlignment(SwingConstants.CENTER);
		lblOne.setForeground(Color.WHITE);
		lblOne.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		GridBagConstraints gbc_lblOne = new GridBagConstraints();
		gbc_lblOne.fill = GridBagConstraints.BOTH;
		gbc_lblOne.insets = new Insets(0, 0, 0, 5);
		gbc_lblOne.gridx = 0;
		gbc_lblOne.gridy = 0;
		panelFirst.add(lblOne, gbc_lblOne);

		setBackground(new Color(228, 230, 235));
		Border border;

		String username=user;

		boolean first = false;
		boolean second = false;
		boolean third = false;

		panelGeneric.setVisible(false);
		uN = null;
		UserClassification u1 = null;
		UserClassification u2 = null;
		UserClassification u3 = null;

		JLabel lblIconOne = null;
		JLabel lblFirstUsername = null;
		JLabel lblFirstScore = null;
		JLabel lblFirstVoteCP = null;
		JLabel lblFirstVoteUs = null;

		JLabel lblIconTwo = null;
		JLabel lblSecondUsername = null;
		JLabel lblSecondScore = null;
		JLabel lblSecondVoteCP = null;
		JLabel lblSecondVoteUs = null;

		JLabel lblIconThree = null;
		JLabel lblThirdUsername = null;
		JLabel lblThirdScore = null;
		JLabel lblThirdVoteCP = null;
		JLabel lblThirdVoteUs = null;

		

		String path="";
		String pathIcon="";
		MyImageIcon imgicon;

//		SmartAPIModel s = new SmartAPIModel();
//		ArrayList<String> c = s.classificaUtenti();
//		ArrayList<UserClassification> classifica = s.getInfoUserClassification(c);

		log.info("classifica.size() = "+classifica.size());
		//System.out.println("classifica.size() = "+classifica.size());
		if (classifica.size() == 1){
			u1 = new UserClassification(classifica.get(0).getUsername(), classifica.get(0).getSomma_media(), 
					classifica.get(0).getVotanti_codepattern(), classifica.get(0).getUtenti_votanti(), classifica.get(0).getAvatar());

			log.info("*******");
			log.info(u1.toString());
			log.info("*******");

			first = true;

		}

		if (classifica.size() == 2){
			u1 = new UserClassification(classifica.get(0).getUsername(), classifica.get(0).getSomma_media(), 
					classifica.get(0).getVotanti_codepattern(), classifica.get(0).getUtenti_votanti(), classifica.get(0).getAvatar());

			log.info("*******");
			log.info(u1.toString());
			log.info("*******");
			u2 = new UserClassification(classifica.get(1).getUsername(), classifica.get(1).getSomma_media(), 
					classifica.get(1).getVotanti_codepattern(), classifica.get(1).getUtenti_votanti(), classifica.get(1).getAvatar());

			log.info("*******");
			log.info(u2.toString());
			log.info("*******");

			first = true;
			second = true;

		}

		if (classifica.size() >= 3){
			u1 = new UserClassification(classifica.get(0).getUsername(), classifica.get(0).getSomma_media(), 
					classifica.get(0).getVotanti_codepattern(), classifica.get(0).getUtenti_votanti(), classifica.get(0).getAvatar());

			log.info("*******");
			log.info(u1.toString());
			log.info("*******");
			u2 = new UserClassification(classifica.get(1).getUsername(), classifica.get(1).getSomma_media(), 
					classifica.get(1).getVotanti_codepattern(), classifica.get(1).getUtenti_votanti(), classifica.get(1).getAvatar());

			log.info("*******");
			log.info(u2.toString());
			log.info("*******");

			u3 = new UserClassification(classifica.get(2).getUsername(), classifica.get(2).getSomma_media(), 
					classifica.get(2).getVotanti_codepattern(), classifica.get(2).getUtenti_votanti(), classifica.get(2).getAvatar());

			log.info("*******");
			log.info(u3.toString());
			log.info("*******");

			first = true;
			second = true;
			third = true;
		}

//		int positionUser = getPositionUser(classifica, username);
//		log.info("Position of "+username+" is: "+positionUser);
//
//		if (positionUser>3){
//			int position = positionUser-1;
//			uN = new UserClassification(classifica.get(position).getUsername(), classifica.get(position).getSomma_media(), 
//					classifica.get(position).getVotanti_codepattern(), classifica.get(position).getUtenti_votanti(), classifica.get(position).getAvatar());
//
//			log.info("*******");
//			log.info(uN.toString());
//			log.info("*******");
//
//		}
//		else flag=false; //username is first or second or third
//
//
//		// ******  FIRST ****** 
//
//		if (positionUser == 1)
//			panelFirst.setBackground(new Color(159, 247, 129));
//		else
	   panelFirst.setBackground(new Color(27, 147, 225));
		border = BorderFactory.createLineBorder(new Color(2, 94, 137), 1);
		panelFirst.setBorder(border);
		lblIconOne = new JLabel("");
		lblIconOne.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconOne.setForeground(Color.WHITE);
		lblIconOne.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		GridBagConstraints gbc_lblIconOne = new GridBagConstraints();
		gbc_lblIconOne.fill = GridBagConstraints.BOTH;
		gbc_lblIconOne.insets = new Insets(0, 0, 0, 5);
		gbc_lblIconOne.gridx = 1;
		gbc_lblIconOne.gridy = 0;
		panelFirst.add(lblIconOne, gbc_lblIconOne);

		if (first){
			pathIcon=u1.getAvatar();
			imgicon = new MyImageIcon(pathIcon,33,23);
			lblIconOne.setIcon(imgicon.getImageResponsive());
			panelFirst.add(lblIconOne);
		}
		
		lblFirstUsername = new JLabel("-");
		if (first) lblFirstUsername = new JLabel(u1.getUsername());
		lblFirstUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstUsername.setForeground(Color.WHITE);
		lblFirstUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		GridBagConstraints gbc_lblFirstUsername = new GridBagConstraints();
		gbc_lblFirstUsername.fill = GridBagConstraints.BOTH;
		gbc_lblFirstUsername.insets = new Insets(0, 0, 0, 5);
		gbc_lblFirstUsername.gridx = 3;
		gbc_lblFirstUsername.gridy = 0;
		panelFirst.add(lblFirstUsername, gbc_lblFirstUsername);

		lblFirstScore = new JLabel("-");
		if (first) lblFirstScore = new JLabel(u1.getSomma_media());
		lblFirstScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstScore.setForeground(Color.WHITE);
		lblFirstScore.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		GridBagConstraints gbc_lblFirstScore = new GridBagConstraints();
		gbc_lblFirstScore.fill = GridBagConstraints.BOTH;
		gbc_lblFirstScore.insets = new Insets(0, 0, 0, 5);
		gbc_lblFirstScore.gridx = 4;
		gbc_lblFirstScore.gridy = 0;
		panelFirst.add(lblFirstScore, gbc_lblFirstScore);

		lblFirstVoteCP = new JLabel("-");
		if (first) lblFirstVoteCP = new JLabel(u1.getVotanti_codepattern());
		lblFirstVoteCP.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstVoteCP.setForeground(Color.WHITE);
		lblFirstVoteCP.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		GridBagConstraints gbc_lblFirstVoteCP = new GridBagConstraints();
		gbc_lblFirstVoteCP.fill = GridBagConstraints.BOTH;
		gbc_lblFirstVoteCP.insets = new Insets(0, 0, 0, 5);
		gbc_lblFirstVoteCP.gridx = 6;
		gbc_lblFirstVoteCP.gridy = 0;
		panelFirst.add(lblFirstVoteCP, gbc_lblFirstVoteCP);

		lblFirstVoteUs = new JLabel("-");
		if (first) lblFirstVoteUs = new JLabel(u1.getUtenti_votanti());
		lblFirstVoteUs.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstVoteUs.setForeground(Color.WHITE);
		lblFirstVoteUs.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		GridBagConstraints gbc_lblFirstVoteUs = new GridBagConstraints();
		gbc_lblFirstVoteUs.fill = GridBagConstraints.BOTH;
		gbc_lblFirstVoteUs.gridx = 8;
		gbc_lblFirstVoteUs.gridy = 0;
		panelFirst.add(lblFirstVoteUs, gbc_lblFirstVoteUs);

		
		
		
		
		


		// ******  SECOND ******


		panelSecond = new JPanel();

			panelSecond.setBackground(new Color(27, 147, 225));
		border = BorderFactory.createLineBorder(new Color(2, 94, 137), 1);
		panelSecond.setBorder(border);
		ClassificationJPanel.add(panelSecond);
		setSecondLayout();

		JLabel lblTwo = new JLabel("2");
		lblTwo.setForeground(Color.WHITE);
		lblTwo.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblTwo.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblTwo = new GridBagConstraints();
		gbc_lblTwo.insets = new Insets(0, 0, 0, 5);
		gbc_lblTwo.gridx = 0;
		gbc_lblTwo.gridy = 0;
		panelSecond.add(lblTwo, gbc_lblTwo);

		lblIconTwo = new JLabel("");
		lblIconTwo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconTwo.setForeground(Color.WHITE);
		lblIconTwo.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		GridBagConstraints gbc_lblIconTwo1 = new GridBagConstraints();
		gbc_lblIconTwo1.insets = new Insets(0, 0, 0, 5);
		gbc_lblIconTwo1.gridx = 1;
		gbc_lblIconTwo1.gridy = 0;
		panelSecond.add(lblIconTwo, gbc_lblIconTwo1);

		if (second){
			pathIcon=u2.getAvatar();
			imgicon = new MyImageIcon(pathIcon,33,23);
			lblIconTwo.setIcon(imgicon.getImageResponsive());
		}

		lblSecondUsername = new JLabel("");
		if (second) lblSecondUsername = new JLabel(u2.getUsername());
		lblSecondUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblSecondUsername.setForeground(Color.WHITE);
		lblSecondUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		GridBagConstraints gbc_lblSecondUsername1 = new GridBagConstraints();
		gbc_lblSecondUsername1.insets = new Insets(0, 0, 0, 5);
		gbc_lblSecondUsername1.gridx = 2;
		gbc_lblSecondUsername1.gridy = 0;
		panelSecond.add(lblSecondUsername, gbc_lblSecondUsername1);

		lblSecondScore = new JLabel("");
		if (second) lblSecondScore = new JLabel(u2.getSomma_media());
		lblSecondScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblSecondScore.setForeground(Color.WHITE);
		lblSecondScore.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		GridBagConstraints gbc_lblSecondScore1 = new GridBagConstraints();
		gbc_lblSecondScore1.insets = new Insets(0, 0, 0, 5);
		gbc_lblSecondScore1.gridx = 3;
		gbc_lblSecondScore1.gridy = 0;
		panelSecond.add(lblSecondScore, gbc_lblSecondScore1);

		lblSecondVoteCP = new JLabel("");
		if (second) lblSecondVoteCP = new JLabel(u2.getVotanti_codepattern());
		lblSecondVoteCP.setHorizontalAlignment(SwingConstants.CENTER);
		lblSecondVoteCP.setForeground(Color.WHITE);
		lblSecondVoteCP.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		GridBagConstraints gbc_lblSecondVoteCP1 = new GridBagConstraints();
		gbc_lblSecondVoteCP1.insets = new Insets(0, 0, 0, 5);
		gbc_lblSecondVoteCP1.gridx = 4;
		gbc_lblSecondVoteCP1.gridy = 0;
		panelSecond.add(lblSecondVoteCP, gbc_lblSecondVoteCP1);

		lblSecondVoteUs = new JLabel("");
		if (second) lblSecondVoteUs = new JLabel(u2.getUtenti_votanti());
		lblSecondVoteUs.setHorizontalAlignment(SwingConstants.CENTER);
		lblSecondVoteUs.setForeground(Color.WHITE);
		lblSecondVoteUs.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		GridBagConstraints gbc_lblSecondVoteUs1 = new GridBagConstraints();
		gbc_lblSecondVoteUs1.insets = new Insets(0, 0, 0, 5);
		gbc_lblSecondVoteUs1.gridx = 5;
		gbc_lblSecondVoteUs1.gridy = 0;
		panelSecond.add(lblSecondVoteUs, gbc_lblSecondVoteUs1);

		// ******  THIRD ******

		ClassificationJPanel.add(panelThird);
		setThirdLayout();

			panelThird.setBackground(new Color(27, 147, 225));
		border = BorderFactory.createLineBorder(new Color(2, 94, 137), 1);
		panelThird.setBorder(border);
		

		JLabel lblThree = new JLabel("3");
		lblThree.setForeground(Color.WHITE);
		lblThree.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		lblThree.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblThree = new GridBagConstraints();
		gbc_lblThree.insets = new Insets(0, 0, 0, 5);
		gbc_lblThree.gridx = 0;
		gbc_lblThree.gridy = 0;
		panelThird.add(lblThree, gbc_lblThree);

		lblIconThree = new JLabel("");
		lblIconThree.setForeground(Color.WHITE);
		lblIconThree.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblIconThree.setBounds(73, 6, 45, 27);
		GridBagConstraints gbc_lblIconThree1 = new GridBagConstraints();
		gbc_lblIconThree1.insets = new Insets(0, 0, 0, 5);
		gbc_lblIconThree1.gridx = 1;
		gbc_lblIconThree1.gridy = 0;
		panelThird.add(lblIconThree, gbc_lblIconThree1);

		if (third){
			pathIcon=u3.getAvatar();
			imgicon = new MyImageIcon(pathIcon,33,23);
			lblIconThree.setIcon(imgicon.getImageResponsive());
		}

		lblThirdUsername = new JLabel("");
		if (third) lblThirdUsername = new JLabel(u3.getUsername());
		lblThirdUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblThirdUsername.setForeground(Color.WHITE);
		lblThirdUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		GridBagConstraints gbc_lblThirdUsername1 = new GridBagConstraints();
		gbc_lblThirdUsername1.insets = new Insets(0, 0, 0, 5);
		gbc_lblThirdUsername1.gridx = 2;
		gbc_lblThirdUsername1.gridy = 0;
		panelThird.add(lblThirdUsername, gbc_lblThirdUsername1);

		lblThirdScore = new JLabel("");
		if (third) lblThirdScore = new JLabel(u3.getSomma_media());
		lblThirdScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblThirdScore.setForeground(Color.WHITE);
		lblThirdScore.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		GridBagConstraints lblThirdScore1 = new GridBagConstraints();
		lblThirdScore1.insets = new Insets(0, 0, 0, 5);
		lblThirdScore1.gridx = 3;
		lblThirdScore1.gridy = 0;
		panelThird.add(lblThirdScore, lblThirdScore1);

		lblThirdVoteCP = new JLabel("");
		if (third) lblThirdVoteCP = new JLabel(u3.getVotanti_codepattern());
		lblThirdVoteCP.setHorizontalAlignment(SwingConstants.CENTER);
		lblThirdVoteCP.setForeground(Color.WHITE);
		lblThirdVoteCP.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		GridBagConstraints gbc_lblThirdVoteCP1 = new GridBagConstraints();
		gbc_lblThirdVoteCP1.insets = new Insets(0, 0, 0, 5);
		gbc_lblThirdVoteCP1.gridx = 4;
		gbc_lblThirdVoteCP1.gridy = 0;
		panelThird.add(lblThirdVoteCP, gbc_lblThirdVoteCP1);

		lblThirdVoteUs = new JLabel("");
		if (third) lblThirdVoteUs = new JLabel(u3.getUtenti_votanti());
		lblThirdVoteUs.setHorizontalAlignment(SwingConstants.CENTER);
		lblThirdVoteUs.setForeground(Color.WHITE);
		lblThirdVoteUs.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		GridBagConstraints gbc_lblThirdVoteUs1 = new GridBagConstraints();
		gbc_lblThirdVoteUs1.gridx = 5;
		gbc_lblThirdVoteUs1.gridy = 0;
		panelThird.add(lblThirdVoteUs, gbc_lblThirdVoteUs1);
		
		JPanel panelNull = new JPanel();
		panelNull.setVisible(false);
		ClassificationJPanel.add(panelNull);
		GridBagLayout gbl_panelNull = new GridBagLayout();
		gbl_panelNull.columnWidths = new int[]{0};
		gbl_panelNull.rowHeights = new int[]{0};
		gbl_panelNull.columnWeights = new double[]{Double.MIN_VALUE};
		gbl_panelNull.rowWeights = new double[]{Double.MIN_VALUE};
		panelNull.setLayout(gbl_panelNull);
		
		// ******  Generic ******
		
		ClassificationJPanel.add(panelGeneric);
		setGenericLayout();
		
		panelGeneric.setBackground(new Color(159, 247, 129));
		border = BorderFactory.createLineBorder(new Color(2, 94, 137), 1);
		panelGeneric.setBorder(border);
		//panelGeneric.setVisible(true);
		
		JLabel lblGeneric = new JLabel("");
		lblGeneric.setForeground(Color.WHITE);
		lblGeneric.setHorizontalAlignment(SwingConstants.CENTER);
		lblGeneric.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		GridBagConstraints gbc_lblGeneric = new GridBagConstraints();
		gbc_lblGeneric.insets = new Insets(0, 0, 0, 5);
		gbc_lblGeneric.gridx = 0;
		gbc_lblGeneric.gridy = 0;
		panelGeneric.add(lblGeneric, gbc_lblGeneric);
		
		 lblGenericIcon = new JLabel("");
		 lblGenericIcon.setHorizontalAlignment(SwingConstants.CENTER);
			lblGenericIcon.setForeground(Color.WHITE);
			lblGenericIcon.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		GridBagConstraints gbc_lblGenericIcon1 = new GridBagConstraints();
		gbc_lblGenericIcon1.insets = new Insets(0, 0, 0, 5);
		gbc_lblGenericIcon1.gridx = 1;
		gbc_lblGenericIcon1.gridy = 0;
		panelGeneric.add(lblGenericIcon, gbc_lblGenericIcon1);
		
		
		
		lblGenericUsername = new JLabel();
		lblGenericUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenericUsername.setForeground(Color.WHITE);
		lblGenericUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		GridBagConstraints gbc_lblGenericUsername1 = new GridBagConstraints();
		gbc_lblGenericUsername1.insets = new Insets(0, 0, 0, 5);
		gbc_lblGenericUsername1.gridx = 2;
		gbc_lblGenericUsername1.gridy = 0;
		panelGeneric.add(lblGenericUsername, gbc_lblGenericUsername1);
		
		lblGenericScore = new JLabel();
		lblGenericScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenericScore.setForeground(Color.WHITE);
		lblGenericScore.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		GridBagConstraints gbc_lblGenericScore1 = new GridBagConstraints();
		gbc_lblGenericScore1.insets = new Insets(0, 0, 0, 5);
		gbc_lblGenericScore1.gridx = 3;
		gbc_lblGenericScore1.gridy = 0;
		panelGeneric.add(lblGenericScore, gbc_lblGenericScore1);
		
		lblGenericVoteCP = new JLabel();
		lblGenericVoteCP.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenericVoteCP.setForeground(Color.WHITE);
		lblGenericVoteCP.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		GridBagConstraints gbc_lblGenericVoteCP11 = new GridBagConstraints();
		gbc_lblGenericVoteCP11.insets = new Insets(0, 0, 0, 5);
		gbc_lblGenericVoteCP11.gridx = 4;
		gbc_lblGenericVoteCP11.gridy = 0;
		panelGeneric.add(lblGenericVoteCP, gbc_lblGenericVoteCP11);
		
		lblGenericVoteUs = new JLabel();
		lblGenericVoteUs.setHorizontalAlignment(SwingConstants.CENTER);
		lblGenericVoteUs.setForeground(Color.WHITE);
		lblGenericVoteUs.setFont(new Font("Lucida Grande", Font.PLAIN, 13));
		GridBagConstraints gbc_lblGenericVoteUs1 = new GridBagConstraints();
		gbc_lblGenericVoteUs1.gridx = 5;
		gbc_lblGenericVoteUs1.gridy = 0;
		panelGeneric.add(lblGenericVoteUs, gbc_lblGenericVoteUs1);

		SwingUtilities.updateComponentTreeUI(panelGeneric);
				
	}


	private static int getPositionUser(ArrayList<UserClassification> classifica, String username){
		int i=1;
		for (UserClassification u: classifica){
			if (username.equals(u.getUsername())){
				return i;
			}
			i++;
		}
		return 0; //never

	}

	public void setUser (String user){
		System.out.println("username: "+user);
		 setRowUser(user);
	}
	
	
	public void setFirstLayout(){
		GridBagLayout gbl_panelFirst = new GridBagLayout();
		gbl_panelFirst.columnWidths = new int[]{45, 45, 45, 101, 68, 44, 68, 62, 68, 0};
		gbl_panelFirst.rowHeights = new int[] {2};
		gbl_panelFirst.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelFirst.rowWeights = new double[]{0.0};
		panelFirst.setLayout(gbl_panelFirst);
	}
	
	public void setSecondLayout(){
		GridBagLayout gbl_panelSecond = new GridBagLayout();
		gbl_panelSecond.columnWidths = new int[] {45, 45, 45, 101, 68, 44, 68, 62, 68, 0};
		gbl_panelSecond.rowHeights = new int[] {2};
		gbl_panelSecond.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_panelSecond.rowWeights = new double[]{0.0};
		panelSecond.setLayout(gbl_panelSecond);
	}

	public void setThirdLayout(){
		GridBagLayout gbl_panelThird = new GridBagLayout();
		gbl_panelThird.columnWidths = new int[] {45, 45, 45, 101, 68, 44, 68, 62, 68, 30};
		gbl_panelThird.rowHeights = new int[] {2};
		gbl_panelThird.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelThird.rowWeights = new double[]{0.0};
		panelThird.setLayout(gbl_panelThird);
	}
	
	public void setGenericLayout(){
		GridBagLayout gbl_panelGeneric = new GridBagLayout();
		gbl_panelGeneric.columnWidths = new int[] {45, 45, 45, 101, 68, 44, 30, 62, 68, 30};
		gbl_panelGeneric.rowHeights = new int[] {2};
		gbl_panelGeneric.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_panelGeneric.rowWeights = new double[]{0.0};
		panelGeneric.setLayout(gbl_panelGeneric);
	}
	
	public void initGeneric(UserClassification uN){
		String pathIcon = "res/4.png";
		MyImageIcon imgicon = new MyImageIcon(pathIcon,33,23);
		lblGenericIcon.setIcon(imgicon.getImageResponsive());
		
		 lblGenericUsername.setText(uN.getUsername());
		 lblGenericScore.setText(uN.getSomma_media()) ;
		 lblGenericVoteCP.setText(uN.getVotanti_codepattern()) ;
		 lblGenericVoteUs.setText(uN.getUtenti_votanti()) ;
		 panelGeneric.setVisible(true);
	}
	
	public void initBackground(){
		panelFirst.setBackground(new Color(27, 147, 225));		
		panelSecond.setBackground(new Color(27, 147, 225));		
		panelThird.setBackground(new Color(27, 147, 225));	
		
		panelGeneric.setVisible(false);
	}
}
