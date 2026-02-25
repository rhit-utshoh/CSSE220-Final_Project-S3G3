package model;
import java.awt.Color;
import java.awt.image.BufferedImage;

import brain.CognitiveBrain; 
public class Player extends GameObj{
    private final CognitiveBrain brain;
    private BufferedImage sprite;
    
    public Player(int gridX, int gridY, CognitiveBrain brain, Color bc, String spritePath) {
    	super(gridX, gridY, GameConfig.PLAYER_SIZE, bc, true);
    	
    	this.brain = brain;
    	this.sprite = GameObj.loadSprite(spritePath);
    }
    
    public BufferedImage getSprite() {
    	return sprite;
    }
    public boolean canMove(float timeLeft) {
        return brain.allowMovement(timeLeft);
    }

    public void checkWallCollision() {
        // clamp to window bounds
        int maxX = GameConfig.WIDTH;
        int maxY = GameConfig.HEIGHT;
        
        if (x-size/2 < 0) x = size/2;
        if (x+size/2> maxX) x = maxX - size/2;

        if (y-size/2 < 0) y = size/2;
        if (y+size/2 > maxY) y = maxY - size/2;
    }

    public String getBrainName() {
        return brain.getClass().getSimpleName();
    }
    
}
