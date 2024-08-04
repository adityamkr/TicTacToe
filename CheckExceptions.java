package com.aurionpro.model;

import com.aurionpro.exceptions.DuplicateMarkerException;
import com.aurionpro.exceptions.GridDimensionsException;
import com.aurionpro.exceptions.InValidMarkerException;
import com.aurionpro.exceptions.MatchDrawException;

public class CheckExceptions {

	
	public boolean checkDuplicateMarker(String marker,GameSymbols userSymbol,GameSymbols duplicateMarkFlag)
	{
		if(duplicateMarkFlag!= userSymbol)
			return true;
			throw new DuplicateMarkerException("ERROR :Duplicate Marker Found '"+marker+"' is Already Taken by another player");
	}
	
	public void checkGridDimension(int rowNo,int colNo,GameSymbols[][] board)
	{
		if(rowNo>=board.length || colNo>= board.length)
			   throw new GridDimensionsException("ERROR :  Row No and Col No Should be under the range of the Total Grid Size");
	}
	public void checkInvalidMarker(String marker)
	{
		if (!marker.equalsIgnoreCase("X") && !marker.equalsIgnoreCase("O"))
			throw new InValidMarkerException("ERROR : InValid Marker Selection : Pls Select Marker Only Among X and O");
	}
	public void checkIfMatchIsDrawn(boolean winResult,GameSymbols[][] board,int drawCount)
	{
		if (!winResult && drawCount == board.length * board[0].length) 
			throw new MatchDrawException("Game Draw ... Better Luck Next Time !!");
	}
}
