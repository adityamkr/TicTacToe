package com.aurionpro.exceptions;

public class MatchDrawException extends RuntimeException {

	String message;
	
	  public MatchDrawException(String message)
	  {
		  this.message = message;
	  }
	  
	  public String getMessage() {
		  return this.message;
	  }
}
