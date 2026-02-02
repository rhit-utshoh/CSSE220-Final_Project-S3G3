package app;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Player implements CognitiveBrain{
	private int x, y; 
	private int dx = 2;
	private int dy = 2;  
	private static BufferedImage sprite1 = null;
	private static BufferedImage sprite2 = null;

	private static boolean triedLoad = false; 
	private static boolean flip = false; 
	
	public Player(int x, int y) {
		this.x = x; 
		this.y = y; 
		loadSprite1Once();
		loadSprite2Once();
	}
	public void move() {
		  x += dx;
		  y += dy;
		}
	public void flip() {
		  dx = -dx;
		  flip = true; 
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

}
