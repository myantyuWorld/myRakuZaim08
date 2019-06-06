package com.goldchain.www.bean;

import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"money"
})
public class MoneyBean {
	@JsonProperty("money")
	ArrayList<ZaimBean> zaimBeans;
	
	@JsonProperty("requested")
	private String requested;

	@JsonProperty("money")
	public ArrayList<ZaimBean> getZaimBeans() {
		return zaimBeans;
	}

	@JsonProperty("money")
	public void setZaimBeans(ArrayList<ZaimBean> zaimBeans) {
		this.zaimBeans = zaimBeans;
	}

	@JsonProperty("requested")
	public String getRequested() {
		return requested;
	}

	@JsonProperty("requested")
	public void setRequested(String requested) {
		this.requested = requested;
	}
	
	
}
