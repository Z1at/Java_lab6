import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class ClientSender {
    private final InetSocketAddress serverAddress;
    private final DatagramChannel channel;

    public ClientSender(DatagramChannel channel, InetSocketAddress serverAddress) {
        this.serverAddress = serverAddress;
        this.channel = channel;
    }

    public void send(ByteBuffer byteBuffer) throws IOException {
        channel.send(byteBuffer, serverAddress);
    }
}
