package ui;
import model.EndPanel;
import model.StartPanel;

//instead of game model can we take in drawing component 
import java.awt.CardLayout;

import javax.swing.*;

public class GameWindow {
	private JFrame frame;
	
	public GameWindow() {        
        frame = new JFrame("CSSE220 Final Project - Milestone 1");
        JPanel cards = new JPanel(new CardLayout());
        
        StartPanel startPanel = new StartPanel();
        GameComponent gc = new GameComponent();
        
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
}
