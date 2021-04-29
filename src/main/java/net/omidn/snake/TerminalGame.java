package net.omidn.snake;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class TerminalGame {
    /**
     * List of functions that accepts a code of pressed keys and does something
     */
    public static List<Consumer<Integer>> actionHandlers = new ArrayList<>();
    /**
     * Used for terminating the program
     */
    public static boolean running = true;


    public static int frameRate = 100;

    public static void main(String[] args) throws InterruptedException {

        new Thread(() -> {
            try {
                while (running) {
                    Thread.sleep(frameRate);
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


        int screenWidth = 60;
        int screenHeight = 22;
        MainFrame mainFrame = new MainFrame(screenWidth, screenHeight);
        Snake snake = new Snake(screenWidth, screenHeight);
        Bait bait = new Bait(screenWidth, screenHeight);
        mainFrame.addSpirit(snake);
        mainFrame.addSpirit(bait);

        addActionHandler(key -> {
            if (key == 3) {
                running = false;
            }
        });

        addActionHandler(key -> {
            switch (key) {
                case (int) 'A':
                case (int) 'a':
                    if (snake.queryChangeDirection(3))
                        frameRate = 100;
                    break;
                case (int) 'S':
                case (int) 's':
                    if (snake.queryChangeDirection(2))
                        frameRate = 180;
                    break;

                case (int) 'D':
                case (int) 'd':
                    if (snake.queryChangeDirection(1))
                        frameRate = 100;
                    break;
                case (int) 'W':
                case (int) 'w':
                    if (snake.queryChangeDirection(0))
                        frameRate = 180;
                    break;
            }
        });


        running = true;
        while (running) {
            snake.collision(bait);
            Thread.sleep(frameRate);
            TerminalUtils.clearFromCellToEndOfScreen(3, 0);
            System.out.print(mainFrame.printable());
            mainFrame.update();
        }

    }

    public static void addActionHandler(Consumer<Integer> actionHandler) {
        actionHandlers.add(actionHandler);
    }

}
