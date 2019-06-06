package com.goldchain.www.bean;

import java.sql.Date;
import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
"id",
"mode",
"user_id",
"date",
"category_id",
"genre_id",
"to_account_id",
"from_account_id",
"amount",
"comment",
"active",
"name",
"receipt_id",
"place",
"created",
"currency_code"
})
public class ZaimBean {

@JsonProperty("id")
private String id;
@JsonProperty("mode")
private String mode;
@JsonProperty("user_id")
private Integer userId;
@JsonProperty("date")
private Date date;
@JsonProperty("category_id")
private Integer categoryId;
@JsonProperty("genre_id")
private Integer genreId;
@JsonProperty("to_account_id")
private Integer toAccountId;
@JsonProperty("from_account_id")
private Integer fromAccountId;
@JsonProperty("amount")
private Integer amount;
@JsonProperty("comment")
private String comment;
@JsonProperty("active")
private Integer active;
@JsonProperty("name")
private String name;
@JsonProperty("receipt_id")
private Integer receiptId;
@JsonProperty("place")
private String place;
@JsonProperty("created")
private String created;
@JsonProperty("currency_code")
private String currencyCode;
@JsonIgnore
private Map<String, Object> additionalProperties = new HashMap<String, Object>();

@JsonProperty("id")
public String getId() {
return id;
}

@JsonProperty("id")
public void setId(String id) {
this.id = id;
}

@JsonProperty("mode")
public String getMode() {
return mode;
}

@JsonProperty("mode")
public void setMode(String mode) {
this.mode = mode;
}

@JsonProperty("user_id")
public Integer getUserId() {
return userId;
}

@JsonProperty("user_id")
public void setUserId(Integer userId) {
this.userId = userId;
}

@JsonProperty("date")
public Date getDate() {
return date;
}

@JsonProperty("date")
public void setDate(Date date) {
this.date = date;
}

@JsonProperty("category_id")
public Integer getCategoryId() {
return categoryId;
}

@JsonProperty("category_id")
public void setCategoryId(Integer categoryId) {
this.categoryId = categoryId;
}

@JsonProperty("genre_id")
public Integer getGenreId() {
return genreId;
}

@JsonProperty("genre_id")
public void setGenreId(Integer genreId) {
this.genreId = genreId;
}

@JsonProperty("to_account_id")
public Integer getToAccountId() {
return toAccountId;
}

@JsonProperty("to_account_id")
public void setToAccountId(Integer toAccountId) {
this.toAccountId = toAccountId;
}

@JsonProperty("from_account_id")
public Integer getFromAccountId() {
return fromAccountId;
}

@JsonProperty("from_account_id")
public void setFromAccountId(Integer fromAccountId) {
this.fromAccountId = fromAccountId;
}

@JsonProperty("amount")
public Integer getAmount() {
return amount;
}

@JsonProperty("amount")
public void setAmount(Integer amount) {
this.amount = amount;
}

@JsonProperty("comment")
public String getComment() {
return comment;
}

@JsonProperty("comment")
public void setComment(String comment) {
this.comment = comment;
}

@JsonProperty("active")
public Integer getActive() {
return active;
}

@JsonProperty("active")
public void setActive(Integer active) {
this.active = active;
}

@JsonProperty("name")
public String getName() {
return name;
}

@JsonProperty("name")
public void setName(String name) {
this.name = name;
}

@JsonProperty("receipt_id")
public Integer getReceiptId() {
return receiptId;
}

@JsonProperty("receipt_id")
public void setReceiptId(Integer receiptId) {
this.receiptId = receiptId;
}

@JsonProperty("place")
public String getPlace() {
return place;
}

@JsonProperty("place")
public void setPlace(String place) {
this.place = place;
}

@JsonProperty("created")
public String getCreated() {
return created;
}

@JsonProperty("created")
public void setCreated(String created) {
this.created = created;
}

@JsonProperty("currency_code")
public String getCurrencyCode() {
return currencyCode;
}

@JsonProperty("currency_code")
public void setCurrencyCode(String currencyCode) {
this.currencyCode = currencyCode;
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