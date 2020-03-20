import org.json.*;

public class PokeApp {

    WebAPI webAPImanager;
    Keyboard commandKeyboard;

    public PokeApp(){
        webAPImanager = new WebAPI();
        commandKeyboard = new Keyboard();
    }

    private void appLoop()
    {
        boolean runtimeActive = true;

        while (runtimeActive) {
            System.out.println("1) Pokemon information\n" +
                               "2) Location information\n" +
                               "0) Close the application");
            String userInput = commandKeyboard.getInput();
            runtimeActive = processCommand(userInput);
        }
    }

    private boolean processCommand(String inputFromUser) {
        switch (inputFromUser) {
            case "1":
                System.out.println("Enter pokemon name or ID:");
                String pokemonName = "pokemon/" + commandKeyboard.getInput();
                String completePokemonInfo = webAPImanager.makeHTTPRequest(pokemonName);
                if (completePokemonInfo != null) {
                    processPokemonData(completePokemonInfo);
                }
                return true;
            case "2":
                System.out.println("Enter location name or ID");
                String locationName = "location/" + commandKeyboard.getInput();
                String completeLocationInfo = webAPImanager.makeHTTPRequest(locationName);
                System.out.println(completeLocationInfo);
                return true;
            case "0":
                System.out.println("Goodbye!");
                return false;
            default:
                System.out.println("You can only choose between 1, 2 and 0.");
                return true;
        }
    }

    private void processPokemonData(String pokemonData)
    {
        final JSONObject obj = new JSONObject(pokemonData);

        int pokemonID = (Integer) obj.get("id");
        String pokemonName = (String) obj.get("name");
        int pokemonHeight = (Integer) obj.get("height");
        int pokemonWeight = (Integer) obj.get("weight");

        System.out.println("ID:\t\t" + pokemonID);
        System.out.println("name:\t" + pokemonName);
        System.out.println("height:\t" + pokemonHeight);
        System.out.println("weight:\t" + pokemonWeight);
    }

    public static void main(String[] args) {
        PokeApp pokeApp = new PokeApp();
        pokeApp.appLoop();
    }
}
