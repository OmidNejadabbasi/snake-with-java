package net.omidn.snake;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class TerminalGame
{
    /**
     * List of functions that accepts a code of pressed keys and does something
     */
    public static List<Consumer<Integer>> actionHandlers = new ArrayList<>();
    /**
     * Used for terminating the program
     */
    public static boolean running = true;

    public static void main( String[] args )
    {

        new Thread(() -> {
            try {
                while (running) {
                    Thread.sleep(80);
                    int a = RawConsoleInput.read(false);
                    actionHandlers.forEach(func -> func.accept(a));
                }
            } catch (InterruptedException | IOException e) {
                e.printStackTrace();
            }

        }).start();


        TerminalUtils.clearScreen();
        TerminalUtils.cursorBlinkOff();
        System.out.println("Press WASD keys to move around.");
        System.out.println("Press P to pause and resume.");



        MainFrame mainFrame = new MainFrame(60, 22);
        Snake snake = new Snake(60, 22);
        mainFrame.addSpirit(snake);

        addActionHandler(key -> {
            if(key == 3){
                running = false;
            }
        });

    }

    public static void addActionHandler(Consumer<Integer> actionHandler) {
        actionHandlers.add(actionHandler);
    }

}
