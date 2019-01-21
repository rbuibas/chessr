package com.rb.chess.player;

import java.util.List;
import java.util.Random;

import com.rb.chess.core.model.Board;
import com.rb.chess.core.model.ChessMove;
import com.rb.chess.core.model.Side;
import com.rb.chess.core.model.Square;
import com.rb.chess.core.model.piece.Piece;

public class RandomChessPlayer extends ChessPlayer {

	private Random random;

	public RandomChessPlayer(Board board, Side side) {
		super(board, side);
		random = new Random();
	}

	@Override
	public ChessMove decideMove() {
		List<Piece> pieces = board.getArmy(side).getLivePieces();
		int randomPieceIndex;
		Piece randomPiece;
		List<Square> legalMoves;
		do {
			randomPieceIndex = random.nextInt(pieces.size());
			randomPiece = pieces.get(randomPieceIndex);
			legalMoves = randomPiece.computeLegalMoves();
		} while (legalMoves.size() == 0);
		int randomMoveIndex = random.nextInt(legalMoves.size());
		Square targetSquare = legalMoves.get(randomMoveIndex);
		return new ChessMove(randomPiece.getSquare(), targetSquare, targetSquare.getPiece());
	}
	
	@Override
	public String toString() {
		return "RANDOM PLAYER";
	}
}