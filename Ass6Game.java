// ishay eldar 208306233

import biuoop.GUI;
import java.util.ArrayList;
import java.util.List;

/**
 * class Ass6Game.
 */
public class Ass6Game {
    /**
     * main.
     * @param args
     */
    public static void main(String[] args) {
        GUI gui = new GUI("Arkanoid", 800, 600);
        GameFlow gameFlow = new GameFlow(new AnimationRunner(gui), gui.getKeyboardSensor(), gui);
        List<LevelInformation> levels = new ArrayList<>();
        if (args.length == 0) {
            levels.add(new Level1());
            levels.add(new Level2());
            levels.add(new Level3());
            levels.add(new Level4());
        } else {
            for (int i = 0; i < args.length; i++) {
                try {
                    switch (Integer.parseInt(args[i])) {
                        case 1:
                            levels.add(new Level1());
                            break;
                        case 2:
                            levels.add(new Level2());
                            break;
                        case 3:
                            levels.add(new Level3());
                            break;
                        case 4:
                            levels.add(new Level4());
                            break;
                        default:
                    }
                } catch (NumberFormatException e) {
                    continue;
                }


            }
        }
        gameFlow.runLevels(levels);
    }
}
