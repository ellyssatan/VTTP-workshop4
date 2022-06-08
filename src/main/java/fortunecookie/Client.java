package fortunecookie;

import java.io.Console;
import java.io.IOException;
import java.net.Socket;


// java -cp fortunecookie.jar fc.Client locahost:12345
public class Client {
    public static void main(String[] args) throws IOException {

        String host = "";
        int port = 0;

        String input = args[0];
        String[] splitInput = input.split(":");

        host = splitInput[0];
        port = Integer.parseInt(splitInput[1]);

        //Connect to the server
        System.out.printf("Connect to server %s on port %d\n", host, port);
        Socket sock = new Socket(host, port);
        System.out.println("Connected...");

        NetworkIO netIO = new NetworkIO(sock);
        Console cons = System.console();
        String request = "";
        String response = "";

        while (!request.equals("close")) {
            request = cons.readLine("> ");
            if (request.trim().equals("close"))
                break; // break out from the closest loop
            netIO.write(request);
            //why need 2 for it to work?
            response = netIO.read();
            response = netIO.read();
            System.out.printf(">> %s\n", response);
            netIO.close();
            sock.close();
        }

        netIO.close();
        sock.close();

        System.out.println("Terminating client...");
    }
}
