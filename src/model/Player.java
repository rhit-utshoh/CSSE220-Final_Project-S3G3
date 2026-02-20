package model;
import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Rectangle;

import brain.CognitiveBrain; 
public class Player extends GameObj{
    private int x;
    private int y;

    private final CognitiveBrain brain;

    public Player(int x, int y, CognitiveBrain brain) {
        this.x = x;
        this.y = y;
        this.brain = brain;
    }

    public boolean canMove() {
        return brain.allowMovement();
    }

    public void update() {
        int s = GameConfig.PLAYER_SIZE;

        // clamp to window bounds
        int maxX = GameConfig.WIDTH;
        int maxY = GameConfig.HEIGHT;
        
        if (x-s/2 < 0) x = s/2;
        if (x+s/2> maxX) x = maxX - s/2;

        if (y-s/2 < 0) y = s/2;
        if (y+s/2 > maxY) y = maxY - s/2;
    }

    public int getX() { 
    	return x; 
    }
    public int getY() { 
    	return y; 
    }
    public void setX(int x) { 
    	this.x = x; 
    }
    public void setY(int y) { 
    	this.y = y; 
    }
    
    public Rectangle getBounds() {
    	int s = GameConfig.PLAYER_SIZE;
    	return new Rectangle(x-s/2, y-s/2, s, s);
    }

    public String getBrainName() {
        return brain.getClass().getSimpleName();
    }
    
    public void drawOn(Graphics2D g2, Color c) {
        int s = GameConfig.PLAYER_SIZE;

        g2.setColor(c);
        g2.fillRect(x-s/2, y-s/2, s, s);
    }
}
