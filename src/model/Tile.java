package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public abstract class Tile{
	 	private int x, y;
	    private int size = GameConfig.TILE_SIZE;

	    protected boolean solid;
	    private Color backupColor;
	    	    
		private Rectangle tileRect;
		protected BufferedImage sprite;
		
		public Tile(int gridX, int gridY, Color bc, BufferedImage sprite){
			this.x = gridX * size;
			this.y = gridY * size; 
			this.sprite = sprite;
			this.backupColor = bc;

			this.tileRect = new Rectangle(x, y, size, size);
		}
		
	    
		protected static BufferedImage loadSprite(String imagePath) {
			try {
				return ImageIO.read(Tile.class.getResource(imagePath));
			} catch (IOException | IllegalArgumentException ex) {
				return null; 
			}
		}
		
		public Rectangle getBounds() {
			return tileRect;
		}
		
		public int getX() {
			return x;
		}
		
		public boolean isSolid() {
			return this.solid;
		}
		
		public void drawOn(Graphics2D g2) {
			if(sprite != null) {
				g2.drawImage(sprite, x, y, size, size, null);
			}
			else {
				g2.setColor(this.backupColor);
				g2.fill(tileRect);
			}
	}
	
}
