package com.rb.chess.core.model;

import com.rb.chess.core.model.piece.Piece;

public class Square {
	// final because no intent of changing it exists
	private final Board board;
	
	// need row and column indices
	// also final because when square is created it does not change its position
	private final int row;
	private final int col;
	
	//need a piece object as well
	// not final because the piece can change (e.g. pawn promotion)
	private Piece piece;
	
	public Square(Board board, int row, int col) {
		this.board = board;
		this.row = row;
		this.col = col;
	}
	
	public Board getBoard() {
		return board;
	}

	public int getRow() {
		return row;
	}

	public int getCol() {
		return col;
	}
	
	public void setPiece(Piece piece) {
		this.piece = piece;
	}
	
	public Piece getPiece() {
		return this.piece;
	}
	
	/**
	 * 
	 * @param hOffset offset (add to the column)
	 * @param vOffset offset (add to the row)
	 * @return
	 */
	public Square getAdjescentSquare(int hOffset, int vOffset) {
		return board.getSquare(this.col + hOffset, this.row + vOffset);
	}
	
	@Override
	public String toString() {
		return this.piece != null ? this.piece.toString() : "";
	}
}

