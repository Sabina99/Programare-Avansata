import java.io.IOException;
import java.net.*;


/**
 * GameServer class creates the socket, accepts the clients ans executes the clint's request in a new thread
 * the port is 1024
 */
public class GameServer {

    public static void main(String[] args) throws IOException {
        GameServer server = new GameServer();
    }


    public GameServer() throws IOException {

        ServerSocket serverSocket = null;
        int PORT = 1024;

        try {
            serverSocket = new ServerSocket(PORT);
            while (true) {
                System.out.println("Waiting for a client ...");
                Socket socket = serverSocket.accept();
                new ClientThread(socket).start();
            }
        } catch (IOException e) {
            System.err.println(e);
        } finally {
            serverSocket.close();
        }
    }
}