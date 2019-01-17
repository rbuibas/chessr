package com.rb.chess.core.model;

public class Board {
	public static final int LENGTH = 8;
	
	private Square[][] squares;

	public Board() {
		squares = new Square[LENGTH][LENGTH];
		
		for (int r = 0; r < LENGTH; r++) {
			for (int c = 0; c < LENGTH; c++) {
				squares[r][c] = new Square(this, r, c);
			}
		}
	}
	
	public Square getSquare(int row, int col) {
		return squares[row][col];
	}
}
