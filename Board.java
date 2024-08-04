package com.aurionpro.model;

import java.util.Scanner;

import com.aurionpro.exceptions.GridDimensionsException;

public class Board {

GameSymbols[][] board ;
    
	boolean resetFlag=false;
	
	 public Board() {}
	
	 public Board(GameSymbols[][] gameBoard) {
		// TODO Auto-generated constructor stub
		 this.board = gameBoard;
	}

	public  void displayBoardRows(boolean resetFlag)
	  {
		  for(int row=0;row<board.length;row++)
		  {
			  displayBoardCols(row,resetFlag);
		  }
	  }
	  
	 public void displayBoardCols(int rowNo,boolean resetFlag)
	  {
		  for(int col=0;col<board[0].length;col++)
		  {
			  if(resetFlag)
				  board[rowNo][col]=GameSymbols.$;
			   
			    System.out.print(board[rowNo][col]+" ");
		  }
		  System.out.println();
	  }
	 
	 public void  resetBoard()
	 {
		displayBoardRows(true);
	 }
	 
	 public void  initializeGame()
	 {
		 Scanner sc =  new Scanner(System.in);
		 System.out.println("Enter No of Rows");
		 int rows=sc.nextInt();
		 System.out.println("Enter No of Colums");
		 int cols=sc.nextInt();
		 if(rows != cols)
			 throw new GridDimensionsException("ERROR: Improper Board Dimensions Selection. Pls Select the same no of Rows and Columns");
		 GameSymbols[][] gameboard = new GameSymbols[rows][cols];
	     Board brd = new  Board(gameboard);
			brd.resetBoard();
		 new Player().createPlayers(brd);	
	 }
	 public GameSymbols[][] getBoard() {
		return board;
	}

	public void setBoard(GameSymbols[][] board) {
		this.board = board;
	}

	public boolean checkWinner(IPlay player,int rowNo,int colNo)
	 {
		 if(GameResultValidator.checkWinnerByRowsAndCols(player,"Row",rowNo,board)||
			GameResultValidator.checkWinnerByRowsAndCols(player,"Col",colNo,board) ||
			GameResultValidator.doDiagonalLeftCheck(player,board)||
			GameResultValidator.doDiagonalRightCheck(player,board))
			 return true;
		 return false;
	 }
}
