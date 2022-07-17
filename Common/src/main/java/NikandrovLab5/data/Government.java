package NikandrovLab5.data;

import java.io.Serializable;

public enum Government implements Serializable {
    CORPORATOCRACY,
    MATRIARCHY,
    OLIGARCHY,
    TIMOCRACY;

    public static boolean isPresent(String data) {
        try {
            Government.valueOf(data);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
