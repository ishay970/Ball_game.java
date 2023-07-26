//208306233 ishay eldar

import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import java.awt.Color;

/**
 * class Paddle.
 */
public class Paddle implements Sprite, Collidable {
    private biuoop.KeyboardSensor keyboard;
    private Block block;
    private Point upperLeft;
    private Color color;

    /**
     * CONSTRUCTOR.
     * @param block
     * @param gui
     */
    public Paddle(Block block, GUI gui) {
        this.block = block;
        this.upperLeft = block.getCollisionRectangle().getUpperLeft();
        this.keyboard = gui.getKeyboardSensor();
        this.color = Color.yellow;
    }

    /**
     * CONSTRUCTOR.
     * @param color
     */
    public void setColor(Color color) {
        this.color = color;
        this.block.setColor(color);
    }

    /**
     * method moveLeft.
     */
    public void moveLeft() {
        if (this.upperLeft.getX() <= 0) {
            return;
        }
        Block newBlock = new Block(new Rectangle(new Point(this.upperLeft.getX() - 4,
                this.upperLeft.getY()),
                this.getCollisionRectangle().getWidth(),
                this.getCollisionRectangle().getHeight()
        ));
        this.block = newBlock;
        this.upperLeft = newBlock.getCollisionRectangle().getUpperLeft();
        this.block.setColor(color);
    }

    /**
     * method moveRight.
     */
    public void moveRight() {
        if (this.upperLeft.getX() >= 800 - this.getCollisionRectangle().getWidth()) {
            return;
        }
        Block newBlock = new Block(new Rectangle(new Point(this.upperLeft.getX() + 4,
                this.upperLeft.getY()),
                this.getCollisionRectangle().getWidth(),
                this.getCollisionRectangle().getHeight()
        ));
        newBlock.setColor(this.color);
        this.block = newBlock;
        this.upperLeft = newBlock.getCollisionRectangle().getUpperLeft();
    }

    /**
     * method timePassed.
     */
    public void timePassed() {
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        }
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        }
    }

    /**
     * method drawOn.
     * @param d
     */
    public void drawOn(DrawSurface d) {
        this.block.drawOn(d);
    }

    /**
     *
     * @return rectangle
     */
    public Rectangle getCollisionRectangle() {
        return this.block.getCollisionRectangle();
    }

    /**
     *
     * @param collisionPoint
     * @param currentVelocity
     * @param hitter
     * @return velocity
     */
    public Velocity hit(Point collisionPoint, Velocity currentVelocity, Ball hitter) {
        double absoluteV = currentVelocity.getAbsolute();
        double w = this.getCollisionRectangle().getWidth();
        double x = this.upperLeft.getX();
        double colX = collisionPoint.getX();
        if (colX >= x && colX <= x + (w / 5)) {
            return Velocity.fromAngleAndSpeed(210, absoluteV);
        }
        if (colX >= x + (w / 5) && colX <= x + 2 * (w / 5)) {
            return Velocity.fromAngleAndSpeed(240, absoluteV);
        }
        if (colX >= x + 2 * (w / 5) && colX <= x + 3 * (w / 5)) {
            return Velocity.fromAngleAndSpeed(270, absoluteV);
        }
        if (colX >= x + 3 * (w / 5) && colX <= x + 4 * (w / 5)) {
            return Velocity.fromAngleAndSpeed(300, absoluteV);
        } else {
            return Velocity.fromAngleAndSpeed(330, absoluteV);
        }
    }

    /**
     *
     * @param g
     */
    // Add this paddle to the game.
    public void addToGame(GameLevel g) {
        g.addCollidable(this);
        g.addSprite(this);
    }
}