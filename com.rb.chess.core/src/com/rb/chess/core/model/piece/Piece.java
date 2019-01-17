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
	protected final Side side;
	
	// Added square because each piece has initial position
	// Constructor is protected since only the child classes can call it
	protected Piece(Square square, Side side, int score) {
		this.square = square;
		this.square.setPiece(this);
		this.score = score;
		this.side = side;
	}
}
