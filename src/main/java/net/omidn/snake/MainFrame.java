package net.omidn.snake;

import java.util.ArrayList;
import java.util.Arrays;
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

        resetRaster();

    }

    private void resetRaster() {
        //filling it with spaces.
        for (String[] r : raster) {
            Arrays.fill(r, " ");
        }
        raster[0][0] = "┌";
        raster[0][width + 1] = "┐";
        raster[height + 1][0] = "└";
        raster[height + 1][width + 1] = "┘";
        for (int i = 1; i < width + 1; i++) {
            raster[0][i] = raster[height + 1][i] = "─";
        }
        for (int i = 1; i < height + 1; i++) {
            raster[i][0] = raster[i][width + 1] = "│";
        }
    }


    /**
     * This method will be called on every step of the game loop.
     */
    public void update() {
        spiritList.forEach(Spirit::update);
        // Updating the raster:
        resetRaster();
        spiritList.forEach(spirit -> {
            spirit.getPoints().forEach(point -> {
                try {
                    raster[point.y + 1][point.x + 1] = point.toString();
                }catch (Exception e){}
            });
        });

    }

    public void addSpirit(Spirit s) {
        spiritList.add(s);
    }

    public void killSpirit(Spirit s) {
        spiritList.remove(s);
    }



    public String printable(){
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < raster.length; i++) {
            for (int j = 0; j < raster[0].length; j++) {
                sb.append(raster[i][j]);
            }
            sb.append('\n');
        }
        return sb.toString();
    }


}
