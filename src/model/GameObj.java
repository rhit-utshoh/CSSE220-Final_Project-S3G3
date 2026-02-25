package model;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public abstract class GameObj {
	protected int x, y, size;

    private final boolean solid;
    private final Color backupColor;
	
    public GameObj(int gridX, int gridY, int size, Color bc, boolean solid) {
		// add 0.5 to both gridX and gridY to make x and y the center point of tile, not top left corner
    	this.x = (int) ((gridX + 0.5) * GameConfig.TILE_SIZE);
    	this.y = (int) ((gridY + 0.5) * GameConfig.TILE_SIZE);
    	this.size = size;
    	this.backupColor = bc;
    	this.solid = solid;
    }
        
    public int getX() { 
    	return x; 
    }
    public int getY() { 
    	return y; 
    }
    public boolean isSolid() {
    	return solid;
    }
    public void setX(int x) { 
    	this.x = x; 
    }
    public int getSize() {
    	return size;
    }
    public void setY(int y) { 
    	this.y = y; 
    }
    
    public Rectangle getBounds() {
    	return new Rectangle(x-size/2, y-size/2, size, size);
    }
    
    public abstract BufferedImage getSprite();

   
	protected static BufferedImage loadSprite(String imagePath) {
		try {
			return ImageIO.read(GameObj.class.getResource(imagePath));
		} catch (IOException | IllegalArgumentException ex) {
			System.out.printf("failed to load sprite: %s", imagePath);
			return null;
		}
	}

	public void drawOn(Graphics2D g2) {
		if (this.getSprite() != null) {
			g2.drawImage(this.getSprite(), x-size/2, y-size/2, size, size, null);
			g2.setColor(Color.RED);
		} else {
			g2.setColor(this.backupColor);
			g2.fill(this.getBounds());
		}
	}
	
}
