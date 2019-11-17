package com.goldchain.www.bean;

import org.springframework.beans.factory.annotation.Value;

/***
 * 
 * @author yuichi_develop
 *
 */
public class RakutenProperty {

	@Value("${rakuten.applicationId}")
	private String rakutenApplicationId;
	@Value("${rakuten.applicationSecret}")
	private String rakutenApplicationSecret;
	@Value("${rakuten.affiliateId}")
	private String rakutenAffiliateId;
	
	public String getRakutenApplicationId() {
		return rakutenApplicationId;
	}
	public void setRakutenApplicationId(String rakutenApplicationId) {
		this.rakutenApplicationId = rakutenApplicationId;
	}
	public String getRakutenApplicationSecret() {
		return rakutenApplicationSecret;
	}
	public void setRakutenApplicationSecret(String rakutenApplicationSecret) {
		this.rakutenApplicationSecret = rakutenApplicationSecret;
	}
	public String getRakutenAffiliateId() {
		return rakutenAffiliateId;
	}
	public void setRakutenAffiliateId(String rakutenAffiliateId) {
		this.rakutenAffiliateId = rakutenAffiliateId;
	}
}
