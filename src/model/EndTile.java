package model;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class EndTile extends Tile{
	private static BufferedImage sprite;
	private static boolean triedLoad;
	
	
	public EndTile(int gridX, int gridY) {
		super(
				gridX, 
				gridY, 
				Color.WHITE,
				loadSpriteOnce());
		this.solid = false;
	}
	
	private static BufferedImage loadSpriteOnce() {
		if (!triedLoad) {
			sprite = loadSprite("/checkered.png");
			triedLoad = true;
		}
		return sprite;
	}

}
