package NikandrovLab5.data;

import java.io.Serializable;

public enum StandardOfLiving implements Serializable {
    VERY_HIGH,
    LOW,
    VERY_LOW,
    NIGHTMARE;

    public static boolean isPresent(String data) {
        try {
            StandardOfLiving.valueOf(data);
            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
