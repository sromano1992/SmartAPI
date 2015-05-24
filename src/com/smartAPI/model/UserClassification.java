package com.smartAPI.model;

public class UserClassification {
	
	private String username;
	private double score;
	private String avatar;
	
	public UserClassification(String username, double score, String avatar){
		this.username=username;
		this.score=score;
		this.avatar=avatar;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public String toString(){
		String str="username: "+username+"\t score: "+score+"\n";
		return str;
	}

}
