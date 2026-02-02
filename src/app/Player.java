package app;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Player implements CognitiveBrain{
	private int x, y; 
	private int vx = 2;
	private int vy = 2;  
	
	private static BufferedImage sprite = null;
	private static boolean triedLoad = false; 
	private static boolean flipped = false; 
	
    private final CognitiveBrain brain;

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
        loadSpriteOnce();
        this.brain = brain;
    }
	
	private static void loadSpriteOnce() {
		if (triedLoad) return;
		triedLoad = true;
		
		try {
			sprite = ImageIO.read(Player.class.getResource("catRight.png"));
//			sprite = ImageIO.read(Ball.class.getResource("cat.png"));
		} catch (IOException | IllegalArgumentException ex) 
			{
				sprite = null; 
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
