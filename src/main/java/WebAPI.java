import java.net.URL;
import java.net.HttpURLConnection;
import java.util.Scanner;

public class WebAPI {
    private void appLoop()
    {
        System.out.println("Let's download some web data!");
        String result = makeHTTPRequestForLavenderTown();
        System.out.println(result);
    }

    public static String makeHTTPRequestForLavenderTown() {
        String urlString = "https://pokeapi.co/api/v2/location/lavender-town";
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
            e.printStackTrace();
        }
        return response;
    }


    public static void main(String[] args) {
        WebAPI app = new WebAPI();
        app.appLoop();
    }
}
