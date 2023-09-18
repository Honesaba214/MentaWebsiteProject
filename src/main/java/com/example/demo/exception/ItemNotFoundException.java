package com.example.demo.exception;

public class ItemNotFoundException extends Exception{

	public final String errorCode;
	
	public ItemNotFoundException(String message) {
		super(message);
		this.errorCode = "404";
	}
	
	public String geterrorCode() {
		return errorCode;
	}
	
}
