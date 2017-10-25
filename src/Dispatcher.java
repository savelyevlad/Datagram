import java.io.IOException;

public class Dispatcher {

    private static UDPServer server = new UDPServer();

    private static UDPClient client;

    public static void main(String[] args) throws IOException {
        new Thread(server).start();
        client = new UDPClient();
        String keeek = client.send("keeek");
        System.out.println(keeek);
    }
}
