package com.rb.chess.app.parts;

import com.rb.chess.core.model.Side;

public class BlackGraveyard extends GraveyardPart {
	
	public BlackGraveyard() {
		side = Side.BLACK;
		PartRefresher.setBlackGraveyardPart(this);
	}
}
