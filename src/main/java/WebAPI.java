import java.net.URL;
import java.net.HttpURLConnection;
import java.util.Scanner;

public class WebAPI {

    public static String makeHTTPRequestForLavenderTown(String pokemonName) {
        String urlString = "https://pokeapi.co/api/v2/pokemon/" + pokemonName;
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
            System.out.println("No such pokemon, sorry");
        }
        return response;
    }
}
