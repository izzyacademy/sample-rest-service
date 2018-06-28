package com.izzyacademy.event.exceptions;

import java.util.ArrayList;
import java.util.List;

public class ErrorModel {

	private int code;
	
	private String message;
	
	private List<ErrorDetail> errors = new ArrayList<ErrorDetail>();
	
	public ErrorModel()
	{
		this.code = 0;
		this.message = "";
	}
	
	public ErrorModel(String message)
	{
		this.code = 0;
		this.message = message;
	}
	
	public ErrorModel(int code, String message)
	{
		this.code = code;
		this.message = message;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<ErrorDetail> getErrors() {
		return errors;
	}

	public void setErrors(List<ErrorDetail> errors) {
		this.errors = errors;
	}
}
