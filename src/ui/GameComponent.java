package ui;

import model.*;
import brain.ADHDBrain;
import brain.NeurotypicalBrain;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.swing.*;



public class GameComponent extends JComponent {
	private float timeLeft;
    
    private Timer timer;
    
    private GameState state;
    private int speed;
    
    private Tile endTile;
    private ArrayList<Player> players = new ArrayList<>();
    private ArrayList<Tile> tiles = new ArrayList<>();
    private int currentLevel;

    private boolean left, right, up, down;
    private int vx, vy;
    
    public GameComponent(GameWindow window) {
    	// set initial vales
    	currentLevel = 1;
    	timeLeft = GameConfig.TIME_LIMIT;
    	state = GameState.PLAYING;
    	speed = GameConfig.PLAYER_SPEED;
    	
//    	// set up JComponent
//    	setBackground(Color.WHITE);
//    	setOpaque(true);
//        setPreferredSize(new Dimension(GameConfig.WIDTH, GameConfig.HEIGHT));
        
        loadLevel(this.currentLevel);
        
        // Main timer loop
        timer = new Timer(50, e -> {
        	for (Player p : players) {
        		if (state == GameState.PLAYING && p.canMove(timeLeft)) {

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
        			            p.setX(tileRect.x - p.getSize()/2);
        			        } else if (vx < 0) {
        			        	// hit tile from right
        			            p.setX(tileRect.x + tileRect.width + p.getSize()/2);
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
        			            p.setY(tileRect.y - p.getSize()/2);
        			        } else if (vy < 0) {
        			        	// hit tile from bottom
        			            p.setY(tileRect.y + tileRect.height + p.getSize()/2);
        			        }
        			    }
        			}
        			
        			
        
        		}
        		p.checkWallCollision();
        	}
        
        
        for (int i = 0; i < players.size(); i++) {
        	Rectangle endTileSmall = new Rectangle(endTile.getX(), endTile.getY(), endTile.getSize()/2, endTile.getSize()/2);
        
        	if (players.get(i).getBounds().intersects(endTileSmall))
        		players.remove(i);
//        	 win
//        	timer.stop();
        }
        
        if (timeLeft <= 0) {
        	// lose
        	timer.stop();
        }
        
        if (state == GameState.PLAYING)
        	timeLeft -= 0.05;

        repaint();
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
    
    private void loadLevel(int levelNum) {
		File file = new File(String.format("./level%d.txt", levelNum));
		
		try {
			Scanner scanner = new Scanner(file);
			int row = 0;
			while (scanner.hasNextLine()) {
				int s = GameConfig.TILE_SIZE;
				String line = scanner.nextLine();
				for (int col = 0; col < line.length(); col++) {
					char c = line.charAt(col);
					if (c == 'F') {
				        Tile t = new Tile(col, row, TileType.FLOOR); 
				        tiles.add(t);
					} else if (c == 'W') {
				        Tile t = new Tile(col, row, TileType.WALL); 
				        tiles.add(t);
					} else if (c == 'E') {
						endTile = new Tile(col, row, TileType.END);
						tiles.add(endTile);
					} else if (c == '1') {
						Tile t = new Tile(col, row, TileType.FLOOR);
				        Player p = new Player(col, row, new NeurotypicalBrain(), Color.PINK, "/pinkPlayer.png");
						players.add(p);
						tiles.add(t);
					}  else if (c == '2') {
						Tile t = new Tile(col, row, TileType.FLOOR);
				        Player p = new Player(col, row, new ADHDBrain(), Color.MAGENTA, "/purplePlayer.png");
						players.add(p);
						tiles.add(t);
					}
				}
				
				row++;
			}
			scanner.close();
		} catch (FileNotFoundException e) {
			System.out.printf("level%d.txt not found", levelNum);
		}
	}
    
    @Override
    protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    Graphics2D g2 = (Graphics2D) g;
	    
	    for (Tile t : tiles) {
	    	t.drawOn(g2);
	    }
	    for (Player p : players) {
		    p.drawOn(g2);
	    }
        
       //HUD
	    Font f = new Font("Comic Sans MS", Font.BOLD, 20);
        g2.setFont(f);
        
        g2.setColor(Color.BLACK);
        g2.drawString("State: " + state + "   (P = Pause)", 10, 20);
        g2.drawString("WASD or arrow keys = move both players together", 10, 50);
        g2.drawString(String.format("Time Left: %.2f", timeLeft), 10, 80);
    }
    
    public void startGame() {
    	timer.start();
    }
}
