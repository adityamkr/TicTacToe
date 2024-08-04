package com.aurionpro.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.aurionpro.exceptions.DuplicateMarkerException;
import com.aurionpro.exceptions.GridDimensionsException;
import com.aurionpro.exceptions.InValidMarkerException;
import com.aurionpro.exceptions.MatchDrawException;

public class Player implements IPlay {
	
	String name;
	GameSymbols gameSymbol;
	Board board;
	int drawCount = 0;
	boolean isWinner = false;
    GameSymbols duplicateMarkFlag = GameSymbols.$;
    Scanner scanner = new Scanner(System.in);
	static CheckExceptions checkExceptions = new CheckExceptions();

	public Player() {}
	
	public Player(Board board, String name, GameSymbols gameSymbol) {
		this.board = board;
		this.name = name;
		this.gameSymbol = gameSymbol;
		
	}
	@Override
	public void play(GameSymbols[][] board) {
		// TODO Auto-generated method stub
		System.out.println("Its " + this.playerName() +"'s" +" Turn");
		System.out.println("Where do you want to Mark " + this.gameSymbol + " ?");
		System.out.println("Enter the location in terms of rowNo");
		int rowNo = scanner.nextInt();
		System.out.println("Enter the location in terms of colNo");
		int colNo = scanner.nextInt();
		checkExceptions.checkGridDimension(rowNo, colNo, board);
		if(gridBlockAlreadyOccupied(board, rowNo, colNo)){
			play(board);
			return;}
		board[rowNo][colNo] = gameSymbol;
		System.out.println("Current Grid After Adding Player1 Mark " + gameSymbol + " is ");
		this.board.displayBoardRows(false);
		boolean winResult = this.board.checkWinner(this, rowNo, colNo);
		drawCount += 1;
		checkExceptions.checkIfMatchIsDrawn(winResult,board,drawCount);
	}
	
	

	public void createPlayers(Board board) {
		GameSymbols symbol = GameSymbols.$;
		List<Player> players = new ArrayList<Player>();
		for (int i = 1; i <= 2; i++) {
			 String[] playerInfo = getPlayerInfo(i);
			String name = playerInfo[0];
			String marker = playerInfo[1];
			checkExceptions.checkInvalidMarker(marker);
			if (marker.equalsIgnoreCase("X") && checkExceptions.checkDuplicateMarker(marker,GameSymbols.X,duplicateMarkFlag)) {
				symbol = GameSymbols.X;
				duplicateMarkFlag= GameSymbols.X;
			}
			if (marker.equalsIgnoreCase("O") && checkExceptions.checkDuplicateMarker(marker,GameSymbols.O,duplicateMarkFlag)) {
				symbol = GameSymbols.O;
				duplicateMarkFlag = GameSymbols.O;
			}
			Player player = new Player(board, name, symbol);
			players.add(player);
		}
		Player player1 = players.get(0);
		Player player2 = players.get(1);
		GameResultValidator.validateGameState(player1, player2, board, drawCount);
	}


	@Override
	public String playerName() {
		// TODO Auto-generated method stub
		return this.name;
	}

   @Override
	public GameSymbols playerMark() {
		// TODO Auto-generated method stub
		return this.gameSymbol;
	}

	@Override
	public boolean setWinner(boolean value) {
		// TODO Auto-generated method stub
		return this.isWinner = value;
	}
	
	public boolean gridBlockAlreadyOccupied(GameSymbols[][] board,int rowNo,int colNo)
	{
		if (board[rowNo][colNo] != GameSymbols.$) {
			System.out.println("Row No " + rowNo + " and " + colNo + " is Occupied Pls enter different block on grid");
			return true;
		}
		return false;
	}
	
	public String[] getPlayerInfo(int i)
	{
		System.out.println("Enter Player " + i + " Name");
		String name = scanner.nextLine();
		System.out.println("Choose X or O as Your Marker");
		String marker = scanner.nextLine();
		return new String[] {name,marker};
	}
}
