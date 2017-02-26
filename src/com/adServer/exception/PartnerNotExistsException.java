package com.adServer.exception;

public class PartnerNotExistsException extends Exception {
	
	static final String defaultMessage = "Partner Id does not exists";
	
	public PartnerNotExistsException(){
		super(defaultMessage);
	}
	public PartnerNotExistsException(String message){
		super(message);
	}
}
