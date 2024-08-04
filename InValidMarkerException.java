package com.aurionpro.exceptions;

public class InValidMarkerException extends RuntimeException {
	
	String message;
	 public InValidMarkerException(String message)
	 {
		this.message = message;
	 }
	
	 public String getMessage()
	 {
		 return message;
	 }
	 
}
