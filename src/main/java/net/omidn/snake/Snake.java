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

    /**
     * The direction of the snake
     */
    public int direction = 1;
    private boolean pendingDirChange = false;
    private int length = 4;

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
        int headX = head.x, headY = head.y;

        switch (direction) {
            case 0:
                head.y = (head.y - 1 + frameHeight) % frameHeight;
                break;

            case 1:
                head.x = (head.x + 1 + frameWidth) % frameWidth;
                break;

            case 2:
                head.y = (head.y + 1 + frameHeight) % frameHeight;
                break;

            case 3:
                head.x = (head.x - 1 + frameWidth) % frameWidth;
                break;
        }

        points.add(1, tail);
        tail.x = headX;
        tail.y = headY;

        points.remove(length);
        tail = points.get(length - 1);
    }
}
