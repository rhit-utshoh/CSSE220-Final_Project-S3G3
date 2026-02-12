package model;
import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
	

	public class StartPanel extends JPanel {
		
		private JLabel title ; 
		private JButton StartButton; 
		
		public StartPanel(){
			setLayout(new BorderLayout());
			setBackground(Color.pink); 
			
			title = new JLabel("StartTheGame:)"); 
			StartButton = new JButton("PLAY"); 
			
			add(title, BorderLayout.CENTER); 
			add(StartButton, BorderLayout.SOUTH);
			StartButton.setSize(70, 25);
			StartButton.setBackground(Color.green); 
			
//			StartButton.set(Color.RED); 
			
			//when i did css i could make it so when i hover over the start button it could(HOVER EFFECT ON JBUTTON)
			//hovering event 
			//come forward in the page i want to figure out how to do that 
			//i could also add padding around boxes to make them have a boarder and i also want to make the text box have curved edges
			
		}

		public JButton getStartButton() {
	        return StartButton;
	        
	    }
		public JLabel getTitle() {
	        return title;

	}



}
