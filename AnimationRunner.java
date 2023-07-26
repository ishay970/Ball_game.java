// ishay eldar
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * class AnimationRunner.
 */
public class AnimationRunner {
    private GUI gui;
    private int framesPerSecond;
    private Sleeper sleeper;

    /**
     * constructor.
     */
    public AnimationRunner(GUI gui) {
        this.sleeper = new Sleeper();
        this.gui = gui;
    }

    /**
     *
     * @return gui
     */
    public GUI getGui() {
        return gui;
    }

    /**
     *
     * @param animation
     */
    public void run(Animation animation) {
        this.framesPerSecond = 60;
        int millisecondsPerFrame = 1000 / this.framesPerSecond;
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();

            animation.doOneFrame(d);

            gui.show(d);
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }

}
