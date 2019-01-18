package com.rb.chess.app.listeners;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Label;

import com.rb.chess.app.parts.ChessBoardPart;
import com.rb.chess.app.parts.PartRefresher;
import com.rb.chess.core.model.Board;
import com.rb.chess.core.model.ChessMove;
import com.rb.chess.core.model.Side;
import com.rb.chess.core.model.Square;
import com.rb.chess.core.model.piece.Piece;
import com.rb.chess.player.ChessPlayer;

public class ChessMoveListener implements MouseListener {
	private final Label label;
	private static Piece selectedPiece;
	private static boolean doubleClicked;
	
	// static, because we have 64 listeners and we need them to
	// know the same player
	private static ChessPlayer whitePlayer, blackPlayer;
	
	public ChessMoveListener(Label label) {
		this.label = label;
		whitePlayer = ChessBoardPart.getChessRoom().getPlayer(Side.WHITE);
		blackPlayer = ChessBoardPart.getChessRoom().getPlayer(Side.BLACK);
	}

	@Override
	public void mouseDoubleClick(MouseEvent e) {
		// reset first
		resetLegalMoves();
		
		Piece piece = ((Square) label.getData()).getPiece();
		if (piece != null && piece.getSide() == Side.WHITE) {
			for (Square square : piece.computeLegalMoves()) {
				square.setLegal(true);
			}
			selectedPiece = piece;
			doubleClicked = true;
		}
	}

	@Override
	public void mouseDown(MouseEvent e) {
		if (doubleClicked) {
			Square targetSquare = (Square) label.getData();
			if (targetSquare.isLegal()) {
				Square initialSquare = selectedPiece.getSquare();
				Piece targetPiece = targetSquare.getPiece(); // could be null
				ChessMove move = new ChessMove(initialSquare, targetSquare, targetPiece);
				whitePlayer.makeMove(move);
				
				doubleClicked = false;
				resetLegalMoves();
			}
		}
	}

	@Override
	public void mouseUp(MouseEvent e) {
		PartRefresher.refresh();
	}
	
	private void resetLegalMoves() {
		for (int r = 0; r < Board.LENGTH; r++) {
			for (int c = 0; c < Board.LENGTH; c++) {
				ChessBoardPart.getChessRoom().getBoard().getSquare(r, c).setLegal(false);
			}
		}
	}
}
