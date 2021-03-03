package net.omidn.snake;

public class Point {

    int x;
    int y;
    private char character;
    private Color color;

    public Point(int x, int y, char character) {
        this(x, y, character, Color.WHITE);
    }

    public Point(int x, int y, char character, Color color) {
        this.x = x;
        this.y = y;
        this.character = character;
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return color.code() + character + "\033[0m";
    }
}
