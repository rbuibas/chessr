package com.rb.chess.player;

import java.util.ArrayList;
import java.util.List;

import com.rb.chess.core.model.Army;
import com.rb.chess.core.model.Board;
import com.rb.chess.core.model.ChessMove;
import com.rb.chess.core.model.Side;
import com.rb.chess.core.model.Square;
import com.rb.chess.core.model.piece.Piece;

public class ChessPlayer {
	protected Board board;
	protected Side side;
	
	public ChessPlayer(Board board, Side side) {
		this.board = board;
		this.side = side;
	}
	
	/**
	 * This method is used for deciding which move to make out of all possible moves.
	 * Random move generator will have a lot of moves to chose from.
	 * The AI will have an algorithm implemented.
	 * 
	 * This method will be overridden in the extending classes (AI memebers).
	 * @param move
	 */
	public ChessMove decideMove() {
		return null;
	}
	
	public void makeMove(ChessMove move) {
		if (move.getTargetPiece() != null) {
			// handle the death of the piece.
			Army opponentArmy = board.getArmy(side.opposite());
			opponentArmy.buryPiece(move.getTargetPiece());
			
		}
		Piece movingPiece = move.getInitialSquare().getPiece();
		movingPiece.setSquare(move.getTargetSquare());
		move.getTargetSquare().setPiece(movingPiece);
		move.getInitialSquare().setPiece(null);
	}
	
	public void undoMove(ChessMove move) {
		Square initialSquare = move.getInitialSquare();
		Square targetSquare = move.getTargetSquare();
		Piece targetPiece = move.getTargetPiece();
		// moving piece is the one on the target square now
		Piece movingPiece = targetSquare.getPiece();
		
		movingPiece.setSquare(initialSquare);
		initialSquare.setPiece(movingPiece);
		targetSquare.setPiece(null);
		if (targetPiece != null) {
			targetPiece.setSquare(targetSquare);
			targetSquare.setPiece(targetPiece);
			Army oponnentArmy = board.getArmy(side.opposite());
			oponnentArmy.revivePiece(targetPiece);
		}
	}
	
	public List<ChessMove> computeAllLegalMoves() {
//		board.getArmy(side).getLivePieces().stream().forEach(p -> p.comuteLegalMoves());
		Army army = board.getArmy(side);
		List<Piece> livePieces = army.getLivePieces();
		List<ChessMove> legalMoves = new ArrayList<ChessMove>();
		
		for (Piece p : livePieces) {
			for (Square s : p.computeLegalMoves()) {
				ChessMove move = new ChessMove(p.getSquare(), s, s.getPiece());
				legalMoves.add(move);
			}
		}
		return legalMoves;		
	}
	
	@Override
	public String toString() {
		return "USER";
	}
}