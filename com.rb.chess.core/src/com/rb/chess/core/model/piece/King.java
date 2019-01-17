package com.rb.chess.core.model.piece;

import com.rb.chess.core.model.Side;
import com.rb.chess.core.model.Square;

public class King extends Piece {

	public King(Square square, Side side) {
		super(square, side, 99);
	}
	
	/*
	 * (non-Javadoc)
	 * Helpful for debugging and generally representing the piece
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return side == Side.WHITE ? "K" : "k";
	}
}
