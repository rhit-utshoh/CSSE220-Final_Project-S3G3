package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;

import model.Menu;

// Controller includes both GameComponent and Menu
public class Controller extends JComponent{
	private GameComponent drawing; 
	private Menu menu; 
	public Controller() {
		setLayout(new BorderLayout());
		menu = new Menu(); 
		add(menu, BorderLayout.NORTH);
		add(drawing, BorderLayout.CENTER);
		
		SwingUtilities.invokeLater(() -> drawing.requestFocusInWindow()); 
		
		ButtonListener bl = new ButtonListener();

	}
	private class ButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			String buttonLabel = e.getActionCommand();
			if (buttonLabel.equals("Left")) {
				drawing.moveLeft();
			} else if (buttonLabel.equals("Right")) {
				drawing.moveRight();
			} else {
				drawing.reset();
			}
			drawing.requestFocusInWindow();
		}
	
	}	
}
