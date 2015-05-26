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
		
		String username="c.amati";
		boolean flag=true; //if user is not one, not two, not three
		JPanel panelGeneral = new JPanel();
		panelGeneral.setVisible(false);
		
		SmartAPIModel s = new SmartAPIModel();
		ArrayList<String> c = s.classificaUtenti();
		ArrayList<UserClassification> classifica = s.getInfoUserClassification(c);
		
		UserClassification u1 = 
				new UserClassification(classifica.get(0).getUsername(), classifica.get(0).getSomma_media(), 
					classifica.get(0).getVotanti_codepattern(), classifica.get(0).getUtenti_votanti(), classifica.get(0).getAvatar());
		
		UserClassification u2 = 
				new UserClassification(classifica.get(1).getUsername(), classifica.get(1).getSomma_media(), 
					classifica.get(1).getVotanti_codepattern(), classifica.get(1).getUtenti_votanti(), classifica.get(1).getAvatar());
		
		UserClassification u3 = 
				new UserClassification(classifica.get(2).getUsername(), classifica.get(2).getSomma_media(), 
					classifica.get(2).getVotanti_codepattern(), classifica.get(2).getUtenti_votanti(), classifica.get(2).getAvatar());
		
		int positionUser = getPositionUser(classifica, username);
		
		if (positionUser>3){
			int position = positionUser-1;
			UserClassification uN = 
			new UserClassification(classifica.get(position).getUsername(), classifica.get(position).getSomma_media(), 
				classifica.get(position).getVotanti_codepattern(), classifica.get(position).getUtenti_votanti(), classifica.get(position).getAvatar());
		}
		
		
		// ******  FIRST ******
		JPanel panelFirst = new JPanel();
		panelFirst.setBounds(91, 84, 645, 78);
		if (positionUser == 1){
			panelFirst.setBackground(new Color(159, 247, 129));
			flag=false;
		}
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

		JLabel lblIconOne = new JLabel("");
		lblIconOne.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconOne.setForeground(Color.WHITE);
		lblIconOne.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblIconOne.setBounds(71, 6, 64, 66);

		String path="res/1.png";
		String pathIcon = getClass().getResource(path).getFile();
		MyImageIcon imgicon = new MyImageIcon(pathIcon,50,40);
		lblIconOne.setIcon(imgicon.getImageResponsive());
		panelFirst.add(lblIconOne);

		// ******  SECOND ******
		JPanel panelSecond = new JPanel();
		panelSecond.setLayout(null);
		if (positionUser == 2){
			flag=false;
			panelSecond.setBackground(new Color(159, 247, 129));
		}
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

		JLabel lblIconTwo = new JLabel(" ");
		lblIconTwo.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconTwo.setForeground(Color.WHITE);
		lblIconTwo.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblIconTwo.setBounds(76, 6, 64, 66);
		panelSecond.add(lblIconTwo);

		path="res/2.png";
		pathIcon = getClass().getResource(path).getFile();
		imgicon = new MyImageIcon(pathIcon,50,40);
		lblIconTwo.setIcon(imgicon.getImageResponsive());
		//panelSecond.add(lblIconTwo);

		// ******  THIRD ******
		JPanel panelThird = new JPanel();
		panelThird.setLayout(null);
		if (positionUser == 3){
			flag=false;
			panelThird.setBackground(new Color(159, 247, 129));
		}
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

		JLabel lblIconThree = new JLabel(" ");
		lblIconThree.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconThree.setForeground(Color.WHITE);
		lblIconThree.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblIconThree.setBounds(78, 6, 64, 66);
		panelThird.add(lblIconThree);
		
		path="res/3.png";
		pathIcon = getClass().getResource(path).getFile();
		imgicon = new MyImageIcon(pathIcon,50,40);
		lblIconThree.setIcon(imgicon.getImageResponsive());
		//panelThird.add(lblIconThree);
		
		// ******  GENERAL ******
	
		if (flag){
		panelGeneral.setVisible(true);
		panelGeneral.setBackground(new Color(159, 247, 129));
		panelGeneral.setLayout(null);
		border = BorderFactory.createLineBorder(new Color(2, 94, 137), 1);
		panelGeneral.setBorder(border);
		panelGeneral.setBounds(91, 406, 645, 78);
		add(panelGeneral);

		JLabel lblGeneral = new JLabel("16");
		lblGeneral.setForeground(Color.WHITE);
		lblGeneral.setHorizontalAlignment(SwingConstants.CENTER);
		lblGeneral.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblGeneral.setBounds(6, 6, 64, 66);
		panelGeneral.add(lblGeneral);

		JLabel lblIconGeneral = new JLabel(" ");
		lblIconGeneral.setHorizontalAlignment(SwingConstants.CENTER);
		lblIconGeneral.setForeground(Color.WHITE);
		lblIconGeneral.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblIconGeneral.setBounds(79, 6, 64, 66);
		panelGeneral.add(lblIconGeneral);

		path="res/4.png";
		pathIcon = getClass().getResource(path).getFile();
		imgicon = new MyImageIcon(pathIcon,50,40);
		lblIconGeneral.setIcon(imgicon.getImageResponsive());
		
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
		lblScore.setBounds(289, 6, 64, 27);
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
		lblVoter.setBounds(383, 6, 95, 27);
		panelInfo.add(lblVoter);

		JLabel lblUser = new JLabel("Username");
		lblUser.setHorizontalAlignment(SwingConstants.CENTER);
		lblUser.setForeground(Color.WHITE);
		lblUser.setFont(new Font("Lucida Grande", Font.PLAIN, 18));
		lblUser.setBounds(160, 6, 95, 27);
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
