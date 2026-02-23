package model;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridBagLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class StartFrame extends JFrame {
		
		private JLabel title = new JLabel("THE MAZE"); 
		private JLabel caption = new JLabel("Help Mochi and her friend get through the maze!"); 
		private JButton startButton = new JButton(); 
		Color bgColor = new Color(200, 220, 240);
		Color btnColor1 = new Color(248, 208, 218); 
		Color btnColor = new Color(255, 210, 228); 
		Color txtColor1 = new Color(255, 149, 185); 
		Color txtColor = new Color(175, 150, 210); 
		Color btnHov = new Color(207, 196, 255); 
		Color btnHovBorder = new Color(152, 169, 255); 

		public  StartFrame() {
			setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			setSize(700,700);
			JPanel root = new JPanel(new BorderLayout());
	        root.setBackground(Color.BLACK);
	        setContentPane(root);

	        JPanel centerPanel = new JPanel();
	        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
	        centerPanel.setBackground(bgColor);
	        centerPanel.setOpaque(true);
	        centerPanel.setPreferredSize(new Dimension(900, 700));
	        
			 title.setFont(new Font("Comic Sans MS", Font.BOLD, 60));
			 title.setForeground(txtColor1); 
			 title.setAlignmentY(TOP_ALIGNMENT);	
			 caption.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
			 caption.setForeground(txtColor1); 
			 caption.setAlignmentY(TOP_ALIGNMENT);
			
			startButton = new JButton("Start"); 
			startButton.setForeground(txtColor); 
			startButton.setBackground(btnColor);
			startButton.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
			startButton.setBorder(BorderFactory.createLineBorder(btnHovBorder, 12)); 


//	        startButton.setAlignmentY(CENTER_ALIGNMENT); 
//			startButton.setSize(500,100); //the size wil not listen to this as its doing any size it wants

			Dimension btnSize = new Dimension(300, 100);
			//was changing sizes and i didnt like so this keeps the size in the way i want 
			startButton.setPreferredSize(btnSize);
			startButton.setMaximumSize(btnSize);     
			startButton.setMinimumSize(btnSize);     
			startButton.setAlignmentX(Component.CENTER_ALIGNMENT);

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
	                button.setBorder(BorderFactory.createLineBorder(btnHovBorder, 14));				
	                }
	            @Override
	            public void mouseExited(MouseEvent e) {
					JButton button = (JButton) e.getComponent();
	                button.setBackground(btnColor);
	                button.setForeground(txtColor);
	                button.setBorder(BorderFactory.createLineBorder(btnHovBorder, 12));				

	            }
			};	
			startButton.addMouseListener(hover);
		
			centerPanel.add(Box.createVerticalStrut(16));
			centerPanel.add(title);
			centerPanel.add(caption);
			centerPanel.add(Box.createVerticalStrut(24));
			centerPanel.add(Box.createVerticalGlue());
			centerPanel.add(startButton);
			centerPanel.add(Box.createVerticalGlue());
			root.add(centerPanel, BorderLayout.CENTER); 
			
			
			JPanel bottomSprites = new JPanel();
			bottomSprites.setOpaque(true);
			bottomSprites.setBackground(bgColor);
			bottomSprites.setLayout(new FlowLayout(FlowLayout.CENTER, 24, 12)); 

			addSprite(bottomSprites, "/purplePlayer.png");
			addSprite(bottomSprites, "/pinkSimr.png");
			bottomSprites.setBorder(new EmptyBorder(0, 0, 200, 0)); 

			root.add(bottomSprites, BorderLayout.SOUTH);
		}
	
		private void addSprite(JPanel bttm, String resourcePath) {
	        try {
	            BufferedImage img = ImageIO.read(Tile.class.getResource(resourcePath));
	            if (img != null) {
	                JLabel sprite = new JLabel(new ImageIcon(img));
	                bttm.add(sprite);
	            }
	        } catch (IOException | IllegalArgumentException ex) {}
	    }

}
			
			//when i did css i could make it so when i hover over the start button it could(HOVER EFFECT ON JBUTTON)
			//hovering event 
			//come forward in the page i want to figure out how to do that 
			//i could also add padding around boxes to make them have a boarder and i also want to make the text box have curved edges
			
		




