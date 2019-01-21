package com.rb.chess.core.model.icons;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.imageio.ImageIO;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Platform;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Display;
import org.osgi.framework.Bundle;

import com.rb.chess.core.model.Side;

public class IconHandler {
	// no need to instantiate
	private static Path path;
	
	// put in the static block otherwise no can use try/catch
//	static {
//		URL location = IconHandler.class.getProtectionDomain().getCodeSource().getLocation();
//		try {
//			path = Paths.get(location.toURI()).resolve("icons/chess_icons");
////			path = Paths.get(location.toURI()).resolve("../" + Platform.getBundle("com.rb.chess.core").toString() + "/icons/chess_icons");
//			System.out.println(Platform.getBundle("com.rb.chess.core").toString());
//		} catch (URISyntaxException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
//	public static Image getPieceIcon(String pieceName, Side side) {
//		URL location = IconHandler.class.getProtectionDomain().getCodeSource().getLocation();
//		try {
//			path = Paths.get(location.toURI()).resolve("icons/chess_icons");
//		} catch (URISyntaxException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		String imageName = pieceName + "-" + ((side == Side.WHITE) ? "white" : "black") + "-50.png";
//		return new Image(Display.getDefault(), path.resolve(imageName).toString());
//	};
	
	public static Image getPieceIcon(String pieceName, Side side) {
		String imageName = pieceName + "-" + ((side == Side.WHITE) ? "white" : "black") + "-50.png";
		InputStream in = IconHandler.class.getClassLoader().getResourceAsStream("icons/chess_icons/" + imageName);
		return new Image(Display.getDefault(), in);
	};
	
	public static Image getBlankIcon() {
		return new Image(Display.getDefault(), IconHandler.class.getClassLoader().getResourceAsStream("icons/chess_icons/blank-50.png"));
	}
}
