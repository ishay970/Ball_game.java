//208306233 ishay eldar
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * class ScoreIndicator.
 */
public class ScoreIndicator implements Sprite {
    private Counter score;

    /**
     * constructor.
     * @param score
     */
    public ScoreIndicator(Counter score) {
        this.score = score;
    }

    /**
     *
     * @param d
     */
    @Override
    public void drawOn(DrawSurface d) {
        d.setColor(Color.white);
        d.drawText(360, 15, "Score: " + this.score.getValue(), 15);
    }

    /**
     * empty.
     */
    @Override
    public void timePassed() {
    }

}
