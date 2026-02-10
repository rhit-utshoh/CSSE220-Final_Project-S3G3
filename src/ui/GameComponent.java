package ui;

import model.GameConfig;
import model.GameModel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class GameComponent extends JComponent implements KeyListener {

    private final GameModel model;

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

        // Player 1 (Neurotypical) - Blue box for now
        g.setColor(Color.BLUE);
        g.fillRect(model.getP1().getX(), model.getP1().getY(), s, s);

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

	public void reset() {
		// TODO Auto-generated method stub
		
	}

	public void moveRight() {
		// TODO Auto-generated method stub
		
	}
}
