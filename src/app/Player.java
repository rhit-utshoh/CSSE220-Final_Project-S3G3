package app;

<<<<<<< HEAD
public class Player implements CognitiveBrain{
	
	
	public Player() {
		
	}

=======
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

    public boolean canMoveThisTick() {
        return brain.allowMovement();
    }

    public void setVelocity(int vx, int vy) {
        this.vx = vx;
        this.vy = vy;
    }

    public void update() {
        x += vx;
        y += vy;

        // clamp to window bounds
        int maxX = GameConfig.WIDTH - GameConfig.PLAYER_SIZE;
        int maxY = GameConfig.HEIGHT - GameConfig.PLAYER_SIZE;

        if (x < 0) x = 0;
        if (y < 0) y = 0;
        if (x > maxX) x = maxX;
        if (y > maxY) y = maxY;
    }

    public int getX() { return x; }
    public int getY() { return y; }

    public String getBrainName() {
        return brain.getClass().getSimpleName();
    }
>>>>>>> utsho_branch
}
