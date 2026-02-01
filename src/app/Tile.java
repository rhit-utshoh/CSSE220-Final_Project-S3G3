package app;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Tile  extends GameObj{
		private static final int HEIGHT = 50;
		private static final int WIDTH = 50;
		private int y;
		private int x;
		private Color color = new Color(165, 42, 42); 
		private Rectangle newTile; 
		
		public void Tile(int x, int y, Color color){
			this.x = x;
			this.y = y; 
			this.color = color; 
			newTile = new Rectangle(x, y, WIDTH, HEIGHT);
			
		}
		
		public void drawOn(Graphics2D g2){
			g2.setColor(color);
			g2.fill(newTile);
		}
	
}
