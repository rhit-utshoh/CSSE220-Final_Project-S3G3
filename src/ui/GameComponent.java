package ui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;
import javax.swing.Timer;

import app.Player;
import app.Tile;
import model.GameModel;

public class GameComponent extends JComponent {
	public static final int WIDTH = 500;
	public static final int HEIGHT = 200;
	private int start_x = 250;
	private int x = start_x;
	private int y = 20;
	private int step = 10;
	private Tile tile; 
	private Player catLeft, catRight; 
	private Timer timer;
	
	
	private GameModel model;


	public GameComponent(GameModel model) {
	this.model = model;
	}

	public void moveLeft() {
		  x -= step;
		  repaint();
		}

		public void moveRight() {
		  x += step;
		  repaint();
		}

		public void reset() {
		  x = start_x;
		  repaint();
		}
		
	
		
		

	@Override
	protected void paintComponent(Graphics graphics) {
		setBackground(new Color(72, 150,56));
		setOpaque(true);
		setPreferredSize(new Dimension(WIDTH, HEIGHT));
		//need to make it so these only show based on what direction the cat is going 
		catLeft = new Player(100,120); 
		catRight = new Player(100, 120); 
		super.paintComponent(graphics);
		Graphics2D graphics2 = (Graphics2D) graphics;
		Tile tile = new Tile(100, 100, Color.darkGray);
		tile.drawOn(graphics2);

	// Minimal placeholder to test  it’s running
		graphics2.drawString("Final Project Starter: UI is running ✅", 20, 30);
	// TODO: draw based on model state
		
	}
}