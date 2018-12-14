package pl.edu.agh.visca.cli;

public class Logger {

    public static boolean loggingEnabled = true;

    public static void info(String template, Object... args) {
        if (loggingEnabled)
            System.out.println("LOGGER [info]: " + String.format(template, args));
    }
}
