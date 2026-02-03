package ui;

import model.GameConfig;
import model.GameModel;
import model.Player;
import model.Tile;

import javax.swing.*;
import java.awt.*;

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

    private boolean up, down, left, right;

    public GameComponent(GameModel model) {
        this.model = model;

        setPreferredSize(new Dimension(GameConfig.WIDTH, GameConfig.HEIGHT));
        setFocusable(true);

        setupKeyBindings();

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

    private void setupKeyBindings() {
        bind("pressed W", () -> up = true);
        bind("released W", () -> up = false);

        bind("pressed S", () -> down = true);
        bind("released S", () -> down = false);

        bind("pressed A", () -> left = true);
        bind("released A", () -> left = false);

        bind("pressed D", () -> right = true);
        bind("released D", () -> right = false);

        bind("pressed P", model::togglePause);
    }

    private void bind(String keyStroke, Runnable action) {
        InputMap im = getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW);
        ActionMap am = getActionMap();

        im.put(KeyStroke.getKeyStroke(keyStroke), keyStroke);
        am.put(keyStroke, new AbstractAction() {
            @Override
            public void actionPerformed(java.awt.event.ActionEvent e) {
                action.run();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics graphics) {
        Graphics2D g = (Graphics2D) graphics;
        super.paintComponent(g);

		setBackground(new Color(72, 150,56));
		setOpaque(true);

		Tile tile = new Tile(100, 100, Color.darkGray);
		tile.drawOn(g);

		// Minimal placeholder to test  it’s running
		g.drawString("Final Project Starter: UI is running ✅", 20, 30);
		// TODO: draw based on model state
        
        //background
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, getWidth(), getHeight());

        //draw players
        int s = GameConfig.PLAYER_SIZE;

        //Player 1 (Neurotypical) - Blue
        g.setColor(Color.BLUE);
        g.fillRect(model.getP1().getX(), model.getP1().getY(), s, s);

        //Player 2 (ADHD) - Red
        g.setColor(Color.RED);
        g.fillRect(model.getP2().getX(), model.getP2().getY(), s, s);

        //HUD
        g.setColor(Color.BLACK);
        g.drawString("State: " + model.getState() + "   (P = Pause)", 10, 20);
        g.drawString("WASD = move both players together", 10, 40);
        g.drawString("P1 Brain: " + model.getP1().getBrainName(), 10, 60);
        g.drawString("P2 Brain: " + model.getP2().getBrainName() + " (may ignore input sometimes)", 10, 80);
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
	
}

