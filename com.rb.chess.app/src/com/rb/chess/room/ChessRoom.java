package com.rb.chess.room;

import com.rb.chess.core.model.Army;
import com.rb.chess.core.model.Board;
import com.rb.chess.core.model.Side;
import com.rb.chess.core.model.piece.Bishop;
import com.rb.chess.core.model.piece.BlackPawn;
import com.rb.chess.core.model.piece.King;
import com.rb.chess.core.model.piece.Knight;
import com.rb.chess.core.model.piece.Queen;
import com.rb.chess.core.model.piece.Rook;
import com.rb.chess.core.model.piece.WhitePawn;

public class ChessRoom {
	private final Board board;
	
	public ChessRoom() {
		// here we create the board, but we need armies first
		Army blackArmy = new Army();
		Army whiteArmy = new Army();
		
		this.board = new Board(whiteArmy, blackArmy);
		
		// Add pawns
		for (int i = 0; i < 8; i++) {
			whiteArmy.addPiece(new WhitePawn(board.getSquare(1, i)));
			blackArmy.addPiece(new BlackPawn(board.getSquare(6, i)));
		}
		// Add rest of the pieces to white army
		whiteArmy.addPiece(new Rook(board.getSquare(0, 0), Side.WHITE));
		whiteArmy.addPiece(new Rook(board.getSquare(0, 7), Side.WHITE));
		whiteArmy.addPiece(new Knight(board.getSquare(0, 1), Side.WHITE));
		whiteArmy.addPiece(new Knight(board.getSquare(0, 6), Side.WHITE));
		whiteArmy.addPiece(new Bishop(board.getSquare(0, 2), Side.WHITE));
		whiteArmy.addPiece(new Bishop(board.getSquare(0, 5), Side.WHITE));
		whiteArmy.addPiece(new Queen(board.getSquare(0, 3), Side.WHITE));
		whiteArmy.addPiece(new King(board.getSquare(0, 4), Side.WHITE));
		
		// Add rest of the pieces to black army
		blackArmy.addPiece(new Rook(board.getSquare(7, 0), Side.BLACK));
		blackArmy.addPiece(new Rook(board.getSquare(7, 7), Side.BLACK));
		blackArmy.addPiece(new Knight(board.getSquare(7, 1), Side.BLACK));
		blackArmy.addPiece(new Knight(board.getSquare(7, 6), Side.BLACK));
		blackArmy.addPiece(new Bishop(board.getSquare(7, 2), Side.BLACK));
		blackArmy.addPiece(new Bishop(board.getSquare(7, 5), Side.BLACK));
		blackArmy.addPiece(new Queen(board.getSquare(7, 3), Side.BLACK));
		blackArmy.addPiece(new King(board.getSquare(7, 4), Side.BLACK));
		
	}
	
	public Board getBoard() {
		return this.board;
	}
}
