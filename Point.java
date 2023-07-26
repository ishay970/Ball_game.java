// ishay eldar

/**
 * class Point.
 */
public class Point {
    private double x;
    private double y;

    /**
     *
     * @param x
     * @param y
     */
    public Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    /**
     *
     * @return double
     */
    public double getX() {
        return this.x;
    }

    /**
     *
     * @return double
     */
    public double getY() {
        return this.y;
    }

    /**
     * method showPoint.
     */
    public void showPoint() {
        System.out.println(this.getX());
        System.out.println(this.getY());
    }

    /**
     *
     * @param other
     * @return boolean
     */
    public boolean equals(Point other) {
        return (this.x == other.getX() && this.y == other.getY());
    }

    /**
     *
     * @param other
     * @return point
     */
    public double distance(Point other) {
        return Math.sqrt(Math.pow(other.getX() - this.x, 2) - Math.pow(other.getY() - this.y, 2));
    }
}

