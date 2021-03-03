package net.omidn.snake;

/**
 * This enums contain csi sequences for turning on colored text on the terminal.
 */
public enum Color {

    BLACK("\033[30m"),
    RED("\033[31m"),
    GREEN("\033[32m"),
    YELLOW("\033[33m"),
    BLUE("\033[34m"),
    MAGENTA("\033[35m"),
    CYAN("\033[36m"),
    WHITE("\033[37m");



    private String csiSeq;

    Color(String csiSeq){
        this.csiSeq = csiSeq;
    }

    public String code(){
        return csiSeq;
    }

}
