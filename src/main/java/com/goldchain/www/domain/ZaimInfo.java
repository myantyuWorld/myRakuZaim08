package com.goldchain.www.domain;

import java.io.Serializable;

public class ZaimInfo implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 5282486478758304568L;

	private String accessToken;
	
	private String accessTokenSecret;

	public String getAccessToken() {
		return accessToken;
	}

	public void setAccessToken(String accessToken) {
		this.accessToken = accessToken;
	}

	public String getAccessTokenSecret() {
		return accessTokenSecret;
	}

	public void setAccessTokenSecret(String accessTokenSecret) {
		this.accessTokenSecret = accessTokenSecret;
	}
	
	
	
}
