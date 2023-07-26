//208306233 ishay eldar
import biuoop.DrawSurface;
/**
 * interface Sprite.
 */
public interface Sprite {
    /**
     *
     * @param d
     */
    // draw the sprite to the screen
    void drawOn(DrawSurface d);

    /**
     * method timePassed.
     */
    // notify the sprite that time has passed
    void timePassed();
}