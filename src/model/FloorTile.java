package model;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class FloorTile extends Tile{
	private static BufferedImage sprite;
	
	public FloorTile(int gridX, int gridY) {
		super(gridX, gridY, Color.GREEN);
		sprite = super.loadSprite("/grass.jpg");
		this.solid = false;
	}
	
	@Override
	protected BufferedImage getSprite() {
		return sprite;
	}
}