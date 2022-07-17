import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class ServerSender {
    private final DatagramChannel channel;
    private SocketAddress clientAddress;

    public ServerSender(DatagramChannel channel){
        this.channel = channel;
    }

    public void setClientAddress(SocketAddress clientAddress) {
        this.clientAddress = clientAddress;
    }

    public void send(ByteBuffer byteBuffer) throws IOException {
        channel.send(byteBuffer, clientAddress);
    }
}
