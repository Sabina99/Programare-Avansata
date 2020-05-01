import java.util.Scanner;
import java.io.*;
import java.net.*;
/**
 * ClientApplication class receives input (a command), sends it to the server and retrieves the response
 */
public class ClientApplication {
    public static void main (String[] args) throws IOException {

        String address = "127.0.0.1";
        int PORT = 1024;
        try (
                Socket socket = new Socket(address, PORT);
                PrintWriter output = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader input = new BufferedReader( new InputStreamReader(socket.getInputStream())) ) {

            Scanner keyboard = new Scanner(System.in);
            System.out.println("Give one commad: ");
            String command = keyboard.nextLine();
            output.println(command);
            String response = input.readLine ();
            System.out.println(response);

        } catch (UnknownHostException e) {
            System.err.println(e);
        }
    }
}
