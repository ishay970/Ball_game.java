//ishay eldar

/**
 * interfase coliidable.
 */
public interface Collidable {

    /**
     *
     * @return rectangle
     */
    Rectangle getCollisionRectangle();

    /**
     *
     * @param collisionPoint
     * @param currentVelocity
     * @param hitter
     * @return velocity
     */
    Velocity hit(Point collisionPoint, Velocity currentVelocity, Ball hitter);
}
