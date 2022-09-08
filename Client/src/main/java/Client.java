import NikandrovLab5.utility.TextFormatting;

import java.io.*;
import java.net.InetSocketAddress;
import java.nio.channels.DatagramChannel;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        DatagramChannel clientChannel = DatagramChannel.open();
//        InetSocketAddress serverAddress = new InetSocketAddress("localhost", Integer.parseInt(args[0]));
        InetSocketAddress serverAddress = null;
        try {
            int port = Integer.parseInt(System.getenv("port"));
//            int port = 7354;
            serverAddress = new InetSocketAddress("localhost", port);
        }
        catch(Exception ignored){
            System.out.println(TextFormatting.getRedText("This port is busy or you entered the wrong port"));
            System.out.println(TextFormatting.getRedText("Enter the desired port via the environment variable \"port\""));
            System.exit(1);
        }

        clientChannel.connect(serverAddress);
        ClientSender clientSender = new ClientSender(clientChannel, serverAddress);
        ClientReceiver clientReceiver = new ClientReceiver(clientChannel);
        ClientManager clientManager = new ClientManager(clientReceiver, clientSender);

        try{
            while(true){
                System.out.println(TextFormatting.getGreenText("Enter the command:"));
                String command = scanner.nextLine().strip();
                clientManager.run(command);
                if(command.equals("exit")){
                    break;
                }
            }
        }
        catch (Exception exception){
            System.out.println(TextFormatting.getYellowText(exception.getMessage()));
        }
        finally {
            System.out.println(TextFormatting.getYellowText("The program is over, I hope you enjoyed it"));
        }

        clientChannel.close();
    }
}
