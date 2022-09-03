import NikandrovLab5.commands.Save;
import NikandrovLab5.utility.Collection;
import NikandrovLab5.utility.TextFormatting;

import java.io.File;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.channels.DatagramChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.util.*;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        DatagramChannel serverChannel = DatagramChannel.open();
        serverChannel.configureBlocking(false);

        try {
            int port = Integer.parseInt(System.getenv("port"));
            serverChannel.bind(new InetSocketAddress("localhost", port));
        }
        catch(Exception ignored){
            System.out.println(TextFormatting.getRedText("This port is busy or you entered the wrong port"));
            System.out.println(TextFormatting.getRedText("Enter the desired port via the environment variable \"port\""));
            System.exit(1);
        }

        String environmentVariable = System.getenv("Lab6");
//        String environmentVariable = args[0];
        while(true){
            Scanner scanner = new Scanner(System.in);
            if(environmentVariable == null){
                System.out.println("The environment variable has not been set, enter the path to the file that can be read and written to:");
                environmentVariable = scanner.nextLine();
            }
            environmentVariable += ".csv";
            File check = new File(environmentVariable);
            try {
                check.createNewFile();
                break;
            }
            catch(Exception ignored){

            }
            environmentVariable = null;
        }
        environmentVariable = environmentVariable.toLowerCase();

        Collection collection = new Collection();
        ServerReceiver serverReceiver = new ServerReceiver(serverChannel);
        ServerSender serverSender = new ServerSender(serverChannel);
        ServerManager serverManager = new ServerManager(serverReceiver, serverSender, environmentVariable);
        System.out.println("The server has started working");

        Selector selector = Selector.open();
        serverChannel.register(selector, SelectionKey.OP_READ);
        new Thread(() -> {
            while(true) {

                try {
                    selector.select();
                } catch (IOException e) {
                    e.printStackTrace();
                }

                Iterator<SelectionKey> it = selector.selectedKeys().iterator();
                while(it.hasNext()){
                    SelectionKey key = it.next();
                    it.remove();
                    if(key.isReadable()) {
                        try {
                            serverManager.run(collection);
                        }
                        catch(Exception exception){
                            exception.printStackTrace();
                        }
                    }
                }
            }
        }).start();

        String finalEnvironmentVariable = environmentVariable;
        new Thread(() -> {
            Scanner scanner = new Scanner(System.in);
            while(true){
                if(scanner.hasNext()){
                    String command = scanner.nextLine();
                    if(command.equals("save")){
                        Save save = new Save();
                        System.out.println(TextFormatting.getYellowText(save.save(finalEnvironmentVariable, collection)));
                    }
                    else if(command.equals("exit")){
                        Save save = new Save();
                        save.save(finalEnvironmentVariable, collection);
                        System.out.println(TextFormatting.getYellowText("The program is over, I hope you enjoyed it"));
                        System.exit(0);
                    }
                    else{
                        System.out.println(TextFormatting.getRedText("Unknown command"));
                    }
                }
            }
        }).start();
    }
}
