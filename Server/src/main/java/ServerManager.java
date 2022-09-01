import NikandrovLab5.commands.*;
import NikandrovLab5.data.*;
import NikandrovLab5.utility.Collection;
import NikandrovLab5.utility.TextFormatting;
import NikandrovLab5.utility.Transformation;
import src.ClientMessage;
import src.ServerMessage;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.stream.Stream;

public class ServerManager {
    ServerSender serverSender;
    ServerReceiver serverReceiver;
    String environmentVariable;

    public ServerManager(ServerReceiver serverReceiver, ServerSender serverSender, String environmentVariable){
        this.serverReceiver = serverReceiver;
        this.serverSender = serverSender;
        this.environmentVariable = environmentVariable;
    }

    public void run(Collection collection) throws IOException, ClassNotFoundException {
        ServerMessage answer = new ServerMessage("The command was executed" + '\n');
        ByteBuffer byteBuffer = serverReceiver.receive(serverSender);
        ClientMessage clientMessage = (ClientMessage) Transformation.Deserialization(byteBuffer);
        if (clientMessage.command != null) {
            if (clientMessage.command.equals("insert")) {
                if (clientMessage.arg.contains(",")) {
                    answer.setMessage("There can be no commas in the key" + '\n');
                } else {
                    City city = (City) clientMessage.obj;
                    city.setId(collection.id++);
                    city.setCreationDate();
                    collection.collection.put(clientMessage.arg, city);
                    answer.setMessage("The object was successfully added" + '\n');
                }
            } else {
                String key = null;
                for (String now : collection.collection.keySet()) {
                    if (collection.collection.get(now).getId() == clientMessage.id) {
                        key = now;
                        break;
                    }
                }
                if (key == null) {
                    answer.setMessage("There is no item with this id in the collection" + '\n');
                } else {
                    switch (clientMessage.arg) {
                        case "name" -> collection.collection.get(key).setName((String) clientMessage.obj);
                        case "coordinates" -> collection.collection.get(key).setCoordinates((Coordinates) clientMessage.obj);
                        case "area" -> collection.collection.get(key).setArea((Double) clientMessage.obj);
                        case "population" -> collection.collection.get(key).setPopulation((Long) clientMessage.obj);
                        case "metersabvovesealevel" -> collection.collection.get(key).setMetersAboveSeaLevel((Integer) clientMessage.obj);
                        case "climate" -> collection.collection.get(key).setClimate((Climate) clientMessage.obj);
                        case "government" -> collection.collection.get(key).setGovernment((Government) clientMessage.obj);
                        case "standardofliving" -> collection.collection.get(key).setStandardOfLiving((StandardOfLiving) clientMessage.obj);
                        case "governor" -> collection.collection.get(key).setGovernor((Human) clientMessage.obj);
                    }
                    answer.setMessage("The element has been successfully replaced" + '\n');
                }
            }
        }
        else{
            Operations operations = new Operations();
            answer.setMessage("");
            operations.run(clientMessage.commands, collection, environmentVariable, answer, operations);
            if(answer.message.equals("")){
                answer.setMessage("The command was executed" + '\n');
            }
        }

        //Сортировка в обратном лексикографическом порядке с помощью Stream API и лямбда-выражений
        Stream<String> stream = collection.collection.keySet().stream().sorted((key1, key2) -> -key1.compareTo(key2));
        stream.forEach((s) -> collection.collection.put(s, collection.collection.remove(s)));

        ByteBuffer buffer = Transformation.Serialization(answer);
        serverSender.send(buffer);
    }
}
