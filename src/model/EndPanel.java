package model;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class EndPanel extends JPanel {

    private JLabel title = new JLabel("GAME OVER");
    Color bgColor = new Color(200, 220, 240);
    Color btnColor1 = new Color(248, 208, 218);
    Color btnColor = new Color(255, 210, 228);
    Color txtColor1 = new Color(255, 149, 185);
    Color txtColor = new Color(175, 150, 210);
    Color btnHov = new Color(207, 196, 255);
    Color btnHovBorder = new Color(152, 169, 255);

    public EndPanel() {
        setLayout(new BorderLayout());
        setBackground(Color.BLACK);

        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
        centerPanel.setBackground(bgColor);
        centerPanel.setOpaque(true);
        centerPanel.setPreferredSize(new Dimension(900, 700));

        // Title
        title.setFont(new Font("Comic Sans MS", Font.BOLD, 40));
        title.setForeground(txtColor1);
        title.setAlignmentY(TOP_ALIGNMENT);

        // Add to center panel
        centerPanel.add(Box.createVerticalStrut(16));
        centerPanel.add(title);
        centerPanel.add(Box.createVerticalStrut(24));
        centerPanel.add(Box.createVerticalGlue());
//        centerPanel.add(restartButton);
        centerPanel.add(Box.createVerticalGlue());

        add(centerPanel, BorderLayout.CENTER);

        // Bottom sprites
        JPanel hitSprite = new JPanel();
        hitSprite.setOpaque(true);
        hitSprite.setBackground(bgColor);
        hitSprite.setLayout(new FlowLayout(FlowLayout.CENTER, 24, 12));

        addSprite(hitSprite, "/hitPlayer.png");
        hitSprite.setBorder(new EmptyBorder(0, 0, 100, 0));

        add(hitSprite, BorderLayout.SOUTH);
    }

    private void addSprite(JPanel bottomPanel, String resourcePath) {
        try {
            BufferedImage img = ImageIO.read(EndPanel.class.getResource(resourcePath));
            if (img != null) {
                JLabel sprite = new JLabel(new ImageIcon(img));
                bottomPanel.add(sprite);
            }
        } catch (IOException | IllegalArgumentException ex) {}
    }
}