package com.goldchain.www.bean;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "result" })
public class RakutenCategory {

	@JsonProperty("result")
	private Result result;
	@JsonIgnore
	private Map<String, Object> additionalProperties = new HashMap<String, Object>();

	@JsonProperty("result")
	public Result getResult() {
		return result;
	}

	@JsonProperty("result")
	public void setResult(Result result) {
		this.result = result;
	}

	@JsonAnyGetter
	public Map<String, Object> getAdditionalProperties() {
		return this.additionalProperties;
	}

	@JsonAnySetter
	public void setAdditionalProperty(String name, Object value) {
		this.additionalProperties.put(name, value);
	}

	@JsonInclude(JsonInclude.Include.NON_NULL)
	@JsonPropertyOrder({ "small" })
	public static class Result {

		@JsonProperty("small")
		private List<Small> small = null;
		@JsonIgnore
		private Map<String, Object> additionalProperties = new HashMap<String, Object>();

		@JsonProperty("small")
		public List<Small> getSmall() {
			return small;
		}

		@JsonProperty("small")
		public void setSmall(List<Small> small) {
			this.small = small;
		}

		@JsonAnyGetter
		public Map<String, Object> getAdditionalProperties() {
			return this.additionalProperties;
		}

		@JsonAnySetter
		public void setAdditionalProperty(String name, Object value) {
			this.additionalProperties.put(name, value);
		}

		@JsonInclude(JsonInclude.Include.NON_NULL)
		@JsonPropertyOrder({ "categoryName", "parentCategoryId", "categoryId", "categoryUrl" })
		public static class Small {

			@JsonProperty("categoryName")
			private String categoryName;
			@JsonProperty("parentCategoryId")
			private String parentCategoryId;
			@JsonProperty("categoryId")
			private Integer categoryId;
			@JsonProperty("categoryUrl")
			private String categoryUrl;
			@JsonIgnore
			private Map<String, Object> additionalProperties = new HashMap<String, Object>();

			@JsonProperty("categoryName")
			public String getCategoryName() {
				return categoryName;
			}

			@JsonProperty("categoryName")
			public void setCategoryName(String categoryName) {
				this.categoryName = categoryName;
			}

			@JsonProperty("parentCategoryId")
			public String getParentCategoryId() {
				return parentCategoryId;
			}

			@JsonProperty("parentCategoryId")
			public void setParentCategoryId(String parentCategoryId) {
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

		}
	}
}
