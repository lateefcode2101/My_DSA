import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientNew {
    public static void main(String[] args) throws IOException {
        String serverAddress = "localhost";
        int serverPort = 12345;

        Socket socket = new Socket(serverAddress, serverPort);

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter writer = new PrintWriter(socket.getOutputStream(), true);

        System.out.print("Enter a message: ");
        String message = reader.readLine();
        writer.println(message);

        BufferedReader responseReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String response = responseReader.readLine();
        System.out.println("Server response: " + response);

        socket.close();
    }
}
