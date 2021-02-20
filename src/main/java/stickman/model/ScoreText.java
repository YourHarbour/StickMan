package stickman.model;

import javafx.scene.text.Text;
/**
 * This class used for control the display and the score of the user
 */
public class ScoreText implements TextObserver{

    /**
     * Score record all the scores owned
     */
    private int score;

    private int totalScore;
    /**
     * Text object to show in pane
     */
    private Text scoreText;
    private Text totalScoreText;

    public ScoreText(){
        this.score = 0;
        this.totalScore = 0;
        this.scoreText = new Text(String.valueOf(score));
        this.scoreText.setX(600);
        this.scoreText.setY(45);
        this.totalScoreText = new Text(String.valueOf(totalScore));
        this.totalScoreText.setX(600);
        this.totalScoreText.setY(60);
    }

    /**
     * When kill the slime, the score + 100
     */
    public void killSlime(){
        this.score+=100;
        this.totalScore+=100;
        upDate();
    }

    /**
     * When touch the mushroom, score + 50
     */
    public void touchMushroom(){
        this.score+=50;
        this.totalScore+=50;
        upDate();
    }

    /**
     * When the time of user use to pass the level over recommend time, the score --
     */
    public void overRecommendTime(int time){
        this.score-=time;
        this.totalScore-=time;
        upDate();
    }

    /**
     * When the time of user use to pass the level less than recommend time, the score ++
     */
    public void lessTime(int time){
        this.score+=time;
        this.totalScore+=time;
        upDate();
    }

    /**
     * Update the display value
     */
    @Override
    public void upDate(){
        if(this.score < 0){
            this.score = 0;
        }
        if(this.totalScore < 0){
            this.totalScore = 0;
        }
        this.scoreText.setText(String.valueOf(score));
        this.totalScoreText.setText(String.valueOf(totalScore));
    }

    /**
     * get the score now
     */
    public int getScore(){
        return this.score;
    }

    /**
     * get the total score
     */
    public int getTotalScore() {
        return totalScore;
    }

    /**
     * get the text to add to pane
     */
    public Text getScoreText() {
        return scoreText;
    }

    /**
     * Get the text object
     */
    public Text getTotalScoreText() {
        return totalScoreText;
    }

    /**
     * Set the score, for reload use
     */
    public void setScore(int score){
        this.score = score;
        upDate();
    }

    /**
     * Set the total score, used for reload
     */
    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
        upDate();
    }

    @Override
    protected ScoreText clone() throws CloneNotSupportedException {
        return (ScoreText) super.clone();
    }
}
