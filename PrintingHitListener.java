//208306233 ishay eldar

/**
 * class PrintingHitListener.
 */
public class PrintingHitListener implements HitListener {
    /**
     * constructor.
     */
    public PrintingHitListener() {
    }

    /**
     *
     * @param beingHit
     * @param hitter
     */
    public void hitEvent(Block beingHit, Ball hitter) {
        System.out.println("A Block was hit.");
    }
}
