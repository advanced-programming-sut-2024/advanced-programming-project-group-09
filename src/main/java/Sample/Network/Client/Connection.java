package Sample.Network.Client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class Connection {
    private static Connection instance;
    private Socket socket;
    private DataOutputStream outputStream;
    private DataInputStream inputStream;
    private static Listener listener;

    public static void connect(String host, int port) {
        instance = new Connection(host, port);
        System.out.println("Successfully connected to " + host + " " + port);
        startListening();
    }

    private Connection(String host, int port) {
        try {
            socket = new Socket(host, port);
            outputStream = new DataOutputStream(socket.getOutputStream());
            inputStream = new DataInputStream(socket.getInputStream());
        } catch (IOException e) {
            System.out.println("Cannot connect to the server, restart the application");
            System.exit(0);
        }
    }

    public static Connection getInstance() {
        return instance;
    }

    public void closeConnection() throws IOException {
        socket.close();
    }

    public DataInputStream getInputStream() {
        return inputStream;
    }

    public DataOutputStream getOutputStream() {
        return outputStream;
    }

    public String sendRequest(Request request) {
        try {
            outputStream.writeUTF(request.toJson());
            return Listener.consumeLastInput();
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void startListening() {
        listener = new Listener(Connection.getInstance().inputStream);
        listener.start();
    }
}
