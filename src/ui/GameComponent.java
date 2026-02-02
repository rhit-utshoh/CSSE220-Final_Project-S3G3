package ui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JComponent;

import app.Tile;
import model.GameModel;

public class GameComponent extends JComponent {

	
	
	private GameModel model;


	public GameComponent(GameModel model) {
	this.model = model;
	}


	@Override
	protected void paintComponent(Graphics graphics) {
		super.paintComponent(graphics);
		Graphics2D graphics2 = (Graphics2D) graphics;
		Tile tile = new Tile(100, 100, Color.darkGray);
		tile.drawOn(graphics2);

	// Minimal placeholder to test  it’s running
		graphics2.drawString("Final Project Starter: UI is running ✅", 20, 30);
	// TODO: draw based on model state
		
	}
}