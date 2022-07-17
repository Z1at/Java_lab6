package NikandrovLab5.commands;

import NikandrovLab5.utility.Collection;

public class Show {
    public String show(Collection collection) {
        if (collection.collection.size() == 0) {
            return "Collection is empty" + '\n';
        } else {
            String res = "All elements of the collection:" + '\n';
            for (String key : collection.collection.keySet()) {
                res += key + ":" + '\n';
                res += collection.collection.get(key).toString() + '\n';
            }
            return res;
        }
    }
}
