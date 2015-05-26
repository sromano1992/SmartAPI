package com.smartAPI.model;

public class UserClassification {
	
	private String username;
	private String somma_media;
	private String votanti_codepattern;
	private String utenti_votanti;
	private String avatar;
	
	public UserClassification(String username, String somma_media,
			String votanti_codepattern, String utenti_votanti, String avatar) {
		this.username = username;
		this.somma_media = somma_media;
		this.votanti_codepattern = votanti_codepattern;
		this.utenti_votanti = utenti_votanti;
		this.avatar = avatar;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getSomma_media() {
		return somma_media;
	}

	public void setSomma_media(String somma_media) {
		this.somma_media = somma_media;
	}

	public String getVotanti_codepattern() {
		return votanti_codepattern;
	}

	public void setVotanti_codepattern(String votanti_codepattern) {
		this.votanti_codepattern = votanti_codepattern;
	}

	public String getUtenti_votanti() {
		return utenti_votanti;
	}

	public void setUtenti_votanti(String utenti_votanti) {
		this.utenti_votanti = utenti_votanti;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public String toString(){
		String str="username: "+username+"\tsomma_media: "+somma_media+
				"\t votanti_codepattern: "+votanti_codepattern+"\t utenti_votanti: "+utenti_votanti+
				"\tavatar: "+avatar;
		return str;
	}
	

}
