package com.goldchain.www.bean;

import org.springframework.beans.factory.annotation.Value;

/**
 * OAuth認証に必要な情報をプロパティファイルより取得し保持
 * 
 * @author yuichi_develop
 */
public class OAuthProperty {

	@Value("${zaim.consumerKey}")
	private String consumerKey;
	@Value("${zaim.consumerSecret}")
	private String consumerSecret;

	@Value("${zaim.requestTokenUrl}")
	private String requestTokenUrl;
	
	@Value("${zaim.authorizeUrl}")
	private String authorizeUrl;
	
	@Value("${zaim.accessTokenUrl}")
	private String accesTokenUrl;

	public String getConsumerKey() {
		return consumerKey;
	}

	public void setConsumerKey(String consumerKey) {
		this.consumerKey = consumerKey;
	}

	public String getConsumerSecret() {
		return consumerSecret;
	}

	public void setConsumerSecret(String consumerSecret) {
		this.consumerSecret = consumerSecret;
	}

	public String getRequestTokenUrl() {
		return requestTokenUrl;
	}

	public void setRequestTokenUrl(String requestTokenUrl) {
		this.requestTokenUrl = requestTokenUrl;
	}

	public String getAuthorizeUrl() {
		return authorizeUrl;
	}

	public void setAuthorizeUrl(String authorizeUrl) {
		this.authorizeUrl = authorizeUrl;
	}

	public String getAccesTokenUrl() {
		return accesTokenUrl;
	}

	public void setAccesTokenUrl(String accesTokenUrl) {
		this.accesTokenUrl = accesTokenUrl;
	}
	
	
}
