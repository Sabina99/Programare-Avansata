import java.io.*;
import java.net.Socket;

/**
 * ClientThread class receives commands from the clients, if the command is stop, the server will be stopped
 */
class ClientThread extends Thread {
    private Socket socket = null;

    public ClientThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter output = new PrintWriter(socket.getOutputStream());

            String request = input.readLine();
            if (request.equals("stop")) {
                String text = "Server stopped";
                output.println(text);
                output.flush();
                System.exit(1);
            } else if (request.equals("exit")) {
                String text = "Ending connection...";
                output.println(text);
                output.flush();
                socket.close();
            } else {
                String text = "Server received the request";
                output.println(text + " --> " + request);
                output.flush();
            }

        } catch (IOException e) {
            System.err.println(e);
        } finally {
            try {
                socket.close();
            } catch (IOException e) {
                System.err.println(e);
            }
        }
    }
}