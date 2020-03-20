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
            System.out.println("1) catch pokomon by name\n" +
                               "0) exit app");
            String userInput = commandKeyboard.getInput();
            runtimeActive = processCommand(userInput);
        }
    }

    private boolean processCommand(String inputFromUser) {
        switch (inputFromUser) {
            case "1":
                System.out.println("Enter pokemon name. I suggest pikachu");
                String pokemonName = commandKeyboard.getInput();
                String result = webAPImanager.makeHTTPRequestForLavenderTown(pokemonName);
                System.out.println(result);
                return true;
            case "0":
                System.out.println("exiting");
                return false;
            default:
                System.out.println("1 or 0, that's the only options for computers (right now)");
                return true;
        }
    }


    public static void main(String[] args) {
        PokeApp pokeApp = new PokeApp();
        pokeApp.appLoop();
    }
}
