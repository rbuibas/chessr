package com.rb.chess.app.parts;

public class PartRefresher {

	// it's static because this is a singleton
	private static ChessBoardPart chessBoardPart = null;
	private static GraveyardPart whiteGraveyardPart = null;
	private static GraveyardPart blackGraveyardPart = null;

//	public static ChessBoardPart getChessBoardPartInstance() {
//		if (chessBoardPart == null) {
//			chessBoardPart = new ChessBoardPart();
//		}
//		return chessBoardPart;
//	}

	public static void setWhiteGraveyardPart(GraveyardPart whiteGraveyardPart) {
		PartRefresher.whiteGraveyardPart = whiteGraveyardPart;
	}
	
	public static void setBlackGraveyardPart(GraveyardPart blackGraveyardPart) {
		PartRefresher.blackGraveyardPart = blackGraveyardPart;
	}
	
	public static void setChessBoardPart(ChessBoardPart chessBoardPart) {
		PartRefresher.chessBoardPart = chessBoardPart;
	}

	public static void refresh() {
		// check why is this needed TODO
		if (chessBoardPart == null || whiteGraveyardPart == null || blackGraveyardPart == null) {
			return;
		}
		if (chessBoardPart != null) {
			chessBoardPart.setFocus();
		}
		// should maybe check if it's null or not..
		if (whiteGraveyardPart != null)
			whiteGraveyardPart.setFocus();
		if (blackGraveyardPart != null)
			blackGraveyardPart.setFocus();
	}
}
