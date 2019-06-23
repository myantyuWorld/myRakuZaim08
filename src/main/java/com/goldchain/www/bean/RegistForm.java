package com.goldchain.www.bean;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.apache.ibatis.javassist.expr.NewArray;

public class RegistForm {

	@NotNull
	private Integer money;
	
	@NotNull
	private String date;
	
	private Integer category;
	
	private String biko;
	
	private Integer kubn;

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public String getDate() {
		return new SimpleDateFormat("yyyyMMdd").format(this.date);
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getCategory() {
		return category;
	}

	public void setCategory(Integer category) {
		this.category = category;
	}

	public String getBiko() {
		return biko;
	}

	public void setBiko(String biko) {
		this.biko = biko;
	}

	public Integer getKubn() {
		return kubn;
	}

	public void setKubn(Integer kubn) {
		this.kubn = kubn;
	}
	
}
