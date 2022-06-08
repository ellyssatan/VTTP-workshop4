package fortunecookie;

import java.io.*;
import java.net.*;
import java.util.*;

// java -cp fortunecookie.jar fc.Server 12345 cookie_file.txt
public class Server {
    public static void main(String[] args) throws IOException, FileNotFoundException, EOFException {

        int port = 0;
        String host = "localhost";

        // get args input for port#
        if (args.length > 0)
            port = Integer.parseInt(args[0]);

        System.out.println("Starting up server...");
        // 1. Serversocket
        ServerSocket server = new ServerSocket(port);
        System.out.println("Waiting for client connection");
        // 2. Socket to connect
        Socket sock = server.accept();
        System.out.println("Connected...");

        NetworkIO netIO = new NetworkIO(sock);
        Cookie cookieList = new Cookie();

        String req = "";

        // IO
        while (!req.contains("close")){
            req = netIO.read();
            netIO.write("[CLIENT REQ] " + req);
            if (req.equals("get-cookie")) {
                String output = cookieList.returnCookie();
                netIO.write("[cookie-text] " + output);
                System.out.println("[cookie-text] " + output);
            }
        }
        System.out.println("Closing server...");
        server.close();
        

    }


}
