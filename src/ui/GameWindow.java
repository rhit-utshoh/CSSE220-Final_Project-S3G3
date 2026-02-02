package ui;

import model.GameModel;

import javax.swing.*;

public class GameWindow {

    public static void show() {
        GameModel model = new GameModel();
        
        JFrame frame = new JFrame("CSSE220 Final Project - Milestone 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setConten\tPane(new GameComponent(model));
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
