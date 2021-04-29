package net.omidn.snake;

import java.util.Random;

public class Bait extends Spirit {

    private static Color color = Color.RED;
    private Point point;

    private Random random = new Random();

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

    public void toNewPosition() {
        point.x = random.nextInt(frameWidth);
        point.y = random.nextInt(frameHeight);
    }
}
