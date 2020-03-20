import java.net.URL;
import java.net.HttpURLConnection;
import java.util.Scanner;

/**
 * Purpose of this class is to connect to the PokéAPI and download requested information.
 */

public class WebAPI {

    Texts textWriter;

    public WebAPI()
    {
        textWriter = new Texts();
    }

    public String makeHTTPRequest(String requestName) {

        String urlString = "https://pokeapi.co/api/v2/" + requestName;
        String response = null;

        try {
            URL url = new URL(urlString);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            Scanner responseScanner = new Scanner(connection.getInputStream());
            while (responseScanner.hasNext()) {
                response = responseScanner.nextLine();
            }

        } catch (Exception e) {
            textWriter.findingOfRecordFailed(requestName);
        }
        return response;
    }
}
