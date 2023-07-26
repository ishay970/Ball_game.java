//208306233 ishay eldar

/**
 * class BallRemover.
 */
public class BallRemover implements HitListener {
    private GameLevel game;
    private Counter remainingBalls;

    /**
     *  @param game
     * @param removedBalls
     */
    public BallRemover(GameLevel game, Counter removedBalls) {
        this.game = game;
        this.remainingBalls = removedBalls;
    }

    /**
     *
     * @return counter
     */
    public Counter getRemainingBalls() {
        return remainingBalls;
    }

    /**
     *
     * @param beingHit
     * @param hitter
     */
    // Blocks that are hit should be removed
    // from the game. Remember to remove this listener from the block
    // that is being removed from the game.
    public void hitEvent(Block beingHit, Ball hitter) {
        hitter.removeFromGame(this.game);
        this.remainingBalls.decrease(1);
    }
}
