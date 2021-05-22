package com.goldchain.www.domain.pojo;

import java.io.Serializable;

import javax.validation.constraints.NotBlank;

public class Users implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -8922772392655881053L;

	@NotBlank
	private String id;
	
	@NotBlank
	private String password;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	
}
