package NikandrovLab5.utility;

import NikandrovLab5.data.*;

import java.time.LocalDate;
import java.util.Scanner;

/**
 * Class is used to receive fields from console
 */
public class FieldReceiver {
    private static final Scanner scanner = new Scanner(System.in);

    public static String getName() {
        while (true) {
            System.out.println(TextFormatting.getGreenText("Enter the name of the city: "));
            String[] name = scanner.nextLine().trim().split(" ");
            if (name.length == 1 & !name[0].contains(",")) {
                return name[0];
            }
            System.out.println(TextFormatting.getRedText("Wrong name, enter again (the name cannot contain commas):"));
        }
    }

    public static Coordinates getCoordinates() {
        System.out.println(TextFormatting.getGreenText("Enter the coordinates of the city (decimal(Through a point) and integer numbers): "));
        while (true) {
            String[] string = scanner.nextLine().trim().split(" ");
            if (string.length == 2) {
                try {
                    return new Coordinates(Float.parseFloat(string[0]), Long.parseLong(string[1]));
                } catch (NumberFormatException ignored) {

                }
            }
            System.out.println(TextFormatting.getRedText("You entered the wrong coordinates, enter again: "));
        }
    }

    public static double getArea() {
        System.out.println(TextFormatting.getGreenText("Enter the area of the city(integer number, must be greater than zero): "));
        while (true) {
            String[] string = scanner.nextLine().trim().split(" ");
            if (string.length == 1) {
                try {
                    double number = Double.parseDouble(string[0]);
                    if (number > 0) return number;
                } catch (NumberFormatException ignored) {

                }
            }
            System.out.println(TextFormatting.getRedText("You entered the wrong area, enter again: "));
        }
    }

    public static Long getPopulation() {
        System.out.println(TextFormatting.getGreenText("Enter the population of the city(integer number, must be greater than zero): "));
        while (true) {
            String[] string = scanner.nextLine().trim().split(" ");
            if (string.length == 1) {
                try {
                    long number = Long.parseLong(string[0]);
                    if (number > 0) return number;
                } catch (NumberFormatException ignored) {

                }
            }
            System.out.println(TextFormatting.getRedText("You entered the wrong population, enter again: "));
        }
    }

    public static Integer getMetersAboveSeaLevel() {
        System.out.println(TextFormatting.getGreenText("Enter the meters above sea level(integer number): "));
        while (true) {
            String[] string = scanner.nextLine().trim().split(" ");
            if (string.length == 1) {
                try {
                    return Integer.parseInt(string[0]);
                } catch (NumberFormatException ignored) {

                }
            }
            System.out.println(TextFormatting.getRedText("You entered the wrong sea level, enter again: "));
        }
    }

    public static Climate getClimate() {
        while (true) {
            System.out.println(TextFormatting.getGreenText("Choose the climate of the city: "));
            for (Climate climate : Climate.values()) {
                System.out.println(TextFormatting.getYellowText(String.valueOf(climate)));
            }
            String string = scanner.nextLine().toUpperCase();
            if (Climate.isPresent(string)) {
                return Climate.valueOf(string);
            }
            System.out.println(TextFormatting.getRedText("You enter the wrong climate, enter again: "));
        }
    }

    public static Government getGovernment() {
        while (true) {
            System.out.println(TextFormatting.getGreenText("Choose the government of the city: "));
            for (Government government : Government.values()) {
                System.out.println(TextFormatting.getYellowText(String.valueOf(government)));
            }
            String string = scanner.nextLine().toUpperCase();
            if (Government.isPresent(string)) {
                return Government.valueOf(string);
            }
            System.out.println(TextFormatting.getRedText("You enter the wrong government, enter again: "));
        }
    }

    public static StandardOfLiving getStandardOfLiving() {
        while (true) {
            System.out.println(TextFormatting.getGreenText("Choose the standard of living of the city: "));
            for (StandardOfLiving standardOfLiving : StandardOfLiving.values()) {
                System.out.println(TextFormatting.getYellowText(String.valueOf(standardOfLiving)));
            }
            String string = scanner.nextLine().toUpperCase();
            if (StandardOfLiving.isPresent(string)) {
                return StandardOfLiving.valueOf(string);
            }
            System.out.println(TextFormatting.getRedText("You enter the wrong standard of living, enter again"));
        }
    }

    public static Human getGovernor() {
        String name;
        System.out.println(TextFormatting.getGreenText("Enter the name of the governor: "));
        while (true) {
            String[] string = scanner.nextLine().toLowerCase().trim().split(" ");
            if (string.length == 1 & !string[0].contains(",")) {
                name = string[0];
                break;
            }
            System.out.println(TextFormatting.getRedText("You entered the wrong name, enter again(The name cannot contain commas): "));
        }
        System.out.println(TextFormatting.getGreenText("Enter the height of governor(decimal(Through a point)): "));
        double number;
        while (true) {
            String[] string = scanner.nextLine().trim().split(" ");
            if (string.length == 1) {
                try {
                    number = Double.parseDouble(string[0]);
                    if (number > 0) {
                        break;
                    }
                } catch (NumberFormatException ignored) {

                }
            }
            System.out.println(TextFormatting.getRedText("Wrong height, enter again: "));
        }
        System.out.println(TextFormatting.getGreenText("Enter the date of birthday in the format year-month-day(YYYY-MM-DD). All numbers is integer." +
                " 999 < year < 10000, 0 < month < 13, 0 < day < 32"));
        while (true) {
            String string = scanner.nextLine().trim();
            try {
                return new Human(name, number, LocalDate.parse(string));
            } catch (Exception ignored) {
                System.out.println(TextFormatting.getRedText("Wrong date, enter again(Maybe there are fewer days in your month than 31): "));
            }
        }
    }
}
