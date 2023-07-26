//208306233 ishay eldar
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 *
 */
public class YouWin implements Animation {
    private KeyboardSensor keyboard;
    private int score;

    /**
     *
     * @param score
     */
    public YouWin(int score) {
        this.score = score;
    }

    /**
     *
     * @param d
     */
    @Override
    public void doOneFrame(DrawSurface d) {


        d.drawText(10, d.getHeight() / 2, "You Win! Your score is " + this.score, 32);
    }

    /**
     *
     * @return boolean
     */
    @Override
    public boolean shouldStop() {
        return false;
    }
}