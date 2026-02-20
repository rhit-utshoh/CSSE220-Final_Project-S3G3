package model;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


import javax.swing.*;

public class StartFrame extends JFrame {
		
		private JLabel title = new JLabel("GAME TITLE"); 
		private JButton startButton = new JButton(); 
		Color bgColor = new Color(200, 220, 240);
		Color btnColor = new Color(248, 208, 218); 
		Color txtColor = new Color(175, 150, 210); 
		Color btnHov = new Color(207, 196, 255); 
		Color btnHovBorder = new Color(152, 169, 255); 



		public  StartFrame() {
			setTitle("GameName"); 
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(900,700);
			 JPanel panel = new JPanel(); 
			 panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			 panel.setBackground(bgColor);
			 panel.setOpaque(true);
			 panel.setPreferredSize(new Dimension(900, 700));

			 
			 title.setFont(new Font("Comic Sans MS", Font.BOLD, 30));
			 title.setForeground(txtColor); 
			 title.setAlignmentY(TOP_ALIGNMENT);				
			
			startButton = new JButton("PLAY"); 
			startButton.setForeground(txtColor); 
			startButton.setBackground(btnColor);

//	        startButton.setAlignmentY(CENTER_ALIGNMENT); 
			startButton.setSize(500,100); //the size wil not listen to this as its doing any size it wants
			startButton.setFont(new Font("Comic Sans MS", Font.BOLD, 28));
			startButton.setBorder(BorderFactory.createLineBorder(btnColor, 6)); 
	        startButton.setMinimumSize(new Dimension(400, 100));
			startButton.setText("Start"); 		
			startButton.addActionListener(e -> {
				JOptionPane.showMessageDialog(startButton, "Starting");
//				State = playing; need to pull up the actual game screen here!!
			});
			
			MouseAdapter hover = new MouseAdapter() {
				@Override
	            public void mouseEntered(MouseEvent e) {
					JButton button = (JButton) e.getComponent();
							
	                button.setBackground(btnHov);
	                button.setForeground(btnColor);
	                button.setBorder(BorderFactory.createLineBorder(btnHovBorder, 2));				
	                }
	            @Override
	            public void mouseExited(MouseEvent e) {
					JButton button = (JButton) e.getComponent();
	                button.setBackground(btnColor);
	                button.setForeground(txtColor);
	            }
			};		
			startButton.addMouseListener(hover);
			
			title.setAlignmentX(Component.CENTER_ALIGNMENT);
			startButton.setAlignmentX(Component.CENTER_ALIGNMENT);
			panel.add(Box.createVerticalStrut(8));
			panel.add(title);
			panel.add(Box.createVerticalStrut(24));
			panel.add(Box.createVerticalGlue());
			panel.add(startButton);
			panel.add(Box.createVerticalGlue());

		// took so very long but the grid layout allows me to center the buttons and i am able to set the button and title to be where i want 
		JPanel root = new JPanel(new GridBagLayout());
		root.setBackground(Color.BLACK);
		
		root.add(panel);  
		setContentPane(root);


		}
	}
		
			//StartButton.set(Color.RED); 
			
			//when i did css i could make it so when i hover over the start button it could(HOVER EFFECT ON JBUTTON)
			//hovering event 
			//come forward in the page i want to figure out how to do that 
			//i could also add padding around boxes to make them have a boarder and i also want to make the text box have curved edges
			
		




