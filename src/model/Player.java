package model;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import brain.CognitiveBrain;


public class Player {
	private int x, y; 
	private int vx = 2;
	private int vy = 2;  
	private CognitiveBrain brain;
	
	private static BufferedImage sprite = null;
	private int dx = 2;
	private int dy = 2;  
	private static BufferedImage sprite1 = null;
	private static BufferedImage sprite2 = null;

	private static boolean triedLoad = false; 
	private static boolean flipped = false; 
	

	public void move() {
		  x += vx;
		  y += vy;
		}
	public void flip() {
		  vx = -vx;
		  flipped = true; 
	}	

    public Player(int x, int y, CognitiveBrain brain) {
        this.x = x;
        this.y = y;
        loadSprite1Once();
        loadSprite2Once();
        this.brain = brain;
    }
	

	private static void loadSprite1Once() {
		if (triedLoad) return;
		triedLoad = true;
		
		try {
			sprite1 = ImageIO.read(Player.class.getResource("catRight.png"));
//			sprite = ImageIO.read(Ball.class.getResource("cat.png"));
		} catch (IOException | IllegalArgumentException ex) 
			{
				sprite1 = null; 
			}
		}
	private static void loadSprite2Once() {
		if (triedLoad) return;
		triedLoad = true;
		
		try {
			sprite2 = ImageIO.read(Player.class.getResource("catLeft.png"));
//			sprite = ImageIO.read(Ball.class.getResource("cat.png"));
		} catch (IOException | IllegalArgumentException ex) 
			{
				sprite2 = null; 
			}
		}

    public boolean canMoveThisTick() {
        return brain.allowMovement();
    }

    public void setVelocity(int vx, int vy) {
        this.vx = vx;
        this.vy = vy;
    }

    public void update() {
        x += vx;
        y += vy;

        // clamp to window bounds
        int maxX = GameConfig.WIDTH - GameConfig.PLAYER_SIZE;
        int maxY = GameConfig.HEIGHT - GameConfig.PLAYER_SIZE;

        if (x < 0) x = 0;
        if (y < 0) y = 0;
        if (x > maxX) x = maxX;
        if (y > maxY) y = maxY;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public String getBrainName() {
        return brain.getClass().getSimpleName();
    }
}
