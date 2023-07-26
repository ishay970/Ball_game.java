//ishay eldar
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Level2 implements LevelInformation {
    /**
     *
     * @return num
     */
    @Override
    public int numberOfBalls() {
        return 10;
    }

    /**
     *
     * @return num
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> l = new ArrayList<>();
        int angle = 200;
        for (int i = 0; i < 5; i++) {
            angle += 10;
            l.add(Velocity.fromAngleAndSpeed(angle, 2));
        }
        angle = 340;
        for (int i = 0; i < 5; i++) {
            angle -= 10;
            l.add(Velocity.fromAngleAndSpeed(angle, 2));
        }
        return l;
    }

    /**
     *
     * @return num
     */
    @Override
    public int paddleSpeed() {
        return 3;
    }

    /**
     *
     * @return num
     */
    @Override
    public int paddleWidth() {
        return 500;
    }

    /**
     *
     * @return str
     */
    @Override
    public String levelName() {
        return "Wide Eazy";
    }

    /**
     *
     * @return block
     */
    @Override
    public Block getBackground() {
        Block b = new Block(new Rectangle(new Point(0, 0), 799, 599));
        b.setColor(Color.lightGray);
        return b;
    }

    /**
     *
     * @return list
     */
    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();

        for (int i = 725; i >= 25; i -= 50) {
            Rectangle rectangle = new Rectangle(new Point(i, 300), 50, 20);
            Block block = new Block(rectangle);
            if (i >= 675) {
                block.setColor(Color.cyan);
            } else if (i >= 575) {
                block.setColor(Color.pink);
            } else if (i >= 475) {
                block.setColor(Color.blue);
            } else if (i >= 325) {
                block.setColor(Color.green);
            } else if (i >= 225) {
                block.setColor(Color.yellow);
            } else if (i >= 125) {
                block.setColor(Color.orange);
            } else {
                block.setColor(Color.red);
            }
            blocks.add(block);
        }

        return blocks;
    }

    /**
     *
     * @return num
     */
    @Override
    public int numberOfBlocksToRemove() {
        return 14;
    }
}
