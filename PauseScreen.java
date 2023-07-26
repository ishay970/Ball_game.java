// ishay eldar
import biuoop.DrawSurface;

/**
 *
 */
public class PauseScreen implements Animation {

    /**
     *
     */
    public PauseScreen() {
    }

    /**
     *
     * @param d
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        d.drawText(10, d.getHeight() / 2, "paused -- press space to continue", 32);
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
