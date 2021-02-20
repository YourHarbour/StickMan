package stickman.Memento;

import java.util.ArrayList;
import java.util.List;
/**
 * Keeper of the memento
 */
public class CareTaker {

    /**
     * used for record the only memento as the requirement
     */
    private Memento memento;

    public void setMemento(Memento memento){
        this.memento = memento;
    }

    public Memento getMemento(){
        return this.memento;
    }


}
