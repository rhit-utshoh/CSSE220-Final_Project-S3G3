package ui;

import model.GameModel;
import model.GameState;
import model.Player;
import model.Tile;

import javax.swing.*;
import model.GameConfig;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.Timer;

import brain.ADHDBrain;
import brain.NeurotypicalBrain;

public class GameComponent extends JPanel {
	private final Player p1;
    private final Player p2;
    
    private GameState state = GameState.PLAYING;
    private int speed = GameConfig.PLAYER_SPEED;
    
    private ArrayList<Player> players = new ArrayList<>();
    private Tile grassTile, stoneTile;
    
    private boolean left, right, up, down;
    private int vx, vy;
    public GameComponent() {
    	
    	setBackground(Color.WHITE);
    	setOpaque(true);
        setPreferredSize(new Dimension(GameConfig.WIDTH, GameConfig.HEIGHT));
        
        p1 = new Player(140, 200, new NeurotypicalBrain());
        p2 = new Player(260, 200, new ADHDBrain());
        players.add(p1);
        players.add(p2);
        
		grassTile = new Tile(0, 0, 0); 
        stoneTile = new Tile(1, 0, 1); 
        
        Timer timer = new Timer(50, e -> {
        	for (Player p : players) {
        		if (state == GameState.PLAYING) {
        			vx = (right ? speed : 0) - (left ? speed : 0);
                	vy = (down ? speed : 0) - (up ? speed : 0);
        			p.setVelocity(vx, vy);
        		}
        		p.update();
        	}
        	repaint();
        });
        timer.start();
        
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
    	
    @Override
    protected void paintComponent(Graphics g) {
	    super.paintComponent(g);
	    Graphics2D g2 = (Graphics2D) g;
	    
		int tileW = getWidth() / 5;
		int tileH = getHeight() / 5;
		grassTile.drawOn(g2, tileW, tileH);
		stoneTile.drawOn(g2, tileW, tileH);
		
	    p1.drawOn(g2, Color.BLUE);
	    p2.drawOn(g2, Color.RED);
	    
        
        
//       //HUD
//        g2.setColor(Color.BLACK);
//        g2.drawString("State: " + state + "   (P = Pause)", 10, 20);
//        g2.drawString("WASD = move both players together", 10, 40);
//        g2.drawString("P1 Brain: " + p1.getBrainName(), 10, 60);
//        g2.drawString("P2 Brain: " + p2.getBrainName() + " (may ignore input sometimes)", 10, 80);
    }
}
