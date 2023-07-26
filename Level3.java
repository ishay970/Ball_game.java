//ishay eldar

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Level3 implements LevelInformation {
    /**
     *
     * @return num
     */
    @Override
    public int numberOfBalls() {
        return 2;
    }

    /**
     *
     * @return list
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> l = new ArrayList<>();
        l.add(Velocity.fromAngleAndSpeed(250, 2));
        l.add(Velocity.fromAngleAndSpeed(290, 2));
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
        return "Green 3";
    }

    /**
     *
     * @return block
     */
    @Override
    public Block getBackground() {
        Block b = new Block(new Rectangle(new Point(0, 0), 799, 599));
        b.setColor(Color.green);
        return b;
    }

    /**
     *
     * @return list
     */
    @Override
    public List<Block> blocks() {
        List<Block> blocks = new ArrayList<>();
        int firstBlock = 379;
        for (int i = 200; i >= 120; i -= 20) {
            for (int j = 739; j >= firstBlock; j -= 40) {
                Rectangle rectangle = new Rectangle(new Point(j, i), 40, 20);
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
                        block.setColor(Color.blue);
                        break;
                    case 120:
                        block.setColor(Color.white);
                        break;
                    case 100:
                        block.setColor(Color.green);
                        break;
                    default:
                }
                blocks.add(block);
            }
            firstBlock += 40;
        }

        return blocks;
    }

    /**
     *
     * @return num
     */
    @Override
    public int numberOfBlocksToRemove() {
        return 40;
    }
}
