package Sample;

import java.io.*;
import java.net.Socket;

public class ServerThread extends Thread {

    public String username;
    private Socket socket;
    private Server server;
    PrintWriter writer;
    InputStream input;
    OutputStream output;

    public ServerThread(Socket socket) {
        this.socket = socket;
        server = Server.getInstance();
    }

    public void run() {
        while (true) {
            try {
                input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));
                output = socket.getOutputStream();
                writer = new PrintWriter(output, true);
                String inputFromClient;
                while ((inputFromClient = reader.readLine()) != null) {
                    server.handleCommand(inputFromClient);
                    System.out.println("Server Received: " + inputFromClient);
                    writer.println(server.handleCommand(inputFromClient));
                }
            } catch (IOException ex) {
                System.out.println("Server exception: " + ex.getMessage());
                ex.printStackTrace();
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
