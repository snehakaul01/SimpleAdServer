package com.adServer.exception;

public class PartnerAlreadyExistsException extends Exception {
	
	static final String defaultMessage = "Partner Id Already exists";
	
	public PartnerAlreadyExistsException(){
		super(defaultMessage);
	}
	public PartnerAlreadyExistsException(String message){
		super(message);
	}
}
