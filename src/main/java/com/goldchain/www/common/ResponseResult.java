package com.goldchain.www.common;

public class ResponseResult {

	private String code;
	private String message;
	
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public ResponseResult createSuccess() {
		ResponseResult responseResult = new ResponseResult();
		responseResult.code = "0";
		responseResult.message = "";
		
		return responseResult;
	}
	
	public ResponseResult createError() {
		ResponseResult responseResult = new ResponseResult();
		responseResult.code = "1";
		responseResult.message = "error";
		
		return responseResult;
	}
	
	
}
