package net.omidn.snake;

public class Snake extends Spirit{

    /**
     * The Point object of the head
     */
    public Point head;
    /**
     * The Point object of the tail
     */
    public Point tail;

    private static final char CHAR = '0';
    private Color color = Color.CYAN;

    public Snake(int frameWidth, int frameHeight) {
        super(frameWidth, frameHeight);
        points.add(head = new Point(frameWidth / 2, frameHeight / 2 + 3, '❥', color));
        points.add(new Point(frameWidth / 2, frameHeight / 2 + 2, CHAR, color));
        points.add(new Point(frameWidth / 2, frameHeight / 2 + 1, CHAR, color));
        points.add(tail = new Point(frameWidth / 2, frameHeight / 2, CHAR, color));
    }

    @Override
    public void update() {

    }
}
