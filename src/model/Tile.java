package app;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.Ellipse2D;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Tile  extends GameObj{
		private static final int HEIGHT = 50;
		private static final int WIDTH = 50;
		private int y;
		private int x;
		private Color color = new Color(165, 42, 42); 
		private Rectangle grassTile, brickTile; 
		private static BufferedImage sprite = null;
		private static boolean triedLoad = false;
		
		public Tile(int x, int y){
			this.x = x;
			this.y = y; 
			grassTile = new Rectangle(x, y, WIDTH, HEIGHT);
			brickTile = new Rectangle(x, y, WIDTH, HEIGHT);
			loadSpriteOnce();
		}
		
		
		private static void loadSpriteOnce() {
			if (triedLoad) return;
			triedLoad = true;
			
			try {
			// tennis.png must be in the SAME package as Ball.java
				sprite = ImageIO.read(Tile.class.getResource("grass.jpg"));
				sprite = ImageIO.read(Tile.class.getResource("stoneTile.png"));
			} catch (IOException | IllegalArgumentException ex) {
					sprite = null; 
			}
		}

		public void drawOn(Graphics2D g2){

			Shape origionalClip = g2.getClip();
			Shape rectangle = new Rectangle.Double(x,y,WIDTH, HEIGHT);
			g2.setClip(rectangle);
			if(sprite != null) {
				g2.drawImage(sprite,x,y,WIDTH, HEIGHT, null);
			}
			
			
		else {
			g2.setColor(color);
			g2.fill(grassTile);
			g2.fill(brickTile);
		}

		}
	
}
