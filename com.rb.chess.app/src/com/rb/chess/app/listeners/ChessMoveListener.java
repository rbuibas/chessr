package com.rb.chess.app.listeners;

import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.swt.widgets.Label;

import com.rb.chess.app.parts.ChessBoardPart;
import com.rb.chess.app.parts.PartRefresher;
import com.rb.chess.core.model.Board;
import com.rb.chess.core.model.Side;
import com.rb.chess.core.model.Square;
import com.rb.chess.core.model.piece.Piece;

public class ChessMoveListener implements MouseListener {
	private final Label label;
	private static Piece selectedPiece;
	private static boolean doubleClicked;
	
	public ChessMoveListener(Label label) {
		this.label = label;
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
