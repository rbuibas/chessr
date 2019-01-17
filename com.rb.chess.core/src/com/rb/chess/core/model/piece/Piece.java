package com.rb.chess.core.model.piece;

import com.rb.chess.core.model.Side;
import com.rb.chess.core.model.Square;

/**
 * Every piece has different characteristics but we need the common part.
 * Hence we make this class abstract 
 * @author Raul Buibas
 *
 */
public abstract class Piece {
	/**
	 *  Common characteristics of a piece are:
	 *  - score (value)
	 *  - square (position)
	 *  - side (color) 
	 */
	private final int score;
	private Square square;
	private final Side side;
	
	// Added square because each piece has initial position
	public Piece(Square square, int score, Side side) {
		this.score = score;
		this.side = side;
	}
}
