package APItest;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpRequest.BodyPublishers;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;

public class APITest {

    public static void main(String[] args) {
       
        String url = "https://bfhldevapigw.healthrx.co.in/automation-campus/create/user";

      
        String jsonBody = """
            {
                "firstName": "Prasad",
                "lastName": "Patil",
                "phoneNumber": 8408929387,
                "emailId": "prasadpatil99@gmail.com"
            }
        """;

        
        HttpClient client = HttpClient.newHttpClient();

  
        HttpRequest request = HttpRequest.newBuilder()
            .uri(URI.create(url))
            .header("Content-Type", "application/json")
            .header("roll-number", "36")
            .POST(BodyPublishers.ofString(jsonBody))
            .build();

       
        try {
            HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
            System.out.println("Status Code: " + response.statusCode());
            System.out.println("Response Body: " + response.body());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
