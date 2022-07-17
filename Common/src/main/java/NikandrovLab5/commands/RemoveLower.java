package NikandrovLab5.commands;

import NikandrovLab5.utility.Collection;
import NikandrovLab5.utility.TextFormatting;

import java.util.Vector;

public class RemoveLower {
    public void removeLower(Collection collection, String key) {
        Vector<String> keys = new Vector<>();
        for (String temporary : collection.collection.keySet()) {
            if (temporary.compareTo(key) < 0) {
                keys.add(temporary);
            }
        }
        for (String temporary : keys) {
            collection.collection.remove(temporary);
        }
    }
}
