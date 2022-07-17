package NikandrovLab5.commands;

import NikandrovLab5.utility.Collection;
import NikandrovLab5.utility.TextFormatting;

public class GetInfo {
    public String getInfo(Collection collection, String initTime) {
        return "Information about collection: \n" + "Type of collection: " + "LinkedHashMap" + "\n" +
                "Type of collection items: " + "Cities" + "\n" +
                "Initialization date: " + initTime + "\n" +
                "Number of items in the collection: " + collection.collection.size() + '\n' + '\n';
    }
}
