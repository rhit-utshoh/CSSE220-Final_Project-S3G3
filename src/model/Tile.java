package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Tile  extends GameObj{

	 	private int gridX;
	    private int gridY;
		private Rectangle grassTile, brickTile; 
		private static BufferedImage grassSprite;
		private static BufferedImage stoneSprite;
		private static boolean triedLoad = false;
		private int type; 
		
		
		public Tile(int gridX, int gridY, int type){
			this.gridX = gridX;
			this.gridY = gridY; 
			this.type = type; 
			loadSpriteOnce();
		}
		
		
		private static void loadSpriteOnce() {
			if (triedLoad) return;
			triedLoad = true;
			
			try {
				grassSprite = ImageIO.read(Tile.class.getResource("/grass.jpg"));
				stoneSprite = ImageIO.read(Tile.class.getResource("/stoneTile.jpg"));
			} catch (IOException | IllegalArgumentException ex) {
				grassSprite = null; 
				stoneSprite = null; 
			}
		}

		public void drawOn(Graphics2D g2, int tileW, int tileH){
			int x = gridX * tileW;
			int y = gridY * tileH;
			BufferedImage sprite = (type == 0 ? grassSprite : stoneSprite);

			Shape origionalClip = g2.getClip();
			Shape rectangle = new Rectangle2D.Double(x, y, tileW, tileH);
			g2.setClip(rectangle);
			
			if(sprite != null) {
				g2.drawImage(sprite, x, y, tileW, tileH, null);
			}
			else {
				g2.setColor(Color.green);
				g2.fill(grassTile);

				g2.setColor(Color.DARK_GRAY);
				g2.fill(brickTile);
		}
	}
	
}