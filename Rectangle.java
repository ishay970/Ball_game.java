//208306233 ishay eldar
import java.util.ArrayList;
import java.util.List;

/**
 * class Rectangle.
 */
public class Rectangle {

    private Point upperLeft;
    private double width;
    private double height;

    /**
     * constructor.
     * @param upperLeft
     * @param width
     * @param height
     */
    // Create a new rectangle with location and width/height.
    public Rectangle(Point upperLeft, double width, double height) {
        this.upperLeft = upperLeft;
        this.width = width;
        this.height = height;
    }

    /**
     *
     * @return double
     */
    public double getHeight() {
        return height;
    }

    /**
     *
     * @return double
     */
    public double getWidth() {
        return width;
    }

    /**
     *
     * @return point
     */
    public Point getUpperLeft() {
        return upperLeft;
    }

    /**
     *
     * @return point
     */
    public Point getUpperRight() {
        return new Point(upperLeft.getX() + getWidth(), upperLeft.getY());
    }

    /**
     *
     * @return point
     */
    public Point getBottomLeft() {
        return new Point(upperLeft.getX(), upperLeft.getY() + getHeight());
    }

    /**
     *
     * @return point
     */
    public Point getBottomRight() {
        return new Point(upperLeft.getX() + getWidth(), upperLeft.getY() + getHeight());
    }

    /**
     *
     * @param height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    /**
     *
     * @param width
     */
    public void setWidth(double width) {
        this.width = width;
    }

    /**
     *
     * @param upperLeft
     */
    public void setUpperLeft(Point upperLeft) {
        this.upperLeft = upperLeft;
    }

    /**
     * method showRec.
     */
    public void showRec() {
        //System.out.println("The UpperLeft is:" + this.getUpperLeft().getX();
        // System.out.println("The UpperLeft is:" + this.getUpperLeft().getY();
        System.out.println("The whidth is:" + this.getWidth());
        System.out.println("The height is:" + this.getHeight());
    }

    /**
     *
     * @param line
     * @return point
     */
    public List<Point> intersectionPoints(Line line) {

        List<Point> pointsIntersection = new ArrayList<>();
        Point intersection = line.intersectionWith(new Line(this.getBottomLeft(), this.getBottomRight()));
        if (intersection != null) {
            pointsIntersection.add(intersection);
        }
        intersection = line.intersectionWith(new Line(this.getUpperLeft(), this.getUpperRight()));
        if (intersection != null) {
            pointsIntersection.add(intersection);
        }
        intersection = line.intersectionWith(new Line(this.getUpperLeft(), this.getBottomLeft()));
        if (intersection != null) {
            pointsIntersection.add(intersection);
        }
        intersection = line.intersectionWith(new Line(this.getUpperRight(), this.getBottomRight()));
        if (intersection != null) {
            pointsIntersection.add(intersection);
        }


      /*  double x0 = upperLeft.getX();
        double x1 = x0 + width;
        double y0 = upperLeft.getY();
        double y1 = y0 + height;

        double[] lineMn = line.getLine();

        double y = lineMn[0] * x0 + lineMn[1];
        Line left = new Line(x0, y0, x0, y1);
        if (left.isOnLine(new Point(x0, y))) {
            pointsIntersection.add(new Point(x0, y));
        }

        y = lineMn[0] * x1 + lineMn[1];
        Line right = new Line(x1, y0, x1, y1);
        if (left.isOnLine(new Point(x1, y))) {
            pointsIntersection.add(new Point(x1, y));
        }
        double x = (y0 - lineMn[1]) / lineMn[0];
        Line top = new Line(x0, y0, x1, y0);
        if (left.isOnLine(new Point(x, y0))) {
            pointsIntersection.add(new Point(x, y0));
        }

        x = (y1 - lineMn[1]) / lineMn[0];
        Line botom = new Line(x0, y1, x1, y1);
        if (left.isOnLine(new Point(x, y1))) {
            pointsIntersection.add(new Point(x, y1));
        }*/

        return pointsIntersection;
    }
}

