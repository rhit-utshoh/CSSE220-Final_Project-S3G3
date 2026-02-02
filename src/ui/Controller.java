package ui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComponent;
import javax.swing.SwingUtilities;

import app.Menu;


public class Controller extends JComponent{
	private GameComponent drawing; 
	private Menu menu; 
	public Controller() {
		setLayout(new BorderLayout());
		menu = new Menu(); 
		add(menu, BorderLayout.SOUTH);
		add(drawing, BorderLayout.CENTER);
		
		SwingUtilities.invokeLater(() -> drawing.requestFocusInWindow()); 
		
		ButtonListener bl = new ButtonListener();

//		not for the menu but will be helpful when moving player if we want that to be on the bottom menu 
//		menu.getHealthPoints().addActionListener(bl);
//		menu.getHealthPoints().addActionListener(bl);
//		menu.getResetButton().addActionListener(bl);
		menu.healthPoints().addImage();
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
