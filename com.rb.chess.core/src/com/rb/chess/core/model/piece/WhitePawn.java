package com.rb.chess.core.model.piece;

import com.rb.chess.core.model.Side;
import com.rb.chess.core.model.Square;

public class WhitePawn extends Piece {

	public WhitePawn(Square square) {
		super(square, Side.WHITE, 1);
	}
	
	/*
	 * (non-Javadoc)
	 * Helpful for debugging and generally representing the piece
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "P";
	}
}
