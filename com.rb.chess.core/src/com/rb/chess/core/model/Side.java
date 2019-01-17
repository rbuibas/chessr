package com.rb.chess.core.model;

public enum Side {
	WHITE,
	BLACK;
	
	public Side opposite() {
		return this == BLACK ? WHITE : BLACK;
	}
}
