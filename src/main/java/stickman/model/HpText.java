package stickman.model;

import javafx.scene.text.Text;

/**
 * This class used for control the display and the hp of the hero
 */
public class HpText  implements TextObserver{

    /**
     * The hp which for all levels
     */
    private int hp;

    /**
     * Text for show the hp in pane
     */
    private Text hpText;

    public HpText(){
        //intital hp 0, change after read the configure file
        this.hp = 0;
        //new Text show the hp
        this.hpText = new Text(String.valueOf(hp));
        this.hpText.setX(600);
        this.hpText.setY(75);
    }

    /**
     * Reduce the hp by 1, this happened if slime touches hero
     */
    public void getHurt(){
        this.hp--;
        upDate();
    }

    /**
     * Get the current hp of the hero
     */
    public int getHp(){
       return this.hp;
    }

    /**
     * Set the hp, used for reload
     */
    public void setHp(int hp){
        this.hp = hp;
        upDate();
    }

    /**
     * Get the HpText to add to the pane
     */
    public Text getHpText(){
        return this.hpText;
    }

    /**
     * Update the text display value
     */
    @Override
    public void upDate(){
        this.hpText.setText(String.valueOf(this.hp));
    }

    @Override
    protected HpText clone() throws CloneNotSupportedException {
        return (HpText) super.clone();
    }
}
