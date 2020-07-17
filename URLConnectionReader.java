import java.net.*;
import java.io.*;

public class URLConnectionReader {
    public static void main(String[] args) throws Exception {
        URL httpbin = new URL("http://httpbin.org/get");
        URLConnection hc = httpbin.openConnection();
        BufferedReader in = new BufferedReader(
                                new InputStreamReader(
                                hc.getInputStream()));
        String inputLine;

        while ((inputLine = in.readLine()) != null) 
            System.out.println(inputLine);
        in.close();
    }
}