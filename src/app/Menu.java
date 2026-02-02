package app;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Image;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

public class Menu extends JPanel{
	private Image healthPoints;
	private Image brainPoints; 
	private int levelNum;
	
	public Menu() {
		setPreferredSize(new Dimension(300,50));
		setLayout(new FlowLayout(FlowLayout.CENTER));
		setBackground(Color.pink); 
		
		healthPoints = ImageIO.read(Menu.class.getResource("healthPts.png")); 
		brainPoints = ImageIO.read(Player.class.getResource("grainPts.png"));
		levelNum = 1; 
		
		add(healthPoints);
		add(levelNum);
	}
	public Image healthPoints(){
		return healthPoints;
	}
	public Image brainPoints() {
		return brainPoints;
	}
	public int levelNum() {
		return levelNum; 
	}
}
