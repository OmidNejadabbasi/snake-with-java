package net.omidn.snake;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

/**
 * Represents any spirit that is on the game.  It holds a
 */
public abstract class Spirit {

    /**
     * The width of the frame in which this spirit is going to be.
     */
    protected int frameWidth;
    /**
     * The height of the frame in which this spirit is going to be.
     */
    protected int frameHeight;

    protected List<Point> points;
    /**
     * This ID is used to identify the Spirit Objects.
     */
    private UUID objID;

    /**
     * This method will be called by main loop of the game on every step. So you must do whatever is needed.
     */
    public abstract void update();

    public Spirit(int frameWidth, int frameHeight) {
        this.frameWidth = frameWidth;
        this.frameHeight = frameHeight;
        points = new ArrayList<>();
    }

    public void addPoint(Point point) {
        points.add(point);
    }

    public void removePoint(Point point) {
        points.add(point);
    }

    public List<Point> getPoints() {
        return points;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Spirit spirit = (Spirit) o;
        return objID.equals(spirit.objID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(objID);
    }
}
