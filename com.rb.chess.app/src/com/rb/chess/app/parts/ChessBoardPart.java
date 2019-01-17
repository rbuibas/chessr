package com.rb.chess.app.parts;

import javax.annotation.PostConstruct;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import com.rb.chess.core.model.Board;
import com.rb.chess.room.ChessRoom;

public class ChessBoardPart {
	
	private ChessRoom chessRoom;

	@PostConstruct
	public void createComposite(Composite parent) {
		chessRoom = new ChessRoom();
		Board board = chessRoom.getBoard();
		board.display();
	}

	@Focus
	public void setFocus() {
		
	}
}