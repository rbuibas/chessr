package com.rb.chess.core.model.piece;

import java.util.ArrayList;
import java.util.List;

import com.rb.chess.core.model.Side;
import com.rb.chess.core.model.Square;
import com.rb.chess.core.model.icons.IconHandler;

public class Queen extends Piece {

	public Queen(Square square, Side side) {
		super(square, side, 9, IconHandler.getPieceIcon("queen", side));
	}
	
	/*
	 * (non-Javadoc)
	 * Helpful for debugging and generally representing the piece
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return side == Side.WHITE ? "Q" : "q";
	}

	@Override
	public List<Square> computeLegalMoves() {
		List<Square> legalMoves = new ArrayList<Square>();
		// like the Rook
		legalMoves.addAll(computeLinearMoves(0,1));
		legalMoves.addAll(computeLinearMoves(1,0));
		legalMoves.addAll(computeLinearMoves(0,-1));
		legalMoves.addAll(computeLinearMoves(-1,0));
		// like the Bishop
		legalMoves.addAll(computeLinearMoves(-1,1));
		legalMoves.addAll(computeLinearMoves(1,1));
		legalMoves.addAll(computeLinearMoves(1,-1));
		legalMoves.addAll(computeLinearMoves(-1,-1));

		// or simpler 
		for (int h = -1; h <= 1; h++) {
			for (int c = -1; c <= 1; c++) {
				// legalMoves.addAll(computeLinearMoves(h,c));
			}
		}
		return legalMoves;
	}
}
