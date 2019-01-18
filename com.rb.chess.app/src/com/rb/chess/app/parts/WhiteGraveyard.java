package com.rb.chess.app.parts;

import com.rb.chess.core.model.Side;

public class WhiteGraveyard extends GraveyardPart {
		
	public WhiteGraveyard() {
		side = Side.WHITE;
		PartRefresher.setWhiteGraveyardPart(this);
	}
}
