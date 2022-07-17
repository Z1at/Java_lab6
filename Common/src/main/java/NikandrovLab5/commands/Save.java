package NikandrovLab5.commands;

import NikandrovLab5.data.City;
import NikandrovLab5.utility.Collection;
import NikandrovLab5.utility.TextFormatting;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Save {
    public String save(String path, Collection collection) {
        try {
            File checkFile = new File(path);
            if (!checkFile.canWrite()) {
                return "There is no access to rewrite the file with the path of the environment variable " + path + '\n';
            }
            else {
                FileOutputStream file = new FileOutputStream(path);
                OutputStreamWriter writer = new OutputStreamWriter(file);
                writer.write("key" + ";" + "id" + ";" + "name" + ";" + "coordinates" + ";" + "creation date" + ";" +
                        "area" + ";" + "population" + ";" + "meters above sea level" + ";" + "climate" + ";" +
                        "government" + ";" + "standard of living" + ";" + "governor(name. height. birthday)" + "\n");
                for (String key : collection.collection.keySet()) {
                    City city = collection.collection.get(key);
                    writer.write(key + ';' + city.getId() + ";" + city.getName() + ";" + "(" + city.getCoordinates().getX()
                            + "; " + city.getCoordinates().getY() + ")" + ";" +
                            city.getCreationDate() + ";" + city.getArea() + ";" + city.getPopulation() + ";" +
                            city.getMetersAboveSeaLevel() + ";" + city.getClimate() + ";" + city.getGovernment() + ";" +
                            city.getStandardOfLiving() + ";" + city.getGovernor().getName() + ". " +
                            city.getGovernor().getHeight() + ". " + city.getGovernor().getBirthday() + "\n");
                }

                writer.close();
                return "The file was saved successfully" + '\n';
            }
        } catch (IOException exception) {
            return "If you have a file open with the path you specified, then close it and repeat the command" + '\n';
        }
    }
}
