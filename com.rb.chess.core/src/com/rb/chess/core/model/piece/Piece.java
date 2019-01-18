package com.rb.chess.core.model.piece;

import java.util.ArrayList;
import java.util.List;

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
	protected Square square;
	protected final Side side;
	
	public abstract List<Square> computeLegalMoves();
	
	// Added square because each piece has initial position
	// Constructor is protected since only the child classes can call it
	protected Piece(Square square, Side side, int score) {
		this.square = square;
		this.square.setPiece(this);
		this.score = score;
		this.side = side;
	}

	public void setSquare(Square square) {
		this.square = square;
	}

	public Square getSquare() {
		return this.square;
	}
	
	protected void checkSquare(List<Square> legalMoves, Square square) {
		if (square != null && square.getPiece() == null || square.getPiece().side != this.side) {
			legalMoves.add(square);
		}
	}
	
	/**
	 * 
	 * @param h general horizontal direction
	 * @param v general vertical direction
	 * @return
	 */
	protected List<Square> computeLinearMoves(int h, int v) {
		List<Square> legalMoves = new ArrayList<Square>();
		Square targetSquare;
		targetSquare = square.getAdjescentSquare(h, v);
		while (targetSquare != null) {
			if (targetSquare.getPiece() == null) {
				legalMoves.add(targetSquare);
			} else if (targetSquare.getPiece().side == this.side) {
				break; // no more moves beyond that square
			} else {
				legalMoves.add(targetSquare);
				break; // no more moves beyond that square
			}
			// like this one below, it's elegant
			targetSquare = targetSquare.getAdjescentSquare(h, v);
		}
		return legalMoves;
	}
}
