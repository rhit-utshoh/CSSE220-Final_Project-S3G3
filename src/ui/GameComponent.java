package ui;

<<<<<<< HEAD
import model.GameConfig;
=======
>>>>>>> branch 'm3_lindsey' of https://github.com/rhit-utshoh/CSSE220-Final_Project-S3G3.git
import model.GameModel;
import model.GameState;
import model.Player;

import javax.swing.*;
<<<<<<< HEAD
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
=======
import model.GameConfig;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
>>>>>>> branch 'm3_lindsey' of https://github.com/rhit-utshoh/CSSE220-Final_Project-S3G3.git

<<<<<<< HEAD
public class GameComponent extends JComponent implements KeyListener {
=======
import javax.swing.JPanel;
import javax.swing.Timer;
>>>>>>> branch 'm3_lindsey' of https://github.com/rhit-utshoh/CSSE220-Final_Project-S3G3.git

<<<<<<< HEAD
    private final GameModel model;
=======
import brain.ADHDBrain;
import brain.NeurotypicalBrain;
>>>>>>> branch 'm3_lindsey' of https://github.com/rhit-utshoh/CSSE220-Final_Project-S3G3.git

<<<<<<< HEAD
    private boolean up;
    private boolean down;
    private boolean left;
    private boolean right;

    public GameComponent(GameModel model) {
        this.model = model;

        setPreferredSize(new Dimension(GameConfig.WIDTH, GameConfig.HEIGHT));
        setFocusable(true);
        addKeyListener(this);

        Timer timer = new Timer(16, e -> {
            model.update(up, down, left, right);
            repaint();
        });
        timer.start();
    }

    @Override
    public void addNotify() {
        super.addNotify();
        requestFocusInWindow();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Background
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        int s = GameConfig.PLAYER_SIZE;
import model.GameState;
import model.Player;

        // Player 1 (Neurotypical) - Blue box for now
        g.setColor(Color.BLUE);
        g.fillRect(model.getP1().getX(), model.getP1().getY(), s, s);
import javax.swing.*;
import model.GameConfig;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

        // Player 2 (ADHD) - Red for now
        g.setColor(Color.RED);
        g.fillRect(model.getP2().getX(), model.getP2().getY(), s, s);

        // HUD
        g.setColor(Color.BLACK);
        g.drawString("State: " + model.getState(), 10, 20);
        g.drawString("WASD = move both players together", 10, 40);
        g.drawString("P1 Brain: " + model.getP1().getBrainName(), 10, 60);
        g.drawString("P2 Brain: " + model.getP2().getBrainName(), 10, 80);
    }
    
    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            up = true;
        } else if (key == KeyEvent.VK_S) {
            down = true;
        } else if (key == KeyEvent.VK_A) {
            left = true;
        } else if (key == KeyEvent.VK_D) {
            right = true;
        } else if (key == KeyEvent.VK_P) {
            model.togglePause();
        }
    }

    public void keyReleased(KeyEvent e) {
        int key = e.getKeyCode();

        if (key == KeyEvent.VK_W) {
            up = false;
        } else if (key == KeyEvent.VK_S) {
            down = false;
        } else if (key == KeyEvent.VK_A) {
            left = false;
        } else if (key == KeyEvent.VK_D) {
            right = false;
        }
    }

    public void keyTyped(KeyEvent e) {
        // Not used
    }

	public void moveLeft() {
		// TODO Auto-generated method stub
		
	}
=======
public class GameComponent extends JPanel {
	private final Player p1;
    private final Player p2;
    
    private GameState state = GameState.PLAYING;
    private int speed = GameConfig.PLAYER_SPEED;
    
    private ArrayList<Player> players = new ArrayList<>();
    
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
        
        Timer timer = new Timer(50, e -> {
        	for (Player p : players) {
        		if (state == GameState.PLAYING)
        			vx = (right ? GameConfig.PLAYER_SPEED : 0) - (left ? GameConfig.PLAYER_SPEED : 0);
                	vy = (down ? GameConfig.PLAYER_SPEED : 0) - (up ? GameConfig.PLAYER_SPEED : 0);
        			p.setVelocity(vx, vy);
        		p.update();
        	}
        	repaint();
        });
        timer.start();
        
        // bind keys
        setFocusable(true);
        addKeyListener(ka);
    }	
>>>>>>> branch 'm3_lindsey' of https://github.com/rhit-utshoh/CSSE220-Final_Project-S3G3.git

<<<<<<< HEAD
	public void reset() {
		// TODO Auto-generated method stub
		
	}
=======
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
    		case KeyEvent.VK_UP:
    			up = false;
    			break;
    		case KeyEvent.VK_DOWN:
    			down = false;
    			break;
    		case KeyEvent.VK_LEFT:
    			left = false;
    			break;
    		case KeyEvent.VK_RIGHT:
    			right = false;
    			break;
    		}
    	}
    };
    	
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        
        //draw players
        int s = GameConfig.PLAYER_SIZE;
>>>>>>> branch 'm3_lindsey' of https://github.com/rhit-utshoh/CSSE220-Final_Project-S3G3.git

<<<<<<< HEAD
	public void moveRight() {
		// TODO Auto-generated method stub
		
	}
=======
        //Player 1 (Neurotypical) - Blue
        g2.setColor(Color.BLUE);
        g2.fillRect(p1.getX()-s/2, p1.getY()-s/2, s, s);

        //Player 2 (ADHD) - Red
        g2.setColor(Color.RED);
        g2.fillRect(p2.getX()-s/2, p2.getY()-s/2, s, s);

        //HUD
        g2.setColor(Color.BLACK);
        g2.drawString("State: " + state + "   (P = Pause)", 10, 20);
        g2.drawString("WASD = move both players together", 10, 40);
        g2.drawString("P1 Brain: " + p1.getBrainName(), 10, 60);
        g2.drawString("P2 Brain: " + p2.getBrainName() + " (may ignore input sometimes)", 10, 80);
    }
>>>>>>> branch 'm3_lindsey' of https://github.com/rhit-utshoh/CSSE220-Final_Project-S3G3.git
}
