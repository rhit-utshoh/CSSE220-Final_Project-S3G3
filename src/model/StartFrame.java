package model;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JLabel;

import javax.swing.JFrame;

public class StartFrame extends JFrame {
		
		private JLabel title = new JLabel("GAME TITLE"); 
		private JButton startButton = new JButton(); 
		Color bgColor = new Color(255, 240,204); 
		Color  btnColor = new Color(255, 216, 224); 
		Color btnHov = new Color(207, 196, 255); 
		Color btnHovBorder = new Color(152, 169, 255); 



		public  StartFrame() {
			setTitle("GameName"); 
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(900,700);
			 JPanel panel = new JPanel(); 
			 panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			 panel.setBorder(BorderFactory.createEmptyBorder(24, 24, 24, 24));
			 panel.setBackground(new Color(255, 240,204));
			 // maybe i can make a litle translucent panel.setOpaque(true)
			 panel.setPreferredSize(new Dimension(900, 700)); 
			 
			 title.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
			 title.setForeground(new Color(255, 105, 180)); 
			 title.setAlignmentY(TOP_ALIGNMENT);				
			
			startButton = new JButton("PLAY"); 			
			startButton.setBackground(btnColor);

	        startButton.setAlignmentY(CENTER_ALIGNMENT);

			startButton.setSize(70, 25);
			startButton.setText("start");
			 
			 @Override 
			 protected void paintComponent(Graphics g) {
	                super.paintComponent(g);
	                setBackground(Color.pink);  // Light pink
	            }
					
		
			
			
			startButton.addActionListener(e -> {
				JOptionPane.showMessageDialog(startButton, "Starting");
//				State = playing; 
			});
			
			MouseAdapter hover = new MouseAdapter() {
				@Override
	            public void mouseEntered(MouseEvent e) {
					JButton button = (JButton) e.getComponent();
							
	                button.setBackground(btnHov);
	                button.setForeground(btnHov);
	                button.setBorder(BorderFactory.createLineBorder(btnHovBorder, 2));				
	                }
	            @Override
	            public void mouseExited(MouseEvent e) {
					JButton button = (JButton) e.getComponent();
	                button.setBackground(bgColor);
	                button.setForeground(btnColor);
	            }
			};		
			startButton.addMouseListener(hover);
			panel.add(title);
			panel.add(startButton);
			setContentPane(panel); 

		}
	}
		
			//StartButton.set(Color.RED); 
			
			//when i did css i could make it so when i hover over the start button it could(HOVER EFFECT ON JBUTTON)
			//hovering event 
			//come forward in the page i want to figure out how to do that 
			//i could also add padding around boxes to make them have a boarder and i also want to make the text box have curved edges
			
		
