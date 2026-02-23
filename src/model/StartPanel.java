package model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class StartPanel extends JPanel {

    private JLabel title = new JLabel("THE MAZE");
	private JLabel caption = new JLabel("Help Mochi and her friend get through the maze!"); 
	private JLabel caption2 = new JLabel("Keep them in the water avoid the walls"); 
    private JButton startButton = new JButton();
    Color bgColor = new Color(200, 220, 240);
    Color btnColor1 = new Color(248, 208, 218);
    Color btnColor = new Color(255, 210, 228);
    Color txtColor1 = new Color(255, 149, 185);
    Color txtColor = new Color(175, 150, 210);
    Color btnHov = new Color(207, 196, 255);
    Color btnHovBorder = new Color(152, 169, 255);
    
    public StartPanel() {
    	setLayout(new BorderLayout());
    	
        add(makeCenterPanel(), BorderLayout.CENTER);

        // Bottom panel has the two player sprites
        JPanel bottomSprites = new JPanel();
        bottomSprites.setOpaque(true);
        bottomSprites.setBackground(bgColor);
        bottomSprites.setLayout(new FlowLayout(FlowLayout.CENTER, 24, 12));

        addSprite(bottomSprites, "/purplePlayer.png");
		addSprite(bottomSprites, "/pinkSimr.png");
		bottomSprites.setBorder(new EmptyBorder(0, 0, 200, 0)); 
		add(bottomSprites, BorderLayout.SOUTH);

    }
    
    private JPanel makeCenterPanel() {
    	// Make the center panel with title, start button, captions 1+2
    	// We also have a mouse listener that adds a hover effect to the start button
    	
    	JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(bgColor);
        centerPanel.setOpaque(true);
        centerPanel.setPreferredSize(new Dimension(900, 700));

        // Title & caption 
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 60));
		 title.setForeground(txtColor1); 
		 title.setAlignmentY(TOP_ALIGNMENT);	
		 caption.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		 caption.setForeground(txtColor1); 
		 caption.setAlignmentY(TOP_ALIGNMENT);
		 caption2.setFont(new Font("Comic Sans MS", Font.BOLD, 20));
		 caption2.setForeground(txtColor1); 
		 caption2.setAlignmentY(TOP_ALIGNMENT);

        // start Button
        startButton = new JButton("Restart");
        startButton.setForeground(txtColor);
        startButton.setBackground(btnColor);
        startButton.setFont(new Font("Comic Sans MS", Font.BOLD, 35));
        startButton.setBorder(BorderFactory.createLineBorder(btnHovBorder, 12));

        Dimension btnSize = new Dimension(300, 100);
        startButton.setPreferredSize(btnSize);
        startButton.setMaximumSize(btnSize);
        startButton.setMinimumSize(btnSize);
        startButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        startButton.addActionListener(e -> {
            JOptionPane.showMessageDialog(startButton, "Starting");
            // TODO: switch back to gameplay screen
        });

        // Hover effect
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

        // Add to center panel and make layout centered (it still doesnt work )
        centerPanel.add(Box.createVerticalStrut(16));
        centerPanel.add(title);
		centerPanel.add(caption);
		centerPanel.add(caption2);
		centerPanel.add(Box.createVerticalStrut(24));
        centerPanel.add(Box.createVerticalGlue());
        centerPanel.add(startButton);
        centerPanel.add(Box.createVerticalGlue());
        
        return centerPanel;
    }
    
    private void addSprite(JPanel bottomPanel, String resourcePath) {
        try {
            BufferedImage img = ImageIO.read(Tile.class.getResource(resourcePath));
            if (img != null) {
                JLabel sprite = new JLabel(new ImageIcon(img));
                bottomPanel.add(sprite);
            }
        } catch (IOException | IllegalArgumentException ex) {
        	System.out.println("problem loading images");
        }
    }
}
//when i did css i could make it so when i hover over the start button it could(HOVER EFFECT ON JBUTTON)
//hovering event 
//come forward in the page i want to figure out how to do that 
//i could also add padding around boxes to make them have a boarder and i also want to make the text box have curved edges

