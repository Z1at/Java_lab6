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

    public void receive() throws IOException, ClassNotFoundException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(65536);
        channel.receive(byteBuffer);
        ServerMessage message = (ServerMessage) Transformation.Deserialization(byteBuffer);
        System.out.println(TextFormatting.getYellowText(message.message));
    }
}
