package model;

import java.awt.BasicStroke;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import model.Tile;


public class DrawingComponent extends JPanel{
	

	public static final int SIZE = 500;
	private Tile grassTile, stoneTile;
	
	public DrawingComponent() {
		System.out.println("DrawingComponent.paintComponent called. size=" + getWidth() + "x" + getHeight());
		setBackground(new Color(72, 150,56));
		setOpaque(true);
		setPreferredSize(new Dimension(SIZE, SIZE)); 
		grassTile = new Tile(0, 0, 0); 
        stoneTile = new Tile(1, 0, 1); 

	}
	@Override
	protected void paintComponent(Graphics g) {
		  super.paintComponent(g);
		  Graphics2D g2 = (Graphics2D) g;
		  int tileW = getWidth() / 10;
	      int tileH = getHeight() / 10;
	      grassTile.drawOn(g2, tileW, tileH);
	      stoneTile.drawOn(g2, tileW, tileH);

	}
}
