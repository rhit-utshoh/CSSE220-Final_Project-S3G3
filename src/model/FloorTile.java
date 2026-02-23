package model;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class FloorTile extends Tile{
	private static BufferedImage sprite;
	private static boolean triedLoad;
	
	
	public FloorTile(int gridX, int gridY) {
		super(
				gridX, 
				gridY, 
				Color.GREEN,
				loadSpriteOnce()
		);
		this.solid = false;
	}
	
	private static BufferedImage loadSpriteOnce() {
		if (!triedLoad) {
			sprite = loadSprite("/grass.jpg");
			triedLoad = true;
		}
		return sprite;
	}

}
