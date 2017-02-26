package com.adServer.exception;

public class AdExpiredException extends Exception {
	static final String defaultMessage = "No active ad campaigns exist for the specified partner";
	
	public AdExpiredException(){
		super(defaultMessage);
	}
	public AdExpiredException(String message){
		super(message);
	}
}
