package com.rb.chess.core.model;

public class Square {
	// final because no intent of changing it exists
	private final Board board;
	
	// need row and column indices
	// also final because when square is created it does not change its position
	private final int row;
	private final int col;
	
	//need a piece object as well
	// not final because the piece can change (e.g. pawn promotion)
	
	
	public Square(Board board, int row, int col) {
		this.board = board;
		this.row = row;
		this.col = col;
	}

}
