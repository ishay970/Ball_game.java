// ishay eldar
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Level4 implements LevelInformation {
    /**
     *
     * @return num
     */
    @Override
    public int numberOfBalls() {
        return 3;
    }

    /**
     *
     * @return list
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> l = new ArrayList<>();
        int angle = 250;
        for (int i = 0; i < 3; i++) {
            l.add(Velocity.fromAngleAndSpeed(angle, 2));
            angle += 20;
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
        return 80;
    }

    /**
     *
     * @return str
     */
    @Override
    public String levelName() {
        return "Final Four";
    }

    /**
     *
     * @return block
     */
    @Override
    public Block getBackground() {
        Block b = new Block(new Rectangle(new Point(0, 0), 799, 599));
        b.setColor(Color.cyan);
        return b;
    }

    /**
     *
     * @return block
     */
    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        for (int i = 200; i >= 80; i -= 20) {
            for (int j = 725; j >= 20; j -= 50) {
                Rectangle rectangle = new Rectangle(new Point(j, i), 50, 20);
                Block block = new Block(rectangle);
                switch (i) {
                    case 200:
                        block.setColor(Color.gray);
                        break;
                    case 180:
                        block.setColor(Color.red);
                        break;
                    case 160:
                        block.setColor(Color.yellow);
                        break;
                    case 140:
                        block.setColor(Color.green);
                        break;
                    case 120:
                        block.setColor(Color.white);
                        break;
                    case 100:
                        block.setColor(Color.pink);
                        break;
                    case 80:
                        block.setColor(Color.cyan);
                        break;
                    default:
                }
                blocks.add(block);

            }
        }

        return blocks;
    }

    /**
     *
     * @return num
     */
    @Override
    public int numberOfBlocksToRemove() {
        return 105;
    }
}
