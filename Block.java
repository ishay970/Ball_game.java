//208306233 ishay eldar
import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * class block.
 */
public class Block implements Collidable, Sprite, HitNotifier {

    private Rectangle rect;
    private Color color;
    private List<HitListener> hitListeners;

    /**
     *
     * @param rect
     */
    public Block(Rectangle rect) {
        this.rect = rect;
        this.color = Color.black;
        this.hitListeners = new ArrayList<>();
    }

    /**
     *
     * @param g
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     *
     * @param color
     */
    public void setColor(Color color) {
        this.color = color;
    }

    /**
     *
     * @return
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return rect;
    }

    /**
     *
     * @param collisionPoint
     * @param currentVelocity
     * @param hitter
     * @return
     */
    @Override
    public Velocity hit(Point collisionPoint, Velocity currentVelocity, Ball hitter) {
        Velocity v = currentVelocity;
        if ((collisionPoint.getX() == rect.getUpperLeft().getX())
                ||
                (collisionPoint.getX() == rect.getUpperLeft().getX() + rect.getWidth())) {
            v.setDx(-v.getDx());
        }
        if ((collisionPoint.getY() == rect.getUpperLeft().getY())
                ||
                (collisionPoint.getY() == rect.getUpperLeft().getY() + rect.getHeight())) {
            v.setDy(-v.getDy());
        }
        this.notifyHit(hitter);
        return v;
    }

    /**
     *
     * @param d
     */
    public void drawOn(DrawSurface d) {
        d.setColor(this.color);
        d.fillRectangle((int) this.rect.getUpperLeft().getX(),
                (int) this.rect.getUpperLeft().getY(),
                (int) this.rect.getWidth(),
                (int) this.rect.getHeight());
        d.setColor(Color.black);
        d.drawRectangle((int) this.rect.getUpperLeft().getX(),
                (int) this.rect.getUpperLeft().getY(),
                (int) this.rect.getWidth(),
                (int) this.rect.getHeight());
    }

    /**
     *
     * @param game
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
        game.removeCollidable(this);
    }

    /**
     *
     */
    @Override
    public void timePassed() {

    }

    /**
     *
     * @param hl
     */
    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    /**
     *
     * @param hl
     */
    @Override
    public void removeHitListener(HitListener hl) {
        if (hitListeners.contains(hl)) {
            hitListeners.remove(hl);
        }
    }

    /**
     *
     * @param hitter
     */
    private void notifyHit(Ball hitter) {
        // Make a copy of the hitListeners before iterating over them.
        List<HitListener> listeners = new ArrayList<HitListener>(this.hitListeners);
        // Notify all listeners about a hit event:
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

}


