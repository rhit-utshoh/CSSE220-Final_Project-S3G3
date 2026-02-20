package model;

import java.awt.Color;
import java.awt.image.BufferedImage;

public class EndTile extends Tile {
	private static BufferedImage sprite;
	
	public EndTile(int gridX, int gridY) {
		super(gridX, gridY, Color.red);
		sprite = super.loadSprite("/checkered.png");
		this.solid = false;
	}
	
	@Override
	protected BufferedImage getSprite() {
		return sprite;
	}
}
