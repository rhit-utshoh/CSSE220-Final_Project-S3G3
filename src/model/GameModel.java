package model;

import app.ADHDBrain;
import app.GameConfig;
import app.NeurotypicalBrain;
import app.Player;

public class GameModel {

    private final Player p1;
    private final Player p2;

    private GameState state = GameState.PLAYING;

    public GameModel() {
        p1 = new Player(140, 200, new NeurotypicalBrain());
        p2 = new Player(260, 200, new ADHDBrain());
    }

    public void togglePause() {
        state = (state == GameState.PLAYING) ? GameState.PAUSED : GameState.PLAYING;
    }

    public boolean isPlaying() {
        return state == GameState.PLAYING;
    }

    public GameState getState() {
        return state;
    }

    public void update(boolean up, boolean down, boolean left, boolean right) {
        if (!isPlaying()) {
            // stop movement while paused
            p1.setVelocity(0, 0);
            p2.setVelocity(0, 0);
            return;
        }

        int vx = (right ? GameConfig.PLAYER_SPEED : 0) - (left ? GameConfig.PLAYER_SPEED : 0);
        int vy = (down ? GameConfig.PLAYER_SPEED : 0) - (up ? GameConfig.PLAYER_SPEED : 0);

        boolean p1Move = p1.canMoveThisTick();
        boolean p2Move = p2.canMoveThisTick();

        p1.setVelocity(p1Move ? vx : 0, p1Move ? vy : 0);
        p2.setVelocity(p2Move ? vx : 0, p2Move ? vy : 0);

        p1.update();
        p2.update();
    }

    public Player getP1() { return p1; }
    public Player getP2() { return p2; }
}
