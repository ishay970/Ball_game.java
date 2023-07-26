// ishay eldar 208306233
import biuoop.DrawSurface;

/**
 * interface Animation.
 */
public interface Animation {
    /**
     *
     * @param d
     */
    void doOneFrame(DrawSurface d);

    /**
     *
     * @return boolean
     */
    boolean shouldStop();
}

