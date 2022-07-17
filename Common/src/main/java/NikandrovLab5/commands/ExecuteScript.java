package NikandrovLab5.commands;

import NikandrovLab5.utility.Collection;
import NikandrovLab5.utility.TextFormatting;
import src.ServerMessage;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class ExecuteScript {
    public int checkingTheCycle(String path, Operations paths, ServerMessage answer) {
        for (String temporary : paths.paths) {
            if (temporary.equals(path)) {
                answer.plusMessage("In your file with the path: \"" +
                        paths.paths.get(paths.paths.size() - 1) + "\" there is a call to the file that was called before" + '\n');
                paths.paths.clear();
                return 2;
            }
        }
        paths.paths.add(path);
        return 0;
    }

    public int check(String[] concatenation, Collection collection, FileReader file, Operations operations,
                     String environmentVariable, ServerMessage answer) {
        if (concatenation[0].equals("insert") & concatenation.length == 2) {
            try {
                if (!concatenation[1].contains(",")) {
                    FileOutput.insert(collection, concatenation[1], file);
                }
            } catch (IOException ignored) {

            }
        } else if (concatenation[0].equals("update") & concatenation.length == 2) {
            try {
                FileOutput.updateId(collection.collection, Integer.parseInt(concatenation[1]), file);
            } catch (NumberFormatException | IOException ignored) {

            }
        } else {
            int result = operations.run(concatenation, collection, environmentVariable, answer, operations);
            if (result == 2 | result == 3) {
                return 2;
            }
        }
        return 0;
    }

    public int executeScript(String path, Collection collection, Operations operations, String environmentVariable, ServerMessage answer) {
        try {
            File checkFile = new File(path);
            if (!checkFile.canRead()) {
                answer.plusMessage("There is no access to read the file with the path " + path + '\n');
                return 2;
            }
            FileReader file = new FileReader(path);
            String string = "";
            String[] concatenation;
            while (file.ready()) {
                char c = (char) file.read();
                if (c == '\n') {
                    concatenation = string.toLowerCase().trim().split(" ");
                    int result = 0;
                    if (!concatenation[0].equals("")) {
                        result = check(concatenation, collection, file, operations, environmentVariable, answer);
                    }
                    if (result == 2 | result == 3) {
                        return 2;
                    }
                    string = "";
                } else {
                    string += String.valueOf(c);
                }
            }
            int result = 0;
            if (!string.equals("")) {
                result = check(string.toLowerCase().trim().split(" "), collection, file, operations, environmentVariable, answer);
            }
            file.close();
            return result;
        } catch (IOException e) {
            answer.plusMessage("Invalid path" + '\n');
        }
        return 0;
    }
}
