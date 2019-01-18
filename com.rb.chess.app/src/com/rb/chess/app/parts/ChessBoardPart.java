package com.rb.chess.app.parts;

import javax.annotation.PostConstruct;
import org.eclipse.e4.ui.di.Focus;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import com.rb.chess.core.model.Board;
import com.rb.chess.core.model.Square;
import com.rb.chess.room.ChessRoom;

public class ChessBoardPart {
	
	private ChessRoom chessRoom;
	private Label[][] squares;
	
	public ChessBoardPart() {
		chessRoom = new ChessRoom();
		squares = new Label[Board.LENGTH][Board.LENGTH];
	}

	@PostConstruct
	public void createComposite(Composite parent) {
		// only the widget here
		// create the labels here
		
		// but first set the layout 
		// GridLayout lets you organize your widget as a matrix
		
		parent.setLayout(new GridLayout(Board.LENGTH, true));
		
		// arrange a little bit the data represented
		// the gridData object will center horizontally and vertically
		// it's a good practice to center 
		GridData gridData = new GridData(SWT.CENTER, SWT.CENTER, false, false);
		for (int r = 0; r < Board.LENGTH; r++) {
			for (int c = 0; c < Board.LENGTH; c++) {
				squares[r][c] = new Label(parent, SWT.BORDER);
				// center it a little bit
				squares[r][c].setLayoutData(gridData);
				// with set data we can link any object to the widget
				// in this case we link our Square object
				squares[r][c].setData(chessRoom.getBoard().getSquare(r, c));
				squares[r][c].setText(squares[r][c].getData().toString());
			}
		}
	}

	@Focus
	public void setFocus() {
		
	}
}