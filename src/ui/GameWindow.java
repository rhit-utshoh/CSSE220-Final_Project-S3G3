package ui;
<<<<<<< HEAD

=======
//instead of game model can we take in drawing component 
>>>>>>> branch 'm3_lindsey' of https://github.com/rhit-utshoh/CSSE220-Final_Project-S3G3.git
import model.GameModel;
import model.StartFrame;

import javax.swing.*;

import javax.swing.*;

public class GameWindow {

    public static void show() {
        GameModel model = new GameModel();
        
<<<<<<< HEAD
        JFrame frame = new JFrame("CSSE220 Final Project - Milestone 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setContentPane(new GameComponent(model));
=======
//        JFrame frame = new JFrame("CSSE220 Final Project - Milestone 1");
        JFrame frame = new StartFrame();
//        JFrame frame = new JFrame("CSSE220 Final Project - Milestone 1");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setContentPane(frame);
//        frame.setContentPane(new GameComponent());
>>>>>>> branch 'm3_lindsey' of https://github.com/rhit-utshoh/CSSE220-Final_Project-S3G3.git
        frame.pack();
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
