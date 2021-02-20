package stickman.entity.still;

import stickman.entity.Entity;
import stickman.entity.GameObject;

public class GameOver extends GameObject {
    /**
     * Constructs a GameObject object.
     *
     * @param x         The x-coordinate.
     * @param y         The y-coordinate.
     */

    public GameOver(double x, double y) {
        super("gameover.jpeg", x, y, 640, 400, Layer.EFFECT);
    }

    @Override
    public boolean isSolid() {
        return false;
    }

    @Override
    public Entity clone() {
        return null;
    }
}
