import java.io.*;
import java.nio.ByteBuffer;
import java.util.Locale;
import java.util.Scanner;

import NikandrovLab5.data.*;
import NikandrovLab5.utility.FieldReceiver;
import NikandrovLab5.utility.TextFormatting;
import NikandrovLab5.utility.Transformation;
import src.ClientMessage;


public class ClientManager {
    private final ClientReceiver clientReceiver;
    private final ClientSender clientSender;

    public ClientManager(ClientReceiver clientReceiver, ClientSender clientSender) {
        this.clientReceiver = clientReceiver;
        this.clientSender = clientSender;
    }

    public void run(String task) throws IOException, ClassNotFoundException {
        String[] command = task.toLowerCase().split(" ");
        ByteBuffer byteBuffer;
        if (command[0].equals("insert") & command.length == 2) {
            String name = FieldReceiver.getName();
            Coordinates coordinates = FieldReceiver.getCoordinates();
            double area = FieldReceiver.getArea();
            Long population = FieldReceiver.getPopulation();
            Integer metersAboveSeaLevel = FieldReceiver.getMetersAboveSeaLevel();
            Climate climate = FieldReceiver.getClimate();
            Government government = FieldReceiver.getGovernment();
            StandardOfLiving standardOfLiving = FieldReceiver.getStandardOfLiving();
            Human governor = FieldReceiver.getGovernor();
            City city = new City(name, coordinates, area, population, metersAboveSeaLevel, climate, government,
                    standardOfLiving, governor);

            //Выбираем тип сообщения, который отправим
            ClientMessage clientMessage = new ClientMessage("insert", city, command[1]);
            //Сериализация объекта
            byteBuffer = Transformation.Serialization(clientMessage);
        } else if (command[0].equals("update") & command.length == 2) {
            //Находим поле, которое нужно поменять и на что
            String field;
            Object obj = null;
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
                    case "name" -> obj = FieldReceiver.getName();
                    case "coordinates" -> obj = FieldReceiver.getCoordinates();
                    case "area" -> obj = FieldReceiver.getArea();
                    case "population" -> obj = FieldReceiver.getPopulation();
                    case "metersabvovesealevel" -> obj = FieldReceiver.getMetersAboveSeaLevel();
                    case "climate" -> obj = FieldReceiver.getClimate();
                    case "government" -> obj = FieldReceiver.getGovernment();
                    case "standardofliving" -> obj = FieldReceiver.getStandardOfLiving();
                    case "governor" -> obj = FieldReceiver.getGovernor();
                    default -> f = true;
                }
                if (f) {
                    System.out.println(TextFormatting.getRedText("There is no such field, enter again:"));
                } else {
                    field = concatenation.toString();
                    break;
                }
                System.out.println(TextFormatting.getGreenText("Enter the name of the field you want to change"));
            }
            //Создаём сообщение и сериализуем объект
            ClientMessage clientMessage = new ClientMessage(command[0], obj, Integer.parseInt(command[1]), field);
            byteBuffer = Transformation.Serialization(clientMessage);
        } else {
            //Создаём сообщение и сериализуем объект
            ClientMessage clientMessage = new ClientMessage(command);
            byteBuffer = Transformation.Serialization(clientMessage);
        }
        //Отправляем запрос на сервер
        clientSender.send(byteBuffer);
        //Получаем ответ с сервера
        clientReceiver.receive();
    }
}
