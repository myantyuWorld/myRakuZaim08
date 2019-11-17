package com.goldchain.www.bean;

import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "categoryName", "parentCategoryId", "categoryId", "categoryUrl" })
public  class RecipeCategory {

	@JsonProperty("categoryName")
	private String categoryName;
	@JsonProperty("parentCategoryId")
	private Integer parentCategoryId;
	@JsonProperty("categoryId")
	private Integer categoryId;
	@JsonProperty("categoryUrl")
	private String categoryUrl;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();
	@JsonIgnore
	private Integer cgsb;

	@JsonProperty("categoryName")
	public String getCategoryName() {
		return categoryName;
	}

	@JsonProperty("categoryName")
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@JsonProperty("parentCategoryId")
	public Integer getParentCategoryId() {
		return parentCategoryId;
	}

	@JsonProperty("parentCategoryId")
	public void setParentCategoryId(Integer parentCategoryId) {
		this.parentCategoryId = parentCategoryId;
	}

	@JsonProperty("categoryId")
	public Integer getCategoryId() {
		return categoryId;
	}

	@JsonProperty("categoryId")
	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	@JsonProperty("categoryUrl")
	public String getCategoryUrl() {
		return categoryUrl;
	}

	@JsonProperty("categoryUrl")
	public void setCategoryUrl(String categoryUrl) {
		this.categoryUrl = categoryUrl;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	public Integer getCgsb() {
		return cgsb;
	}

	public void setCgsb(Integer cgsb) {
		this.cgsb = cgsb;
	}
	
	

}