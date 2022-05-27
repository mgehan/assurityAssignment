package common;

public class SystemUtils {

    public static String getProperty(String name, String defaultValue) {
        return System.getProperty(name, defaultValue);
    }

    private SystemUtils() {
    }
}
