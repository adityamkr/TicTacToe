package com.aurionpro;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.aurionpro.exceptions.DuplicateMarkerException;
import com.aurionpro.exceptions.GridDimensionsException;
import com.aurionpro.exceptions.InValidMarkerException;
import com.aurionpro.exceptions.MatchDrawException;
import com.aurionpro.model.*;
class Testing {

	static CheckExceptions checkExceptions;
	
	
	GameSymbols[][] board = {
			{GameSymbols.X,GameSymbols.X,GameSymbols.O},
			{GameSymbols.X,GameSymbols.X,GameSymbols.X},
			{GameSymbols.X,GameSymbols.O,GameSymbols.X}
	};
	 IPlay player = new Player(new Board(),"Aditya",GameSymbols.X);
	
	@Test
	@BeforeAll
	static void createObject()
	{
		checkExceptions = new CheckExceptions();
	}
	
    @Test
	public void testcheckGridDimension()
	{
		assertThrows(GridDimensionsException.class,()->checkExceptions.checkGridDimension(3,0, board));
	}
	
	@Test
	public void testCheckInvalidMarker()
	{
		assertThrows(InValidMarkerException.class, ()-> checkExceptions.checkInvalidMarker("z"));
	}
	
	@Test
	public void testcheckDuplicateMarker()
	{
		 assertThrows(DuplicateMarkerException.class,()->checkExceptions.checkDuplicateMarker("X",GameSymbols.X,GameSymbols.X));
	}
	
	@Test
	public void testIfMatchIsDrawn()
	{
		assertThrows(MatchDrawException.class,()-> checkExceptions.checkIfMatchIsDrawn(false, board,9));
	}
	
	@Test
	public void testCheckWinnerByRowsAndByCols()
	{
		assertTrue(GameResultValidator.checkWinnerByRowsAndCols(player,"Col",0, board));
		assertTrue(GameResultValidator.checkWinnerByRowsAndCols(player,"Row",1, board));
	}
	@Test
	public void testDiagonalChecks()
	{
		assertTrue(GameResultValidator.doDiagonalLeftCheck(player, board));
	}
	

}
