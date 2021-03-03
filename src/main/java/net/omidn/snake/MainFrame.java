package net.omidn.snake;

import java.util.ArrayList;
import java.util.List;

public class MainFrame {
    public int width, height;
    public List<Spirit> spiritList;
    private String[][] raster;


    public MainFrame(int width, int height) {
        if (width < 1 || height < 1)
            throw new IllegalArgumentException("Dimensions cannot be negative!");
        this.width = width;
        this.height = height;
        spiritList = new ArrayList<>();
        //drawing the border of frame
        raster = new String[height + 2][width + 2];
    }
}
