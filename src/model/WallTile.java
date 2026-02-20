package model;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class WallTile extends Tile{
	private static BufferedImage sprite;
	
	public WallTile(int gridX, int gridY) {
		super(gridX, gridY, Color.DARK_GRAY);
		sprite = super.loadSprite("/stoneTile.jpg");
		this.solid = true;
	}
	
	@Override
	protected BufferedImage getSprite() {
		return sprite;
	}

}
