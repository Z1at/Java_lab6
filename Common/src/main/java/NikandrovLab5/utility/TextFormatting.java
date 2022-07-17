package NikandrovLab5.utility;

/**
 * Class for format text for highlight errors and informational messages
 */
public class TextFormatting {

    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_RED = "\u001B[31m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_BLUE = "\u001B[34m";
    private static final String ANSI_YELLOW = "\u001B[33m";

    public static String getRedText(String text) {
        return ANSI_RED + text + ANSI_RESET;
    }

    public static String getGreenText(String text) {
        return ANSI_GREEN + text + ANSI_RESET;
    }

    public static String getBlueText(String text) {
        return ANSI_BLUE + text + ANSI_RESET;
    }

    public static String getYellowText(String text) {
        return ANSI_YELLOW + text + ANSI_RESET;
    }
}