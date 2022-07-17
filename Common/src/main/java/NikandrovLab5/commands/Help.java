package NikandrovLab5.commands;

import NikandrovLab5.utility.TextFormatting;

import java.util.HashMap;
import java.util.Map;

/**
 * Class for displaying all commands with explanations
 */
public class Help {
    public static Map<String, String> vocabulary = new HashMap<>();

    /**
     * Class constructor
     *
     * @param size - If this method has been called at least once, then this variable will not be equal to 0,
     *             and we will not create the entire dictionary again
     */
    public static void create(int size) {
        if (size != 0) return;
        vocabulary.put("info", "Displays information about the collection");
        vocabulary.put("show", "Outputs all the elements of the collection");
        vocabulary.put("insert (name_of_key)", "Adds a new element with the specified key");
        vocabulary.put("update (id)", "Updates the values of a collection item by the specified id");
        vocabulary.put("remove_key (key)", "Deletes an item from the collection by its key");
        vocabulary.put("clear", "Clears the collection");
        vocabulary.put("execute_script (the path to the file with the extension)", "Reads and executes a script from a file");
        vocabulary.put("exit", "Terminates the program without saving");
        vocabulary.put("remove_greater (element)", "remove all items from the collection that exceed the specified");
        vocabulary.put("remove_lower (element)", "remove all items smaller than the specified one from the collection");
        vocabulary.put("remove_greater_key (key)", "remove from the collection all items whose key exceeds the specified one");
        vocabulary.put("remove_any_by_governor (name, height and date of birthday of governor)", "remove one element from the collection"
                + " whose value of the governor field is equivalent to the specified one");
        vocabulary.put("count_less_than_government (government)", "outputs the number of elements" +
                " whose value of the government field is less than the specified one");
        vocabulary.put("count_greater_than_government (government)", "outputs the number of elements" +
                " whose value of the government field is greater than the specified one");
    }

    /**
     * Method for output of all commands
     */
    public static String help() {
        String res = "";
        for(String key : vocabulary.keySet()){
            res += (key + " - " + vocabulary.get(key)) + "\n";
        }
        return res + '\n';
    }
}
