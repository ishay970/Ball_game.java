//208306233 ishay eldar

import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 *
 */
public class KeyPressStoppableAnimation implements Animation {
    private KeyboardSensor sensor;
    private String key;
    private Animation animation;
    private boolean isAlreadyPressed = true;

    /**
     *
     * @param sensor
     * @param key
     * @param animation
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {
        this.sensor = sensor;
        this.key = key;
        this.animation = animation;
    }

    /**
     *
     * @param d
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        if (this.shouldStop()) {
            if (isAlreadyPressed) {
                return;
            }
        } else {
            isAlreadyPressed = false;
        }
        animation.doOneFrame(d);
    }

    /**
     *
     * @return boolean
     */
    @Override
    public boolean shouldStop() {
        if (this.sensor.isPressed(key)) {
            return true;
        }
        return false;
    }
    // think about the implementations of doOneFrame and shouldStop.
}