import java.io.*;
import java.net.*;
public class Cserver
{
    public static void main(String[] args) throws Exception
    {
        ServerSocket sersock = new ServerSocket(3000);
        System.out.println("Server ready for chatting");
        Socket sock = sersock.accept( );

        BufferedReader keyRead = new BufferedReader(new
                InputStreamReader(System.in));

        OutputStream ostream = sock.getOutputStream();
        PrintWriter pwrite = new PrintWriter(ostream, true);
        InputStream istream = sock.getInputStream();
        BufferedReader receiveRead = new BufferedReader(new
                InputStreamReader(istream));
        String str, sendMessage;
        StringBuilder pt= new StringBuilder();
        while(true)
        {
            if((str = receiveRead.readLine()) != null)
            {

                for(int i = 0;i<str.length();i++)
                {
                    char letter = str.charAt(i);
                    char c;
                    if(Character.isUpperCase(letter))
                        c = (char)(((((int)letter)-2-65+26)%26)+65);

 else
                    c = (char)(((((int)letter)-2-97+26)%26)+97);
                    pt.append(c);
                }
                System.out.println("encrypted message ="+pt);
            }
            System.out.println("decrypted message= "+str);
            sendMessage = keyRead.readLine();
            pwrite.println(sendMessage);
            pwrite.flush();
        }
    }
}