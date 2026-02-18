package model;

import java.awt.BasicStroke;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import model.Tile;

// i want this to be the screen that is the background so all other things will be in game component pasted on top of this. 
public class DrawingComponent extends JPanel{
	

	public static final int SIZE = 500;
	private Tile grassTile, stoneTile;
	
	public DrawingComponent() {
		setBackground(new Color(72, 150,56));
		setOpaque(true);
		setPreferredSize(new Dimension(SIZE, SIZE)); 
		grassTile = new Tile(0, 0, 0); 
        stoneTile = new Tile(1, 0, 1); 

	}
	
	//just to keep track of the level we are on 
	
	
	@Override
	protected void paintComponent(Graphics g) {
		  super.paintComponent(g);
		  Graphics2D g2 = (Graphics2D) g;
		  int cols = 5, rows = 5;
		  int tileW = getWidth() / cols;
		  int tileH = getHeight() / rows;
		 

//		  if(row == 5 )
		  //checkerboard 
		  
//		  for (int y = 0; y < rows; y++) {
//		         for (int x = 0; x < cols; x++) {
//		             // choose grass/stone, etc. based on map logic
//		             (someTile).drawOn(g2, tileW, tileH, x, y); // depends on your Tile API
//		         }
//		     }

	      grassTile.drawOn(g2, tileW, tileH);
	      stoneTile.drawOn(g2, tileW, tileH);

	}
}
