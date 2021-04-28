package net.omidn.snake;

public class Bait extends Spirit {

    private static Color color = Color.RED;
    private Point point;

    public Bait(int frameWidth, int frameHeight) {
        super(frameWidth, frameHeight);
        points.add(point = new Point(1, 1, '#', color));
    }

    @Override
    public void update() {
        // empty
    }

    public Point getPoint() {
        return point;
    }
}
