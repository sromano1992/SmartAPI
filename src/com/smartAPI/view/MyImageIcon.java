package com.smartAPI.view;
import java.awt.Image;

import javax.swing.ImageIcon;


public class MyImageIcon extends ImageIcon{
	
	private Image image;
	private Image newimg;
	private ImageIcon imageIcon;
	
	public MyImageIcon(String path){
		imageIcon = new ImageIcon(path);
		image = imageIcon.getImage();
		newimg = image.getScaledInstance(80, 75,  java.awt.Image.SCALE_SMOOTH); 
		imageIcon = new ImageIcon(newimg);
	}
	
	public ImageIcon getImageResponsive(){
		return imageIcon;
	}

}

