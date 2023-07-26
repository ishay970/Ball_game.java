// ishay eldar

import java.util.List;
/**
 * class Line.
 */

public class Line {
    private Point start;
    private Point end;

    /**
     * constructor.
     * @param start
     * @param end
     */
    public Line(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * constructor.
     * @param x1
     * @param y1
     * @param x2
     * @param y2
     */
    public Line(double x1, double y1, double x2, double y2) {
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
    }

    /**
     *
     * @return double.
     */
    // Return the length of the line
    public double length() {
        return this.start.distance(this.end);
    }

    /**
     *
     * @return point
     */
    // Returns the middle point of the line
    public Point middle() {
        double midX = (this.start.getX() + this.end.getX()) / 2;
        double midY = (this.start.getY() + this.end.getY()) / 2;
        return new Point(midX, midY);
    }

    /**
     *
     * @return point
     */
    // Returns the start point of the line
    public Point start() {
        return this.start;
    }

    /**
     *
     * @return point
     */
    // Returns the end point of the line
    public Point end() {
        return this.end;
    }

    /**
     *
     * @param other
     * @return boolean
     */
    // Returns true if the lines intersect, false otherwise
    /*public boolean isIntersecting(Line other) {
        if (this.getSlope() == other.getSlope()) {
            return false;
        }
        Point inter = this.intersectionWith(other);
        if ((inter.getX() >= Math.min(this.start.getX(), this.end.getX()))
                && (inter.getX() <= Math.max(this.start.getX(), this.end.getX()))
                && (inter.getX() >= Math.min(other.start.getX(), other.end.getX()))
                && (inter.getX() <= Math.max(other.start.getX(), other.end.getX()))) {
            return true;
        } else {
            return false;
        }
    }*/

    /**
     *
     * @return double
     */
    public double getSlope() {
        double slope;
        if (this.start.getX() == this.end.getX()) {
            return 0;
        }
        slope = (this.end.getY() - this.start.getY()) / (this.end.getX() - this.start.getX());
        return slope;
    }

    /**
     *
     * @return line
     */
    public double[] getLine() {
        double n = (this.end.getY() - this.getSlope() * this.end.getX());
        double[] line = new double[2];
        line[0] = this.getSlope();
        line[1] = n;
        return line;
    }

    /**
     *
     * @param other
     * @return point
     */
    // Returns the intersection point if the lines intersect,
    // and null otherwise.
    public Point intersectionWith(Line other) {

        if (this.start.getX() == this.end.getX()) {
            if (other.start.getX() == other.end.getX()) {
                return  null;
            }
            double[] l = other.getLine();
            Point p = new Point(this.start.getX(), l[0] * this.start.getX() + l[1]);
            if (!other.isOnLine(p)) {
                return null;
            }
            if (p.getY() > Math.max(this.start.getY(), this.end.getY())
                    ||
                    p.getY() < Math.min(this.start.getY(), this.end.getY())) {
                return null;
            }
            return  p;
        }

        if (other.start.getX() == other.end.getX()) {
            if (this.start.getX() == this.end.getX()) {
                return  null;
            }
            double[] l = this.getLine();
            Point p = new Point(other.start.getX(), l[0] * other.start.getX() + l[1]);
            if (!this.isOnLine(p)) {
                return null;
            }
            if (p.getY() > Math.max(other.start.getY(), other.end.getY())
                    ||
                    p.getY() < Math.min(other.start.getY(), other.end.getY())) {
                return null;
            }
            return p;
        }

        double[] l1 = this.getLine();
        double[] l2 = other.getLine();
        double x = (l1[1] - l2[1]) / (l2[0] - l1[0]);
        double y = (l1[0] * x) + l1[1];
        Point p2 = new Point(x, y);
        if (!(this.isOnLine(p2) && other.isOnLine(p2))) {
            return null;
        }
        return p2;
    }

    /**
     *
     * @param other
     * @return boolean
     */
    // equals -- return true is the lines are equal, false otherwise
    public boolean equals(Line other) {
        return (this.start.equals(other.start)) && (this.end.equals(other.end));
    }

    /**
     *
     * @param p
     * @return boolean
     */
    public boolean isOnLine(Point p) {
        double[] l = this.getLine();
        if (p.getY() == l[0] * p.getX() + l[1]) {
            return ((p.getX() >= Math.min(this.start.getX(), this.end.getX()))
                    &&
                    (p.getX() <= Math.max(this.start.getX(), this.end.getX()))
                    &&
                    (p.getY() >= Math.min(this.start.getY(), this.end.getY()))
                    &&
                    (p.getY() <= Math.max(this.start.getY(), this.end.getY())));
        } else {
            return false;
        }
    }

    /**
     *
     * @param rect
     * @return point
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {
        List<Point> pointList = rect.intersectionPoints(this);
        double min = -1;
        Point minP = null;

        for (Point p : pointList) {
            if ((min == -1) || (p.distance(this.start) < min)) {
                min = p.distance(this.start);
                minP = p;
            }
        }
        return minP;
    }

}

