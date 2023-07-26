//208306233 ishay eldar
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;
import java.awt.Color;

/**
 * class testing.
 */
public class Testing {
    public static final int WIDTH = 900;
    public static final int HEIGHT = 700;

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        // create gui
        GUI gui = new GUI("Collision Test", WIDTH, HEIGHT);

        //create ball
        int r = 10;
        GameEnvironment e = new GameEnvironment();
        Ball ball = new Ball(400, 350, r, Color.BLACK);
        int angle = 300;
        int speed = 10;
        Velocity v = Velocity.fromAngleAndSpeed(angle, speed);
        ball.setVelocity(v);
        ball.setGameEnvironment(e);

        int hits = 0;
        //create block
        Color color = new Color(10, 50, 100);
        int width = WIDTH;
        int height = 2;
        Point p = new Point(0, 0);
        Rectangle rect = new Rectangle(p, width, height);
        Block b1 = new Block(rect);

        Color color2 = new Color(10, 50, 100);
        int width2 = WIDTH;
        int height2 = 2;
        Point p2 = new Point(0, 698);
        Rectangle rect2 = new Rectangle(p2, width2, height2);
        Block b2 = new Block(rect2);

        Color color3 = new Color(10, 50, 100);
        int width3 = 2;
        int height3 = HEIGHT;
        Point p3 = new Point(0, 0);
        Rectangle rect3 = new Rectangle(p3, width3, height3);
        Block b3 = new Block(rect3);

        Color color4 = new Color(10, 50, 100);
        int width4 = 2;
        int height4 = HEIGHT;
        Point p4 = new Point(898, 0);
        Rectangle rect4 = new Rectangle(p4, width4, height4);
        Block b4 = new Block(rect4);

        ball.getGameEnvironment().addCollidable(b1);
        ball.getGameEnvironment().addCollidable(b2);
        ball.getGameEnvironment().addCollidable(b3);
        ball.getGameEnvironment().addCollidable(b4);

        Sleeper sleeper = new Sleeper();
        while (true) {
            DrawSurface d = gui.getDrawSurface();
            ball.drawOn(d);
            b1.drawOn(d);
            b2.drawOn(d);
            b3.drawOn(d);
            b4.drawOn(d);
            gui.show(d);
            ball.moveOneStep();
            sleeper.sleepFor(50); // wait for 50 milliseconds.
        }
    }
}
