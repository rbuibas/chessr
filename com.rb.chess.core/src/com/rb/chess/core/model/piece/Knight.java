package com.rb.chess.core.model.piece;

import java.util.ArrayList;
import java.util.List;

import com.rb.chess.core.model.Side;
import com.rb.chess.core.model.Square;
import com.rb.chess.core.model.icons.IconHandler;

public class Knight extends Piece {

	public Knight(Square square, Side side) {
		super(square, side, 3, IconHandler.getPieceIcon("knight", side));
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
}
