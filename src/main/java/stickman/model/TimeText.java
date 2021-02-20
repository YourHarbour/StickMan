package stickman.model;

import javafx.scene.text.Text;
/**
 * This class used for control the display and the time
 */
public class TimeText implements TextObserver{
    /**
     * num used for recording the time
     */
    private int time = 0;
    /**
     * the text to show in pane
     */
    private Text timeText;

    public TimeText(){
        this.timeText = new Text("");
        this.timeText.setX(600);
        this.timeText.setY(15);
    }

    /**
     * Update the time and display
     */
    @Override
    public void upDate(){
        this.time++;
        setTimeText();
    }

    /**
     * reset the time
     */
    public void reSetNum(){
        this.time = 0;
    }

    /**
     * set the time to text
     */
    private void setTimeText(){
        this.timeText.setText(String.valueOf(this.time/120));
    }

    /**
     * Get the text object to ad to pane
     */
    public Text getTimeText(){
        return this.timeText;
    }

    /**
     * get time
     */
    public int getTime(){
        return this.time;
    }

    /**
     * set time, for reload use
     */
    public void setTime(int time) {
        this.time = time;
        setTimeText();
    }


    @Override
    protected TimeText clone() throws CloneNotSupportedException {
        return (TimeText) super.clone();
    }
}
