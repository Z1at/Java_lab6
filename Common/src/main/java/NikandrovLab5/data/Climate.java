package NikandrovLab5.data;

import java.io.Serializable;

public enum Climate implements Serializable {
    RAIN_FOREST,
    TROPICAL_SAVANNA,
    STEPPE,
    DESERT;

    public static boolean isPresent(String data) {
        try {
            Climate.valueOf(data);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
