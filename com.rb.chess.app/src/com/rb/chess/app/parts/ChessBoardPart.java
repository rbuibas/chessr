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
	
	private static final String[] COL_LETTER = {"A", "B", "C", "D", "E", "F", "G", "H"};
	private ChessRoom chessRoom;
	private Label[][] squares;
	
	public ChessBoardPart() {
		chessRoom = new ChessRoom();
		// +1 is for numbers and letters
		squares = new Label[Board.LENGTH + 1][Board.LENGTH + 1];
	}

	@PostConstruct
	public void createComposite(Composite parent) {
		// only the widget here
		// create the labels here
		
		// but first set the layout 
		// GridLayout lets you organize your widget as a matrix
		
		// +1 is for numbers and letters		
		parent.setLayout(new GridLayout(Board.LENGTH + 1, false));
		
		// arrange a little bit the data represented
		// the gridData object will center horizontally and vertically
		// it's a good practice to center 
		GridData squareGridData = new GridData(SWT.FILL, SWT.CENTER, false, false);
		// another grid data for tags (letters and numbers on the side of the board)
		GridData tagGridData = new GridData(SWT.CENTER, SWT.CENTER, false, false);
		for (int r = 0; r < Board.LENGTH; r++) {
			// add the numbers to the board
			squares[r][0] = new Label(parent, SWT.NONE);
			squares[r][0].setLayoutData(tagGridData);
			squares[r][0].setText(Integer.toString(r + 1));
			for (int c = 0; c < Board.LENGTH; c++) {
				squares[r][c] = new Label(parent, SWT.BORDER);
				// center it a little bit
				squares[r][c].setLayoutData(squareGridData);
				// with set data we can link any object to the widget
				// in this case we link our Square object
				squares[r][c].setData(chessRoom.getBoard().getSquare(r, c));
				squares[r][c].setText(squares[r][c].getData().toString() + "XXXXX");
			}
		}
		squares[Board.LENGTH][0] = new Label(parent, SWT.NONE);
		squares[Board.LENGTH][0].setLayoutData(tagGridData);
		for (int i = 0; i < Board.LENGTH; i++) {
			squares[Board.LENGTH][i + 1] = new Label(parent, SWT.NONE);
			squares[Board.LENGTH][i + 1].setLayoutData(tagGridData);
//			squares[Board.LENGTH][i + 1].setText(Character.toString((char) ('A' + i)));
			squares[Board.LENGTH][i + 1].setText(COL_LETTER[i]);
		}
	}

	@Focus
	public void setFocus() {
		
	}
}