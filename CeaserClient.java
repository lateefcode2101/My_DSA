import java.io.*;
        import java.net.*;

public class CeaserClient {
    public static void main(String[] args) {
        final String SERVER_ADDRESS = "localhost";
        final int SERVER_PORT = 12345;

        try (Socket socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
             BufferedReader userInput = new BufferedReader(new InputStreamReader(System.in));
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true)) {

            System.out.print("Enter 'encrypt' or 'decrypt': ");
            String action = userInput.readLine();

            System.out.print("Enter a message: ");
            String message = userInput.readLine();

            System.out.print("Enter shift value: ");
            int shift = Integer.parseInt(userInput.readLine());

            String request = action + ":" + message + ":" + shift;
            out.println(request);

            String result = in.readLine();
            System.out.println("Result: " + result);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
