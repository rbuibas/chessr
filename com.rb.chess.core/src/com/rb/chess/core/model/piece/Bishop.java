package com.rb.chess.core.model.piece;

import java.util.List;

import com.rb.chess.core.model.Side;
import com.rb.chess.core.model.Square;

public class Bishop extends Piece {

	public Bishop(Square square, Side side) {
		super(square, side, 3);
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
		// TODO Auto-generated method stub
		return null;
	}
}
