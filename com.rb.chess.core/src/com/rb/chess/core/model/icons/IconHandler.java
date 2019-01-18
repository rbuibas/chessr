package com.rb.chess.core.model.icons;

import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;

import com.rb.chess.core.model.Side;

public class IconHandler {
	// no need to instantiate
	private static Path path;
	
	// put in the static block otherwise no can use try/catch
	static {
		URL location = IconHandler.class.getProtectionDomain().getCodeSource().getLocation();
		try {
			path = Paths.get(location.toURI()).resolve("../com.rb.chess.core/icons/chess_icons");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Image getPieceIcon(String pieceName, Side side) {
		String imageName = pieceName + "-" + ((side == Side.WHITE) ? "white" : "black") + "-50.png";
		return new Image(Display.getDefault(), path.resolve(imageName).toString());
	};
	
	public static Image getBlankIcon() {
		String imageName = "blank-50.png";
		return new Image(Display.getDefault(), path.resolve(imageName).toString());
	};
}
