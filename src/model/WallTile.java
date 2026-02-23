package model;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class WallTile extends Tile{
	private static BufferedImage sprite;
	private static boolean triedLoad;
	
	
	public WallTile(int gridX, int gridY) {
		super(
				gridX, 
				gridY, 
				Color.DARK_GRAY,
				loadSpriteOnce()
		);
		this.solid = true;
	}
	
	private static BufferedImage loadSpriteOnce() {
		if (!triedLoad) {
			sprite = loadSprite("/stoneTile.jpg");
			triedLoad = true;
		}
		return sprite;
	}

}
