// ishay eldar

import java.util.List;

/**
 *
 */
public interface LevelInformation {
    /**
     *
     * @return int
     */
    int numberOfBalls();
    // The initial velocity of each ball
    // Note that initialBallVelocities().size() == numberOfBalls()

    /**
     *
     * @return list
     */
    List<Velocity> initialBallVelocities();

    /**
     *
     * @return int
     */
    int paddleSpeed();

    /**
     *
     * @return int
     */
    int paddleWidth();
    // the level name will be displayed at the top of the screen.

    /**
     *
     * @return str
     */
    String levelName();
    // Returns a sprite with the background of the level

    /**
     *
     * @return block
     */
    Sprite getBackground();
    // The Blocks that make up this level, each block contains
    // its size, color and location.

    /**
     *
     * @return list
     */
    List<Block> blocks();
    // Number of blocks that should be removed
    // before the level is considered to be "cleared".
    // This number should be <= blocks.size();

    /**
     *
     * @return int
     */
    int numberOfBlocksToRemove();
}
