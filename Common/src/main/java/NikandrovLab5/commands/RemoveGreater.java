package NikandrovLab5.commands;

import NikandrovLab5.utility.Collection;

public class RemoveGreater {
    public void removeGreater(Collection collection, String key) {
        RemoveGreaterKey removeGreaterKey = new RemoveGreaterKey();
        removeGreaterKey.removeGreaterKey(key, collection);
    }
}
