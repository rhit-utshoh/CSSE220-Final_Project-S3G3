package app;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import app.Tile;


public class DrawingComponent extends JPanel{

	public static final int SIZE = 500;
	private Tile grassTile, stoneTile;
	
	public DrawingComponent() {
		
		setBackground(new Color(72, 150,56));
		setOpaque(true);
		setPreferredSize(new Dimension(SIZE, SIZE)); 
		grassTile = new Tile(SIZE / 10, (SIZE / 10)); 
	}
	protected void paintComponent(Graphics g) {
		  super.paintComponent(g);
		  Graphics2D g2 = (Graphics2D) g;
		  grassTile.draw(g2);
	}
}
