package com.aurionpro.model;

public interface IPlay {
	  void play(GameSymbols [][] board);
	  GameSymbols playerMark();
	  String playerName();
	  boolean setWinner(boolean value);
}
