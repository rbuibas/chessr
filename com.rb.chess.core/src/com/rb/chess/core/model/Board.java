package com.rb.chess.core.model;

import com.rb.chess.core.model.piece.Piece;

public class Board {
	public static final int LENGTH = 8;
	
	private Army whiteArmy;
	private Army blackArmy;
	
	private Square[][] squares;

	public Board(Army white, Army black) {
		
		this.whiteArmy = white;
		this.blackArmy = black;
		
		squares = new Square[LENGTH][LENGTH];
		
		for (int r = 0; r < LENGTH; r++) {
			for (int c = 0; c < LENGTH; c++) {
				squares[r][c] = new Square(this, r, c);
			}
		}
	}
	
	public Square getSquare(int row, int col) {
		if (row < 0 || row > LENGTH -1 || col < 0 || col > LENGTH -1) 
			return null; // otherwise we get OutOfBoundsException
		return squares[row][col];
	}
	
	public Army getArmy(Side side) {
		return side == Side.BLACK ? blackArmy : whiteArmy ;
	}

	public void display() {
		for (int r = Board.LENGTH - 1; r >= 0 ; r--) {
			for (int c = 0; c < Board.LENGTH; c++) {
				if (squares[r][c].getPiece() != null) {
					System.out.print(squares[r][c].getPiece().toString());
				} else {
					System.out.print(".");
				}
			}
			System.out.println();
		}
	}
	
	// doing it here since here we have the armies
	public int computeRating(Side side) {
		int whiteScore = 0;
		int blackScore = 0;
		
		for (Piece p : whiteArmy.getLivePieces()) {
			whiteScore += p.getScore();
		}
		
		for (Piece p : blackArmy.getLivePieces()) {
			blackScore += p.getScore();
		}
		return side == Side.BLACK ? blackScore - whiteScore : whiteScore - blackScore;
	}
}
