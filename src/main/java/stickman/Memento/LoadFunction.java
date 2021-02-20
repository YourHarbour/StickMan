package stickman.Memento;

import stickman.entity.Entity;
import stickman.entity.moving.enemy.Slime;
import stickman.level.LevelBuilderImpl;
import stickman.level.LevelFacade;
import stickman.model.GameEngine;
/**
 * this function used for when user pressed save or load key, the all save or reload process finished here
*/
public class LoadFunction {

    /**
     * reload function here
     */
    public static void load(GameEngine model){
        LevelFacade.setNum(model.getCareTaker().getMemento().getNumOfLevel());
        model.setLevel(LevelBuilderImpl.generateFromFile(model.getCareTaker().getMemento().getLevel().getSource(),model));
        model.getCurrentLevel().getHero().setX(model.getCareTaker().getMemento().getStickMan().getXPos());
        model.getCurrentLevel().getHero().setY(model.getCareTaker().getMemento().getStickMan().getYPos());
        if(model.getCareTaker().getMemento().getStickMan().isUpgraded()){
            model.getCurrentLevel().getHero().upgrade();
        }
        model.getHpText().setHp(model.getCareTaker().getMemento().getHp());
        model.getScoreText().setScore(model.getCareTaker().getMemento().getScore());
        model.getScoreText().setTotalScore(model.getCareTaker().getMemento().getTotalScore());
        model.getTimeText().setTime(model.getCareTaker().getMemento().getTime());
        for(Entity entity:model.getCurrentLevel().getEntities()){
            if(entity.getClass().getName().equals("stickman.entity.moving.enemy.Slime")){
                boolean isAlive = true;
                for(Entity entity1:model.getCareTaker().getMemento().getEntityList()){
                    if(entity.getImagePath().equals(entity1.getImagePath())){
                        isAlive = true;
                        Slime slime = (Slime) entity;
                        slime.setLeft(((Slime) entity1).isLeft());
                        break;
                    }else{
                        isAlive = false;
                    }
                }
                if(!isAlive){
                    entity.setActive(false);
                }
            }else if(entity.getClass().getName().equals("stickman.entity.still.Mushroom")){
                boolean isAlive = true;
                for(Entity entity1:model.getCareTaker().getMemento().getEntityList()){
                    if(entity.getImagePath().equals(entity1.getImagePath())){
                        isAlive = true;
                        break;
                    }else{
                        isAlive = false;
                    }
                }
                if(!isAlive){
                    entity.setActive(false);
                }
            }
        }
        model.getCurrentLevel().setReload();
    }

    /**
     * save function here
     */
    public static void save(GameEngine model){
        model.getCareTaker().setMemento(new Memento(model.getCurrentLevel(),model));
    }
}
