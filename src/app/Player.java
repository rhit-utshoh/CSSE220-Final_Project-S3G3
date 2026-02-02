package app;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Player implements CognitiveBrain{
	private int x, y; 
	private int dx = 2;
	private int dy = 2;  
	private static BufferedImage sprite = null;
	private static boolean triedLoad = false; 
	private static boolean flip = false; 
	
	public Player() {
		this.x = x; 
		this.y = y; 
		loadSpriteOnce();
	}
	public void move() {
		  x += dx;
		  y += dy;
		}
	public void flip() {
		  dx = -dx;
		  flip = true; 
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

}
