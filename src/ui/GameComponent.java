package ui;

import model.GameObj;
import model.GameState;
import model.Player;
import model.Tile;
import model.WallTile;
import model.EndTile;
import model.FloorTile;
import model.GameConfig;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;

import brain.ADHDBrain;
import brain.NeurotypicalBrain;

public class GameComponent extends JPanel {
	private Player p1;
    private Player p2;
    
    private Timer timer;
    
    private GameState state = GameState.PLAYING;
    private int speed = GameConfig.PLAYER_SPEED;
    
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Tile> tiles = new ArrayList<>();

    private boolean left, right, up, down;
    private int vx, vy;
    
    public GameComponent() {
    	
    	setBackground(Color.WHITE);
    	setOpaque(true);
        setPreferredSize(new Dimension(GameConfig.WIDTH, GameConfig.HEIGHT));
        
    	int s = GameConfig.PLAYER_SIZE;
    	
        loadLevel();
        
        
        timer = new Timer(50, e -> {
        	for (Player p : players) {
        		if (state == GameState.PLAYING && p.canMove()) {

        			vx = (right ? speed : 0) - (left ? speed : 0);
                	vy = (down ? speed : 0) - (up ? speed : 0);
        	    	
        			// need to separate x and y movement
        			
                	// move x first
        			p.setX(p.getX() + vx);
        			for (Tile t : tiles) {
        				Rectangle tileRect = t.getBounds();
        			    if (tileRect.intersects(p.getBounds()) && t.isSolid()) {
        			        if (vx > 0) {
        			        	// hit tile from left
        			            p.setX(tileRect.x - s/2);
        			        } else if (vx < 0) {
        			        	// hit tile from right
        			            p.setX(tileRect.x + tileRect.width + s/2);
        			        }
        			    }
        			}

        			// move y second
        			p.setY(p.getY() + vy);
        			for (Tile t : tiles) {
        				Rectangle tileRect = t.getBounds();
        				if (tileRect.intersects(p.getBounds()) && t.isSolid()) {
        			        if (vy > 0) {
        			            // hit tile from top
        			            p.setY(tileRect.y - s/2);
        			        } else if (vy < 0) {
        			        	// hit tile from bottom
        			            p.setY(tileRect.y + tileRect.height + s/2);
        			        }
        			    }
        			}
        
        		}
        	p.update();
        	repaint();
        	}
        });
        
        // bind keys
        setFocusable(true);
        addKeyListener(ka);
        
    }	

    KeyAdapter ka = new KeyAdapter() {
    	@Override
    	public void keyPressed(KeyEvent e) {
    		switch (e.getKeyCode()) {
    		case KeyEvent.VK_W: case KeyEvent.VK_UP:
    			up = true;
    			break;
    		case KeyEvent.VK_S: case KeyEvent.VK_DOWN:
    			down = true;
    			break;
    		case KeyEvent.VK_A: case KeyEvent.VK_LEFT:
    			left = true;
    			break;
    		case KeyEvent.VK_D: case KeyEvent.VK_RIGHT:
    			right = true;
    			break;
    		case KeyEvent.VK_P:
    			if (state == GameState.PAUSED)
    				state = GameState.PLAYING;
    			else
    				state = GameState.PAUSED;
    			break;
    		}
    	}
    	@Override
    	public void keyReleased(KeyEvent e) {
    		switch (e.getKeyCode()) {
    		case KeyEvent.VK_W: case KeyEvent.VK_UP:
    			up = false;
    			break;
    		case KeyEvent.VK_S: case KeyEvent.VK_DOWN:
    			down = false;
    			break;
    		case KeyEvent.VK_A: case KeyEvent.VK_LEFT:
    			left = false;
    			break;
    		case KeyEvent.VK_D: case KeyEvent.VK_RIGHT:
    			right = false;
    			break;
    		}
    	}
    };
    
    private void loadLevel() {
		File file = new File("./level1.txt");
		
		try {
			Scanner scanner = new Scanner(file);
			int row = 0;
			while (scanner.hasNextLine()) {
				int s = GameConfig.TILE_SIZE;
				String line = scanner.nextLine();
				for (int col = 0; col < line.length(); col++) {
					char c = line.charAt(col);
					if (c == 'F') {
				        Tile t = new FloorTile(col, row); 
				        tiles.add(t);
					} else if (c == 'W') {
				        Tile t = new WallTile(col, row); 
				        tiles.add(t);
					} else if (c == 'E') {
						Tile t = new EndTile(col, row);
						tiles.add(t);
					} else if (c == '1') {
						Tile t = new FloorTile(col, row);
				        p1 = new Player(col*s+s/2, row*s+s/2, new NeurotypicalBrain());
						players.add(p1);
						tiles.add(t);
					}  else if (c == '2') {
						Tile t = new FloorTile(col, row);
				        p2 = new Player(col*s+s/2, row*s+s/2, new NeurotypicalBrain());
						players.add(p2);
						tiles.add(t);
					}
				}
				
				row++;
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.println("level1.txt not found");
		}
	}
    
    @Override
    protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    Graphics2D g2 = (Graphics2D) g;
	    
	    for (Tile t : tiles) {
	    	t.drawOn(g2);
	    }
		
	    p1.drawOn(g2, Color.BLUE);
	    p2.drawOn(g2, Color.RED);
	    
        
//       //HUD
//        g2.setColor(Color.BLACK);
//        g2.drawString("State: " + state + "   (P = Pause)", 10, 20);
//        g2.drawString("WASD = move both players together", 10, 40);
//        g2.drawString("P1 Brain: " + p1.getBrainName(), 10, 60);
//        g2.drawString("P2 Brain: " + p2.getBrainName() + " (may ignore input sometimes)", 10, 80);
    }
    
    public void startGame() {
    	timer.start();
    }
}
