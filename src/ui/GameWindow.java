package ui;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import model.StartPanel;

public class GameWindow {
	private JFrame frame;
	private JPanel cards;
	
	public GameWindow() {        
        frame = new JFrame("CSSE220 Final Project - Milestone 3");
        cards = new JPanel(new CardLayout());
        
        StartPanel startPanel = new StartPanel();
        GameComponent gc = new GameComponent(this);
        
        cards.add(startPanel, "START");
        cards.add(gc, "GAME");
        
        frame.setContentPane(cards);
        CardLayout c1 = (CardLayout) cards.getLayout();
        c1.show(cards, "START");
        
        startPanel.getStartButton().addActionListener(e -> {
        	gc.startGame();
    		SwingUtilities.invokeLater(() -> gc.requestFocusInWindow());
        	c1.show(cards, "GAME");
        });
	}
	
	public void show() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
	
	public void winGame(float score) {
		
	}
	
	public void loseGame() {
		
	}
}
