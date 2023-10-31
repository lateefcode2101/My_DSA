import com.sun.org.apache.xerces.internal.util.SymbolTable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerNew {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(12345);
        System.out.println("Server listening on port 12345...");

        while (true) {
            Socket clientSocket = serverSocket.accept();
            new ClientHandler(clientSocket).start();
        }
    }

    static class ClientHandler extends Thread {
        private final Socket clientSocket;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        public void run() {
            try {
                BufferedReader reader = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

                String message = reader.readLine();
                String transformedMessage = transformMessage(message);
                writer.println(transformedMessage);

                clientSocket.close();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private String transformMessage(String message) {
            StringBuilder transformed = new StringBuilder();
            for (char c : message.toCharArray()) {
                if (Character.isUpperCase(c)) {
                    transformed.append(Character.toLowerCase(c));
                } else if (Character.isLowerCase(c)) {
                    transformed.append(Character.toUpperCase(c));
                } else {
                    transformed.append(c);
                }
            }
            return transformed.toString();
        }
    }
}
