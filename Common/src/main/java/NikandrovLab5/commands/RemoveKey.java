package NikandrovLab5.commands;

import NikandrovLab5.utility.TextFormatting;
import NikandrovLab5.utility.Collection;

public class RemoveKey {
    public void removeKey(String key, Collection collection) {
        int len = collection.collection.size();
        collection.collection.remove(key);
    }
}
