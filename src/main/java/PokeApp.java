/**
 * Purpose of this class is to run the application.
 */

public class PokeApp {

    WebAPI webAPImanager;
    Keyboard commandKeyboard;
    ProcessJSON jsonProcessor;
    Texts textWriter;

    public PokeApp(){
        webAPImanager = new WebAPI();
        commandKeyboard = new Keyboard();
        jsonProcessor = new ProcessJSON();
        textWriter = new Texts();
    }

    private void appLoop()
    {
        boolean runtimeActive = true;
        textWriter.printWelcomeScreen();

        while (runtimeActive) {
            textWriter.applicationMenu();
            String userInput = commandKeyboard.getInput();
            runtimeActive = processCommand(userInput);
        }
    }

    private boolean processCommand(String inputFromUser) {
        String pokemonApiPrefix = "pokemon/";
        String locationApiPrefix = "location/";

        switch (inputFromUser) {

            case "1":
                textWriter.getPokemonNameOrID();
                String pokemonName = pokemonApiPrefix + commandKeyboard.getInput();
                String completePokemonInfo = webAPImanager.makeHTTPRequest(pokemonName);
                if (completePokemonInfo != null) {
                    jsonProcessor.processPokemonData(completePokemonInfo);
                }
                return true;

            case "2":
                textWriter.getLocationNameOrID();
                String locationName = locationApiPrefix + commandKeyboard.getInput();
                String completeLocationInfo = webAPImanager.makeHTTPRequest(locationName);
                if (completeLocationInfo != null) {
                    jsonProcessor.processLocationData(completeLocationInfo);
                }
                return true;

            case "0":
                textWriter.applicationClosing();
                return false;

            default:
                textWriter.wrongMenuInput();
                return true;
        }
    }

    public static void main(String[] args) {
        PokeApp pokeApp = new PokeApp();
        pokeApp.appLoop();
    }
}
