/**
 * Purpose of this class is to provide all application texts used by the application.
 */

public class Texts {
    public void applicationMenu()
    {
        System.out.println("\n" +
                "1) Show pokemon information\n" +
                "2) Show location information\n" +
                "0) Close the application");
    }
    public void getPokemonNameOrID()
    {
        System.out.println("Enter pokemon name or ID number:");
    }
    public void getLocationNameOrID()
    {
        System.out.println("Enter location name or ID number");
    }
    public void applicationClosing()
    {
        System.out.println("Now you know everything about Pokemons. Have a nice day!");
    }
    public void wrongMenuInput()
    {
        System.out.println("I don't understand. You can only choose between 1, 2 and 0.");
    }
    public void processingOfDataFailed()
    {
        System.out.println("Processing of downloaded data failed.");
    }
    public void findingOfRecordFailed(String recordType)
    {
        System.out.println("I haven't found " + recordType + " in the database.");
    }
    public void printPokemonInfo(long pokemonID, String pokemonName, long pokemonHeight, long pokemonWeight)
    {
        System.out.println("\nID:\t\t" + pokemonID);
        System.out.println("name:\t" + pokemonName);
        System.out.println("height:\t" + pokemonHeight);
        System.out.println("weight:\t" + pokemonWeight);
    }
    public void printLocationRegion(String regionName)
    {
        System.out.println("region of location: " + regionName);
    }
    public void printLanguagesHeader()
    {
        System.out.println("\nLocation name in different languages:");
    }
    public void printLocationName(String locationName)
    {
        System.out.println(locationName);
    }
    public void printWelcomeScreen()
    {
        System.out.println("\nWelcome to the ultimate Pokemon guide!");
    }
}
