package net.omidn.snake;

public class TerminalGame
{
    public static void main( String[] args )
    {

        TerminalUtils.clearScreen();
        TerminalUtils.cursorBlinkOff();
        System.out.println("Press WASD keys to move around.");
        System.out.println("Press P to pause and resume.");

    }
}
