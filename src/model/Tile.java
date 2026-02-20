package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public abstract class Tile extends GameObj{
	 	private int x;
	    private int y;
	    private int size = GameConfig.TILE_SIZE;

	    protected boolean solid;
	    private Color backupColor;
	    	    
		private Rectangle tileRect; 
		
		public Tile(int gridX, int gridY, Color bc){
			this.x = gridX * size;
			this.y = gridY * size; 
			this.backupColor = bc;

			this.tileRect = new Rectangle(x, y, size, size);
		}
		
	    protected abstract BufferedImage getSprite();

	    
		protected BufferedImage loadSprite(String imagePath) {
			BufferedImage sprite;
			try {
				sprite = ImageIO.read(Tile.class.getResource(imagePath));
			} catch (IOException | IllegalArgumentException ex) {
				sprite = null; 
			}
			return sprite;
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

			Shape originalClip = g2.getClip();
			g2.setClip(tileRect);
			
			BufferedImage sprite = getSprite();
			if(sprite != null) {
				g2.drawImage(sprite, x, y, size, size, null);
			}
			else {
				g2.setColor(this.backupColor);
				g2.fill(tileRect);
			}
			g2.setClip(originalClip);
	}
	
}
