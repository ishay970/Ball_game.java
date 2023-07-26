//208306233 ishay eldar
import biuoop.DrawSurface;
import java.util.ArrayList;
import java.util.List;

/**
 * class SpriteCollection.
 */
public class SpriteCollection {
    private List<Sprite> sprites;

    /**
     * constructor.
     */
    public SpriteCollection() {
        this.sprites = new ArrayList<>();
    }

    /**
     * @return sprites
     */
    public List<Sprite> getSprites() {
        return sprites;
    }

    /**
     *
     * @param s
     */
    public void addSprite(Sprite s) {
        this.sprites.add(s);
    }

    /**
     * method notifyAllTimePassed.
     */
    // call timePassed() on all sprites.
    public void notifyAllTimePassed() {
        int size = this.sprites.size();
        int i = 0;
        while (i < size) {
            this.sprites.get(i).timePassed();
            size = this.sprites.size();
            i++;
        }
    }

    /**
     *
     * @param d
     */
    // call drawOn(d) on all sprites.
    public void drawAllOn(DrawSurface d) {
        for (Sprite s : this.sprites) {
            s.drawOn(d);
        }
    }

    /**
     *
     * @param s
     */
    public void removeSprite(Sprite s) {
        if (this.sprites.contains(s)) {
            this.sprites.remove(s);
        }
    }
}