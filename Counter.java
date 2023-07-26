//208306233 ishay eldar

/**
 * class Counter.
 */
public class Counter {

    private int value;

    /**
     * constructor.
     */
    public Counter() {
        this.value = 0;
    }

    /**
     *
     * @param number
     */
    // add number to current count.
    void increase(int number) {
        this.value += number;
    }

    /**
     *
     * @param number
     */
    // subtract number from current count.
    void decrease(int number) {
        this.value -= number;
    }

    /**
     *
     * @return int
     */
    // get current count.
    public int getValue() {
        return value;
    }
}
