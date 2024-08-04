package com.aurionpro.exceptions;

public class DuplicateMarkerException extends RuntimeException{

	String message;
	    public DuplicateMarkerException(String message)
	    {
	    	this.message = message;
	    }
	    
	    public String getMessage()
	    {
	      return message;
	    }
	    
}
