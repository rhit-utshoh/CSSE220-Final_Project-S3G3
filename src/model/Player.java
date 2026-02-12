package model;
import brain.CognitiveBrain; 
public class Player {

    private int x;
    private int y;

    private int vx;
    private int vy;

    private final CognitiveBrain brain;

    public Player(int x, int y, CognitiveBrain brain) {
        this.x = x;
        this.y = y;
        this.brain = brain;
    }

    public boolean canMove() {
        return brain.allowMovement();
    }

    public void setVelocity(int vx, int vy) {
        this.vx = vx;
        this.vy = vy;
    }

    public void update() {
    	if (!this.canMove()) {
    		vx = 0;
    		vy = 0;
    		return;
    	}
        x += vx;
        y += vy;

        // clamp to window bounds
        int maxX = GameConfig.WIDTH - GameConfig.PLAYER_SIZE;
        int maxY = GameConfig.HEIGHT - GameConfig.PLAYER_SIZE;
        
        int player_left_edge = x - GameConfig.PLAYER_SIZE;
        int player_right_edge = x + GameConfig.PLAYER_SIZE;
        int player_top_edge = y - GameConfig.PLAYER_SIZE;
        int player_bottom_edge = y + GameConfig.PLAYER_SIZE;
        
        if (player_left_edge < 0) x = GameConfig.PLAYER_SIZE;
        if (player_right_edge > maxX) x = maxX - GameConfig.PLAYER_SIZE;

        if (player_top_edge < 0) y = GameConfig.PLAYER_SIZE;
        if (player_bottom_edge > maxY) y = maxY - GameConfig.PLAYER_SIZE;
    }

    public int getX() { 
    	return x; 
    }
    public int getY() { 
    	return y; 
    }

    public String getBrainName() {
        return brain.getClass().getSimpleName();
    }
}
