// ishay eldar
import biuoop.GUI;
import biuoop.KeyboardSensor;
import java.util.List;

/**
 * class GameFlow.
 */
public class GameFlow {

    private KeyboardSensor keyboardSensor;
    private AnimationRunner animationRunner;
    private GUI gui;

    /**
     *
     * @param ar
     * @param ks
     * @param gui
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks, GUI gui) {
        this.animationRunner = ar;
        this.keyboardSensor = ks;
        this.gui = gui;
    }

    /**
     *
     * @param levels
     */
    public void runLevels(List<LevelInformation> levels) {
        Counter scoreCounter = new Counter();
        for (LevelInformation levelInfo : levels) {
            GameLevel level = new GameLevel(levelInfo, this.keyboardSensor, this.animationRunner, scoreCounter);
            level.initialize();
            while (!(level.shouldStop())) {
                level.run();
            }
            if (level.getCounterBalls().getValue() == 0 && !level.isWin()) {
                this.animationRunner.run(new KeyPressStoppableAnimation(gui.getKeyboardSensor(),
                        gui.getKeyboardSensor().SPACE_KEY, new GameOver(scoreCounter.getValue())));
                return;
            }
        }
        this.animationRunner.run(new KeyPressStoppableAnimation(gui.getKeyboardSensor(),
                gui.getKeyboardSensor().SPACE_KEY, new YouWin(scoreCounter.getValue())));
    }
}
