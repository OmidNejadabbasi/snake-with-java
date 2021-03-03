package net.omidn.snake;

import java.io.IOException;

public class TerminalUtils {

    /**
     * It is equal to true if we are running on Microsoft Windows.
     */
    public static boolean isWindows = System.getProperty("os.name").toLowerCase().contains("windows");


    /**
     * Tries to clear the screen system independently. NOT test on Windows yet!
     */
    public static void clearScreen() {
        if (isWindows) {
            try {
                Runtime.getRuntime().exec("cls");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            clearFromCellToEndOfScreen(0, 0);
        }
    }


    /**
     * Clears the screen form line number {@code line} and column number {@code column}.
     */
    public static void clearFromCellToEndOfScreen(int line, int column) {
        System.out.printf("\033[%d;%dH\033[J", line, column);
    }

    /**
     * Sets the cursor of terminal to blink-off mode.
     */
    public static void cursorBlinkOff() {
        System.out.print("\033[?25l");
    }


    /**
     * Reads a raw key input from the input but does not block the program. If there is no character present, it returns -2.
     *
     */
    public static char readKey() {
        char c = '\0';
        try {
            c = (char) RawConsoleInput.read(true);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return c;
    }


}
