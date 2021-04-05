package com.goldchain.www.domain;

import javax.validation.constraints.NotBlank;

public class Memo {

	/***
	 * メモID
	 */
	private int mmid;
	/***
	 * メモ種別
	 * 1 ： 日用品
	 * 2 ： 食費
	 */
	private int mmsb;
	/***
	 * メモ内容
	 */
	@NotBlank
	private String mmnm;
	/***
	 * カウント
	 * メモの入力数をカウントする用
	 */
	private int count;
	
	private int deleteFlg;
	
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
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getDeleteFlg() {
		return deleteFlg;
	}
	public void setDeleteFlg(int deleteFlg) {
		this.deleteFlg = deleteFlg;
	}
}
