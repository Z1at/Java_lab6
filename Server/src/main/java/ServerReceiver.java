import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.DatagramChannel;

public class ServerReceiver {
    private final DatagramChannel channel;

    public ServerReceiver(DatagramChannel channel){
        this.channel = channel;
    }

    public ByteBuffer receive(ServerSender serverSender) throws IOException {
        ByteBuffer byteBuffer = ByteBuffer.allocate(65536);
        SocketAddress clientAddress = channel.receive(byteBuffer);
        serverSender.setClientAddress(clientAddress);
        return byteBuffer;
    }
}
