package NikandrovLab5.commands;

import NikandrovLab5.data.*;
import NikandrovLab5.utility.Collection;
import NikandrovLab5.utility.FieldReceiver;
import NikandrovLab5.utility.TextFormatting;

import java.util.Scanner;

public class UpdateId {
    public Object updateId(String field) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(TextFormatting.getGreenText("Enter the name of the field you want to change"));
        while (true) {
            String[] string = scanner.nextLine().trim().split(" ");
            StringBuilder concatenation = new StringBuilder();
            for (String s : string) {
                concatenation.append(s);
            }
            boolean f = false;
            switch (concatenation.toString()) {
                case "name": {
                    String name = FieldReceiver.getName();
                    break;
                }
                case "coordinates": {
                    Coordinates coordinates = FieldReceiver.getCoordinates();
                    break;
                }
                case "area": {
                    double area = FieldReceiver.getArea();
                    break;
                }
                case "population": {
                    Long population = FieldReceiver.getPopulation();
                    break;
                }
                case "metersabvovesealevel": {
                    Integer metersAboveSeaLevel = FieldReceiver.getMetersAboveSeaLevel();
                    break;
                }
                case "climate": {
                    Climate climate = FieldReceiver.getClimate();
                    break;
                }
                case "government": {
                    Government government = FieldReceiver.getGovernment();
                    break;
                }
                case "standardofliving": {
                    StandardOfLiving standardOfLiving = FieldReceiver.getStandardOfLiving();
                    break;
                }
                case "governor": {
                    Human governor = FieldReceiver.getGovernor();
                    break;
                }
                default:
                    f = true;
            }
            if (f) {
                System.out.println(TextFormatting.getRedText("There is no such field, enter again:"));
            }
            System.out.println(TextFormatting.getGreenText("Enter the name of the field you want to change"));
        }
    }
}
