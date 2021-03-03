package net.omidn.snake;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Represents any spirit that is on the game.  It holds a
 */
public abstract class Spirit {

    protected List<Point> points;
    /**
     * This method will be called by main loop of the game on every step. So you must do whatever is needed.
     */
    public abstract void update();

    public Spirit(){
        points = new ArrayList<>();
    }

    public void addPoint(Point point){
        points.add(point);
    }

    public void removePoint(Point point){
        points.add(point);
    }

    public List<Point> getPoints() {
        return points;
    }

}
