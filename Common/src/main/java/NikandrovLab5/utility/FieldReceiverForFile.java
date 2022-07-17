package NikandrovLab5.utility;

import NikandrovLab5.data.*;

import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;

/**
 * Class is used to receive fields from files
 */
public class FieldReceiverForFile {
    public static String getName(FileReader file) throws IOException {
        while (file.ready()) {
            String[] name = getLine(file).toLowerCase().trim().split(" ");
            if (name.length == 1 & !name[0].contains(",")) {
                return name[0];
            }
        }
        return null;
    }

    public static Coordinates getCoordinates(FileReader file) throws IOException {
        while (file.ready()) {
            String[] coordinates = getLine(file).toLowerCase().trim().split(" ");
            if (coordinates.length == 2) {
                try {
                    return (new Coordinates(Float.parseFloat(coordinates[0]), Long.parseLong(coordinates[1])));
                } catch (NumberFormatException ignored) {

                }
            }
        }
        return new Coordinates((float) -1, (long) -1);
    }

    public static double getArea(FileReader file) throws IOException {
        while (file.ready()) {
            String[] area = getLine(file).toLowerCase().trim().split(" ");
            if (area.length == 1) {
                try {
                    double number = Double.parseDouble(area[0]);
                    if (number > 0) {
                        return number;
                    }
                } catch (NumberFormatException ignored) {

                }
            }
        }
        return -1;
    }

    public static Long getPopulation(FileReader file) throws IOException {
        while (file.ready()) {
            String[] population = getLine(file).toLowerCase().trim().split(" ");
            if (population.length == 1) {
                try {
                    long number = Long.parseLong(population[0]);
                    if (number > 0) {
                        return number;
                    }
                } catch (NumberFormatException ignored) {

                }
            }
        }
        return (long) -1;
    }

    public static Integer getMetersAboveSeaLevel(FileReader file) throws IOException {
        while (file.ready()) {
            String[] metersAboveSeaLevel = getLine(file).toLowerCase().trim().split(" ");
            if (metersAboveSeaLevel.length == 1) {
                try {
                    return Integer.parseInt(metersAboveSeaLevel[0]);
                } catch (NumberFormatException ignored) {

                }
            }
        }
        return null;
    }

    public static Climate getClimate(FileReader file) throws IOException {
        while (file.ready()) {
            String[] climate = getLine(file).toUpperCase().trim().split(" ");
            if (climate.length == 1 & Climate.isPresent(climate[0])) {
                return Climate.valueOf(climate[0]);
            }
        }
        return null;
    }

    public static Government getGovernment(FileReader file) throws IOException {
        while (file.ready()) {
            String[] government = getLine(file).toUpperCase().trim().split(" ");
            if (government.length == 1 & Government.isPresent(government[0])) {
                return Government.valueOf(government[0]);
            }
        }
        return null;
    }

    public static StandardOfLiving getStandardOfLiving(FileReader file) throws IOException {
        while (file.ready()) {
            String[] standardOfLiving = getLine(file).toUpperCase().trim().split(" ");
            if (standardOfLiving.length == 1 & StandardOfLiving.isPresent(standardOfLiving[0])) {
                return StandardOfLiving.valueOf(standardOfLiving[0]);
            }
        }
        return null;
    }

    public static Human getGovernor(FileReader file) throws IOException {
        String name = "";
        double number = -1;
        while (file.ready()) {
            String[] array = getLine(file).toLowerCase().trim().split(" ");
            if (array.length == 1 & !array[0].contains(",")) {
                name = array[0];
                break;
            }
        }
        while (file.ready()) {
            String[] height = getLine(file).trim().split(" ");
            if (height.length == 1) {
                try {
                    number = Double.parseDouble(height[0]);
                    if (number > 0) {
                        break;
                    }
                } catch (NumberFormatException ignored) {

                }
            }
        }
        while (file.ready()) {
            String birthday = getLine(file).trim();
            try {
                return new Human(name, number, LocalDate.parse(birthday));
            } catch (Exception ignored) {

            }
        }
        return null;
    }

    private static String getLine(FileReader file) throws IOException {
        String string = "";
        while (file.ready()) {
            char c = (char) file.read();
            if (c == '\n') {
                break;
            }
            string += c;
        }
        return string;
    }
}
