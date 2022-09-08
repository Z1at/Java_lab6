import NikandrovLab5.utility.TextFormatting;
import NikandrovLab5.utility.Transformation;
import src.ServerMessage;

import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;
import java.util.Arrays;

public class ClientReceiver {
    private final DatagramChannel channel;

    public ClientReceiver(DatagramChannel channel) {
        this.channel = channel;
    }

    public void receive() {
        ByteBuffer byteBuffer = ByteBuffer.allocate(65536);
        try {
            String answer = "";
            while(true) {
                if (channel.isConnected()) {
                    channel.receive(byteBuffer);
                    ServerMessage message = (ServerMessage) Transformation.Deserialization(byteBuffer);
                    if(message.message.equals("end")){
                        break;
                    }
                    answer += message.message;
                    byteBuffer = ByteBuffer.allocate(65536);
                }
            }
            System.out.println(TextFormatting.getYellowText(answer));

        }
        catch (Exception ignored){
            System.out.println(TextFormatting.getRedText("Server is not responding, try again later" + '\n'));
        }
    }
}
