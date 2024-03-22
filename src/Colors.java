public class Colors{
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_PURPLE = "\u001B[35m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_WHITE = "\u001B[37m";
    public Colors(){

    }

    public static String getAnsiReset(){
        return ANSI_RESET;
    }
    public static String getAnsiRed(){
        return ANSI_RED;
    }
    public static String getAnsiGreen(){
        return ANSI_GREEN;
    }
    public static String getAnsiYellow(){
        return ANSI_YELLOW;
    }
    public static String getAnsiBlue(){
        return ANSI_BLUE;
    }
    public static String getAnsiPurple(){
        return ANSI_PURPLE;
    }
    public static String getAnsiCyan(){
        return ANSI_CYAN;
    }
    public static String getAnsiWhite(){
        return ANSI_WHITE;
    }
}
