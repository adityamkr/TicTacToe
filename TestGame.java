package com.aurionpro.test;

import java.util.Scanner;

import com.aurionpro.model.Board;
import com.aurionpro.model.GameSymbols;
import com.aurionpro.model.Player;

public class TestGame {

	public static void main(String[] args) {
		
		try
		{
			 Board newBoard = new Board();
			  newBoard.initializeGame();  
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		
	}
}
