package com.aurionpro.exceptions;

public class GridDimensionsException extends RuntimeException {

     String message;
	 public GridDimensionsException(String message)
	 {
		 this.message = message;
	 }
	 
	 public String getMessage()
	 {
		 return message;
	 }
}
