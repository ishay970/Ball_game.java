// ishay eldar
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.KeyboardSensor;
import biuoop.Sleeper;

import java.awt.Color;

/**
 * class GameLevel.
 */
public class GameLevel implements Animation {
    private SpriteCollection sprites;
    private SpriteCollection sprites2;
    private GameEnvironment environment;
    private Sleeper sleeper;
    private GUI gui;
    private KeyboardSensor keyboardSensor;
    private BlockRemover blockRemover;
    private BallRemover ballRemover;
    private ScoreTrackingListener scoreTrackingListener;
    private ScoreIndicator scoreIndicator;
    private Counter counterBlocks;
    private Counter counterBalls;
    private Counter counterScore;
    private boolean isRuning;
    private AnimationRunner animationRunner;
    private LevelInformation level;
    private boolean win;

    /**
     *
     * @param level
     * @param keyboardSensor
     * @param animationRunner
     * @param counterScore
     */
    public GameLevel(LevelInformation level, KeyboardSensor keyboardSensor,
                     AnimationRunner animationRunner, Counter counterScore) {
        this.level = level;
        this.keyboardSensor = keyboardSensor;
        this.animationRunner = animationRunner;
        this.counterScore = counterScore;

    }

    /**
     *
     * @return environment
     */
    public GameEnvironment getEnvironment() {
        return this.environment;
    }

    /**
     *
     * @param c
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     *
     * @param s
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }
    // Initialize a new game: create the Blocks and Ball (and Paddle)
    // and add them to the game.

    /**
     * method initialize.
     */
    public void initialize() {

        this.sprites = new SpriteCollection();
        this.sprites2 = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.sleeper = new Sleeper();
        this.gui = animationRunner.getGui();
        this.keyboardSensor = this.gui.getKeyboardSensor();

        this.counterBlocks = new Counter();
        this.counterBalls = new Counter();
        this.blockRemover = new BlockRemover(this, this.counterBlocks);
        this.ballRemover = new BallRemover(this, this.counterBalls);
        this.scoreTrackingListener = new ScoreTrackingListener(this.counterScore);
        this.scoreIndicator = new ScoreIndicator(this.counterScore);
        this.isRuning = true;


        for (Velocity v : level.initialBallVelocities()) {
            Ball ball = new Ball(400, 560, 5, Color.blue);
            ball.setGameEnvironment(this.environment);
            ball.setVelocity(v);
            this.sprites2.addSprite(ball);
            this.counterBalls.increase(1);
        }

        int width = 800;
        int height = 40;
        Point p = new Point(0, 0);
        Rectangle rect = new Rectangle(p, width, height);
        Block b1 = new Block(rect);
        b1.setColor(Color.gray);
        b1.addToGame(this);


        int width2 = 800;
        int height2 = 10;
        Point p2 = new Point(0, 590);
        Rectangle rect2 = new Rectangle(p2, width2, height2);
        Block b2 = new Block(rect2);
        b2.setColor(Color.gray);
        b2.addToGame(this);
        b2.addHitListener(ballRemover);


        int width3 = 10;
        int height3 = 600;
        Point p3 = new Point(0, 0);
        Rectangle rect3 = new Rectangle(p3, width3, height3);
        Block b3 = new Block(rect3);
        b3.setColor(Color.gray);
        b3.addToGame(this);


        int width4 = 10;
        int height4 = 600;
        Point p4 = new Point(790, 0);
        Rectangle rect4 = new Rectangle(p4, width4, height4);
        Block b4 = new Block(rect4);
        b4.setColor(Color.gray);
        b4.addToGame(this);

        this.sprites.addSprite(level.getBackground());

        int widthPaddle = level.paddleWidth();
        int heightPaddle = 20;
        Point pPaddle = new Point(400 - (level.paddleWidth() / 2), 570);
        Rectangle rectPaddle = new Rectangle(pPaddle, widthPaddle, heightPaddle);
        Block bPaddle = new Block(rectPaddle);
        bPaddle.setColor(Color.yellow);
        Paddle paddle = new Paddle(bPaddle, gui);
        paddle.addToGame(this);


        /** for (int i = 0; i < 7; i++){
         for (int j = 750; j > i * 40 + 200; j-= 40){ // the orginal
         // for (int i = 0; i < 2; i++){
         //  for (int j = 750; j > 710; j-= 40){  // for test
         this.counterBlocks.increase(1);
         Rectangle rectx = new Rectangle(new Point(j, i*20 + 60), 40, 20);
         Block bRectx = new Block (rectx);
         bRectx.setColor(Color.blue);
         bRectx.addToGame(this);
         bRectx.addHitListener(this.blockRemover);
         bRectx.addHitListener(this.scoreTrackingListener);
         }

         }*/
        for (Block b : level.blocks()) {
            this.counterBlocks.increase(1);
            b.addToGame(this);
            b.addHitListener(this.blockRemover);
            b.addHitListener(this.scoreTrackingListener);
        }
    }

    // Run the game -- start the animation loop.

    /**
     * method run.
     */
    public void run() {
        this.initialize(); // or a similar method
        this.isRuning = true;
        // use our runner to run the current animation -- which is one turn of
        // the game.
        this.animationRunner.run(this);
    }

    /**
     *
     * @param c
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     *
     * @param s
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
        this.sprites2.removeSprite(s);
    }

    /**
     *
     * @param d
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        this.sprites.drawAllOn(d);
        this.sprites2.drawAllOn(d);
        d.setColor(Color.white);
        d.drawText(460, 15, "Level Name: " + this.level.levelName(), 15);
        this.scoreIndicator.drawOn(d);
        this.sprites.notifyAllTimePassed();
        this.sprites2.notifyAllTimePassed();

        if (counterBlocks.getValue() == 0) {
            this.counterScore.increase(100);
            isRuning = false;
            win = true;
        }
        if (counterBalls.getValue() == 0) {
            isRuning = false;
            win = false;
        }
        if (this.keyboardSensor.isPressed("p")) {
            this.animationRunner.run(new KeyPressStoppableAnimation(gui.getKeyboardSensor(),
                    gui.getKeyboardSensor().SPACE_KEY, new PauseScreen()));
        }
    }

    @Override
    public boolean shouldStop() {
        return !(this.isRuning);
    }

    /**
     *
     * @return counterBalls
     */
    public Counter getCounterBalls() {
        return counterBalls;
    }

    /**
     *
     * @return win
     */
    public boolean isWin() {
        return win;
    }
}
