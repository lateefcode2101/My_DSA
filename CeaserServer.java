import java.io.*;
        import java.net.*;

public class CeaserServer {
    public static void main(String[] args) {
        final int PORT = 12345;

        try (ServerSocket serverSocket = new ServerSocket(PORT)) {
            System.out.println("Server started. Waiting for a client...");

            while (true) {
                try (Socket clientSocket = serverSocket.accept();
                     BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                     PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {

                    String request = in.readLine();
                    String[] parts = request.split(":");
                    String action = parts[0];
                    String message = parts[1];
                    int shift = Integer.parseInt(parts[2]);

                    String result = "";

                    if (action.equals("encrypt")) {
                        result = encrypt(message, shift);
                    } else if (action.equals("decrypt")) {
                        result = decrypt(message, shift);
                    }

                    out.println(result);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String encrypt(String message, int shift) {
        StringBuilder encrypted = new StringBuilder();

        for (char c : message.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                encrypted.append((char) (((c - base + shift) % 26) + base));
            } else {
                encrypted.append(c);
            }
        }

        return encrypted.toString();
    }

    private static String decrypt(String encrypted, int shift) {
        StringBuilder decrypted = new StringBuilder();

        for (char c : encrypted.toCharArray()) {
            if (Character.isLetter(c)) {
                char base = Character.isLowerCase(c) ? 'a' : 'A';
                decrypted.append((char) (((c - base - shift + 26) % 26) + base));
            } else {
                decrypted.append(c);
            }
        }

        return decrypted.toString();
    }
}
