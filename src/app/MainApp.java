package app;

import javax.swing.SwingUtilities;

import ui.GameWindow;

// lindsey was here

/**
 * Class: MainApp
<<<<<<< HEAD
 * @author 3g3
=======
 * @author s3g3
>>>>>>> utsho_branch
 * <br>Purpose: Top level class for CSSE220 Project containing main method 
 * Entry point for the final project.
 */

public class MainApp {
<<<<<<< HEAD
	
	 
	
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
		new MainApp().run();
		});
		}
	
	public void run() {
		GameWindow.show();
		// Hint: MainApp should not contain game logic or drawing code
		}
}
=======

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new MainApp().run());
    }

    public void run() {
        GameWindow.show();
        // Hint: MainApp should not contain game logic or drawing code.
    }
}
>>>>>>> utsho_branch
