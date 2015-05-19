package com.smartAPI.view;
import java.awt.Image;

import javax.swing.ImageIcon;


public class MyImageIcon extends ImageIcon{
	
	private Image image;
	private Image newimg;
	private ImageIcon imageIcon;
	
	public MyImageIcon(String path, int width, int height){
		imageIcon = new ImageIcon(path);
		image = imageIcon.getImage();
		newimg = image.getScaledInstance(width, height,  java.awt.Image.SCALE_SMOOTH); 
		imageIcon = new ImageIcon(newimg);
	}
	
	public ImageIcon getImageResponsive(){
		return imageIcon;
	}

}

