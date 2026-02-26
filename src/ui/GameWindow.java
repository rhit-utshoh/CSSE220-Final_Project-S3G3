package ui;
import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import model.LosePanel;
import model.StartPanel;
import model.WinPanel;

public class GameWindow {
	private JFrame frame;
	private JPanel cards;
	private CardLayout c1;
	
	public GameWindow() {        
        frame = new JFrame("CSSE220 Final Project - Milestone 3");
        cards = new JPanel(new CardLayout());
        
        StartPanel startPanel = new StartPanel();
        GameComponent gc = new GameComponent(this);
        LosePanel lose = new LosePanel();
        
        cards.add(startPanel, "START");
        cards.add(gc, "GAME");
        cards.add(lose, "LOSE");
        
        frame.setContentPane(cards);
        c1 = (CardLayout) cards.getLayout();
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
        WinPanel win = new WinPanel(score);
        cards.add(win, "WIN");
        c1.show(cards, "WIN");
	}
	
	public void loseGame() {
		c1.show(cards, "LOSE");
	}
}
