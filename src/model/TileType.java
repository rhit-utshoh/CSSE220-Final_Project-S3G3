package model;

import java.awt.Color;
import java.awt.image.BufferedImage;

// Using this example of a Level enum from resources:

//public enum Level {
//    L1(new int[][] { {120, 100} }),
//    L2(new int[][] { {60, 80}, {220, 140} }),
//    L3(new int[][] { {40, 40}, {120, 180}, {260, 90} });
//
//    private final int[][] starts;
//    Level(int[][] starts) { this.starts = starts; }
//    public int[][] starts() { return starts; }
//}
  
public enum TileType {
	WALL("/wall.png", true, Color.DARK_GRAY),
	END("/checkered.png", false, Color.WHITE),
	FLOOR("/walkWay.png", false, Color.GREEN);
	
	private String spritePath;
	private boolean solid;
	private Color backupColor;
	
	private BufferedImage sprite;
	private boolean triedLoad;
	
	TileType(String path, boolean solid, Color color) {
		this.spritePath = path;
		this.solid = solid;
		this.backupColor = color;
	}
	
	
	public boolean isSolid() {
		return solid;
	}
	
	public Color getBackupColor() {
		return backupColor;
	}
	
	public BufferedImage getSprite() {
		if (sprite == null && !triedLoad) {
			triedLoad = true;
			sprite = GameObj.loadSprite(spritePath);
		}
		return sprite;
	}
	public String getSpritePath() {
		return spritePath;
	}

	
	
}
