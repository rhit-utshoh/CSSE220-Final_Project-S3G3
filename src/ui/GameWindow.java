package ui;
//instead of game model can we take in drawing component 
import model.GameModel;
import model.StartFrame;

import javax.swing.*;

public class GameWindow {

    public static void show() {
        GameModel model = new GameModel();
//        
        JFrame frame = new JFrame("CSSE220 Final Project - Milestone 1");
//        JFrame frame = new StartFrame();
//        JFrame frame = new JFrame("CSSE220 Final Project - Milestone 1");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setContentPane(frame);
        frame.setContentPane(new GameComponent());
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
