import java.io.IOException;
import java.net.*;

public class UDPClient {
    private DatagramSocket socket;
    private InetAddress address;

    private byte[] buf;

    public UDPClient() {
        try {
            socket = new DatagramSocket();
            address = InetAddress.getByName("127.0.0.1");
        } catch (SocketException | UnknownHostException e) {
            e.printStackTrace();
        }
    }

    public String send(String message) throws IOException {
        buf = message.getBytes();
        DatagramPacket packet = new DatagramPacket(buf, buf.length, address, 56666);
        socket.send(packet);
        packet = new DatagramPacket(buf, buf.length);
        socket.receive(packet);
        String received = new String(packet.getData(), 0, packet.getLength());
        return received;
    }

    public void close() {
        socket.close();
    }
}
