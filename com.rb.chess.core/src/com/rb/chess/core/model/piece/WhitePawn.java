package com.rb.chess.core.model.piece;

import java.util.ArrayList;
import java.util.List;

import com.rb.chess.core.model.Side;
import com.rb.chess.core.model.Square;
import com.rb.chess.core.model.icons.IconHandler;

public class WhitePawn extends Piece {

	public WhitePawn(Square square) {
		super(square, Side.WHITE, 1, IconHandler.getPieceIcon("pawn", Side.WHITE));
	}

	/*
	 * (non-Javadoc) Helpful for debugging and generally representing the piece
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "P";
	}

	/**
	 * The pawn can move: 
	 * - one square forward (considering legality of the square)
	 * - two squares forward on the first move (considering legality of the square)
	 * - one square diagonally, when capturing opponent's piece
	 * 
	 * Warning: Not covering En Passant and Pawn Promotion.
	 */
	@Override
	public List<Square> computeLegalMoves() {
		List<Square> legalMoves = new ArrayList<Square>();
		Square targetSquare = square.getAdjescentSquare(0, 1);
		// 1. one step forward
		if (targetSquare != null && targetSquare.getPiece() == null) {
			// hardly could targetSquare be null if we implement pawn promotion
			legalMoves.add(targetSquare);
			if (square.getRow() == 1) { // initial position
				// 2. two steps forward
				targetSquare = square.getAdjescentSquare(0, 2);
				if (targetSquare != null && targetSquare.getPiece() == null) {
					// remove first check since no chance the board ends after index 1
					legalMoves.add(targetSquare);
				}
			}
		}
		
		// 3. opponent piece capturing
		targetSquare = square.getAdjescentSquare(1, 1); // diagonally to right
		if (targetSquare != null && targetSquare.getPiece() != null && targetSquare.getPiece().side != this.side) {
			legalMoves.add(targetSquare);
		}
		targetSquare = square.getAdjescentSquare(-1, 1); // diagonally to left
		if (targetSquare != null && targetSquare.getPiece() != null && targetSquare.getPiece().side != this.side) {
			legalMoves.add(targetSquare);
		}
		
		return legalMoves;
	}
}
