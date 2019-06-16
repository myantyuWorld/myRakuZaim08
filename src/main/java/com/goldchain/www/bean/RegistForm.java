package com.goldchain.www.bean;

import java.util.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class RegistForm {

	private Integer money;
	private Date date;
	private Integer category;
	
	@NotEmpty
	@Pattern(regexp = "^[^ -~｡-ﾟ]*$")
	private String biko;
	private Integer kubn;

	public Integer getMoney() {
		return money;
	}

	public void setMoney(Integer money) {
		this.money = money;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
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
