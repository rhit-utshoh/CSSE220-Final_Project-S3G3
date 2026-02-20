package model;
import java.awt.Color;
import java.awt.Graphics2D;

import brain.CognitiveBrain; 
public class Player {

    private int x;
    private int y;

    private int vx;
    private int vy;

    private final CognitiveBrain brain;

    public Player(int x, int y, CognitiveBrain brain) {
        this.x = x;
        this.y = y;
        this.brain = brain;
    }

    public boolean canMove() {
        return brain.allowMovement();
    }

    public void setVelocity(int vx, int vy) {
        this.vx = vx;
        this.vy = vy;
    }

    public void update() {
    	if (!this.canMove()) {
    		vx = 0;
    		vy = 0;
    		return;
    	}
        x += vx;
        y += vy;
        
        int s = GameConfig.PLAYER_SIZE;

        // clamp to window bounds
        int maxX = GameConfig.WIDTH;
        int maxY = GameConfig.HEIGHT;
        
        int player_left_edge = x - s/2;
        int player_right_edge = x + s/2;
        int player_top_edge = y - s/2;
        int player_bottom_edge = y + s/2;
        
        if (player_left_edge < 0) x = s/2;
        if (player_right_edge > maxX) x = maxX - s/2;

        if (player_top_edge < 0) y = s/2;
        if (player_bottom_edge > maxY) y = maxY - s/2;
    }

    public int getX() { 
    	return x; 
    }
    public int getY() { 
    	return y; 
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
