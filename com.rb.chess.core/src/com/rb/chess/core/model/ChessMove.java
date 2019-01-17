package com.rb.chess.core.model;

import com.rb.chess.core.model.piece.Piece;

public class ChessMove {
	private Square initialSquare;
	private Square targetSquare;
	/**
	 * Defining the target piece but not the moving piece.
	 * Target piece is very important for the alpha-pruning algorithm.
	 * We need it for the undo.
	 */
	private Piece targetPiece;
	
	public ChessMove(Square initialSquare, Square targetSquare, Piece targetPiece) {
		super();
		this.initialSquare = initialSquare;
		this.targetSquare = targetSquare;
		this.targetPiece = targetPiece;
	}

	public Square getInitialSquare() {
		return initialSquare;
	}

	public void setInitialSquare(Square initialSquare) {
		this.initialSquare = initialSquare;
	}

	public Square getTargetSquare() {
		return targetSquare;
	}

	public void setTargetSquare(Square targetSquare) {
		this.targetSquare = targetSquare;
	}

	public Piece getTargetPiece() {
		return targetPiece;
	}

	public void setTargetPiece(Piece targetPiece) {
		this.targetPiece = targetPiece;
	}
	
	
}
