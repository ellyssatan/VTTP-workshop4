package fortunecookie;

import java.io.*;
import java.util.*;

// Examples of interaction include open and closing the cookie file and randomly return a cookie text.
public class Cookie {
    
    String srcFile = "/Users/elly/cookie_file.txt";

    public String getSrcFile(){
        return this.srcFile;
       }

    public void openCookie() throws IOException {
        Reader reader = new FileReader(this.srcFile);
        BufferedReader br = new BufferedReader(reader);

        String line = "";
        List<String> cookies = new ArrayList<>();

        while (line != null) {
            line = br.readLine();
        }
    }

    public void closeCookie() {
        
    }

    public String returnCookie() throws IOException {
        Reader reader = new FileReader(this.srcFile);
        BufferedReader br = new BufferedReader(reader);

        String line = "";
        List<String> cookies = new ArrayList<>();
        
        while (line != null) {
            line = br.readLine();
            cookies.add(line);
        }

        int rnd = new Random().nextInt(cookies.size());
        String output = cookies.get(rnd);
        return output;
    }
}
