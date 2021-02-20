package stickman.model;

import javafx.scene.text.Text;
import stickman.Memento.CareTaker;
import stickman.level.Level;
import stickman.level.LevelManager;

import java.util.List;

/**
 * Interface for the GameEngine. Describes the necessary behaviour
 * for running the game.
 */
public interface GameEngine {

    /**
     * Gets the current running level.
     * @return The current level
     */
    Level getCurrentLevel();

    /**
     * Makes the player jump.
     * @return Whether the input had an effect
     */
    boolean jump();

    /**
     * Moves the player left.
     * @return Whether the input had an effect
     */
    boolean moveLeft();

    /**
     * Moves the player right.
     * @return Whether the input had an effect
     */
    boolean moveRight();

    /**
     * Stops player movement.
     * @return Whether the input had an effect
     */
    boolean stopMoving();

    /**
     * Updates the scene every frame.
     */
    void tick();

    /**
     * Makes the player shoot.
     */
    void shoot();

    /**
     * Restarts the level.
     */
    void reset();

    /**
     * Get to next Level
     */
    void nextLevel(Level level);

    /**
     * Get all file names
     */
    List<String> getFileNames();

    /**
     * Get the TimeText in the current Game Engine
     */
    TimeText getTimeText();

    /**
     * Set the current Level
     */
    void setLevel(Level level);

    /**
     * Get the recommendTimeText object
     */
    Text getRecommendTimeText();

    /**
     * Get the ScoreText in the current Game Engine
     */
    ScoreText getScoreText();

    /**
     * Get the HpText in the current Game Engine
     */
    HpText getHpText();

    /**
     * Get the CareTaker in the current Game Engine
     */
    CareTaker getCareTaker();

}
