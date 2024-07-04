package Sample.Network.Server.websocket;

import Sample.Network.Server.database.ChatManager;
import Sample.Network.Server.database.Database;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

@SuppressWarnings("resource")
public class Server {
    public static void main(String[] args) throws IOException {
        Database.load();
        ChatManager.load();
        run(8080);
    }

    private static void run(int port) throws IOException {
        ServerSocket serverSocket = new ServerSocket(port);
        while (true){
            Socket socket = serverSocket.accept();
            new Connection(socket).start();
        }
    }
}
