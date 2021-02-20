package stickman.level;

import stickman.entity.still.Win;
import stickman.model.GameEngine;

/**
 * This class used for control the whole level transaction logic
 */
public class LevelFacade {

    //Record the current level number
    private static int num = 0;

    /**
     * detect the time user use to pass the level and control the score
     */
    private static void detectTimeOver(GameEngine gameEngine){
        if(gameEngine.getTimeText().getTime() > Integer.parseInt(gameEngine.getRecommendTimeText().getText())){
            gameEngine.getScoreText().overRecommendTime(gameEngine.getTimeText().getTime()/120 - Integer.parseInt(gameEngine.getRecommendTimeText().getText()));
        }else if(gameEngine.getTimeText().getTime()/120 < Integer.parseInt(gameEngine.getRecommendTimeText().getText())){
            gameEngine.getScoreText().lessTime(Integer.parseInt(gameEngine.getRecommendTimeText().getText()) - gameEngine.getTimeText().getTime()/120);
        }
    }

    /**
     * Switch to new Level or show the win screen
     */
    public static void getNextLevel(LevelManager level, GameEngine gameEngine){
        if(num + 1 != gameEngine.getFileNames().size()){
            num++;
            detectTimeOver(gameEngine);
            int score = gameEngine.getScoreText().getTotalScore();
            System.out.println(score);
            gameEngine.nextLevel(LevelBuilderImpl.generateFromFile(gameEngine.getFileNames().get(num),gameEngine));
            gameEngine.getTimeText().reSetNum();
            gameEngine.getRecommendTimeText().setText(String.valueOf(gameEngine.getCurrentLevel().getRecommendTime()));
            gameEngine.getScoreText().setScore(0);
            gameEngine.getScoreText().setTotalScore(score);

//            gameEngine.reset();
        }else{
            detectTimeOver(gameEngine);
            level.setActive(false);
            level.getEntities().add(new Win(level.getHeroX() - 200, level.getHeroY() - 200));
        }
    }

    /**
     * Set the number which indicates the current level
     */
    public static void setNum(int i){
        num = i;
    }

    /**
     * Get the number which indicates the current level
     */
    public static int getNum(){
        return num;
    }


}
