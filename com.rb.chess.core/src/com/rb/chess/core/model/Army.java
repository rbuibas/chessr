package com.rb.chess.core.model;

import java.util.ArrayList;
import java.util.List;

import com.rb.chess.core.model.piece.Piece;

public class Army {
	private final List<Piece> livePieces;
	private final List<Piece> deadPieces;
	
	public Army() {
		livePieces = new ArrayList<Piece>();
		deadPieces = new ArrayList<Piece>();
	}
	
	public List<Piece> getLivePieces() {
		return livePieces;
	}

	public List<Piece> getDeadPieces() {
		return deadPieces;
	}
	
	public void addPiece(Piece piece) {
		livePieces.add(piece);
	}
	
	public void buryPiece(Piece piece) {
		// returns a boolean, should use it to be sure we are not 
		// doing something stupid like removing a piece that 
		// does not exist TODO
		livePieces.remove(piece);
		deadPieces.add(piece);
	}
	
	

}
