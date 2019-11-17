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
		private List<RecipeCategory> small = null;
		
		@JsonProperty("medium")
		private List<RecipeCategory> medium= null;
		
		@JsonProperty("large")
		private List<RecipeCategory> large= null;
		
		@JsonIgnore
		private Map<String, Object> additionalProperties = new HashMap<String, Object>();

		@JsonProperty("small")
		public List<RecipeCategory> getSmall() {
			return small;
		}
		@JsonProperty("small")
		public void setSmall(List<RecipeCategory> small) {
			this.small = small;
		}
		@JsonProperty("medium")
		public List<RecipeCategory> getMedium() {
			return medium;
		}
		@JsonProperty("medium")
		public void setMedium(List<RecipeCategory> medium) {
			this.medium = medium;
		}
		@JsonProperty("large")
		public List<RecipeCategory> getLarge() {
			return large;
		}
		@JsonProperty("large")
		public void setLarge(List<RecipeCategory> large) {
			this.large = large;
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
