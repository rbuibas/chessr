package com.rb.chess.core.model.piece;

import java.util.ArrayList;
import java.util.List;

import com.rb.chess.core.model.Side;
import com.rb.chess.core.model.Square;
import com.rb.chess.core.model.icons.IconHandler;

public class King extends Piece {

	public King(Square square, Side side) {
		super(square, side, 99, IconHandler.getPieceIcon("king", side));
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

	/**
	 * This method does not cover castling.
	 */
	@Override
	public List<Square> computeLegalMoves() {
		List<Square> legalMoves = new ArrayList<Square>();
		for (int h = -1; h <= 1; h++) {
			for (int v = -1; v <= 1; v++) {
				checkSquare(legalMoves, square.getAdjescentSquare(h, v));
			}
		}
		return legalMoves;
	}
}
