package model;

import java.awt.image.BufferedImage;

public class Tile extends GameObj {	
	
	private final TileType type;
	
	public Tile(int gridX, int gridY, TileType type) {
		super(
				gridX, gridY, GameConfig.TILE_SIZE, 
				type.getBackupColor(), 
				type.isSolid()
		);
		
		this.type = type;
	}
	
	public BufferedImage getSprite() {
		return type.getSprite();
	}
	
	public TileType getType() {
		return type;
	}
}