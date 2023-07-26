//ishay eldar

/**
 * class Velocity.
 */
public class Velocity {
    private  double dx, dy;

    /**
     * constructor.
     * @param dx
     * @param dy
     */
    public Velocity(double dx, double dy) {
        this.dx = dx;
        this.dy = dy;
    }

    /**
     *
     * @return double
     */
    public double getDx() {
        return dx;
    }

    /**
     *
     * @return double
     */
    public double getDy() {
        return dy;
    }

    /**
     *
     * @return double
     */
    public double getAbsolute() {
        return Math.sqrt(Math.pow(dx, 2) + Math.pow(dy, 2));
    }

    /**
     *
     * @param p
     * @return point
     */
    // Take a point with position (x,y) and return a new point
    // with position (x+dx, y+dy)
    public Point applyToPoint(Point p) {
        return  new Point(p.getX() + this.dx, p.getY() + this.dy);
    }

    /**
     *
     * @param angle
     * @param speed
     * @return velocity
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {
        angle = angle * (Math.PI / 180);
        double dx = speed * Math.cos(angle);
        double dy = speed * Math.sin(angle);
        return new Velocity(dx, dy);
    }

    /**
     *
     * @param dx
     */
    public void setDx(double dx) {
        this.dx = dx;
    }

    /**
     *
     * @param dy
     */
    public void setDy(double dy) {
        this.dy = dy;
    }
}

