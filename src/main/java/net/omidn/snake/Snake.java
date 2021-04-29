package net.omidn.snake;

public class Snake extends Spirit {

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
    private boolean growPending = false;
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

        Point newP = new Point(headX, headY, CHAR, color);
        points.add(1, newP);


        if (!growPending)
            points.remove(length);
        tail = points.get(length - 1);
        pendingDirChange = false;
        growPending = false;
    }

    /**
     * Tries to change the direction of the snake.
     * @param newDir 0 -> up, 1 -> right, 2 -> down, 3 -> left
     */
    public boolean queryChangeDirection(int newDir) {
        if (pendingDirChange)
            return false;
        newDir %= 4;

        if (direction == 1 || direction == 3) {
            if (newDir == 0 || newDir == 2) {
                pendingDirChange = true;
                direction = newDir;
                return true;
            }
        } else if (direction == 2 || direction == 0) {
            if (newDir == 1 || newDir == 3) {
                pendingDirChange = true;
                direction = newDir;
                return true;
            }
        }
        return false;
    }

    public void collision(Bait bait) {
        if (head.equals(bait.getPoint())) {
            if (!growPending) {
                length++;
                growPending = true;
                bait.toNewPosition();
            }
        }
    }

}
