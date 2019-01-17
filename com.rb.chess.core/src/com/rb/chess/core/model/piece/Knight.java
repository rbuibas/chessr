package com.rb.chess.core.model.piece;

import java.util.ArrayList;
import java.util.List;

import com.rb.chess.core.model.Side;
import com.rb.chess.core.model.Square;

public class Knight extends Piece {

	public Knight(Square square, Side side) {
		super(square, side, 3);
	}

	/*
	 * (non-Javadoc) Helpful for debugging and generally representing the piece
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return side == Side.WHITE ? "N" : "n";
	}

	@Override
	public List<Square> computeLegalMoves() {
		// horrible, please refactor
		List<Square> legalMoves = new ArrayList<Square>();
		Square targetSquare;
		targetSquare = square.getAdjescentSquare(1, 2);
		checkSquare(legalMoves, targetSquare);
		targetSquare = square.getAdjescentSquare(-1, 2);
		checkSquare(legalMoves, targetSquare);
		targetSquare = square.getAdjescentSquare(1, -2);
		checkSquare(legalMoves, targetSquare);
		targetSquare = square.getAdjescentSquare(-1, -2);
		checkSquare(legalMoves, targetSquare);
		targetSquare = square.getAdjescentSquare(2, 1);
		checkSquare(legalMoves, targetSquare);
		targetSquare = square.getAdjescentSquare(2, -1);
		checkSquare(legalMoves, targetSquare);
		targetSquare = square.getAdjescentSquare(-2, 1);
		checkSquare(legalMoves, targetSquare);
		targetSquare = square.getAdjescentSquare(-2, -1);
		checkSquare(legalMoves, targetSquare);
		return legalMoves;
	}

	private void checkSquare(List<Square> legalMoves, Square square) {
		if (square != null && square.getPiece() == null || square.getPiece().side != this.side) {
			legalMoves.add(square);
		}
	}
}
