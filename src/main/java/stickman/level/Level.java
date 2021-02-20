package stickman.level;

import stickman.entity.Entity;
import stickman.entity.Interactable;
import stickman.entity.moving.MovingEntity;
import stickman.entity.moving.other.Projectile;
import stickman.entity.moving.player.StickMan;
import stickman.model.TimeText;

import java.util.List;

/**
 * The interface describing the behaviours of a Level.
 */
public interface Level extends Cloneable{

    /**
     * Gets all the entities within the Level.
     * @return All the entities within the level
     */
    List<Entity> getEntities();

    /**
     * Gets the height of the level.
     * @return The height of the level
     */
    double getHeight();

    /**
     * Gets the width of the level.
     * @return The width of the level
     */
    double getWidth();

    /**
     * Updates the level every frame.
     */
    void tick();

    /**
     * Gets the height of the floor.
     * @return The height of the floor
     */
    double getFloorHeight();

    /**
     * Gets the x-coordinate of the player character.
     * @return The x-coordinate of the player
     */
    double getHeroX();

    /**
     * Gets the y-coordinate of the player character.
     * @return The y-coordinate of the player
     */
    double getHeroY();

    /**
     * Makes the player jump.
     * @return Whether the player jumped
     */
    boolean jump();

    /**
     * Makes the player move left.
     * @return Whether the player moved left
     */
    boolean moveLeft();

    /**
     * Makes the player move right.
     * @return Whether the player moved right
     */
    boolean moveRight();

    /**
     * Stops all horizontal movement of the player.
     * @return Whether the player stopped moving
     */
    boolean stopMoving();

    /**
     * Resets the level.
     */
    void reset();

    /**
     * Makes the player shoot.
     */
    void shoot();

    /**
     * Returns the source file of the level.
     * @return The file the level is based off of
     */
    String getSource();

    /**
     * Stops level and shows victory message.
     */
    void win();

    /**
     * Set the level active or not.
     */
    void setActive(Boolean active);

    /**
     * Returns true if the level is active.
     * @return Whether the level is active
     */
    boolean getActive();

    /**
     * get the recommend time to pass the level
     * @return the recommend time to pass the level
     */
    long getRecommendTime();

    /**
     * get the current hp of the hero
     * @return the hp of the hero
     */
    int getHp();

    /**
     * Set the hp of the heron
     */
    void setHp();

    /**
     * Returns true if the entity is active (and hence shouldn't be deleted).
     * @return the cloned level
     */
    Level clone();

    /**
     * Return the moving entity list
     * @return the moving entities in this level
     */
    List<MovingEntity> getMoving();


    /**
     * Return the hero
     * @return the hero entity
     */
    StickMan getHero();

    /**
     * Set the stickman
     */
    void setStickMan(StickMan stickMan);

    /**
     * Set the reload indicator ofthe level
     */
    void setReload();
}
