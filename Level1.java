//208306233 ishay eldar

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */
public class Level1 implements LevelInformation {
    /**
     *
     * @return 1
     */
    @Override
    public int numberOfBalls() {
        return 1;
    }

    /**
     *
     * @return listVel
     */
    @Override
    public List<Velocity> initialBallVelocities() {
        List<Velocity> listVel = new ArrayList<>();
        listVel.add(new Velocity(0, 2));
        return listVel;
    }

    /**
     *
     * @return 3
     */
    @Override
    public int paddleSpeed() {
        return 3;
    }

    /**
     *
     * @return 80
     */
    @Override
    public int paddleWidth() {
        return 80;
    }

    /**
     *
     * @return string
     */
    @Override
    public String levelName() {
        return "Direct hit";
    }

    /**
     *
     * @return block
     */
    @Override
    public Sprite getBackground() {
        return new Block(new Rectangle(new Point(0, 0), 800, 600));
    }

    /**
     *
     * @return listblocks
     */
    @Override
    public List<Block> blocks() {
        List<Block> listblocks = new ArrayList<>();
        Block b = new Block(new Rectangle(new Point(380, 100), 40, 40));
        b.setColor(Color.red);
        listblocks.add(b);
        return listblocks;
    }

    /**
     *
     * @return 1
     */
    @Override
    public int numberOfBlocksToRemove() {
        return 1;
    }
}
