package ua.pp.kris;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

public class POSTrequest {
        public static void main(String[] args) throws IOException, InterruptedException { 
            var values = new HashMap<String, String>() {{
                put("text", "Drink wine, save the water!");
                put("chat_id", System.getenv("TELEGRAM_CHATID"));
            }};
    
            var objectMapper = new ObjectMapper();
            String requestBody = objectMapper
                    .writeValueAsString(values);
    
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.telegram.org/bot"+System.getenv("TELEGRAM_TOKEN")+"/sendMessage"))
                    .header("Content-Type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .build();
    
            HttpResponse<String> response = client.send(request,
                    HttpResponse.BodyHandlers.ofString());
    
            System.out.println(response.body());
    }
}