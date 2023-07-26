//208306233 ishay eldar

import biuoop.DrawSurface;
import java.util.ArrayList;
import java.util.List;
import java.awt.Color;

/**
 * class ball.
 */
public class Ball implements Sprite, HitNotifier {

    private Point center;
    private int r;
    private Color color;
    private Velocity v;
    private GameEnvironment gameEnvironment;
    private List<HitListener> hitListeners;

    /**
     *
     * @param center
     * @param r
     * @param color
     */
    public Ball(Point center, int r, Color color) {
        this.center = center;
        this.r = r;
        this.color = color;
        this.hitListeners = new ArrayList<>();
    }

    /**
     *
     * @param x
     * @param y
     * @param r
     * @param color
     */
    public Ball(int x, int y, int r, Color color) {
        this.center = new Point(x, y);
        this.r = r;
        this.color = color;
    }

    /**
     *
     * @param g
     */
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }

    /**
     *
     * @return point.
     */
    public Point center() {
        return this.center;
    }

    /**
     *
     * @return int.
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     *
     * @return int.
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     *
     * @return int.
     */
    public int getSize() {
        return this.r;
    }

    /**
     *
     * @return color.
     */
    public Color getColor() {
        return this.color;
    }

    /**
     *
     * @param surface
     */
    public void drawOn(DrawSurface surface) {
        surface.setColor(this.color);
        surface.fillCircle((int) this.center.getX(), (int) this.center.getY(), this.r);
    }

    /**
     *
     */
    @Override
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     *
     * @param v
     */
    public void setVelocity(Velocity v) {
        this.v = v;
    }

    /**
     *
     * @param dx
     * @param dy
     */
    public void setVelocity(double dx, double dy) {
        this.v = new Velocity(dx, dy);
    }

    /**
     *
     * @return velocity.
     */
    public Velocity getVelocity() {
        return this.v;
    }

    /**
     *
     * @return gameEnvironment.
     */
    public GameEnvironment getGameEnvironment() {
        return gameEnvironment;
    }

    /**
     *
     * @param gameEnvironment
     */
    public void setGameEnvironment(GameEnvironment gameEnvironment) {
        this.gameEnvironment = gameEnvironment;
    }

    /**
     *
     */
    public void moveOneStep() {
        Line t = this.trajectory();
        CollisionInfo collisionInfo = this.gameEnvironment.getClosestCollision(t);
        if (collisionInfo == null) {
            this.center = new Point(t.end().getX(), t.end().getY());
            return;
        }
        this.v = collisionInfo.collisionObject().hit(collisionInfo.collisionPoint(), this.v, this);
        t = this.trajectory();
        this.center = new Point(t.end().getX(), t.end().getY());
    }

    /**
     *
     * @return line
     */
    public  Line trajectory() {
        return new Line(this.center.getX(), this.center.getY(),
                this.center.getX() + this.v.getDx(), this.center.getY() + this.v.getDy());
    }

    /**
     *
     * @param game
     */
    public void removeFromGame(GameLevel game) {
        game.removeSprite(this);
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
}




