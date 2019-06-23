package com.goldchain.www.domain;

import javax.validation.constraints.NotBlank;

public class Memo {

	
	private int mmid;
	
	private int mmsb;
	@NotBlank
	private String mmnm;
	
	public int getMmid() {
		return mmid;
	}
	public void setMmid(int mmid) {
		this.mmid = mmid;
	}
	
	public int getMmsb() {
		return mmsb;
	}
	public void setMmsb(int mmsb) {
		this.mmsb = mmsb;
	}
	public String getMmnm() {
		return mmnm;
	}
	public void setMmnm(String mmnm) {
		this.mmnm = mmnm;
	}
	
	
}
