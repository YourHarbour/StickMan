package stickman.Memento;

import stickman.entity.Entity;
import stickman.entity.Interactable;
import stickman.entity.moving.MovingEntity;
import stickman.entity.moving.other.Projectile;
import stickman.entity.moving.player.StickMan;
import stickman.level.Level;
import stickman.level.LevelFacade;
import stickman.model.GameEngine;

import java.util.ArrayList;
import java.util.List;

/**
 * The Memento which store the status
 */
public class Memento {


    private List<Entity> entityList = new ArrayList<>();
    private Level level;
    private StickMan stickMan;
    private int hp;
    private int score;
    private int time;
    private int numOfLevel;
    private int totalScore;
    private List<Entity> projectiles = new ArrayList<>();

    /**
     * Creates a new memento object.
     * @param level The recorded Level
     * @param gameEngine The recorded gameEngine
     */
    public Memento(Level level, GameEngine gameEngine){
        this.numOfLevel = LevelFacade.getNum();
        this.level = level.clone();
        this.stickMan = (StickMan) level.getHero().clone();
        for(Entity entity:level.getEntities()){
            this.entityList.add(entity.clone());
        }
        this.totalScore = gameEngine.getScoreText().getTotalScore();
        this.hp = gameEngine.getHpText().getHp();
        this.score = gameEngine.getScoreText().getScore();
        this.time = gameEngine.getTimeText().getTime();
    }

    /**
     * Get the Hp of the saved state
     * @return hp
     */
    public int getHp() {
        return this.hp;
    }

    /**
     * Get the Level of saved state.
     * @return Level
     */
    public Level getLevel() {
        return level;
    }

    /**
     * Get the EntityList of saved state
     * @return List of entities
     */
    public List<Entity> getEntityList(){
        return this.entityList;
    }

    /**
     * Get the hero of saved state
     * @return the recorded hero
     */
    public StickMan getStickMan() {
        return stickMan;
    }

    /**
     * Get the score of saved state
     * @return score
     */
    public int getScore() {
        return this.score;
    }

    /**
     * Get the time of saved state
     * @return time
     */
    public int getTime() {
        return this.time;
    }

    /**
     * Get the num which indicates the level of saved state
     * @return num of level
     */
    public int getNumOfLevel() {
        return numOfLevel;
    }

    /**
     * Get the total score which all player get
     * @return total score
     */
    public int getTotalScore() {
        return totalScore;
    }
}
