package Sample;

import java.io.*;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    private static Client instance;

    public static Client getInstance() {
        if (instance == null)
            instance = new Client(0);
        return instance;
    }

    public static Client createClient(int token) {
        instance = new Client(token);
        return instance;
    }

    public void setToken(int token) {
        this.token = token;
    }

    public int getToken() {
        return token;
    }

    int token;

    public Client(int token) {
        this.token = token;
        Server.clients.add(this);
    }

    public Client() {

    }

    public static int port = 2000;


    public String tryToConnectToServer(String cmd) {
        String response = "";
        while (true) {
            try (Socket socket = new Socket("127.0.0.1", port)) {
                OutputStream output = socket.getOutputStream();
                PrintWriter writer = new PrintWriter(output, true);

                InputStream input = socket.getInputStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(input));

                writer.println(cmd);

                response = reader.readLine();
                System.out.println("response: " + response);
//            handleResponseForClient(response);
            } catch (UnknownHostException ex) {
                System.out.println("Server not found: " + ex.getMessage());
            } catch (IOException ex) {
                System.out.println("I/O error: " + ex.getMessage());
            }
            return response;
        }
    }

    private void handleResponseForClient(String response) {
        // Handling response from server
    }


}