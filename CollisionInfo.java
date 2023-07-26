//208306233 ishay eldar

/**
 * class CollisionInfo.
 */
public class CollisionInfo {

    private  Point point;
    private Collidable collidable;

    /**
     *
     * @param point
     * @param collidable
     */
    public CollisionInfo(Point point, Collidable collidable) {
        this.point = point;
        this.collidable = collidable;
    }

    /**
     *
     * @return point
     */
    public Point collisionPoint() {
        return this.point;
    }

    /**
     *
     * @return collidable
     */
    public Collidable collisionObject() {
        return this.collidable;
    }

}

