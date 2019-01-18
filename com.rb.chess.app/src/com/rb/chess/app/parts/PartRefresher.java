package com.rb.chess.app.parts;

public class PartRefresher {

	// it's static because this is a singleton
	private static ChessBoardPart chessBoardPart = null;

//	public static ChessBoardPart getChessBoardPartInstance() {
//		if (chessBoardPart == null) {
//			chessBoardPart = new ChessBoardPart();
//		}
//		return chessBoardPart;
//	}

	public static void setChessBoardPart(ChessBoardPart chessBoardPart) {
		PartRefresher.chessBoardPart = chessBoardPart;
	}

	public static void refresh() {
		if (chessBoardPart != null) {
			chessBoardPart.setFocus();
		}
	}
}
