package com.smartAPI.view;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import com.smartAPI.model.Common;
import com.smartAPI.model.SmartAPIModel;
import com.smartAPI.model.UserClassification;

import java.awt.Font;
import java.util.ArrayList;

public class UserClassificationJPanel extends JPanel {

	public UserClassificationJPanel() {
		setLayout(null);
		setBackground(new Color(228, 230, 235));
		Border border;

		String username="ciro";
		boolean flag=true; //if user is not one, not two, not three
		boolean first = false;
		boolean second = false;
		boolean third = false;
		JPanel panelGeneric = new JPanel();
		panelGeneric.setVisible(false);
		UserClassification uN = null;
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

		JLabel lblGenericIcon = null;
		JLabel lblGenericUsername = null;
		JLabel lblGenericScore = null;
		JLabel lblGenericVoteCP = null;
		JLabel lblGenericVoteUs = null;

		String path="";
		String pathIcon="";
		MyImageIcon imgicon;

		SmartAPIModel s = new SmartAPIModel();
		ArrayList<String> c = s.classificaUtenti();
		ArrayList<UserClassification> classifica = s.getInfoUserClassification(c);

		System.out.println("classifica.size() = "+classifica.size());
		if (classifica.size() == 1){
			u1 = new UserClassification(classifica.get(0).getUsername(), classifica.get(0).getSomma_media(), 
					classifica.get(0).getVotanti_codepattern(), classifica.get(0).getUtenti_votanti(), classifica.get(0).getAvatar());

			System.out.println("*******");
			System.out.println(u1);
			System.out.println("*******");
			
			 first = true;
			
		}

		if (classifica.size() == 2){
			u1 = new UserClassification(classifica.get(0).getUsername(), classifica.get(0).getSomma_media(), 
					classifica.get(0).getVotanti_codepattern(), classifica.get(0).getUtenti_votanti(), classifica.get(0).getAvatar());

			System.out.println("*******");
			System.out.println(u1);
			System.out.println("*******");
			u2 = new UserClassification(classifica.get(1).getUsername(), classifica.get(1).getSomma_media(), 
					classifica.get(1).getVotanti_codepattern(), classifica.get(1).getUtenti_votanti(), classifica.get(1).getAvatar());

			System.out.println("*******");
			System.out.println(u2);
			System.out.println("*******");
			
			 first = true;
			 second = true;
			
		}

		if (classifica.size() >= 3){
			u1 = new UserClassification(classifica.get(0).getUsername(), classifica.get(0).getSomma_media(), 
					classifica.get(0).getVotanti_codepattern(), classifica.get(0).getUtenti_votanti(), classifica.get(0).getAvatar());

			System.out.println("*******");
			System.out.println(u1);
			System.out.println("*******");
			u2 = new UserClassification(classifica.get(1).getUsername(), classifica.get(1).getSomma_media(), 
					classifica.get(1).getVotanti_codepattern(), classifica.get(1).getUtenti_votanti(), classifica.get(1).getAvatar());

			System.out.println("*******");
			System.out.println(u2);
			System.out.println("*******");	

			u3 = new UserClassification(classifica.get(2).getUsername(), classifica.get(2).getSomma_media(), 
					classifica.get(2).getVotanti_codepattern(), classifica.get(2).getUtenti_votanti(), classifica.get(2).getAvatar());

			System.out.println("*******");
			System.out.println(u3);
			System.out.println("*******");
			
			 first = true;
			 second = true;
			 third = true;
		}

		int positionUser = getPositionUser(classifica, username);

		if (positionUser>3){
			int position = positionUser-1;
			uN = new UserClassification(classifica.get(position).getUsername(), classifica.get(position).getSomma_media(), 
					classifica.get(position).getVotanti_codepattern(), classifica.get(position).getUtenti_votanti(), classifica.get(position).getAvatar());

			System.out.println("*******");
			System.out.println(uN);
			System.out.println("*******");
		}
		else flag=false; //username is first or second or third

		// ******  FIRST ******
		JPanel panelFirst = new JPanel();
		panelFirst.setBounds(91, 84, 645, 78);
		if (positionUser == 1)
			panelFirst.setBackground(new Color(159, 247, 129));
		else
			panelFirst.setBackground(new Color(27, 147, 225));
		border = BorderFactory.createLineBorder(new Color(2, 94, 137), 1);
		panelFirst.setBorder(border);
		add(panelFirst);
		panelFirst.setLayout(null);

		JLabel lblOne = new JLabel("1");
		lblOne.setForeground(Color.WHITE);
		lblOne.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblOne.setHorizontalAlignment(SwingConstants.CENTER);
		lblOne.setBounds(6, 6, 64, 66);
		panelFirst.add(lblOne);

		lblIconOne = new JLabel("");
		lblIconOne.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconOne.setForeground(Color.WHITE);
		lblIconOne.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblIconOne.setBounds(71, 6, 64, 66);

		if (first){
			path="res/1.png";
			pathIcon = getClass().getResource(path).getFile();
			imgicon = new MyImageIcon(pathIcon,50,40);
			lblIconOne.setIcon(imgicon.getImageResponsive());
			panelFirst.add(lblIconOne);
		}

		lblFirstUsername = new JLabel("-");
		if (first) lblFirstUsername = new JLabel(u1.getUsername());
		lblFirstUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstUsername.setForeground(Color.WHITE);
		lblFirstUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblFirstUsername.setBounds(150, 6, 130, 66);
		panelFirst.add(lblFirstUsername);

		
		lblFirstScore = new JLabel("-");
		if (first) lblFirstScore = new JLabel(u1.getSomma_media());
		lblFirstScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstScore.setForeground(Color.WHITE);
		lblFirstScore.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblFirstScore.setBounds(292, 6, 78, 66);
		panelFirst.add(lblFirstScore);

		lblFirstVoteCP = new JLabel("-");
		if (first) lblFirstVoteCP = new JLabel(u1.getVotanti_codepattern());
		lblFirstVoteCP.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstVoteCP.setForeground(Color.WHITE);
		lblFirstVoteCP.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblFirstVoteCP.setBounds(404, 6, 78, 66);
		panelFirst.add(lblFirstVoteCP);

		lblFirstVoteUs = new JLabel("-");
		if (first) lblFirstVoteUs = new JLabel(u1.getUtenti_votanti());
		lblFirstVoteUs.setHorizontalAlignment(SwingConstants.CENTER);
		lblFirstVoteUs.setForeground(Color.WHITE);
		lblFirstVoteUs.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblFirstVoteUs.setBounds(534, 6, 78, 66);
		panelFirst.add(lblFirstVoteUs);

		// ******  SECOND ******
		JPanel panelSecond = new JPanel();
		panelSecond.setLayout(null);
		if (positionUser == 2)
			panelSecond.setBackground(new Color(159, 247, 129));
		else
			panelSecond.setBackground(new Color(27, 147, 225));
		border = BorderFactory.createLineBorder(new Color(2, 94, 137), 1);
		panelSecond.setBorder(border);
		panelSecond.setBounds(91, 161, 645, 78);
		add(panelSecond);

		JLabel lblTwo = new JLabel("2");
		lblTwo.setForeground(Color.WHITE);
		lblTwo.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblTwo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTwo.setBounds(6, 6, 64, 66);
		panelSecond.add(lblTwo);

		lblIconTwo = new JLabel(" ");
		lblIconTwo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconTwo.setForeground(Color.WHITE);
		lblIconTwo.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblIconTwo.setBounds(76, 6, 64, 66);
		panelSecond.add(lblIconTwo);

		if (second){
		path="res/2.png";
		pathIcon = getClass().getResource(path).getFile();
		imgicon = new MyImageIcon(pathIcon,50,40);
		lblIconTwo.setIcon(imgicon.getImageResponsive());
		}
		
		lblSecondUsername = new JLabel("-");
		if (second) lblSecondUsername = new JLabel(u2.getUsername());
		lblSecondUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblSecondUsername.setForeground(Color.WHITE);
		lblSecondUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblSecondUsername.setBounds(152, 6, 127, 66);
		panelSecond.add(lblSecondUsername);

		lblSecondScore = new JLabel("-");
		if (second) lblSecondScore = new JLabel(u2.getSomma_media());
		lblSecondScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblSecondScore.setForeground(Color.WHITE);
		lblSecondScore.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblSecondScore.setBounds(291, 6, 78, 66);
		panelSecond.add(lblSecondScore);

		lblSecondVoteCP = new JLabel("-");
		if (second) lblSecondVoteCP = new JLabel(u2.getVotanti_codepattern());
		lblSecondVoteCP.setHorizontalAlignment(SwingConstants.CENTER);
		lblSecondVoteCP.setForeground(Color.WHITE);
		lblSecondVoteCP.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblSecondVoteCP.setBounds(407, 6, 78, 66);
		panelSecond.add(lblSecondVoteCP);

		lblSecondVoteUs = new JLabel("-");
		if (second) lblSecondVoteUs = new JLabel(u2.getUtenti_votanti());
		lblSecondVoteUs.setHorizontalAlignment(SwingConstants.CENTER);
		lblSecondVoteUs.setForeground(Color.WHITE);
		lblSecondVoteUs.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblSecondVoteUs.setBounds(533, 6, 78, 66);
		panelSecond.add(lblSecondVoteUs);
		//panelSecond.add(lblIconTwo);

		// ******  THIRD ******
		JPanel panelThird = new JPanel();
		panelThird.setLayout(null);
		if (positionUser == 3)
			panelThird.setBackground(new Color(159, 247, 129));
		else
			panelThird.setBackground(new Color(27, 147, 225));
		border = BorderFactory.createLineBorder(new Color(2, 94, 137), 1);
		panelThird.setBorder(border);
		panelThird.setBounds(91, 238, 645, 78);
		add(panelThird);

		JLabel lblThree = new JLabel("3");
		lblThree.setForeground(Color.WHITE);
		lblThree.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblThree.setHorizontalAlignment(SwingConstants.CENTER);
		lblThree.setBounds(6, 6, 64, 66);
		panelThird.add(lblThree);

		lblIconThree = new JLabel(" ");
		lblIconThree.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconThree.setForeground(Color.WHITE);
		lblIconThree.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblIconThree.setBounds(78, 6, 64, 66);
		panelThird.add(lblIconThree);

		if (third){
		path="res/3.png";
		pathIcon = getClass().getResource(path).getFile();
		imgicon = new MyImageIcon(pathIcon,50,40);
		lblIconThree.setIcon(imgicon.getImageResponsive());
		}
		
		lblThirdUsername = new JLabel("-");
		if (third) lblThirdUsername = new JLabel(u3.getUsername());
		lblThirdUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblThirdUsername.setForeground(Color.WHITE);
		lblThirdUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblThirdUsername.setBounds(154, 6, 124, 66);
		panelThird.add(lblThirdUsername);

		lblThirdScore = new JLabel("-");
		if (third) lblThirdScore = new JLabel(u3.getSomma_media());
		lblThirdScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblThirdScore.setForeground(Color.WHITE);
		lblThirdScore.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblThirdScore.setBounds(290, 6, 78, 66);
		panelThird.add(lblThirdScore);

		lblThirdVoteCP = new JLabel("-");
		if (third) lblThirdVoteCP = new JLabel(u3.getVotanti_codepattern());
		lblThirdVoteCP.setHorizontalAlignment(SwingConstants.CENTER);
		lblThirdVoteCP.setForeground(Color.WHITE);
		lblThirdVoteCP.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblThirdVoteCP.setBounds(408, 6, 78, 66);
		panelThird.add(lblThirdVoteCP);

		lblThirdVoteUs = new JLabel("-");
		if (third) lblThirdVoteUs = new JLabel(u3.getUtenti_votanti());
		lblThirdVoteUs.setHorizontalAlignment(SwingConstants.CENTER);
		lblThirdVoteUs.setForeground(Color.WHITE);
		lblThirdVoteUs.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblThirdVoteUs.setBounds(533, 6, 78, 66);
		panelThird.add(lblThirdVoteUs);
		//panelThird.add(lblIconThree);

		// ******  Generic ******

		if (flag){
			panelGeneric.setVisible(true);
			panelGeneric.setBackground(new Color(159, 247, 129));
			panelGeneric.setLayout(null);
			border = BorderFactory.createLineBorder(new Color(2, 94, 137), 1);
			panelGeneric.setBorder(border);
			panelGeneric.setBounds(91, 406, 645, 78);
			add(panelGeneric);

			JLabel lblGeneric = new JLabel("16");
			lblGeneric.setForeground(Color.WHITE);
			lblGeneric.setHorizontalAlignment(SwingConstants.CENTER);
			lblGeneric.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			lblGeneric.setBounds(6, 6, 64, 66);
			panelGeneric.add(lblGeneric);

			lblGenericIcon = new JLabel(" ");
			lblGenericIcon.setHorizontalAlignment(SwingConstants.CENTER);
			lblGenericIcon.setForeground(Color.WHITE);
			lblGenericIcon.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			lblGenericIcon.setBounds(79, 6, 64, 66);
			panelGeneric.add(lblGenericIcon);

			path="res/4.png";
			pathIcon = getClass().getResource(path).getFile();
			imgicon = new MyImageIcon(pathIcon,50,40);
			lblGenericIcon.setIcon(imgicon.getImageResponsive());

			lblGenericUsername = new JLabel(uN.getUsername());
			lblGenericUsername.setHorizontalAlignment(SwingConstants.CENTER);
			lblGenericUsername.setForeground(Color.WHITE);
			lblGenericUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			lblGenericUsername.setBounds(155, 6, 124, 66);
			panelGeneric.add(lblGenericUsername);

			lblGenericScore = new JLabel(uN.getSomma_media());
			lblGenericScore.setHorizontalAlignment(SwingConstants.CENTER);
			lblGenericScore.setForeground(Color.WHITE);
			lblGenericScore.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			lblGenericScore.setBounds(291, 6, 78, 66);
			panelGeneric.add(lblGenericScore);

			lblGenericVoteCP = new JLabel(uN.getVotanti_codepattern());
			lblGenericVoteCP.setHorizontalAlignment(SwingConstants.CENTER);
			lblGenericVoteCP.setForeground(Color.WHITE);
			lblGenericVoteCP.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			lblGenericVoteCP.setBounds(408, 6, 78, 66);
			panelGeneric.add(lblGenericVoteCP);

			lblGenericVoteUs = new JLabel(uN.getUtenti_votanti());
			lblGenericVoteUs.setHorizontalAlignment(SwingConstants.CENTER);
			lblGenericVoteUs.setForeground(Color.WHITE);
			lblGenericVoteUs.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
			lblGenericVoteUs.setBounds(532, 6, 78, 66);
			panelGeneric.add(lblGenericVoteUs);

		}

		//********
		JPanel panelInfo = new JPanel();
		panelInfo.setLayout(null);
		panelInfo.setBackground(Color.LIGHT_GRAY);
		panelInfo.setBounds(91, 20, 645, 39);
		add(panelInfo);

		JLabel lblScore = new JLabel("Score");
		lblScore.setHorizontalAlignment(SwingConstants.CENTER);
		lblScore.setForeground(Color.WHITE);
		lblScore.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblScore.setBounds(296, 6, 64, 27);
		panelInfo.add(lblScore);

		JLabel label_1 = new JLabel("");
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		label_1.setBounds(108, 6, 64, 66);
		panelInfo.add(label_1);

		JLabel lblVoter = new JLabel("Voters CP");
		lblVoter.setHorizontalAlignment(SwingConstants.CENTER);
		lblVoter.setForeground(Color.WHITE);
		lblVoter.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblVoter.setBounds(394, 6, 95, 27);
		panelInfo.add(lblVoter);

		JLabel lblUser = new JLabel("Username");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setForeground(Color.WHITE);
		lblUser.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblUser.setBounds(170, 6, 95, 27);
		panelInfo.add(lblUser);

		JLabel lblVotersUser = new JLabel("Voters User");
		lblVotersUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblVotersUser.setForeground(Color.WHITE);
		lblVotersUser.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblVotersUser.setBounds(512, 6, 111, 27);
		panelInfo.add(lblVotersUser);

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
}
