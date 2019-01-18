package com.rb.chess.core.model.piece;

import java.util.ArrayList;
import java.util.List;

import com.rb.chess.core.model.Side;
import com.rb.chess.core.model.Square;
import com.rb.chess.core.model.icons.IconHandler;

public class Bishop extends Piece {

	public Bishop(Square square, Side side) {
		super(square, side, 3, IconHandler.getPieceIcon("bishop", side));
	}
	
	/*
	 * (non-Javadoc)
	 * Helpful for debugging and generally representing the piece
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return side == Side.WHITE ? "B" : "b";
	}

	@Override
	public List<Square> computeLegalMoves() {
		List<Square> legalMoves = new ArrayList<Square>();
		legalMoves.addAll(computeLinearMoves(-1,1));
		legalMoves.addAll(computeLinearMoves(1,1));
		legalMoves.addAll(computeLinearMoves(1,-1));
		legalMoves.addAll(computeLinearMoves(-1,-1));
		return legalMoves;
	}
}
