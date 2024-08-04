package com.aurionpro.model;

public class GameResultValidator {

	public static void validateGameState(Player player1, Player player2,Board board,int drawCount)
	{
		 while(!player1.isWinner && !player2.isWinner && drawCount!=(board.getBoard().length* board.getBoard()[0].length))
		 {
				 player1.play(board.getBoard());
			 if(!player1.isWinner && !player2.isWinner && drawCount!=(board.getBoard().length* board.getBoard()[0].length))
				 player2.play(board.getBoard());
		 }
	}
	
	
	
	public static  boolean doDiagonalLeftCheck(IPlay player,GameSymbols[][] board)
	{
		int count=0;
		for(int i=0;i<board.length;i++)
		{
				if(board[i][i] != player.playerMark())
					break;
				count++;
		}
			if(count != board.length)
				return false;
			
				System.out.println(player.playerName()+" Won the Game Having Mark "+player.playerMark());
				player.setWinner(true);
				return true;
	}
	public static boolean doDiagonalRightCheck(IPlay player,GameSymbols[][] board)
	{
		int count=0;
		for(int i=0;i<board.length;i++)
		{
				if(board[i][board.length-1-i] != player.playerMark())
					break;
				count++;
		}
			if(count != board.length)
				return false;
				System.out.println(player.playerName()+" Won the Game Having Mark "+player.playerMark());
				player.setWinner(true);
				return true;
	}
	
	public static boolean checkWinnerByRowsAndCols(IPlay player,String searchBy,int RowValueOrColvalue,GameSymbols[][] board)
	{
		int count = 0;
		for(int i=0;i<board.length;i++)
		{
			if(searchBy.equalsIgnoreCase("Row"))
			{
				if(board[RowValueOrColvalue][i] != player.playerMark())
					break;
					count++;
					continue;
			}
			if(searchBy.equalsIgnoreCase("Col"))
			{
				if(board[i][RowValueOrColvalue] != player.playerMark())
					break;
				count++;
				continue;
			}
		}
		if(count != board.length)
			return false;
		
			System.out.println(player.playerName()+" Won the Game Having Mark "+player.playerMark());
			player.setWinner(true);
			return true;
	}
	
	
}
