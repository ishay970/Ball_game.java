// ishay eldar

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 *
 */
public class GameOver implements Animation {
    private KeyboardSensor keyboard;
    private int score;

    /**
     *
     * @param score
     */
    public GameOver(int score) {
        this.score = score;
    }

    /**
     *
     * @param d
     */
    @Override
    public void doOneFrame(DrawSurface d) {


        d.drawText(10, d.getHeight() / 2, "Game Over. Your score is " + this.score, 32);
    }

    /**
     * @ boolean
     */
    @Override
    public boolean shouldStop() {
        return false;
    }
}
