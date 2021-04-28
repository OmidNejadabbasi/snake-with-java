package net.omidn.snake;

public class TerminalGame
{
    public static void main( String[] args )
    {

        TerminalUtils.clearScreen();
        TerminalUtils.cursorBlinkOff();
        System.out.println("Press WASD keys to move around.");
        System.out.println("Press P to pause and resume.");



        MainFrame mainFrame = new MainFrame(60, 22);
        Snake snake = new Snake(60, 22);
        mainFrame.addSpirit(snake);

    }
}
