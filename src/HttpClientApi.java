import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

public class HttpClientApi {

    public static void main(String[] args) {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create("https://v6.exchangerate-api.com/v6/9e87c568202423108f616295/latest/USD"))
                .build();
    }


}
